package week03;

import java.util.Arrays;
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
//		String[] arr = { "Astros", "Reds", "Phillies", "Dodgers", "Angels" };
//		String word1, word2, word3;
//
//		word1 = "Yankees";
//		word2 = "Orioles";
//		word3 = "Mariners";
//
//		String[] newArr = { word1, word2, word3 };
//
//		String[] biggerArr = new String[arr.length + newArr.length];
//
//		for (int i = 0; i < arr.length; i++) {
//			biggerArr[i] = arr[i];
//			for (int j = 0; j < biggerArr.length - arr.length; j++) {
//				biggerArr[j + arr.length] = newArr[j];
//			}
//		}

//		for (int i = 0; i < biggerArr.length; i++) {
//			System.out.println(biggerArr[i]);
//		}
//		System.out.println(Arrays.toString(biggerArr));

//		
//		Question 16:
//		System.out.println("Question 16:");
//		
//		int[] arr1 = { -11, 43, 901, 72, -5};
//		int[] arr2 = arr1.clone();
//
//		System.out.println(arr2[3]);
		
//		Question 17:
//		System.out.println("Question 17:");
//		reverseArray(60, 50, 40, 30, 20);
		
//		Question 18:
//		System.out.println("Question 18:");
		
//		Question 19:
		System.out.println("Question 19:");
		
		int input1, input2;
//		input1 = 10;
//		input2 = 15;
		input1 = in.nextInt();
		input2 = in.nextInt();
		multidimensional(input1, input2);
		
//		Question 20:
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
//
//	static int[] buildArray(int num) {
//		int[] numArray = new int[num];
//		for (int i = 0; i < num; i++) {
//			numArray[i] = i;
//		}
//		return numArray;
//	}

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

//	static int createInt(int num1, int num2, int num3, int num4, int num5, int num6) {
//
//		int[] arrayInt = { num1, num2, num3, num4, num5, num6 };
//		return arrayInt[arrayInt.length - 1];
//
//	}

	/*
	 * Question 14: What will the new Array be after the following code runs?
	 * 
	 * int[] arr = {-11, 43, 901, 43, -5};
	 * 
	 * arr[arr.length - 2] = 0;
	 * 
	 * for (int n : arr){ System.out.print(n + " "); }
	 * 
	 * A. -11 43 901 43 -5 B. -11 43 901 43 0 -5 C. -11 43 901 0 -5 √
	 * 
	 */

	/*
	 * Question 15: Build A New Array
	 * 
	 * Given an Array of words named arr and variables word1, word2, and word3 do
	 * the following: - Create a new Array called newArr that has word1, word2, and
	 * word3 as its elements - Create another Array that is big enough to hold all
	 * of the words from the original Array arr, as well as the three new words. You
	 * can name this Array to your liking. - Write a loop to get the words from the
	 * original Array arr and put them into your new Array - Add the words from
	 * newArr into the new Array also - Finally, loop through your new Array and
	 * print each element to the console
	 * 
	 * - An idea to get more practice with Arrays: You could create an Array for the
	 * three new words, and then loop through two Arrays to create your new Array.
	 * 
	 */

	/*
	 * Question 16: What number will print to the console after the following code runs?
	 * 
		int[] arr = { -11, 43, 901, 72, -5};
		int[] arr2 = arr.clone();
		
		System.out.println(arr2[3]);
	 * 
	 * A. Nothing - `clone( )` isn't a real Array method  
	 * B. 901 
	 * C. 72 √
	 * 
	 */

	/*
	 * Question 17: Reverse An Array
	 * 
	 * Using the initialized Array named arr that uses five (5) integers 
	 * provided by the user as elements:
	 * 
	 * - Create a new Array called reverseArr that is the reverse of 
	 * the original Array arr
	 * Then write a loop that will iterate through each Array and 
	 * print each element in the console
	 * - Note: You should print the elements of both Arrays
	 * - Hint: Both Arrays should have the same amount of elements 
	 * and therefore have the same lengths
	 * 
	 */
	
	static void reverseArray(int a, int b, int c, int d, int e) {
			
		int[] arr = {a, b, c, d, e};
		int[] reverseArr = new int[arr.length];
		
		for (int i = arr.length - 1; i >= 0; i--) {
			reverseArr[arr.length - 1 - i] = arr[i];
		}
		
		for (int num : arr) {
			System.out.println(num);
		}
		for (int num : reverseArr) {
			System.out.println(num);
		}
	}

	/*
	 * Question 18: In Java, can you have an Array of mixed types of values 
	 * (i.e. an Array that contains both data of type String & int, 
	 * or int & char, etc.)?
	 * 
	 * A. No √
	 * B. Yes
	 */

	/*
	 * Question 19: Multidimensional Arrays -- This is an advanced problem!
	 * 
	 * In this problem you will create a multidimensional Array of int named arr.
	 * 
	 * - You are given two integer variables, a and b that are user inputs
	 * 
	 * - Use these integer values to initially declare your new Array arr, 
	 * where these integers determine the size of both dimensions of the Array
	 * 
	 * - Then, use these int values to create both an inner and outer Array 
	 * using some type of loop (maybe a for loop) that starts at zero and 
	 * goes to whatever number values are stored in a and b
	 * 
	 * - To complete this problem, when you've populated the Arrays (after 
	 * the nested loops have completed), print the last element of the first 
	 * Array to the console.
	 * 
	 * Here are a few tips:
	 * 
	 * - Error Checking: Make sure both numbers entered by the user are 
	 * greater than two (2). If not, print the following message to the 
	 * console: "Both numbers need to be greater than 2."
	 * 
	 * - You will need to create two loops to populate the multidimensional 
	 * Array, storing the index of the second loop in the Array positions.
	 * 
	 */

	static void multidimensional(int a, int b) {
	    // Check for error -- invalid parameters with an if/else
		if (a <= 2 || b <= 2) {
			System.out.println("Both numbers need to be greater than 2.");
			
		} else {
			// If both parameters are > 2
			// Declare a multidimensional array something like this:
			//          int[][] arr = new int[param1][param2];
			
			int[][] arr = new int[a][b];
			
			// Create two loops to populate your new multidimensional array
			// Note:  you will need a new index in each for-loop. 
			//          one index will be used for the first for-loop's 
			//          index (0 to param1 - 1)
			//          the second index will be used for the second 
			//          for-loop's index (0 to param2 - 1)		
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = j;
				}
			}
			
			// After you have populated your multidimensional array, 
			// Print out the value of arr[firstPosition][lastPosition]
			System.out.println(arr[0][b - 1]);
		}
	}
	
	/*
	 * Question 20: 
	 * 
	 */

}