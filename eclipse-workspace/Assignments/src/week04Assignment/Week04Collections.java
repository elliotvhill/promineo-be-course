package week04Assignment;

public class Week04Collections {

	public static void main(String[] args) {
		
		/* Question 1 */
		
		// Create array of int ages
		int[] ages = {3, 9, 23, 64, 2, 8, 28, 93};
		
		// Programmatically subtract first element from last element
		System.out.println(ages[ages.length - 1] - ages[0]);
		
		// Create new array of int ages2
		int[] ages2 = {3, 9, 23, 64, 2, 8, 28, 93, 21};
		
		// Repeat subtraction from above
		System.out.println(ages2[ages2.length - 1] - ages2[0]);
		
		// Calculate average age of ages2
		double sum = 0;
		for (double num : ages2) {
			sum += num;
		}
		System.out.println(sum / ages2.length);
		
		
		/* Question 2 */
		
		// Create array of String names
		String[] names = {"Sam", "Tommy", "Tim", "Sally", "Buck", "Bob"};
		
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
			if (name != names[names.length -1]) {
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
		
		/* Question 4 */
		
		// How do you access the first element of any array?
		// array[0]
		
		
		/* Question 5 */
		
		// Create array of int nameLengths
		int[] nameLengths = new int[names.length];
		// Iterate over names and add lengths to nameLengths
		for (int i = 0; i < names.length; i++) {
			nameLengths[i] = names[i].length();
		}
		for (int length : nameLengths) {
			System.out.println(length);
		}
		
		/* Question 6 */
		
		// Loop through nameLengths and calculate sum
		int lengthsSum = 0;
		for (int length : nameLengths) {
			lengthsSum += length;
		}
		System.out.println(lengthsSum);
		
		/* Question 7 */
		// See method outside main below
		System.out.println(concatenateWord("Dandelion", 5));
		
		/* Question 8 */
		// See method outside main below
		System.out.println(getFullName("Geralt", "of Rivia"));
		
		/* Question 9 */
		// See method outside main below
		int[] numbersToSum = {17, 54, 38, 29};
		System.out.println(isSumOver100(numbersToSum));
		
		/* Question 10 */
		// See method outside main below
		
		
		/* Question 11 */
		// See method outside main below
		
		
		/* Question 12 */
		// See method outside main below
		
		
		/* Question 13 */
		// See method outside main below
		
		
		
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
	
	
	
	/* Question 11 method */
	
	
	/* Question 12 method */
	
	
	/* Question 13 method */
	
	
}
