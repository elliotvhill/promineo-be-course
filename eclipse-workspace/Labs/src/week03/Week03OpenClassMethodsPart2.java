package week03;

import java.util.Scanner;

public class Week03OpenClassMethodsPart2 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		//		Question 11:
		//		System.out.println("Question 1:");
		//		int a,b,c,d,e;
		//		a = in.nextInt();
		//		b = in.nextInt();
		//		c = in.nextInt();
		//		d = in.nextInt();
		//		e = in.nextInt();
		//		int[] mainArray = createArray(a, b, c, d, e);
		//		System.out.println("The third number in your array is: " + mainArray[2]);


		//		Question 13:
		System.out.println("Question 3:");
		System.out.println(sumOfDigits(245));

		//		Question 15:
		System.out.println("Question 5:");
		System.out.println(passwordChecker("adastra%"));
		System.out.println(passwordChecker("astra%"));
		System.out.println(passwordChecker("adastraa"));

		//		Question 16:
		System.out.println("Question 6:");
		//		String iCanRetire = readyForTheBeach(64);
		//	    System.out.println(iCanRetire);

		//		Question 17:
		System.out.println("Question 7:");
		String[] names = {"Jose", "James", "Roberto", "Theodore", "Fred"};
		System.out.println(avgNameLength(names));

		//		Question 18:
		System.out.println("Question 8:");

		//		Question 19:
		System.out.println("Question 9:");
		//		int length = in.nextInt();
		//		int width = in.nextInt();
		//		int perimeter = rectanglePerimeter(length, width);
		//		System.out.println("The rectangle has a perimeter of " + perimeter + ".");


		in.close();
	}

	/*
	 * Question 11: createArray Method
	 * 
	 * Complete the method that accepts five integer values stored 
	 * in the variables a, b, c, d, e.
	 * - In the method, you will create an Array of int that stores 
	 * the value of the five parameters
	 * - The method should return the Array
	 */

	static int[] createArray(int a, int b, int c, int d, int e) {
		int[] numbers = {a, b, c, d, e};
		return numbers;
	}

	/* Question 12: When calling howManyVars() which are the correct 
	 * arguments to pass in?
	 * 
		public class Main {
		    public static void main(String[] args) {
		        System.out.println(howManyVars());
		    }
		    static void howManyVars(int a, String b, double c, int d, boolean e, char f){
		    }
		} 
	 * 
	 * A. 143, "I am a String", 9.99, 403, true, 'N' √
	 * The order and data type of the arguments passed in have to 
	 * be the same as the parameters of the method.
	 * 
	 * B. 2, "Name", 4, 11, true, 9, 'Y'
	 * C. "Hi", 5, 8, 43.33, 'X', false
	 */

	/* Question 13: sumOfDigits Method
	 * 
	 * Complete the method called sumOfDigits that takes an integer 
	 * variable called digits. Then return the sum of all the digits 
	 * in digits. For example, 245 would be 2 + 4 + 5 = 11.
	 * 
	 */

	static int sumOfDigits(int digits) {
		int sum = 0;

		while (digits != 0)
		{
			sum = sum + digits % 10;
			digits = digits/10;
			System.out.println("Sum: " + sum + " Digits: " + digits);
		}

		return sum;
	}

	/* Question 14: What will be the value of the variable addItUp 
	 * after the following code runs?
	 * 
		public static void main(String[] args) {
		        int addItUp = followTheMath(10, 5, 8, 11);
		    }
		    static int followTheMath(int num1, int num2, int num3, int num4){
		        int total = 0;
		        if (num1 < num4){
		            total += num2;
		        }
		        if (num2 == num3){
		            total += num4;
		        } else {
		            total += num1;
		        }
		        total += num3;
		        return num3;
		    }
	 * 
	 * A. 24
	 * B. 8 √ Since num1 is less than num4, total = 0 + 5 then since num2 is 
	 * not equal to num3, total = 0 + 5 + 10, then total = 0 + 5 + 10 + 8 = 23; 
	 * however, the last line returns num3, which is equal to 8 so the output 
	 * of the method is 8.
	 * C. 23 
	 * D. 15
	 * 
	 */

	/* Question 15: passwordChecker Method
	 * 
	 * Complete the method called passwordChecker that accepts the 
	 * String stored in variable password.
	 * - The method should check to make sure that password is at least 
	 * 8 characters in length and contains one of 4 special symbols, 
	 * !, $, %, or &
	 * - The method should return true or false.
	 * 
	 */

	static boolean passwordChecker(String password) {
		if (password.length() >= 8) {
			for (int i = 0; i < password.length(); i++) {
				if (
						password.charAt(i) == '!' || 
						password.charAt(i) == '$' || 
						password.charAt(i) == '%' || 
						password.charAt(i) == '&'
						) {
					return true;
				}
			}
		}
		return false;
	}

	/* Question 16: What will the value be for the variable iCanRetire 
	 * after the code runs?
	 * 
		 public static void main(String[] args) {
		    String iCanRetire = readyForTheBeach(64);
		    System.out.println(iCanRetire);
		} 
		static String readyForTheBeach(int age){
		    if (age < 30){
		        return "Only if you built Facebook or Google";
		    }
		    if (age < 50){
		        return "Perhaps if you lived a frugal life and worked 
		        a couple of jobs at a time.";
		    }
		    if (age < 65){
		        return "You are getting closer...";
		    } else {
		        return "You can call it quits!";
		    }
		}
	 * 
	 * A. You are getting closer… √
	 * B. Only if you built Facebook or Google!
	 * C. You can call it quits!
	 * D. Perhaps if you lived a frugal life and worked a couple of 
	 * jobs at a time.
	 * 
	 */

	/* Question 17: avgNameLength Method
	 * 
	 * Given a method call avgNameLength that takes in an Array of String stored 
	 * in names, write a program that will traverse the Array.
	 * - The names Array will hold 5 names that are entered by the user
	 * - The method avgNameLength will traverse the Array and find the average length 
	 * of all the names that are part of names
	 * - Return the average length of all the names
	 * 
	 */

	static int avgNameLength(String[] names) {
		int[] nameLengths = new int[names.length];
		for (int i = 0; i < names.length; i++) {
			nameLengths[i] = names[i].length();
		}
		int sum = 0;
		for (int num : nameLengths) {
			sum += num;
		}
		return sum / names.length;
	}

	/* Question 18: Are return statements required for all methods?
	 * A. Yes
	 * B. No √
	 */

	/* Question 19: rectanglePerimeter Method
	 * 
	 * Inside of the public class, write a static method 
	 * called rectanglePerimeter:
	 * - The method should accept two int variables named length and width
	 * - In the body of the method write a program that will calculate 
	 * the perimeter of the rectangle
	 * - The method should return an integer value representing the 
	 * perimeter of the rectangle
	 * 
	 */

	static int rectanglePerimeter(int length, int width) {
		return 2 * (length + width);
	}

	/* Question 20: Which variable should be returned for the method to be correct?
	 * 
	 public class Main {
	    public static void main(String[] args) {
	        System.out.println(whatsReturned(9, "Hi, There", false, 4.99, 'T'));
	    }
	    static boolean whatsReturned(int num1, String words, boolean TF, double price, char letter){
	        return;
	    }
	} 
	 * 
	 * A. price
	 * B. letter
	 * C. num1
	 * D. TF √
	 * Since the return type of the method is boolean, then the only value 
	 * that can be returned is the boolean TF
	 * E. words
	 */


}
