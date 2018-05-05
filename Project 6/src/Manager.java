/**
 * Inherits accessible members from employee and represents the managers for the company. 
 * @author Josue Ponce
 * @version 1.0
 *
 */

public class Manager extends Employee {
	
	
	/**Attribute P holds the predefined constant for employees who are managers. */
    private final static Position p = Position.MANAGER;
    
    /**Attribute salary holds the salary earned by managers. */
    private double salary;
    
    /**
     * Default class constructor. 
     */
    public Manager() {
        super();
        salary = 0;  
    }
    
    /**
     * Parameterized constructor that initiates fName, lName, empNum, and salary.
     * @param fName - Represents the manager's first name.
     * @param lName - Represents the manager's last name.
     * @param empNum - Represents the manager's employee ID
     * @param salary - Represents the manager's salary.
     */
    public Manager(String fName, String lName, int empNum, double salary) {
        super(fName, lName, empNum, p);
        this.salary = salary;
      
    }
    
    /**
     * Returns the calculated weekly pay for managers.
     * @return salary - Total weekly salary for managers.
     */  
    public double calculateWeeklyPay() {
    	
        return salary;
    }
    
    /**
     * 	Gets the employee's salary.
     * @return Salary - Returns the manager's salary.
     */
    public double getSalary() {
        return salary;
    }
    
    /**
     * Setter method to set the manager's salary.
     * @param salary - Holds the salary for managers.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    /**
     *Super.toString() calls Object class method toSting() and also calculates weekly pay in proper currency format for this sub class. 
     *@return Information from the manager's subclass and calculated weekly pay in proper format.
     */
    @Override
	public String toString(){
		
		return super.toString()+"		                $"+String.format("%,.2f", calculateWeeklyPay());
	}
}