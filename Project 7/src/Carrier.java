/**
 * Inherits accessible members from WarShip and represents carriers.
 * @author Josue Ponce
 * @version 1.0
 *
 */
public class Carrier extends WarShip {
	
	/** Attribute aircraft holds the total number of aircrafts on the ship.*/
    private int aircraft;
    
    /**
     * Default class constructor. 
     */
    public Carrier() {
        super();
        setAircraft(0);
    }
    
    /**
     * Parameterized constructor that initiates name, year, type, and aircraft.
     * @param name - Represents the name of the carrier.
     * @param year - Represents the year the carrier was built.
     * @param type - Represents the type of ship.
     * @param aircraft - Represents the total number of aircrafts on-board the carrier.
     */
    public Carrier(String name, String year, String type, int aircraft){
        super(name, year, type, aircraft, 0, 0);
        setAircraft(aircraft);
    }
    
    /**
     * Setter method sets the total number of aircrafts on-board the carrier.
     * @param aircraft - Holds total number of aircrafts on-board the carrier.
     */
    @Override
    public void setAircraft(int aircraft) {
        this.aircraft = aircraft;
    }
    
    /**
     * Returns the total amount of aircrafts on-board the carrier.
     * @return aircraft - Total amount of aircrafts on-board the carrier.
     */
    @Override
    public int getAircraft() {
        return aircraft;
    }
    
    
    /**
     * Returns the name of the carrier, the year it was built and the total amount of aircrafts on-board.
     * @return Name of the carrier, the year it was built and the total amount of aircrafts on-board.
     */
    @Override
    public String toString() {
        return getName() + " built in " + getYear() + ", Carrirer class carrying " + getAircraft() + " aircrafts.";
    }
    
    /**
     * Writes information about the carriers to a csv file.
     * @return the name of the carrier, the year it was built, and the total amount of aircrafts on-board the carrier to a csv file.
     */
    @Override
    public String writeData() {
        return getName() + "," + "Carrier" + "," + getYear() + "," + getAircraft();
    }
}