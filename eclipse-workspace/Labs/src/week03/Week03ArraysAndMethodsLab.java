//
// Copyright (c) 2023 Promineo Tech
// Author:  Promineo Tech Academic Team
// Subject: Arrays & Methods
// Java Week 03 Lab
//
package week03;

public class Week03ArraysAndMethodsLab {

	public static void main(String[] args) {

		//
		// Arrays:
		//

		// 1. Create an array with the following values 1, 5, 2, 8, 13, 6
		int[] intArray = { 1, 5, 2, 8, 13, 6 };

		// 2. Print out the first element in the array
		System.out.println("Question 2:");
		System.out.println(intArray[0]);

		// 3. Print out the last element in the array without using the number 5
		System.out.println("Question 3:");
		System.out.println(intArray[intArray.length - 1]);

		// 4. Print out the element in the array at position 6, what happens?
//		System.out.println("Question 4:");
//		System.out.println(intArray[6]);
		// Throws an index out of bounds error

		// 5. Print out the element in the array at position -1, what happens?
//		System.out.println("Question 5:");
//		System.out.println(intArray[-1]);
		// Also throws an index out of bounds error

		// 6. Write a traditional for loop that prints out each element in the array
		System.out.println("Question 6:");
		for (int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
		}

		// 7. Write an enhanced for loop that prints out each element in the array
		System.out.println("Question 7:");
		for (int num : intArray) {
			System.out.println(num);
		}

		// 8. Create a new variable called sum, write a loop that adds
		// each element in the array to the sum
		System.out.println("Question 8:");
		int sum = 0;
		for (int num : intArray) {
			sum += num;
		}
		System.out.println(sum);

		// 9. Create a new variable called average and assign the average value of the
		// array to it
		System.out.println("Question 9:");
		double average = sum / intArray.length;
		System.out.println(average);

		// 10. Write an enhanced for loop that prints out each number in the array
		// only if the number is odd
		System.out.println("Question 10:");
		for (int num : intArray) {
			if (num % 2 != 0) {
				System.out.println(num);
			}
		}

		// 11. Create an array that contains the values "Sam", "Sally", "Thomas", and
		// "Robert"
		System.out.println("Question 11:");
		String[] names = { "Sam", "Sally", "Thomas", "Robert" };
		System.out.println(names);

		// 12. Calculate the sum of all the letters in the new array // ?? Concatenate?
		// Count number of chars??
		System.out.println("Question 12:");
		int stringChars = 0;

		for (String name : names) {
			stringChars += name.length();
		}
		System.out.println(stringChars);

		//
		// Methods:
		//

		// 13. Write and test a method that takes a String name and prints out a
		// greeting.
		// This method returns nothing.
		System.out.println("Question 13:");
		greeting("Elliot");

		// 14. Write and test a method that takes a String name and
		// returns a greeting. Do not print in the method.
		noPrintGreeting("Geralt");

		// Compare method 13 and method 14:
		// a. Analyze the difference between these two methods.
		// b. What do you find?
		// c. How are they different?

		/*
		 * 13 simply prints the string but does not return it, meaning the result is not
		 * stored/cannot be used in subsequent code. 14 returns a value that can be used
		 * in future code.
		 */

		// 15. Write and test a method that takes a String and an int and
		// returns true if the number of letters in the string is greater than the int
		System.out.println("Question 15:");
		System.out.println(stringVsInt(7, "Dandelion"));

		// 16. Write and test a method that takes an array of string and a string and
		// returns true if the string passed in exists in the array
		System.out.println("Question 16:");
		String[] fruits = { "orange", "mango", "avocado" };
		System.out.println(stringExists(fruits, "mango"));

		// 17. Write and test a method that takes an array of int and
		// returns the smallest number in the array
		System.out.println("Question 17:");
		int[] numbers = { 4, 19, 6, 2, 11 };
		System.out.println(smallestInt(numbers));

		// 18. Write and test a method that takes an array of double and
		// returns the average
		System.out.println("Question 18:");
		double[] numsToAvg = {4, 1, 6, 2, 11};
		System.out.println(average(numsToAvg));

		// 19. Write and test a method that takes an array of Strings and
		// returns an array of int where each element
		// matches the length of the string at that position
		System.out.println("Question 19:");
		String[] teams = {"Chelsea", "Arsenal", "Ipswich", "West Ham"};
		System.out.println(stringLengths(teams));

		// 20. Write and test a method that takes an array of strings and
		// returns true if the sum of letters for all strings with an even amount of
		// letters
		// is greater than the sum of those with an odd amount of letters.
		System.out.println("Question 20:");
		System.out.println(oddVsEvenStrings(teams));

		// 21. Write and test a method that takes a string and
		// returns true if the string is a palindrome
		System.out.println("Question 21:");
		System.out.println(isPalindrome("racecar"));
		System.out.println(isPalindrome("level"));
	}

	// Method 13:
	public static void greeting(String name) {
		System.out.println("Howdy, " + name);
	}

	// Method 14:
	public static String noPrintGreeting(String name) {
		return "Greetings, " + name;
	}

	// Method 15:
	public static boolean stringVsInt(int num, String str) {
		return str.length() > num;
	}

	// Method 16:
	public static boolean stringExists(String[] arr, String str) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(str)) {
				return true;
			}
		}
		return false;
	}

	// Method 17:
	public static int smallestInt(int[] nums) {
		int min = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < min) {
				min = nums[i];
			}
		}
		return min;
	}

	// Method 18:
	public static double average(double[] arr) {
		double sum = 0;
		for (double num : arr) {
			sum += num;
		}
		return sum / arr.length;
	}

	// Method 19:
	public static int[] stringLengths(String[] arr) {
		int[] lengths = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			lengths[i] = arr[i].length();
		}
		return lengths;
	}

	// Method 20:
	public static boolean oddVsEvenStrings(String[] arr) {
		int evenSum = 0;
		int oddSum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length() % 2 == 0) {
				evenSum += arr[i].length();
			} else {
				oddSum += arr[i].length();
			}
		}
		return evenSum > oddSum;
	}

	// Method 21:
	public static boolean isPalindrome(String str) {
		for (int i = 0; i < str.length() / 2; i++) { // length / 2 to check first half of string against second half
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

}
