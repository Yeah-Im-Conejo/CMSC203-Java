import java.util.Scanner;

//Public class movie driver

public class MovieDriver {
   /**@param String[]*/
   public static void main(String[]args){
      
       //Creating a type of Scanner object
       Scanner input=new Scanner(System.in);
      
       //Movie object
       Movie data = new Movie();
       
       //Declaring string variables. 
       String movieName;
       String rating;
       int tickets;
       String scan;
       do{
       //prompt the user to enter the title of movie. 
       System.out.println("Enter the name of a movie:");
       movieName = input.nextLine();
      
       //set the title in the movie object. 
       data.setTitle(movieName);	
       
       //Prompt the user to enter the movie’s rating
       System.out.println("Enter the rating of the movie ");
       
       //Set the rating in the movie object
       rating = input.nextLine();
       
       //Set the title
       data.setRating(rating);
       
       //Prompt the user to enter the number of tickets sold at a (unnamed) theater
       System.out.println("Enter the number of tickets sold for the movie: ");
       
       //Set the number of tickets
       tickets = input.nextInt();
       
       //Set the number of tickets sold in the movie object
       data.setSoldTickets(tickets);
        
       //use toString method in Movie.java
       //Print out the information using the movie’s toString method
       System.out.println(data.toString());
       
       // Prompts user if they want to enter another movie. 
       System.out.println("Do you want to enter another movie? (y or n)");
       scan=input.next();
       input.nextLine();
      
       }while(scan.equalsIgnoreCase("y"));
       input.close();
       
       // Display goodbye message to user. 
       System.out.println("Goodbye!");
   }
}