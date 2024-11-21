package week03;

import java.util.Scanner;

public class Week03ArrayIceCreamOrder {

//	Class to instantiate an ice cream order Object
	public class ArrayIceCreamOrder {
		String user, size, cupOrCone;
		String[] flavors = new String[3];
		
//		Default constructor
		public ArrayIceCreamOrder() {
			this.user = "";
			this.size = "";
			this.cupOrCone = "";
		}
		
//		Additional constructors
//		Constructor: only user and flavors
		public ArrayIceCreamOrder(String user, String[] flavors) {
			this.user = user;
			this.flavors = flavors;
		}
//		Constructor: full order
		public ArrayIceCreamOrder(String user, String[] flavors, String size, String cupOrCone) {
			this.user = user;
			this.flavors = flavors;
			this.size = size;
			this.cupOrCone = cupOrCone;
		}
		
//		Getters and Setters
		
	}
	
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		/*
		 * Show menu of flavors
		 * Get user flavor choice
		 * Get user ice cream size choice
		 * Get user cup or cone choice
		 */
	}

}
