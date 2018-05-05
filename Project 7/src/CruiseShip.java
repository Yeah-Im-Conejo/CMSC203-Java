/**
 * Inherits accessible members from Ship and represents cruise ships. 
 * @author Josue Ponce
 * @version 1.0
 *
 */
public class CruiseShip extends Ship {
	
	/** Attribute passenger holds the total number of passengers for cruise ships. */
    private int passenger;
    
    /**Attribute ST holds the name ship types. */
    private final static ShipType ST = ShipType.CRUISE;
    
    /**
     * Default class constructor
     */
    public CruiseShip() {
        super();
        setPassenger(0);
    }
    
    /**
     * Parameterized constructor the initiates name, year, type, and passenger.
     * @param name - Represents the name of the cruise ship.
     * @param year - Represents the year the cruise ship was built.
     * @param type - Represents the type of ship.
     * @param passenger - Represents the passenger capacity of the cruise ship.
     */
    public CruiseShip(String name, String year, String type, int passenger) {
        super(name, year, ST);
        setPassenger(passenger);
    }
    
    /**
     * Setter method sets the total number of passenger capacity of cruise ships.
     * @param passenger - Holds total number of passenger capacity of the cruise ship.
     */
    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }
    
    /**
     * Returns total number of passengers.
     * @return passenger - Holds total number of passengers.
     */
    public int getPassenger() {
        return passenger;
    }
    
    /**
     * Returns super.toString() with the total amount of passengers the cruise ship can hold.
     * @return super.toString() with the total amount of passengers the cruise ship can hold.
     */
    public String toString() {
        return super.toString() + " carrying " + getPassenger() + " passengers";
    }
    
    /**
     * Writes information about the cruise ship to CSV file.
     * @return super.writeData() along with the number of passengers the cruise ship can hold to a CSV file.
     */
    @Override
    public String writeData() {
        return super.writeData() + "," + passenger;
    }
}