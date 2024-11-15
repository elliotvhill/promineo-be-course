package com.promineotech;

public class BooleanOperations {

	public static void main(String[] args) {
		/**
		 * Let's look at using math terms for greater than, less than, or equal too.
		 * 
		 * In math, we use this all the time to compare numbers. Let's look at some
		 * examples.
		 */

		/**
		 * In English, we would say if the age value < the required number, don't allow
		 * to continue, otherwise if the age = 21 or over then continue.
		 * 
		 * In this statement, we want to check the age value against another value to
		 * determine what to do. See the code below.
		 * 
		 */

		/**
		 * Here we are using an if/else statement to either disallow the user or allow
		 * them to continue. As you can see below this is how we compare integers using
		 * < than and greater than and equal too.
		 * 
		 * Here list of these types of operators. You use them to
		 * determine logic based on 2 values and the result is either true or false.
		 * 
		 // @formatter:off
		 *  < Less than
		 *  > Greater than 
		 *  <= Less than or Equal too.
		 *  => Greater than or Equal too.
		 *  == Identical Equal
		 // @formatter:on
		 */
		int age = 20;
		if (age < 21) {
			// Don't allow the user to continue because age < 21
			System.out.println("Sorry you are not old enough.");
		} else if (age >= 21) {
			// The user is at least 21 or older so the can continue.
			System.out.println("You are old enough.");
		}

		/**
		 * In math we use range checking all time, let's check to see if a number falls
		 * within a range of numbers. Below we are using an && which means both
		 * conditions have to be true. Since the number we are checking is 9, the number
		 * is less then 100 but is not greater then 10.
		 * 
		 * The code below should print: Number is not within the range, because the
		 * number is not within the range.
		 */
		int range = 9;
		if (range <= 100 && range >= 10) {
			// If the number 10 or greater AND less than or equal to 100.
			System.out.println("Number is within the range.");
		} else {
			// The number was not within the range.
			System.out.println("Number is not within the range.");
		}

		/**
		 * Lets look at this if the number can be one OR the other. Here we us the ||
		 * operator. The code should print: Number is within the range, because 1 of the
		 * conditions is true and we are using the || operator.
		 */
		range = 9;
		if (range <= 100 || range >= 10) {
			// If the number is 10 or greater AND less than or equal to 100.
			System.out.println("Number is within the range.");
		} else {
			// The number was not within the range.
			System.out.println("Number is not within the range.");
		}

		/**
		 * Remember if/else conditions are used to evaluate a statement that is true or
		 * not. For example: if(true && true && true || false)
		 * 
		 * The above code means that there has to be 3 true values and maybe 1 false.
		 * Let's look at more complex example with comments. Let's take into
		 * consideration grading. I want to check the score of a test and print out the
		 * grade. This will required 2 things, check the range AND print the grade.
		 * Grades fall within a range, for example: 80 - 83 = 'B-' and for forth.
		 */
		int theScore = 78;

		/**
		 * So we take the score value and check to see if it falls within a range. For
		 * example, if the score is equal to or greater than 90 AND less than or equal
		 * to 100 prints an 'A'.
		 * 
		 * So in order for us to print an 'A' both sides of the condition have to be
		 * true. See below, if the score does not pass, it will go to the next
		 * condition.
		 * 
		 * if (theScore >= 90 && theScore <= 100)
		 * 
		 */

		if (theScore >= 90 && theScore <= 100) {
			System.out.println("Score is an A");
		} else if (theScore >= 80 && theScore <= 89) {
			System.out.println("Score is an B");
		} else if (theScore >= 70 && theScore <= 79) {
			System.out.println("Score is an C");
		} else if (theScore >= 60 && theScore <= 69) {
			System.out.println("Score is an D");
		} else {
			System.out.println("Score is an F");
		}

		/**
		 * Sometimes you want to check if a value is equal to a specific number or
		 * value. We can check this by using the '==' operator.
		 * 
		 * Let say I want to see if I got 100% percent on a test. If the score is not
		 * exactly 100, then we do something else.
		 */
		int testScore = 100;
		if (testScore == 100) {
			// testScore was exactly 100
			System.out.println("Score is exactly 100");
		} else {
			// testScore was not 100
			System.out.println("Score is not 100");
		}

		/**
		 * We can also check the Strings data types in case we want to see if the String
		 * is equal to another String.
		 */
		String myString = "TheTest";
		if (myString == "Thetest") {
			// The String was a perfect match
			System.out.println("They match.");
		} else {
			// String did not match
			System.out.println("Nope.");
		}

		if (myString.equals("TheTest")) {
			// The String was a perfect match
			System.out.println("They match.");
		} else {
			// String did not match
			System.out.println("Nope.");
		}

	}

}
