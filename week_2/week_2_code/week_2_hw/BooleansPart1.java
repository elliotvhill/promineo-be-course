package com.promineotech.hw;

import java.util.Scanner;

public class BooleansPart1 {

	/**
	 * A comment
	 */
	// There other comment
	public static void main(String[] args) {
		try {
			// question1();
			// question2();
			// question3();
			// question4();
			// question5();
			// question6();
			// question7();
			// question8();
			question9();
			// question11();
			// question12();
			// question13();
			// question14();
			// question15();
			// question16();
			// question17();
			// question18();
			// question19();
			// question20();
			// test();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Given two integer variables, a and b, write a Boolean Expression that will
	 * check if a is less than b AND if b is greater than 100. Print the result to
	 * the console.
	 */
	public static void question1() {
		Scanner in = new Scanner(System.in);
		int a, b;
		a = in.nextInt();
		b = in.nextInt();

		/***** DO NOT CHANGE THE CODE ABOVE THIS LINE *****/
		if (a < b && b > 100) {
			System.out.println("a is less then b, b is greater then 100");
		} else {
			System.out.println("a is less or equal to b, b is less then 100");
		}
		in.close();
	}

	/**
	 * What will the following code print to the console?
	 */
	public static void question2() {
		System.out.println("hello world".charAt(0) != 'H');
	}

	/**
	 * Write a program that takes in three given boolean values: a, b, and c.
	 * 
	 * Declare a variable named result that is a boolean, set it equal to a
	 * statement that compares if a AND b are true OR if a AND c are true, OR if b
	 * AND c are true
	 * 
	 * Print the value of result to the console The program should print true if two
	 * of the values are true, and "false" otherwise
	 */
	public static void question3() {
		Scanner in = new Scanner(System.in);
		boolean a = in.nextBoolean();
		boolean b = in.nextBoolean();
		boolean c = in.nextBoolean();
		boolean result;
		/***** DO NOT CHANGE THE CODE ABOVE THIS LINE ******/
		if ((a && b) || (a && c) || (b && c)) {
			result = true;
		} else {
			result = false;
		}
		System.out.println(result);
		in.close();
	}

	public static void question4() {
		int x = 25;
		int y = 20;
		int z = 10;

		boolean result = x > y && x > z;
		System.out.println(result);
	}

	/**
	 * Given four variables num1, num2, num3, and num4, create a Boolean Expression.
	 * If num1 is greater than num2 OR num3 is less than num4, then true should
	 * print to the console Otherwise, false should print to the console.
	 */
	public static void question5() {
		Scanner in = new Scanner(System.in);
		int num1, num2, num3, num4;
		num1 = in.nextInt();
		num2 = in.nextInt();
		num3 = in.nextInt();
		num4 = in.nextInt();

		boolean isValid;
		/***** DO NOT CHANGE THE CODE ABOVE THIS LINE *****/
		if (num1 > num2 || num3 < num4) {
			isValid = true;
		} else {
			isValid = false;
		}
		System.out.println(isValid);
		in.close();
	}

	public static void question6() {
		int tokens = 12;
		int costToPlayArcadeGame = 3;

		System.out.println(tokens < costToPlayArcadeGame);
	}

	/**
	 * Given the variables a and b, write a Boolean Expression that checks if either
	 * is true. Check to see if the value of a is true OR if the value of b is true
	 * Print the result to the console
	 */
	public static void question7() {
		Scanner in = new Scanner(System.in);
		boolean a = in.nextBoolean();
		boolean b = in.nextBoolean();
		boolean result;
		/***** DO NOT CHANGE THE CODE ABOVE THIS LINE *****/
		if (a || b) {
			result = true;
		} else {
			result = false;
		}
		System.out.println(result);
		in.close();
	}

	public static void question8() {
		System.out.println((10 > 5) || (5 < 1));
	}

	/**
	 * Given variables x and y, write an expression that says x is less than y and
	 * negate that expression with !. Print the result of that expression to the
	 * console. Hint: Use the ! operator.
	 */
	public static void question9() {
		Scanner in = new Scanner(System.in);
		int x, y;
		x = in.nextInt();
		y = in.nextInt();
		/***** DO NOT CHANGE THE CODE ABOVE THIS LINE *****/
		if ((x < y) != true) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
		in.close();
	}

	public static void question10() {

	}

	/**
	 * !True
	 * 
	 * Write a program that takes in three boolean inputs a, b, c and checks if a
	 * statement is true or false. Check to see if a AND b is true OR if c OR NOT b
	 * is true. Set the value of that equal to a boolean variable called result
	 * Print result to the console
	 */
	public static void question11() {
		Scanner in = new Scanner(System.in);
		boolean a = in.nextBoolean();
		boolean b = in.nextBoolean();
		boolean c = in.nextBoolean();
		/***** DO NOT CHANGE THE CODE ABOVE THIS LINE *****/
		if ((a && b) || (c || !b)) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
		in.close();
	}

	public static void question12() {
		System.out.println(!false && (true && !true));
	}

	/**
	 * Discounts are awarded if a person is a student OR if they are under the age
	 * of 18. Using an integer variable called age and a boolean variable called
	 * isStudent, write an if/else statement that checks if age is under 18 or if
	 * isStudent is true. If age is less than 18 years old or isStudent is true then
	 * print to the console "You get a discount!" Else, print "Sorry, no discount
	 * for you."
	 */
	public static void question13() {
		Scanner in = new Scanner(System.in);
		int age;
		boolean isStudent;
		age = in.nextInt();
		isStudent = in.nextBoolean();
		/***** DO NOT CHANGE THE CODE ABOVE THIS LINE *****/
		if (age < 18 || isStudent) {
			System.out.println("You get a discount!");
		} else {
			System.out.println("Sorry, no discount for you.");
		}
		in.close();
	}

	public static void question14() {
		int num = 9;
		boolean result = (num % 2 == 0 || num % 5 == 0);
		if (result) {
			System.out.println("The number is either even or a multiple of 5");
		} else {
			System.out.println("The number is neither even nor a multiple of 5");
		}
	}

	/**
	 * Given four integer variables moneyInBank, rentDue, carPayment, and food,
	 * write a conditional that will check if there's enough money for the bills.
	 * Declare an int variable called billSum and set it equal to the sum of
	 * rentDue, carPayment, and food
	 * 
	 * If moneyInBank is greater than or equal to billSum, print "You have enough
	 * money this week." to the console Else, print "You may need to borrow some
	 * money."
	 */
	public static void question15() {
		Scanner in = new Scanner(System.in);
		int moneyInBank, rentDue, carPayment, food;
		moneyInBank = in.nextInt();
		rentDue = in.nextInt();
		carPayment = in.nextInt();
		food = in.nextInt();
		brokeOrNot(moneyInBank, rentDue, carPayment, food);
		in.close();
	}

	public static void brokeOrNot(int moneyInBank, int rentDue, int carPayment, int f) {
		/***** DO NOT CHANGE THE CODE BELOW THIS LINE *****/
		int billSum = f + rentDue + carPayment;
		if (moneyInBank >= billSum) {
			System.out.println("You have enough money this week.");
		} else {
			System.out.println("You may need to borrow some money.");
		}
	}

	public static void question16() {
		System.out.println((-2 < -1) || ((10 > 3) && false));
	}

	/**
	 * Can I Pass The Class? In this problem, you are given four variables of type
	 * double called assignment1, assignment2, assignment3, and assignment4. To pass
	 * the class you need to have the sum of assignment1 and assignment2 be greater
	 * than 150.0 AND either assignment3 OR assignment4 needs to be greater than
	 * 70.0. Write an if/else statement that checks these parameters If you can pass
	 * the class, print this statement to the console: "You passed the class."
	 * Otherwise, print "You failed the class."
	 */
	public static void question17() {
		Scanner in = new Scanner(System.in);
		double assignment1, assignment2, assignment3, assignment4;
		assignment1 = in.nextDouble();
		assignment2 = in.nextDouble();
		assignment3 = in.nextDouble();
		assignment4 = in.nextDouble();
		/***** DO NOT CHANGE THE CODE ABOVE THIS LINE *****/
		double totals = assignment1 + assignment2;
		if (totals > 150 && (assignment3 > 70 || assignment4 > 70)) {
			System.out.println("You passed the class.");
		} else {
			System.out.println("You failed the class.");
		}
		in.close();
	}

	public static void question18() {
		boolean isRaining = true;
		if (!isRaining) {
			System.out.println("It's not raining, so I can go for a walk.");
		} else {
			System.out.println("It's raining, so I'll stay indoors.");
		}
	}

	/**
	 * To be or Not to be a Vowel, that is the question?
	 * 
	 * Given a variable named letter of type char. Create an if/else statement to
	 * check to see if the character stored in the variable letter is a vowel or a
	 * consonant. The if statement should have the variable letter equal to each
	 * vowel separated by the || operator If the character is a vowel, then print
	 * "It's a vowel!" Else, print "It's a consonant!"
	 */
	public static void question19() {
		Scanner in = new Scanner(System.in);
		char a;
		a = in.nextLine().charAt(0);
		aeiou(a);
		in.close();
	}

	public static void aeiou(char letter) {
		if (isVowelBySwitch(letter)) {
			System.out.println("It's a vowel!");
		} else {
			System.out.println("It's a consonant!");
		}
	}

	public static boolean isVowelBySwitch(char c) {
		switch (c) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
		case 'A':
		case 'E':
		case 'I':
		case 'O':
		case 'U':
			return true;
		default:
			return false;
		}
	}

	public static void question20() {
		int num = 15;
		System.out.println(num % 2 == 0 && num % 3 == 0);
	}

	public static void test() {
		// !
		boolean isCool = false;
		if (isCool == true) {
			System.out.println("True");
		} else if (isCool == false) {
			System.out.println("False");
		}
	}

}
