package com.promineotech;

import java.text.NumberFormat;
import java.util.Scanner;

public class Combined {

	public static void main(String[] args) throws Exception {
		/**
		 * This program takes input from the user then: 
		 * - Uses an if/else to make sure the data is correct or not empty 
		 * - Uses Switch statement to assign the grade based on the score entered. 
		 * - Uses a boolean to check if the user is done or wants to keep entering more scores.
		 */

		/**
		 * the boolean is to allow us to exit the program or keep accepting scores.
		 */
		boolean done = false;

		/**
		 * This special Object that reads data from standard in.
		 */
		Scanner sc = new Scanner(System.in);
		while (!done) {
			System.out.print("Enter the test score : ");
			String testScore = sc.nextLine();

			/**
			 * Make sure the String is valid by checking if it is empty.
			 */
			if (testScore.length() > 0) {
				/**
				 * Here we check to see if the user entered 'done', if so then we want to exit
				 * the program.
				 */
				if (testScore.equals("done")) {
					done = true;
					/**
					 * This will tell Java to return nothing but exit.
					 */
					return;
				} else {
					/**
					 * Now we want to make sure that we actually have a number because score are
					 * numbers and cannot be anything else.
					 * 
					 * We set the Number Object to null so we can set it in the parse method.
					 */
					Number score = null;
					try {
						score = NumberFormat.getInstance().parse(testScore);
					} catch (Exception e) {
						System.out.println(
								"The testscore was not a valid score. Please enter a valid score between 0 - 100");
						continue;
					}

					/**
					 * Convert the score to a integer for testing the conditions.
					 */
					int theScore = score.intValue();
					int scoreResult;
					if (theScore >= 90 && theScore <= 100) {
						scoreResult = 1;
					} else if (theScore >= 80 && theScore <= 89) {
						scoreResult = 2;
					} else if (theScore >= 70 && theScore <= 79) {
						scoreResult = 3;
					} else if (theScore >= 60 && theScore <= 69) {
						scoreResult = 4;
					} else {
						scoreResult = 5;
					}

					switch (scoreResult) {
					case 1:
						System.out.println("Your grade : A");
						break;
					case 2:
						System.out.println("Your grade : B");
						break;
					case 3:
						System.out.println("Your grade : C");
						break;
					case 4:
						System.out.println("Your grade : D");
						break;
					default:
						System.out.println("Your grade : F");
					}
				}
			} else {
				System.out.println("Invalid test score, please enter a valid score.");
			}
		}
		sc.close();
	}
}
