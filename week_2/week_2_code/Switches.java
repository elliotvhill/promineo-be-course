package com.promineotech;

public class Switches {
	public static void main(String[] args) {
		
		/**
		 * We are using a Char to determine the percentage based on the grade.
		 * switch - defines the variable you want to check.
		 * case - is what match you are looking for.
		 * break - means we found the case we want to we finish.
		 * default - this is what we print when no other case match.
		 */
		char grade = 'D';

		switch (grade) {
		case 'A':
			System.out.println("90-100");
			break;
		case 'B':
			System.out.println("80-89");
			break;
		case 'C':
			System.out.println("70-79");
			break;
		case 'D':
			System.out.println("60-69");
			break;
		default:
			System.out.println("0-59");
		}
	}
}
