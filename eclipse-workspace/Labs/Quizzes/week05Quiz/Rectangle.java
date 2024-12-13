package week05Quiz;

public class Rectangle implements Shape {
	
	private double width;
	private double length;

	@Override
	public double calculatePerimeter() {
		return 2 * (this.width + this.length);
	}

	@Override
	public double calculateArea() {
		return this.width * this.length;
	}

}
