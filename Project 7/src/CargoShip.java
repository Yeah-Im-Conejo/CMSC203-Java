/**
 * Inherits accessible members from Ship and represents CargoShips. 
 * @author Josue Ponce
 * @version 1.0
 *
 */
public class CargoShip extends Ship {
	
	/** Attribute tons holds the weight capacity of the cargo ship in tons. */
    private int tons;
    
    /**Attribute ST holds the name ship types. */
    private final static ShipType ST = ShipType.CARGO;
    
    /**
     * Default Class Constructor
     */
    public CargoShip() {
        super();
        setTons(0);
    }
    
    /**
     * Parameterized constructor that initiates name, year, type, and tons.
     * @param name - Represents the name of the cargo ship.
     * @param year - Represents the year the cargo ship was built.
     * @param type - Represents the type of ship.
     * @param tons - Represents the total weight capacity of the cargo ship.
     */
    public CargoShip(String name, String year, String type, int tons) {
        super(name, year, ST);
        setTons(tons);
    }
    
    /**
     * Setter method sets the total amount of tons the ship can carry.
     * @param tons - Holds the total amount of weight in tons the cargo ship can carry.
     */
    public void setTons(int tons) {
        this.tons = tons;
    }
    
    /**
     * Returns the total weight capacity in tons. 
     * @return tons- total weight capacity in tons. 
     */
    public int getTons() {
        return tons;
    }
    
    /**
     * Returns super.toString() with the total amount of weight capacity of the cargo ship in tons.
     * @return - super.toString() along with the total amount of weight capacity of the cargo ship in tons.
     */
    @Override
    public String toString() {
        return super.toString() + " with " + tons + " tons capacity";
    }
    
    /**
     * Writes information about the cargo ships to a csv file.
     * @return super.writeData() with the total amount of weight capacity in tons to a csv file.
     */
    @Override
    public String writeData() {
        return super.writeData() + "," + tons;
    }
}