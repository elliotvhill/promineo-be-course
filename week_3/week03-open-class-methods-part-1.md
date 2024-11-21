# Java 3 - Methods Part 1

This lesson contains Questions 1-10 (Part 1) of the OpenClass Methods Lesson, and contains five (5) coding questions, each followed by a mastery question.


### What is a method?
In Java, a **method** is a block of code that performs a specific task. Think of it this way: a *method* is a set of coding instructions which can be referenced by name, and called at any point in a program by simply using the method's name. The main purpose of writing methods is code reusability, which implies that the code is written once, and then can be used over and over.

Additionally, methods are useful when breaking down complex programs into smaller, more manageable pieces. A method would then be written to solve the smaller piece, and would be called from the main program or another method. Methods can be called from other parts of the program, making it easy to reuse code and make changes to the program's behavior.

### The Parts of a Method

* **method declaration:** The only required parts of a method declaration are the method's **_return type_**, **_name_**, a **_pair of parentheses_** `()`, and a **_body between braces_** `{}`.

* **method signature:** Two of the components of a method declaration comprise a **method signature** — the method's **_name_** and the **_parameter types_**. _(**Note:** a method signature does not contain anything else.)_.

* There are other parts that can be used when writing a Java method. The complete list of components of a method declaration are as follows:

    - **Modifiers:** Access Modifiers (e.g. `public`, `private`, `protected`) or **Non-Access Modifiers** (e.g. `static`)

    - **Return Type:** Either the data type (primitive or reference) of the value to be returned by the method, or void (no return value)

    - **Method Name:** A name give to the method, following the rules for field names, written in camelCase format.
    
    - **Parameter List:** Either `()`, or a list of input parameters, comma-delimited, preceded by the data type, enclosed in `()`.

    - **Exception List:** This is a list of **Exceptions** that can be thrown by the method -- i.e. Error Handling.

    - **Method Body:** the code written, enclosed in `{}`


### Method Declaration

When writing a method, you need to specify its **name**, **return type**, and any **parameters** it may take, as well as write a **body** which contains the functionality of the method.

* The **name** of the method should be descriptive and indicate what the method does.

* The **return type** specifies the type of data that the method will return, and if the method does not return any data, its return type is `void`.

* Any **parameters** are optional and allow you to pass data to the method when it is called, if required.

* The **body** will contain any Java statements that accomplish the purpose of the method.

#### Example Method Declaration

```java
  public int calculateSum(int number1, int number2) {
        return number1 + number2;
  }
```

### Method Invocation

To call a method, you simply use its **name** followed by **parentheses** `()`, and any necessary **arguments** within the parentheses. The method will then execute its code, and may `return` a value if a return type other than `void` is specified.

#### Example Method Invocation

```java
   int num1 = 5;
   int num2 = 5;
   int sum = calculateSum(num1, num2);
```

### Conclusion

Using **methods** in Java can help make your code more modular, efficient, and easier to understand. It also allows you to reuse code and avoid repeating the same code over and over again. By learning how to use methods effectively, you can become a more proficient and efficient Java programmer.


## 1. _`returnSum` Method_

Create a static method named `returnSum` that accepts 3 `int` variables named `num1`, `num2`, and `num3`

* The method should `return` the sum of the three variables

* **Note:** Don't forget to include the opening and closing curly braces for the method

```java
public class CodingQuestion {

// WRITE YOUR CODE HERE




/***** DO NOT CHANGE THE CODE BELOW THIS LINE *****/
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num1, num2, num3;
		num1 = in.nextInt();
		num2 = in.nextInt();
		num3 = in.nextInt();
		System.out.println(returnSum(num1, num2, num3));
	}
}
```

## 2. _What is wrong with the code below?_

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(isDivisibleBy2(5));
    }
    static double isDivisibleBy2(int a){
       if ( a % 2 == 0) {
          return true;
       } else {
          return false;
       }
    }  
}
```

A. Nothing, the code will run.  

B. We are returning the wrong type of value - instead of double, it should be int.  

C. We are returning the wrong type of value - instead of double, it should be boolean.  

### Static Methods

#### Example of a Static Method:

```java
    public class MyClass{

       public static int addNumbers(int a, int b) {
          int sum = a + b;
          return sum;
       }
    }
