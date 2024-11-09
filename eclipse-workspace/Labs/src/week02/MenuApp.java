package week02;

import java.util.Scanner;

public class MenuApp {

	public static void main(String[] args) {
//		Create new Scanner to receive user input
		Scanner sc = new Scanner(System.in);

//		System.out.println("Enter your name: ");
////		Store user input as a String
//		String name = sc.nextLine();
//		System.out.println("Welcome, " + name);


		int selection = 0;
		double total = 0;

		while (selection != 4) {
			System.out.println("Select an option:");
			System.out.println("1. Add candy bar to shopping cart: 1.99");
			System.out.println("2. Add milk to shopping cart: 4.97");
			System.out.println("3. Add cereal to shopping cart: 7.49");
			System.out.println("4. Check out");
			
			selection = sc.nextInt();
			
			switch (selection) {
			case 1:
				total += 1.99;
				break;
			case 2:
				total += 4.97;
				break;
			case 3:
				total += 7.49;
				break;
			case 4:
				break;
			default:
				System.out.println("Please pick a valid option.");
			}
		}

		System.out.println("Total: " + total);
		sc.close();
	}

}
