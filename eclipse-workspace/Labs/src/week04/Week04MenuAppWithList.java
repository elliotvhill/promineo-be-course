package week04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Week04MenuAppWithList {

	// Outside main so accessible by all methods
	static Scanner scanner = new Scanner(System.in);
	static List<String> students = new ArrayList<String>();

	public static void main(String[] args) {

		int choice = 0; // the option the user chooses

		while (choice != 4) {

			showMenu();

			choice = getUserChoice();
			if (choice == 1) {
				printStudentNames();
			} else if (choice == 2) {
				addNewStudent();
			} else if (choice == 3) {
				deleteStudent();
			} else if (choice == 4) {
				System.out.println("Goodbye");
			} else {
				System.out.println("Please select a valid option.");
			}

		}

		scanner.close();
	}

	public static void showMenu() {
		System.out.println("1) Print student names");
		System.out.println("2) Add new student");
		System.out.println("3) Delete student at Position");
		System.out.println("4) Exit");
		System.out.println("-------------------------");
		System.out.print("Please make a selection: ");
	}

	public static int getUserChoice() {
		return scanner.nextInt();
	}

	public static void printStudentNames() {
		System.out.println();
		if (students.size() == 0) {
			System.out.println("No students");
			System.out.println();
		} else {
			System.out.println("Students:");
			System.out.println();
			for (String student : students) {
				System.out.println((students.indexOf(student) + 1) + ") " + student);
			}
			System.out.println();
		}
	}

	public static void addNewStudent() {
		System.out.print("Enter the name you would like to add: ");
//		students.add(scanner.next()); // one line if don't need to store value
		String name = scanner.next(); // store as variable to use in future
		students.add(name);
		System.out.println();
		System.out.println("Student added: " + name);
		System.out.println();
	}

	public static void deleteStudent() {
		System.out.print("Enter the index of the student to delete: ");
		int index = getUserChoice();
		if (index - 1 < students.size()) {
			System.out.println();
			System.out.println("Deleted: " + students.get(index - 1));
			students.remove((index) - 1);
			System.out.println();
		}
	}

}
