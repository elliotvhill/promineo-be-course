package week04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Week04OpenClassListsPart2 {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		/*
		 * 11. Every Other
		 * 
		 * Given a List of String called words and containing 5 values entered by the
		 * user stored in the variables word1, word2, word3, word4, and word5, create a
		 * new List.
		 * 
		 * - Create a new List of String called newList 
		 * - This new List will contain every other List item from the original 
		 * List called words starting with the first item 
		 * - When done populating newList, execute your code to see what
		 * prints to the console 
		 * - Use a loop to populate the newList with elements
		 * 
		 */
		System.out.println("Question 11:");

		String word1, word2, word3, word4, word5;
		word1 = "Java";
		word2 = "JavaScript";
		word3 = "MySQL";
		word4 = "HTML";
		word5 = "SpringBoot";
//		word1 = in.nextLine();
//		word2 = in.nextLine();
//		word3 = in.nextLine();
//		word4 = in.nextLine();
//		word5 = in.nextLine();

		List<String> words = new ArrayList<>();
		words.add(word1);
		words.add(word2);
		words.add(word3);
		words.add(word4);
		words.add(word5);

		halfList(words);

		/*
		 * 12. What will print to the console when the code below runs?
		 * 
		 * A. an error message 
		 * B. [-1, 43, 894, 1077, 54329] √ 
		 * The Java Collections.sort() method actually sorts and replaces the items in the List
		 * in sorted order. 
		 * C. nothing, but no error message 
		 * D. [894, -1, 1077, 43, 54329]
		 * 
		 */
		System.out.println("Question 12:");

		List<Integer> newInts = new ArrayList<>();
		newInts.add(894);
		newInts.add(-1);
		newInts.add(1077);
		newInts.add(43);
		newInts.add(54329);

		Collections.sort(newInts);
		System.out.println(newInts);

		/*
		 * 13. Create a List of Squared Numbers
		 * 
		 * Given five numbers by the user stored in num1, num2, num3, num4, and num5: 
		 * - Create a List of Integer called squaredNums 
		 * - Add the squared values of each user number as elements to squaredNums 
		 * - Finally, return squaredNums
		 * 
		 */

		System.out.println("Question 13:");

		int num1 = 1;
		int num2 = 2;
		int num3 = 3;
		int num4 = 4;
		int num5 = 5;
//		int num1 = in.nextInt();
//		int num2 = in.nextInt();
//		int num3 = in.nextInt();
//		int num4 = in.nextInt();
//		int num5 = in.nextInt();
		System.out.println(squaredList(num1, num2, num3, num4, num5));

		/*
		 * Question 14: Lists are a part of or a sub-interface of which one of the
		 * following choices:
		 * 
		 * A. ArrayList 
		 * B. LinkedList 
		 * C. Collections √ 
		 * D. Maps
		 */

		/*
		 * Question 15: Print Index of userLetter
		 * 
		 * Given a List of char called alphabet, search the List for the char stored in
		 * userLetter and print to the console the index value of that char.
		 * 
		 */

		System.out.println("Question 15:");

//		char userLetter = in.next().charAt(0);
		char userLetter = 'n';

		List<Character> alphabet = new ArrayList<>();
		for (int i = 97; i < (97 + 26); i++) {
			alphabet.add((char) i);
		}

		findLetter(alphabet, userLetter);

		/*
		 * Question 16: If the List `alphabet` in the code below contains all lower case
		 * letters of the alphabet, what will print to the console when the
		 * `System.out.println()` is reached?
		 * 
		 * A. all the letters of the alphabet 
		 * B. all the letters of the alphabet, except for 'a' √ 
		 * C. nothing 
		 * D. a
		 */

		System.out.println("Question 16:");

		alphabet.remove(0);
//		System.out.println(alphabet);

		/*
		 * Question 17: List of Factors
		 * 
		 * Given a variable int called userNumber, create a List of Factors and print
		 * the List to the console.
		 * 
		 * - Create a List of Integer Factors by declaring a new List variable, name it
		 * factorNum 
		 * - Find all the positive factors of userNumber using a loop from 1
		 * to userNumber 
		 * - In the loop, store the factors of userNumber as elements of
		 * the factorNum List 
		 * - Finally, print the List to the console
		 * 
		 * Note: All values of userNumber will have two (2) possible factors at a
		 * minimum: one (1) and userNumber.
		 */

		System.out.println("Question 17:");

//		int userNumber = in.nextInt();
		int userNumber = 7;
		factors(userNumber);

		/*
		 * Question 18: What will print to the console when the code below runs?
		 * 
		 * A. 14.25 
		 * B. false 
		 * C. true √
		 */
		System.out.println("Question 18:");

		List<Double> measurements = new ArrayList<>();
		measurements.add(1.12);
		measurements.add(6.9);
		measurements.add(14.25);
		measurements.add(20.84);
		System.out.println(measurements.contains(14.25));

		/*
		 * Question 19: Given an initialized LinkedList called line containing 3
		 * elements that represent people standing in line for a rollercoaster ride. The
		 * names of the people in line are "Amanda", "Brad", and "Cori", in that order.
		 * It is now Amanda's turn to ride. Do the following:
		 * 
		 * - Remove the first element of the List, "Amanda" 
		 * - Add another element to the end of the List, this element is "Danny" 
		 * - Execute your code. The List should change from [Amanda, Brad, Cori] to [Brad, Cori, Danny].
		 */

		System.out.println("Question 19:");

		LinkedList<String> line = new LinkedList<String>();
		line.add("Amanda");
		line.add("Brad");
		line.add("Cori");

		System.out.println("People in line: " + line);
		System.out.println("First person in line was: " + line.get(0));
		System.out.println("The last person in line was: " + line.get(2));

		/***** DO NOT CHANGE THE CODE ABOVE THIS LINE *****/

		// WRITE YOUR CODE HERE
		line.remove(0);
		line.add("Danny");

		/***** DO NOT CHANGE THE CODE BELOW THIS LINE *****/
		System.out.println("People in line now: " + line);
		System.out.println("Now the first person in line is: " + line.get(0));
		System.out.println("The last person in line is: " + line.get(2));

		/*
		 * Question 20: Which of the following data structures is BEST suited for a
		 * requirement where elements are frequently added or removed from the middle of
		 * the List?
		 * 
		 * A. None of the above 
		 * B. ArrayList 
		 * C. LinkedList √
		 * 
		 */

	}

	/********************* METHODS *********************/

	/* Question 17: */
	static void factors(int userNumber) {

		List<Integer> factorNum = new ArrayList<Integer>();

		if (userNumber > 0) {
			for (int i = 1; i <= userNumber; i++) {
				if (userNumber % i == 0) {
					factorNum.add(i);
				}
			}
			System.out.println(factorNum);
		} else {
			System.out.println("Number must be greater than 0.");
		}
	}

	/* Question 15: */
	static void findLetter(List<Character> alphabet, char userLetter) {

		System.out.println(alphabet.indexOf(userLetter));

	}

	/* Question 13: */
	static List<Integer> squaredList(int num1, int num2, int num3, int num4, int num5) {

		List<Integer> rootNums = Arrays.asList(num1, num2, num3, num4, num5);

		List<Integer> squaredNums = new ArrayList<Integer>();
		for (int num : rootNums) {
			squaredNums.add(num * num);
		}
		return squaredNums;
	}

	/* Question 11: */

	static void halfList(List<String> words) {

		// WRITE YOUR CODE HERE
		List<String> newList = new ArrayList<String>();

		for (int i = 0; i < words.size(); i++) {
			if (i % 2 == 0) {
				newList.add(words.get(i));
			}
		}

		/***** DO NOT CHANGE THE CODE BELOW THIS LINE *****/
		System.out.println("The old List is: " + words);
		System.out.println("The new List is: " + newList);
	}

}
