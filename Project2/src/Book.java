
/**
 * Book class is a representation of a book with title, author, number of ratings received, calculates
 * total number of ratings, average rating, recommendation comment, price and whether the book has hard cover or not.
 *
 * @author Josue Ponce
 * @version 1.0
 */


public class Book {
	



	/** Attribute title holds the title of the book. */
    private String title;
    
    /**Attribute author holds the author of the book. */
    private String author;
    
    /**Attribute numberOfRatings holds the number of ratings input by user. */
    private int numberOfRatings;
    
    /**Attribute totalRating holds the total amount of ratings that were input by the user. */
    private int totalRating;
    
    /**Attribute price holds the price of the book.*/
    private double price;
    
   /** Attribute hasHardCover holds if the book has a hard cover or not. */
    private String hasHardCover;


    /**

     * Constructor class that initiates the title and author with the value in parameters.

     * The remaining properties are assigned default values.

     * @param title - represents the title of the book.

     * @param author - represents the author of the book.

     */
    
    public Book(String title, String author) {

        double randy = (float)(Math.random() * 10);

        double result;

        result = Math.round(randy * 100.00) / 100.00;

        this.title = title;

        this.author = author;

        numberOfRatings = 0;

        totalRating = 0;

        price = result;

        this.hasHardCover = "No";


    }
    /**

     * Constructor class with values such as title, author, price and hard cover (h) indicator.

     * @param title - string - represents the title of the book.

     * @param author - string - represents the author of the book.

     * @param price - double - represents the price of the book.

     * @param h - String - indicates whether the book has hard cover or not.

     */
    
    public Book(String title, String author, double price, String h) {


        this.title = title;

        this.author = author;

        numberOfRatings = 0;

        totalRating = 0;

        this.price = price;
 
        h = "Yes";

        this.hasHardCover = h;

    }
    
/**
 * setter method to input the title of the book. 
 * @param n is a String containing the title of the book. 
 */
    
    public void setTitle(String n) {
        this.title = n;
    }
    
    /**
     * setter method to input the author of the book. 
     * @param n is a String containing the name of the book's author. 
     */
    
    public void setAuthor(String n) {
        this.author = n;
    }
    
    /**
     * setter method to set the price of the book. 
     * @param n is a double containing the price of the book. 
     */
    
    public void setPrice(double n) {
        this.price = n;
    }
    
    /**
     * setter method determining whether the book has hard cover or not. 
     * @param h is a String containing information on whether the book has hard cover or not.
     */
    public void setCover(String h) {
        this.hasHardCover = h;
    }

/**

   * method that increases the number of ratings count and also calculates the rating total.

   * @param rating - int - represents the rating given for the book by a single entity and adds the total number of ratings input into the program.

   */

    public void addRating(int rating) {

        totalRating += rating;

        numberOfRatings++;

    }

/**

   * returns 0 if the number of ratings is zero else returns the average of ratings result.

   * @return average rating value  - double.

   */
    
    public double findAvgRating() {

        double d;
        double result;
        if (numberOfRatings == 0) {
        	
            return 0;   
        }
        else
            d = ((double) totalRating) / numberOfRatings;
        result = Math.round(d * 100.0) / 100.0;

        return result;

    }
    
    /**

     * returns a string value describing whether the book is recommended or not.
     * 
     * @return string - recommendation comment.
     */

    public String bookRecommendation() {

        double avgRating = findAvgRating();

        if (avgRating >= 3 && avgRating <= 4) {

            return "Strongly Recomended";
        }
        else if (avgRating >= 2 && avgRating < 3) {

            return "Recommended";
        }
        else if (avgRating >= 1 && avgRating < 2) {

            return "Not Recommended";
        }
        else if (avgRating == 0) {

            return "No Information Is Available For Recommendation";
        }
        else

            return "UNEXPECTED DATA FOUND";

    }
    
    /**
     * returns the entire information of the book in a single string.
     *
	 *@return title, author, numberofRatings,findAvgRating(),price, hasHardCover, and bookRecommendation().
     */

    @Override
    public String toString() {

        return "The Following book has been added to the Amazon Database:                 \n" +
            "TITLE: " + title

            +
            "\nAUTHOR :" + author

            +
            "\nTOTAL # OF RATINGS: " + numberOfRatings

            +
            "\nAVERAGE RATING: " + findAvgRating()

            +
            "\nPRICE: $" + price + "\nHARDCOVER: " + hasHardCover

            +
            "\nRecommendations based on book ratings: " + bookRecommendation();

    }

}