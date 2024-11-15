package com.promineotech;

import java.util.Scanner;

public class Conditionals {

	public static void main(String[] args) {
		/**
		 * Simple if else check for an age.
		 */
		int age = 19;
		if (age < 21) {
			System.out.println("You need to be 21 or older.");
		} else {
			System.out.println("You are old enough.");
		}

		/**
		 * Here is a way to check a range using conditional statements.
		 */
		int start = 51;
		int stop = 74;

		/**
		 * This is showing how we can include to variables in a condition and use ><
		 * plus the && = and, || = or operation to check our ranges. if() {
		 * 
		 * } else {
		 * 
		 * }
		 * 
		 * of
		 * 
		 * if() {
		 * 
		 * } else if() {
		 * 
		 * }
		 */
		if (start > 50 && stop < 74) {

			System.out.println("start is > 50 and stop < 74");

		} else if (start > 50 && stop < 75) {

			System.out.println("start is > 50 and stop < 75");

		} else if (start < 50 || stop > 73) {

			System.out.println("start < 50 or stop > 73");
		}

		/**
		 * Boolean are always true or false the Not Operator '!'
		 */
		boolean isCool = true;
		if (!isCool) {
			System.out.println("It's Cool!");
		} else {
			System.out.println("Not Cool!");
		}

		int test;
		long bigNumber;
		float data;

		String myString = "TheTest";
		if (myString == "Thetest") {
			System.out.println("They match.");
		} else {
			System.out.println("Nope.");
		}

		if (myString.equals("TheTest")) {
			System.out.println("They match.");
		} else {
			System.out.println("Nope.");
		}

		Scanner in = new Scanner(System.in);
		String randomWord = in.next();

		System.out.println(randomWord);

		int length = randomWord.length();
		if (length >= 10) {
			System.out.println("That is a really long word!");
		} else {
			System.out.println("Your word is not that long.");
		}

		in.close();
	}
}
