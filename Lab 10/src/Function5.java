/**
 * Task #3 function 5
 * @author Josue Ponce
 * @version 1.0
 */
public class Function5 extends Function {

	@Override
	public double fnValue(double x) {
		
		return Math.sin(1/x);
	}
	

	public String toString () {
		return "sin(1/x)";
	}
}