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

    - **`INT`s** — used for whole numbers, can specify a size _(e.g._ `TINYINT`_,_ `SMALLINT`_, etc.)_ <sup>[[1](#source-1)]</sup>

    - **`DECIMAL`** — stores numbers with decimal places, must specify the _precision_ (i.e. number of digits including decimal digits) and _scale_ (i.e. number of digits to the right of the decimal)

    - **Date/Time** — useful for storing dates, times, and timestamping (e.g. `TIMESTAMP` type), storing date and time values

    - **Characters** — `CHAR` and `VARCHAR(<size>)` — used to store characters and strings; `varchar`s are unique because you must specify the maximum size of the string to store _(e.g. 40 characters, etc.)_

    - **Text** — used to store larger amounts of text; unique because can also specify a size _(e.g._ `SMALLTEXT`_,_ `MEDIUMTEXT`_, etc.)_

    - **Boolean** — used to store boolean values; can be either `true`/`false` or numeric (`0`/`1`)

    - **Enumerated (Enum)** — used when records need to be limited to a discrete set of predefined values; for example, an enum `status` might only accept the values `active` and `inactive`

    - **Binary** — `BIT` and `BLOB` — `BIT` holds bit values with a specified size value between 1 and 64; `BLOB`s are **B**inary **L**arge **Ob**jects and can hold up to 65,535 bytes of data, whether that be large amounts of text, multimedia files, or other unstructured data. <sup>[[3](#source-3)][[4](#source-4)]</sup>

2. Research primary & foreign keys in RDBMSs? What are they? Why are they useful?

    > **Primary keys** are unique values used to identify records in a table _(e.g. a customer ID)_. They help prevent duplicates and speed up query execution. <sup>[[8](#source-8)]</sup> A table can only have _one_ primary key.
    >
    > **Foreign keys** are simply keys that refer to another table's primary key. They are used for establishing relationships between tables and making sure that the data from both tables aligns correctly. <sup>[[9](#source-9)]</sup> A table can have _multiple_ foreign keys.

3. Define DDL and DML. What do the acronyms mean? Describe each one. Give examples.

    > **DDL** stands for **Data Definition Language**. DDL refers to the actual SQL commands for creating, changing, and deleting database structures like tables and schemas _(e.g._ `CREATE`_,_ `DROP`_,_ `ALTER`_, etc.)_. <sup>[[2](#source-2)]</sup>
    >
    > **DML** stands for **Data Manipulation Language**. DML refers to the SQL commands for manipulating data — `INSERT`, `UPDATE`, `DELETE` etc.

4. What are `INDEX`es in MySQL? Why are they important? What benefit do they provide?

    > **Indexes** help speed up data lookups similar to how a book's index makes finding information faster and easier — MySQL can use an index to locate a piece of data, instead of having to search through the entire table. <sup>[[5](#source-5)]</sup> They are useful for large data sets, columns that are frequently queried, or columns that can have a wide range of values. <sup>[[6](#source-6)]</sup>

5. What is a `VIEW` in an RDBMS. What is a view? Why is it useful?

    > A `VIEW` is is a subset of a database that is used to save frequent queries. Using a view saves time and effort when specific queries are run frequently and/or are complex. <sup>[[7](#source-7)]</sup>

6. What is a `JOIN` when talking about databases?

    > A `JOIN` is a way to combine data from multiple tables using just one query. <sup>[[10](#source-10)]</sup> `JOIN`s increase efficiency by using related columns to retrieve and display information from two or more tables at a time.

### Resources Consulted

<a id="source-1"></a> 1. [MySQL Data Types | w3schools](https://www.w3schools.com/mysql/mysql_datatypes.asp)  
<a id="source-2"></a>2. [SQL Commands | DDL, DQL, DML, DCL and TCL Commands | Geeks for Geeks](https://www.geeksforgeeks.org/sql-ddl-dql-dml-dcl-tcl-commands/)  
<a id="source-3"></a>3. [Binary Large Object \(BLOB\) | Gartner](<https://www.gartner.com/en/information-technology/glossary/blob-binary-large-object#:~:text=Large%20Object%20(BLOB)-,Binary%20Large%20Object%20(BLOB),-Binary%20large%20object>)  
<a id="source-4"></a>4. [What is a BLOB (Binary Large Object)? Can it be Tokenized? | Cloud Security Alliance](https://cloudsecurityalliance.org/blog/2022/05/04/what-is-a-blob-binary-large-object-can-it-be-tokenized)  
<a id="source-5"></a>5. [MySQL Indexes | Geeks for Geeks](https://www.geeksforgeeks.org/mysql-indexes/)  
<a id="source-6"></a>6. [SQL Indexes | Geeks for Geeks](https://www.geeksforgeeks.org/sql-indexes/)  
<a id="source-7"></a>7. [Database views | IBM](https://www.ibm.com/docs/en/cdfsp/7.6.1.2?topic=structure-views)  
<a id="source-8"></a>8. [MySQL Primary Key | Geeks for Geeks](https://www.geeksforgeeks.org/mysql-primary-key/)  
<a id="source-9"></a>9. [MySQL FOREIGN KEY Constraint | Geeks for Geeks](https://www.geeksforgeeks.org/mysql-foreign-key-constraint/)  
<a id="source-10"></a>10. [MySQL JOIN | Geeks for Geeks](https://www.geeksforgeeks.org/mysql-join-1/)
