package week03;

import java.util.Scanner;

public class Week03Objects {

	public static void main(String[] args) {

		String name = "Geralt of Rivia";
		System.out.println(name.length());
		System.out.println(name.charAt(3));

		Scanner s = new Scanner(System.in);

		int[] numbers = new int[3];
		System.out.println(numbers.length);

//		
		/*
		 * Equality
		 */

		String a = new String("Hello");
		String b = new String("Hello");

		System.out.println(a);
		System.out.println(b);
		System.out.println(a == b); // False

		int x = 5;
		int y = 5;

		System.out.println(x);
		System.out.println(y);
		System.out.println(x == y); // True

		/*
		 * 
		 * Equivalence operator, `==`, checks if values are the _same value in memory_
		 * 
		 * With Primitive data types--e.g. `x` and `y` above--they are pointing to the
		 * same exact value in memory.
		 * 
		 * With Objects, each is its own instance in memory-- regardless whether the
		 * actual value is the same.
		 * 
		 */

		String c = new String("Hello");
		String d = c;

		System.out.println(c);
		System.out.println(d);
		System.out.println(c == d);
		// True because d is assigned the literal _same object in memory_

		/*
		 * To check if two objects have the same values, have to use the `equals()`
		 * method.
		 */

		System.out.println("equals() method: " + a.equals(b)); // True

//		
		s.close();
	}

}
