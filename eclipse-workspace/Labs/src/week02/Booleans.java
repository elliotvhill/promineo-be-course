package week02;

public class Booleans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int ageRequiredToDrive = 16;
		int currentAge = 14;
//		currentAge = 30;
		boolean canPersonDrive = (currentAge >= ageRequiredToDrive);
		System.out.println(canPersonDrive);
		
		
		// if try to redefine currentAge below boolean declaration, value will not change
//		currentAge = 18;
//		System.out.println(canPersonDrive);
		
	}

}
