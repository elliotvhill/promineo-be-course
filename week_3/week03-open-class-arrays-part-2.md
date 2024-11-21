# Java 3 - Arrays Part 2

This lesson contains Questions 11-20 (Part 2) of the OpenClass Arrays Lesson, and contains five (5) coding questions, each followed by a mastery question.


## 11. Build and Return an Array:

In the method `buildArray` you will take the `int` value stored in the given variable `num` and declare an Array of that size called `numArray`.

* Write a `for` loop that starts with a loop variable or index of zero (`0`) and checks to see if the loop variable is less than num.

* To fill the Array, you will insert the value of that loop variable to one of the slots in `numArray` indexed by the loop variable

* `return` the variable `numArray` after the for loop finishes

_Hint: Put the `return` statement outside of your `for` loop._

```java
	static int[] buildArray(int num) {
    
    // WRITE YOUR CODE HERE
    
    int[] numArray = new int[num];
    for (int i = 0; i < num; i++) {
        numArray[i] = i;
    }
    return numArray;

/****** DO NOT CHANGE THE CODE BELOW THIS LINE ******/
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num;
		num = in.nextInt();
		System.out.println("Your array is: ");
		System.out.println(Arrays.toString(buildArray(num)));
	}
```

## 12. _What number will print to the console when this code runs?_

```java
int[] arr = new int[5];
for ( int i = 1; i <= 5; i++){
    arr[i - 1] = i;
}
System.out.println(arr[2]);
```

A. 2  
**_B. 3_** -- `arr[2]` is `arr[3-1] = 3`, so `arr[2]=3`.  
C. 4  
D. 1  


## 13. _Create An Array of Integer_

In the method `createInt` create an Array

* Use the 6 variables that are passed in as `num1`, `num2`, `num3`, `num4`, `num5`, and `num6` to create the Array

* The Array of `int` should be called `arrayInt`

* Make sure to `return` the last item in `arrayInt`

```java
static int createInt(int num1, int num2, int num3, int num4, int num5, int num6) {
/****** DO NOT CHANGE THE CODE ABOVE THIS LINE ******/

        // WRITE YOUR CODE HERE
	
        int[] arrayInt = {num1, num2, num3, num4, num5, num6};
        return arrayInt[arrayInt.length - 1];
        
/****** DO NOT CHANGE THE CODE BELOW THIS LINE ******/
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num1, num2, num3, num4, num5, num6; 
		num1 = in.nextInt();
		num2 = in.nextInt();
		num3 = in.nextInt();
		num4 = in.nextInt();
		num5 = in.nextInt();
		num6 = in.nextInt();
		int returnedInt = createInt(num1, num2, num3, num4, num5, num6);
		System.out.println("The last number of the array is " + returnedInt + ".");
	}
```

## 14. _What will the new Array be after the following code runs?_

```java
int[] arr = {-11, 43, 901, 43, -5};

arr[arr.length - 2] = 0;

for (int n : arr){
    System.out.print(n + " ");
}
```

A. -11 43 901 43 0 -5  
B. -11 43 901 43 -5  
**_C. -11 43 901 0 -5_**  


## 15. _Build A New Array_

Given an Array of words named `arr` and variables `word1`, `word2`, and `word3`, do the following:

* Create a new Array called `newArr` that has `word1`, `word2`, and `word3` as its elements

* Create another Array that is big enough to hold all of the words from the original Array `arr`, as well as the three new words. You can name this Array to your liking.

* Write a loop to get the words from the original Array `arr` and put them into your new Array

* Add the words from `newArr` into the new Array also

* Finally, loop through your new Array and print each element to the console

_An idea to get more practice with Arrays: You could create an Array for the three new words, and then loop through two Arrays to create your new Array._

```java
static void newArray(String word1, String word2, String word3, String[] arr) {

    String[] newArr = {word1, word2, word3};
    String[] biggerArr = new String[newArr.length + 3];

}

// Sample Test Case #1
// Yankees
// Orioles 
// Mariners

// Expected STDOUT
// Astros
// Reds
// Phillies
// Dodgers
// Angels
// Yankees
// Orioles 
// Mariners
```


## 16. _What number will print to the console after the following code runs?_

```java
int[] arr = { -11, 43, 901, 72, -5};
int[] arr2 = arr.clone();

System.out.println(arr2[3]);
```

A. Nothing - clone( ) isn't a real Array method  
B. 901  
C. 72  

## 17. *Reverse An Array*

