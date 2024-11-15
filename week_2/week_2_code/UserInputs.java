package com.promineotech;

import java.util.Scanner;

public class UserInputs {
	public static void main(String[] args) {
		/**
		 * You can see that we use a boolean, if/else checks and the && operator.
		 */
		boolean loggedIn = false;
		Scanner sc = new Scanner(System.in);
		while (!loggedIn) {
			System.out.print("Enter username: ");
			String username = sc.nextLine();
			System.out.print("Enter password: ");
			String password = sc.nextLine();
			if (username.equals("samy1234") && password.equals("12345")) {
				System.out.println("Welcome back " + username);
				loggedIn = true;
			} else {
				System.out.println("Inaccurate credentials!");
			} 
		}
		sc.close();
	}
}
