package classesProject;

import java.util.ArrayList;

public class VendingMachine {

	private ArrayList<Product> stock = new ArrayList<Product>();
	private ArrayList<Coin> coinsAvailable = new ArrayList<Coin>();
	private ArrayList<Coin> insertedCoins = new ArrayList<Coin>();

	public void restock(String merchandise, int amount, double price) {
		boolean merchFound = false;
		for(Product product : stock) {
			if(product.getName().equals(merchandise)) {
				product.addQty(amount);
				product.setPrice(price); //if during restock the operator wants to change the price
				merchFound = true;
			}
		}
		if(merchFound == false) {
			stock.add(new Product(merchandise, amount, price));
		}
	}
	
	public void removeProduct(String merchandise, int amount) {
		for(Product product : stock) {
			if(product.getName().equals(merchandise)) {
				product.removeQty(amount);
			}
		}
	}
	
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
	
	public void removeCoins(String name, int amount) {
		for(Coin coin : coinsAvailable) {
			if(coin.getName().equals(name)) {
				coin.removeCoin(amount);
			}
		}
	}
	
	public void changePrice(String name, double price) {
		for(Product product : stock) {
			if(product.getName().equals(name)) {
				product.setPrice(price);
			}
		}
	}
	
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
	
	public void buy(String productName) {
		int total = 0;
		boolean soldOut = true;
		for(Product product : stock) {
			if(product.getName().equals(productName) && product.getQty() != 0) {
				soldOut = false;
				for(Coin coin : insertedCoins) {
					total += coin.getTotal();
				}
				if(total >= product.getPrice()) {
					for(Coin coin : insertedCoins) {
						this.addCoins(coin.getName(), coin.getQty());
						coin.setQty(0);
					}
					product.removeQty(1);
				}
				else {
					System.out.println("Insufficient money to purchase the " + productName);
				}
			}
		}
		if(soldOut) {
			System.out.println(productName + " is sold out.");
		}
	}
	
	public String checkPrices() {
		String products = "";
		for(Product product : stock) {
			String twoDecimalPlaces = String.format("%.2f", product.getPrice());
			products += product.getName() + ": $" + twoDecimalPlaces + "\n";
		}
		return products;
	}
	
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
