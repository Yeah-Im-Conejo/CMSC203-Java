/**
 * Inherits accessible members from ship and represents warships which will also have it's own subclasses
 * @author Josue Ponce
 * @version 1.0
 *
 */
public class WarShip extends Ship {
	
	/** Attribute guns holds the number of guns on the ship. */
    private int guns;
    
    /** Attribute aircraft holds the total number of aircrafts on the ship. */
    private int aircraft;
    
    /** Attribute torpedoes holds the total number of torpedoes on the ship. */
    private int torpedoes;
    
    /**Attribute ST holds the name ship types. */
    private final static ShipType ST = ShipType.WARSHIP;
    
    /**
     * Default constructor.
     */
    public WarShip() {
        super();
        setNumGuns(0);
        setAircraft(0);
        setNumTorpedoes(0);
    }
    
    /**
     * Parameterized constructor that initiates name, year, type, guns, torpedoes, and aircraft.
     * @param name - Represents the name of the ship.
     * @param year - Represents the year the ship was built.
     * @param type - Represents the type of ship.
     * @param guns - Represents the total number of guns on the ship.
     * @param torpedoes - Represents the total number of torpedoes on the ship.
     * @param aircraft - Represents the total number of aircrafts on the ship.
     */
    public WarShip(String name, String year, String type, int guns, int torpedoes, int aircraft) {
        super(name, year, ST);
        setNumGuns(guns);
        setAircraft(aircraft);
        setNumTorpedoes(torpedoes);
    }
    
    /**
     * Setter method sets the total number of guns on the ship.
     * @param guns - Holds the total number of guns.
     */
    public void setNumGuns(int guns) {
        this.guns = guns;
    }
    
    /**
     * Setter method sets the total number of aircrafts on the ship.
     * @param aircraft - Holds the total number of aircrafts.
     */
    public void setAircraft(int aircraft) {
        this.aircraft = aircraft;
    }
    
    /**
     * Setter method sets the total number of torpedoes.
     * @param torpedoes - Holds the number of torpedoes.
     */
    public void setNumTorpedoes(int torpedoes) {
        this.torpedoes = torpedoes;
    }
    
    /**
     * Returns the total number of aircrafts on the ship.
     * @return aircraft - total number of aircrafts on-board the ship.
     */
    public int getAircraft() {
        return aircraft;
    }
    
    /**
     * Returns total number of guns on the ship.
     * @return guns - Total number of guns on the ship.
     */
    public int getNumGuns() {
        return guns;
    }
    
    /**
     * Returns the number of torpedoes on the ship.
     * @return torpedoes - Total number of torpedoes on the ship.
     */
    public int getNumTorpedoes() {
        return torpedoes;
    }
    
    /**
     * Returns super.toString() with the total number of guns, torpedoes and aircrafts. 
     * @return super.toString() with total number of guns, torpedoes and aircrafts. 
     */
    @Override
    public String toString() {
   
        return super.toString() + " with " + getNumGuns() + " guns, " + getNumTorpedoes() + " torpedoes, and " + getAircraft() + " aircrafts.";
    }
    
    /**
     * Writes information about warship and it's subclasses to a CSV file.
     * @return super.writedata() with the total number of guns, torpedoes and aircrafts to a CSV file.
     */
    @Override
    public String writeData() {
        return super.writeData() + "," + getNumGuns() + "," + getNumTorpedoes() + "," + getAircraft();
    }
	

}