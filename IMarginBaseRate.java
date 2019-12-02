package SalesApp;

public interface IMarginBaseRate {
	
	//that returns the margin base rate 
	default double getBaseMarginRate() {
		return 0.18;  
	}
}
