package com.promineotech; // file structure
import java.util.Scanner; // java util library class

public class MyTest {

	public static void main(String[] args) {
		
		// System in and out
		Scanner in = new Scanner(System.in);
		String username;
		String password;
		username = in.nextLine();
		// password = in.nextLine();
		
		// < > != == && ||
		// if age is greater than or equal to 55 AND is less than 75
		// && - AND 
		// || - OR
		if(username.isEmpty()) {
			System.out.println("Not a valid user.");
		} else {
			// username must be 10 or greater or less then or equal to 50
			if(username.length() >= 10 || username.length() <= 50) {
				System.out.println("You are a valid user.");
			} else {
				System.out.println("Not a valid user.");
			}
		}
	}
}