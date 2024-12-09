package week05;

public class CreateObjectDemo {

	/* 
	 * Example from Java docs tutorial: 
	 * https://dev.java/learn/classes-objects/creating-objects/ 
	 */
	
	public static void main(String[] args) {
		
		// Declare and create a point object and two rectangle objects:
		Point originOne = new Point(23, 94);
		Rectangle rectOne = new Rectangle(originOne, 100, 200);
		Rectangle rectTwo = new Rectangle(50, 100);
		
		// Display rectOne's width, height, and area:
		System.out.println("Width of rectOne: " + rectOne.width);
		System.out.println("Height of rectOne: " + rectOne.height);
		System.out.printf("Area of rectOne: %s%n", rectOne.getArea());
		
		// Set rectTwo's position:
		rectTwo.origin = originOne;
		
		// Display rectTwo's position:
		System.out.printf("X Position of rectTwo: %s%n", rectTwo.origin.x);
		System.out.printf("Y Position of rectTwo: %s%n", rectTwo.origin.y);
		
		// Move rectTwo and display its new position:
		rectTwo.move(40, 72);
		System.out.printf("New X Position of rectTwo: %s%n", rectTwo.origin.x);
		System.out.printf("New Y Position of rectTwo: %s%n", rectTwo.origin.y);
		
		
		/*
		 * Output:
		 * 
		 * Width of rectOne: 100
		 * Height of rectOne: 200
		 * Area of rectOne: 20000
		 * X Position of rectTwo: 23
		 * Y Position of rectTwo: 94
		 * X Position of rectTwo: 40
		 * Y Position of rectTwo: 72
		 */
	}

}
