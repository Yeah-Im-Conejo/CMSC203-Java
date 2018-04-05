	 /**
	 
	 *ManagementCompany holds a list of properties in an array structure.
	 
	 * @author Josue Ponce
	 
	 * @version 1.0
	 
	 */

	public class ManagementCompany {

	    /** Attribute holds the total number of max properties. */
	    private final int MAX_PROPERTY = 5;

	    /** Attribute holds the management fee. */
	    private double mgmFee;

	    /** Attribute holds the name of the company */
	    private String companyName;

	    /** Attribute holds the total number of max properties allowed in the array. */
	    private Property[] properties = new Property[MAX_PROPERTY];


	    /** Attribute holds the taxID */
	    private String taxID;


	    /** Attribute creates a index variable to keep track of current index of properties array */
	    private int index = 0;

	    /**

	    * Constructor class that initiates companyName, taxID, and mgmFee.

	    * @param companyName represents the name of the company.

	    * @param taxID represents the taxID.

	    * @param mgmFee represents the management fee.

	    */

	    public ManagementCompany(String companyName, String taxID, double mgmFee) {
	    	
	        this.companyName = companyName;

	        this.taxID = taxID;

	        this.mgmFee = mgmFee;

	    }

	    /**

	    * Adds the property object to the "properties" array. It returns either -1 if the array is full or the index in the array where the property was added successfully.

	    * @param p is a property object.

	    * @return -1 if the array is full otherwise return index-1 of the array where the property was added.

	    */

	    public int addProperty(Property p) {

	        //Check if index >= MAX_PROPERTY then the array is full, return -1

	        if (index >= MAX_PROPERTY) {

	            return -1;

	        }

	        else {

	            //store object to current index.

	            properties[index] = p;

	            //Increment index

	            index++;

	            //Return index-1 to return index where property was added.

	            return index - 1;

	        }

	    }

	    /**

	    * @return totalRent amount due.

	    */

	    public double totalRent() {

	    	 double totalRent = 0;

	        //Iterate through all the objects present in properties array and add all rents

	        for (int i = 0; i < index; i++) {

	            totalRent += properties[i].getRentAmount();

	        }

	        return totalRent;

	    }

	    /**

	    * Displays information of the property at index i

	    * @param i is the index of the property within the array "p"

	    * @return output which is the information of the property at index i.

	    */

	    public String displayPropertyAtIndex(int i) {

	        //Create a string output and add values of properties array at given index

	        String output = properties[i].toString();

	        return output;

	    }

	    /**

	    * @return the max number of properties.

	    */

	    public int getMAX_PROPERTY() {

	        return MAX_PROPERTY;

	    }
	    
	    /**

	    * Method returns the index of the property with the maximum amount of rent.

	    * @return maxPropertyRentIndex which is the index of the property with the maximum rent amount.

	    */

	    public int maxPropertyRentIndex() {

	        //Create variable maxRent to represent maximum rent

	        double maxRent = 0;

	        //Create variable maxRentIndex to represent maximum rent index

	        int maxRentIndex = 0;

	        //Iterate through all the objects present in properties array

	        for (int i = 0; i < index; i++) {

	            //If maxRent is < current property, change max rent to current's property rent and maxRentIndex to current index.

	            if (maxRent < properties[i].getRentAmount()) {

	                maxRent = properties[i].getRentAmount();

	                maxRentIndex = i;

	            }

	        }

	        //return maxRentIndex;

	        return maxRentIndex;

	    }

	    /**

	    * Calculates and returns the management fee due.

	    * @return fee which is the calculated total management fee.

	    */

	    public double calculateTotalFee()

	    {

	        double fee = 0;

	        for (int i = 0; i < index; ++i)

	        {

	            fee += mgmFee * properties[i].getRentAmount() / 100;

	        }

	        return fee;

	    }

	    /**

	    * Displays all the information of all properties in the output variable and returns the calculated management fee.

	    * @return calculateTotalFee() and output.

	    */

	    public String toString() {

	        String output = "";

	        //Iterate through all the objects present in properties array and add information of all property in output variable.

	        for (int i = 0; i < index; i++) {

	            output += properties[i].toString() + "\n\n";

	        }

	        return "List of the properties for, " + companyName +

	            ", taxID: " + taxID +

	            "\n___________________________________________________\n" +

	            output + "___________________________________________________\ntotal management Fee: " + calculateTotalFee();

	    }

	}