Using the initialized Array named arr that uses five (5) integers provided by the user as elements.
Create a new Array called reverseArr that is the reverse of the original Array arr
Then write a loop that will iterate through each Array and print each element in the console
Note: You should print the elements of both Arrays
Hint: Both Array should have the same amounts of elements and therefore have the same lengths
Code
Reset
Java
Sample Test Case #1
50
25
0
25
50
Execute code
STDOUT
Expected STDOUT
50
25
0
25
50
50
25
0
25
50
Submit answer
Did you like this question?

imgimg
(Voting helps us personalize your learning experience!)
In Java, can you have an Array of mixed types of values (i.e. an Array that contains both data of type String & int, or int & char, etc.)?
Multiple-choice options (select one)

A.
No

B.
Yes

Submit answer
Did you like this question?

imgimg
(Voting helps us personalize your learning experience!)
Multidimensional Arrays
Multidimensional Arrays are a type of Array in Java that can store data in more than one dimension. They are essentially Arrays of Arrays, where each element in the Array is itself an Array. They are useful for storing and manipulating data that has a 2D structure, such as matrices, tables, and grids. A 2D Array is a special case of a multidimensional Array, where each element in the main Array contains another Array, resulting in two dimensions (rows and columns). However, in general, a multidimensional Array can have more than two dimensions, allowing for even more complex data structures to be created.

Example of how to Initialize 2D Arrays:
    //declares a 2D integer Array with 3 rows and 4 columns
    int[][] matrix1 = new int[3][4]; 


    //declares and initializes a 2D integer Array with 3 rows and 4 columns
    int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}; 
The total elements in a 2D Array can be calculated by multiplying the number of rows by the number of columns. In the examples above, each 2D Array would be initialized with 12 elements total.

To access an element in a multidimensional Array, you need to specify the indices of both the row and column that the element is located in. Multidimensional Arrays can be useful for storing and manipulating data that has more than one dimension, such as matrices, images, and maps. They can also be sorted and searched just like one-dimensional Arrays. However, they can be more complex to work with than one-dimensional Arrays, and it's important to keep track of the dimensions and indices of the elements when working with multidimensional Arrays. Overall, understanding how to work with multidimensional Arrays is an important skill for any Java developer who needs to work with complex data structures.

Example of a MultiDimensional Array:
    public class App{
        public static void main(String[] args){

            // a 2D Array with 3 rows and 4 columns
            int[][] numbers = {{11, 12, 13, 14},
                               {21, 22, 23, 24},
                               {31, 32, 33, 34}};

            // print out the elements in the Array
            for (int i = 0; i < numbers.length; i++) {
               for (int j = 0; j < numbers[i].length; j++) {
                  // prints the columns of a row
                  System.out.print(numbers[i][j] + " ");
               }
               // prints each row on a new line
               System.out.println();
            }    
        }
    }
In this example, we first create a 2D Array called numbers with 3 rows and 4 columns using an Array initializer. We then use a nested for loop to iterate over the rows and columns of the Array, and print out each element using the indices i and j.

When we run this program, it will output the elements in each Array in the 2D Array, as follows:

   /* Output:
    11 12 13 14
    21 22 23 24
    31 32 33 34
    */ 
Multidimensional Arrays
   This is an advanced problem!

In this problem you will create a multidimensional Array of int named arr.
You are given two integer variables, a and b that are user inputs
Use these integer values to initially declare your new Array arr, where these integers determine the size of both dimensions of the Array
Then, use these int values to create both an inner and outer Array using some type of loop (maybe a for loop) that starts at zero and goes to whatever number values are stored in a and b
To complete this problem, when you've populated the Arrays (after the nested loops have completed), print the last element of the first Array to the console.
Here are a few tips:

Error Checking: Make sure both numbers entered by the user are greater than two (2). If not, print the following message to the console: "Both numbers need to be greater than 2."
You will need to create two loops to populate the multidimensional Array, storing the index of the second loop in the Array positions.
Extra comments are provided to help you along the way.
Hint: With firstPosition meaning the first position in an Array, and lastPosition meaning the last position in an Array, print to the console the value stored in the following position in the Array: arr[firstPosition][lastPosition]. For example: arr[0][arr[0].length - 1]

Code
Reset
Java
Sample Test Case #1
10
15
Execute code
STDOUT
Expected STDOUT
14
Submit answer
Did you like this question?

imgimg
(Voting helps us personalize your learning experience!)
How many possible elements can the following Array hold?
public class App{
    public static void main(String[] args){
        int[][] arrX2 = new int[10][10];
    }
}
Multiple-choice options (select one)

A.
20

B.
none - this code won't work

C.
10

D.
100
