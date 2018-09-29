import java.util.ArrayList;

public class Fund {
	private static double customerFund; // coins inserted by customer
	private static double machineFund; // coins in vending machine
	private ArrayList<String> customerCoins = new ArrayList<String>();
	
	public boolean priceChecker(Product product, double fund) {
		if (product.price <= fund) {
			return true;
		}else {
			return false;
		}
	}
	
	public void insertCoin(String coin) {
		if(coin.toLowerCase().equals("quarter")) {
			customerFund += .25;
		}else if (coin.toLowerCase().equals("dime")){
			customerFund += .10;
		}else if (coin.toLowerCase().equals("nickel")){
			customerFund += .05;
		}else if (coin.toLowerCase().equals("penny")){
			customerFund += .01;
		}
	}
	
	public void collectMachineFund(){
		
	}
	
	
	

}
