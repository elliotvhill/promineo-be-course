package week03;

public class Week03Methods {

	public static void main(String[] args) {
//		
		/* createFullName method: */
		String firstName = "Johnny";
		String lastName = "Appleseed";
		String fullName = createFullName(firstName, lastName);
		String fullName2 = createFullName("Jonathan", lastName);
		
		System.out.println(fullName);
		System.out.println(fullName2);

//		
		/* sumTwoNums method: */
		
//		Variable declarations (visible in `main` only: 
		int firstNum = 3;
		int secondNum = 7;
		
//		Call first method -- pass variables into method as params:
		sumTwoNums(firstNum, secondNum);
		
//		Additional variable declarations:
		int result = 0;
		
//		Call second method:
		result = sumTwoNums(firstNum, secondNum);
		
		System.out.println("The sum is: " + result);
		
//		
		/* sumArray method: */
		int[] myArray = new int[3];
		myArray[0] = 7;
		myArray[1] = 10;
		myArray[2] = 8;
		
		System.out.println(sumArray(myArray));
		
//		
		/* calculateAverage method: */
		double[] arr2 = new double[3];
		arr2[0] = 2.2;
		arr2[1] = 6.7;
		arr2[2] = 4.0;
		
		System.out.println(calculateAverage(arr2));
		
//		
		/* multiplyString method: */
		System.out.println(multiplyString("hello", 3));
		
	}
	
	/*
	 * Takes two strings and concatenates them to print a
	 * full name with a space between the strings
	 */
	public static String createFullName(String x, String y) {  // Method Signature
		/*
		 * Method Signature components: 
		 * 
		 * - `public static` -> access modifiers
		 * - `String` -> return type -- if not returning anything, use `void`
		 * - name of method
		 * - `()` -> parameters, if applicable -- including types
		 */
		return x + " " + y;
	}
	
	/*
	 * Takes two nums and returns the sum
	 */
	public static int sumTwoNums(int num1, int num2) {
		return num1 + num2;
	}
	
	/*
	 * Takes an array of ints and returns the sum of all ints
	 */
	public static int sumArray(int[] numbers) {
		int sum = 0;
		
		for (int number : numbers) {
			sum += number;
		}
		return sum;
	}
	
	/*
	 * Takes an array of doubles and returns the average of 
	 * all elements in the array
	 */
	public static double calculateAverage(double[] numbers) {
		double sum = 0;
		for (double number : numbers) {
			sum += number;
		}
		return sum / numbers.length;
	}
	
	/* 
	 * Takes a String and an int and returns the String 
	 * concatenated with itself int number of times
	 */
	public static String multiplyString(String str, int num) {
		String result = "";
		
		for (int i = 0; i < num; i++) {
			result += str;
		}
		
		return result;
	}
	
}
