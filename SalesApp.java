package SalesApp;

/**This program keeps track of sales;
 * online and in store sales for a small business.
 * 
 * @author Perihan Hill
 * @since 11/30/2019
 * @version 1.8
 */
import java.util.LinkedList;
import java.util.List;

public class SalesApp {

	public static void main(String[] args) {

		List<Sales> sales = new LinkedList<Sales>(); 
		String file = "/Users/peri/Desktop/JavaSE8/ReadFiles/TotalSales.csv"; 
		 
		
		List<String[]> newSales = utilities.CSVfile.read(file); 
		
		for(String[] salesInfo: newSales) {
			String salesType = salesInfo[0];
			String productName = salesInfo[1]; 
			int quantity = Integer.parseInt(salesInfo[2].trim());
			double costPerItem = Double.valueOf(salesInfo[3]); 
	 		 

	 		if(salesType.equals("Instore")) {
	 			sales.add(new InStoreSales(productName, quantity, costPerItem)); 
			}
			else if(salesType.equals("Online")) {
				sales.add(new OnlineSales(productName, quantity, costPerItem)); 
				
			} 
			else {
				System.out.println("CANNOT READ SALES TYPE");
			}
		}
			for(Sales sl: sales) {
				System.out.println("*********************");
				sl.showInfo();
			}
	}
}


