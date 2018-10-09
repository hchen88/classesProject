package classesProject;

public class Product {
	//instance variables
	private int qty; // qty of products
	private double price; // price of product 
	private String name;  // product name
	
	/**
	 * this is a default constructor of the Product
	 * 
	 */
	public Product() {
		name = "N/A";
		qty = 0;
		price = 0.00;
	}
	/**
	 * Constructor is specific product information
	 * @param name - string name of product
	 * @param qty - integer qty of product
	 * @param price - double price of product
	 */
	public Product(String name, int qty, double price ) {
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	/**
	 * gets the name of the product
	 * @return - the product name as a string
	 */
	public String getName() {
		return name;
	}
	/**
	 * this method gets the price of the product
	 * @return - returns the price of the product as a double
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * this method gets the qty of product
	 * @return - returns the qty as an integer
	 */
	public int getQty() {
		return qty;
	}
	
	/**
	 * this method sets the name of the product
	 * @param name- the name to set to as a string
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * this method sets the price of the product
	 * @param price- price as a double
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * this method increments the qty 
	 * @param qty - the qty to add in integer form
	 */
	public void addQty(int qty) {
		this.qty += qty;
	}
	/**
	 * this method decrements the qty of the product
	 * @param qty- the qty to remove as an integer
	 */
	public void removeQty(int qty) {
		this.qty -= qty;
	}
	/**
	 * this is the toString method that displays the qty in stock.
	 */
	public String toString() {
		return "There are " + qty + " " + name + "s available.\n";
	}
	
}
