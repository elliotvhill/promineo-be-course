package week05;

public class VideoCurriculum {

	public static void main(String[] args) {
		
		// Classes video:
		
		// Creating a new instance of the Class StringBuilder
		StringBuilder name = new StringBuilder();

		// Create new instance of Student using a default Constructor:
		Student student1 = new Student();
		student1.firstName = "Geralt";
		student1.lastName = "of Rivia";
		student1.gradeLevel = 12;
		student1.phoneNumber = "1234567890";
		
		student1.introduceStudent();
		
		// Rather than use dot notation for each individual property, use a constructor to create an instance 
		
		Student student2 = new Student("Yennefer", "of Vengerberg");
		student2.introduceStudent();
		
		
		Student student3 = new Student("Tom", "Bombadil", 8, "1230987654");
		student3.introduceStudent();
	}

}
