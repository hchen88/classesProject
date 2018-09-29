import java.util.ArrayList;

public class Product {
	public static ArrayList<Product> productList = new ArrayList<Product>();
	int qty;
	double price;
	String name;
	
	public Product() {
		name = "Soda";
		qty = 30;
		price = 1.00;
		
	}
	
	public Product(String name, int qty, double price ) {
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	
	public void reStock(int amountStocking) {
		qty += amountStocking;
	}
	
	public void changePrice(double price) {
		this.price = price;
	}
	
	public void buyProduct(Product product) {
		product.qty --;
	}
	
	
	public String toString() {
		
		String str ="";
		str += " " + name + "\n Price:" + price;
		
		return str;
	}
	
	
	
			
}
