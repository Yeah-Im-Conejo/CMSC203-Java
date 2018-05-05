/**
 * Inherits accessible members from WarShip and represents Destroyers.
 * @author Josue Ponce
 * @version 1.0
 *
 */
public class Destroyer extends WarShip {
	
	/** Attribute guns holds the total number of guns on destroyers. */
    private int guns;
    
    /**
     * Default constructor
     */
    public Destroyer() {
        super();
        setNumGuns(0);
    }
    
    /**
     * Parameterized constructor the initiates name, year, type, and guns.
     * @param name - Represents the name of the destroyer.
     * @param year - Represents the year the ship was built.
     * @param type - Represents the type of ship.
     * @param guns - Represents the number of guns on the destroyer.
     */
    public Destroyer(String name, String year, String type, int guns) {
        super(name, year, type, guns, 0, 0);
        setNumGuns(guns);
    }
    
    /**
     * Setter method sets the total number of guns on destroyers.
     * @param guns - Holds the total number of guns on destroyers
     */
    @Override
    public void setNumGuns(int guns) {
        this.guns = guns;
    }
    
    /**
     * Returns the total number of guns on the destroyers.
     * @return guns - Total number of guns on destroyers.
     */
    @Override
    public int getNumGuns() {
        return guns;
    }
    
    /**
     * Returns the name of the destroyer, the year it was built, and the total number of guns on the destroyer.
     * @return The name of the destroyer, the year it was built, and the total number of guns on the destroyer.
     */
    @Override
    public String toString() {
        return getName() + " built in " + getYear() + ", Destroyer class with " + getNumGuns() + " guns.";
    }
    
    /**
     * Writes information about the Destroyer to a CSV file.
     * @return The name of the destroyer, the year it was built, and the total number of guns on the destroyer to a CSV file.
     */
    @Override
    public String writeData() {
        return getName() + ",Destroyer," + getYear() + "," + getNumGuns();
    }
}