import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * ShipRegistrySTUDENTTest ensures that all the methods in ShipRegistry.Java are implemented correctly
 * @author Josue Ponce
 * @version 1.0
 */
public class ShipRegistrySTUDENTTest {

	private ShipRegistry shipsSTUDENT;
	 
	@Before
	public void setUpSTUDENT() throws Exception {
		
		shipsSTUDENT = new ShipRegistry();
		shipsSTUDENT.addShip("SS Atlantic Causeway", "Cargo", "1982", 15000, 0, 0, 0, 0);
		shipsSTUDENT.addShip("MS Oasis of the Seas",  "Cruise", "2003", 0, 6000, 0, 0, 0);
		shipsSTUDENT.addShip("USS Missouri (BB-63)",  "Warship", "1941", 0, 0, 78, 34, 0);
		shipsSTUDENT.addShip("USS Gerald R. Ford (CVN-78)", "Carrier",  "2013", 0, 0, 0, 0, 100);
		shipsSTUDENT.addShip("Type 052C destroyer", "Destroyer", "2002", 0, 0, 105, 0, 0);
		
	}

	@After
	public void tearDown() throws Exception {
		shipsSTUDENT=null;
	}
	
	//I personally added this.
	@Test
	public void testGetShipDescriptionsSTUDENT() {
		String[] shipDescr = shipsSTUDENT.getShipDescriptions();
		assertEquals("Cargo",shipDescr[0]);
		assertEquals("Cruise",shipDescr[1]);
		assertEquals("Warship",shipDescr[2]);
		
	}
	
	//I added this. 
	@Test
	public void testGetWarshipDescriptionsSTUDENT() {
		String[] shipDescr = shipsSTUDENT.getWarshipDescriptions();
		assertEquals("Carrier",shipDescr[0]);
		assertEquals("Destroyer",shipDescr[2]);
		assertEquals("Submarine",shipDescr[4]);
	}
	
	@Test
	public void testAddShipSTUDENT() {

		shipsSTUDENT.addShip("USS Port Royal (CG-73)", "Cruiser", "1992", 0, 0, 70, 0, 0);
		shipsSTUDENT.addShip("USS Pivot (AM-276)","Mine Sweeper", "1943", 0, 0, 95, 0, 0);
		shipsSTUDENT.addShip("Akula", "Submarine","1976",0,0,0,88,0);
		shipsSTUDENT.addShip("USS George H.W. Bush (CVN 77)","Carrier","2009",0,0,0,0,123);
		ArrayList<Ship> shipList = shipsSTUDENT.getShips();
		assertEquals("USS Port Royal (CG-73)",shipList.get(5).toString().substring(0,22));
		assertEquals("USS Pivot (AM-276)",shipList.get(6).toString().substring(0,18));
		assertEquals("Akula",shipList.get(7).toString().substring(0,5));
		assertEquals(123,((WarShip)shipList.get(8)).getAircraft());
		
	}

	@Test
	public void testReadFileSTUDENT() {
		try {
			//this statement just rewrites an empty file over any existing ones
			new PrintWriter("testShips.csv"); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		shipsSTUDENT.writeFile(new File("testShips.csv"));
		shipsSTUDENT = new ShipRegistry();
		shipsSTUDENT.readFile(new File("testShips.csv"));
		ArrayList<Ship> shipList = shipsSTUDENT.getShips();
		Ship s = shipList.get(0);
		assertEquals("SS Atlantic Causeway",s.writeData().substring(0,20));	
		s = shipList.get(3);
		assertEquals("USS Gerald R. Ford (CVN-78)",s.writeData().substring(0,27));	
	}

	@Test
	public void testWriteFile() {
		ArrayList<Ship> shipList = shipsSTUDENT.getShips();
		Ship s = shipList.get(2);
		assertEquals("USS Missouri (BB-63)",s.writeData().substring(0,20));
	}

}