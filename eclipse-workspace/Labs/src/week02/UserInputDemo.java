package week02;

import java.util.Scanner;

public class UserInputDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // System.in is a standard input stream
		boolean loggedIn = false;
		int attempts = 0;

		while (!loggedIn && attempts < 3) {
			System.out.print("Enter username: ");
			String username = sc.nextLine();

			System.out.print("Enter password: ");
			String password = sc.nextLine();

			if (username == "" || password == "") {
				System.out.println("Please enter both a username and password.\n");
			} else if (username.equals("admin") && password.equals("verysecure")) {
				loggedIn = true;
				System.out.println("\nWelcome back, " + username);
			} else {
				attempts++;
				System.out.println("\nIncorrect username or password.");
				System.out.println(attempts + "/3 incorrect attempts\n");
				if (attempts == 3) {
					System.out.println("Too many failed attempts.");
				}
			}

		}
		sc.close();

	}

}