```

### Parts of a Static Method

* `public static`: These are **modifiers** that specify the scope and behavior of the method. `public` is an **access modifier** meaning the method can be accessed from anywhere in the program, and `static` is actually a **non-access modifier** which means the method belongs to the class and not to any instance of the class.

* `int`: This is the **return type** of the method. It specifies what type of value the **method** will return.

* `addNumbers`: This is the **name** of the **method**. It should be a descriptive name that tells you what the **method** does.

* `(int a, int b)`: These are the **method parameters**. In this case, the **method** takes two `int` values as input, which are named `a` and `b`.

* `int sum = a + b;`: This line creates a new variable named `sum`, which is an `int` type, and assigns it the value of `a + b`. This calculates the _sum_ of the two input values.

* `return sum;`: This line returns the value of sum as the result of the **method**. The `return` keyword is used to specify the value that the **method** will return. In this case, it returns the sum of the two input values.

### Calling a Static Method

To call this method outside of the class MyClass, you would use the following code:

```java
int result = MyClass.addNumbers(8, 6);
System.out.println(result);

// Output: 14
```

Where `MyClass` is the name of the class that contains the `addNumbers` method. This would assign the value `14` to the variable `result`.

### Return Type `void`

#### Example of a Method with a `void` Return Type:

```java
public void printMessage(String message) {
    System.out.println(message);
}
```

The example above takes a String argument and prints it to the console. It does not return any value, which is indicated by the `void` return type. To call this method, you would use the following code:

```java
printMessage("Hello, world!");
// Output: Hello, world!
```

### Vocabulary terms:

* **Argument**: A value that is passed to a method when it is called. Arguments are enclosed in parentheses and separated by commas.

* **Call**: The act of invoking a method by its name. Method calls typically include the method name followed by parentheses, which may contain arguments.

* **Method**: A block of code that performs a specific task. Methods can be called by other parts of the program to execute the task.

* **Method signature**: The combination of a method name and its parameter types, which uniquely identifies the method.

* **Overloading a method**: Creating multiple methods with the same name but different parameter lists.

* **Return type**: The data type of the value returned by a method. If a method doesn't return a value, its return type is `void`.

* **Parameter**: A variable that is declared in the method declaration and is used to accept an argument passed to the method.

* **Scope**: The region of the program where a variable can be accessed. Variables declared within a method have local scope and can only be accessed within that method. Additionally, a variable declared inside pair of brackets `{}` anywhere within any method has scope within the brackets only, loop variables are an example of this.

* **Signature**: The combination of a method name and its parameter types.

* **Static method**: A method that is associated with a class, rather than with an instance of the class.

* **Syntax**: The set of rules that govern the structure of a program.

* `void`: A return type used when a method doesn't return a value.


## 3. _`repeatWord` Method_

Complete the method that takes a String named `userWord` and an integer value named `numTimes`.

* In that method you will take the value stored in `numTimes` and create a new String that repeats `userWord` that many times

* Then `return` the new String value from the method

_Ex. if userWord is "Java" and numTimes is 5, the returned **String** would be "JavaJavaJavaJavaJava"_

```java
public class CodingQuestion {

	static String repeatWord(String userWord, int numTimes) {
	
	    // WRITE YOUR CODE HERE
	





/***** DO NOT CHANGE THE CODE BELOW THIS LINE *****/ 
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numTimes;
		String userWord;
		userWord = in.nextLine();
		numTimes = in.nextInt();
		System.out.println(repeatWord(userWord,numTimes));
	}
}
```

## 4. _What will print to the console when the code below runs?_

```java
public class MethodsApp{
    public static void main(String[] args) {
        System.out.println(divideNums(5, 0));
    }
    static double divideNums(int a, int b){
        return a/b;
    }
}
```

A. 1  
B. 0  
C. 5  
D. Java will give an error message  


### Overloaded Methods

Below you will find two distinct methods with the same name. Observe how the methods take in a different number of parameters. The first `addNumbers()` method adds two numbers, while the second `addNumbers()` method adds three numbers. Java distinguishes between the methods based on the number and types of parameters.

#### Example:

```java
    public int addNumbers(int x, int y) {
        int sum = x + y;
        return sum;
    }

    public int addNumbers(int x, int y, int z) {
        int sum = x + y + z;
        return sum;
    }
