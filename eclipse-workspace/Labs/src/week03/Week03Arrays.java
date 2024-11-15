package week03;

import java.util.Scanner;

public class Week03Arrays {

	public static void main(String[] args) {
		
		String[] students = new String[3]; 
		  
		/* Note: Arrays are not dynamic/flexible -> must specify size upon declaration */ 
		  
		students[0] = "Elizabeth Swan";
		students[1] = "Jack Sparrow";
		students[2] = "Will Turner";

		/* Regular `for` loop */
		System.out.println("`for` loop:");
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i]);
		}
		
		int[] gradesArray = {100, 97, 80, 85, 79};
		System.out.println("Grades:");
		for (int i = 0; i < 5; i++) {
			System.out.println((i + 1) + ": " + gradesArray[i]);
		}
		
		
		/* Enhanced `for` loop */
		System.out.println("Enhanced `for` loop:");
		for (String student : students) {
			System.out.println(student);
		}
		
		int counter = 1;
		System.out.println("Grades:");
		for (int grade : gradesArray) {
			System.out.println((counter++) + ": " + grade);
		}
		
//		
//		
		/*
		 * Coding Challenge:  As a stretch, you could convert these examples 
		 * to use the Java Scanner() as was described in the "User Input 
		 * Section of Week 2: Weekly Curriculum & Videos".
		 */
//		
		Scanner in = new Scanner(System.in);
//		
//		int[] userGradesArray = new int[5];
//		userGradesArray[0] = in.nextInt();
//		userGradesArray[1] = in.nextInt();
//		userGradesArray[2] = in.nextInt();
//		userGradesArray[3] = in.nextInt();
//		userGradesArray[4] = in.nextInt();
//		
//		for (int userGrade : userGradesArray) {
//			System.out.println("Grade: " + userGrade);
//		}
//		
//		
		String[] groceries = new String[5];
		
		groceries[0] = "Carrots";
		groceries[1] = "Apples";
		groceries[2] = "Granola";
		groceries[3] = "Broccoli";
		groceries[4] = "Pretzels";
		
		for (String grocery : groceries) {
			System.out.println("Product is: " + grocery);
		}
		
		
		int[] multiplesOf3 = new int[10];
		
		/*
		 * Use a `for` loop instead of manually creating each value 
		 */
		for (int i = 1; i <= multiplesOf3.length; i++) {
			multiplesOf3[i - 1] = i * 3;
			System.out.println("number: " + multiplesOf3[i - 1]);
		}
		
		
		int[] multiplesOf5 = new int[10];
		for (int i = 0; i < multiplesOf5.length; i++) {
			multiplesOf5[i] = (i + 1) * 5;
			System.out.println(multiplesOf5[i]);
		}
		
		in.close();
		
	}

}


















