
/**
   This program demonstrates how numeric types and operators behave in Java
   Do Task #1 before adding Task#2 where indicated.
*/

import java.util.* ; // task #2 import java scanner


public class NumericTypes {
	public static void main (String [] args) {
		
		
		//TASK #2 Create a Scanner object here 
		Scanner scan = new Scanner(System.in);
		
		//identifier declarations Task #1
		//final double NUMBER = 2 ; // number of scores
		//int score1 = 100; // first test score
		//int score2= 95; // second test score
		//final int BOILING_IN_F = 212; // boiling temperature
		//double fToC; // temperature in Celsius
		//double average; // arithmetic average
		// String output; // line of output to print out
		
		  //Task #2 declare a variable to hold the user’s temperature
		  String score1;
		  String score2;
		  double celcius;
		  //TASK #2 declare variables used here
		  double fToC;
		  double cToF;
		  String fullName;
		  String output;
		  
		  System.out.println("Enter your Full name: ");      // prompt the user to enter their full name
		  fullName = scan.nextLine();                     // read the user's full name
		  System.out.println(fullName);

		  System.out.println(); // extra blank line
		  
		//Task #2 prompt user to input score1
		  System.out.print("Enter Score 1: ");
		//Task #2 read score1 
		  score1 = scan.nextLine();
		//Task #2 prompt user to input score2
		  System.out.print("Enter Score 2: ");
		//Task #2 read score2 
		  score2 = scan.nextLine();
	      System.out.println("Score 1 : " + score1);
	      System.out.println("Score 2 : " + score2);
		
	
	    // Find an arithmetic average (Task #1)
		 //average = (score1 + score2) / NUMBER;
		//output = score1 + " and " + score2 + " have an average of " + average;	
		//System.out.println(output);
		//Convert Fahrenheit temperatures to Celsius
		//fToC = (double) (5/(double)9 * (BOILING_IN_F - 32));
		//output = BOILING_IN_F + " in Fahrenheit is " + fToC + " in Celsius.";
		//System.out.println(output);
	      
	      
		//Task #2 prompt user to input another temperature
	       System.out.print("Enter a temperature in Celcius: ");
	       celcius = scan.nextDouble();
	       scan.close();
		//Task #2 read the user’s temperature in Fahrenheit
	       cToF = celcius *(9/(double)5) + 32;
	       output = celcius + " degrees Celcius is " + cToF + " degrees Fahrenheit";
	       System.out.print(output);
		//Task #2 convert the user’s temperature to Celsius
	       fToC = (cToF-32) *(5/(double)9);
		//Task #2 print the user’s temperature in Celsius
	       System.out.print("\n" + cToF + " degrees Fahrenheit is " + fToC + " degrees Celcius" );
		   System.out.println("\nGoodbye"); // to show that the program is ended	
	}
}