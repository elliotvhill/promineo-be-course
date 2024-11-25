# Week 4 Research Assignment

## Purpose

* This Research Assignment is meant to go beyond the course curriculum and increase your understanding of relevant topics while exposing you to online resources you'll frequently use on the job. 
* As developers, research is a constant part of our job. 
* A common saying is that 90% of software development is "Googling".  While that is an exaggeration, search engines are highly utilized tools in the software development role.   
* The Java Documentation is a great place to start, and there are so many other great resources!


## Instructions

* Choose at least two (2) of the 5 numbered prompts below.
* Research those prompts.
* Write at least one paragraph for two (2) of the prompts below
* Include URLs from where you found the information to cite your sources. 
* Submit your Research Results to the LMS.

## Prompts

### Strings

1. Select five (5) methods from the [**String Java Documentation**](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html) and describe the following for each: 

    (a) What is the method signature for each method?

    (b) What does each method do? 

    (c) Why would this method be useful (how could you use it)?  Give an example.

    ```java
    String string.compareToIgnoreCase(String str);
    // Compares two strings lexicographically (i.e. alphaetizing), ignoring case
    // Could be used in a sorting algorithm

    String string.format(String formatString, Object arguments);
    // Returns a string formatted according to arguments that are passed
    // The format String represents how the arguments should be processed and inserted into text
    // Syntax: %[argument_index$][flags][width][.precision]conversion
    // Use case: formatting a date string
    // e.g. Calendar c = ...;
    //      String s = String.format("Birthday: %1$tm %1$te $1$tY", );

    String string.matches(String regex);
    // Takes a regular expression as an argument and compares the String to it
    // Use case: validating user input, search

    String string.split(String regex);
    // Splits a string according to matches to a regular expression
    // Use case: parsing strings into separate variables

    String string.strip();
    // Removes all leading and trailing whitespace from a string
    // Use case: cleaning data
    ```


### Arrays

2. Select five (5)  methods from the [**Array Java Documentation**](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/reflect/Array.html) and describe the following for each: 

    (a) What is the method signature for each method?

    (b) What does each method do? 

    (c) Why would this method be useful (how could you use it)? Give an example.

    ```java
    getLength();
    // Gets the length of an array
    // Use case: check a user's password for a minimum length

    getDouble(Object arr, int index);
    // Returns the indexed value as a double (instead of a raw Object)
    // Use case: type specificity, return actual doubles for calculations

    setBoolean(Object arr, int index, boolean bool)
    // Sets the indexed element to the given boolean value
    // Use case: updating boolean values for use in conditional statements

    getInt(Object arr, int index);
    // Returns the indexed value as an integer (instead of a raw Object)
    // Use case: type specificity, use with arrays of ints, return actual ints for use in calculations
    ```

### Collections 

Resource: [**Java Tutorials on Interfaces**](https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html)

3. What are the differences between Lists, Sets, and Maps in Java?

    > Lists are ordered, mutable, and allow duplicates.
    >
    > Sets are unordered and do not allow duplicates (including null values)
    >
    > Maps are key-value pairs; keys must be unique

4. List at least two different implementations for each collection (List, Set, and Map). When would you use one of the implementations over the other?

    * List: 
        * Would use when preserving order is important, like customers in a queue, for example
        * Could also use for a classroom roster

    * Set: 
        * Would use when working with data that cannot contain duplicates, like SSNs, for example
        * Could also use for a list of unique usernames

    * Map: 
        * Could use for recording inventory, e.g. product-count KV pairs
        * Could also use for storing students and their grades

5. Write Java code that does the following:

    (a) Write a line of code that shows how you would instantiate an ArrayList of String.

    ```java
    List<String> list = new ArrayList<String>();
    ```

    (b) Write a line of code that shows how you would instantiate a HashSet of StringBuilder.

    ```java
    Set<StringBuilder> set = new HashSet<StringBuilder>();
    ```

    (c) Write a line of code that shows how you would instantiate a HashMap of String, String.

    ```java
    Map<String, String> map = new HashMap<String, String>();
    ```

    #### Resources consulted: 

    * [Class String | Java Docs](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html#method-summary)
    * [Class Array | Java Docs](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/reflect/Array.html#getInt(java.lang.Object,int))
    * [Array `getInt()` Method in Java](https://www.geeksforgeeks.org/array-getint-method-in-java/)
    * [Interface Map<K,V>](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Map.html)
    