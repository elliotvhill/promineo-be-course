# Week 9 Curriculum

Notes from the week 9 MySQL video lessons.

## Overview

### Goals:

-   Create an application that demonstrates how to perform Create, Read, Update, and Delete operations on a database
-   Learn about transactions
-   Learn how to use Java Database Connectivity (JDBC) API
-   Learn about indexes, table joins, functions, and more

### Recap:

-   Connected to a database using Java Database Connectivity (JDBC) API
-   Learned about MySQL data types
-   Looked at Relational Database Management System (RDBC) relationships
-   Diagrammed our schema
-   Discovered indexes
-   Created tables with all indexes

### This week:

#### Transactions

-   Transactions group SQL statements into **atomic** groups:
    -   Either the _whole group_ succeeds...
    -   ...or the _whole group_ fails _(i.e. there are no partial transactions)_
-   Transactions are **ACID**:
    -   **A**tomicity
    -   **C**onsistency
    -   **I**solation
    -   **D**urability

#### Java Database Connectivity (JDBC) API

-   How to properly **code** with JDBC
-   The elements of JDBC:
    -   `Connection`s
    -   `Statement`s
    -   `ResultSet`s
-   How to **structure** a JDBC method: try-with-resource statement

#### Robust Menu Applicatioin

-   Write a robust menu application with proper **error** handling
-   Obtaining user input using a **scanner**

#### Inserting Data

-   CRUD
    -   **C**reate
    -   **R**ead
    -   **U**pdate
    -   **D**elete
-   The `INSERT INTO` statement
-   SQL **Injection**:
    -   What it is
    -   How to prevent it

#### Project: Add a Recipe

-   Create the Java entity objects
-   Learn the ins and outs of `INSERT`ing data
-   Use `PreparedStatement` objects
-   How to set parameters
-   How to obtain the primary key on the inserted record

## Transactions and JDBC

### What is a transaction?

A **transaction** contains one or more SQL statements. _All_ the statements **succeed**, or _all_ the statements **fail**. When all the SQL statements succeed, the transaction is **committed**. When an SQL statement fails, the transaction is **rolled back**.

### Transactions are ACID

-   **A**tomicity
-   **C**onsistency
-   **I**solation
-   **D**urability

#### Atomicity:

-   The **transaction** either _all_ succeeds, or it _all_ fails.
-   There are **no partial transactions** — _except for tables_

#### Consistency:

-   All data is **consistent** all the time
-   Data is always **valid** based on any rules created and applied in the schema
    -   Constraints
    -   Cascades
    -   Triggers

#### Isolation:

-   No transaction is **effected** by any other transaction — transactions are **isolated**

#### Durability:

-   Once a transaction is committed and the database sasys it succeeded (i.e. the transaction is **confirmed**, the application is notified), it is **permanently** in the system.
-   Data doesn't get **lost**.
-   Data is present **even if a system crash** occurs immediately after a transaction is confirmed.

### More on Transactions

MySQL puts **every** statement into a **transaction**, whether you want it to or not. By controlling your own transactions, you can have **multiple statements** within the same transaction.

-   Multiple queries, inserts, and deletes can be done in a **consistent** manner, even if the same rows are being changed at the same time.

-   The default **isolation** level protects your transactions against changes made by others.

### Start a Transaction

-   Send `START TRANSACTION` to MySQL, _OR_...
-   ...There is a method on the connection object for this: `setAutoCommit`
-   Every statement on the transaction **must** be made over the **same connection**.

```java
Connection conn =
    DbConnection.getConnection();
conn.setAutoCommit(false);
```

### Commit a Transaction

-   Send `COMMIT` to MySQL, _OR_...
-   ...There is a method on the connection object for this: `commit`

```java
startTransaction(conn);

try {
    // Do some stuff
    conn.commit();
} catch (Exception e) {
    // Do somethings
};
```

### Roll Back a Transaction

-   Send `ROLLBACK` to MySQL, _OR_...
-   ...There is a method on the connection object for this: `rollback`

