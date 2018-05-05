//Imports 
import java.util.ArrayList;

import java.text.NumberFormat;

import java.util.*;

/**
 * Company class implements CompanyInterface. Contains arraylist which holds references to 
 * Employee data element class objects to be inherited from employee.
 * @author Josue Ponce
 * @version 1.0
 *
 */
public class Company implements CompanyInterface {


	/** Attribute companyName holds the name of the company.*/
    private String companyName;
    
    /** Attribute employees holds objects from the data element class.*/
    private ArrayList < Employee > employees;
    
    /** Attribute numberOfCompanies holds the total number of companies set to 0.*/
    private static int numberOfCompanies = 0;
    
    /** Attribute numDesign holds the total number of designers.*/
    private int numDesign;
    
    /** Attribute numEmployees holds the total number of employees.*/
    private int numEmployees;
    
    /** Attribute numManufacturing holds the total number of employees working in manufacturing.*/
    private int numManufacturing;
    
    /** Attribute numSales holds the total number of employees who work in sales.*/
    private int numSales;
    
    /** Attribute numManager holds the total number of managers who manage the company.*/
    private int numManager;
    
    /** Attribute fmt holds proper currency formatting representing U.S dollars.*/
    private NumberFormat fmt;
    
    /**
     * Parameterized class constructor that initiates arg. 
     * @param arg - Represents the company name.
     */
    public Company(String arg )
    {
    	// Instantiate fields
    	
        this.companyName = arg;

        this.employees = new ArrayList < Employee > ();

        this.numSales = 0;

        this.numEmployees = 0;

        this.numDesign = 0;

        this.numManufacturing = 0;

        this.numManager = 0;
        
        updateCompanyNumber();

        this.fmt = NumberFormat.getCurrencyInstance(Locale.US);

    }
    
    /**
	 * Adds an employee to the ArrayList.
	 * @param type - Employee's position: Manager, Design, Sales, Manufacturing
	 * @param fname - Employee's first name.
	 * @param lname - Employee's last name.
	 * @param firstParam - Manager-salary, Design-hourly rate, Sales-weekly sales, Manufacturing-rate per piece
	 * @param secondParam - Manager-not needed (0), Design-number of hours, Sales-not needed (0), Manufacturing-number of pieces
	 * @param empNum - Employee's ID number
	 * @return null if successful add.  Returns a string that describes the reason 
	 * for not adding the employee. 
	 */
    
    public String addEmployee(String fname, String lname, String type, double firstParam, int secondParam, int empNum)
    {

        if (numSales == 1 && type.equals("Sales")) {

            return "There is already a sales person\nEmployee not added";

        } else if (numDesign == 2 && type == "Design")

            return "There are already two design persons\nEmployee not added";

        else if (numManufacturing == 4 && type.equals("Manufacturing"))

            return "There are already four manufacturing persons\nEmployee not added";

        else if (numManager == 1 && type.equals("Manager"))

            return "There is already a manager\nEmployee not added";

        else if (this.getNumEmployees() == 8)

            return "There are already 8 employees\nEmployee not added";

        else if (type.equals("Sales") == false && type.equals("Design") == false && type.equals("Manufacturing") == false

            &&
            type.equals("Manager") == false)

            return "That position does not exist";

        else {

            if (type.equals("Sales")) {

                Sales s = new Sales(fname, lname, empNum, firstParam);

                employees.add(s);

                numSales++;

            } else if (type.equals("Design")) {

                Design d = new Design(fname, lname, empNum, firstParam, secondParam);

                employees.add(d);

                numDesign++;

            } else if (type.equals("Manufacturing")) {

                Manufacturing m = new Manufacturing(fname, lname, secondParam, firstParam, empNum);

                employees.add(m);

                numManufacturing++;

            } else {

                Manager m = new Manager(fname, lname, empNum, firstParam);

                employees.add(m);

                numManager++;

            }

            return null;
        }
    }
    
    
    /**
     *  Returns the total number of companies.
     * @return numberOfCompanies - Returns the total number of companies.
     */
    public static int getNumCompanies()
    {

        return numberOfCompanies;
    }
    
    /**
     * Updates the Company number and increments the number of companies by 1.
     */
    private static void updateCompanyNumber()
    {

        numberOfCompanies += 1;
    }
    
    /**
     * Resets the company count.
     */
    public static void resetCompanyCount()
    {

        numberOfCompanies = 0;
    }

    /**
     * Returns the number of employees
     * @return numEmployees - The total number of employee's working at the company.
     */
    public int getNumEmployees()
    {

        return numEmployees;
    }
    
    /**
     * Returns the total number of managers.
     * @return numManager - The number of managers
     */
    public int getNumManager() {

        return numManager;
    }
    
    /**
     * Returns the total number of designers.
     * @return numDesign - Total number of designers.
     */
    public int getNumDesign() {

        return numDesign;

    }
    
    /**
     * Returns the total number of sales employees.
     * @return numSales - Total number of sales employees.
     */
    public int getNumSales() {

        return numSales;

    }
    
	/**
	 * Returns the number of piece workers in the ArrayList
	 * @return numManufacturing - Total number of piece workers. 
	 */
    public int getNumManufacturing() {

        return numManufacturing;

    }
    
	
	/**
	 * Calculate the total weekly pay for all employees in the ArrayList
	 * @return total - The total weekly pay for all employees
	 */
    public double calculateTotalWeeklyPay() {

        double total = 0;

        for (Employee e: employees) {

            total += e.calculateWeeklyPay();
            

            fmt.format(total);

        }
        return total;
    }
    
    
    /**
	 * Creates a string representation of the object which represents first name, last name, and the employee's position.
	 * @return printEmp - String that represents all the objects in the ArrayList from employee.
	 */
    public String printCompany()

    {

        String printEmp = companyName;

        printEmp = this.companyName + "\n";

        for (Employee e: employees) {

        	printEmp += e.getFirstName() + " " + e.getLastName() + " Position: " + e.getPos() + "\n";

        }

        return printEmp;
    }
    

	/**
	 * Generates a weekly report of employee weekly pay
	 * @return report - String that contains the Weekly Report
	 */
    public String generateWeeklyReport() {

        String report = "WEEKLY PAY REPORT FOR " + companyName +

            " COMPANY\n\nEMPLOYEE		       WEEKLY PAY\n" +

            toString() + "\nTotal payroll: " + fmt.format(calculateTotalWeeklyPay()) +

            "\nTotal number of managers paid: " + String.valueOf(numManager) +

            "\nTotal number of Design employees paid: " + String.valueOf(numDesign) +

            "\nTotal number of Sales employees paid: " + String.valueOf(numSales) +

            "\nTotal number of Manufacturing employees paid: "

            +
            String.valueOf(numManufacturing);

        return report;

    }
    
    /**
	 * Remove a specified employee from the ArrayList.
	 * @param firstName First name of the employee to remove from the payroll
	 * @param lastName Last name of the employee to remove from the payroll
	 * @return true if the employee was successfully removed, false otherwise
	 */
    public boolean removeEmployee(String firstName, String lastName) {

        // Iterate over employee list

        for (Employee e: employees) {

            // IF first name and last name matches, remove employee

            // return true

            if (firstName.equals(e.getFirstName()) && lastName.equals(e.getLastName())) {

                employees.remove(e);

                return true;

            }
        }
        return false;
    }

    
	/**
	 * Creates a string representation of the object
	 * @return s - String that represents all the objects in the ArrayList from employee.
	 */
    @Override
    public String toString()
    {

        String s = "";

        for (Employee e: employees) {

            s += e.toString() + "\n";

        }
        return s;
    }
}