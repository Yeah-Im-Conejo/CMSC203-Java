import java.io.*;
import java.util.Scanner;


/**
 * This utility works with 2 dimensional ragged arrays with a maximum of 10 rows and 10 columns
 * This utility also works with negative and positive numbers
 * There are no private data members in the utility class! 
 * @author Josue Ponce
 * @version 1.0
 * 
 */


public final class TwoDimRaggedArrayUtility {

    /**
	 * Reads data from the text file.
	 * @param file - the file to read from. 
	 * @return data - which is a two dimensional ragged (depending on data) array of doubles if the file is not empty, returns a null if file is empty
 
	 */
    public static double[][] readFile(File file) {

        double[][] data = null;

        try {
            Scanner in = new Scanner(file);
            int rows = 0;
            while ( in .hasNextLine()) {
                ++rows; in .nextLine();
            } in .close(); in = new Scanner(file);
            String line;
            data = new double[rows][];
            for (int i = 0; i < data.length; i++) {
                line = in .nextLine();
                String[] nums = line.split(" ");
                data[i] = new double[nums.length];
                for (int j = 0; j < data[i].length; j++) {
                    data[i][j] = Double.valueOf(nums[j]);
                }
            } in .close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * Writes the ragged array of doubles into a file.
     * @param data - two dimensional ragged array of doubles
     * @param outputFile - The output file that will be written. 
     */
    public static void writeToFile(double[][] data, File outputFile) {
        try {
            BufferedWriter writeData = new BufferedWriter(new FileWriter(outputFile));

            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    writeData.write(data[i][j] + " ");
                }
                writeData.newLine();
            }
            writeData.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the total of all the elements of the two dimensional array
     * @param data- The two dimensional arrays that will be calculated to get the total.
     * @return total - The sum of all the elements in the two dimensional array
     */
    public static double getTotal(double[][] data) {
        double total = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                total += data[i][j];
            }
        }
        return total;
    }

    /**
     * Returns the average of the elements in the two dimensional array
     * @param data - The two dimensional arrays that will be calculated to get the average. 
     * @return (total/count) - the average of the elements in the two dimensional array 
     */
    public static double getAverage(double[][] data) {

        double total = 0;
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                total += data[i][j];
                count++;
            }
        }


        return (total / count);
    }

    /**
     * Returns the total of the selected row in the two dimensional array index 0 refers to the first row
     * @param data - The two dimensional array
     * @param row - The row index to take the total of (0 refers to the first row)
     * @return rowTotal - The total of the row
     */
    public static double getRowTotal(double[][] data, int row) {

        double rowTotal = 0;
        for (int i = 0; i < data[row].length; i++) {
            rowTotal += data[row][i];
        }
        return rowTotal;
    }


    /**
     * Returns the total of the selected column in the two dimensional array index 0 refers to the first column.
     * If a row in the two dimensional array doesn't have this column index, 
     * it is not an error, it doesn't participate in this method.
     * @param data - The two dimensional array
     * @param col - the column index to take the total of (0 refers to the first column)
     * @return columnTotal - The total of the column
     */
    public static double getColumnTotal(double[][] data, int col) {

        double columnTotal = 0;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length)
                columnTotal += data[i][col];
        }
        return columnTotal;
    }

    /**
     * Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row.
     * @param data - the two dimensional array
     * @param row - the row index to find the largest element of (0 refers to the first row)
     * @return max - the largest element of the row
     */
    public static double getHighestInRow(double[][] data, int row) {

        double max = 0;
        for (int i = 0; i < data[row].length; i++) {
            if (max < data[row][i])
                max = data[row][i];
        }
        return max;
    }

    /**
     * Returns the smallest element of the selected row in the two dimensional array index 0 refers to the first row.
     * @param data - the two dimensional array
     * @param row - the row index to find the smallest element of (0 refers to the first row)
     * @return min - the smallest element of the row
     */
    public static double getLowestInRow(double[][] data, int row) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < data[row].length; i++) {

            if (min > data[row][i])
                min = data[row][i];
        }
        return min;
    }


    /**
     * Returns the largest element of the selected column in the two dimensional array index 0 refers to the first column. 
     * @param data - The two dimensional array
     * @param col -  The column index to find the largest element of (0 refers to the first column)
     * @return max - The largest element of the column
     */
    public static double getHighestInColumn(double[][] data, int col) {

        double max = 0;
        for (int i = 0; i < data.length; i++) {

            if (data[i].length > col) {
                if (data[i][col] > max) {
                    max = data[i][col];
                }
            }
        }
        return max;
    }

    /**
     * Returns the smallest element of the selected column in the two dimensional array index 0 refers to the first column.
     * @param data - The two dimensional array
     * @param col - The column index to find the smallest element of (0 refers to the first column)
     * @return min - The smallest element of the column
     */
    public static double getLowestInColumn(double[][] data, int col) {

        double min = Double.MAX_VALUE;

        for (int i = 0; i < data.length; i++) {

            if (data[i].length > col) {
                if (data[i][col] < min) {
                    min = data[i][col];
                }
            }
        }
        return min;
    }

    /**
     * Returns the largest element in the two dimensional array
     * @param data - The two dimensional array
     * @return max - The largest element in the two dimensional array
     */

    public static double getHighestInArray(double[][] data) {

        double max = data[0][0];

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] > max)
                    max = data[i][j];
            }
        }
        return max;
    }

    /**
     * Returns the smallest element in the two dimensional array
     * @param data - The two dimensional array
     * @return min - The smallest element in the two dimensional array
     */
    public static double getLowestInArray(double[][] data) {

        double min = data[0][0];

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] < min)
                    min = data[i][j];
            }
        }
        return min;
    }


}