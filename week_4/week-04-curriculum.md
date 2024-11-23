# Java 4: Weekly Curriculum & Videos

### Table of contents
1. [StringBuilder](#1-string-vs-stringbuilder)
2. [Lists](#2-lists)
3. [Collections](#3-collections)
4. [Menu App](#4-menu-app)


## 1. StringBuilder

### String vs. StringBuilder

#### String:

In **Java**, a **String** is _immutable_, which means that it can not be modified.  *Strings* are very useful in programming, but they should only be used if you are not modifying a **String** once you create it!  

> _The immutability of **String** is a feature, not a bug!_ 

James Gosling, the chief architect of Java,  is quoted as saying that he would use an immutable whenever he could.  The immutability of **Strings** provides features, such as security, caching, and reusability, without having to copy the **String**.  There are many resources that provide a lot of insight into Strings, such as the [Oracle Java Tutorials -- Strings](https://docs.oracle.com/javase/tutorial/java/data/strings.html).  


To further unpack the immutability of the **String** Object, check this out: 

You _can_ assign a new **value** to a **String** variable, but **both values** will remain in memory. In the following example, Java does not use the same space in memory, it leaves the value `Bob Brown` and creates a new space for `Sue Brown`. The syntax works, but it is not good coding practice to use the **String** datatype when you want to dynamically create or modify a **String** value within your code.

```java
String name = "Bob Brown";
System.out.println(name);
name = "Sue Brown";
System.out.println(name);
```

**Digging Deeper:** Explain what happens in the above example. What does **Java** do when you assign a new value to a **String**? 


#### StringBuilder:

**Java** provides another Object that allows a programmer to build a **String** dynamically called **StringBuilder**, and it is _mutable_, which means that a **StringBuilder** can be modified. There are also great resources which discuss this Object, including the [Oracle Java Tutorials -- The StringBuilder Class](https://docs.oracle.com/javase/tutorial/java/data/buffers.html).

Here is an example using a StringBuilder:

```java
package com.promineotech;
public class StringBuilderExample {
    public static void main(String[] args) {

        String firstName = "Bob";
        String lastName = "Brown";
        String middleInitial = "B";
        String space = " ";

        System.out.println(firstName);
        System.out.println(lastName);

        StringBuilder sb = new StringBuilder();

        // use append() to dynamically create a String using StringBuilder 
        sb.append(firstName);
        sb.append(space);
        sb.append(lastName);
        System.out.println(sb.toString());

        // Add a middle Initial
        sb.insert(firstName.length()+1, middleInitial + space);
        System.out.println(sb.toString());
    }
}
```

**Coding Challenge:** Write code that reverses a variable of type `StringBuilder()` without using the `reverse()` method, and then print the result to the Console.


#### Resources:

- [Java 17 String Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html)
- [Java 17 StringBuilder Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/StringBuilder.html)
- [The Java Tutorials Strings](https://docs.oracle.com/javase/tutorial/java/data/strings.html)
- [The Java Tutorials StringBuilder](https://docs.oracle.com/javase/tutorial/java/data/buffers.html)


## 2. Lists

Programming is all about data, and being able to organize data is essential when writing applications. We need organized, quick access to our data. Java provides a many ways to organize data, two of which are **Arrays** and **Lists**. Both allow a elements to be directly accessed. 


### Array:

**Arrays** allow storage of elements together. Arrays are **Objects** in Java. You must choose the size of an Array when it is declared, and, once declared, the size of an array is _immutable_ or unchangeable. If you know the number of items that you are storing, Arrays are very effective and useful data structures. Items in an array are stored in a continuous manner in memory, and arrays provide for very quick access to the elements.

#### Example declaring an Array of Strings:

```java
String[] myInstruments = new String[4];
myInstruments[0] = "Tuba";
myInstruments[1] = "Trombone";
myInstruments[2] = "Trumpet";
myInstruments[3] = "Triangle";
```

Another way to create this same array would be as follows:

```java
String[] myInstruments = {"Tuba", "Trombone", "Trumpet", "Triangle"};
```

**Note:** If we try to add an element to index `4` in `myInstruments`, an  `ArrayIndexOutOfBoundsException` will be thrown.

**An Array:**

- is required to be constructed.

- has a fixed size.

- holds variables of the same type

- has elements that are accessed via an index.


### Lists:

**Lists** are used to "collect"  elements. By creating a List, you can store any number of elements, dynamically modifying the List, and the location of each item is managed by the List. Each element is accessible through a variable that you declare as a List.

A List in Java is an **Interface**. To use a List in Java, you will import the `java.util` library, and a List will need to be declared and initialized. A List is often implemented by the `ArrayList` class, but can also be implemented by one of these classes: `LinkedList`, `Vector` and `Stack`. If you choose `ArrayList`, you will also have to import `ArrayList` from `java.util`.

#### Example declaring a List of String:

```java
List<String> myInstruments = new ArrayList<String>();
myInstruments.add("Tuba");
myInstruments.add("Trombone");
myInstruments.add("Trumpet");
myInstruments.add("Triangle");
```

Notice that _unlike_ an Array, you can dynamically add additional elements to your List, inserting as many elements as you wish to this same List, without throwing an exception:

```java
myInstruments.add("Flute");
myInstruments.add("Clarinet");
myInstruments.add("Oboe");
```

**A List:**

- Is Ordered

- Preserves Insertion Order

- Allows Positional Access and Insertion of Items

- Allows Duplicates

- Is a Collection of Objects 


#### Arrays vs. ArrayLists:

To review, the array is a specified-length data structure, and in contrast, the ArrayList is a variable-length Collection class.

> **Research challenge:** List can only be created on a Class; How do we create a List of integers? Can you create a `List<int>`? How does Java handle this?

#### Resources:

- [Java 17 List Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/List.html)
- [Java 11 List Documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/List.html)
- [The Java Tutorials List Interface](https://docs.oracle.com/javase/tutorial/collections/interfaces/list.html)
- [The Java Tutorials Array](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)


## 3. Collections

What is a **Collection**? Think of a **Collection** as an Object, but that Object can contain (or represent) a group of Objects. Java provides a **Collection Framework**, which is an architecture that allows a unified access to a variety of different collections. You have already been introduced to **Lists**, and it was mentioned that a **List** an Interface that falls within the **Collections Framework**. Two additional types of Collection Interfaces are **Sets** and **Maps**.  

**Collection Interfaces:** **Set**, **List**, **Map**, and others

**Collection Implementations:** There are a number of classes provided in Java that are used to implement the **Collection Interfaces**. _See the Java Collections Framework Overview_ link below for additional information on **Collection Implementations**.

**Interface --> Implementation**

* Set --> HashSet, TreeSet, LinkedHashSet

* List --> ArrayList, LinkedList

* Map --> HashMap, TreeMap, LinkedHashMap

#### The Collections Class:  

The **Collections Class** contains static methods that either return collections, or perform some operation on collections. A `NullPointerException` is thrown by all methods of this class if the collections or Class Objects provided are `null`. Check out the links below for information on the Java Class Collections.

#### Set:

* No Duplicates

* At most one `null` element

* Not guaranteed to be in any particular order

#### Set Example:

Notice the order of the Strings that are inserted into this Set. 

```java
Set<String> vegetables = new HashSet<String>();

vegetables.add("Carrot");
System.out.println(vegetables);

vegetables.add("Onion");
System.out.println(vegetables);

vegetables.add("Broccoli");
System.out.println(vegetables);

vegetables.add("Asparagus");
System.out.println(vegetables);
```

What happens if you add a duplicate to a Set?

Questions to ask: 

1. Is an error thrown?  **_No_**  

2. Does the duplicate get stored? **_No_**  

```java   
vegetables.add("Carrot");
System.out.println(vegetables);

vegetables.add(null);
System.out.println(vegetables);

vegetables.add(null);
System.out.println(vegetables);

System.out.println("The size of our set is: " + vegetables.size());
```

**Research question:** Think about usefulness of Sets. What applications make sense for this Collection?

#### Resources:

- [Java Collections Framework Overview](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/doc-files/coll-overview.html)
- [Java 11 Collections](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Collections.html)
- [Java 17 Collections](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Collections.html)
- [The Java Tutorials Collection Interfaces](https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html)



## 4. Menu App

### Menu App with List

**Menu-Driven Applications** are really useful, and here is our  example from Week 3, rewritten to use **Lists**.


<details><summary><strong><code>IceCreamOrder.java</code> Class<strong></summary>

This is the class that is used to instantiate an `IceCreamOrder` Object. Notice that this class has fields, a default constructor, additional constructors, and a `describe` method.

```java
package com.promineo.application;
import java.util.ArrayList;
import java.util.List;
public class IceCreamOrder {
    String user;
    String size;
    String cupOrCone;
    List<String> flavors = new ArrayList<String>();

    // Default Constructor
    public IceCreamOrder() { 
        this.user = "";
        this.flavors.add(null);
        this.size = "";
        this.cupOrCone = "";
    }
    // Additional Constructors
    public IceCreamOrder(String user, List<String> flavors) {
        this.user = user;
        this.flavors = flavors;
    }
    public IceCreamOrder(String user, List<String> flavors, String size, String cupOrCone) {
        this.user = user;
        this.flavors = flavors;
        this.size = size;
        this.cupOrCone = cupOrCone;
    }
    //Getters & Setters
    public String getUser() { return this.user; }
    public void setUser(String user) { this.user = user; }
    public List<String> getFlavors() { return this.flavors; }
    public void setFlavors(List<String> flavors) { this.flavors = flavors; }
    public String getSize() { return this.size; } 
    public void setSize(String size) { this.size = size; } 
    public String getCupOrCone() { return this.cupOrCone; } 
    public void setCupOrCone(String cupOrCone) { this.cupOrCone = cupOrCone; }

    // Describe Method
    public void describe() {
        int num = 0;
        int boxSize = 40;
        char star = '*';

        for (int i = 0; i < boxSize; i++) {
            System.out.print(star);
        }
        System.out.println("\nIce Cream Order:\n----------------");
        System.out.print("Name:\n\t" + this.user + "\nOrder: \n\t");
        System.out.println(this.size + " " + this.cupOrCone);

        if (this.flavors.size() > 1) {
            System.out.print("Flavors:\n\t");
        } else {
            System.out.print("Flavor:\n\t");
        }
        if (this.flavors.isEmpty()) {
            System.out.println("No ice cream flavors were chosen!");
        } else {
            for (String flavor : this.flavors) {
                System.out.print(flavor);
                num++;
                if (num == flavors.size()-1) {
                    System.out.print (" & \n\t");
                } else if (num < flavors.size()-1) {
                    System.out.print (", \n\t");
                }
            }
        }
        System.out.println();
        for (int i = 0; i < boxSize; i++) {
            System.out.print(star);
        }
    } // end of describe
} // end of IceCreamOrder
```

</details>

<details><summary><strong><code>MenuInput.java</code> Class which contains the <code>main</code> Method</strong></summary>

Notice that this class has a `main` method, and a number of techniques for printing menus to the screen, as well as handling and manipulating data. We include a number of different types of loops, as well. Of note is the use of a `do...while` loop, since it always runs at least once, it's a great choice for a **Menu-driven Application**.

```java
package com.promineo.application;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MenuInput {
    static List<String> iceCreamList = new ArrayList<String>();
    static Scanner input = new Scanner(System.in);
    private static final int maxScoops = 3;
    private static List<String> options = Arrays.asList("Vanilla", "Chocolate", "Mint Chocolate Chip", "Strawberry", "Black Raspberry", "Chocolate Peanut Butter Cup", "Bubble Gum", "Banana Fudge", "End of Ice Cream Selection");

    public static void main(String[] args) {

        // **********************************************************
        //  Future enhancement -- Create a List of IceCreamOrders, 
        //        and then add the order to the list, and
        //        prompt the User and 
        //.       ask whether their order is complete or not.
        // **********************************************************

        IceCreamOrder userOrder = new IceCreamOrder();
        boolean finished = false;
        System.out.println("------------------------------\nWelcome to The Ice Cream Stand\n------------------------------\n");
        while (!finished) {
            System.out.print("Enter a name for your order: ");
            userOrder.setUser(input.nextLine());
            int counter = 0;
            boolean willOrderIceCream = true;
            int userInput = 0;
            System.out.println("\n\n" + userOrder.getUser() + ", you may choose up to 3 flavors of ice cream!\n\n");
            do {
                if (counter == 0) {
                    printFlavorOptions();
                }
                    if (counter <= 2) {
                    System.out.print("Enter your selection: ");
                    userInput = input.nextInt();
                    switch (userInput) {
                        case (1):
                        case (2):
                        case (3):
                        case (4):
                        case (5):
                        case (6):
                        case (7):
                        case (8):
                            printChoice(options.get(userInput - 1), counter);
                            break;
                        case (9):
                            if (counter == 0) {
                                System.out.println("No selection has been made! Do you want to order ice cream?");
                                if (willOrderIceCream = checkOrderCancellation()) {
                                    userInput = 0;
                                    counter--;
                                    break;
                                }
                            }
                            System.out.println("End of Ice Cream Selection!\n");
                            break;
                        default:
                            System.out.println("Invalid Selection Choice");
                            counter--;
                    }
                }
                counter++;
            } while (userInput != 9 && counter <= 4); // ExitCriteria == 9

            /* Set field in userOrder */
            userOrder.setFlavors(iceCreamList);
            if (willOrderIceCream) {
                // Choose the Size of the Ice Cream: Small, Medium or Large
                int userInputSize = 0;
                int size = iceCreamList.size();
                if (size == maxScoops) {
                    System.out.println("With 3 Ice Cream flavors, the size you get is: LARGE");
                    userOrder.setSize("Large");
                    userInputSize = size;
                } else {
                    printSizeOptions();
                    userInputSize = input.nextInt();
                    while ((userInputSize != 1) && (userInputSize != 2) && (userInputSize != 3)) {
                        System.out.print("Please enter a valid ice cream size selection: ");
                        userInputSize = input.nextInt();
                    }
                    System.out.print("The size you have chosen is: ");
                    switch (userInputSize) {
                        case (1):
                            System.out.println("SMALL");
                            userOrder.setSize("Small");
                            break;
                        case (2):
                            System.out.println("MEDIUM");
                            userOrder.setSize("Medium");
                            break;
                        case (3):
                            System.out.println("LARGE");
                            userOrder.setSize("Large");
                            break;
                    }
                }
                System.out.println("\n");

                // Choose cup or cone
                int order = 0;
                printCupOrConeOptions();
                order = input.nextInt();
                while ((order != 1) && (order != 2)) {
                    System.out.print("Please enter a valid entry: ");
                    order = input.nextInt();
                }
                System.out.print("You have chosen a: ");
                switch (order) {
                    case (1):
                        System.out.println("CUP");
                        userOrder.setCupOrCone("Cup");
                        break;
                    case (2):
                        System.out.println("CONE");
                        userOrder.setCupOrCone("Cone");
                        break;
                }
                System.out.println("\n");
                userOrder.describe();
                System.out.println("\n");
            } else {
                System.out.println("Order Cancelled!");
            }
            //  **********************************************************
            //  Future enhancement --  Add a menu here to ask the
            //  user if they have another request to add to this order.
            // **********************************************************
            finished = true; 

        }  // end of while
        System.out.println("Goodbye -- End of Order!");
    } // end of main

    public static void printCupOrConeOptions() {
        System.out.println("Choose either a CUP or a CONE for your order: ");
        System.out.println("---------------------------------------------");
        System.out.println("\t1) CUP");
        System.out.println("\t2) CONE");
        System.out.println("---------------------------------------------");
        System.out.print("Enter your selection: ");
    }

    public static void printChoice(String flavor, int counter) {
        System.out.println("Ice Cream Choice #" + (counter + 1) + ": " + flavor);
        System.out.println("------------------------------------------------");
        iceCreamList.add(flavor);
    }
    public static void printFlavorOptions() {
        System.out.println();
        System.out.println("Choose ice cream flavors:");
        System.out.println("-------------------------");
        for (int i = 0; i < options.size(); i++) {
            System.out.println(" " + (i + 1) + ") " + options.get(i));
        }
        System.out.println("------------------------------------------------");
    }
    public static boolean checkOrderCancellation() {
        int check = 0;
        System.out.println();
        System.out.println("Would you like Ice cream?");
        System.out.println("-------------------------");
        System.out.println("\t1) Yes, continue the order!");
        System.out.println("\t2) No, CANCEL my order");
        System.out.print("Enter your selection: ");
        check = input.nextInt();
        while ((check != 1) && (check != 2)) {
            System.out.print("Please enter a valid entry: ");
            check = input.nextInt();
        }
        System.out.print("You have chosen: ");
        if (check == 1) {
            System.out.println("CONTINUE Your Order");
            System.out.println();
            return true;
        } else {
            System.out.println("CANCEL Your Order");
            System.out.println();
            return false;
        }
    }

    public static void printSizeOptions() {
        System.out.println("Choose size for your ice cream: ");
        System.out.println("-------------------------------");
        System.out.println("\t1) SMALL -- 1 scoop");
        System.out.println("\t2) MEDIUM -- 2 scoops");
        System.out.println("\t3) LARGE -- 3 scoops");
        System.out.print("Enter your selection: ");
    }

} // End of MenuInput
```

</details>

_**Advanced Coding Challenge:** Modify the above example. This example creates an Ice Cream Order for one person, and exits the program. The modification would be to multiple people's orders before exiting, and use a List of Objects to create an IceCream Order which contains one or more people's orders._


### Menu App with Map

[VIDEO]

#### Resources:

- [The Java Tutorials -- The Map Interface](https://docs.oracle.com/javase/tutorial/collections/interfaces/map.html)
- [The Java Tutorials -- The List Interface](https://docs.oracle.com/javase/tutorial/collections/interfaces/list.html)
- [The Java Tutorials -- The Set Interface](https://docs.oracle.com/javase/tutorial/collections/interfaces/set.html)

