package week05;

public class SalariedEmployee extends Employee {

	public SalariedEmployee(String firstName, String lastName, double pay) {
		super(firstName, lastName, pay); // Refers to the Employee class constructor
	}

	@Override
	public double calculatePay() {
		return getPay() * 80;
	}

}
