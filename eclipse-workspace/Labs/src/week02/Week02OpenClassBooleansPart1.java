package week02;

import java.util.*;

public class Week02OpenClassBooleansPart1 {

	public static void main(String[] args) {

//		Boolean Operations - Part I
//		
//		1. Will it be true or false?
//		Given two integer variables, a and b, write a Boolean Expression that 
//		will check if a is less than b AND if b is greater than 100.
//		Print the result to the console.
//		
		Scanner in = new Scanner(System.in);
//		
//		int a, b;
//		a = in.nextInt();
//		b = in.nextInt();
//		
//		a = 105;
//		b = 101; 
//		Output: false
//		
//		a = 62;
//		b = 105;
//		Output: true
//		
//		a = 125;
//		b = 500;
//		Output: true
//		
//		a = 100;
//		b = 99;
//		Output: false
//		
//		System.out.println(a < b && b > 100);
//		
//		
//		2. What will the following code print to the console?
//		System.out.println( "hello world".charAt(0) != 'H');
//		Output: true
//		
//		
//		3. True AND, OR False
//		Write a program that takes in three given boolean values: a, b, and c.
//		Declare a variable named result that is a boolean, set it equal to a 
//		statement that compares if a AND b are true OR if a AND c are true, 
//		OR if b AND c are true
//		Print the value of result to the console
//		The program should print true if two of the values are true, and "false" otherwise.

//		 boolean a = in.nextBoolean();
//	     boolean b = in.nextBoolean();
//	     boolean c = in.nextBoolean();
//		
//	     boolean result = (a && b) || (a && c) || (b && c);
//	     System.out.println(result);

//	     Input: true, true, true
//	     Output: true

//	     Input: true, false, false
//	     Output: false

//	     Input: false, false, true
//	     Output: false

//	     Input: false, false, false
//	     Output: false

//	     Input: false, true, true
//	     Output: true 

//	     Input: true, false, true
//	     Output: true
//	     
//		
//		4. What will the value of result be when the following code runs?
//		int x = 25;
//		int y = 20;
//		int z = 10;
//
//		boolean result = x > y && x > z;
//
//		System.out.println(result);
//		Output: true
//		
//		
//		5. This || That
//		Given four variables num1, num2, num3, and num4, create a Boolean Expression.
//		If num1 is greater than num2 OR num3 is less than num4, then true should print to the console
//		Otherwise, false should print to the console.
//		
//		int num1, num2, num3, num4;
//		num1 = in.nextInt();
//		num2 = in.nextInt();
//      num3 = in.nextInt();
//      num4 = in.nextInt();
//        
//      System.out.println((num1 > num2) || (num3 < num4));
//		
//      Input: 14, 8, 25, 11
//      Output: true
//      
//      Input: 17, 25, 12, 23
//      Output: true
//      
//      Input: 89, 105, 97, 54
//      Output: false
//      
//      Input: 35, 25, 55, 95
//      Output: true
//      
//      Input: 5, 10, 20, 15
//      Output: false
//      
//      
//      6. What will print to the console when the following code runs?
//      
//		int tokens = 12;
//		int costToPlayArcadeGame = 3;
//        
//		System.out.println(tokens < costToPlayArcadeGame);
//        
//      Output: false
//        
//        
//        7. True or False
//        Given the variables a and b, write a Boolean Expression that checks if either is true.
//        Check to see if the value of a is true OR if the value of b is true
//        Print the result to the console
//		
//		boolean a = in.nextBoolean();
//		boolean b = in.nextBoolean();
//		
//		System.out.println(a || b);
//		
//		
//		8. What will the following code print to the console?
//			public class App {
//			public static void main(String[] args){
//				System.out.println( (10 > 5)  ||  (5 < 1) );
//		    }
//		}
//		
//				
//		9. Not!
//		Given variables x and y, write an expression that says x is less than y and negate that expression with !.
//		Print the result of that expression to the console.
//		Hint: Use the ! operator.
//		
//		int x, y;
//		x = in.nextInt();
//		y = in.nextInt();
//		
//		System.out.println(!(x < y));
//		
//		Input: 1, 2
//		Output: false
//		
//		Input: 4, 3
//		Output: true
//		
//		Input: 5, 5
//		Output: true
//		
//		Input: 10, 15
//		Output: false
//		
//		
//		10. What will the following Boolean Expression evaluate to?
//				System.out.println(true && !false);
		
		in.close();
	}

}