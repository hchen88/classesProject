package classesProject;

public class Coin {
	
	private String name;
	private double value;
	private int qty;
	
	public Coin() {
		name = "N/A";
		value = 0;
		qty = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public double getValue() { //amount of a single coin
		return value;
	}
	
	public int getQty() { //quantity of that coin available
		return qty;
	}
	
	public double getTotal() { //total amount of said coins
		return value * qty;
	}
	
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
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public void removeCoin(int amount) {
		qty -= amount;
	}
	
	public void addCoin(int amount) {
		qty += amount;
	}
	
	public String toString() {
		return "There are " + qty + " " + name + "s available.\n";
	}

}
