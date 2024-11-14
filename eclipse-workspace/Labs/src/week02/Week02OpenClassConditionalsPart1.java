//
// Copyright (c) 2023 Promineo Tech
// Author:  Promineo Tech Academic Team
// Subject:  Boolean & Conditionals Lab
// Java Week 02 Lab  
//
package week02;

import java.util.*;

public class Week02OpenClassConditionalsPart1 {

	public static void main(String[] args) {

		//////////// BOOLEANS and CONDITIONALS -- LESSON EXAMPLES ////////////
		//

		// 1. Variable Declaration:
		// a. Create a variable named age and assign it a value of 14

//		int age = 14;

		// 2. Print a Boolean Expression:
		// a. Print the boolean expression age >= 16 to the console and note the
		// results.
		// a. Change the value of age to 18 and print again.

//		System.out.println(age >= 16); // false
//		age = 18;
//		System.out.println(age >= 16); // true

		// 3. Can you drive?
		// a. Using a conditional, print one of the following:
		// i. "You can drive" if age is greater than or equal to 16
		// ii. "You cannot drive" otherwise

//					if (age >= 16) {
//						System.out.println("You can drive");
//					} else {
//						System.out.println("You cannot drive");
//					}
		//
		// a. Change the value of age and rerun to see the result

//		age = 13;
//		if (age >= 16) {
//			System.out.println("You can drive");
//		} else {
//			System.out.println("You cannot drive");
//		}

		// 4. Update Solution to Question 3 as follows:
		// a. Add a new variable called hasLicense before the conditional.
		// b. Change the boolean expression in the conditional to additionally
		// include the need for hasLicense to be true.
		// c. Try changing the values of age and hasLicense and note the different
		// results.

//		age = 21;
//		boolean hasLicense = false;
//
//		if (age >= 16 && hasLicense == true) {
//			System.out.println("You can drive");
//		} else {
//			System.out.println("You cannot drive");
//		}

		// 5. Milk?
		// a. Create two new variables - costOfMilk and thirstLevel
		// b. Create a new conditional that prints "Milk Please" if costOfMilk is less
		// than 2.50
		// or if thirstLevel is greater than 6 and prints "No Thanks" otherwise.
		// c. Change the values and note the different results.

//		double costOfMilk = 4.95;
//		int thirstLevel = 7;
//
//		if (costOfMilk < 2.50 || thirstLevel > 6) {
//			System.out.println("Milk Please");
//		} else {
//			System.out.println("No Thanks");
//		}

		// 6. Cookie Distribution:
		// Note: You will evenly distribute all of the cookies to the children
		// and as the adult you get to keep the remaining cookies for yourself.
		//
		// a. Create two variables called numberOfCookies and numberOfChildren.
		// b. Initialize the two variables to integer values.
		// b. Use a conditional to print the following based on the following
		// conditions:
		// i. If there are 0 cookies remaining, print "Sad Face"
		// ii. If there are less than 2 cookies, print "Yes!"
		// iii. If there are less than 5 cookies, print "Whoohoooo!"
		// iv. If there are 5 or more cookies, print "Jackpot!"

//		int numberOfCookies = 20;
//		int numberOfChildren = 14;
//		
//		int result = numberOfCookies % numberOfChildren;
//		
//		if (result == 0) {
////			System.out.println(result);
//			System.out.println("Sad Face");
//		} else if (result < 2) {
////			System.out.println(result);
//			System.out.println("Yes!");
//		} else if (result < 5) {
////			System.out.println(result);
//			System.out.println("Whoohoooo!");
//		} else {
////			System.out.println(result);
//			System.out.println("Jackpot!");
//		}

//		Q: Can we assume cookies remain whole?
//		i.e. if cookies cannot be divided evenly
//		among children, does adult keep _all_ cookies?

//		Q: For time/space optimization, does it make sense to use memory 
//		(i.e. create 'result' variable)
//		or to repeat the calculation w/o using extra storage?

		// 7. Loyalty Member Program:
		// a. Create a variable called loyaltyMemberStatus and assign the value "SILVER"
		// b. Create a variable called loyaltyMemberDiscount and assign the value 0.0
		// c. Using a switch, set the value of loyaltyMemberDiscount based on
		// the following loyaltyMemberStatus scale:
		// i. "SILVER" is 0.10
		// ii. "GOLD" is 0.15
		// iii. "PLATINUM" is 0.25

//		String loyaltyMemberStatus = "SILVER";
//		double loyaltyMemberDiscount = 0.0;
//
//		switch (loyaltyMemberStatus) {
//		case "SILVER":
//			loyaltyMemberDiscount = 0.10;
//		case "GOLD":
//			loyaltyMemberDiscount = 0.15;
//		case "PLATINUM":
//			loyaltyMemberDiscount = 0.25;
//		default:
//			break;
//		}

		// 8. Using the Loyalty Member Program variables from Question 7, do the
		// following:
		// a. Create a variable called billTotal and assign a value
		// b. Create a variable called adjustedTotal and assign it the billTotal minus
		// the loyaltyMemberDiscount percent of the billTotal
		// c. If the adjustedBillTotal is greater than $500 upgrade the
		// loyaltyMemberStatus from SILVER to GOLD or from GOLD to PLATINUM

//		double billTotal = 1000;
//		double adjustedBillTotal = billTotal - loyaltyMemberDiscount * billTotal;
//
//		if (adjustedBillTotal > 500) {
//			if (loyaltyMemberStatus == "SILVER") {
//				loyaltyMemberStatus = "GOLD";
//			} else {
//				loyaltyMemberStatus = "PLATINUM";
//			}
//		}

//		System.out.println(
//				"Your total comes to $" + adjustedBillTotal + " and your member status is " + loyaltyMemberStatus);

		// 9. Login -- username & password:
		// a. Create two variables, username and password
		// b. Create a conditional that prints one of the following:
		// i. "login successful" if the username is "Tommy123" and the password is
		// "12345"
		// ii. "access denied" otherwise

//		String username = "Tommy123";
//		String password = "12345";
//
//		if (username.equals("Tommy123") && password.equals("12345")) {
//			System.out.println("login successful");
//		} else {
//			System.out.println("access denied");
//		}

		//
		// LOOPS:
		//

		// 10. Write a for loop that prints each number from 0 to 9

//		for (int i = 0; i <= 9; i++) {
//			System.out.println(i);
//		}

		// 11. Write a for loop that prints each number from 10 to 0 backwards

//		for (int i = 10; i >= 0; i--) {
//			System.out.println(i);
//		}

		// 12. Write a for loop that prints every other number from 0 to 100

//		for (int i = 0; i < 101; i++) {
//			if (i % 2 == 0) {
//				System.out.println(i);
//			}
//		}

		// 13. Write a for loop that iterates from 0 to 100 and prints
		// "EVEN" if the number is even and "ODD" if it's odd

//		for (int i = 0; i < 101; i++) {
//			if (i % 2 == 0) {
//				System.out.println("EVEN");
//			} else {
//				System.out.println("ODD");
//			}
//		}

		// 14. Write a while loop that starts at 100 and iterates backwards by 1 until
		// it reaches 0
		// within the loop, divide each number by 3 and print the remainder to the
		// console.

//		int i = 100;
//
//		while (i > 0) {
//			i--;
//			System.out.println(i % 3);
//		}
//		
//		
//		
		//////////// OPEN CLASS PROBLEMS: ////////////
//		
//		
		Scanner in = new Scanner(System.in);
//		
//		
//		
//		1. Old Enough to Vote?
//
//		Given the variable age, create an if/else statement that checks if 
//		the value stored in age is old enough to vote.
//		- If the age is greater than or equal to 18, then print "You are 
//		old enough to vote."
//		- If the age is not, then print "You are not old enough to vote."
//		
//		
//		int age = in.nextInt();
//		
//		if (age >= 18) {
//			System.out.println("You are old enough to vote.");
//		} else {
//			System.out.println("You are not old enough to vote.");
//		}
//		
//		
//		
//		2. True or False: In Java, a variable has to be declared before it is used.
//		True
//		
//		
//		
//		3. Is This String Long?
//
//		Given the variable randomWord, create an if/else statement that 
//		checks the length of the String in variable randomWord
//		- If the word contains 10 or more characters, print "That is a 
//		really long word!"
//		- Otherwise, print "Your word is not that long."
//		
//		String randomWord = in.next();
//		
//		if (randomWord.length() >= 10) {
//			System.out.println("That is a really long word!");
//		} else {
//			System.out.println("Your word is not that long.");
//		}
//		
//		test #1: exceptionally
//		Output: long word
//		
//		test #2: Java
//		Output: not long word
//		
//		test #3: programming
//		Output: long word
//		
//		test #4: small
//		Output: not long word
//		
//		test #5: inconsequential
//		Output: long word
//		
//		test #6: perfectionist
//		Output: long word
//		
//		test #7: super
//		Output: not long word
//		
//		
//		
//		4. True/False: Java is a strongly-typed language.
//		True;
//		Java requires the declaration of every variable with a data type. 
//		A variable can not be created without the range of values it can 
//		hold. Once declared, the data type of the variable cannot be changed.
//		
//		
//		
//		5. Smaller, Larger or Equal?
//
//		Given the variables num1 and myNumber, create an if/else if statement 
//		that compares myNumber to num1. Based on which condition evaluates to 
//		true, print one of the following messages:
//		- num1 + " is smaller than my number, " + myNumber
//		- num1 + " is larger than my number, " + myNumber
//		- num1 + " is equal to my number, " + myNumber
//		
//		int num1 = 156;
//		int myNumber = in.nextInt();
//		
//		if (num1 < myNumber) {
//			System.out.println(num1 + " is smaller than my number, " + myNumber);
//		} else if (num1 > myNumber) {
//			System.out.println(num1 + " is larger than my number, " + myNumber);
//		} else {
//			System.out.println(num1 + " is equal to my number, " + myNumber);
//		}
//		
//		
//		
//		6. Which of the following is the correct syntax to print a full name 
//		using the Java programming language System.out.println(), 
//		given a firstName and a lastName?
//		
//		A. System.out.println(firstName + " " + lastName)
//		B. System.out.println(firstName + " " + lastName);
//		C. System.out.println(firstName + lastName);
//		D. System.out.println(firstName + lastName)
//
//		B.
//
//
//
//		7. Which Day Is The Hottest?
//
//		Given three variables, sundayTemp, mondayTemp, and tuesdayTemp, write 
//		a program that will determine which day is the hottest.
//		
//		- If sundayTemp is the highest, print "Sunday"
//		- If mondayTemp is the highest, print "Monday"
//		- If tuesdayTemp is the highest, print "Tuesday"
//		- Assume that none of the temperatures are the same
//		
//		double sundayTemp = in.nextDouble();
//		double mondayTemp = in.nextDouble();
//		double tuesdayTemp = in.nextDouble();
//		
//		if (sundayTemp > mondayTemp && sundayTemp > tuesdayTemp) {
//			System.out.println("Sunday");
//		} else if (mondayTemp > sundayTemp && mondayTemp > tuesdayTemp) {
//			System.out.println("Monday");
//		} else {
//			System.out.println("Tuesday");
//		}
//		
//		
//		
//		8. What would be the correct Java data type to use when declaring a 
//		variable to store the price of a grocery store item?
//		A. double
//		B. short
//		C. int
//		
//		A
//		
//		
//		
//		9. Who Is the Oldest?
//
//		Given three variables, personOneAge, personTwoAge, and personThreeAge, 
//		write a program that will determine who is the oldest.
//		
//		- If Person one is the oldest, print "Person one is the oldest."
//		- If Person two is the oldest, print "Person two is the oldest."
//		- If Person three is the oldest, print "Person three is the oldest."
//		- Assume that no one is the same age
//		
//		int personOneAge = in.nextInt();
//		int personTwoAge = in.nextInt();
//		int personThreeAge = in.nextInt();
//		
//		if (personOneAge > personTwoAge && personOneAge > personThreeAge) {
//			System.out.println("Person one is the oldest.");
//		} else if (personTwoAge > personOneAge && personTwoAge > personThreeAge) {
//			System.out.println("Person two is the oldest.");
//		} else {
//			System.out.println("Person three is the oldest.");
//		}
//		
//		
//		
//		10. True/False: In Java, an else is always required when using 
//		an if conditional statement.
//		False
//		
		in.close();
	}

}