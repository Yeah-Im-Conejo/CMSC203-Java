/**
 * Inherits accessible members from WarShip and represents cruisers.
 * @author Josue Ponce
 * @version 1.0
 *
 */
public class Cruiser extends WarShip {
	
	/**Attribute guns holds the total number of guns on cruisers. */
    private int guns;
    
    /**
     * Default class constructor.
     */
    public Cruiser() {
        super();
        setNumGuns(0);
    }
    
    /**
     * Parameterized constructor that initializes name, year, type, and guns.
     * @param name - Represents the name of the cruiser.
     * @param year - Represents the year the cruiser was built.
     * @param type - Represents the type of ship.
     * @param guns - Represents the total number of guns on the cruiser.
     */
    public Cruiser(String name, String year, String type, int guns) {
        super(name, year, type, guns, 0, 0);
        setNumGuns(guns);
    }
    
    /**
     * Setter method holds the total number of guns on cruisers.
     * @param guns - Holds the total number of guns on cruisers.
     */
    @Override
    public void setNumGuns(int guns) {
        this.guns = guns;
    }
    
    /**
     * Returns the total number of guns on cruisers.
     * @return guns - Total number of guns on cruisers.
     */
    @Override
    public int getNumGuns() {
        return guns;
    }
    
    /**
     * Returns the name of the cruiser, the year it was built and the total number of guns.
     * @return - The name of the cruiser, the year it was built and the total number of guns.
     */
    @Override
    public String toString() {
        return getName() + " built in " + getYear() + ", Cruiser class with " + getNumGuns() + " guns.";
    }
    
    /**
     * Writes information about cruisers to a csv file.
     * @return the name of the cruiser, the year it was built and the total number of guns to a csv file.
     */
    @Override
    public String writeData() {
        return getName() + ",Cruiser," + getYear() + "," + getNumGuns();
    }
}