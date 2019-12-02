package SalesApp;

public class InStoreSales extends Sales {
	
	private String receiptNumber;
	private static int receiptIndex = 10000; 

	public InStoreSales(String productName, int quantity,
                     double costPerItem) {
		super(productName, quantity, costPerItem);
		transactionID = "INS" + transactionID; 
		setPricePerItem();
		receiptIndex++; 
		setReceiptNumber();
	}

    @Override
    public void setBaseMarginRate() {
    	marginRate = getBaseMarginRate() * costPerItem; 
	}
    
    private void setReceiptNumber() {
    	receiptNumber = "C31A" + receiptIndex; 
    } 

    public void showInfo() {
    	super.showInfo();
    	System.out.println("RECEIPT NUMBER: " + receiptNumber);
	}

}

