package week05;

public class Encapsulation {

	public static void main(String[] args) {
		
		Student student = new Student();
//		student.firstName = "Elrond";
//		System.out.println(student.firstName);
		// Above code is considered poor practice -- need instead to encapsulate object's data
		
		// Same functionality using getters & setters:
		student.setFirstName("Elrond");
		student.setPhoneNumber("1234567890");
		student.introduceStudent();
		
		/*
		 * Access Modifiers:
		 * public		accessible everywhere
		 * private		only accessible from within the class itself
		 * protected		only accessible within the class, other classes in the same package, and all subclasses
		 * No Modifier	same as protected EXCEPT not accessible in subclasses in different packages
		 */
		
		
		RectangleVideoCurriculum rect = new RectangleVideoCurriculum(10.0, 15.0);
		rect.setLength(10);
		System.out.println(rect.getArea());
		

	}

}
