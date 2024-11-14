package week02;

import java.util.*;

public class Week02OpenClassLoopsPart2 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

//		11. Add a Number a Certain Number of Times
//
//		Given the variables numToAdd, howManyTimes, and sumResult, do the 
//		following:
//		
//		- Create a do while loop that adds the value of numToAdd to 
//		the variable sumResult
//		- You will want to set up your addition equation to add numToAdd 
//		to sumResult on each iteration of the loop.
//		- The loop will run as many times as the value stored in howManyTimes.
//		- Once the loop has finished running, print the value of sumResult 
//		to the console using System.out.println();
//		
//		int numToAdd = in.nextInt();
//		int howManyTimes = in.nextInt();
//		int sumResult = 0;
//		
//		do {
//			sumResult += numToAdd;
//			howManyTimes--;
//		} while (howManyTimes > 0);
//		
//		System.out.println(sumResult);
//		
//		
//		
//		12. True/False: A do while loop will run at least one time even 
//		if the condition checked for evaluates to false.
//		True; The condition is checked AFTER the code is executed so it 
//		will run at least the one time.
//		
//		
//		
//		13. do while Loop
//
//		Using the given variable userNumber, create an if/else statement 
//		that checks to see if userNumber is more than 10 and under 100.
//		
//		- If it is, execute a do while loop that prints the value of 
//		userNumber to the console AND decrements it by 1 until userNumber 
//		is less than or equal to 10.
//		- Otherwise, if userNumber is not greater than 10 and less than 100, 
//		print (exactly) "Your number is not a value that is more than 10 and 
//		less than 100." to the console, including the "." at the end
//		
//		int userNumber = in.nextInt();
//		
//		if (userNumber > 10 && userNumber < 100) {
//			do {
//				System.out.println(userNumber);
//				userNumber--;
//			} while (userNumber >= 10);
//		} else {
//			System.out.println("Your number is not a value that is more than 10 and less than 100.");
//		}
//		
//		
//		
//		14. What is printed after this code runs?
//		int x = 0;
//		do {
//			System.out.println("I will print!");
//			x++;
//		} while (x > 1);
//		
//		A. Error
//		B. "I will print!"
//		C. "I will print!" etc. forever
//		D. Nothing will print
//		
//		B: 
//		Since x doesn't meet the condition x > 1 the loop will run one 
//		time because do while loops always run once but then it will stop 
//		running because the condition is false.
//		
//		
//		
//		15. Pick a Loop, any Loop
//
//		Write a loop (any type of loop will work) that does a countdown 
//		using the given variable countDown.
//		
//		- Check to make sure the number stored in countDown is not larger 
//		than 10 and is greater than or equal to 3
//		- The loop should run from the value stored in countDown down to 1
//		- Each time the loop runs, print the value of the counter 
//		followed by three periods (…)
//		- Once out of the loop, print "We have lift off!"
//		- Use System.out.println() to print everything to the console
//		- If countDown is less than 3 or greater than 10, then the only 
//		message printed to the console is "We have lift off!"
//		
		int countDown = in.nextInt();
		
		if (countDown >= 3 && countDown <= 10) {
			
			while (countDown > 0) {
				System.out.println(countDown + "...");
				countDown--;
			}
		}
		
		System.out.println("We have lift off!");
//		
//		
//		
		in.close();

	}

}
