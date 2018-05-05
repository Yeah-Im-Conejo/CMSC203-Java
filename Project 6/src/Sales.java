/**
 * Inherits accessible members from employee and represents employees who work in sales for the company.
 * @author Josue Ponce
 * @version 1.0
 */

public class Sales extends Employee{
	
   /**Attribute BONUS holds the bonus earned for each sale the employee makes. */
   private final static int BONUS = 250;
   
   /**Attribute P holds the predefined constant for employees in sales. */
   private final static Position p = Position.SALES;
   
   /** Attribute weeklySales holds the amount of sales for the week. */
   private double weeklySales;
   
   /**
    * Default class constructor. 
    */
   public Sales()
   {
       super();
       weeklySales = 0;
   }
   
   /**
    * Parameterized constructor that initiates fName, lName, empNum,and weeklySales.
    * @param fName - Represents the sales employee's first name.
    * @param lName - Represents the sales employee's last name.
    * @param empNum - Represents the sales employee's ID number.
    * @param weeklySales - Represents the total amount of weekly sales.
    */
   public Sales(String fName, String lName, int empNum, double weeklySales)
   {
       super(fName, lName, empNum, p);
       this.weeklySales = weeklySales;  
   }
   
   /**
    * Setter method sets the total amount of weekly sales made by employees.
    * @param weeklySales - Holds the total amount of sales the employees have made for the week.
    */
   public void setWeeklySales(double weeklySales)
   {
       this.weeklySales = weeklySales;
   }
   
   /**
    *  Returns weekly Sales.
    * @return weeklySales - Weekly sales made by employees.
    */
   public double getWeeklySales()
   {
       return weeklySales;
   }
   
   /**
    * Calculates the weekly pay for sales employees based on the total amount of weekly sales made
    * multiplied by 0.057 plus the bonus per sale.
    * @return weeklySales - Calculated weeklySales multiplied by 0.057 plus the bonus.
    */
   public double calculateWeeklyPay() {
       return (weeklySales * .057) + BONUS;
   }
   
   /**
    * Super.toString() calls Object class method toSting() and also calculates weekly pay in proper currency format for this sub class. 
    * @return information from the designer's subclass and calculated weekly pay in proper format.
    */
   @Override
	public String toString(){
		return super.toString()+"		                $"+String.format("%,.2f", calculateWeeklyPay());
	}

}
	
