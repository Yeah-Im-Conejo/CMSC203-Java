/**
 * Inherits accessible members from employee and represents employees who are designers for the company. 
 * @author Josue Ponce
 * @version 1.0
 */
public class Design extends Employee {
	
	/**Attribute p holds predefined constant for employees who are designers */
    private final static Position p = Position.DESIGN;
    
    /**Attribute payRate holds the total pay rate per hour for designers. */
    private double payRate;
    
    /** Attribute hours holds the total amount of hours for designers */
    private double hours;
    
    
    /**
     * Default class constructor.
     */ 
    public Design() {
        super();
        payRate = 0;
        hours = 0;
    }
    
    /**
     * Parameterized constructor that initiates fName, lName, empNum,payRate and hours.
     * @param fName - Represents the designer's first name.
     * @param lName - Represents the designer's last name.
     * @param empNum - Represents the designer's employee ID.
     * @param payRate - Represents the designer's payRate.
     * @param hours - Represents the designer's total amount of hours worked.
     */
    public Design(String fName, String lName, int empNum, double payRate, double hours) {
        super(fName, lName, empNum, p);
        setPayRate(payRate);
        setHours(hours);

    }
  
    /**
     * Setter method sets the hourly pay rate for designers.
     * @param payRate - Holds hourly pay rate.
     */  
    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }
    
    /**
     * Setter method sets the total amount of hours worked.
     * @param hours - Holds the total amount of hours worked.
     */  
    public void setHours(double hours) {
        this.hours = hours;
    }
    
    /**
     * Returns the pay rate for designers.
     * @return payRate - Total pay per hour.
     */ 
    public double getPayRate() {
        return payRate;
    }
    
    /**
     * Returns the total amount of hours worked.
     * @return hours - Total amount of hours worked.
     */   
    public double getHours() {
        return hours;
    }

    /**
     * Returns the calculated weekly pay for designers.
     * @return total - calculated weekly pay for designers.
     */
    public double calculateWeeklyPay() {

        if (hours <= 40)
            return getHours() * getPayRate();
        else if (hours < 0 || payRate < 0)
            return -1;
        else {
            double total;
            total = 40 * payRate;
            total += (hours - 40) * (payRate * 1.5);
            return total;
        }

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