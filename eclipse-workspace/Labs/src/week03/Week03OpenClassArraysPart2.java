package week03;

import java.util.Scanner;

public class Week03OpenClassArraysPart2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

//		Question 11:
//		System.out.println("Question 11:");

//		Question 12:
//		System.out.println("Question 12:");

//		Question 13:
//		System.out.println("Question 13:");
//		int num1, num2, num3, num4, num5, num6; 
//		num1 = in.nextInt();
//		num2 = in.nextInt();
//		num3 = in.nextInt();
//		num4 = in.nextInt();
//		num5 = in.nextInt();
//		num6 = in.nextInt();
//		int returnedInt = createInt(num1, num2, num3, num4, num5, num6);
//		System.out.println("The last number of the array is " + returnedInt + ".");

//		Question 14:
//		System.out.println("Question 14:");
//		int[] arr = { -11, 43, 901, 43, -5 };
//
//		arr[arr.length - 2] = 0;
//
//		for (int n : arr) {
//			System.out.print(n + " ");
//		}
		
//		Question 15:
//		System.out.println("Question 15:");
//		
////		Question 16:
//		System.out.println("Question 16:");
//		
////		Question 17:
//		System.out.println("Question 17:");
//		
////		Question 18:
//		System.out.println("Question 18:");
//		
////		Question 19:
//		System.out.println("Question 19:");
//		
////		Question 20:
//		System.out.println("Question 20:");

		in.close();
	}

	/*
	 * Question 11: Build and Return an Array
	 * 
	 * In the method buildArray you will take the int value stored in the given
	 * variable num and declare an Array of that size called numArray. - Write a for
	 * loop that starts with a loop variable or index of zero (0) and checks to see
	 * if the loop variable is less than num. - To fill the Array, you will insert
	 * the value of that loop variable to one of the slots in numArray indexed by
	 * the loop variable - return the variable numArray after the for loop finishes
	 * 
	 */

	static int[] buildArray(int num) {
		int[] numArray = new int[num];
		for (int i = 0; i < num; i++) {
			numArray[i] = i;
		}
		return numArray;
	}

	/*
	 * Question 12:
	 * 
	 */

	/*
	 * Question 13: Create An Array of Integer
	 * 
	 * In the method createInt create an Array - Use the 6 variables that are passed
	 * in as num1, num2, num3, num4, num5, and num6 to create the Array - The Array
	 * of int should be called arrayInt - Make sure to return the last item in
	 * arrayInt
	 * 
	 */

	static int createInt(int num1, int num2, int num3, int num4, int num5, int num6) {

		int[] arrayInt = { num1, num2, num3, num4, num5, num6 };
		return arrayInt[arrayInt.length - 1];

	}

	/*
	 * Question 14: What will the new Array be after the following code runs?
	 * 
		  int[] arr = {-11, 43, 901, 43, -5};
		  
		  arr[arr.length - 2] = 0;
		  
		  for (int n : arr){ System.out.print(n + " "); } 
	 * 
	 * A. -11 43 901 43 -5 
	 * B. -11 43 901 43 0 -5 
	 * C. -11 43 901 0 -5 √
	 * 
	 */

	/*
	 * Question 15: Build A New Array

Given an Array of words named arr and variables word1, word2, and word3 do the following:
Create a new Array called newArr that has word1, word2, and word3 as it's elements
Create another Array that is big enough to hold all of the words from the original Array arr, as well as the three new words. You can name this Array to your liking.
Write a loop to get the words from the original Array arr and put them into your new Array
Add the words from newArr into the new Array also
Finally, loop through your new Array and print each element to the console
An idea to get more practice with Arrays: You could create an Array for the three new words, and then loop through two Arrays to create your new Array.
	 * 
	 */

	/*
	 * Question 16:
	 * 
	 */

	/*
	 * Question 17:
	 * 
	 */

	/*
	 * Question 18:
	 * 
	 */

	/*
	 * Question 19:
	 * 
	 */

	/*
	 * Question 20:
	 * 
	 */

}