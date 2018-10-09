package classesProject;
/**	
 * Scott Arima and Howard Chen
 * 08 October 2018
 * Purpose of the program- Simulate Vending Machine with capabilities making transactions, 
 * 						   re-stocking products, withdrawing funds.  
 * Inputs: selections from vending menu
 * Output: Game Log - Displays vending actions, insufficient funds/stock.
 */
public class Coin {
	
	private String name; // name/type of coin
	private double value; // value of coin
	private int qty; // qty of coin in vending machine
	/**
	 * default constructor of a coin 
	 * name set to "N/A"
	 * value set to 0
	 * qty set to zero
	 * 
	 */
	public Coin() {
		name = "N/A"; 
		value = 0;
		qty = 0;
	}
	/**
	 * gets the name of the coin
	 * @return - name in string type
	 */
	public String getName() {
		return name;
	}
	/**
	 * gets the value of the coin
	 * @return - value in double type
	 */
	public double getValue() { //amount of a single coin
		return value;
	}
	/**
	 * gets the qty of coins
	 * @return - qty as an integer 
	 */
	public int getQty() { //quantity of that coin available
		return qty;
	}
	/**
	 * gets the total type
	 * @return - returns the total as a double
	 */
	public double getTotal() { //total amount of said coins
		return value * qty;
	}
	/**
	 * setter for the name of the coin
	 * @param - the name to set coin to as a string
	 */
	public void setName(String name) {
		this.name = name;
		if(name.equals("quarter")) {
			value = 0.25;
		}
		else if(name.equals("dime")) {
			value = 0.10;
		}
		else if(name.equals("nickel")) {
			value = 0.05;
		}
		else { //would be a penny by default
			value = 0.01;
		}
	}
	/**
	 * set qty
	 * @param qty
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}
	/**
	 * removes a specific amount of coins
	 * @param amount - the int amount of coins to remove
	 */
	public void removeCoin(int amount) {
		qty -= amount;
	}
	/**
	 * adds coins to vending machine
	 * @param amount- the int amount of coins to add
	 */
	public void addCoin(int amount) {
		qty += amount;
	}
	/**
	 * Override to string method, displays number 
	 * of coins avaiable in vending machine
	 */
	public String toString() {
		return "There are " + qty + " " + name + "s available.\n";
	}

}
