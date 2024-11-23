package week04;

public class Week04StringBuilder {

	public static void main(String[] args) {

		String firstName = "Geralt";
		String lastName = "of Rivia";

		System.out.println(firstName + " " + lastName);

		String tripleHi = multiplyString("Hi", 3);
		System.out.println(tripleHi);

//		System.out.println(firstName.concat(lastName));
		firstName.concat(lastName);
		System.out.println(firstName);

		StringBuilder fullName = new StringBuilder("Triss");
		fullName.append(" Merigold");

		/*
		 * StringBuilder methods
		 */

		// toString
		System.out.println(fullName.toString()); // actually don't need to use .toString() here as it is implicitly
													// called in any println statement

		// charAt
//		System.out.println(fullName.charAt(6));

		// deleteCharAt
//		System.out.println(fullName.deleteCharAt(6));
//		System.out.println(fullName.toString());

		// delete
//		System.out.println(fullName.delete(1, 3));

		// indexOf
//		System.out.println(fullName.indexOf("ig"));

		// length

		// replace
//		System.out.println(fullName.replace(6, 9, "booo"));

		// reverse
		System.out.println(fullName.reverse());

		/*
		 * Coding Challenge: Write code that reverses a variable of type StringBuilder()
		 * without using the reverse() method, and then print the result to the Console.
		 */

		System.out.println(reverseString("Dandelion"));

	}

	public static String multiplyString(String str, int num) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < num; i++) {
			result.append(str);
		}
		return result.toString(); // use .toString() to match return type declared in method signature
	}

	public static String reverseString(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(str.length() - 1 - i));
		}
		return sb.toString();
	}

}
