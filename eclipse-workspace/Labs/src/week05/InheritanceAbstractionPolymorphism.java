package week05;

public class InheritanceAbstractionPolymorphism {

	public static void main(String[] args) {

		Employee salary = new SalariedEmployee("Geralt", "of Rivia", 2500.00);
		Employee hourly = new HourlyEmployee("Dandelion", "the Bard", 15.00, 75.3);
		Employee manager = new Manager("Rick", "Sanchez", 4500.00, 15.5);

		System.out.println(salary.calculatePay());
		System.out.println(hourly.calculatePay());
		System.out.println(manager.calculatePay());

	}

}
