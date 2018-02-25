import java.util.Scanner;
 
/*
* This program contains some syntax and logic errors, and depending on the input, contains a run-time error.
* However, I have fixed all those errors!! lab done by @Yeah_Im_Conejo
*/

public class Function2 {
	public static void main(String[] args) {
		//this line creates an object called input from the Java library class Scanner.
		//System.in specifies the keyboard as the input stream Scanner will use
		Scanner input = new Scanner(System.in);
 
		//initialize the program's variables
		double result;
		double x=-999.999;
 
		//print out prompts to tell the user what to do
		System.out.println("\nProgram to evaluate a function...\n");
		System.out.println("Compute the value of the function f(x)=(2*x^3 - 5*x^2 - 12*x + 4)/x");
		System.out.println("Enter the value of x for which f(x) will be evaluated (numeric values):");
 
		//read what the user types and set x to that value
		x = input.nextDouble();
 
		//use built-in Java library method Math.pow and standard operators to compute the result
		result = (2*Math.pow(x,3)-5*Math.pow(x,2)-12*x+4)/x;
 
		//print out the result to the console
		System.out.println("f("+x+")="+result);	
		System.out.println("\nGoodbye");
	}
}
