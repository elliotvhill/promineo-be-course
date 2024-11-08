package week02;

public class BooleansAndLoops {

	public static void main(String[] args) {
		int ageRequiredToDrive = 16;
		int currentAge = 14;
		currentAge = 30;
		boolean canPersonDrive = (currentAge >= ageRequiredToDrive);
		System.out.println(canPersonDrive); // Output: true

		currentAge = 10;
		System.out.println(canPersonDrive); // this still incorrectly prints 'true' after reassigned on line 9...

		currentAge = 16; // but this works fine...

		if (currentAge >= ageRequiredToDrive) {
			System.out.println("Eligible to drive!");
		} else {
			System.out.println("This person cannot legally drive.");
		}

//		Switch statements
		char grade = 'A';
		grade = 'B';

		switch (grade) {
		case 'A':
			System.out.println("90%");
			break;
		case 'B':
			System.out.println("80%");
			break;
		case 'C':
			System.out.println("70%");
			break;
		default:
			System.out.println("You failed.");
		}

//		'do...while' loops
		int i = 27;

		do {
			i--;
			System.out.println(i);
		} while (i > 24);
	}

}
