import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Ship Registry implements ShipRegistryInterface which holds references to
 * the ship data element class objects to be inherited from ship.
 * @author Josue Ponce
 * @version 1.0
 *
 */
public class ShipRegistry implements ShipRegistryInterface {
	
	/** Attribute ships holds the Ship array list. */
    public ArrayList < Ship > ships = null;
    
    /**Attribute count initialized to 0 holds the count of ships per type. */
    private int count = 0;
    
    /**
     * Default constructor.
     */
    public ShipRegistry() {
    	
            ships = new ArrayList < Ship > ();
        }
    
    /**
     * The addShip method adds ships to the ShipRegistry's ArrayList, distinguishing by type,
     * creating a ship instance of the correct type, and specifying the correct parameters according to its type.
     * This method does not add in any sorted order - the ships are held in the order they are added
     * @param name A string representing the name of the ship
     * @param type A string representing one of "Cargo", "Cruise", "Warship", "Carrier", "Cruiser","Destroyer","Mine Sweeper",or "Submarine"
     * @param year A string representing the year launched
     * @param tons A string representing the number of tons of cargo (net register tonnage (NRT)) the ship can carry
     * @param pax A string representing the number of passengers a cruise ship can carry
     * @param guns A string representing the number of guns a warship can carry.  "Guns" is loosely defined, not according to naval jargon
     * @param torpedoes A string representing the number of torpedoes a warship can carry.
     * @param aircraft A string representing the number of aircraft a warship can nominally carry.
     */
    public void addShip(String name, String type, String year, int tons, int pax, int guns, int torpedoes, int aircraft) {
    	
        switch (type) {
            case "Cargo":
                ships.add(new CargoShip(name, year, type, tons));
                count++;
                break;
            case "Cruise":
                ships.add(new CruiseShip(name, year, type, pax));
                count++;
                break;
            case "Warship":
                ships.add(new WarShip(name, year, type, guns, aircraft, torpedoes));
                count++;
                break;
            case "Carrier":
                ships.add(new Carrier(name, year, type, aircraft));
                count++;
                break;
            case "Cruiser":
                ships.add(new Cruiser(name, year, type, guns));
                count++;
                break;
            case "Destroyer":
                ships.add(new Destroyer(name, year, type, guns));
                count++;
                break;
            case "Mine Sweeper":
                ships.add(new Mine_Sweeper(name, year, type, guns));
                count++;
                break;
            case "Submarine":
                ships.add(new Submarine(name, year, type, torpedoes));
                count++;
                break;
        }
    }
    
	/**
	 * Returns ships from array list.
	 * @return ships - All the ships from the array list.
	 */
    public ArrayList < Ship > getShips() {
    	
        return ships;
    }
    
	/**
	 * The getShipDescriptions method is used in the GUI to set the radio button labels for basic ship types
	 * @return the string array {ShipType.CARGO.toString(), ShipType.CRUISE.toString(), ShipType.WARSHIP.toString()};
	 */
    public String[] getShipDescriptions() {
    	
        String[] returnString = {
            ShipType.CARGO.toString(),
                ShipType.CRUISE.toString(),
                ShipType.WARSHIP.toString()
        };
        return returnString;
    }
    
	/**
	 * The getWarshipDescriptions method is used in the GUI to set the radio button labels for the five warship types
	 * @return the string array {ShipType.CARRIER.toString(), ShipType.CRUISER.toString(), ShipType.DESTROYER.toString(), ShipType.MINE_SWEEPER.toString(), ShipType.SUBMARINE.toString()};
	 */
    public String[] getWarshipDescriptions() {
    	
        String[] returnString = {
            ShipType.CARRIER.toString(),
                ShipType.CRUISER.toString(),
                ShipType.DESTROYER.toString(),
                ShipType.MINE_SWEEPER.toString(),
                ShipType.SUBMARINE.toString()
        };
        return returnString;
    }
    
    /**
     * Setter method sets the ship count.
     * @param count - Holds the ship count.
     */
    public void setCount(int count) {
    	
            this.count = count;
        }
    
