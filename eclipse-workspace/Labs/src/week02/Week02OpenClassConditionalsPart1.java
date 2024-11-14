package week02;

import java.util.*;

public class Week02OpenClassConditionalsPart1 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

//		
//		11. Will My Team Make the Playoffs?
//		
//		Evaluate if your favorite baseball team is any good and 
//		might make the playoffs. You are given two integer variables, 
//		wins and losses, and one Boolean variable called isFall.
//		- If wins is greater than losses and isFall equals true, 
//		then print a message that says “It's looking good for 
//		your team to make the playoffs.”
//		- If wins is greater than losses, but isFall is false, 
//		then print “Your favorite team has promise, but it's too early to tell.”
//		- Finally, if both conditions evaluate to false, then print 
//		“It's not looking too good.”
//				
//				        
//			int wins = 8;
//			int losses = 2;
//			boolean isFall = false;
////		
//			
////			// Step 1: We want to check if the number of wins is 
////			// greater than the number of losses and if it's fall season.
////			// If both conditions are true, the program will print 
////			// that the team is likely to make the playoffs.
//			if (wins > losses && isFall) {
//				System.out.println("It's looking good for your team to make the playoffs.");
////			
////			// Step 2: If the number of wins is greater than the number of losses but it's not fall season,
////			// the program will print that the team has potential, but it's too early to decide.
//			} else if (wins > losses && !isFall) {
//				System.out.println("Your favorite team has promise, but it's too early to tell.");
////				        
//			} else {
////			// Step 3: If neither of the above conditions are true (meaning wins are not greater than losses),
////			// the program will print that things aren't looking good for the team.
//				System.out.println("It's not looking too good.");
//			}
//				      
//
//			test: 4, 6, true // not looking good
//			test: 8, 2, false // too early

//		12. What is the output of this code?
//				int num = 7;
//				String message;
//
//				if (num > 10) {
//				    message = "The number is greater than 10.";
//				} else if (num > 5) {
//				    message = "The number is greater than 5 but less than or equal to 10.";
//				} else {
//				    message = "The number is less than or equal to 5.";
//				}
//
//				System.out.println(message);
//				
//				Multiple-choice options (select one)
//				B.
//				The number is greater than 5 but less than or equal to 10.

//		13. Nested Statements
//
//		Create a nested if statement:
//		- Check to see if num1 is greater than or equal to num2
//		- Note: The second if statement should only run if the first if evaluates to true
//		- If the first statement is true then check to see if num3 is greater than or equal to num4
//		- If both conditions are true print "both statements are true"
//		- At the end of the main() method, print "program ended"
//
//		        int num1 = in.nextInt();
//		        int num2 = in.nextInt();
//		        int num3 = in.nextInt();
//		        int num4 = in.nextInt();
//		        
////		        
////		        // Step 1: We check if num1 is greater than or equal to num2.
////		        // If this condition is true, we move to the next step.
//		        
//		        if (num1 >= num2) {
////			        // Step 2: Inside the first condition, we now check if num3 is greater than or equal to num4.
//		        		if (num3 >= num4) {
////				        // If both conditions are true, the program will print "both statements are true".
//		        			System.out.println("both statements are true");
//		        		}
//		        }
////		        // Step 3: Regardless of whether the conditions were true or false, 
////		        // the program will print "program ended".
//		        System.out.println("program ended");
//		        
//		        
//		        // Example: 
//		        // Let's say num1 = 5, num2 = 3, num3 = 4, and num4 = 2.
//		        // Since 5 is greater than 3, and 4 is greater than 2, the program will print:
//		        // "both statements are true"
//		        // "program ended"
//
//		test: 5, 5, 5, 5
//		test: 1, 2, 3, 4

//		14. Would the following code give the same result as the code in Question #13? // yes
//			if (num1 >= num2 && num3 >= num4){
//				System.out.println("both statements are true");
//				}
//			System.out.println("program ended");

//		15. `switch` Statement Practice
//
//		Given a variable monthNumber, write a switch statement to 
//		check the value stored in the variable that will produce 
//		the name of the month.
//		- When a match is made, print out that month in word 
//		format (i.e. 7 should print July)
//		- If a match is not made, print out "Invalid Month"
//		- Use System.out.println() to print statements to the console.
//
//				int monthNumber = in.nextInt();
//				
//				switch (monthNumber) {
//				case 1:
//					System.out.println("January");
//					break;
//				case 2:
//					System.out.println("February");
//					break;
//				case 3:
//					System.out.println("March");
//					break;
//				case 4:
//					System.out.println("April");
//					break;
//				case 5:
//					System.out.println("May");
//					break;
//				case 6:
//					System.out.println("June");
//					break;
//				case 7:
//					System.out.println("July");
//					break;
//				case 8:
//					System.out.println("August");
//					break;
//				case 9:
//					System.out.println("September");
//					break;
//				case 10:
//					System.out.println("October");
//					break;
//				case 11:
//					System.out.println("November");
//					break;
//				case 12:
//					System.out.println("December");
//					break;
//				default:
//					System.out.println("Invalid Month");
//					break;
//				}
//
//		test: 0
//		test: 11
//		test: 13
//		test: 12
//		test: 4
//		test: 6
//		test: 1
//		test: 2

//		16. Java will execute all of the code below the matched case 
//		in a switch statement unless a break; statement is inserted.
//		true
//
//
//
//		17. Debug: How Many Days in the Month?
//
//		Given the String variable month, determine how many days are 
//		in the given month or if it's an Invalid month.
//		- Currently, the program works but only if the name of the month 
//		stored in the variable month is lowercase.
//		- Change something in the switch statement that will make the 
//		program work as desired no matter the letter case of the name of the month.
//				

		String month = in.nextLine();
//
		int days = -1;
		switch (month.toLowerCase()) {
		case "january":
		case "march":
		case "may":
		case "july":
		case "august":
		case "october":
		case "december":
			days = 31;
			break;
		case "april":
		case "june":
		case "september":
		case "november":
			days = 30;
			break;
		case "february":
			days = 28;
			break;
		}

		/***** DO NOT CHANGE THE CODE BELOW THIS LINE *****/
		if (days == -1) {
			System.out.println("Invalid month");
		} else {
			System.out.println("Has " + days + " days");
		}

		in.close();
	}

}
