package week02;

import java.util.*;

public class Week02OpenClassBooleansPart2 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
//
//		11. !True
//		Write a program that takes in three boolean inputs a, b, c and checks 
//		if a statement is true or false.
//		
//		- Check to see if a AND b is true OR if c OR NOT b is true.
//		- Set the value of that equal to a boolean variable called result
//		- Print result to the console
//		
//		boolean a = in.nextBoolean();
//		boolean b = in.nextBoolean();
//		boolean c = in.nextBoolean();
//		
//		boolean result = (a && b) || (c || !b);
//		
//		System.out.println(result);
//		
//		Input: true, false, true
//		Output: true
//		
//		Input: false, false, false 
//		Output: true
//		
//		Input: true, true, true
//		Output: true
//		
//		Input: false, true, false
//		Output: false
//		
//		
//		
//		12. What will print to the console when the following code runs?
//		
//		System.out.println(!false && (true && !true));
//		Output: false
//		
//		
//		13. Can I have a discount?
//		
//		Discounts are awarded if a person is a student OR if they are under the 
//		age of 18. Using an integer variable called age and a boolean variable 
//		called isStudent, write an if/else statement that checks if age is 
//		under 18 or if isStudent is true.
//		- If age is less than 18 years old or isStudent is true then print to 
//		the console "You get a discount!"
//		- Else, print "Sorry, no discount for you."
//		
//		int age;
//		boolean isStudent;
//		age = in.nextInt();
//		isStudent = in.nextBoolean();
//		
//		if (age < 18 || isStudent) {
//			System.out.println("You get a discount!");
//		} else {
//			System.out.println("Sorry, no discount for you.");
//		}
//		
//		Input: 22, true 
//		Output: discount
//		
//		Input: 17, false 
//		Output: discount
//		
//		Input: 18, false
//		Output: no discount
//		
//		Input: 30, false
//		Output: no discount
//		
//		Input: 16, true
//		Output: discount
//		
//		
//		14. What will the following code print to the console?
//		
//		int num = 9;
//		boolean result = (num % 2 == 0 || num % 5 == 0);
//		
//		if (result) {
//			System.out.println("The number is either even or a multiple of 5");
//		} else {
//			System.out.println("The number is neither even nor a multiple of 5");
//		}
//		
//		Output: "The number is neither even nor a multiple of 5"
//		
//		
//		15. Is There Enough Money for the Bills?
//		
//		Given four integer variables moneyInBank, rentDue, carPayment, and 
//		food, write a conditional that will check if there's enough money 
//		for the bills.
//		- Declare an int variable called billSum and set it equal to the sum 
//		of rentDue, carPayment, and food
//		- If moneyInBank is greater than or equal to billSum, print "You have 
//		enough money this week." to the console
//		- Else, print "You may need to borrow some money."
//		
//		int moneyInBank, rentDue, carPayment, food;
//		
//		Test Case 1:
//		moneyInBank = 1500;
//		rentDue = 1000;
//		carPayment = 350;
//		food = 200;
//		Output: borrow money
//		
//		Test Case 2:
//		moneyInBank = 2350;
//		rentDue = 1250;
//		carPayment = 580;
//		food = 350;
//		Output: enough money
//		
//		int billSum = rentDue + carPayment + food;
//		
//		if (moneyInBank >= billSum) {
//			System.out.println("You have enough money this week.");
//		} else {
//			System.out.println("You may need to borrow some money.");
//		}
//		
//		
//		16. What does the following code print to the console?
//        System.out.println((-2 < -1) || ((10 > 3) && false));
//		
//		
//		17. Can I Pass The Class?
//		
//		In this problem, you are given four variables of type double called 
//		assignment1, assignment2, assignment3, and assignment4. To pass the 
//		class you need to have the sum of assignment1 and assignment2 be greater 
//		than 150.0 AND either assignment3 OR assignment4 needs to be greater than 70.0.
//		- Write an if/else statement that checks these parameters
//		- If you can pass the class, print this statement to the console: "You passed the class."
//		- Otherwise, print "You failed the class."
//		
//		double assignment1, assignment2, assignment3, assignment4;
//		assignment1 = in.nextDouble();
//		assignment2 = in.nextDouble();
//		assignment3 = in.nextDouble();
//		assignment4 = in.nextDouble();
//		
//		if ((assignment1 + assignment2) > 150.0 && (assignment3 > 70.0 || assignment4 > 70.0)) {
//			System.out.println("You passed the class.");
//		} else {
//			System.out.println("You failed the class.");
//		}
//		
//		Input: 80, 88, 77, 82
//		Output: pass
//		
//		Input: 95, 80, 89, 65
//		Output: pass
//		
//		Input: 82, 79, 68, 65
//		Output: fail
//		
//		Input: 72, 79, 68, 71
//		Output: pass
//		
//		Input: 70, 71, 88, 91
//		Output: fail
//		
//		
//		18. What will print to the console when the following code runs?
//		
//		boolean isRaining = true;
//		
//		if (!isRaining) {
//			System.out.println("It's not raining, so I can go for a walk.");
//		} else {
//			System.out.println("It's raining, so I'll stay indoors.");
//		}
//		
//		Output: raining
//		
//		
//		19. To be or Not to be a Vowel, that is the question?
//
//		Given a variable named letter of type char. Create an if/else statement 
//		to check to see if the character stored in the variable letter is 
//		a vowel or a consonant.
//		- The if statement should have the variable letter equal to each 
//		vowel separated by the || operator
//		- If the character is a vowel, then print "It's a vowel!"
//		- Else, print "It's a consonant!"
//		
//		// (Note: the defined method in OpenClass IDE takes argument 'letter' as input i.e. 'a')
//		
//		char a;
//		a = in.nextLine().charAt(0);
//		
//		if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
//			System.out.println("It's a vowel!");
//		} else {
//			System.out.println("It's a consonant!");
//		}
//		
//		Input: a
//		Output: vowel
//		
//		
//		20. What will print to the console when the following code runs?
//
//		int num = 15;
//		System.out.println(num % 2 == 0 && num % 3 == 0);
//		
//		Output: false
//		
		in.close();
	}

}
