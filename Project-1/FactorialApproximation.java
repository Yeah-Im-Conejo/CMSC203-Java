/* This program calculates the Factorial Approximation of a number. Developed by Josue Ponce */

import java.util.Scanner; // Import scanner


public class FactorialApproximation {
	
	public static void main(String[] args)
	 {
		
		double results; // Declaring double precision variable result
		
		double difference;  //Declaring double precision variable difference

	    final double PI = 3.141592653589793; // Double constant variable for PI

	    final double ENUM = 2.718281828459045; // Double constant variable for Euler's number. 
		
		System.out.print("         Factorial Approximation \n"); // Display program header. 
		
		//Prompt user to enter number greater than 0 and less than 100
		System.out.print("\nPlease enter a whole number greater than 0 and less than 100: " ); 
		
		Scanner input = new Scanner(System.in); // scanner input
		
		int n = input.nextInt(); // obtain's user input. 

		input.close();
		
		// If user input is greater than 0 and less than 100 then calculated results. 
		if ( n > 0 && n < 100 ) {
			
			results = Math.sqrt(2*PI)*Math.pow(ENUM,-n)*Math.pow(n, n + 0.5); 
			
			
			System.out.print("\nThe approximation of " + n + "! is " + results + "\n"); //Display Results to user
			
			// If user input equals 7 subtract 5040 from the calculated results.   
			if (n == 7) {
				
				results = Math.sqrt(2*PI)*Math.pow(ENUM,-n)*Math.pow(n, n + 0.5);
			
				difference = 5040- results; 	// Subtracts 5040 from calculated results.
				
				//Display difference between 7 and the approximation to user.
				System.out.print("The difference between 7! and the approximation: " + difference + "\n"); 
			
		}
		// If user input equals 5 subtract 120 from the calculated results. 
		else if (n == 5){
			
			results = Math.sqrt(2*PI)*Math.pow(ENUM,-n)*Math.pow(n, n + 0.5);
			
			difference = 120 - results; // Subtracts 120 from calculated results. 
			
			//Display difference between 7 and the approximation to user.
			System.out.print("The difference between 5! and the approximation: " + difference + "\n");
	
		}
		
	}   // User input is not greater than 0 and less than 100 display error messages. 
		else {
			
			System.out.print("The number you entered is out of the required range.");
			
			System.out.print("\nPlease restart the program.\n");

		}
		// Programer's name. 
			System.out.print("\nProgrammer: Josue Ponce\n");
			
	 }
}
