package week05;

public abstract class Employee {
	/*
	 * 'abstract' means it cannot be instantiated -- it's just an abstraction of an
	 * employee
	 */

	/*
	 * Fields
	 */
	private String firstName, lastName;
	private double pay;
	private String address;
	private String reportsTo;
	private double bonusPercentage;

	/*
	 * Methods
	 */

	// Constructors
	public Employee(String firstName, String lastName, double pay) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.pay = pay;
	}

	/*
	 * This is an example of polymorphism bc each class can implement it a little
	 * differently. This method _has_ to be implemented by classes that inherit it.
	 */
	public abstract double calculatePay();

	public String getInformation() {
		return String.format("Name: %s %s%n Reports to: %s%n Address: %s", firstName, lastName, reportsTo, address);
	}

	/*
	 * Getters & setters
	 */

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getPay() {
		return pay;
	}

	public void setPay(double pay) {
		this.pay = pay;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(String reportsTo) {
		this.reportsTo = reportsTo;
	}

	public double getBonusPercentage() {
		return bonusPercentage;
	}

	public void setBonusPercentage(double bonusPercentage) {
		this.bonusPercentage = bonusPercentage;
	}

}