```java
startTransaction(conn);

try {
    // Do some stuff - thrown Exception
    commitTransaction(conn);
} catch (Exception e) {
    conn.rollback();
};
```

### The parts of JDBC

-   `Connection`:
    -   Loads the driver
    -   Establishes a TCP connection with MySQL
-   `Statement`:
    -   Queries or updates MySQL with SQL instructions
    -   Translates from SQL to MySQL "dialect"
-   `ResultSet`:
    -   Contains results of a query
    -   Only used in queries

### The Challenge

-   After obtaining a resource, it **MUST** be **closed** in a `finally` block.
-   The `close()` method call must also be **wrapped in a `try/catch` block**.
-   Resources are: `Connection`s, `Statement`s, `ResultSet`s
-   If resources are _not closed_, they will be **leaked** and the application will eventually crash.

#### JDBC pre-Java 1.7:

```java
Connection conn - null;

try {
    conn = getConnection();
}
catch (SQLException e) {
    throw new RuntimeException(e);
}
finally {
    if (conn != null) {
        try {
            conn.close(); // must be wrapped in own try/catch block because can also throw an exception
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
```

-   Code that closes `Connection`s must be _duplicated_ for `Statement`s and `ResultSet`s.
-   This leads to a lot of **intricate code**:
    -   Easy to leave something out
    -   Hard to make changes
    -   Very large methods
-   If you don't do it right, you will make a mistake and **leak resources**.
-   It's **easy** to make a mistake!

#### Java 1.7 helped...

Java 1.7 introduced **try-with-resource**. This **automatically** closes objects that implement the `Closeable` interface — `Connection`s, `Statement`s, and `ResultSet`s.

#### Try-with-resource

The resource is **initialized** within parentheses _after_ the `try` keyword and _before_ the `try` body. There is no need to write a `finally` block — the compiler adds the `finally` block and **closes** the resource.

```java
try (Connection conn = getConnection()) {
    // `try` body
}
```

**Still need to handle exceptions**:

```java
try (Connection conn = getConnection()) {
    // `try` body
}
catch (SQLException e) {
    // Handle the exception
}
```

#### The code now looks like this — _much_ better:

```java
try (Connection conn = getConnection()) {
    startTransaction(conn);

    try (Statement stmt = conn.createStatement()) {
        try (ResultSet rs = stmt.executeQuery(sql)) {
            // Gather results
            commitTransaction(conn);
        }
    }
    catch (Exception e) {
        rollbackTransaction(conn);
        throw new RuntimeException(e);
    }
}
catch (SQLException e) {
    throw new RuntimeException(e);
}
```

## Create the Tables

### The approach:

1. Read the contents of a file (`recipe_schema.sql`) into a Java String
2. Remove comments from the file content
3. Replace all whitespace sequences with single spaces
4. Convert the SQL statement lines to a list
5. Add all lines to a SQL Statement object to be executed as a batch

#### A caveat — We will need to add some Java files to the project:

| File              | Purpose                                      |
| ----------------- | -------------------------------------------- |
| `DaoBase.java`    | Provides common code used in the `DAO` class |
| `EntityBase.java` | Provides common code used in entity classes  |

_**Note:** For the homework you will just need `DaoBase.java`._

## Create Menu Applications

### The approach:

1. In the class with the `main` method, create a method to print the available operations (i.e. the menu)
2. Write the user input methods using `Scanner`
3. Add a loop with the `exitMenu` and `createTables` method calls
4. Call the service method to create the tables

## Inserting Data and SQL Injection — Practicing safe data

### Inserting Data

-   Data is inserted a row at a time using `INSERT INTO`

    **Syntax:**

    ```sql
    INSERT INTO table_name
    (col1, col2, col3)
    VALUES (val1, val2, val3);
    ```

#### SQL Operations: CRUD

| Operation  | SQL Keyword           |
| ---------- | --------------------- |
| **C**reate | `INSERT INTO <table>` |
| **R**ead   | `SELECT`              |
| **U**pdate | `UPDATE`              |
| **D**elete | `DELETE`              |

