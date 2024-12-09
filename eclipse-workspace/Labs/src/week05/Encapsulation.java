package week05;

public class Encapsulation {

	public static void main(String[] args) {
		
		Student student = new Student();
		student.firstName = "Elrond";
		System.out.println(student.firstName);
		// Above code is considered poor practice -- need instead to encapsulate object's data
		
		/*
		 * Access Modifiers:
		 * public		accessible everywhere
		 * private		only accessible from within the class itself
		 * protected		only accessible within the class, other classes in the same package, and all subclasses
		 * No Modifier	same as protected EXCEPT not accessible in subclasses in different packages
		 */
		
		
		

	}

}
