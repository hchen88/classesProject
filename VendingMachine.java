package classesProject;

import java.util.ArrayList;

/**	
 * Scott Arima and Howard Chen
 * 08 October 2018
 * Purpose of the program- Simulate Vending Machine with capabilities making transactions, 
 * 						   re-stocking products, withdrawing funds.  
 * Inputs: selections from vending menu
 * Output: Game Log - Displays vending actions, insufficient funds/stock.
 */
public class VendingMachine {

	private ArrayList<Product> stock = new ArrayList<Product>();
	private ArrayList<Coin> coinsAvailable = new ArrayList<Coin>();
	private ArrayList<Coin> insertedCoins = new ArrayList<Coin>();
	
	/**
	 * this method restocks merchandise and gives the operator the option to change the price
	 * @param merchandise - string of merchandise name
	 * @param amount - integer of amount to restock
	 * @param changePrice - boolean to determine whether to change price or not
	 * @param price - price to change to (optional)
	 */
	public void restock(String merchandise, int amount, boolean changePrice, double price) {
		boolean merchFound = false;
		for(Product product : stock) {
			if(product.getName().equals(merchandise)) {
				product.addQty(amount);
				if(changePrice) {
					product.setPrice(price); //if during restock the operator wants to change the price
				}
				merchFound = true;
			}
		}
		if(merchFound == false) {
			stock.add(new Product(merchandise, amount, price));
		}
	}
	/**
	 * this method is used removes products
	 * @param merchandise- string type merchandise name
	 * @param amount- int type amount to be removed
	 */
	public void removeProduct(String merchandise, int amount) {
		for(Product product : stock) {
			if(product.getName().equals(merchandise)) {
				product.removeQty(amount);
			}
		}
	}
	
	/**
	 * this method adds coins to Vending machine
	 * @param name - the string of the coin type
	 * @param additionalCoins - integer qty of coins
	 */
	
	public void addCoins(String name, int additionalCoins) {
		boolean coinFound = false;
		for(Coin coin : coinsAvailable) {
			if(coin.getName().equals(name)) {
				coin.addCoin(additionalCoins);
				coinFound = true;
			}
		}
		if(coinFound == false) {
			Coin newCoin = new Coin();
			newCoin.setName(name);
			newCoin.setQty(additionalCoins);
			coinsAvailable.add(newCoin);
		}
	}
	/**
	 * this method removes coins from vendingMachine 
	 * @param name -  the string type of coin to remove
	 * @param amount -  the amount of coins to remove
	 */
	public void removeCoins(String name, int amount) {
		for(Coin coin : coinsAvailable) {
			if(coin.getName().equals(name)) {
				coin.removeCoin(amount);
			}
		}
	}
	/**
	 * this method prints out total of coins to be removed and then removes all coins from vending machines 
	 * from both inserted coins and coins available ArrayLists.
	 */
	public String removeAllCoins() {
		double total = 0;
		for(Coin coin : coinsAvailable) {
			total += coin.getTotal();
		}
		String str = String.format("Removed $%.2f%n", total);
		insertedCoins.clear();
		coinsAvailable.clear();
		return str;
		}
	/**
	 * this method changes the price of specific product.
	 * @param name- the name of the product 
	 * @param price - the price to change the product to
	 */
	public void changePrice(String name, double price) {
		for(Product product : stock) {
			if(product.getName().equals(name)) {
				product.setPrice(price);
			}
		}
	}
	
	/**
	 * this method is used to  insert coins 
	 * @param name- string of the type of coin to insert 
	 * @param amount - integer  of the amount of coins inserted
	 */
	public void insertCoins(String name, int amount) {
		boolean coinFound = false;
		for(Coin coin : insertedCoins) {
			if(coin.getName().equals(name)) {
				coin.addCoin(amount);
				coinFound = true;
			}
		}
		if(coinFound == false) {
			Coin userCoin = new Coin();
			userCoin.setName(name);
			userCoin.setQty(amount);
			insertedCoins.add(userCoin);
		}
	}
	/**
	 * this method is used to purchase 
	 * a product from the vending machine
	 * @param productName- string type of the product name to purchase
	 * @return - returns a boolean ArrayList for tester to output "sold out" or "insufficient funds" message.
	 */
	public ArrayList<Boolean> buy(String productName) {
		int total = 0;
		ArrayList<Boolean> booleanList=new ArrayList<Boolean>();
		booleanList.add(true); //first index for sold out boolean
		booleanList.add(true); //second index for sufficient funds boolean
		
		for(Product product : stock) {
			if(product.getName().equals(productName) && product.getQty() != 0) {
				booleanList.set(0, false);// sets 1st index in ArrayList to false
				for(Coin coin : insertedCoins) {
					total += coin.getTotal();
				}
				if(total >= product.getPrice()) { // buying product
					for(Coin coin : insertedCoins) {  
						this.addCoins(coin.getName(), coin.getQty());
						coin.setQty(0); // reomves coins 
					}
					product.removeQty(1);  //insufficent funds
					insertedCoins.clear();
					
				}
				else { 
					booleanList.set(1, false); // sets 2nd index in ArrayList to false
					for(Coin coin : insertedCoins) {
						coin.setQty(0);
					}
				}
			}
		}
		
		return booleanList;
	}
	/**
	 * this method gets the prices of each product in the vending machine
	 * @return - string of the products and their respected prices
	 */
	public String checkPrices() {
		String products = "";
		for(Product product : stock) {
			String twoDecimalPlaces = String.format("%.2f", product.getPrice()); // Concatenates string of Products and prices. 
			products += product.getName() + ": $" + twoDecimalPlaces + "\n";
		}
		return products; // returns the string
	}
	/**
	 * this method used to display a list of products in the vending machine
	 * @return- returns the string format of the list of products
	 */
	public String listProducts() {
		String products = "Products Listed:\n";
		for(Product product : stock) {
			products += product.getName() + "\n"; // // Concatenates string of Products 
		}
		return products;
	}
	
	/**
	 * this method gets the inserted coins total in vending  machine
	 * @return- the double total of inserting coins
	 */
	public double getInsertedCoinsTotals() {
		double total = 0;
		for(Coin coin : insertedCoins) {
			total += coin.getTotal();
		}
		return total;
	}
	/**
	 * this method gets the coins available total.
	 * (income made by sales)
	 * @return - double type total of the coins available
	 */
	public double getCoinsAvailbleTotals() {
		double total = 0;
		for(Coin coin : coinsAvailable) {
			total += coin.getTotal();
		}
		return total;
	}
	/**
	 * to string method to display products and coins in vending machine
	 */
	public String toString() {
		String products = "";
		String coins = "";
		for(Product product : stock) {
			products += product;
		}
		for(Coin coin : coinsAvailable) {
			coins += coin;
		}
		return "Products:\n" + products + "Coins:\n" + coins;
	}
	
}
