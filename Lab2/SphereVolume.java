/**The java program prompts the user to input the diameter of a sphere and
calculate the volume of the sphere then print the volume*/


import java.util.Scanner; //Import Java scanner 

public class SphereVolume {

	public static void main(String[] args) {
		
		//Declaring variables. 
		double diam;
	 
		double neko = 2;
		
		double volume;
		
		String output; 
		
		//Displays the purpose of the program to user. 
		System.out.print("This program calculates the volume of a sphere\n");
		
		//prompts user to input the diameter of the sphere.
		System.out.print("\nPlease enter the diameter of the sphere: ");
		
		// Scanner object
		Scanner input = new Scanner(System.in);
		
		//Reads user input
		diam =Double.parseDouble(input.nextLine());
		input.close();
		
		//Stores the radius of a sphere in variable called "Radius"
		double radius = diam / neko;
		
		//Calculates Volume of sphere. 
		volume = (double) (4/(double)3)*Math.PI*Math.pow(radius, 3); 
		
		//Displays results to user
		output = "The volume of a sphere is:" + volume;
		System.out.print(output);
		
		
	}
}
