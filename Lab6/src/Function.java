

/**
*The purpose of this class is to compute different function values for a real value x

*@Author Josue Ponce 

*@Date 3/19/18

*@version 1.0

*/

public class Function{

     /**

     * Holds the function's value.

     */

     private double FUNCTION_CHOICE;

     /**

     *Holds the Description of the function

     */
     private String description;
     

     /**

     * Regular constructor that initializes the choice of the function to compute

     * @param fnChoice

     */

     public Function(int fnChoice){

          FUNCTION_CHOICE=(double)fnChoice;

          setDescription();

     }

     /**

     * returns the function choice.

     * @return the function of choice. 

     */

     public int getFunctionChoice(){

          return (int)FUNCTION_CHOICE;

     }

     /**

     * Sets the description of a function. 

     */

     public void setDescription(){

          if(FUNCTION_CHOICE ==1.0) {

              description="(8x-sqrt(x))/(x^3-7x^2+15x-9)";
          }

          else if (FUNCTION_CHOICE ==2.0) {

              description="sin(x)";
          }

          else if (FUNCTION_CHOICE ==3.0) {

              description="(5/x)+35";
          }

          else if (FUNCTION_CHOICE ==4.0) {

              description="(sqrt(x^3+16)-4)/(x^2)";
          }

          else if (FUNCTION_CHOICE == 5.0) {

              description="(e^x-1)/x";
          }

     }

    

     /**

     * returns the description with function choice

     * @param fnChoice

     * @return the description of the chosen function. 

     */

     public static String getDescription(int fnChoice){

          if(fnChoice ==1) {

              return "(8x-sqrt(x))/(x^3-7x^2+15x-9)";
          }

          else if (fnChoice ==2) {
          

              return "sin(x)";
          }

          else if (fnChoice ==3) {

              return "(5/x)+35";
          }

          else if (fnChoice ==4) {

              return "(sqrt(x^3+16)-4)/(x^2)";
          }

          else if (fnChoice == 5) {

              return "(e^x-1)/x";
          }

          else

              return "";

     }

     /**

     *@return the description string

     */

     public String toString(){

          return description +" for "+FUNCTION_CHOICE;

     }

     /**

     * evaluates the function value for the parameter x

     * @param x

     * @return the calculated results based on the function choice.  

     */

     public double computeFunctionValue( double x){

          if(FUNCTION_CHOICE==1.0)

          return (8*x-Math.sqrt(x))/(Math.pow(x,3)-7*Math.pow(x,2)+15*x-9);

          else if (FUNCTION_CHOICE ==2.0)

              return Math.sin(x);

          else if (FUNCTION_CHOICE ==3.0)

              return (5/x)+35;

          else if (FUNCTION_CHOICE ==4.0)
        	  
              return (Math.sqrt(Math.pow(x,3)+16)-4)/Math.pow(x,2);

          else if (FUNCTION_CHOICE == 5.0)

              return (Math.pow(Math.E,x)-1)/x;

          else

              return 0.0;

     }

}

