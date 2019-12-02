package SalesApp;

public class OnlineSales extends Sales {

	private String orderNumber;
 
	public OnlineSales (String productName, int quantity,
                       double costPerItem){
       super(productName, quantity, costPerItem); 
   		transactionID = "ONL" + transactionID;
   		setPricePerItem();
        setOrderNumber();   
	}       
   
    @Override
    public void setBaseMarginRate() {
	   marginRate = (getBaseMarginRate() * costPerItem) - 0.03;
    }
   
    private void setOrderNumber() {
	   orderNumber = "100-" + (int)(Math.random() * Math.pow(10, 7)); 
	   
    }
  
    public void showInfo() {
    	super.showInfo();
		 System.out.println("ONLINE ORDER NUMBER: " + orderNumber);
	}

}
