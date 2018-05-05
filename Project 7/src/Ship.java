/**
 * Ship class is an object that holds other ship objects(subclasses).
 * Additionally, the class implements comparable <ship> which compares the names of all ships in the array list,
 * so that they can be sorted in alphabetical order.
 * @author Josue Ponce
 * @version 1.0
 */
public abstract class Ship implements Comparable<Ship>{
	
	/** Attribute name holds the name of the ships. */
    private String name;
    
    /** Attribute year holds the year the ships were built. */
    private String year;
    
    /** Attribute type holds the name ship types. */
    private ShipType type;
    
    /**
     * Default constructor.
     */
    public Ship() {
        this.name = "";
        this.year = "";
        this.type = null;
    }
    
    /**
     * Parameterized constructor that initiates name, year, and type.
     * @param name - Represents the name of ships.
     * @param year - Represents the year the ships were built.
     * @param type - Represents the type of ship.
     */
    public Ship(String name, String year, ShipType type) {
        this.name = name;
        this.year = year;
        this.type = type;
    }
    
    /**
     * Setter method sets the ship type.
     * @param type - Holds the type of ship.
     */
    public void setType(ShipType type) {
        this.type = type;
    }
    
    /**
     * Setter method sets the name of the ship.
     * @param name - Holds the name of the ship.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Setter method holds the year the ship was build.
     * @param year - Holds the year the ship was build.
     */
    public void setYear(String year) {
        this.year = year;
    }
    
    /**
     * Returns the name of the ship.
     * @return name - The name of the ship.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the year the ship was built.
     * @return year - Holds the year the ship was built.
     */
    public String getYear() {
        return year;
    }
    
    /**
     * Returns the type of ship.
     * @return type - Holds the ship type.
     */
    public ShipType getType() {
        return type;
    }
    
    /**
     * Writes information about the ships to a CSV file which includes the name of ships, type of ship and build year.
     * @return The name of ships, type of ships, and the year the ships were built to a CSV file. 
     */
    public String writeData() {
        return name + "," + type + "," + year;
    }
    
    /**
     * Compares the names of ships and sorts them in alphabetical order.
     * @param o - Holds the ships from array list to be compared.
     * @return the names of ships that been compared and sorted in alphabetical order.
     */
    public int compareTo(Ship o) {
    	  
    	   return getName().compareTo(o.getName());
    	}
    
    /**
     * Returns information about all the ships in the Array including name, build year and ship type.
     * @return The name of the ships, the year the ships were built, and the type of ship.
     */
    @Override
    public String toString() {
        return getName() + " built in " + getYear() + ", " + getType() + " class";
    }


}
