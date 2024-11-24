package week04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapMenuApplication {

	static Scanner scanner = new Scanner(System.in);
	static Map<String, String> phoneBook = new HashMap<String, String>();
	
	public static void main(String[] args) {
		
		int choice = 0;
		
		while (choice != 4) {
			printMenu();
			choice = getUserChoice();
			
			if (choice == 1) {
				displayPhoneBook();
			} else if (choice == 2) {
				addContact();
			} else if (choice == 3) {
				deleteContact();
			} else if (choice == 4) {
				System.out.println("Goodbye");
			} else {
				System.out.println("Please pick a valid option.");
			}
			
		}
		
	} // end of main
	
	public static void printMenu() {
		System.out.println("1) Display phone book");
		System.out.println("2) Add new contact");
		System.out.println("3) Delete contact");
		System.out.println("4) Exit");
		System.out.println("----------------------");
	}

	public static int getUserChoice() {
		return scanner.nextInt();
	}
	
	public static void displayPhoneBook() {
		Set<String> phoneNumbers = phoneBook.keySet();
		for (String phoneNumber : phoneNumbers) {
			System.out.println(phoneNumber + ": " + phoneBook.get(phoneNumber));
		}
	}
	
	public static void addContact() {
		System.out.print("Enter phone number: ");
		String phoneNumber = scanner.next();
		System.out.print("Enter name: ");
		String name = scanner.next();
		
		phoneBook.put(phoneNumber, name);
		System.out.println("Added " + phoneNumber + ": " + name);
	}
	
	public static void deleteContact() {
		System.out.print("Enter phone number to delete: ");
		String phoneNumber = scanner.next();
		if (phoneBook.get(phoneNumber) == null) {
			System.out.println("Contact does not exist");
			phoneNumber = scanner.next();
		} else {
			System.out.println("Removed: " + phoneNumber + ": " + phoneBook.remove(phoneNumber));
		}
	}
	
}
