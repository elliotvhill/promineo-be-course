package gradeBook;

import java.util.Scanner;

public class GradeBook {

//	Instantiating a Student Object
	public static void main(String[] args) {
		String fullName = "";
		String lineVariable = "---------------------------";
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Grade Book Example");
		
		System.out.println("Name of Course:");
		String courseName = sc.nextLine();
		
		System.out.println("How many students are in this class:");
		int numOfStudents = sc.nextInt();
		
//		Declare Array of programming students of length numOfStudents from user input
		Student[] programmingStudents = new Student[numOfStudents];
		
		System.out.println("How many grades do you have per student?");
		int numOfGrades = sc.nextInt();
		
		sc.nextLine();
		
		for (int i = 0; i < programmingStudents.length; i++) {
//			Declare Array of length of user entered grades (numOfGrades)
			int[] grades = new int[numOfGrades];
			System.out.print("Enter Student's Full Name: ");
			fullName = sc.nextLine();
			
			for (int j = 0; j < grades.length; j++) {
				System.out.print("Enter a grade: ");
//				Insert grade into grades Array
				grades[j] = sc.nextInt();
			}
//			Insert new student into students Array
			programmingStudents[i] = new Student(fullName, grades);
			sc.nextLine();
		}
		
		System.out.println("\n\n" + lineVariable + "\n");
		
		for (Student student : programmingStudents) {
			/*
			 * Call describe method on each student in programmingStudents 
			 * to print student data
			 */
			student.describe();
		}
		
		System.out.println(lineVariable + "\n");

		
		sc.close();
	}

}
