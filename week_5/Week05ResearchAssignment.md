# Week 5 Research Assignment

## Purpose

- _This Research Assignment is meant to go beyond the course curriculum and increase your understanding of relevant topics while exposing you to online resources you'll frequently use on the job._ 

- As developers, **research** is a constant part of our job. 

- A common saying is that 90% of software development is "Googling".  While that is an exaggeration, search engines are highly utilized tools in the software development role.   

- The **Java Documentation** is a great place to start, and there are so many other great resources!


## Instructions

- Choose at least **two (2)** of the above prompts.

- Research those prompts.

- Write at least one paragraph for **two (2)** of the below prompts

- Include URLs from where you found the information to cite your sources. 

- Submit your **Research Results** to the LMS.


## Prompts

### OOP:

1. What are the four pillars of Object-Oriented Programming? Explain each pillar.

    > The four pillars of OOP are Abstraction, Encapsulation, Inheritance, and Polymorphism. [[1](https://www.w3schools.com/java/java_oop.asp)]
    > 
    > **Abstraction** is the idea of hiding details from users. For example, a user only needs to "see" a `Car` object's `startEngine` function -- they _don't_ need to access the `fireCylinders` or `burnFuel` functions, etc.
    > 
    > **Encapsulation** describes the idea of keeping sensitive data hidden from the user. This helps keep data more secure (e.g. making a field read-only by _only_ defining a `get` method).
    > 
    > **Inheritance** describes the ability of a class (subclass) to _inherit_ properties and methods from another class (superclass). This makes code much more reusable and efficient -- common properties and behavior can be defined in _one_ place and then be inherited by more specific subclasses.
    > 
    > **Polymorphism** is a result of inheritance -- because multiple subclasses can inherit common functionality from a superclass, they can then each implement the functionality in their own unique way.


2. What is the relationship between a Class and an Object?

    > A Class is a blueprint -- a description of an object's properties (fields) and behavior (methods). An Object is a specific instance of a Class. [[1](https://www.w3schools.com/java/java_classes.asp)]
    > 
    > For example, the Class `Car` might specify that any car must have at least four wheels, every car has some basic functions (drive, break, reverse), a type, etc. 
    > 
    > An Object of Class `Car` might be a specific make or model (e.g. a `Mustang`) that has the characteristics described in the Class, but those characteristics may differ from other instances of the `Car` Class (e.g. a `Buick`).


### Advanced OOP:

3. What are the differences between abstract classes and interfaces? When should you use one over the other?

    > **Abstract classes** cannot be instantiated -- they can't be used to create Objects. For example, the Class `Employee` used in this week's lessons.
    > 
    > Abstract classes are useful when you know you need several similar (sub)classes that share a set of common fields or methods. 
    > 
    > You might create an abstract class `Animal`, and then create the subclasses `Dog` and `Cat`. `Dog` and `Cat` would both be `Animal`s -- have four legs, have fur, make a sound, etc. -- and so the `Animal` class can define these common properties instead of having to repeat code for each type of animal. However, you would never instantiate an `Animal` just on its own.
    > 
    > **Interfaces** are abstract classes that are only used to group related methods -- with empty bodies. To continue with the animal example, you might instead create an Interface called `Animal` that contains the empty methods `move()`, `makeSound()`, etc. The way in which each animal implements these methods will vary -- e.g. a `Fish`'s `move()` method will provide functionality for swimming, whereas a `Cheetah`'s will define running.
    > 
    > Interfaces solve the problem of _multiple inheritance_ -- a class can only inherit from _one_ superclass. However, a class can implement multiple interfaces.
    > 
    > For example, if you had the classes `House` and `Car`, but you needed to also create an `RV` class. The `RV` class would need properties from both the `House` and `Car` classes -- which is only possible by implementing an Interface rather than a class. [[1](https://dev.java/learn/oop/)] [[2](https://www.w3schools.com/java/java_interface.asp)]

4. Research the SOLID principles of Object-Oriented Programming (OOP) as introduced by Robert Martin. List the principles, and give a description of each one.

    > SOLID is an acronym [[1](https://anmolsehgal.medium.com/solid-principles-de1029ef8a8f)] that stands for the principles of: 
    > 
    > - **S**ingle-Responsibility
    > - **O**pen-Closed
    > - **L**iskov Substitution
    > - **I**nterface Segregation
    > - **D**ependency Inversion
    > 
    > **Single-Responsibility** is the idea that classes should have only one "job". Rather than group many kinds of functionality (methods) under a single class, the Single-Responsibility principle states it is better practice to separate the different methods into their own classes.
    > 
    > The **Open-Closed** principle is the idea that a class should be "open" for _extension_ but "closed" for _modification_. If a class is open for extension, it is flexible; if it is closed for modification, it cannot be changed at a later point and risk breaking code down the line.
    > 
    > **Liskov Substitution** refers to the idea that subclasses should be able to be substituted for their superclass. The Liskov Substitution principle is broken if inherited functionality doesn't make sense for a subclass -- e.g. having `setWidth` and `setHeight` methods inherited to a `Square` subclass from a `Rectangle` superclass.
    > 
    > **Inheritance Segregation** is the idea that interfaces that include many methods that implementing classes do _not_ use should instead be broken into multiple smaller and more specific interfaces. That way, classes can implement only the interfaces they need.
    > 
    > **Dependency Inversion** states that classes should not rely on hidden, specific dependencies; that the relevant calling class should instead create the dependency.


### Exceptions:

5. What is an exception?

    > An **exception** is essentially a bug or error -- an unexpected result from running code.

6. What are the differences between checked and unchecked exceptions?

    > **Checked** exceptions are found by the compiler at compile time -- e.g. syntax errors. These exceptions are ones that can be anticipated and controlled by developers.
    > 
    > **Unchecked** exceptions are errors found at runtime -- for example, a bug that causes unintended behavior or that can entirely crash an application. Another example of an unchecked exception would be if an app is unable to connect to an external database or API due to an issue with the third party itself.


### Testing:

7. What is unit testing and why is it important?

    > **Unit testing** is the practice of writing tests into code that test _small_ functional pieces of code at a time. Testing code in small chunks like this narrows focus and helps catch bugs and errors faster, and tests can be automated. [[1](https://aws.amazon.com/what-is/unit-testing/)]


## Resources Consulted

- [Objects, Classes, Interfaces, Packages, and Inheritance | The Java Tutorials](https://dev.java/learn/oop/)

- [Classes and Objects in Java | Geeks for Geeks](https://www.geeksforgeeks.org/classes-objects-java/)

- [Java OOP | w3schools](https://www.w3schools.com/java/java_oop.asp)

- [Java Classes/Objects | w3schools](https://www.w3schools.com/java/java_classes.asp)

- [Java Encapsulation | w3schools](https://www.w3schools.com/java/java_encapsulation.asp)

- [Java Abstraction | w3schools](https://www.w3schools.com/java/java_abstract.asp)

- [Java Interface | w3schools](https://www.w3schools.com/java/java_interface.asp)

- [Java Inheritance (Subclass and Superclass) | w3schools](https://www.w3schools.com/java/java_inheritance.asp)

- [SOLID: The First 5 Principles of Object Oriented Design | DigitalOcean](https://www.digitalocean.com/community/conceptual-articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design)

- [SOLID Principles | Anmol Sehgal on Medium](https://anmolsehgal.medium.com/solid-principles-de1029ef8a8f)

- [What is Unit Testing? | AWS](https://aws.amazon.com/what-is/unit-testing/)

