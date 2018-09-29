import java.util.Scanner;

public class VendingTester {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//Creates Products 
		Product sprite = new Product("Sprite", 500, 2.50);
		Product.productList.add(sprite);  //S
		Product coke = new Product("coke", 20, 1.50);
		Product.productList.add(coke);   // Sprite, Coke
		Product dietCoke = new Product("Diet Coke", 500, 2.50);
		Product.productList.add(dietCoke); // Sprite, Coke, DietCoke
		Product cactusCooler = new Product("Cactus Cooler", 500, 2.50);
		Product.productList.add(cactusCooler); // Sprite, Coke, Diet Coke, CactusCooler
		Product monster = new Product("Monster", 500, 3.50);
		Product.productList.add(monster);  // Sprite, Coke, Diet Coke, CactusCooler
		
		
		String selection;
		//Menu
		System.out.println("Enter a number for the following "
				+ "Selection:\n1.Insert Coins\n2.Check Prices\n"
				+ "3.Restock Products\n4.Exit");
		selection = in.nextLine();
		if( selection.equals("1")) {
			System.out.println("Enter in coin(quarter,dime,nickel,penny):");
			selection = in.nextLine();
		}else if (selection.equals("2")) {
			for(int i = 0; i< Product.productList.size(); i++) {
				
			}
		}
		
		
		
	}

}
