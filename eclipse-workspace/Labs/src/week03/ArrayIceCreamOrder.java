package week03;

public class ArrayIceCreamOrder {

//	Class used to instantiate an ice cream order Object
	String user, size, cupOrCone;
	String[] flavors = new String[3];

//		Default constructor
	public ArrayIceCreamOrder() {
		this.user = "";
		this.size = "";
		this.cupOrCone = "";
	}

//		Additional constructors
//		Constructor: only user and flavors (?)
	public ArrayIceCreamOrder(String user, String[] flavors) {
		this.user = user;
		this.flavors = flavors;
	}

//		Constructor: full order (?)
	public ArrayIceCreamOrder(String user, String[] flavors, String size, String cupOrCone) {
		this.user = user;
		this.flavors = flavors;
		this.size = size;
		this.cupOrCone = cupOrCone;
	}

//		Getters and Setters
	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String[] getFlavors() {
		return this.flavors;
	}

	public void setFlavors(String[] flavors) {
		this.flavors = flavors;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCupOrCone() {
		return this.cupOrCone;
	}

	public void setCupOrCone(String cupOrCone) {
		this.cupOrCone = cupOrCone;
	}

//		Describe method
	public void describe(int iceCreamCount) {
		int printFlavors = 0;
		int boxSize = 40; // i.e. the size of a character box to print, like on a receipt
		char star = '*';

		/*
		 * Print out customer and order information like a receipt
		 */
		for (int i = 0; i < boxSize; i++) {
			System.out.print(star); // print stars to create the 'box' as if a receipt
		}
		System.out.println("\nIce Cream Order:\n--------------");
		System.out.print("Name:\n\t" + this.user + "\nOrder: \n\t");
		System.out.println(this.size + " " + this.cupOrCone);

		System.out.println("Flavors:\n\t");
		while (printFlavors < iceCreamCount) {
			System.out.print(this.flavors[printFlavors++]); // incrementing w/in print statement
			if (printFlavors == iceCreamCount - 1) {
				// if flavor is second to last one add an '&'
				System.out.print(" & \n\t");
			} else if (printFlavors < iceCreamCount - 1) {
				// if flavor is not penultimate or ultimate flavor, print with a comma to make a
				// list
				System.out.print(", \n\t");
			}
		} // end of while loop
	} // end of describe method

} // end of ArrayIceCreamOrder class
