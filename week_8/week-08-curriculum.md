# Week 8 Curriculum

Notes from the week 8 MySQL video lessons.

## Week 7 Review

-   Difference between a database and a database client
-   Using Maven to manage dependencies
-   3-tier application design
-   The database connection and driver
-   How to connect to a database with JDBC

## Week 8 Overview

#### MySQL data types:

-   Integer
-   Decimal
-   Text
-   Date/time
-   Enum

#### Creating tables:

-   We will look at how to use the `CREATE TABLE` statement to create tables in **DBeaver** using the SQL editor

#### RDBMS Relationships:

-   Do a recap on **Java** relationship types: `has a`, `is a`, `uses a`
-   Look at the difference between **RDBMS** and **NoSQL**
-   Check out the **RDBMS** relationship types
    -   One-to-one
    -   One-to-many
    -   Many-to-many

#### Entity Relationship Diagrams:

-   We will see how to create an **Entity Relationship Diagram** in Draw.io
    -   Entities map to tables and columns
    -   Relationships are lines between entities
-   Relationship **types** are expressed using **Crows' Foot** notation
    -   Expresses **modality** — _e.g. optional or mandatory_
    -   Expresses **cardinality** — _e.g. one or many_

#### All about indexes:

-   **Speed** up reads
-   Enforce **uniqueness**
-   Specify **relationships**
    -   Primary key
    -   Foreign keys
-   Automatically **delete** child rows with `ON DELETE CASCADE`

## MySQL Data Types

### About data types

Just like Java, **MySQL** has different data types. MySQL supports all standard **SQL** data types. Many types come in various **sizes**.

-   Whole number types: `INT`

    -   Unlike Java, `INT`s can be signed or `UNSIGNED`. `INT` is a synonym of `INTEGER`.

        | MySQL Data Type  | Corresponding Java Type | Size in Bits |
        | ---------------- | :---------------------: | :----------: |
        | `TINYINT`        |          byte           |      8       |
        | `SMALLINT`       |          short          |      16      |
        | `MEDIUMINT`      |           --            |      24      |
        | `INT`, `INTEGER` |           int           |      32      |
        | `BIGINT`         |          long           |      64      |

-   Fixed precision type: `DECIMAL`
    -   `DECIMAL`s are defined with precision and scale
    -   **Precision** is the total number of digits stored (including decimal digits)
    -   **Scale** is the number of digits to the right of the decimal point
    -   **Example:** `DECIMAL(5, 2)` stores values from `-999.99` to `999.99`
    -   `DECIMAL` numbers are **exact** and can be used for money
    -   The Java class that corresponds to `DECIMAL` is `BigDecimal` — _not_ double
    -   May have round off issues, but they don't _accumulate_
-   Date and time types:
    -   `DATETIME`: `yyyy-mm-dd hh:mm:ss` format
    -   `TIMESTAMP` is the same as `DATETIME` but `TIMESTAMP` is **converted to UTC** when stored
    -   `DATE` (`yyyy-mm-dd`)
    -   `TIME` (`hh:mm:ss`)
    -   `YEAR` (`yyyy`)
-   Character types:
    -   `CHAR`: **fixed-width** storage (max=255)
    -   `VARCHAR`: **variable-width** storage (like a Java `String`)
-   Text types:

    | Type         | Max Length (characters) |
    | ------------ | ----------------------- |
    | `TINYTEXT`   | 2<sup>8</sup>           |
    | `TEXT`       | 2<sup>16</sup>          |
    | `MEDIUMTEXT` | 2<sup>24</sup>          |
    | `LONGTEXT`   | 2<sup>32</sup>          |

-   Enumerated type:
    -   `ENUM`: a single predefined value
        -   **Example:** `ENUM('one', 'two', 'three')` — the column must contain 'one', 'two', or 'three'
    -   Works well with Java `enum` type
- Boolean type:
    - `BOOLEAN`: value can be set to `TRUE` or `FALSE` _(or_ `1` _or_ `0`_)_
    - `BOOLEAN` is **equivalent** `TINYINT(1)`
        - _Note that the_ `(1)` _is a_ **display width**
        - _It has_ **no effect** _on storage size_

### More on data

When a table is created, columns can be declared `NOT NULL`. This means the row **must have a value** for that column.

Columns can also be declared `NULL`. This means that the row may have **no value** in that column (i.e. the column is **nullable**).

If a column is not declared with `NULL` or `NOT NULL`, the column is **nullable**.

`DEFAULT` supplies a value if the inserted value is `NULL` — often used in `TIMESTAMP` or `DATETIME`.

```sql
TIMESTAMP NOT NULL
    DEFAULT CURRENT_TIMESTAMP
```

<!-- ## Creating Tables -->

<!-- ## Relationships -->

<!-- ## Entity Relationship Diagrams -->

<!-- ## Indexes -->
