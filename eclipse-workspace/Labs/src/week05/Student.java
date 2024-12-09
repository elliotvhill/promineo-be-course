package week05;

public class Student {

	// Property that whole class Student shares -- use 'static'
	static int numberOfStudents;

	// Properties of the Student class
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private int gradeLevel;

	// Default constructor (for when no parameters are passed)
	public Student() {
	};

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

	// Private class methods
	private boolean checkLength(String str, int length) {
		return str.length() > length;
	}
	
	// Public class Methods
	public void introduceStudent() {
		System.out.println(String.format("Hello, my name is %s %s.", firstName, lastName));
		System.out.println(String.format("I am in grade %s.", gradeLevel));
		System.out.println(String.format("My phone number is %s.", phoneNumber));
	}

	// Getters and Setters -- access the private fields we declared above and allow us to add logic
	public void setFirstName(String firstName) {
		if (checkLength(firstName, 1)) {
			this.firstName = firstName;
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		if (checkLength(lastName, 1)) {
			this.lastName = lastName;
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setPhoneNumber(String phoneNumber) {
		if (checkLength(phoneNumber, 9)) {
			this.phoneNumber = phoneNumber;
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setGradeLevel(int gradeLevel) {
		if (gradeLevel > 0 && gradeLevel < 13) {
			this.gradeLevel = gradeLevel;
		}
	}

	public int getGradeLevel() {
		return gradeLevel;
	}

}
