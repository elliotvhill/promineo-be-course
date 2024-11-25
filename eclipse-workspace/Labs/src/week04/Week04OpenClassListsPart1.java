package week04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Week04OpenClassListsPart1 {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		/*
		 * 1. Create a List of Integer
		 * 
		 * A List of Integer called listNums has been created. A for loop is used to
		 * populate the List with elements, from one to whatever value is stored in the
		 * variable input endNum. Print the List to the console.
		 * 
		 */

//		int endNum = in.nextInt();
		int endNum = 7;
		System.out.println("Question 1:");
		createList(endNum);

		/*
		 * 2. What name will print to the console after the following code runs?
		 * 
		 * A. Mike B. Tyler √ C. Joe D. Nick E. Michael
		 */

		List<String> str = new ArrayList<>();

		str.add("Nick");
		str.add("Joe");
		str.add("Michael");
		str.add("Tyler");
		str.add("Mike");

		System.out.println("Question 2:");
		System.out.println(str.get(3));

		/*
		 * 3. Access a List of String
		 * 
		 * Given a List stored in the variable productList, write code that will access
		 * elements in the List based on the index value stored in indexVal.
		 * 
		 * - First, check to make sure the number is at least zero, and that it is less
		 * than the size of the List - If indexVal is valid, print the product
		 * associated with the value stored at indexVal - If indexVal is not valid, then
		 * print "No product can be found with that product number." to the console
		 * 
		 */
//			int indexVal = in.nextInt();
		int indexVal = 3;
		System.out.println("Question 3:");
		accessListOfString(indexVal);

		/*
		 * 4. Looking at the code below, what line would print out the character 'c' to
		 * the console?
		 * 
		 * A. System.out.println(newChars.get(3)); B.
		 * System.out.println(newChars.get(2)); √ C. System.out.println(newChars[3]); D.
		 * System.out.println(newChars[2]);
		 * 
		 */
		List<Character> newChars = new ArrayList<>();
		newChars.add('a');
		newChars.add('b');
		newChars.add('c');
		newChars.add('d');
		newChars.add('e');

		System.out.println("Question 4:");
		System.out.println(newChars.get(2));

		/*
		 * 5. Create a new List of String
		 * 
		 * Given a List called tenWords that contains ten different words, write code
		 * that will find the values stored in 3 particular positions in the List
		 * tenWords and creates a new List with those words. Create a new List of String
		 * called threeWords Given num1, num2, and num3 as indexes, retrieve three words
		 * stored in tenWords Populate the List threeWords with the three elements
		 * retrieved from tenWords After adding the three words to your new List, print
		 * out the List stored in threeWords to the console
		 * 
		 * Error Checking:
		 * 
		 * Check that each number entered for num1, num2, and num3 is a number from 0 to
		 * 9 Otherwise, print
		 * "Sorry, there was an error getting a number you requested."
		 * 
		 */

//			int num1 = in.nextInt();
//			int num2 = in.nextInt();
//			int num3 = in.nextInt();

		int num1 = 9;
		int num2 = 8;
		int num3 = 2;

		List<String> tenWords = new ArrayList<String>();
		tenWords.add("Bumfuzzle");
		tenWords.add("Cattywampus");
		tenWords.add("Widdershins");
		tenWords.add("Gubbins");
		tenWords.add("Lollygag");
		tenWords.add("Malarkey");
		tenWords.add("Wabbit");
		tenWords.add("Impignorate");
		tenWords.add("Yarborough");
		tenWords.add("Bloviate");

		System.out.println("Question 5:");
		wordReplace(tenWords, num1, num2, num3);

		/*
		 * 6. What is the value stored in the variable `letter` after the code below
		 * runs?
		 * 
		 * A. b B. e C. a D. d √ E. c
		 * 
		 */

		System.out.println("Question 6:");

		List<Character> newChars2 = new ArrayList<>();
		newChars2.add('a');
		newChars2.add('b');
		newChars2.add('c');
		newChars2.add('d');
		newChars2.add('e');

		char letter = newChars2.remove(3);
		System.out.println(letter);

		/*
		 * 7. Create a New List of Integer
		 * 
		 * Given four int numbers stored in the variables num1, num2, num3, and num4
		 * Create a List of Integer, give it a name Store all of the values of the
		 * variables in the List as its elements Add an element to the end of the List
		 * that stores the sum of all the values Print the List to the console
		 * 
		 */
		int num5, num6, num7, num8;
		num5 = -1;
		num6 = -2;
		num7 = -3;
		num8 = -4;

//				num5 = in.nextInt();
//				num6 = in.nextInt();
//				num7 = in.nextInt();
//				num8 = in.nextInt();

		System.out.println("Question 7:");
		sumList(num5, num6, num7, num8);

		/*
		 * 8. What is the correct method for determining how many elements are in a
		 * List?
		 * 
		 * A. someList.size() √ B. someList.length C. someList.length(); D.
		 * someList.size
		 * 
		 */

		/*
		 * 9. Create a List of Integer
		 * 
		 * Given the value stored in the variable endNum, do the following:
		 * 
		 * - Create a List of Integer called newList - Add the numbers 1 to endNum to
		 * the List using a loop - Then, print the first element from the List to the
		 * console using "The first number in the List is " + method to get the first
		 * element - Finally, print the last element of the List to the console using
		 * "The last number in the List is " + method to get the last element - The last
		 * element of the List should NOT be retrieved using a hard-coded index like
		 * someList.get(10)
		 * 
		 * Note: Before creating the List, check if endNum is greater than zero and if
		 * it is, then proceed creating the List. If endNum is not greater than zero,
		 * then simply print "Your List cannot be created with a number less than one."
		 * 
		 */
		System.out.println("Question 9:");

//				int endNum2 = in.nextInt();
		int endNum2 = 7;

		beginEnd(endNum2);

		/*
		 * 10. What will print to the console when the following code runs?
		 * 
		 * A. 17 B. 54992 C. An "Out of Bounds" error message √
		 * 
		 */
		System.out.println("Question 10:");

		List<Integer> newInts = new ArrayList<>();
		newInts.add(143);
		newInts.add(-93);
		newInts.add(54992);
		newInts.add(17);

//				System.out.println(newInts.get(newInts.size()));

	}

	/********************** METHODS **********************/

	/* Question 9: */

	static void beginEnd(int endNum) {
		if (endNum > 0) {
			List<Integer> newList = new ArrayList<Integer>();
			for (int i = 1; i <= endNum; i++) {
				newList.add(i);
			}
			System.out.println("The first number in the List is " + newList.get(0));
			System.out.println("The last number in the list is " + newList.get(endNum - 1));
		} else {
			System.out.println("Your List cannot be created with a number less than one.");
		}

	}

	/* Question 7: */

	static void sumList(int num1, int num2, int num3, int num4) {

		List<Integer> listOfNums = new ArrayList<Integer>();
		listOfNums.add(num1);
		listOfNums.add(num2);
		listOfNums.add(num3);
		listOfNums.add(num4);

		int result = 0;
		for (int num : listOfNums) {
			result += num;
		}

		listOfNums.add(result);
		System.out.println(listOfNums);
	}

	/* Question 5: */

	static void wordReplace(List<String> tenWords, int num1, int num2, int num3) {

		List<String> threeWords = new ArrayList<String>();

		if (num1 >= 0 && num1 < 10 && num2 >= 0 && num2 < 10 && num3 >= 0 && num3 < 10) {
			threeWords.add(tenWords.get(num1));
			threeWords.add(tenWords.get(num2));
			threeWords.add(tenWords.get(num3));
			System.out.println(threeWords);
		} else {
			System.out.println("Sorry, there was an error getting a number you requested.");
		}

	}

	/* Question 3: */
	static void accessListOfString(int indexVal) {

		List<String> productList = new ArrayList<>();

		productList.add("Macbook");
		productList.add("HP Notebook");
		productList.add("iPhone 14");
		productList.add("Acer Aspire");
		productList.add("Windows Surface");
		productList.add("Galaxy S23");
		/***** DO NOT CHANGE THE CODE ABOVE THIS LINE *****/

		// WRITE YOUR CODE HERE
		if (indexVal >= 0 && indexVal < productList.size()) {
			System.out.println(productList.get(indexVal));
		} else {
			System.out.println("No product can be found with that product number.");
		}

	}

	/* Question 1: */
	static void createList(int endNum) {

		List<Integer> listNums = new ArrayList<>();

		for (int i = 1; i <= endNum; i++) {
			listNums.add(i);
		}
		/***** DO NOT CHANGE THE CODE ABOVE THIS LINE *****/
		// WRITE YOUR CODE HERE
		System.out.println(listNums);

		/***** DO NOT CHANGE THE CODE BELOW THIS LINE *****/
	}

}
