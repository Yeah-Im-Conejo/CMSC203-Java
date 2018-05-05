/**
 * Inherits accessible members from employee and represents employees who work in manufacturing for the company. 
 * @author Josue Ponce
 * @version 1.0
 */
public class Manufacturing extends Employee
{
   /**Attribute p holds predefined constant for employees in manufacturing. */ 
   private final static Position p = Position.MANUFACTURING;
   
   /**Attribute pieceAmount holds the total amount of pieces manufactured by the employee*/
   private double pieceAmount;
   
   /** Attribute pricePerPiece holds the price per piece manufactured by the employee.*/
   private double pricePerPiece;
   
   /**
    * Default constructor.
    */
   public Manufacturing()
   {
       super();
       setPieceAmount(0);
       setPricePerPiece(0);
   }
   
   /**
    * Parameterized Constructor that initializes fName,lName, pieceAmount, PricePerPice, and int empNum.
    * @param fName - Represents the manufacturer's first name.
    * @param lName - Represents the manufacturer's last name.
    * @param pieceAmount - Represents the total amount of pieces manufactured. 
    * @param pricePerPiece - Represents the total cost per piece.
    * @param empNum - Represents the manufacturer's employees ID number.
    */
   public Manufacturing(String fName, String lName, double pieceAmount, double pricePerPiece, int empNum)
   {
       // call super
       super(fName, lName, empNum, p);
       setPieceAmount(pieceAmount);
       setPricePerPiece(pricePerPiece);
   }
   
   /**
    * Setter method sets the price for each piece manufactured.
    * @param pricePerPiece - Holds the price for each piece manufactured. 
    */
   public void setPricePerPiece(double pricePerPiece) {
       this.pricePerPiece = pricePerPiece;
   }
   
   /**
    * Setter method sets the total piece amount. 
    * @param pieceAmount - Holds the total cost for each piece.
    */
   public void setPieceAmount(double pieceAmount) {
       this.pieceAmount = pieceAmount;
   }
   
   /**
    *  Returns the calculated weekly pay for employees in manufacturing
    *  @return getPieceAmount() * getPricePerPiece(); 
    */
   public double calculateWeeklyPay() {
       return getPieceAmount() * getPricePerPiece();
   }
   /**
    * Returns the total amount for each piece manufactured.
    * @return pieceAmount - Total amount each piece is worth.
    */
   public double getPieceAmount() {
       return pieceAmount;
   }

   /**
    * 
    * @return pricePerPiece - Price per each item manufactured. 
    */
   public double getPricePerPiece() {
       return pricePerPiece;
   }

   /**
    * Super.toString() calls Object class method toSting() and also calculates weekly pay in proper currency format for this sub class. 
    * @return information from the manufacturing subclass and calculated weekly pay in proper format.
    */
   @Override
	public String toString(){
		return super.toString()+"		                $"+String.format("%,.2f", calculateWeeklyPay());
	}
	

}