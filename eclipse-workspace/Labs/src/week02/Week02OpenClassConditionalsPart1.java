package week02;

public class Week02OpenClassConditionalsPart1 {

	public static void main(String[] args) {
		
		
//		Will My Team Make the Playoffs?
//
//				Evaluate if your favorite baseball team is any good and might make the playoffs. You are given two integer variables, wins and losses, and one Boolean variable called isFall.
//				If wins is greater than losses and isFall equals true, then print a message that says “It's looking good for your team to make the playoffs.”
//				If wins is greater than losses, but isFall is false, then print “Your favorite team has promise, but it's too early to tell.”
//				Finally, if both conditions evaluate to false, then print “It's not looking too good.”
//				
//				
//				import java.io.*;
//				import java.util.*;
//
//				public class LetsPlayBall {
//
//					static void playoffs(int wins, int losses, boolean isFall) {
//				        // Step 1: We want to check if the number of wins is greater than the number of losses and if it's fall season.
//				        // If both conditions are true, the program will print that the team is likely to make the playoffs.
//				        
//				        
//				        // Step 2: If the number of wins is greater than the number of losses but it's not fall season,
//				        // the program will print that the team has potential, but it's too early to decide.
//				      
//				        
//				        // Step 3: If neither of the above conditions are true (meaning wins are not greater than losses),
//				        // the program will print that things aren't looking good for the team.
//				      
//				        
//				        // Example: Let's say wins = 8, losses = 5, and isFall = true.
//				        // Since wins are greater than losses and it's fall, the program will print:
//				        // "It's looking good for your team to make the playoffs."
//
//						
//						
//						
//						
//						
//						
//						
//						
//						
//
//				/***** DO NOT CHANGE THE CODE BELOW THIS LINE *****/
//					}
//
//					public static void main(String[] args) {
//						Scanner in = new Scanner(System.in);
//						int wins, losses;
//						boolean isFall;
//						wins = in.nextInt();
//						losses = in.nextInt();
//						isFall = in.nextBoolean();
//						playoffs(wins, losses, isFall);
//					}
//				}
		
//		test: 4, 6, true
//		test: 8, 2, false
		
		
		
//		What is the output of this code?
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
//				Multiple-choice options (select one)
//
//				A.
//				The number is greater than 10.
//
//				B.
//				The number is greater than 5 but less than or equal to 10.
//
//				C.
//				The number is less than or equal to 5.
		
		
		
		
//		Nested Statements
//
//		Create a nested if statement:
//		Check to see if num1 is greater than or equal to num2
//		Note: The second if statement should only run if the first if evaluates to true
//		If the first statement is true then check to see if num3 is greater than or equal to num4
//		If both conditions are true print "both statements are true"
//		At the end of the main() method, print "program ended"
		
//		import java.io.*;
//		import java.util.*;
//
//		public class CodingQuestion {
//
//		    public static void main(String[] args) {
//		        Scanner in = new Scanner(System.in);
//		        int num1 = in.nextInt();
//		        int num2 = in.nextInt();
//		        int num3 = in.nextInt();
//		        int num4 = in.nextInt();
//		    /***** DO NOT CHANGE THE CODE ABOVE THIS LINE *****/
//		        
//		        // Step 1: We check if num1 is greater than or equal to num2.
//		        // If this condition is true, we move to the next step.
//		        
//		            // Step 2: Inside the first condition, we now check if num3 is greater than or equal to num4.
//		            // If both conditions are true, the program will print "both statements are true".
//		           
//		        
//		        // Step 3: Regardless of whether the conditions were true or false, the program will print "program ended".
//		        
//		        
//		        // Example: 
//		        // Let's say num1 = 5, num2 = 3, num3 = 4, and num4 = 2.
//		        // Since 5 is greater than 3, and 4 is greater than 2, the program will print:
//		        // "both statements are true"
//		        // "program ended"
//
//
//
//		test: 5, 5, 5, 5
//		test: 1, 2, 3, 4
		
		
		
//		Would the following code give the same result as the code in Question #13?
//				  if ( num1 >= num2 && num3 >= num4){
//				    System.out.println("both statements are true");
//				   }
//				  System.out.println("program ended");
		
		
		
//		switch Statement Practice
//
//		Given a variable monthNumber, write a switch statement to check the value stored in the variable that will produce the name of the month.
//		When a match is made, print out that month in word format (i.e. 7 should print July)
//		If a match is not made, print out "Invalid Month"
//		Use System.out.println() to print statements to the console.
		
//		
//		import java.io.*;
//		import java.util.*;
//
//		public class CodingQuestion {
//
//			public static void main(String[] args) {
//				Scanner in = new Scanner(System.in);
//				int monthNumber = in.nextInt();
//			/***** DO NOT CHANGE THE CODE ABOVE THIS LINE *****/
//			
//				// WRITE YOUR CODE HERE
//
//
//
//
//
//
//
//		        
//		        
//			}
//		}
		
		
//		test: 0
//		test: 11
//		test: 13
//		test: 12
//		test: 4
//		test: 6
//		test: 1
//		test: 2
		
		
//
//		Java will execute all of the code below the matched case in a switch statement unless a break; statement is inserted.
		
//		true / false
		
		
		
		
		
//
//
//
//		    }
//		}
		
		
		
		
		
		
		
		
		
		
	}

}
