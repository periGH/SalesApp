package SalesApp;

/**This program keeps track of sales;
 * online and in store sales for a small business.
 * 
 * @author Perihan Hill
 * @since 11/30/2019
 * @version 1.8
 */

public abstract class Sales implements IMarginBaseRate {
	
   private String productName;
   private int quantity;
   private static int salesIndex = 10000;
   protected String transactionID;
   protected double costPerItem;
   protected double marginRate;
   protected double pricePerItem;
   
   
   public Sales(String productName, int quantity, double costPerItem) {
       this.productName = productName.toLowerCase();
       this.quantity = quantity;
       this.costPerItem = costPerItem;
       salesIndex++; 
       this.transactionID = setTransactionID();
       setBaseMarginRate();
       this.pricePerItem = setPricePerItem(); 
   }
   
   public abstract void setBaseMarginRate();
   
   protected String setTransactionID() {
	   String firstFourOfProductName = productName.substring(0, 4); 
	   int salesID = salesIndex; 
	   int randomNumber = (int)(Math.random()* Math.pow(10, 3));  
	   return firstFourOfProductName + salesID + randomNumber; 
   }

   public double setPricePerItem(){
		 double price = costPerItem + marginRate; 
		 price = Math.round(price * 100.0) / 100.0; 
		 return price; 
   }
   
   public void showInfo(){
       System.out.println("TRANSACTION ID: " + transactionID
       		   + "\nPRODUCT NAME: " + productName
               + "\nQUANTITY OF ITEMS: " + quantity
               + "\nCOST PER ITEM: " + costPerItem
               + "\nMARGIN RATE: $" + marginRate
               + "\nPRICE PER ITEM: $" + pricePerItem
               + "\nTOTAL CHARGE: $" + Math.round((quantity*pricePerItem)*100.0)/100.0);
   } 
}