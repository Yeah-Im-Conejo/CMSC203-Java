	/**
	 
	 * Property.java is a data element class which holds the property name, the city where the property is located, the rent amount, and the owner's name.
	 
	 * @author Josue Ponce
	 
	 * @version 1.0
	 
	 */
	public class Property {

	    /** Attribute city holds the name of the city. */

	    private String city;

	    /** Attribute owner holds the name of the owner. */

	    private String owner;

	    /** Attribute propertyName holds the name of the property*/

	    private String propertyName;

	    /** Attribute rentAmount holds the total amount of rent. */

	    private double rentAmount;

	    /**

	    * Parameterized constructor class with default values such as propertyName, city, rentAmount, and owner.

	    * @param propertyName represents the name of the property. 

	    * @param city represents the name of the city.

	    * @param owner represents the name of the owner.

	    * @param rentAmount represents the total amount of rent.

	    */

	    public Property(String propertyName, String city, double rentAmount, String owner) {

	        this.propertyName = propertyName;

	        this.city = city;

	        this.owner = owner;

	        this.rentAmount = rentAmount;

	    }

	    /**

	    * copy constructor that creates a new object using the information of the object passed to it.

	    * @param p is used to create a new object and pass information to the object.

	    */

	    public Property(Property p) {

	        this.propertyName = p.propertyName;

	        this.city = p.city;

	        this.owner = p.owner;

	        this.rentAmount = p.rentAmount;

	    }

	    /**

	    * Setter method to set the name of the property.  

	    * @param propertyName sets the name of the property.

	    */

	    public void setPropertyName(String propertyName) {

	        this.propertyName = propertyName;

	    }

	    /** 

	    * @return the property's name.

	    */

	    public String getPropertyName() {

	        return propertyName;

	    }

	    /**

	    * @return the name of the city

	    */

	    public String getCity() {

	        return city;

	    }

	    /**

	    * Setter method to set the name of the city.

	    * @param city holds the name of the city.  

	    */

	    public void setCity(String city) {

	        this.city = city;

	    }

	    /**

	    * @return the name of the owner

	    */

	    public String getOwner() {

	        return owner;

	    }

	    /**

	    * Setter method sets the name of the owner.

	    * @param owner holds the name of the owner.

	    */

	    public void setOwner(String owner) {

	        this.owner = owner;

	    }

	    /**
	     
	    * @return the rentAmount

	    */

	    public double getRentAmount() {

	        return rentAmount;

	    }

	    /**

	    * Setter method sets the total amount of rent.

	    * @param rentAmount holds the total amount of rent.

	    */

	    public void setRentAmount(double rentAmount) {

	        this.rentAmount = rentAmount;

	    }

	    /**

	    * Returns all information of the property in a single string.

	    *@return propertyName, city, owner, and rentAmount.

	    */

	    @Override

	    public String toString() {

	        return "Property name : " + getPropertyName() + "\n Located in " + getCity() + "\n Belonging to : " + getOwner()

	            +
	            "\n Rent Amount : " + getRentAmount();

	    }

	}