/**
 * This program demonstrates use of inheritance and polymorphism. 
 * Employee is an abstract based class defined with 
 *  4 subclasses which are, manager, sales, design, and manufacturing. 
 * @author Josue Ponce
 * @version 1.0
 */
	public abstract class Employee
	{
		
	/**Attribute fName holds employee's first name */
    private String fName;
    
    /**Attribute lName holds employee's last name */ 
    private String lName;
    
    /**Attribute empNum holds employee's ID number */ 
    private int empNum;
    
    /**Attribute p holds predefined constant based on the employee's position. */ 
    private Position p;
    
    /**
     * Default Class constructor.
     */
    public Employee() {

        this.fName = "";

        this.lName = "";

        this.empNum = -1;

        this.p = null;

    }
    
    /**
     * Parameterized Class constructor that initiates fName, lName, empNum, and p
     * @param fName - Holds the employee's first name.
     * @param lName - Holds the employee's last name.
     * @param empNum - Holds the employee's ID number.
     * @param p - Holds the employee's current position at the company.
     */
    public Employee(String fName, String lName, int empNum, Position p)
    {

        this.fName = fName;

        this.lName = lName;

        this.empNum = empNum;

        this.p = p;

    }
    
    /**
     * Setter method sets the employee's current position.
     * @param pos - Holds the employee's current position.
     */
    public void setPos(Position pos) {

        this.p = pos;
    }
    
    /**
     * Setter method sets the employee's first name.
     * @param fName - Holds the employee's first name.
     */
    public void setFirstName(String fName) {

        this.fName = fName;
    }
    
    /**
     * Setter method sets the employee's ID number.
     * @param empNum - Holds the employee's ID number.
     */ 
    public void setEmpNum(int empNum) {

        this.empNum = empNum;
    }
    
    /**
     * Setter method sets the employee's last name.
     * @param lName - Holds the employee's last name.
     */
    public void setLastName(String lName) {

        this.lName = lName;

    }
    
    /**
     * Returns the employee's current position.
     * @return p - current employee's position.
     */ 
    public Position getPos() {

        return p;
    }
    
    /**
     * Returns the employee's first name.
     * @return fName - employee's first name
     */
    public String getFirstName() {

        return fName;
    }


    /**
     * Returns the employee's last name.
     * @return lName - The employee's last name.
     */
    public String getLastName() {

        return lName;
    }

    /**
     * Returns the employee's ID number.
     * @return empNum - The employee's ID number.
     */
    public int getEmpNum() {

        return empNum;
    }
 
    /**
     *  Derived class that defines the calculated weekly pay for
     *  each position an employee is working in for the company. 
     * @return derived calculated weekly pay from all 4 sub classes.
     */
    public abstract double calculateWeeklyPay();

    
    /**
     * Returns the employee's ID number if calculateWeeklyPay != null.
     * @return empNum - Otherwise return null.
     */
    @Override
    public String toString() {

        // String.format will print pay to 2 decimal values

        if (String.valueOf(calculateWeeklyPay()) != null) {
        	
            return "   "+ String.valueOf(empNum);

        }

        return null;
    }
}