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


## 4. Exceptions


## 5. Interfaces


## 6. OOP Menu App

