/**
 * Inherits accessible members from WarShip and represents mine sweepers.
 * @author Josue Ponce
 * @version 1.0
 *
 */
public class Mine_Sweeper extends WarShip {
	
	/**Attribute holds the number of guns on mine sweepers.*/
    private int guns;
    
    /**
     * Default constructor
     */
    public Mine_Sweeper() {
    	
        super();
        setNumGuns(0);
    }
    
    /**
     * Parameterized constructor the initiates name, year, type, and guns.
     * @param name - Represents the name of the mine sweeper.
     * @param year - Represents the year the mine sweeper was built.
     * @param type - Represents the type of ship.
     * @param guns - Represents the number of guns on the mine sweeper.
     */
    public Mine_Sweeper(String name, String year, String type, int guns) {
    	
        super(name, year, type, guns, 0, 0);
        setNumGuns(guns);
    }
    
    /**
     * Setter method sets the number of guns on mine sweepers.
     * @param guns - Holds the total number of guns on mine sweepers.
     */
    @Override
    public void setNumGuns(int guns) {
        this.guns = guns;
    }
    
    /**
     * Returns the total number of guns on the mine sweeper.
     * @return guns - Total number of guns on the mine sweeper.
     */
    @Override
    public int getNumGuns() {
        return guns;
    }
    
    /**
     * Returns the name of the mine sweeper, the year it was built and the total number of guns.
     * @return The name of the mine sweeper, the year it was built and the total number of guns.
     */
    @Override
    public String toString() {
        return getName() + " built in " + getYear() + ", Mine Sweeper class with " + getNumGuns() + " guns.";
    }
    
    /**
     * Writes information about the mine sweeper to a CSV file.
     * @return The name of the mine sweeper, the year it was built and the total number of guns to a CSV file.
     */
    @Override
    public String writeData() {
        return getName() + ",Destroyer," + getYear() + "," + getNumGuns();
    }
}