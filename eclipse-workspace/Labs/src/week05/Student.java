package week05;

public class Student {

	// Property that whole class Student shares -- use 'static'
	static int numberOfStudents;
	
	// Properties of the Student class
	String firstName;
	String lastName;
	String phoneNumber;
	int gradeLevel;
	
	// Default constructor (for when no parameters are passed)
	public Student() { };
	
	// Constructor for when only firstName and lastName are passed
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	// Create Student constructor -- this is an example of overloading
	public Student(String firstName, String lastName, int gradeLevel, String phoneNumber) {
		this.firstName = firstName; // set firstName of THIS instance to the firstName argument passed
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.gradeLevel = gradeLevel;
	};
	
	// Student class Methods
	public void introduceStudent() {
		System.out.println(String.format("Hello, my name is %s %s.", firstName, lastName));
		System.out.println(String.format("I am in grade %s.", gradeLevel));
		System.out.println(String.format("My phone number is %s.", phoneNumber));
	}
	
}
