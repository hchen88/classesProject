package classesProject;

public class Product {

	private int qty;
	private double price;
	private String name;
	
	public Product() {
		name = "N/A";
		qty = 0;
		price = 0.00;
	}
	
	public Product(String name, int qty, double price ) {
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQty() {
		return qty;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void addQty(int qty) {
		this.qty += qty;
	}
	
	public void removeQty(int qty) {
		this.qty -= qty;
	}
	
	public String toString() {
		return "There are " + qty + " " + name + "s available.\n";
	}
	
}
