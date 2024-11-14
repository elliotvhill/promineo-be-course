package week02;

import java.util.*;

public class Week02OpenClassLoopsPart1 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

//		1. `for` Loop
//		
//		Given the variable userValue, create a for loop that starts at 1 and goes 
//		to 100 including the value 100, printing the value of the counter to the 
//		console each time the loop processes.
//		- The for loop should iterate from 1 up to and including 100
//		- The for loop should increment the counter by the amount stored in userValue
//		- The for loop should print the counter to the console at every iteration
//		
//		
//		int userValue;
//		userValue = in.nextInt();
//		
//		for (int i = 1; i <= 100; i += userValue) {
//			System.out.println(i);
//		}
//		
//		
//		
//		
//		2. What numbers will print out when this code runs? // 2 4 6 8 10
//		for (int i = 1; i <= 10; i++) {
//			if (i % 2 == 0) {
//				System.out.print(i + " ");
//			}
//		}
//		
//		
//		
//		3. It's the Final Countdown
//
//		Create a for loop that starts at 10 and goes to 0.
//		- The value of your index i decrements by 1 each time the loop finishes
//		- Print the index i to the console for each iteration
//		
//		for (int i = 10; i >= 0; i--) {
//			System.out.println(i);
//		}
//		
//		
//		
//		4. How many times will this loop run? // infinitely
//		
//		for (int i = 1; i <= 10; i--) {
//			if (i % 2 == 0) {
//				System.out.println("Hello");
//			}
//		}
//		
//		
//		
//		
//		5. It's All About the Base
//
//		Given variables `power`, `base`, and `result`, use a for loop to raise the 
//		`base` to the power of `power` (i.e. base^power).
//		- The loop should run from 1 to the number stored in `power`
//		- In the loop body, result should be multiplied by the `base` every time 
//		the loop iterates and that value stored in `result`, like this: 
//		result *= base or result = result * base
//		- Print the value of `result` to the console
//
//		int base = in.nextInt();
//		int power = in.nextInt();
//		int result = 1;
//		
//		for (int i = 1; i <= power; i++) {
//			result *= base;
//		}
//		System.out.println(result);
//
//
//
//		6. What will be the value of the variable counter when the following 
//		for loop finishes running? // 50
//		
		int counter = 0;
		for (int i = 1; i < 100; i += 2) {
			counter++;
			System.out.println(counter);
		}
//
//
//
//		7. Is a Number Between 1 and 100?
//
//		Given the variable userNumber, do the following:
//		- Check to see if userNumber is between 1 and 100 (Valid numbers 
//		are 1, 100, and all numbers in between)
//		- If it is, run a while loop that prints all integer values 
//		starting with userNumber to 100
//		- If not, print "Your number was not between 1 and 100." to the console.
//
//
//
//
		in.close();
	}

}