```
    
### Calling the Methods

To call the first method, `addNumbers()` with two parameters, you would use the following code:

```java
int result = addNumbers(5, 7);
// Output: 12
```

To call the second method, `addNumbers()` with three parameters, you would use the following code:

```java
int newResult = addNumbers(5, 7, 11);
// Output: 23
```

### 5. _`fizzBuzz` Method_

Complete the method called `fizzBuzz` that accepts the integer value stored in `num1`.

* If the value is divisible by 3, print `Fizz` to the console

* If the value is divisible by 5 print `Buzz` to the console

* If the value is divisible by both 3 and 5 print `FizzBuzz` to the console

* If the number is not divisible by either 3 or 5, print `Hello world!` to the console

* Use `System.out.println()` in all of your print statements

```java
public class CodingQuestion {

	static void fizzBuzz(int num1) {
	    
	    // WRITE YOUR CODE HERE




		
		
/***** DO NOT CHANGE THE CODE BELOW THIS LINE *****/
	}
    
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num1;
		num1 = in.nextInt();
		fizzBuzz(num1);
	}
}
```

### 6. _What will print to the console after the code below runs?_

```java
public class MethodsApp {
    static int returnSum(int x, int y, int z){
        int answer = x + y + z;
        return x;
    }
    public static void main(String[] args) {
        int a = 10, b = 10, c = 10;
        System.out.println(returnSum(a,b,c));
    }
}
```

A. Error Message  
B. 30  
C. 10  

### 7. Error Analysis

Fix the error in this method. It is supposed to `return` the sum of the three integers for a total of 30 but it only returns 10. Fix this bug with only changing one line of code.

```java
public class MethodsApp {
    static int returnSum(int x, int y, int z){
        int answer = x + y + z;
        return x;
    }
    public static void main(String[] args) {
        int a = 10, b = 10, c = 10;
        System.out.println(returnSum(a,b,c));
    }
}
```

#### Solution: 

```java
public class MethodsApp {

    static int returnSum(int x, int y, int z){
        
        // CHANGE ONLY ONE OF THESE LINES TO FIX THE ERROR
        int answer = x + y + z;
        return x;
        
/***** DO NOT CHANGE THE CODE BELOW THIS LINE *****/
    }
    public static void main(String[] args) {
        int a = 10, b = 10, c = 10;
        System.out.println(returnSum(a,b,c));
    }
}
```

### _8. Which of the following statements about return type in Java methods is true?_

A. Return type specifies the parameters that the method can accept.  
B. Return type specifies the scope of the method.  
C. Return type specifies the data type of the value returned by the method.  
D. Return type specifies the name of the method.  


### Variable Scope in Java

In Java, **variable scope** refers to the range of code within which a variable can be accessed. A variable declared in one part of the code may not be accessible in another part of the code depending on its scope.

### The different types of variable scope in Java are:

* **Local Scope**: A variable declared inside a method or a block of code has local scope. It can only be accessed within that method or block.

* **Class Scope**: A variable declared inside a class but outside a method has class scope. It can be accessed by all methods and blocks of code within the class.

* **Method Parameter Scope**: A variable declared as a parameter of a method has method parameter scope. It can only be accessed within that method.

* **Static Scope**: A variable declared as static has static scope. It can be accessed by all methods and blocks of code within the class and can also be accessed without creating an instance of the class.

It's important to understand variable scope in Java as it can help avoid errors and ensure code is written in a way that is easy to maintain and understand.


### 9. _What is your `orderTotal`?_

Complete the method called `orderTotal` that takes in 4 doubles stored in `product1`, `product2`, `product3`, and `taxRate`. The method will sum the values of `product1`, `product2`, and `product3`. Then, it will figure out the applicable sales tax using the variable `taxRate`. Finally, the method should return a double that is the total order price with tax.

```java
public class CodingQuestion {

	static double orderTotal(double product1, double product2, double product3, double taxRate) {
	    
	    // WRITE YOUR CODE HERE



		
/***** DO NOT CHANGE THE CODE BELOW THIS LINE *****/
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double product1, product2, product3, taxRate;
		product1 = in.nextDouble();
		product2 = in.nextDouble();
		product3 = in.nextDouble();
		taxRate = in.nextDouble();
		System.out.println("Your order total is: $" + String.format("%,.2f", orderTotal(product1, product2, product3, taxRate)));
	}
}
```

### 10. _Which of the following is an example of a variable with local scope in Java?_

A. A variable declared as static  
B. A variable declared as a parameter of a method  
C. A variable declared inside a class but outside a method  
D. A variable declared inside a method  