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
