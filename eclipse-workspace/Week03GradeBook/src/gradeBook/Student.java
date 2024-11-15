package gradeBook;

// Student Class containing an array of grades
public class Student {
	String fullName = "";
	int[] grades;

//	Constructor object
	public Student(String fName, int[] grades) {
		this.fullName = fName;
		this.grades = grades;
	}

//	Method to describe Student or print data
	public void describe() {
		System.out.println("Student: " + this.fullName);
		System.out.println("Grades: ");

		for (int grade : this.grades) {
			System.out.println("\t" + grade + " ");
		}
		System.out.println();
	}
}