    /**
     * Returns the ship count.
     * @return count - the counted ships.
     */
    public int getCount() {
    	
        return count;
    }
    
        /**
         * The readFile method reads from the input file, one line at a time, assuming each line represents data for one ship.
         * It assumes that the second field is a string representing the ship type,
         * one of "Cargo", "Cruise", "Warship", "Carrier", "Cruiser","Destroyer","Mine Sweeper",or "Submarine".
         * It further assumes specific formats for each type of ship, as follows:
         *    Cargo: name,"Cargo",year,tons
         *    Cruise: name,"Cruise",year,passengers
         *    Warship: name,"Warship",year,guns,aircraft,torpedoes
         *    Carrier: name,"Carrier",year,aircraft
         *    Cruiser, Destroyer, and Mine Sweeper: name,type,year,guns
         *    Submarine: name,"Submarine",year,torpedoes
         * It then calls addShip to instantiate it and add it to the ShipRegistry's ArrayList
         * @param file the file of type File to read from, assumed to be a csv file (comma-delimited) in the above order.
         */
    public void readFile(File file) {
    	
            Scanner scan = null;
            try {
                try {
                    scan = new Scanner(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                while (scan.hasNextLine()) {
                    String inputLine = scan.nextLine();
                    String[] space = inputLine.split(",");
                    if (space.length < 4) {
                        JOptionPane.showMessageDialog(null, "Error");
                    } else {
                        if (space[1].equals("Cargo")) {
                            addShip(space[0], space[1], space[2], Integer.parseInt(space[3].trim()), 0, 0, 0, 0);
                        } else if (space[1].equals(ShipType.CRUISE.toString())) {
                            addShip(space[0], space[1], space[2], 0, Integer.parseInt(space[3].trim()), 0, 0, 0);
                        } else if (space[1].equals(ShipType.CARRIER.toString())) {
                            addShip(space[0], space[1], space[2], 0, 0, 0, 0, Integer.parseInt(space[3].trim()));
                        } else if (space[1].equals(ShipType.SUBMARINE.toString())) {
                            addShip(space[0], space[1], space[2], 0, 0, 0, Integer.parseInt(space[3].trim()), 0);
                        } else addShip(space[0], space[1], space[2], 0, 0, Integer.parseInt(space[3].trim()), 0, 0);
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, e.getMessage() + "Expected integer");
                e.printStackTrace();
            } finally {
                scan.close();
            }
        }
    
	/**
	 * The writeFile method writes to a specified file, either creating a new file or appending to the end of an existing file.
	 * It iterates through ShipRegistry's ArrayList <Ship>, writes one line at a time representing data for each ship.
	 * It writes the second field as a string representing the ship type, 
	 * one of "Cargo", "Cruise", "Warship", "Carrier", "Cruiser","Destroyer","Mine Sweeper",or "Submarine".
	 * It further writes specific formats for each type of ship, as follows:
	 *    Cargo: name,"Cargo",year,tons
	 *    Cruise: name,"Cruise",year,passengers
	 *    Warship: name,"Warship",year,guns,aircraft,torpedoes
	 *    Carrier: name,"Carrier",year,aircraft
	 *    Cruiser, Destroyer, and Mine Sweeper: name,type,year,guns
	 *    Submarine: name,"Submarine",year,torpedoes
	 * @param file the file of type File to write to
	 */
    public void writeFile(File file) {
    	
            PrintWriter output;
            if (file != null) {
                try {
                    output = new PrintWriter(new FileWriter(file, true));
                    for (Ship a: ships) {
                        output.println(a.writeData());
                    }
                    output.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    
        /**
         * Displays all ships in array list sorted in alphabetical order.
         * @return print - All ships in the array list sorted in alphabetical order.
         */
    public String toString() {
    	
            String print = "";    
            for (Ship e: ships) {
                print += e.toString() + "\n";
            }
            return print;
        }
    
        /**
         * Writes information about all the ships in the array to a CSV file.
         * @return result - information about all the ships in the array list to be written to a CSV file.
         */
    public String writeData() {
    	
        String result = "";
        for (Ship a: ships) {
            result += a.writeData() + "\n";
        }
        return result;
    }
}