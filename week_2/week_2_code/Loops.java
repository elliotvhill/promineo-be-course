package com.promineotech;

public class Loops {

	public static void main(String[] args) {
		/**
		 * We can loop with 2 types of structures. 1- standard loop syntax 2- while +
		 * conditional 3- do while + conditional
		 * 
		 * A for loop follows this syntax: for(the condition counter; the condition
		 * checker; increment the condition count value) { Do something here ... }
		 * 
		 * In plan english, the loop syntax means, I want to loop over a statement x
		 * amount of times until x = my stopping point.
		 */
		System.out.println("Too much coding way :-(");
		System.out.println(0);
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
		System.out.println(6);
		System.out.println(7);
		System.out.println(8);
		System.out.println(9);

		System.out.println("\nBetter coding way :-)");

		// So my loop condition is to is I want to print 10 things
		// The counter starts at 0
		// The condition checker = 10
		// We increment by 1 the counter, then re-loop
		//
		// Count 5 numbers
		// 0 - 4 = 5 numbers
		// 1 - 6 = 5 numbers

		// int i = 0;
		// int i = i + 1;
		// i++;
		// i--;
		// int x = 0;
		// x += 5;

		int results = 0;
		// for(starting point; check; number that is changing)
		for (int i = 1; i > 0; i *= 10) {
			System.out.println(i);
		}

		/**
		 * We now want to do the same thing only using a while + condition
		 * 
		 * while(condition is not true, once true we are done.) { Do something here ...
		 * }
		 * 
		 */
		// So the while statement checks to see if counter < 10, once it is greater
		// then 10, it will exit.
		System.out.println("\nWhile example :-)");
		int counter = 0;
		while (counter < 10) {
			System.out.println(counter);
			counter++;
		}

		/**
		 * We now want to do the same thing only using a while + condition
		 * 
		 * do { Do something here ... } while(condition is not true, once true we are
		 * done.) {
		 * 
		 * 
		 */
		// So the while statement checks to see if counter < 10, once it is greater
		// then 10, it will exit.
		System.out.println("\nDo While example :-)");
		counter = 0;
		do {
			System.out.println(counter);
			counter++;
		} while (counter < 10);

//		Given variables power, base, and result, use a for loop to raise the base to the power of power (i.e. base^power).
//		The loop should run from 1 to the number stored in power
//		In the loop body, result should be multiplied by the base every time the loop iterates and that value stored in result, like this: result *= base or result = result * base
//		Print the value of result to the console

		int base = 2;
		int power = 10;
		int result = 1;

		/**
		 * < > <= =<
		 * 
		 * ++ -- *=
		 * 
		 * 
		 */
		System.out.println("");
		for (int index = 1; index <= power; index++) {
			result = base * result;
			System.out.println(result);
		}

		float test = 21;
		float divider = 4;
		float res = test / divider;

		// ! not operator
		int age = 25;
		boolean isCool = true;
		if (age != 75) {

		}
		// Not isCool == false
		if (!isCool) {

		} else {

		}

		int value = 100;
		if (value % 10 == 0) {

		}

	}
}
