import javax.swing.JOptionPane;


/**
* Amazon class tests the Book class by collecting information from the user.
* @author Josue Ponce
* version 1.0
*/

//Declaration of a class Driver

public class Amazon

{
	 /**
	   * Amazon application entry point
	   * @param args
	   *  array of command-line arguments passed to this method in order to print out all information about book. 
	   */
	
    //Declaration of a main method
    public static void main(String[] args)

    {
        //Declaration of a book b

        Book b = new Amazon().getInput();

        JOptionPane.showMessageDialog(null, b.toString(), "Message", JOptionPane.INFORMATION_MESSAGE);

    }

    /**

     * Method Book getInput() asks the user for the title of book, author of book, more book information
     * input rating for book, 

     * @return data to main where all book information will be printed out to user.

     */
      
    
    public Book getInput()

    {
        JOptionPane.showMessageDialog(null, "Welcome to Amazon Book Information Entry Application! \n" +
            "\nLet's start by entering book information... ");

        //Declaration of book data
        /** Attribute book2 asks if the user wants to input another book into the database*/
        String book2;
      //Declaration of book data
        Book data;
        

        do {

            String title = JOptionPane.showInputDialog("Enter the title of the book:");

            String author = JOptionPane.showInputDialog("Enter the book's author: ");

            String option = JOptionPane.showInputDialog("Do you have more information for the book ex.price,type of cover...(Y or N)?");
            if (option.startsWith("y"))

            {

                String price = JOptionPane.showInputDialog("Enter the book's price");

                String hasHardCover = JOptionPane.showInputDialog("Is the book hardcover? (Y or N)");

                if (hasHardCover.startsWith("Y")) {


                }
                data = new Book(title, author, Double.parseDouble(price), hasHardCover);
            } else {

                data = new Book(title, author);
            }

            int rating;

            do {
                rating = Integer.parseInt(JOptionPane.showInputDialog("Enter Rating(1-4) or 0 for no rating:"));

                if (rating == 1 || rating == 2 || rating == 3 || rating == 4) {
                    data.addRating(rating);
                    do {
 

                        rating = Integer.parseInt(JOptionPane.showInputDialog("Enter more Rating(1-4) or 0 for no more rating:"));

                        if (rating == 0) {
                        	 JOptionPane.showMessageDialog(null, data.toString(), "Message", JOptionPane.INFORMATION_MESSAGE);
                        } else if (rating >= 1 && rating <= 4) {

                            data.addRating(rating);
                        } else
                            JOptionPane.showMessageDialog(null, "Invalid rating", "Error", JOptionPane.ERROR_MESSAGE);

                    } while (rating != 0);


                } else if (rating == 0) {
                    JOptionPane.showMessageDialog(null, data.toString(), "Message", JOptionPane.INFORMATION_MESSAGE);
                } else
                    JOptionPane.showMessageDialog(null, "Invalid rating", "Error", JOptionPane.ERROR_MESSAGE);

            } while (rating != 0);


            book2 = JOptionPane.showInputDialog("Do you want to enter another book? ");


        } while (book2.equalsIgnoreCase("y"));

        return data;

    }
}