package week05Quiz;

public class KnowledgeQuestions {

	public static void main(String[] args) {

		/*
		 * Question 1:
		 * 
		 * An __INTERFACE__ is like a contract, any class that implements it must also
		 * implement all the methods defined in it. An __ABSTRACT CLASS__ allows you to
		 * provide some functionality while leaving other methods unimplemented for a
		 * sub-class to define the implementation of those methods.
		 */

		/*
		 * Question 2:
		 * 
		 * While __PRIVATE__ fields and methods can only be accessed within the class
		 * they are declared, __PUBLIC__ fields and methods can be accessed anywhere.
		 * __PROTECTED__ fields and methods can be accessed by any class in the same
		 * package where they are declared, as well as in any sub-classes.
		 */

		/*
		 * Question 3:
		 * 
		 * The code below will create an Employee class that contains fields for
		 * firstName, lastName, and phoneNumber, and contains getter and setter methods
		 * for each of the fields.
		 * 
		 * Hint: pay attention to the access modifiers (e.g. public & private), and
		 * which methods return a value and which do not.
		 */

		// see Employee.java

		/*
		 * Question 4:
		 * 
		 * We have provided the Animal interface here:
		 * 
		 * Animal.java:
		 * 
		 * package com.promineotech;
		 * 
		 * public interface Animal {
		 * public void speak();
		 * public void eat();
		 * }
		 * 
		 * Complete the following two classes correctly. Make sure to use the interface
		 * provided above to implement Dog and Cat.
		 * 
		 * See Dog.java and Cat.java
		 * 
		 */

		/*
		 * Question 5:
		 * 
		 * Finish the code below to implement a method that takes a String as a
		 * parameter, and returns true if the String is a palindrome and false if it is
		 * not. A palindrome is a sequence of characters that reads the same forwards
		 * and backwards such as mom, wow, and racecar.
		 * 
		 */
		System.out.println("-----------\nQuestion 5:\n");
		System.out.println(isAPalindrome("hello"));
		System.out.println(isAPalindrome("mom"));

		/*
		 * Question 6:
		 * 
		 * Given the Shape interface below, finish the Rectangle class below that uses
		 * the interface. Hint: think of what fields a rectangle would need to implement
		 * the methods the interface provides.
		 * 
		 * 
		 * public interface Shape {
		 * public double calculatePerimeter(); public double calculateArea();
		 * }
		 * 
		 * Finish the Rectangle class below: See Rectangle.java
		 */

		System.out.println("-----------\nQuestion 6:\n");

		Rectangle rect = new Rectangle();
		rect.width = 2; // problem did not include or specify use of getters & setters...
		rect.length = 2;

		System.out.println(rect.calculateArea());
		System.out.println(rect.calculatePerimeter());
		
		/*
		 * Question 7:
		 * 
		 * Match the Object Oriented Programming concepts with the correct
		 * examples/definitions.
		 * 
		 * The ability for a class to pass fields and methods to a sub-class.
		 * __INHERITANCE__
		 * 
		 * The ability for something to take many forms. This could be a class or a
		 * method. __POLYMORPHISM__
		 * 
		 * Hides the implementation details from the user so that the user knows what
		 * the class does, but not how it does it. __ABSTRACTION__
		 * 
		 * Hides the inner data of a class while providing specific ways to interact
		 * with the inner data indirectly. __ENCAPSULATION__
		 * 
		 */

		/*
		 * Question 8: True or False
		 * 
		 * A class is like a blueprint, an object is an instance of a class. __TRUE__
		 * 
		 */

		/*
		 * Question 9:
		 * 
		 * Which of the following lines of code will compile and correctly instantiate
		 * an instance of the below Person class?
		 * 
		 * public class Person{
		 * 
		 * private String name;
		 * private int age;
		 * 
		 * public Person(String name, int age) { 
		 *  this.name = name; 
		 *  this.age = age; 
		 *  }
		 * }
		 * 
		 * a. Person Person = new Person("Sam", 4);
		 * b. Person person = new Person("Sam", "4");
		 * c. Person person = new Person("Sam", 4);
		 * d. Person person = new Person();
		 * e. Person person = new Person(4, "Sam");
		 * 
		 * ANSWER: C
		 * 
		 */

		/*
		 * Question 10: True or False
		 * 
		 * Static methods can only be accessed on an instance of a class, not from the
		 * class itself. __FALSE__
		 * 
		 * 
		 * For example, assuming doSomething() is a static method:
		 * 
		 * SomeClass instance = new SomeClass();
		 * instance.doSomething(); //will work
		 * SomeClass.doSomething(); //will not work
		 * 
		 */

	}

	// Method for Question 5:
	public static boolean isAPalindrome(String word) {
		for (int i = 0; i < word.length() / 2; i++) {
			if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

}
