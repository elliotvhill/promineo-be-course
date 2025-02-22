package week05Quiz;

public class Rectangle implements Shape {
	
	double width;
	double length;

	@Override
	public double calculatePerimeter() {
		return 2 * (this.width + this.length);
	}

	@Override
	public double calculateArea() {
		return this.width * this.length;
	}

}
