package week01;

public class PracticeProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println("Hello there!");
		
//		int num1 = 5;
//		int num2 = 5;
//		System.out.println(num1 * num2);
//		System.out.println(3 / 0);
		
		double taxRate = .25;
		double hoursWorked = 40;
		double hourlyRate = 17.52;
		
		double grossPay, netPay;
		
		grossPay = hoursWorked * hourlyRate;
		netPay = grossPay - grossPay * taxRate;
		
		System.out.println(grossPay);
		System.out.printf("Net pay: %.2f", netPay);

	}

}
