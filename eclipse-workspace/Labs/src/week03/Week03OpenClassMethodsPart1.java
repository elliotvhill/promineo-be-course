package week03;

import java.util.Scanner;

public class Week03OpenClassMethodsPart1 {

	public static void main(String[] args) {
		
//		Question 1:
		System.out.println("Question 1:");
		System.out.println(returnSum(4, 18, 76));
		
//		Question 3:
		System.out.println("Question 3:");
		System.out.println(repeatWord("catdog", 3));
		
//		Question 5:
		System.out.println("Question 5:");
		fizzBuzz(17);
		fizzBuzz(9);
		
//		Question 6:
		System.out.println("Question 6:");
		int a = 10, b = 10, c = 10;
//		System.out.println(returnSum2(a,b,c));
		
//		Question 7:
		System.out.println("Question 7:");
		System.out.println(returnSum3(a,b,c));
		
//		Question 9:
		System.out.println("Question 9:");
		
		double product1, product2, product3, taxRate;
		Scanner in = new Scanner(System.in);
		
		product1 = in.nextDouble();
		product2 = in.nextDouble();
		product3 = in.nextDouble();
		taxRate = in.nextDouble();
		
		System.out.println("Your order total is: $" + String.format("%,.2f", orderTotal(product1, product2, product3, taxRate)));
		
		in.close();
		
	}
	
	/*
	 * Question 1:
	 * Create a static method named returnSum that accepts 3 int variables 
	 * named num1, num2, and num3
	 */
		
	public static int returnSum(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
	
	/* Question 2: What is wrong with the code below?
	 * 
	 public class Main {
	    		public static void main(String[] args) {
	        		System.out.println(isDivisibleBy2(5));
	    		}
	    		static double isDivisibleBy2(int a){
			   if ( a % 2 == 0) {
			      return true;
			   } else {
			      return false;
			   }
		    }  
		}
	 * 
	 * A. Nothing, the code will run
	 * B. We are returning the wrong type of value - instead of double, 
	 * it should be int.
	 * C. We are returning the wrong type of value - instead of double, 
	 * it should be boolean. √
	 */
	

	/* Question 3: repeatWord Method
	 * 
	 * Complete the method that takes a String named userWord and an integer value 
	 * named numTimes.
	 * In that method you will take the value stored in numTimes and create a new 
	 * String that repeats userWord that many times
	 * Then return the new String value from the method
	 */
	
	public static String repeatWord(String userWord, int numTimes) {
		String repeatedString = "";
		for (int i = numTimes; i > 0; i--) {
			repeatedString += userWord;
		}
		return repeatedString;
	}
	
	
	/* Question 4: What will print to the console when the code below runs?
	 *
		public class MethodsApp{
		    public static void main3(String[] args) {
		        System.out.println(divideNums(5, 0));
		    }
		    static double divideNums(int a, int b){
		        return a/b;
		    }
		}
	 * 
	 * A. 1
	 * B. 0
	 * C. 5
	 * D. Java will give an error message √
	 * In Java, dividing an integer by zero will throw an exception. In particular, 
	 * an ArithmeticException will be thrown.
	 * 
	 */
	
	
	/* Question 5: fizzBuzz Method
	 * 
	 * Complete the method called fizzBuzz that accepts the integer 
	 * value stored in num1.
	 * If the value is divisible by 3, print "Fizz" to the console
	 * If the value is divisible by 5 print "Buzz" to the console
	 * If the value is divisible by both 3 and 5 print "FizzBuzz" 
	 * to the console
	 * If the number is not divisible by either 3 or 5, print 
	 * "Hello world!" to the console
	 * Use System.out.println() in all of your print statements
	 * 
	 */
	
	public static void fizzBuzz(int num1) {
		if (num1 % 3 == 0 && num1 % 5 == 0) {
			System.out.println("FizzBuzz");
		} else if (num1 % 5 == 0) {
			System.out.println("Buzz");
		} else if (num1 % 3 == 0 ) {
			System.out.println("Fizz");
		} else {
			System.out.println("Hello world!");
		}
	}
	
	/* Question 6: What will print to the console after the code below runs?
	 */
		    static int returnSum2(int x, int y, int z){
		        int answer = x + y + z;
		        return x;
		    }

	 /* A. Error Message
	 * B. 30
	 * C. 10 √
	 * Notice that the method returnSum() returns x, not answer. x is a 
	 * parameter name, 
	 * and the variable a is passed into returnSum() as the first argument 
	 * so it corresponds 
	 * to the first parameter, which is x.
	 */
	
	/* Question 7: Error Analysis
	 * 
	 * Fix the error in this method. It is supposed to return the sum of the 
	 * three integers for a total of 30 but it only returns 10. Fix this bug 
	 * with only changing one line of code.
	 * 
	 */
	
		static int returnSum3(int x, int y, int z){
		        
		        // CHANGE ONLY ONE OF THESE LINES TO FIX THE ERROR
		        int answer = x + y + z;
		        return answer;
		        
		/***** DO NOT CHANGE THE CODE BELOW THIS LINE *****/
		    }
//		        int a = 10, b = 10, c = 10;
//		        System.out.println(returnSum3(a,b,c));
	
	/* Question 8: Which of the following statements about return type in 
	 * Java methods is true?
	 * 
	 * A. Return type specifies the parameters that the method can accept.
	 * B. Return type specifies the scope of the method.
	 * C. Return type specifies the data type of the value returned by 
	 * the method. √
	 * D. Return type specifies the name of the method.
	 */
	
	/* Question 9: What is your orderTotal?
	 * 
	 * Complete the method called orderTotal that takes in 4 doubles stored 
	 * in product1, product2, product3, and taxRate. The method will sum the 
	 * values of product1, product2, and product3. Then it will figure out the 
	 * applicable sales tax using the variable taxRate. Finally, the method 
	 * should return a double that is the total order price with tax.
	 * 
	 */
		
		static double orderTotal(double product1, double product2, double product3, double taxRate) {

			double total = (product1 + product2 + product3) * (1 + taxRate);
			return total;
		}

	
	/* Question 10: Which of the following is an example of a variable with local scope in Java?
	 * 
	 * A. A variable declared as static
	 * B. A variable declared as a parameter of a method
	 * C. A variable declared inside a class but outside a method
	 * D. A variable declared inside a method √
	 */
	
}
