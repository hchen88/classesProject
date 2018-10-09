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
		Scanner in = new Scanner(System.in); // Scanner object to store inputs
		
		VendingMachine vendingMachine = new VendingMachine(); //creates a Vending Machine object
		//Creates Products 		
		vendingMachine.restock("Sprite", 10, true, 2.50);
		vendingMachine.restock("Coke", 1, true, 1.75);
		vendingMachine.restock("Diet Coke", 10, true, 1.75);
		vendingMachine.restock("Cactus Cooler", 10, true, 2.35);
		vendingMachine.restock("Monster", 10, true, 1.99);
		
		//Menu
		String selection = "";
		while(!selection.equals("6")) {
			//Prints Menu for Vending Machine
			System.out.println("Enter a number for the following selection:\n"
					+ "-------User-------\n1. Insert Coins\n2. Check Prices\n3. Select Product\n"
					+ "-----Operator-----\n4. Restock Products\n5. Remove money\n"
					+ "------------------\n6.Exit");
			selection = in.nextLine().trim(); // reads in selection as a String
			if(selection.equals("1")) {
				String coin = "";
				while(!coin.equals("done")) {
					System.out.println("Enter coin name (quarter, dime, nickel, penny) or done:"); //Prompts user for type of coin to insert
					coin = in.nextLine().trim();
					if(!coin.equals("done")) {
						System.out.println("How many of that coin:"); // Prompst user for qty of coins to insert
						String stringAmount = in.nextLine().trim(); //reads in amount in string variable
						int amount = Integer.parseInt(stringAmount); // converts from string to int variable
						vendingMachine.insertCoins(coin, amount); // calls insertCoins method in Vending Machine class
					}
				}

				System.out.printf("You inserted $%.2f%n", vendingMachine.getInsertedCoinsTotals()); //Displays the coin total inserted
				System.out.println("-----Press Enter to return to menu----"); 
				selection = in.nextLine().trim(); 
			}
			else if(selection.equals("2")) {
				System.out.println(vendingMachine.checkPrices() + "\n..Press enter to continue.."); 
				// calls checkPrices method to output prices of each product tin vending Machine
				selection = in.nextLine().trim(); 
			}
			else if(selection.equals("3")) {
				String product = "";			
				System.out.println(vendingMachine.listProducts()); //calls the method listProducts in Vending machine to print out list of Products
				//Prompts user to enter in Product to purchase
				System.out.println("Enter a product name to purchase:");
				product = in.nextLine().trim();
				//calls the buy method in the vending machine class and returns a 
				//boolean ArrayList to print out Insufficient funds or sold out message.
				ArrayList<Boolean> booleanArray = new ArrayList<Boolean>(vendingMachine.buy(product)); // buys product 
				if(!booleanArray.get(1)) { //Insufficient 
					System.out.println("Insufficient Funds to purchase the " + product);  // outputs Insufficent Funds
				}else if (booleanArray.get(0)) {
					System.out.println(product + " is sold out."); // product is sold out
				}else if (!booleanArray.get(0)) {
					System.out.println("-----Dispensing " + product + "----\n" ); //product purchased and dispensing
					System.out.println("-----" + product + " Dispensed----\n" );
				}
				System.out.println("-----Press Enter to return to menu----"); 
				selection = in.nextLine().trim(); 
			} else if (selection.equals("4")) { //Operator Restock Selection
				String product = "";
				System.out.println("Enter a product name (Sprite, Coke, Diet Coke, Cactus Cooler, Monster):"); // Prompts operator for Produc to restock
				product = in.nextLine().trim();
				System.out.println("How many would you like to restock?"); // Prompts operator qty of restock
				String stringAmount = in.nextLine().trim();
				int amount = Integer.parseInt(stringAmount);
				// Prompts user to change price of product or keep original price
				System.out.println("Would you like to change the price of this product? yes/no"); 
				String changeProduct = in.nextLine().trim();
				if(changeProduct.equals("yes")){ // operator decides to change price
					System.out.println("Enter in the price: "); //  prompts user for the price to change it to
					String priceString = in.nextLine().trim();
					double price = Double.parseDouble(priceString);
					vendingMachine.restock(product, amount, true, price); 
				}else if(changeProduct.equals("no")) { // operator chooses to keep price
					vendingMachine.restock(product, amount, false, 0);	// 	just restocks the product with default price		
				}
				
			}else if (selection.equals("5")) { // operator selection to remove money
				// calls method to remove all coins from vending machine then prints the amount removed
				System.out.println(vendingMachine.removeAllCoins()); 
				System.out.println("-----Press Enter to return to menu----"); 
				selection = in.nextLine().trim(); 
				
			}
		}		
		in.close(); //closes Scanner object
	} 

	
}
