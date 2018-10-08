package classesProject;

import java.util.Scanner;

public class VendingTester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		VendingMachine vendingMachine = new VendingMachine();
		
		//Creates Products 		
		vendingMachine.restock("Sprite", 10, 2.50);
		vendingMachine.restock("Coke", 10, 1.75);
		vendingMachine.restock("Diet Coke", 10, 1.75);
		vendingMachine.restock("Cactus Cooler", 10, 2.35);
		vendingMachine.restock("Monster", 10, 1.99);
		
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
			}else if (selection.equals("2")) {
				System.out.println(vendingMachine.checkPrices());
			}
		}		
	}

	
}
