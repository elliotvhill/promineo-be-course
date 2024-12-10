# Java 5: Weekly Curriculum & Videos

### Table of contents

1. [OOP Concepts](#1-oop-concepts)
2. [Classes](#2-classes)
3. [The Pillars of Object-Oriented Programming](#3-the-pillars-of-object-oriented-programming)
4. [Exceptions](#4-exceptions)
5. [Interfaces](#5-interfaces)
6. [OOP Menu App](#6-oop-menu-app)


## 1. OOP Concepts

### What is OOP?


**Object Oriented Programming** (**OOP**) is a programming paradigm. **Java** is an Object Oriented Language, which means that it supports **OOP**, providing features that support and implement the **Four Pillars of OOP**. 

In **OOP**, **objects** are the key construct in our programming, and these **objects** contain **properties** and **functionality**. Instead of writing code all in one place, we structure our program into **objects**. Each object will contain relevant **properties** and **functionality**, which is code that is structured into methods that can be used over and over.  

In **OOP**, programs are written by creating **objects** that contain both data (**properties**) and methods (**functionality**), in contrast with _procedural programming_ where data exists, and procedures and methods perform operations on the data.

It takes time to start to think of **data** as being stored in an **object** which also contains all of the **methods** written for that object. Another way to explain this is to think of an **object**, and imagine that everything that you need (data or methods) is accessible anytime you reference that **object**. If you have access to the **object**, you also have access to any available property and functionality that belong to that **object**.


### Terminology -- Classes vs. Objects:

**Classes** are the mechanism by which we structure our code in OOP.

* A **Class** is a blueprint, in which you create your properties and functionality.
* An **Object** is the actual product developed from the blueprint.  

An **Object** is an **instance** of a **Class**!

So, a **class** is a template for **objects**, and an **object** is an instance of a **class**. When we create an **object** from a **class**, that object will inherit everything in the **class**, including the properties and functionality.


### Description of a Class, and an Object created from the Class:

**Class:**  Animal

**Properties:**

* name
* weight
* type
* location

**Functionality:**

* `describe()`

**Object:**  dog 

A dog will be instantiated as an instance of the class, Animal.

```java
Animal dog = new Animal();
```


### Preview:

In the next chapter, **2. Classes**, you will find a Java example that creates a class _Animal_, and creates a class _AnimalMain_, in which we have a `main` method, as well as two objects created from the class _Animal_:  _elephant_ and _kangaroo_.

### Resource:

- [The Java Tutorials Object-Oriented Programming Concepts](https://docs.oracle.com/javase/tutorial/java/concepts/interface.html)



## 2. Classes

Let's create an example of a **class** and an **object**.

First, we are going to create a class called _Animal_.  This class will have two constructors, getters, setters, and a `describe()` method.

#### This is the class `Animal.java`:

Notice that the class name is written in pascal case (not camel case).

```java
package com.promineotech;

public class Animal {
    String name;
    String type;
    double weight;
    double height;
    String location;

    public Animal() { } // Side question: why is this here?

    public Animal(String name, String type,
    double weight, double height, String location ) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.height = height;
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return this.weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height  = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void describe() {
        System.out.println("Animal Description");
        System.out.println("------------------");
        System.out.println("\tName: " + name);
        System.out.println("\tType: " + type);
        System.out.println("\tWeight: " + weight + " lb.");
        System.out.println("\tHeight: " + height + " in.");
        System.out.println("\tLocated at: " + location);
    }
}
```

Here is the class containing the main method that creates an **object** from the above **class**:

```java
package com.promineotech;

public class AnimalMain {
    public static void main(String[] args) {

        // Use the Constructor to set the information upon 
        //     creation of the Object.
        Animal elephant = new Animal("Dumbo", "elephant", 8000, 108, "Disneyland");

        elephant.describe();

        System.out.println("\n\nLet's access individual fields:");
        System.out.println("-------------------------------");
        System.out.println("Our elephant is named: " + elephant.getName());

        // EXAMPLE:  Create an Object with the Default Constructor
        //           and use the Setters to store information
        System.out.println("\n\n\n");
        Animal kangaroo = new Animal();

        kangaroo.setName("Jack");
        kangaroo.setType("Kangaroo");
        kangaroo.setWeight(150);
        kangaroo.setHeight(48);
        kangaroo.setLocation("Taronga Zoo");

        kangaroo.describe();
    }
}
```

### Resources:

- [The Java Tutorials: Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html)
- [The Java Tutorials: Objects](https://docs.oracle.com/javase/tutorial/java/javaOO/objects.html)



## 3. The Pillars of Object-Oriented Programming

### Encapsulation

Below code is considered poor practice:

```java
/**** App.java ****/

Student student = new Student();
student.firstName = "Elrond";
System.out.println(student.firstName);
```

Instead, use access modifiers, getters and setters:

```java
/**** Student.java ****/

// Class fields
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private int gradeLevel;

// Private checkLength method
private boolean checkLength(String str, int length) {
		return str.length() > length;
	}

// Getters & Setters
public void setFirstName(String firstName) {
		if (checkLength(firstName, 1)) {
			this.firstName = firstName;
		}
	}

	public String getFirstName() {
		return firstName;
	}

// etc.
```

**Access Modifiers:**

- `public`: accessible everywhere
- `private`: only accessible from within the class itself
- `protected`: only accessible within the class, other classes in the same package, and all subclasses
- No Modifier: same as protected EXCEPT not accessible in subclasses in different packages

### Inheritance, Abstraction, and Polymorphism


**Object-Oriented Programming** is an **Imperative Programming Paradigm**.

Let's step back a little bit, and give you some background on programming paradigms.

**Definitions:**

- A **paradigm** is a way, or a method that can be used to solve a problem. 

- A **programming paradigm** is the way that one solves a given problem (or task), by programming.  Also described as a _framework_ that defines how problems can be solved.

- A **programming language** (e.g. Java, Pascal, C#, etc.) is separate from a programming paradigm. A programming language is a tool that is used to write code to solve problems.


There are a number of **programming paradigms**.  Each one has a set of rules and principles.  If a **programming language** is going to support a **programming paradigm**,  the **programming language** must support or adhere to those rules and principles    The **programming paradigm** is enforced by a **programming language compiler** during the program compilation stage.  Each **programming paradigm** is simply a different approach to solve a problem, and provides a style and organization to do so.  

Here is a brief overview of a few **Programming Paradigms**:

**Imperative:**  These types of paradigms are command driven. 

- Details:  Support of an **imperative programming paradigm** looks like this:

    - The program code directs the program execution as sequence of statements executed one by one.

    - The statements will direct the computer to perform tasks.

    - The programmer designs and programs each statement in detail, and each of those statements will direct **what** is to be accomplished by specifying **how** it is to be done.

    - A program in an **imperative programming paradigm** is simply a set of statements, run in order, that execute to completion.

- **Types:**  Two common imperative programming paradigms are as follow:

    - **Procedural** -- Based on a set of procedures (also referred to as functions, methods or subroutines).  Each procedure, function, method or subroutine performs a specific operation.  C, FORTRAN, and Pascal support this paradigm.

    - **Object-Oriented** --  All program components are objects.   The unique feature here is that an object contains properties and functions.  All data and associated methods are combined into a single object.  Some would say that this is an extension of procedural programming concepts.   **Java** supports this paradigm.
    


**Declarative:**  These types of paradigms are logic focused.

- **Details:** Support of a **declarative programming paradigm** looks like this:

    - The control flow is not the important part of this program: the logic of a computation is expressed without describing the control flow of the computation.

    - Focused on achieving the end result.

    - This approach describes **to what** is to be done, instead of _how_ it should be achieved.
    
- **Types:**

    - **Functional** -- based on mathematical functions.  Attempts to solve problems with composing functions as program components.  Functions can be passed as arguments, and can also be returned as a value.  _Pure functional languages, (e.g. Haskell) allow only pure functional programs._  However, some languages allow both functional and procedural programs, and **Java** is one of these programming languages, though to effectively use functional programming in Java, it is advisable to use Java 8 or later.

    - **Logic** -- based on **logic** and **control**, or, in other words, facts and rules.  Control is defined as an order of rules.  In this type, **logic** defines _what_ needs to be solved whereas the **control** defines _how_ it should be solved.  Prolog is an example of this paradigm.  

_**Note:**  many of the current programming languages are general purpose languages, and as such, they support more than one programming paradigm._

Our focus here is on **Object-Oriented Programming** (**OOP**).  There are a number of programming languages that support the **object oriented programming paradigm**, including **Java**, JavaScript, C3, Ruby, and others.   

**There are four pillars of OOP which are:**

1. **Encapsulation** -- Data Security -- binding related data and methods together into objects -- data hiding (hide the unnecessary).

2. **Inheritance** -- Code reusability -- acquiring the existing functionality of a parent class, with the ability to add additional functionality and features into the child class -- an object can inherit some properties and methods from another object.

3. **Polymorphism** --  Many Forms --  A single object can have multiple behaviors, or respond in different ways to the same function.  

4. **Abstraction** -- Present a simplified view -- Hide the complexity from the user (show only what is necessary).

Each pillar is essential, and important, but these pillars are also dependent upon each other.  Without encapsulation, abstraction and inheritance are not possible.  Additionally, polymorphism does not exist without inheritance.   

Each of these pillars is essential to the paradigm, and together define object-oriented programming.   OOP as a whole functions through objects that contain properties and methods, and the relationships of these objects with other objects.


### Resources:

- [The Java Tutorials -- Object-Oriented Programming Concepts](https://docs.oracle.com/javase/tutorial/java/concepts/index.html)



## 4. Exceptions

### What is an Exception?

**Exception:**  An exception is defined as an event that occurs that is contrary to the expected behavior of the application or program that has been written.  Instead of functioning as expected, something happens that causes an unexpected result.

**In Java, there are two types of Exceptions:**

- **_Checked Exceptions_** -- these are checked by the compiler at compiler time.

    - **Example:**   syntax errors -- a missing semi-colon or closing curly brace, incorrect datatype assignment, returning the wrong data type from a method, etc.

- **_Unchecked Exceptions_** -- these are not caught by the compiler; included here are runtime exceptions and errors.

    - **Runtime Exception Example:** Trying to access a Null Address, Out-of-Bounds Indices  
    **Class:**  _RuntimeException, NullPointerException, ArithmeticException, etc._

    - **Error Exception Example:**  Serious issues that cause an application to abort, or to stop running, including Memory or Stack Overflow Errors  
    **Class:**  _OutOfMemory, StackOverflow, VirtualMachineError, etc._


### What is Exception Handling?

**Exception Handling:**  In programming, how the code deals with or handles **Unchecked Exceptions** is called **Exception Handling**.  What does an application do with an unexpected occurrence?  An application needs to make sure it has a plan for when things go wrong.


#### Comparing Diagnosing Car Troubles to Exceptions:

To get a better idea of what an **Exception** is and why **Exception Handling** is important, let's take a look at something a bit more familiar: a car.     

Imagine as you are driving or riding along, the car engine stops working.  What is wrong?  Why did your car stop?  How do we get our car engine running again?  The solution totally depends on what the problem with the car is:

- Would filling the car with gas fix a dead battery? 

- Would changing a tire fix an overheated engine?

- Would adding oil fix being out of gas?

It's important to know what a problem is before we randomly start fixing things in the hope that we fix the right issue.  

- If there is no electricity in your car, filling your gas tank will not help

- If your check engine light is on,  changing a tire will not solve it

- If your gas gauge is on Empty, adding oil will not help that issue.

Cars are designed with features to help you diagnose issues.  There are gauges, warnings, and codes that indicate when something needs to be addressed in your car.


#### The Moral of the Story:

As a car owner, it is good practice to notice when something is not as you expect (e.g. a warning light comes on, the gas gauge is on Empty, the car is slow to start, etc.)

As a software developer,  it is good practice to use **Exception Handling** in your programming to gracefully handled unexpected events.  We cannot predict every failure in our programs, but we can definitely catch exceptions, and communicate back to the user clues as to what the issue is.

- **Invalid Input:**  What does the application do when a user puts in an invalid username and/or password?  Instead of crashing, or quitting, the program can validate the input, and reprompt a user for their username and/or password.

- **Network Failure:** When you are accessing a server over a network, and the internet is down, what does the application do?  Crash?  Or give an error that says `network unavailable, try again later.`?


The video in this chapter covers the way to handle exceptions in  Java, which include:

- Diagnose and fix checked exceptions before running your code.
- Use `try/catch` blocks & the `throws` keyword to handle unchecked exceptions


### Resources:

- [The Java Tutorials:  Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)
- [Java 17 Exception Class Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Exception.html)

## 5. Interfaces

- Interfaces solve the problem of multiple inheritance -- e.g. having a House class and a Car class but needing to create an RV

- Interfaces _only_ have abstract methods -- define method _signatures_ we want it to have; not the bodies

### Resources:

- [Example:  The Java Tutorials -- What is an Interface?](https://docs.oracle.com/javase/tutorial/java/concepts/interface.html)
- [The Java Tutorials -- Interfaces](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)

## 6. OOP Menu App


