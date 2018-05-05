/**
 * Enmun type Position sets Manager, Sales, Design and Manufacturing as a fixed set of predefined constants.
 * @author Josue Ponce
 * @version 1.0
 *
 */
	public enum Position {
		
		/**Attribute MANAGER holds the name of the position for employees who are managers. */
		MANAGER("Manager"),
		
		/**Attribute SALES holds the name of the position for employees who work in sales. */
        SALES("Sales"),
        
        /**Attribute DESIGN holds the name of the position for employees who are designers. */
        DESIGN("Design"),
        
        /**Attribute MANUFACTURING holds the name of the position for employees who work in manufacturing. */
        MANUFACTURING("Manufacturing");
		
	/**Attribute name holds the name of the positions. */
    private String name;

    /**
     *  Parameterized constructor initiates name.
     * @param name - Represents the name of the employee's position.
     */
    Position(String name) {
        this.name = name;
    }
    
    /**
     * Returns the name of the employee's position.
     * @return name - The name of the employee's position.
     */
   @Override
    public String toString() {
        return name;
    }

}