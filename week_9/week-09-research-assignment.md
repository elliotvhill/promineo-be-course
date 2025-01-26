# Week 9 Research Assignment

### Instructions

-   Choose at least **two (2)** of the below prompts.
-   Research those prompts.
-   Write at least one paragraph for **two (2)** of the below prompts
-   Include URLs from where you found the information to cite your sources.
-   Submit your **Research Results** to the LMS.

## Prompts

1.  Research different constructs that are available in MySQL when retrieving data.

    &emsp;(a) How is data retrieved from a MySQL database?

    > Data is retrieved from a MySQL database using the `SELECT` statement. <sup>[[4](#source-4)]</sup>

    &emsp;(b) What clauses exist for restricting the data that is returned to the user?

    > Some clauses that are commonly used for restricting or filtering the data returned are the `WHERE` clause, which allows a user to set search conditions; the `LIMIT` clause, which restricts results to a specified number of rows

    &emsp;(c) Include the syntax for this type of request, and give an example.

    > An example query would be something like `SELECT * FROM customer WHERE first_name = "Geralt" LIMIT 5;`

2.  What types of operations can you do in SQL (or specifically MySQL)? List at least **five (5)** different statements that exist in MySQL. Give a brief description of what these do.

3.  What are wildcards in MySQL? How are they useful? Give an example of a MySQL statement that could use wildcards.

    > **Wildcards** are used as placeholders that can substitute characters in a string. <sup>[[1](#source-1)]</sup> They are used with the `LIKE` keyword and are used to search for specific patterns within strings.
    >
    > For example, to search a `customer` table for `first_name`s that begin with `A`, you might query: `SELECT * FROM customer WHERE first_name LIKE 'A%';`

4.  Define JDBC. What is JDBC? Describe it in your own words. How is it used?

    > **JDBC** stands for **Java Database Connectivity** and is an API that allows applications to connect to databases and execute queries. <sup>[[2](#source-2)][[3](#source-3)]</sup>
    >
    > It is used in Java programs to run queries and perform CRUD operations on many kinds of databases, including MySQL, Postgres, and more.

5.  List 3-5 interesting facts that you have learned about MySQL from your research?

### Resources Consulted

<a id="source-1"></a>1. [MySQL Wildcards | w3schools](https://www.w3schools.com/mysql/mysql_wildcards.asp)  
<a id="source-2"></a>2. [Java Database Connectivity | Wikipedia](https://en.wikipedia.org/wiki/Java_Database_Connectivity)  
<a id="source-3"></a>3. [Java JDBC API | JavaDocs](https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc/)  
<a id="source-4"></a>4. [5.3.4 Retrieving Information from a Table | MySQL Documentation](https://dev.mysql.com/doc/refman/8.0/en/retrieving-data.html)

<!-- <a id="source-5"></a>5. -->
