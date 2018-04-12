import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Junit test cases for lab #9. Added g3 gradebook object for fun and practice. 
 * @author Josue Ponce
 * @version 1.0
 *
 */
public class GradebookTester
{  
   private GradeBook g1;
   private GradeBook g2;
   //for fun
   private GradeBook g3;

   @Before
   public void setUp()
   {
       // create two objects of GradeBook of size 5
       g1 = new GradeBook(5);
       g2 = new GradeBook(5);
       g3=new GradeBook(5);
       // Call the addScore method for each of the GradeBook objects
       g1.addScore(95.0);
       g1.addScore(88.0);
       g1.addScore(92.0);
       
       g2.addScore(30.0);
       g2.addScore(10.0);
       g2.addScore(40.0);
       g2.addScore(20.0);
       //for fun
       g3.addScore(50.0);
       g3.addScore(75.0);
   }

   @After
   public void tearDown()
   {
       // set the two objects of GradeBook to null
       g1 = null;
       g2 = null;
       //for fun
       g3 = null;
   }

   @Test
   public void addScoreTest()
   {
       // Use the toString method to compare the contents of what is in the scores array vs. what is expected to be in the scores array
	   assertTrue(g1.toString().equals("95.0 88.0 92.0 "));
       assertTrue((g2.toString()).equals("30.0 10.0 40.0 20.0 "));
       assertTrue((g3.toString()).equals("50.0 75.0 "));
       //assertTrue((g3.toString()).equals("50.0 75.0 "));
       // Compare the scoreSize to the expected number of scores entered.
       assertEquals(3, g1.getScoreSize(), 0.001);
       assertEquals(4, g2.getScoreSize(), 0.001);
       assertEquals(2, g3.getScoreSize(), 0.001);
   }

   @Test
   public void sumTest() 
   {
       // Compare what is returned by sum() to the expected sum of the scores entered.
       assertEquals(275, g1.sum(), 0.0001);
       assertEquals(100.0, g2.sum(), 0.0001);
       assertEquals(125.0, g3.sum(), 0.0001);
   }

   @Test
   public void minimumTest() 
   {
       // Compare what is returned by minimum() to the expected minimum of the scores entered.
       assertEquals(88.0, g1.minimum(), 0.001);
       assertEquals(10.0, g2.minimum(), 0.001);
       assertEquals(50.0, g3.minimum(), 0.001);
   }

   @Test
   public void finalScoreTest()
   {
       // Compare what is returned by finalScore() to the expected finalScore of the scores entered.
       assertEquals(187.0, g1.finalScore(), 0.001);
       assertEquals(90.0, g2.finalScore(), 0.001);
       assertEquals(75.0, g3.finalScore(), 0.001);
   }
}