-   You don't want or need to specify a **primary key** column name or value — _MySQL does that automatically_ — if the column is marked as `AUTO_INCREMENT`.

-   The column names and values _must_ **match** exactly.

    ```sql
    -- Using the `recipes` database example:
    INSERT INTO unit
    (unit_name_singular, unit_name_plural)
    VALUES ('teaspoon', 'teaspoons');
    ```

#### Inserting null values

-   Null values are inserted using the `null` keyword, or simply by leaving the column out
-   **Note:** the column must **allow nulls** for this to work

    ```sql
    INSERT INTO ingredient
    (recipe_id, unit_id, ingredient_name, instruction, ingredient_order, amount)
    VALUES (2, null, 'green apple', 'cut in quarters', 1, 1);
    ```

#### Foreign key values

-   While MySQL will increment primary key values automatically, you need to insert all **foreign key** values because they are _not_ generated automatically.

    ```sql
    INSERT INTO recipe_category
    (recipe_id, category_id)
    VALUES (1, 4);
    ```

#### Multiple inserts

Multiple rows can be inserted into one statement by **repeating** the values (note: does **not** work in JDBC, including DBeaver):

```sql
INSERT INTO ingredient
(recipe_id, unit_id, ingredient_name, instruction, ingredient_order, amount)
VALUES
(2, null, 'green apple', 'quartered', 1, 1),
(2, 2, 'peanut butter', null, 2, 2),
(2, null, 'strawberries', 'halved', 3, 2),
(2, null, 'sunflower seeds', null, 4, null),
(2, null, 'candy eyes', null, 5, 8);
```

## Preventing SQL Injection Attacks

### SQL Injection

SQL **Injection** works like this:

1. An attacker enters **compromised** data
2. The data is **not** validated
3. The programmer **concatenates** the data into an SQL statement
4. The database **executes** the statement and bad things happen

### An example: list tables

**User input:**

```sql
Enter recipe ID: 2; show tables;
```

**Java code:**

```java
String recipeId = "2; show tables;";
String sql = "SELECT * FROM recipe "
    + "WHERE recipe_id = " + recipeId;
```

**Constructed SQL:**

```sql
SELECT * FROM recipe WHERE recipe_id = 2;
show tables;
```

**MySQL Result:**

```sql
+-----------+----------------+
| recipe_id | recipe_name    |
|         2 | Apple Monsters |
+-----------+----------------+
1 row in set (0.00 sec)

+-------------------+
| Tables_in_recipes |
+-------------------+
| category          |
| ingredient        |
| recipe            |
| recipe_category   |
| step              |
| unit              |
+-------------------+
6 rows in set (0.00 sec)
```

#### Caveat:

-   This attack works in MySQL **CLI**
-   It does **not** work in DBeaver _unless executed as a_ **batch**
-   It most likely won't work in **Java**
    -   JDBC throws an exception if you put **multiple** statements in a single query
    -   You must handle multiple queries **intentioinally** — this is not the norm
    -   Java is still subject to an SQL injection attack if a single table is accessed (like a `user` table)

### How to mitigate

1. **Validate** all input ("`2; show tables;`" does not look like an integer)
2. Never build an SQL command by **concatenating** user input
3. Use typed **parameters** with `PreparedStatement`

### How to use `PreparedStatement`:

```java
String sql = "SELECT * "
    + "FROM recipe "
    + "WHERE recipe_id = ?";

try (PreparedStatement stmt = conn.prepareStatement(sql)) {

    // Set a parameter by passing in parameter number (1-based; '1' in this case) and recipeId (int)
    stmt.setInt(1, recipeId); // if recipeId is not an 'int', will have a problem

    try (ResultSet rs = stmt.executeQuery()) {

    }
}
```

### Bottom line

-   Use `Statement` if there is no user input
-   Use `PreparedStatement` with **parameters** if there _is_ user input
-   **Always** validate user input

## Add a Recipe

### The approach:

1. Add code to perform the bulk import of the recipe data in the DAO class
2. Modify the service method to load `recipe_data.sql`
