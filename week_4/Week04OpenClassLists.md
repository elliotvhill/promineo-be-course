# Java Week 4 - Lists Part 1

### Questions

[Question #1](#1-create-a-list-of-integer)  
[Question #2](#2-what-name-will-print-to-the-console-after-the-following-code-runs)  
[Question #3](#3-access-a-list-of-string)  
[Question #4](#4-looking-at-the-code-below-what-line-would-print-out-the-character-c-to-the-console)  
[Question #5](#5-create-a-new-list-of-string)  
[Question #6](#6-what-is-the-value-stored-in-the-variable-letter-after-the-code-below-runs)  
[Question #7](#7-create-a-new-list-of-integer)  
[Question #8](#8-what-is-the-correct-method-for-determining-how-many-elements-are-in-a-list)  
[Question #9](#9-create-a-list-of-integer)  
[Question #10](#10-what-will-print-to-the-console-when-the-following-code-runs)  
[Question #11](#11-every-other)  
[Question #12](#12-what-will-print-to-the-console-when-the-code-below-runs)  
[Question #13](#13-create-a-list-of-squared-numbers)  
[Question #14](#14-lists-are-a-part-of-or-a-sub-interface-of-which-one-of-the-following-choices)  
[Question #15](#15-print-index-of-userletter)  
[Question #16](#16-if-the-list-alphabet-in-the-code-below-contains-all-lower-case-letters-of-the-alphabet-what-will-print-to-the-console-when-the-systemoutprintln-is-reached)  
[Question #17](#17-list-of-factors)  
[Question #18](#18-what-will-print-to-the-console-when-the-code-below-runs)  
[Question #19](#19-waiting-in-line)  
[Question #20](#20-which-of-the-following-data-structures-is-best-suited-for-a-requirement-where-elements-are-frequently-added-or-removed-from-the-middle-of-the-list)  

## Lists
**Lists** are a commonly used data structure in Java that allow you to store collections of data. Unlike Arrays, which have a fixed size, Lists can grow or shrink dynamically as elements are added or removed. In Java, the most commonly used implementation of a List is the **ArrayList** class, which is part of the `java.util` package.

### Vocabulary terms to know for Lists:

* **List**: An ordered collection of elements that can be accessed by their index.
* **ArrayList**: A class in Java that implements the List interface using an Array to store the elements.
* **LinkedList**: A class in Java that implements the List interface using a Linked List to store the elements.
* **Element**: An individual item in a List.
* **Index**: A numeric value that represents the position of an element in a List.
* **Size**: The number of elements in a List.
* **Iterator**: An object that provides a way to traverse the elements of a List.

### Methods to know for Lists:

* `add()`: A method used to add an element to a List.
* `clear()`: A method used to remove all elements from a List.
* `contains()`: returns true if the List contains the specified element, otherwise false.
* `get()`: A method used to retrieve an element from a List at a specified index.
* `indexOf()`: A method used to retrieve the index of a specified element in a List. 
* `isEmpty()`: A method used to check if a List is empty.
* `remove()`: A method used to remove an element from a List.
* `set()`: A method used to replace an element in a List at a specified index.
* `size()`: returns the number of elements in the List.
* `subList()`: A method used to retrieve a portion of a List between two specified indexes.
      
To use an ArrayList, you first need to import the `java.util` package at the beginning of your code. Then, you can declare a new `ArrayList` variable and specify the type of data that the list will store. For example, to create an ArrayList that stores integers, you can do:

```java
import `java.util`.*;
public class App {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        System.out.println(numbers.get(0));
    }
}
```

In the example above, once the ArrayList is declared, elements can be added to it using the `.add()` method. You can also access elements in an ArrayList using their index, just like with Arrays. The `.get()` method returns the element at the specified index; where it says `numbers.get(0)`, the first element, `1`, will be printed to the console.

To remove elements from an ArrayList, you can use the `.remove()` method. For example:

```java
import `java.util`.*;
public class App {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.remove(1);
    }
}
```

The `.remove()` method as used here, will remove the second element because it has an index of `1`, or rather, the `2` will be removed.

## Problems

### _1. Create a List of Integer_

A List of Integer called `listNums` has been created. A `for` loop is used to populate the List with elements, from one to whatever value is stored in the variable input `endNum`. Print the List to the console.

Use `System.out.println()` to print a List named `listName`, for example, like this: `System.out.println(listName);`

<details><summary><strong>Solution:</strong></summary>

```java
public class CodingQuestion {

    static void createList(int endNum) {
        List<Integer> listNums = new ArrayList<>();
        for (int i = 1; i <= endNum; i++) {
            listNums.add(i);
        }
    /***** DO NOT CHANGE THE CODE ABOVE THIS LINE *****/
        // WRITE YOUR CODE HERE
		
	
	
    /***** DO NOT CHANGE THE CODE BELOW THIS LINE *****/
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int endNum = in.nextInt();
        createList(endNum);
    }
}
```

</details>

### _2. What name will print to the console after the following code runs?_

```java
List<String> str = new ArrayList<>();
str.add("Nick");
str.add("Joe");
str.add("Michael");
str.add("Tyler");
str.add("Mike");
System.out.println(str.get(3));
```

<details><summary><strong>Solution:</strong></summary>

A. Mike  
**_B. Tyler_**  
C. Joe  
D. Nick  
E. Michael  

</details>

### _3. Access a List of String_

Given a List stored in the variable `productList`, write code that will access elements in
the List based on the index value stored in `indexVal`.

* First, check to make sure the number is at least zero, and that it is less than the size of the
List
* Use `System.out.println();` for your print statements. Notice the punctuation in the print statement.
* If `indexVal` is valid, print the product associated with the value stored at `indexVal`
* If `indexVal` is not valid, then print `No product can be found with that product number.` to the console.

<details><summary><strong>Solution:</strong></summary>

```java
public class CodingQuestion {
    public static void main(String[] args) { Scanner in = new Scanner(System.in);
        int indexVal = in.nextInt();
        List<String> productList = new ArrayList<>(); 
        productList.add("Macbook"); 
        productList.add("HP Notebook"); 
        productList.add("iPhone 14"); 
        productList.add("Acer Aspire"); 
        productList.add("Windows Surface"); 
        productList.add("Galaxy S23");
    /***** DO NOT CHANGE THE CODE ABOVE THIS LINE *****/
	    
	    // WRITE YOUR CODE HERE
        
    }
}
```

</details>

### _4. Looking at the code below, what line would print out the character 'c' to the console?_

```java
List<Character> newChars = new ArrayList<>();
newChars.add('a');
newChars.add('b');
newChars.add('c');
newChars.add('d');
newChars.add('e');
```

<details><summary><strong>Solution:</strong></summary>

A. `System.out.println(newChars.get(3));`  
B. `System.out.println(newChars.get(2));`  
C. `System.out.println(newChars[3]);`  
D. `System.out.println(newChars[2]);`  

</details>

### _5. Create a new List of String_

Given a List called `tenWords` that contains ten different words, write code that will find the values stored in 3 particular positions in the List `tenWords` and creates a new List with those words.

* Create a new List of String called `threeWords`
* Given `num1`, `num2`, and `num3` as indexes, retrieve three words stored in `tenWords`. Populate the List `threeWords` with the three elements retrieved from `tenWords`.
* After adding the three words to your new List, print out the List stored in `threeWords` to the console

#### Error Checking:

* Check that each number entered for `num1`, `num2`, and `num3` is a number from `0` to `9`.
* Otherwise, print "Sorry, there was an error getting a number you requested."

Use `System.out.println();` for all of your print statements.

<details><summary><strong>Solution:</strong></summary>

```java
public class CodingQuestion {
    static void wordReplace(List<String> tenWords, int num1, int num2, int num3) {
	    // WRITE YOUR CODE HERE

/***** DO NOT CHANGE THE CODE BELOW THIS LINE *****/
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int num3 = in.nextInt();
        List<String> tenWords = new ArrayList<String>(); 
            tenWords.add("Bumfuzzle"); 
            tenWords.add("Cattywampus"); 
            tenWords.add("Widdershins"); 
            tenWords.add("Gubbins"); 
            tenWords.add("Lollygag"); 
            tenWords.add("Malarkey"); 
            tenWords.add("Wabbit"); 
            tenWords.add("Impignorate"); 
            tenWords.add("Yarborough"); 
            tenWords.add("Bloviate"); 
        wordReplace(tenWords, num1, num2, num3);
    }
}
```

</details>

### _6. What is the value stored in the variable letter after the code below runs?_

```java
List<Character> newChars = new ArrayList<>();
newChars.add('a');
newChars.add('b');
newChars.add('c');
newChars.add('d');
newChars.add('e');
char letter = newChars.remove(3);
```

<details><summary><strong>Solution:</strong></summary>

**Multiple-choice options (select one)**  
A. b  
B. c  
C. e  
**_D. d_**  
E. a  

</details>

### _7. Create a New List of Integer_

Given four int numbers stored in the variables `num1`, `num2`, `num3`, and `num4`
Create a List of Integer, give it a name
Store all of the values of the variables in the List as its elements
Add an element to the end of the List that stores the sum of all the values 
Print the List to the console

<details><summary><strong>Solution:</strong></summary>

```java
static void sumList(int num1, int num2, int num3, int num4) {
        // WRITE YOUR CODE HERE

/***** DO NOT CHANGE THE CODE BELOW THIS LINE *****/ 
    Scanner in = new Scanner(System.in); int num1, num2, num3, num4;

    num1 = in.nextInt();
    num2 = in.nextInt();
    num3 = in.nextInt();
    num4 = in.nextInt();
    sumList(num1, num2, num3, num4);
}
```

</details>

### _8. What is the correct method for determining how many elements are in a List?_

<details><summary><strong>Solution:</strong></summary>

A. `someList.length();`  
B. `someList.length`  
**_C. `someList.size()`_**  
D. `someList.size`  

</details>

### _9. Create a List of Integer_

Given the value stored in the variable `endNum`, do the following:

* Create a List of Integer called `newList`
* Add the numbers `1` to `endNum` to the List using a loop
* Then, print the first element from the List to the console using `The first number in the List is ` + method to get the first element
* Finally, print the last element of the List to the console using `The last number in the List is ` + method to get the last element
* The last element of the List should **NOT** be retrieved using a hard-coded index like `someList.get(10)`

**Note:** Before creating the List, check if `endNum` is greater than zero and if it is, then proceed creating the List. If `endNum` is not greater than zero, then simply print `Your List cannot be created with a number less than one.`

<details><summary><strong>Solution:</strong></summary>

```java
static void beginEnd(int endNum) {
    // WRITE YOUR CODE HERE

/***** DO NOT CHANGE THE CODE BELOW THIS LINE *****/ 
    Scanner in = new Scanner(System.in);
    int endNum = in.nextInt();
    beginEnd(endNum);
}
```

</details>

### _10. What will print to the console when the following code runs?_

```java
List<Integer> newInts = new ArrayList<>();
newInts.add(143);
newInts.add(-93);
newInts.add(54992);
newInts.add(17);

System.out.println(newInts.get(newInts.size()));
```

<details><summary><strong>Solution:</strong></summary>

A. 17  
B. 54992  
**_C. An "Out of Bounds" error message_**  

</details>

### _11. Every Other_

Given a List of String called `words` and containing 5 values entered by the user stored in the variables `word1`, `word2`, `word3`, `word4`, and `word5`, create a new List.

* Create a new List of String called `newList`
* This new List will contain every other List item from the original List called `words` starting with the first item
* When done populating `newList`, execute your code to see what prints to the console

Use a loop to populate the `newList` with elements

<details><summary><strong>Solution:</strong></summary>

```java
static void halfList(List<String> words) {
    
        // WRITE YOUR CODE HERE
        List<String> newList = new ArrayList<String>();
		
		for (int i = 0; i < words.size(); i++) {
			if (i % 2 == 0) {
				newList.add(words.get(i));
			}
		}
    /***** DO NOT CHANGE THE CODE BELOW THIS LINE *****/
        System.out.println("The old List is: " + words);
        System.out.println("The new List is: " + newList);
    }
        
        String word1, word2, word3, word4, word5;
        word1 = in.nextLine();
        word2 = in.nextLine();
        word3 = in.nextLine();
        word4 = in.nextLine();
        word5 = in.nextLine();
        List<String> words = new ArrayList<>();
        words.add(word1);
        words.add(word2);
        words.add(word3);
        words.add(word4);
        words.add(word5);
        
        halfList(words);
```

</details>

### _12. What will print to the console when the code below runs?_

```java
List<Integer> newInts = new ArrayList<>();
newInts.add(894);
newInts.add(-1);
newInts.add(1077);
newInts.add(43);
newInts.add(54329);

Collections.sort(newInts);
System.out.println(newInts);
```

<details><summary><strong>Solution:</strong></summary>

A. an error message  
**_B. [-1, 43, 894, 1077, 54329]_** _The Java `Collections.sort()` method actually sorts and replaces the items in the List in sorted order._  
C. nothing, but no error message  
D. [894, -1, 1077, 43, 54329]  

</details>

### _13. Create a List of Squared Numbers_

Given five numbers by the user stored in `num1`, `num2`, `num3`, `num4`, and `num5`:

* Create a List of Integer called `squaredNums`
* Add the squared values of each user number as elements to `squaredNums`
* Finally, return `squaredNums`
To square a number you can simply do `num1 * num1`


<details><summary><strong>Solution:</strong></summary>

```java
static List squaredList(int num1, int num2, int num3, int num4, int num5) {
 	
    // WRITE YOUR CODE HERE
    
    List<Integer> rootNums = Arrays.asList(num1, num2, num3, num4, num5);
    
    List<Integer> squaredNums = new ArrayList<Integer>();
    for (int num : rootNums) {
        squaredNums.add(num * num);
    }
    return squaredNums;
    
/***** DO NOT CHANGE THE CODE BELOW THIS LINE *****/		
}
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int num1 = in.nextInt();
    int num2 = in.nextInt();
    int num3 = in.nextInt();
    int num4 = in.nextInt();
    int num5 = in.nextInt();
    System.out.println(squaredList(num1,num2,num3,num4,num5));
}
```

</details>

### _14. Lists are a part of or a sub-interface of which one of the following choices:_

<details><summary><strong>Solution:</strong></summary>

A. ArrayList  
B. LinkedList  
**_C. Collections_**  
D. Maps  

</details>

### _15. Print Index of userLetter_

Given a List of `char` called `alphabet`, search the List for the `char` stored in `userLetter` and print to the console the index value of that `char`.

<details><summary><strong>Solution:</strong></summary>

```java
char userLetter = 'n';
    List<Character> alphabet = new ArrayList<>();
        for (int i = 97; i < (97+26); i++) {
            alphabet.add((char) i);
        }
        
    findLetter(alphabet, userLetter);

static void findLetter(List<Character> alphabet, char userLetter) {
    System.out.println(alphabet.indexOf(userLetter));
}
```

</details>

### _16. If the List `alphabet` in the code below contains all lower case letters of the alphabet, what will print to the console when the `System.out.println()` is reached?_

<details><summary><strong>Solution:</strong></summary>

```java
List<Character> alphabet = new ArrayList<>();
for(int i = 97; i < (97 + 26); i++){
    alphabet.add((char)i);
}

alphabet.remove(0);
System.out.println(alphabet);
```

A. all the letters of the alphabet  
B. all the letters of the alphabet, except for 'a'  
C. nothing  
D. a  

</details>

### _17. List of Factors_

Given a variable int called `userNumber`, create a List of Factors and print the List to the console.

* Create a List of Integer Factors by declaring a new List variable, name it `factorNum`
* Find all the positive factors of `userNumber` using a loop from `1` to `userNumber`
* In the loop, store the factors of `userNumber` as elements of the `factorNum` List
* Finally, print the List to the console

**Note:** All values of `userNumber` will have two (2) possible factors at a minimum: one (`1`) and `userNumber`.

<details><summary><strong>Solution:</strong></summary>

```java
static void factors(int userNumber) {

    // WRITE YOUR CODE HERE
    List<Integer> factorNum = new ArrayList<Integer>();

    if (userNumber > 0) {
        for (int i = 1; i <= userNumber; i++) {
            if (userNumber % i == 0) {
                factorNum.add(i);
            }
        }
        System.out.println(factorNum);
    } else {
        System.out.println("Number must be greater than 0.");
    }
    
/***** DO NOT CHANGE THE CODE BELOW THIS LINE *****/
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int userNumber = in.nextInt();
		factors(userNumber);
	}
```

</details>

### _18. What will print to the console when the code below runs?_

```java
List<Double> measurements = new ArrayList<>();
    measurements.add(1.12);
    measurements.add(6.9);
    measurements.add(14.25);
    measurements.add(20.84);
    System.out.println(measurements.contains(14.25));
```

<details><summary><strong>Solution:</strong></summary>

A. 14.25  
B. false  
**_C. true_**  

</details>


## Linked Lists

A **Linked List** is a data structure that is used to store a sequence of elements. Unlike an Array, which stores elements in contiguous memory locations, a **Linked List** stores elements in separate **nodes** that are linked together by **pointers**.

Each **node** in a Linked List contains an element of data, and a reference to the next node in the List. The first node in the List is called the **head**, and the last node is called the **tail**. The tail node's reference to the next node is `null`.

Linked Lists are dynamic data structures, meaning that they can grow or shrink in size during program execution. This makes them very useful for situations where the size of the data being stored is not known ahead of time.

### Java LinkedList

To use a Linked List in Java, you need to create a `LinkedList` Object, which is part of the `java.util` package. You can then add elements to the List using the `.add()` method, remove elements using the `.remove()` method, and access elements using the `.get()` method, similarly to an `ArrayList` Object.

### Advantages and Disadvantages of LinkedList

One advantage of a LinkedList over an Array is that adding or removing elements from the middle of the LinkedList is very efficient. To insert an element into a LinkedList, you simply create a new node and adjust the references of the surrounding nodes. To remove an element, you just need to adjust the references of the surrounding nodes. However, LinkedLists can be less efficient than Arrays when it comes to accessing elements by index, because you need to traverse the List from the head or tail to get to the desired element. Overall, LinkedLists are a useful data structure to know about in Java and can be used in a variety of programming tasks.

Overall, `ArrayList` is a good choice when **random** access to elements is important, while `LinkedList` is a good choice when **frequent insertions or deletions in the middle** of the List are expected.

#### LinkedList Example:

```java
public class ShoppingList {
    public static void main(String[] args) {
        // Create a new LinkedList to store our shopping list
        LinkedList<String> shoppingList = new LinkedList<>();

        // Add some items to the list
        shoppingList.add("Apples");
        shoppingList.add("Bread");
        shoppingList.add("Bananas");
        shoppingList.add("Milk");
        shoppingList.add("Cheese");
        shoppingList.add("Eggs");
        shoppingList.add("Ham");

        shoppingList.remove(2);

        // Print out the entire shopping list using an enhanced for loop
        System.out.println("Shopping List:");

        for (String item : shoppingList) {
            System.out.println(item);
        }
    }
}
```

In the example above, a **LinkedList** is initialized and 7 items are added to it.
Then the following is printed to the console:

```java
    Shopping List:
    Apples
    Bread
    Bananas
    Milk
    Cheese
    Eggs
    Ham
```

Now imagine that you remember that you already have a pound of ham and a bunch of bananas at home. You need to remove the ham and bananas from the shopping list. This can be done by adding these two lines of code:

```java
    shoppingList.remove(2);
    shoppingList.remove(6);
```

After removing those two elements from the LinkedList, the following is then printed to the console:

```java
    Shopping List:
    Apples
    Bread
    Milk
    Cheese
    Eggs
```

### _19. Waiting in Line_

Given an initialized LinkedList called line containing 3 elements that represent people standing in line for a rollercoaster ride. The names of the people in line are "Amanda", "Brad", and "Cori", in that order. It is now Amanda's turn to ride. Do the following:
Remove the first element of the List, "Amanda"
Add another element to the end of the List, this element is "Danny"
Execute your code. The List should change from [Amanda, Brad, Cori] to [Brad, Cori, Danny].

<details><summary><strong>Solution:</strong></summary>

```java
LinkedList<String> line = new LinkedList<String>();
    line.add("Amanda");
    line.add("Brad");
    line.add("Cori");
    
    System.out.println("People in line: " + line);
    System.out.println("First person in line was: " + line.get(0));
    System.out.println("The last person in line was: " + line.get(2));
        
    /***** DO NOT CHANGE THE CODE ABOVE THIS LINE *****/
            
        // WRITE YOUR CODE HERE
    line.remove(0);
    line.add("Danny");
        
    /***** DO NOT CHANGE THE CODE BELOW THIS LINE *****/
    System.out.println("People in line now: " + line);
    System.out.println("Now the first person in line is: " + line.get(0));
    System.out.println("The last person in line is: " + line.get(2));
```

</details>

### _20. Which of the following data structures is BEST suited for a requirement where elements are frequently added or removed from the middle of the List?_

<details><summary><strong>Solution:</strong></summary>

A. None of the above  
B. ArrayList  
**_C. LinkedList_**  
_Adding or removing an element from the middle of the List in a LinkedList involves changing the references of the neighboring nodes to point to the new or removed node, without the need to move any other elements in the List. This operation is faster and more efficient than shifting elements in an ArrayList, especially for large Lists._

</details>