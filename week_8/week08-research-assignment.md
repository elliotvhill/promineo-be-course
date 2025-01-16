# Week 8 Research Assignment

### Instructions

-   Choose at least **two (2)** of the below prompts.
-   Research those prompts.
-   Write at least one paragraph for **two (2)** of the below prompts
-   Include URLs from where you found the information to cite your sources.
-   Submit your **Research Results** to the LMS.

## Prompts

1. Describe each of the ten (10) MySQL data types.

    &emsp;a. How is each data type used?

    &emsp;b. What makes each unique?

    -   **`INT`s** — used for whole numbers, can specify a size _(e.g._ `TINYINT`_,_ `SMALLINT`_, etc.)_ <sup>[[1](#source-1)]</sup>

    -   **`DECIMAL`** — stores numbers with decimal places, must specify the _precision_ (i.e. number of digits including decimal digits) and _scale_ (i.e. number of digits to the right of the decimal)

    -   **Date/Time** — useful for storing dates, times, and timestamping (e.g. `TIMESTAMP` type), storing date and time values

    -   **Characters** — `CHAR` and `VARCHAR(<size>)` — used to store characters and strings; `varchar`s are unique because you must specify the maximum size of the string to store _(e.g. 40 characters, etc.)_

    -   **Text** — used to store larger amounts of text; unique because can also specify a size _(e.g._ `SMALLTEXT`_,_ `MEDIUMTEXT`_, etc.)_

    -   **Boolean** — used to store boolean values; can be either `true`/`false` or numeric (`0`/`1`)

    -   **Enumerated (Enum)** — used when records need to be limited to a discrete set of predefined values; for example, an enum `status` might only accept the values `active` and `inactive`

2. Research primary & foreign keys in RDBMSs? What are they? Why are they useful?

3. Define DDL and DML. What do the acronyms mean? Describe each one. Give examples.

    > **DDL** stands for **Data Definition Language**. DDL refers to the actual SQL commands for creating, changing, and deleting database structures like tables and schemas _(e.g._ `CREATE`_,_ `DROP`_,_ `ALTER`_, etc.)_. <sup>[[2](#source-2)]</sup>
    > 
    > **DML** stands for **Data Manipulation Language**. DML includes the commands for manipulating data — inserting, updating, deleting, etc.

4. What are `INDEX`es in MySQL? Why are they important? What benefit do they provide?

    > Indexes

5. What is a `VIEW` in an RDBMS. What is a view? Why is it useful?

6. What is a `JOIN` when talking about databases?

### Resources Consulted

<a id="source-1"></a> 1. [MySQL Data Types | w3schools](https://www.w3schools.com/mysql/mysql_datatypes.asp)  
<a id="source-2"></a>2. [SQL Commands | DDL, DQL, DML, DCL and TCL Commands](https://www.geeksforgeeks.org/sql-ddl-dql-dml-dcl-tcl-commands/)  

<!-- <a id="source-3"></a>3.  -->
<!-- <a id="source-3"></a>3.  -->
