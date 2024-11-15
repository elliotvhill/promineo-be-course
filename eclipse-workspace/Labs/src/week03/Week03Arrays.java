package week03;

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
		
		/* Enhanced `for` loop */
		System.out.println("Enhanced `for` loop:");
		for (String student : students) {
			System.out.println(student);
		
		}
	}

}
