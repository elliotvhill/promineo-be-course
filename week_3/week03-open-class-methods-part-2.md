# Java 3 - Methods Part 2

This lesson contains Questions 11-20 (Part 2) of the OpenClass Methods Lesson, and contains five (5) coding questions, each followed by a mastery question.

## 1. `createArray` Method

Complete the method that accepts five integer values stored in the variables a, b, c, d, e.
In the method, you will create an Array of int that stores the value of the five parameters
Here is a reminder of a two ways to declare an array:
   int[] arrayName = new int[10];   // An Array of int called arrayName that is of size 10
   int[] arrayName2 = {value1, value2}; // An Array of int called arrayName2 which contains 2 items
The method should return the Array
Code
Reset
Java
Sample Test Case #1
5
4
3
2
1
Execute code
STDOUT
Expected STDOUT
The third number in your array is: 3
Submit answer
Did you like this question?

imgimg
(Voting helps us personalize your learning experience!)
When calling howManyVars() which are the correct arguments to pass in?
public class Main {
    public static void main(String[] args) {
        System.out.println(howManyVars());
    }
    static void howManyVars(int a, String b, double c, int d, boolean e, char f){
    }
} 
Multiple-choice options (select one)

A.
143, "I am a String", 9.99, 403, true, 'N'

B.
2, "Name", 4, 11, true, 9, 'Y'

C.
"Hi", 5, 8, 43.33, 'X', false

Submit answer
Did you like this question?

imgimg
(Voting helps us personalize your learning experience!)
sumOfDigits Method

Complete the method called sumOfDigits that takes an integer variable called digits. Then return the sum of all the digits in digits. For example, 245 would be 2 + 4 + 5 = 11.
Code
Reset
Java
Sample Test Case #1
12
Execute code
STDOUT
Expected STDOUT
The sum of all digits for the value 12 is 3.
Submit answer
Did you like this question?

imgimg
(Voting helps us personalize your learning experience!)
What will be the value of the variable addItUp after the following code runs?
public static void main(String[] args) {
        int addItUp = followTheMath(10, 5, 8, 11);
    }
    static int followTheMath(int num1, int num2, int num3, int num4){
        int total = 0;
        if (num1 < num4){
            total += num2;
        }
        if (num2 == num3){
            total += num4;
        } else {
            total += num1;
        }
        total += num3;
        return num3;
    }
Multiple-choice options (select one)

A.
24

B.
8

C.
23

D.
15

Submit answer
Did you like this question?

imgimg
(Voting helps us personalize your learning experience!)
passwordChecker Method

Complete the method called passwordChecker that accepts the String stored in variable password.
The method should check to make sure that password is at least 8 characters in length and contains one of 4 special symbols, !, $, %, or &
The method should return true or false.
Code
Reset
Java
Sample Test Case #1
password%
Execute code
STDOUT
Expected STDOUT
password% meets the requirements.
Submit answer
Did you like this question?

imgimg
(Voting helps us personalize your learning experience!)
What will the value be for the variable iCanRetire after the code runs?
public static void main(String[] args) {
    String iCanRetire = readyForTheBeach(64);
    System.out.println(iCanRetire);
}
static String readyForTheBeach(int age){
    if (age < 30){
        return "Only if you built Facebook or Google";
    }
    if (age < 50){
        return "Perhaps if you lived a frugal life and worked a couple of jobs at a time.";
    }
    if (age < 65){
        return "You are getting closer...";
    } else {
        return "You can call it quits!";
    }
}
Multiple-choice options (select one)

A.
You are getting closer…

B.
Only if you built Facebook or Google!

C.
You can call it quits!

D.
Perhaps if you lived a frugal life and worked a couple of jobs at a time.

Submit answer
Did you like this question?

imgimg
(Voting helps us personalize your learning experience!)
avgNameLength Method

Given a method call avgNameLength that takes in an Array of String stored in names, write a program that will traverse the Array.
The names Array will hold 5 names that are entered by the user
Here is a reminder of how to access an element in an array:
    // if arrayName is an Array of String
    arrayName[index] // This will access the String located in arrayName at index
    arrayName[0] // This will access the first String in arrayName -- remember that Arrays are zero-indexed
    arrayName[0].length() // This will give the length of the String stored in location zero (0)
The method avgNameLength will traverse the Array and find the average length of all the names that are part of names
Return the average length of all the names
Code
Reset
Java
Sample Test Case #1
Jose
James
Roberto
Theodore
Fred
Execute code
STDOUT
Expected STDOUT
The average name length is 5.
Submit answer
Did you like this question?

imgimg
(Voting helps us personalize your learning experience!)
Are return statements required for all methods?
Multiple-choice options (select one)

A.
Yes

B.
No

Submit answer
Did you like this question?

imgimg
(Voting helps us personalize your learning experience!)
rectanglePerimeter Method

Inside of the public class, write a static method called rectanglePerimeter :
The method should accept two int variables named length and width
In the body of the method write a program that will calculate the perimeter of the rectangle
The method should return an integer value representing the perimeter of the rectangle
Note: Don't forget to include the opening and closing curly braces for the method
Code
Reset
Java
Sample Test Case #1
4
4
Execute code
STDOUT
Expected STDOUT
The rectangle has a perimeter of 16.
Submit answer
Did you like this question?

imgimg
(Voting helps us personalize your learning experience!)
Which variable should be returned for the method to be correct?
public class Main {
    public static void main(String[] args) {
        System.out.println(whatsReturned(9, "Hi, There", false, 4.99, 'T'));
    }
    static boolean whatsReturned(int num1, String words, boolean TF, double price, char letter){
        return;
    }
} 
Multiple-choice options (select one)

A.
price

B.
letter

C.
num1

D.
TF

E.
words
