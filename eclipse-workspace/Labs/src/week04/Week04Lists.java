package week04;

import java.util.List;
import java.util.ArrayList;

public class Week04Lists {

	public static void main(String[] args) {

		String[] cars = new String[3];
		cars[0] = "Buick";
		cars[1] = "Jeep";
		cars[2] = "Dodge";

		/*
		 * List signature: List<E> list of "E" where "E" is the generic 
		 * that will be replaced with the datatype to be used
		 */

		// List<String> // reads as "list of String"

		// can't instantiate a List, have to use ArrayList and import both from java.util
		List<String> divas = new ArrayList<String>(); 

		divas.add("Lady Gaga");
		divas.add("Diana Ross");
		divas.add("Beyonce");

		//		divas.remove(1);

		// Traditional for loop
		for (int i = 0; i < divas.size(); i++) { // uses .size() _method_ (versus .length _property_ of Arrays)
			System.out.println(divas.get(i)); // uses .get() _method_ instead of bracket notation
		}

		// Enhanced for loop
		for (String diva : divas) {
			System.out.println(diva);
		}

		// List<int> numbers = new ArrayList<int>(); // cannot use primitive datatypes, have to use Class, e.g. Integer
		List<Integer> numbers = new ArrayList<Integer>(); // note: Java auto converts int -> Integer and Integer -> int

		/* 
		 * List methods:
		 */

		// .size()
		// .remove()
		// .isEmpty() -> returns boolean


	}

}
