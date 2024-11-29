package week04Assignment;

import java.util.Arrays;

public class Week04Collections {

	public static void main(String[] args) {

		/* Question 1 */
		System.out.println("Question 1:");

		// Create array of int ages
		int[] ages = { 3, 9, 23, 64, 2, 8, 28, 93 };

		// Programmatically subtract first element from last element
		System.out.println(ages[ages.length - 1] - ages[0]);

		// Create new array of int ages2
		int[] ages2 = { 3, 9, 23, 64, 2, 8, 28, 93, 21 };

		// Repeat subtraction from above
		System.out.println(ages2[ages2.length - 1] - ages2[0]);

		// Calculate average age of ages2
		double sum = 0;
		for (double num : ages2) {
			sum += num;
		}
		System.out.println(sum / ages2.length);

		/* Question 2 */
		System.out.println();
		System.out.println("Question 2:");

		// Create array of String names
		String[] names = { "Sam", "Tommy", "Tim", "Sally", "Buck", "Bob" };

		// Iterate through array and calculate average number of letters
		double namesLengthSum = 0;
		for (int i = 0; i < names.length; i++) {
			namesLengthSum += names[i].length();
		}
		System.out.println(namesLengthSum / names.length);

		// Iterate through names and concatenate with spaces
		StringBuilder concatenatedNames = new StringBuilder();
		for (String name : names) {
			// if name is not the last element in names
			if (name != names[names.length - 1]) {
				concatenatedNames.append(name + " ");
			} else {
				// name is last element, do not append an extra space
				concatenatedNames.append(name);
			}
		}
		// Print result with quotes to verify no extra space at end of string
		System.out.println("\"" + concatenatedNames + "\"");

		/* Question 3 */
		// How do you access the last element of any array?
		// array[array.length - 1]

		System.out.println();
		System.out.println("Question 3:");
		System.out.println(names[names.length - 1]);

		/* Question 4 */

		// How do you access the first element of any array?
		// array[0]

		System.out.println();
		System.out.println("Question 4:");
		System.out.println(names[0]);

		/* Question 5 */
		System.out.println();
		System.out.println("Question 5:");

		// Create array of int nameLengths
		int[] nameLengths = new int[names.length];
		// Iterate over names and add lengths to nameLengths
		for (int i = 0; i < names.length; i++) {
			nameLengths[i] = names[i].length();
		}
		System.out.println(Arrays.toString(nameLengths));

		/* Question 6 */
		System.out.println();
		System.out.println("Question 6:");

		// Loop through nameLengths and calculate sum
		int lengthsSum = 0;
		for (int length : nameLengths) {
			lengthsSum += length;
		}
		System.out.println(lengthsSum);

		/* Question 7 */
		// See method outside main below
		System.out.println();
		System.out.println("Question 7:");
		System.out.println(concatenateWord("Dandelion", 5));

		/* Question 8 */
		// See method outside main below
		System.out.println();
		System.out.println("Question 8:");
		System.out.println(getFullName("Geralt", "of Rivia"));

		/* Question 9 */
		// See method outside main below
		System.out.println();
		System.out.println("Question 9:");
		int[] numbersToSum = { 17, 54, 38, 29 };
		System.out.println(isSumOver100(numbersToSum));

		/* Question 10 */
		// See method outside main below
		System.out.println();
		System.out.println("Question 10:");
		double[] doubleArr = { 2.3, 5.9, 2.6, 10.2, 6.4 };
		System.out.println(averageOfDoubles(doubleArr));

		/* Question 11 */
		// See method outside main below
		System.out.println();
		System.out.println("Question 11:");
		double[] doubleArr2 = { 2.43, 16.9, 12.6, 19.2, 6.4 };
		System.out.println(compareAverages(doubleArr, doubleArr2));

		/* Question 12 */
		// See method outside main below
		System.out.println();
		System.out.println("Question 12:");
		System.out.println(willBuyDrink(true, 15.0));
		System.out.println(willBuyDrink(true, 7.0));
		System.out.println(willBuyDrink(false, 15.0));

		/* Question 13 */
		// See method outside main below
		System.out.println();
		System.out.println("Question 13:");
		System.out.println(calculateEarnings(100.0, 0.1));

	}

	/* Question 7 method */
	static String concatenateWord(String word, int n) {
		StringBuilder result = new StringBuilder();

		// Loop n times and concatenate word
		for (int i = 0; i < n; i++) {
			result.append(word);
		}
		// Return result as a String
		return result.toString();
	}

	/* Question 8 method */

	static String getFullName(String firstName, String lastName) {
		return firstName + " " + lastName;
	}

	/* Question 9 method */

	static boolean isSumOver100(int[] numbers) {
		int sum = 0;
		// Get sum of numbers in array
		for (int num : numbers) {
			sum += num;
		}
		// Check if sum is greater than 100
		if (sum > 100) {
			return true;
		}
		return false;
	}

	/* Question 10 method */
	static double averageOfDoubles(double[] numbers) {
		double results = 0;
		// Iterate through array to get the sum of elements
		for (double num : numbers) {
			results += num;
		}
		// Return average of the array
		return results / numbers.length;
	}

	/* Question 11 method */
	static boolean compareAverages(double[] nums1, double[] nums2) {
		double average1 = 0;
		double average2 = 0;
		// Iterate over first array and find average
		for (double num : nums1) {
			average1 += num;
		}
		average1 = average1 / nums1.length;
		System.out.println(average1);

		// Iterate over second array and find average
		for (double num : nums2) {
			average2 += num;
		}
		average2 = average2 / nums2.length;
		System.out.println(average2);

		// Compare average of first array to second
		if (average1 > average2) {
			return true;
		}
		return false;
	}

	/* Question 12 method */
	static boolean willBuyDrink(boolean isHotOutside, double moneyInPocket) {
		// Check if isHotOutside is true and enough moneyInPocket at once
		if (isHotOutside && moneyInPocket > 10.50) {
			return true;
		}
		return false;
	}

	/* Question 13 method */
	static double calculateEarnings(double netProfit, double feePercentage) {
		double earnings = 0;
		// Check that netProfit is not zero
		if (netProfit > 0) {
			// Subtract amount of fee from netProfit
			earnings = netProfit - (netProfit * feePercentage);
		} else {
			// netProfit was zero
			System.out.println("You made no money.");
		}
		return earnings;
	}

}
