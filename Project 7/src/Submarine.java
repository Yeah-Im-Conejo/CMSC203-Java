/**
 * Inherits accessible members from WarShip and represents submarines.
 * @author Josue Ponce
 * @version 1.0
 *
 */
public class Submarine extends WarShip {
	
	/** Attribute torpedoes holds the total number of torpedoes. */
    private int torpedoes;
    
    /**
     * Default constructor.
     */
    public Submarine() {
        super();
        setNumTorpedoes(0);
    }
    
    /**
     * Parameterized constructor that initiates name, year, type, and torpedoes.
     * @param name - Represents the name of the submarines.
     * @param year - Represents the year the submarine was built.
     * @param type - Represents the type of ship.
     * @param torpedoes - Represents the number of torpedoes in the submarine.
     */
    public Submarine(String name, String year, String type, int torpedoes) {
        super(name, year, type, torpedoes, 0, 0);
        setNumTorpedoes(torpedoes);
    }
    
    /**
     * Setter method sets the number of torpedoes.
     * @param torpedoes - Holds the number of torpedoes in the submarine.
     */
    @Override
    public void setNumTorpedoes(int torpedoes) {
        this.torpedoes = torpedoes;
    }
    
    /**
     * Returns the number of torpedoes in the submarine.
     * @return torpedoes - Total number of torpedoes.
     */
    @Override
    public int getNumTorpedoes() {
        return torpedoes;
    }
    
    /**
     * Returns the name of the submarine, the year it was built, and the number of torpedoes. 
     * @return - The name of the submarine, the year it was built, and the number of torpedoes. 
     */
    @Override
    public String toString() {
        return getName() + " built in " + getYear() + ", Submarine class with " + getNumTorpedoes() + " torpedoes.";
    }
    
    /**
     * Writes information about the submarine to a CSV file.
     * @return The name of the submarine, the year it was built, and the number of torpedoes to a CSV file. 
     */
    @Override
    public String writeData() {
        return getName() + ",Submarine," + getYear() + "," + getNumTorpedoes();
    }
}