package week04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ListIceCreamMenuInput {

	static Scanner input = new Scanner(System.in);
	static List<String> iceCreamList = new ArrayList<String>();
	private static final int maxScoops = 3;
	private static List<String> options = Arrays.asList("Vanilla", "Chocolate", "Coffee", "Strawberry", "Black Raspberry", "Salted Caramel", "Birthday Cake", "Chocolate Fudge Brownie", "I'm done choosing flavors");
	
	public static void main(String[] args) {
		
		/* 
		 * **********************************************************
		 * Future enhancement -- Create a List of IceCreamOrders, 
		 * and then add the order to the list, and prompt the User and
		 * ask whether their order is complete or not.
		 ************************************************************
		 */

		ListIceCreamOrder userOrder = new ListIceCreamOrder();
		boolean finished = false;
		System.out.println("------------------------------\nWelcome to The Ice Cream Stand\n------------------------------\n");
		
		while (!finished) {
			System.out.print("Enter a name for your order: ");
			userOrder.setUser(input.nextLine());
			int counter = 0;
			boolean willOrderIceCream = true;
			int userInput = 0;
			System.out.println("\n\n" + userOrder.getUser() + ", you may choose up to 3 flavors of ice cream.\n\n");
			
			do {
				if (counter == 0) {
					printFlavorOptions();
				}
				if (counter <= 2) {
					System.out.print("Enter your selection: ");
					userInput = input.nextInt();
					switch (userInput) {
					case (1):
					case (2):
					case (3):
					case (4):
					case (5):
					case (6):
					case (7):
					case (8):
						printChoice(options.get(userInput - 1), counter);
					break;
					case (9):
						if (counter == 0) {
							System.out.println("No selection has been made! Do you want to order ice cream?");
							if (willOrderIceCream = checkOrderCancellation()) {
								userInput = 0;
								counter--;
								break;
							}
						}
					System.out.println("End of ice cream selection!\n");
					break;
					default:
						System.out.println("Invalid selection choice.");
						counter--;
					}
				}
				counter++;
			} while (userInput != 9 && counter <= 4); // exit criteria = 9
				
				/* Set field in userOrder */
				userOrder.setFlavors(iceCreamList);
				if (willOrderIceCream) {
					// Choose size
					int userInputSize = 0;
					int size = iceCreamList.size();
					if (size == maxScoops) {
						System.out.println("With 3 ice cream flavors, the size you get is: LARGE");
						userOrder.setSize("Large");
						userInputSize = size;
					} else {
						printSizeOptions();
						userInputSize = input.nextInt();
						while ((userInputSize != 1) && (userInputSize != 2) && (userInputSize != 3)) {
							System.out.print("Please enter a valid ice cream size selection: ");
							userInputSize = input.nextInt();
						}
						System.out.print("The size you have chosen is: ");
						switch (userInputSize) {
						case (1):
							System.out.println("SMALL");
							userOrder.setSize("Small");
							break;
						case (2):
							System.out.println("MEDIUM");
						userOrder.setSize("Medium");
						break;
						case (3):
							System.out.println("LARGE");
							userOrder.setSize("Large");
							break;
						}
					}
					System.out.println("\n");
					
					// Choose cup or cone
					int order = 0;
					printCupOrConeOptions();
					order = input.nextInt();
					
					while ((order != 1) && (order != 2)) {
						System.out.print("Please enter a valid entry: ");
						order = input.nextInt();
					}
					System.out.print("You have chosen a: ");
					switch (order) {
						case(1):
							System.out.println("CUP");
							userOrder.setCupOrCone("Cup");
							break;
						case(2):
							System.out.println("CONE");
							userOrder.setCupOrCone("Cone");
							break;
					}
					System.out.println("\n");
					userOrder.describe();
					System.out.println("\n");
				} else {
					System.out.println("Order cancelled.");
				}
				
				/*
				 *  **********************************************************
				 *  Future enhancement --  Add a menu here to ask the
				 *  user if they have another request to add to this order.
				 *  **********************************************************
				 */
				
				finished = true;
				
			} // end of while loop
			
			System.out.println("Goodbye -- end of order!");
			
	} // end of main
	
	public static void printFlavorOptions() {
		System.out.println();
		System.out.println("Choose ice cream flavors:");
		System.out.println("-------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(" " + (i + 1) + ") " + options.get(i));
		}
		System.out.println("------------------------------------------------");
	}
	
	public static void printCupOrConeOptions() {
		System.out.println("Choose either a CUP or a CONE for your order: ");
		System.out.println("------------------------------------------------");
		System.out.println("\t1) CUP");
		System.out.println("\t2) CONE");
		System.out.println("------------------------------------------------");
		System.out.print("Enter your selection: ");
	}
	
	public static void printChoice(String flavor, int counter) {
		System.out.println("Ice Cream Choice #" + (counter + 1) + ": " + flavor);
		System.out.println("------------------------------------------------");
		iceCreamList.add(flavor);
	}
	
	public static boolean checkOrderCancellation() {
		int check = 0;
		System.out.println();
		System.out.println("Would you like ice cream?");
		System.out.println("-------------------------");
		System.out.println("\t1) Yes, CONTINUE my order");
		System.out.println("\t2) No, CANCEL my order");
		System.out.print("Enter your selection: ");
		check = input.nextInt();
		
		while ((check != 1) && (check != 2)) {
			System.out.print("Please enter a valid entry: ");
			check = input.nextInt();
		}
		System.out.print("You have chosen: ");
		if (check == 1) {
			System.out.println("CONTINUE my order");
			System.out.println();
			return true;
		} else {
			System.out.println("CANCEL my order");
			System.out.println();
			return false;
		}
	}
	
	public static void printSizeOptions() {
		System.out.println("Choose a size for your ice cream: ");
		System.out.println("-------------------------------");
		System.out.println("\t1) SMALL -- 1 scoop");
		System.out.println("\t2) MEDIUM -- 2 scoops");
		System.out.println("\t3) LARGE -- 3 scoops");
		System.out.print("Enter your selection: ");
	}

} // end of ListIceCreamMenuInput
