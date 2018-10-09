package classesProject;

import java.util.ArrayList;
import java.util.Scanner;
/**	
 * Scott Arima and Howard Chen
 * 08 October 2018
 * Purpose of the program- Simulate Vending Machine with capabilities making transactions, 
 * 						   re-stocking products, withdrawing funds.  
 * Inputs: selections from vending menu
 * Output: Game Log - Displays vending actions, insufficient funds/stock.
 */
public class VendingTester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		VendingMachine vendingMachine = new VendingMachine();
		
		//Creates Products 		
		vendingMachine.restock("Sprite", 10, true, 2.50);
		vendingMachine.restock("Coke", 1, true, 1.75);
		vendingMachine.restock("Diet Coke", 10, true, 1.75);
		vendingMachine.restock("Cactus Cooler", 10, true, 2.35);
		vendingMachine.restock("Monster", 10, true, 1.99);
		
		//Menu
		String selection = "";
		while(!selection.equals("6")) {
			System.out.println("Enter a number for the following selection:\n"
					+ "-------User-------\n1. Insert Coins\n2. Check Prices\n3. Select Product\n"
					+ "-----Operator-----\n4. Restock Products\n5. Remove money\n"
					+ "------------------\n6.Exit");
			selection = in.nextLine().trim();
			if(selection.equals("1")) {
				String coin = "";
				while(!coin.equals("done")) {
					System.out.println("Enter coin name (quarter, dime, nickel, penny) or done:");
					coin = in.nextLine().trim();
					if(!coin.equals("done")) {
						System.out.println("How many of that coin:");
						String stringAmount = in.nextLine().trim();
						int amount = Integer.parseInt(stringAmount);
						vendingMachine.insertCoins(coin, amount);
					}
				}

				System.out.printf("You inserted $%.2f%n", vendingMachine.getInsertedCoinsTotals());
			}
			else if(selection.equals("2")) {
				System.out.println(vendingMachine.checkPrices() + "\n..Press enter to continue..");
				selection = in.nextLine().trim(); 
			}
			else if(selection.equals("3")) {
				String product = "";			
				System.out.println(vendingMachine.listProducts());
				System.out.println("Enter a product name (Sprite, Coke, Diet Coke, Cactus Cooler, Monster):");
				product = in.nextLine().trim();
				ArrayList<Boolean> booleanArray = new ArrayList<Boolean>(vendingMachine.buy(product)); //buys product
				if(!booleanArray.get(1)) { //Insufficient 
					System.out.println("Insufficient Funds to purchase the " + product);
				}else if (booleanArray.get(0)) {
					System.out.println(product + " is sold out.");
				}else if (!booleanArray.get(0)) {
					System.out.println("-----Dispensing " + product + "----\n" );
					System.out.println("-----" + product + " Dispensed----\n" );
				}
				System.out.println("-----Press Enter to return to menu----");
				selection = in.nextLine().trim(); 
			} else if (selection.equals("4")) {
				String product = "";
				System.out.println("Enter a product name (Sprite, Coke, Diet Coke, Cactus Cooler, Monster):");
				product = in.nextLine().trim();
				System.out.println("How many would you like to restock?");
				String stringAmount = in.nextLine().trim();
				int amount = Integer.parseInt(stringAmount);
				System.out.println("Would you like to change the price of this product? yes/no");
				String changeProduct = in.nextLine().trim();
				if(changeProduct.equals("yes")){
					System.out.println("Enter in the price: ");
					String priceString = in.nextLine().trim();
					double price = Double.parseDouble(priceString);
					vendingMachine.restock(product, amount, true, price);
				}else if(changeProduct.equals("no")) {
					vendingMachine.restock(product, amount, false, 0);				
				}
				
			}else if (selection.equals("5")) {
				vendingMachine.removeAllCoins();
				
			}
		}		
		in.close();
	}

	
}
