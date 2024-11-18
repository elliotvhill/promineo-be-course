# Java 3: Weekly Curriculum & Videos

### Table of contents
1. [Source Control with git](#1-source-control-with-git)
2. [Arrays](#2-arrays)
3. [Methods](#3-methods)
4. [Objects, JavaDocs, and Equality](#4-objects-javadocs-and-equality)
5. [Menu App Example](#5-menu-app-example)

## 1. Source Control with git

**Note:** that a Mac computer may already have **git** preinstalled. Before you attempt installing **git** on a Mac, check to see if it's already there by typing `git version` in your **Terminal** window. 

### Source Control With git Overview

**git** is a "distributed version control system designed to handle everything from small to very large projects with speed and efficiency". _(git, Retrieved on 4/12/23 from https://git-scm.com)_

**git** is used in many software development environments, and provides a number of benefits for any software developer.  It provides a backup of code that you are writing on your local system.  In addition, when working on a project with a team, it provides a way to ensure everyone has the same, up-to-date code. 

**git** is a Source Control tool used to enable teams to collaborate on projects at the same time. If users make changes to the same file that would overwrite one another, **git** provides merge conflict messages that enable users to manually adjust the multiple changes so that no one's code is overwritten. **git** also keeps track of all the changes made to a project by using save-points called commits. 

**GitHub** is a web-based git **GUI** that enables us to visually manage our repositories and push our code to a remote location (**GitHub** servers). 

To start a new project (which we will do each week in this program), we need to create a new directory on our local computer that will contain our project/assignment code and then create a new repository on **GitHub**. Once we create the **repository** or **repo** on **GitHub**, it will give us a list of commands to run on **Command Prompt** (Windows) or **Terminal** (Mac) from within the directory that we created for our project. The list of commands will allow us to connect the directory on our local computer with the **GitHub** repo on the GitHub server, and subsequently back-up our programs to the ((GitHub)) Server repo.

**For example:**

1. We create a new local directory for our weekly project using our **CLI** (**Terminal** or **Command Prompt**): `mkdir week3Assignment`

2. We log into our **GitHub** account in a browser of our choice and create a new repository  
**NOTE:** The **GitHub** repo name could be something like **week3Assignment**, as well.

3. We run the commands that **GitHub** gives us in our **CLI** **<u>in</u>** the directory we made  
**NOTE:** we have to `cd` into the new local directory first: `cd week3Assignment`

The commands used in **Terminal** (Mac) or **Command Prompt** (Windows) typically look like this:

```bash
echo "# week3assignment" >> README.md

git init

git add README.md

git commit -m "first commit"

git branch -M main

git remote add origin https://github.com/<GitUser>/week3assignment.git

git push -u origin main
```

**Note:** `<GitUser>` will be your **GitHub** account username  
**Note:** instead of running `git add README.md` we can run `git add .` to add all files.

**Your CLI may prompt you with the following message:**

```bash
---------------------------------------------------------------------------------------------

Please tell me who you are.

Run

     git config --global user.email You@example.com

     git config --global user.name UserName

---------------------------------------------------------------------------------------------
```

**Note:** If it does, we need to run the suggested commands and **replace** `You@example.com` and `UserName` with _the email you used on_ **GitHub** and _your own username_.

#### Personal Access Tokens:

You may also need to create a token. You can do so by following the official guide here: [PersonalAccessTokenLink](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token)

After running these commands, our local computer's repository should be connected to the remote repository on **GitHub** and we can follow a **git** workflow to keep our code in sync and uploaded to **GitHub**.

Additionally useful **git** commands run from **Command Prompt** (Windows) or **Terminal** (Mac) are as follows:

* `git status`  
this command gives information on the current status of a directory 

* `git remote -v`  
which shows the GitHub repository to which a directory is connected

As an additional example, here is an overview of a **basic git workflow**:

1. Pull down any changes so our workspace is up to date using the command `git pull` in our existing **git** repository.

2. Make any changes to our code or files.

3. Stage the changes by using `git add [files we want to add]` or `git add .` to add all changed/new files.

4. Take a snapshot of those changes (a commit) with `git commit -am "commit message"` where the commit message is a short note summarizing what changes/additions we made. 

5. Push changes to a remote repo using `git push -u origin main`.

### Uploading Your Assignments to GitHub

**Note:** This video talks about uploading a _week 1 coding assignment_, but we are currently in week 3.  You can practice what the presenter is demonstrating with any assignment.

This video takes the approach of creating a local directory for your homework. Once your homework is completed, the presenter goes into the CLI to the homework directory, and does the following:

```bash
git init

git add .

git commit -m "first commit"
```

Then, the presenter goes to their **GitHub** account, creates a new repo name **PT-W1**, and then returns to the local CLI and does the following to complete the connection from the local to the remote repo:

```bash
git branch -M main

git remote add origin https://github.com/GitUser/PT-W1.git

git push -u origin main
```

#### Resources:

* git:
    - [git Documentation](https://git-scm.com/docs)

    - [Complete List of git commands](https://git-scm.com/docs/git#_git_commands)

    - [Quick reference GitHub git Cheat Sheet](https://training.github.com/downloads/github-git-cheat-sheet.pdf)

* GitHub:
    - [GitHub glossary](https://docs.github.com/en/get-started/quickstart/github-glossary)

    - [GitHub Quickstart](https://docs.github.com/en/get-started/quickstart) -- Get started using GitHub to manage Git repos and collaborate with others.


## 2. Arrays

An **array** in Java is a container which holds a set number of values of a single type.  The length of an array is set at the time that it is declared or instantiated, and remains fixed for the life of an array.   Additionally the type contained in an array can be a primitive datatype, or an Object type.

Some useful **array** information and vocabulary is contained here:

* Square Brackets or `[]` tell Java that we are declaring an array
* _element:_ each item stored in an array is called an _element_
* elements within the same Java array must all be the same data type.
* _index:_ each element in an array is found or accessed by its numerical index.
* arrays are zero-based, so the _index_ values start at `0`.
* the first element in any array is located at index: `0`
* the last element of any array is located at index: `arrayName.length - 1`

Just like any variable in Java, an array must be declared.  We declare the array to give it a name, and to allocate space for the size of the array that we declare.  Note that we also must determine the data type of the elements that will be stored in this array, so that Java knows how to store and manage the elements in the array.

Let's look at a Grade Book Example. Imagine that I have a College Programming Course that has 5 coding assignments. For our example, I will set the values of the grades.

> **Coding Challenge:** As a stretch, you could convert these examples to use the Java `Scanner()` as was described in the User Input Section of **_Week 2: Weekly Curriculum & Videos_**.

One way to represent a program a simple **Grade Book** for our five assignment Programming Course could be as follows:

```java
String firstName = "Mary";
String lastName = "Brown";
int assignmentOne = 100;
int assignmentTwo = 79;
int assignmentThree = 80;
int assignmentFour = 90;
int assignmentFive = 100;

System.out.println("Student: " + firstName + " " + lastName);
System.out.println("Grades:");
System.out.println("1: " + assignmentOne);
System.out.println("2: " + assignmentTwo);
System.out.println("3: " + assignmentThree);
System.out.println("4: " + assignmentFour);
System.out.println("5: " + assignmentFive);
```

As you can see, this works for small projects, but what if our Programming Course had 20 students each with 5 assignments, or 20 students each with 100 assignments. A simple Grade Book could get out of hand very quickly. This project can become more manageable by using arrays.  

**How do we declare an array?** Arrays can be declared a number of ways, but each declaration has the same components:  

1. a datatype,
2. Square brackets or `[]`,
3. a name.

Notice that the following three examples are very similar, with the third example actually setting the values within the array in the declaration. All three declare an array named _gradesArray_, all three tell Java that we are creating an **array of type int** (e.g. `int []`), and all three tell Java to create enough space for 5 elements.

```java
// Example 1:
int[] gradesArray = new int[5]; 

// Example 2:
int[] gradesArray;
gradesArray = new int[5];

// Example 3:
int[] gradesArray = {100, 79, 80, 90, 100};
```

Let's simplify the **Grade Book** Example now by using an array, and a for loop to print the grades:

```java
String fullName = "Mary" + " " + "Brown"; 
int[] gradesArray = {100, 79, 80, 90, 100};

System.out.println("Student: " + fullName);
System.out.println("Grades: ");
for (int i = 0; i < 5; i++) {
System.out.println((i+1) + ": " + gradesArray[i]);
}
```

Check out this rewrite of our **Grade Book** code, using an enhanced for loop to print the grades:

```java
String fullName = "Mary" + " " + "Brown"; 
int[] gradesArray = {100, 79, 80, 90, 100};
int counter = 1;

System.out.println("Student: " + fullName);
System.out.println("Grades: ");
for (int grade : gradesArray) {
System.out.println((counter++) + ": " + grade);
}
```


### More Arrays

#### Advanced Topic:

What if you wanted to actually create a more robust Grade Book? One that would take more Student(s), and store their grades inside the Student Object.

Here we are going to explore an example that creates an Array of Objects. In this case, we would like to create an Array to hold our Student data. To accomplish this, we must first define what a Student will look like to be able to declare a Student Class that will be used to create our Objects.

Each Student will have a name, and an `Array` of grades. It will also need a way to create an `Object` of type `Student` (a Constructor), and a `method` to describe a Student (or print out the data corresponding to the student). 

The next step will be to create an Array of type Student.  We will also use the Scanner to take data from the console to use to create our arrays, we will create each Student Objects, and we will update that instance of an Object with the data that is input. 

To reproduce this example, you will need to create a Java Project in Eclipse, and then create two Java classes within that Java Project.

1. `Student.java` -- a class in Java, but does _not_ have a main method.  
2. `GradeBook.java` -- a class in Java with a main method.

<details><summary><strong>Student Class containing an array of grades (<code>Student.java</code>):</strong></summary>

```java
public class Student { 

    String fullName = ""; 
    int[] grades; 

    public Student(String fName,int[] grades) { 
        this.fullName = fName; 
        this.grades = grades; 
    }

    public void describe() { 
        System.out.println("Student: " + this.fullName); 
        System.out.println("Grades:"); 

        for (int grade : this.grades) { 
            System.out.println("\t" + grade + " "); 
        }
        System.out.println(); 
    }
}
```

</details>

<details><summary><strong>Grade Book Example instantiating a Student Object (<code>GradeBook.java</code>):</strong></summary>

```java
import java.util.Scanner;

public class GradeBook {

    public static void main(String[] args) {
        
        String fullName = "";
        String lineVariable = "---------------------------";
        Scanner sc = new Scanner(System.in);

        System.out.println("Grade Book Example");
        System.out.println("Name of Course:");
        
        String courseName = sc.nextLine();
        System.out.println("How many students are in this class:");
        
        int numOfStudents = sc.nextInt();
        Student[] programmingStudents = new Student[numOfStudents];
        System.out.println("How many grades do you have per student?");

        int numOfGrades = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < programmingStudents.length; i++) {
            int[] grades = new int[numOfGrades];
            System.out.print("Enter Student's Full Name: ");
            fullName = sc.nextLine();

            for (int j = 0; j < grades.length; j++) {
                System.out.print("Enter a grade: ");
                grades[j] = sc.nextInt();
            }

            programmingStudents[i] = new Student(fullName, grades);
            sc.nextLine();
        }

        System.out.println("\n\n"+lineVariable+"\n " 
            + courseName + " Grade Book \n"+lineVariable); 

        for (Student student : programmingStudents) { 
            student.describe(); 
        } 
        System.out.println(lineVariable+"\n");

        sc.close();
    }

}
```

</details>

#### Resource:

- [The Java Tutorials -- Arrays](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)


## 3. Methods

Java uses **methods** to accomplish predefined tasks. A method is code that runs when it is called.  When you write a program, and realize that you are writing the same code over and over, it's time to put that code into a method.  Another definition of a Java Method is that it is a collection of statements that are written together, and executed together to perform a task. 

What is a method declaration?

```java
modifier returnDatatype methodName (datatype1 par1, datatype2 par2) {
    BodyOfMethod
}
```

Here, these parts of the method declaration are explained below:

* **_modifier_** − modifier -- _public_, _protected_, _default_ and _private_
* **_returnDatatype_** − the return datatype (Can be a Java primitive datatype,  an Object, or a Collection of a datatype or an Object, or can be **void**).
* **_methodName_** − name of the method
* **_datatype1, datatype2_** - datatypes of the parameters 
* **_par1, par2_** − formal parameters
* **_datatype1 par1, datatype2 par2_** − list of parameters (Can be as many as you need, separated by commas)
* **_BodyofMethod_** —> this is where you put your code... anything that you want to accomplish in that particular method: all Java code, and will include variable declarations, method calls, etc.

Let's define a method here:
```java
public static void sumTwoNumsPrintResult (int number1, int number2) {
    int sum = 0;

    sum = number1 + number2;

    System.out.println(“The sum is: “ + sum);

    // No return statement, because the returnType is void!
}
```

What if we want to return the result?

```java
public static int sumTwoNumsReturnResult (int number1, int number2) {
    int sum = 0;

    sum = number1 + number2;

    return sum;
}
```

Let's call these two functions:

```java
public class ExampleJavaMethodClass {

    public static void main(String[] arg) {

        // Variable Declarations — visible in Main ONLY!
        int firstNumber = 3;

        int secondNumber = 7;

        // Call to first Method — passing variables into this Method as Parameters!
        sumTwoNumsPrintResult(firstNumber,secondNumber)

        // Additional Variable Declarations — visible in Main ONLY!
        int result = 0;

        // Call to second Method
        result = sumTwoNumsReturnResult(firstNumber,secondNumber);

        System.out.println(“The sum is: “ + result);

    }  // End of main()

}
```


## 4. Objects, JavaDocs, and Equality

### Objects and JavaDocs

#### Primitive Datatypes vs. Objects:

A primitive datatype  is just a piece of data and nothing more.  

```java
int age = 19;
System.out.println("Age is: " + age);
```

An Object (e.g. String, Array, etc.) has a value, but there is much more. An Object has properties and methods which are defined on that object, and are accessed via dot-notation. For example, we can declare a String `name`, which is an object, and use the method `name.length()` to print out the length of the String stored in the variable `name`:

```java
String name = "Chip Brown";
System.out.println("The length of name is: " + name.length());
```

The main difference between a primitive datatype and an Object is that a primitive datatype does not have properties and methods defined on it.  

When creating your own Objects, you can define them as you need. For example in our GradeBook example from the Array Section, we needed a Student Object, so we declared a Class named `Student`. `Student` has two fields: `fullName` and `grades`, a Constructor named `Student()`, and a method named `describe()`. 

Additionally, you will notice that `Student` is a Class. In Java, a Class is the template from which an Object can be created, and an Object is an instance of that class. We use the word "instantiate" when we describe the creation of an Object from a Class by use of the Contructor of that Class.

Here is our `Student` Class declaration again:

```java
public class Student {
    String fullName = "";
    int[] grades;

    public Student(String fName,int[] grades) {
        this.fullName = fName;
        this.grades = grades;
    }

    public void describe() {
        System.out.println("Student: " + this.fullName);
        System.out.println("Grades:");
        for (int grade : this.grades) {
            System.out.println("\t" + grade + " ");
        }
        System.out.println();
    }
}
```

In this previous example, we also use a `Scanner`, which is also an Object. Notice the syntax for Scanner declaration below. And here is how we created an Object of type `Student` by instantiating a `Student`:

```java
import java.util.Scanner;
public class GradeBook {
    public static void main(String[] args) {
        String fullName = "";
        String lineVariable = "---------------------------";
        Scanner sc = new Scanner(System.in);

        System.out.println("Grade Book Example");
        System.out.println("Name of Course:");
        
        String courseName = sc.nextLine();
        System.out.println("How many students are in this class:");
        
        int numOfStudents = sc.nextInt();
        Student[] programmingStudents = new Student[numOfStudents];
        System.out.println("How many grades do you have per student?");

        int numOfGrades = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < programmingStudents.length; i++) {
            int[] grades = new int[numOfGrades];
            System.out.print("Enter Student's Full Name: ");
            fullName = sc.nextLine();
            
            for (int j = 0; j < grades.length; j++) {
                System.out.print("Enter a grade: ");
                grades[j] = sc.nextInt();
            }
            programmingStudents[i] = new Student(fullName, grades);
            sc.nextLine();
        }

        System.out.println("\n\n"+lineVariable+"\n " 
            + courseName + " Grade Book \n"+lineVariable); 

        for (Student student : programmingStudents) { 
            student.describe(); 
        }
        System.out.println(lineVariable+"\n");
        sc.close();
    }
}
```

### Equality

Another difference between **Primitive Datatypes** and **Objects** has to do with **Equality**. The **Equality Operator** in Java `==` checks to see if two references are the same. In other words, when comparing **Primitive Datatypes**, `==` checks to see if two values are the same. With **Primitive Datatype Equality Comparison**, `==` checks the _in-memory_ value of the **Primitive Datatype** against the _in-memory_ value of a different **Primitive Datatype**.   

#### Primitive Datatype Equality

The following code declares two `int` variables and compares the value. Since these two variables are pointing to the same value, the `System.out.println()` will print the following result: `age1 == age2: true`

```java
int age1 = 21;
int age2 = 21;
System.out.println("age1 == age2: " + (age1 == age2));
```

#### Object Equality

Remember that when an Object is instantiated, the programmer has access to all properties and methods that are defined within that Object, through dot-notation.

With the declaration of a `new` **Object**, Java creates that object as its own instance in memory. Even if two **Objects** are created with the same exact content, the **Objects** themselves will be created as two separate instances in memory. The point here is that _each instance has its own location in memory_, and the location is _not_ the same, even if the values within the fields _are_ the same.

Let's look at our Grade Book Example above. Imagine that we instantiate two students using the `Student()` Constructor as follows:

```java
int[] grades = { 100, 100, 100 };
Student student1 = new Student("Molly Mack", grades);
Student student2 = new Student("Molly Mack", grades);
```

Notice that the data is exactly the same, but we are creating two distinct **Objects** by using the `new` keyword. So, if we run the following comparisons, the results will be reflect that the `student1` Object is not the same as the `student2` Object, because their locations in memory are distinct. These are **Objects**, not **Primitive** Datatypes. The **only one** of the following examples that will be `true` is when we compare the `student1.fullName` to `"Molly Mack"` with the `.equals()` method.

```java
System.out.println("student1 vs. student2 Equality Example:");
System.out.println("---------------------------------------");
System.out.println("Is student1 == student2? " 
                    + (student1 == student2));
System.out.println("Is student1.equals(student2)? " 
                    + (student1.equals(student2)));
System.out.println("Is student1.equals(\"Molly Mack\")? " 
                    + (student1.equals("Molly Mack")));
System.out.println("Is student1.fullName.equals(\"Molly Mack\")? " 
                    + (student1.fullName.equals("Molly Mack")));
```

**Object Equality** is fun to explore, and when you assign two variables to the same **Object**, it's fun to see what the result is. Let's declare a new variable `student3` and initialize it with the `student2` **Object** as follows:

```java
Student student3 = student2;
```

The results of the following comparisons will be quite different than the `student1` vs. `student2` comparisons above. In fact, the results will be `true` for each comparison:

```java
System.out.println("student2 vs. student3 Equality Example:");
System.out.println("---------------------------------------");
System.out.println("Is student2 == student3? " 
                    + (student2 == student3));
System.out.println("Is student2.equals(student3)? " 
                    + (student2.equals(student3)));
```

**Put your knowledge to the test:** Why is the result different? Spend some time doing research into Object Equality in Java!


## 5. Menu App Example

**Menu-driven Applications** are very useful in the coding world. They allow a program to receive data directly from a user. The user is provided a menu, and then is instructed to select an option from that menu. The chosen option will be used by the program to execute a code path (or `branch`) specific to that option.

In the Back End, the menus we create are text based. Adding a `Client`--or Front End program--which reads in user data, and then communicates to a Back End Server could provide a graphical user interface for the Menu.

**Menu-driven applications** are used in a variety of industries, including but not limited to computing, application development, banking (ATMs), websites, tablets, self-guided machines, word-processors, gaming, and more.

### Menu-Driven Application:

#### Advantages:

* User-friendly
    - Provide guidance to the user
    - No need for a user to remember commands
* Allow a user to control how and in what order a program executes

#### Disadvantages:

* Difficulty finding content, especially with nested sub-menus

### Menu-Driven Application -- `ArrayIceCreamOrder` Example:

Menu-Driven Applications are really useful, and here is another example using Arrays.

**`ArrayIceCreamOrder.java` Class:**

This is the class that is used to instantiate an `ArrayIceCreamOrder` Object. Notice that this class has fields, a default constructor, additional constructors, and a describe method.

```java
package com.promineotech.application;

public class ArrayIceCreamOrder {
    String user;
    String size;
    String cupOrCone;
    String[] flavors = new String[3];

    // Default Constructor
    public ArrayIceCreamOrder() { 
        this.user = "";
        this.size = "";
        this.cupOrCone = "";
    }

    // Additional Constructors
    public ArrayIceCreamOrder(String user, String[] flavors) {
        this.user = user;
        this.flavors = flavors;
    }

    public ArrayIceCreamOrder(String user, String[] flavors, String size, String cupOrCone) {
        this.user = user;
        this.flavors = flavors;
        this.size = size;
        this.cupOrCone = cupOrCone;
    }

    // Getters & Setters
    public String getUser() { return this.user; }
    public void setUser(String user) { this.user = user; }
    public String[] getFlavors() { return this.flavors; }
    public void setFlavors(String[] flavors) { this.flavors = flavors; }
    public String getSize() { return this.size; } 
    public void setSize(String size) { this.size = size; } 
    public String getCupOrCone() { return this.cupOrCone; } 
    public void setCupOrCone(String cupOrCone) { this.cupOrCone = cupOrCone; }

    // Describe Method
    public void describe(int iceCreamCount) {
        int printFlavors = 0;
        int boxSize = 40;
        char star = '*';

        for (int i = 0; i < boxSize; i++) {
            System.out.print(star);
        }
        
        System.out.println("\nIce Cream Order:\n----------------");
        System.out.print("Name:\n\t" + this.user + "\nOrder: \n\t");
        System.out.println(this.size + " " + this.cupOrCone);

        System.out.print("Flavors:\n\t");

        while (printFlavors < iceCreamCount) {
            System.out.print(this.flavors[printFlavors++]);

            if (printFlavors == iceCreamCount-1) {
                System.out.print (" & \n\t");
            } else if (printFlavors < iceCreamCount-1) {
                System.out.print (", \n\t");
            }
        }

        System.out.println();

        for (int i = 0; i < boxSize; i++) {
            System.out.print(star);
        }
    } // end of describe
} // end of ArrayIceCreamOrder
```

This is the `ArrayMenuInput` Application that uses the above Object:

```java
package com.promineotech.application;

import java.util.Scanner;

public class ArrayMenuInput {
    static String[] iceCreamList = new String[3];
    static int iceCreamCounter = 0;
    static Scanner input = new Scanner(System.in);

    private static final int maxScoops = 3;
    
    private static String[] options = {"Vanilla", "Chocolate", "Mint Chocolate Chip", "Strawberry", "Black Raspberry", "Chocolate Peanut Butter Cup", "Bubble Gum", "Banana Fudge","End of Ice Cream Selection"};

    public static void main(String[] args) {
        // **********************************************************
        // Future enhancement -- Create a List of IceCreamOrders,
        // and then add the order to the list, and prompt the User
        // and ask whether their order is complete or not.
        // **********************************************************

        ArrayIceCreamOrder userOrder = new ArrayIceCreamOrder();
        boolean finished = false;
        System.out.println("\n\n-------------------------\nThis Example Uses Arrays!\n-------------------------\n\n\n");
        System.out.println( "------------------------------\nWelcome to The Ice Cream Stand\n------------------------------\n");

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

                if (counter >= 2) {
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
                        printChoice(options[userInput - 1], counter);
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
                int size = iceCreamCounter;

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
                userOrder.describe(iceCreamCounter);
                System.out.println("\n");

            } else {
                System.out.println("Order Cancelled!");
            }

            // **********************************************************
            // Future enhancement -- Add a menu here to ask the
            // user if they have another request to add to this order.
            // **********************************************************

            finished = true;
        } // end of while
        
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
        iceCreamList[iceCreamCounter++] = flavor;
    }

    public static void printFlavorOptions() {
        System.out.println();
        System.out.println("Choose ice cream flavors:");
        System.out.println("-------------------------");

        for (int i = 0; i < options.length; i++) {
            System.out.println(" " + (i + 1) + ") " + options[i]);
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

} // End of ArrayMenuInput
```

