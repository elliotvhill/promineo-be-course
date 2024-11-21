# Java 3 - Arrays Part 1

This lesson contains Questions 1-10 (Part 1) of the OpenClass Arrays Lesson, and contains five (5) coding questions, each followed by a mastery question.

### Arrays

In the Java Programming Language, the Array data type is a reference type, and is also an Object. As a result of this, Java provides functionality that applies to all Object types. In addition, all **methods** of the class Object may be invoked on an Array. This may be confusing to you at this point, but keep in mind that the Java Documentation is a great resource for research on ways to accomplish tasks in Java. Here is a reminder of where to find related resources:

* [Java 17 Array Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/reflect/Array.html)
* [Java 17 Object Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Objects.html)
* [Java Language Tutorials](https://docs.oracle.com/javase/tutorial/)

An Array is a collection of related data that is stored in a single variable. For example, you might use an Array to store the grades of a class of students, or to store the prices of items in a store. Each element in an Array is of the same data type, such as `int`, `float`, or `String`. To access an element in an Array, you use its **index**. The index of the first element in the Array is always 0, this is also referred to as being zero-based; and the index of the last element is equal to the **length of the Array minus one**. For example, if you have an Array with 10 elements, the first element's index is 0, and the last element's index is 9.

Arrays can be useful when you need to work with a large amount of related data. Instead of creating separate variables for each piece of data, you can store all of the data in a single variable of type Array. This can make your code simpler and easier to manage. In addition to **one-dimensional Arrays**, Java also supports **multidimensional Arrays**, which are **Arrays** that have more than one dimension. For example, a **two-dimensional Array** might be used to store data in a grid, where each element represents a cell in the grid and is referenced by two indexes, one for each dimension.

### Vocabulary terms:

* **Array**: A collection of elements of the same data type that are stored together in a contiguous block of memory.

* **Array bounds**: The range of valid index values for an Array, which is from 0 to the length of the Array minus one.

* **Array initializer**: A shorthand syntax for initializing the elements of an Array when it is declared, which consists of a list of values enclosed in curly braces `{}`.

* **Array length**: The number of elements in an Array, which can be accessed using the length attribute of the Array.

* **Declaration**: The act of creating an Array variable, which includes specifying the data type and optionally the size of the Array.

* **Element**: A single value or item in an Array, which is accessed by its index or position within the Array.

* **Enhanced `for` loop**: A shorthand syntax for iterating over the elements of an Array. This `for` loop executes once for each element in an Array. It can simplify the code and make it more readable when we only need to access the elements of the Array and do not need access to the values of the index.

* **Index**: A zero-based integer that specifies the position of an element within an Array, which is used to access or modify the value of the element.

* **Initialization**: The act of assigning values to the elements of an Array, which can be done using an Array initializer or by assigning values to individual elements using their index.

* **Length**: The number of elements in an Array, which is determined by the size of the Array when it is created and _cannot_ be changed later.

* **Multi-dimensional Array**: An Array that has multiple dimensions, such as a 2D Array that is used to represent a matrix, table, or grid-like structure.


### Using a `for` Loop to Iterate through an Array

In the code example below, we have an Array of `int` called `numbers` with 5 elements. The `for` loop iterates over each element in the Array by using the index `i` to access the current element in each iteration. The loop runs for as long as `i` is less than the length of the Array (`numbers.length`), and increments `i` by 1 after each iteration. Inside the loop, we simply print out the value of the current element using `System.out.println();`.


#### Example:

```java
int[] numbers = {1,2,3,4,5}; for(int i = 0; i < numbers.length; i++) { System.out.println(numbers[i]); }
```

## 1. _Add Them Up_

Using the given Array of 5 integers named `numbers` and the given variable `sum`, print out the sum of all the elements in the Array.

* Write a `for` loop that will iterate over the `numbers` Array and add each element of the Array to `sum`

* Use `System.out.println()` to print the value of `sum` to the console

```java
int[] numbers = {2, 4, 6, 8, 10};
    int sum = 0;
    
    for (int num : numbers) {
        sum += num;
    }
    System.out.println(sum);
```
    
## 2. _Which statement about Arrays in Java is true?_

A. When an Array is declared in Java, you do not need to specify the data type.  
B. Java only supports one-dimensional Arrays.  
**_C. Multidimensional Arrays can be used to store data in a grid-like structure._**  
D. The index of the first element in an Array is equal to the length of the Array.  


### Array Declaration

When you declare an Array in Java, you specify the type of data that will be stored in the Array, as well as the number of elements that the Array can hold. You can initialize the Array using an Array initializer, which lets you specify the values of each element in the Array when you declare it, or you can allocate memory for the Array using the new operator and then assign values to the elements using loops.

You can create an Array by declaring a variable of the desired type, followed by square brackets that include an integer signifying the size of the array. For example, to create an Array of 5 integers, you can do:

```java
int[] numbers = new int[5];
```

This creates a variable `numbers` of type **Array of int** which is the location of an **Array of int** with size 5. Each element in the Array is initialized to the default value of `0` because of the way it was created.

You can also initialize the elements of an Array with specific values using an **Array initializer**. For example:

```java
int[] numbers = {1, 2, 3, 4, 5};
```

This creates an **Array of int** with size 5, and initializes its elements to the values `1`, `2`, `3`, `4`, and `5`.

#### Example of Different Ways to Initialize an Array:

```java
int[] array1 = new int[5]; //declares an integer Array with a size of 5

int[] array2 = {1, 2, 3, 4, 5}; //declares and initializes an integer Array with 5 elements

int[] array3; //declares an integer Array reference without allocating memory for the Array
```

### Accessing Array Elements

To access an element of an Array, you can use its index, which is a zero-based integer that specifies the position of the element in the Array. For example, to access the first element of the `numbers` Array, you can do:

```java
int[] numbers = {1, 2, 3, 4, 5};
int firstNumber = numbers[0];
```

This assigns the value of the first element of the `numbers` Array (which is `1`, in this case) to the variable `firstNumber`.


### Modifying Array Elements

You can also modify the elements of an Array by assigning new values to them using their index. For example, to change the value of the third element of the `numbers` **Array** to `10`, you can do:

```java
numbers[2] = 10;
```

This sets the value of the third element (which has an index of 2) to 10.

**Arrays** can be used in many ways, such as storing a collection of data that needs to be processed or displayed in a certain order or storing the results of a computation for further analysis. It's a fundamental data structure that is used in many programming applications.


## 3. _Print the Values In An Array Twice_

Given an Array of `int` called `arr` and an integer variable `x`, do the following:  

Part 1:

* Loop through the Array `arr` to print the values of the Array, using `System.out.println();`

* Then add the value in `x` to each element in `arr` (after using `System.out.println();`)

Part 2:  

* Loop through the Array `arr` a second time, use `System.out.println();` to print out each element to the console

**Note:**  

* _Remember that you added `x` to each value so now the elements in `arr` have a different value_
* _Do not alter the provided `System.out.println();` statements_

```java
static void addX(int[] arr, int x) {
    System.out.println("**Original**"); // Keep this print statement
    /***** DO NOT CHANGE THE CODE ABOVE THIS LINE ******/

        // WRITE YOUR CODE HERE  FOR PART 1
		for ( int i = 0; i < arr.length; i++ ) {
		    System.out.println(arr[i]);
		    arr[i] += x;
		}

    /***** DO NOT CHANGE THE CODE BELOW THIS LINE *****/ 	
    System.out.println("**New Array**"); // Keep this print statement
    /***** DO NOT CHANGE THE CODE ABOVE THIS LINE *****/

        // WRITE YOUR CODE HERE FOR PART 2 

		for ( int j = 0; j < arr.length; j++ ) {
		    System.out.println(arr[j]);
		}

    /***** DO NOT CHANGE THE CODE BELOW THIS LINE *****/ 
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x;
		int[] arr = { 5, 10, 44, -4, 10 };
		x = in.nextInt();
		addX(arr, x);
	}
```


## 4. _Which full name will print to the console when the code runs?_

```java
public class App{
    public static void main(String[] args){
        String[] firstNames = {"Mike", "Joe", "Brian", "Nick", "Carl"};
        String [] lastNames = {"Jones", "Thompson", "Walton", "Bird", "Jordan"};
        System.out.println(firstNames[1] + " " + lastNames[3]);
    }
}
```

A. Joe Walton  
B. Joe Bird  
C. Mike Bird  
D. Mike Walton  


Modifying Elements in an Array

Given an Array of int named arr, replace the first and last value stored in the Array.
Use the given integer values a and b provided by the user to replace the first and last elements, respectively
Loop through the Array and print each element in the Array to the console
Use System.out.println(); for your print statement.

```java
static void changeTwo(int a, int b, int[] arr) {
/****** DO NOT CHANGE THE CODE ABOVE THIS LINE ******/

        // WRITE YOUR CODE HERE

         arr[0] = a;
         arr[arr.length - 1] = b;
         
         for (int num : arr) { System.out.println(num); }
         
/****** DO NOT CHANGE THE CODE BELOW THIS LINE ******/ 	
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a,b;
		a = in.nextInt();
		b = in.nextInt();
		int[] arr = { 3, 7, 0, 4, -6, 10, 55 };
		changeTwo(a, b, arr);
	}
```

## 5. _What number will print to the console when this code runs?_

```java
public class App{
    public static void main(String[] args){
        int[] arr = new int[5];
        arr[3] = 12;
        System.out.println(arr.length);
    }
}
```

A. 12  
**_B. 5_**  
C. 1  
D. 3  


## 6. _Build & Print an Array of Characters_

Given the variable userWord, create a new Array that is made up of the characters of the word stored in the variable.
Initialize a new Array, name it whatever you want
Make sure to use the correct Java data type for this new Array (data type char)
Add each letter of userWord to the Array as elements
Once you have populated the Array, print to the console each element of the Array
Hint: Use the `charAt()` method

```java
static void charArray(String userWord) {
    /***** DO NOT CHANGE THE CODE ABOVE THIS LINE *****/

        // WRITE YOUR CODE HERE FOR

	char[] arr = new char[userWord.length()];
	
	for (int i = 0; i < userWord.length(); i++) {
	    arr[i] = userWord.charAt(i);
	}
	
	for (char character : arr) { System.out.println(character); }
```

## 7. _Would an Array of Strings be immutable or mutable?_

**_A. mutable_**  

> _Although the String element itself is immutable, and the size of an Array in Java is immutable, an Array element can be changed to a different String, so that makes the Array of Strings mutable._

B. immutable  


### Methods & the Return Statement

A **method** is a set of instructions to accomplish a particular tasks. This code is declared, given a name, and is able to be called over and over again.

In Java, the `return` statement is used to end the execution of a method and `return` a value to the calling method. When a method is called, it can perform some operation on the input values passed to it, and then `return` a result back to the calling method. The `return` statement consists of the keyword `return` followed by an expression that evaluates to the value that is to be returned. This value can be of any data type, including integers, floats, Booleans, or even Objects. Additionally, a method `return` type can also be `void`.

When the `return` statement is encountered in a method, it causes the method to immediately stop executing and `return` the value specified in the statement to the calling method. This returned value can then be used by the calling method in further calculations or operations. It's important to note that a method can only `return` a single value, and that value must match the `return` type specified in the method declaration. If a method is declared to `return` an integer, for example, the `return` statement must return an integer value.

The `return` statement is used frequently in Java programming, and understanding how to use it properly is an important skill for beginners. It allows methods to communicate with each other and share information, making Java programs more powerful and flexible.


## 9. _Create & Return an Array of Characters_

In the static method `wordToArray` take the value of `userWord` and turn it into an Array of `char` taking each letter in `userWord` and storing it into that Array.

* Name your new Array variable `charArray`

* `return` the Array variable in the method body

_Writing code inside a **method** is similar to writing code inside of `main()`._

_We have provided the **method signature** and the opening and closing curly braces `{ }`_

```java
static char[] wordToArray(String userWord) {
/***** DO NOT CHANGE THE CODE ABOVE THIS LINE *****/

    // WRITE YOUR CODE HERE
    
    char[] charArray = new char[userWord.length()];
    for (int i = 0; i < userWord.length(); i++) {
        charArray[i] = userWord.charAt(i);
    }
    return charArray;
}
```

## 10. _What will print to the console when the code below runs?_

```java
String[] passwords = new String[3];

passwords[0] = "421499!";
passwords[1] = "cVTT1290?";
passwords[2] = "11?1!cV32A";

for ( String str : passwords ){
    if (str.length() > 7 && str.contains("?")){
        System.out.println(str);
    }
}
```

A. 11?1!cV32A  
**_B. cVTT1290?_**  
   **_11?1!cV32A_**  
C. 421499!  
   cVTT1290?  
   11?1!cV32A  
D. cVTT1290?  
