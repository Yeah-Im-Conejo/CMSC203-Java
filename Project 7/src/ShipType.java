/**
 *  Enmun type ShipType sets Cargo, Cruise, warship, carrier,cruiser,destroyer,mine sweeper, and Submarine
 *  as a fixed set of predefined constants.
 * @author Josue Ponce
 * @version 1.0
 */
public enum ShipType {
	
	/**Attribute CARGO holds the name of ship type for cargo ships. */
    CARGO("Cargo"),
    
    /**Attribute CRUISE holds the name of ship type for cruise ships. */
    CRUISE("Cruise"),
    
    /**Attribute WARSHIP holds the name of ship type for warships. */
    WARSHIP("Warship"),
    
    /**Attribute CARRIER holds the name of ship type for Carrier ships. */
    CARRIER("Carrier"),
    
    /**Attribute CRUISER holds the name of ship type for cruisers. */
    CRUISER("Cruiser"),
    
    /**Attribute DESTROYER holds the name of ship type for Destroyers. */
    DESTROYER("Destroyer"),
    
    /**Attribute MINE_SWEEPER holds the name of ship type for Mine Sweepers. */
    MINE_SWEEPER("Mine Sweeper"),
    
    /**Attribute SUBMARINE holds the name of ship type for submarines. */
    SUBMARINE("Submarine");
	
	/**Attribute name holds the name of the type of ship. */
    private String name;
    
	/**
	 * Sets the name of the ship type.
	 * @param name - Holds the name of the ship type.
	 */
    ShipType(String name) {
        this.name = name;
    }
    
    /**
     * Returns the name of the ship type.
     * @return name - The name of the type of ship.
     */
    @Override
    public String toString() {
        return name;
    }
}