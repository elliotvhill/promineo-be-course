# Week 8 - MySQL Part 3

Coding and mastery questions from MySQL lesson part 3.

## Vocabulary Reminder

-   **Database:** A structured collection of data stored and organized for efficient retrieval and manipulation.

-   **Schema:** A blueprint or structure that defines the logical organization and relationships of database objects, such as tables, views, and constraints.

-   **DBMS (Database Management System):** Software that manages the storage, retrieval, and manipulation of data in a database.

-   **RDBMS (Relational Database Management System):** An RDBMS organizes data based on the relational model, consisting of tables with rows and columns.

-   **SQL (Structured Query Language):** is a language that is used by an **RDBMS** to interact with and manage relational data. SQL is a Standardized Language.

-   **Query:** A request for data retrieval or manipulation from a database using a structured query language (SQL).

-   **Primary Key:** A unique identifier for each record (row) in a table, used to ensure data integrity and facilitate record retrieval.

-   **Foreign Key:** A field in one table that refers to the primary key of another table, establishing a relationship between the two tables.

-   **Table:** A collection of related data organized in rows and columns in a relational database.

-   **Entity:** A distinct object or concept in the real world that is represented in a database table.

-   **Index:** A data structure that improves the speed of data retrieval operations by enabling efficient searching and sorting.

-   **Attribute:** A characteristic or property of an entity that is stored as a column in a database table.

-   **Transaction:** A logical unit of work that consists of one or more database operations, which must be performed atomically and consistently.

-   **Normalization:** The process of organizing data in a database to eliminate redundancy and dependency issues.

-   **ACID (Atomicity, Consistency, Isolation, Durability):** A set of properties that ensure reliability and consistency in database transactions.

-   **Data Integrity:** The accuracy, consistency, and reliability of data stored in a database.

-   **Query Optimization:** The process of selecting the most efficient execution plan for a database query to improve performance.

-   **Data Warehousing:** The process of collecting, organizing, and storing large volumes of data from various sources for analysis and reporting.

-   **Data Mining:** The process of discovering patterns, relationships, and insights from large datasets using statistical and machine learning techniques.

-   **Backup and Recovery:** The process of creating backups of database data and implementing strategies to restore data in case of system failures or data loss.

-   **CRUD (Create, Read, Update, and Delete):** The Operations that can be performed on a **DBMS** or **RDBMS**.

## CRUD Operations in SQL

When we look at the **CRUD** operations on the data in the database, **CRUD** operations are all **DML** statements, as follows:

-   **Create:** SQL `INSERT` statement
-   **Read:** SQL `SELECT` statement
-   **Update:** SQL `UPDATE` statement
-   **Delete:** SQL `DELETE` statement

## SQL Syntax

### `INSERT`:

```sql
INSERT [INTO] tbl_name
        [ (col_name [, col_name] ...)]
        {  VALUES (value_list) [, value_list) ] ... };
value:
        { expr | DEFAULT}
value_list:
        value [, value] ...
assignment:
        col_name =
                    value
                | [row_alias.]col_name
                | [tbl_name.]col_name
                | [row_alias.]col_alias
assignment_list:
        assignment [, assignment] ...
```

### `SELECT`:

```sql
SELECT select_exp [, select_exp] ...
    [FROM table_references]
    [JOIN table_references { ON (col_name) | USING (col_name = col_name) } ]
    [WHERE where_condition]
    [GROUP BY {col_name | expression | positioin}, ...]
    [ORDER BY {col_name | expressions | position}
        [ASC | DESC], ... ]
    [LIMIT row_count];
```

### `UPDATE`:

```sql
UPDATE table_reference
    SET assignment_list
            [WHERE where_condition]
            [ORDER BY ...]
            [LIMIT row_count];
    value:
        { expression | DEFAULT }
    assignment:
        col_name = value
    assignment_list:
        assignment [, assignment] ...
```

### `DELETE`:

```sql
DELETE FROM table_name
    [WHERE where_condition]
    [ORDER BY ...]
    [LIMIT row_count];
```

#### References:

-   [MySQL DELETE Statement](https://dev.mysql.com/doc/refman/8.0/en/delete.html)
-   [MySQL INSERT Statement](https://dev.mysql.com/doc/refman/8.0/en/insert.html)
-   [MySQL SELECT Statement](https://dev.mysql.com/doc/refman/8.0/en/select.html)
-   [MySQL UPDATE Statement](https://dev.mysql.com/doc/refman/8.0/en/update.html)

## Sakila Database

For all of our SQL lessons, we are going to use the **Sakila** Database. Each `id` column which is named _`tableName_id`_ is a `PRIMARY KEY` in that table. Notice that some of those columns are used in subsequent tables as well; in those tables, that first _`tableName_id`_ would be stored as a `FOREIGN KEY` in the subsequent table.

The **_Table_** and **_Column Names_** in this database are these:

| Table Name    | Column Names                                                                                                                                                                                                                        |
| ------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| actor         | actor_id, first_name, last_name last_update                                                                                                                                                                                         |
| address       | address_id, address, address2, district, city_id **(FK)**, postal_code, <br /> &emsp;&emsp;phone, location, last_update                                                                                                             |
| category      | category_id, name, last_update                                                                                                                                                                                                      |
| city          | city_id, city, country_id **(FK)**, last_update                                                                                                                                                                                     |
| country       | country_id, country, last_update                                                                                                                                                                                                    |
| customer      | customer_id, store_id **(FK)**, first_name, last_name, email, address_id **(FK)**, <br /> &emsp;&emsp;active, create_date, last_update                                                                                              |
| film          | film_id, title, description, release_year, language_id **(FK)**, original_language_id **(FK)**, <br /> &emsp;&emsp;rental_duration, rental_rate, length, replacement_cost, rating, special_features, <br /> &emsp;&emsp;last_update |
| film_actor    | actor_id **(FK)**, film_id **(FK)**, last_update                                                                                                                                                                                    |
| film_category | film_id **(FK)**, category_id **(FK)**, last_update                                                                                                                                                                                 |
| film_text     | film_id **(FK)**, title, description                                                                                                                                                                                                |
| inventory     | inventory_id, film_id, store_id **(FK)**, last_update                                                                                                                                                                               |
| language      | language_id, name, last_update                                                                                                                                                                                                      |
| payment       | payment_id, customer_id **(FK)**, staff_id **(FK)**, rental_id **(FK)**, <br /> &emsp;&emsp;amount, payment_date, last_update                                                                                                       |
| rental        | rental_id, rental_date, inventory_id **(FK)**, customer_id **(FK)**, return_date, <br /> &emsp;&emsp;staff_id **(FK)**, last_update                                                                                                 |
| staff         | staff_id, first_name, last_name, address_id **(FK)**, picture, email, store_id **(FK)**, <br /> &emsp;&emsp;active, username, password, last_update                                                                                 |
| store         | store_id, manager_staff_id **(FK)**, address_id **(FK)**, last_update                                                                                                                                                               |

#### Reference: [Sakila Database](https://dev.mysql.com/doc/sakila/en/)

### 21. `SELECT` Statement — `JOIN` two tables, `payment` and `customer` — *Use column aliases*

Retrieve the `customer_id`, the customer's first and last names, and the average of the `amount` paid for a rental in the `payment` table per customer, rounded to two (`2`) decimal places. Limit your results to the first 5 rows. Use the following column aliases in your query:

-   `customer_id` --> "Id"
-   `first_name` --> "First Name"
-   `last_name` --> "Last Name"
-   `rounded average` --> "Average Spent"

Remember, when using an aggregate function, a `GROUP BY` clause may be important.

**Expected Output:**

| Id  | First Name | Last Name | Average Spent |
| :-: | :--------: | :-------: | :-----------: |
|  1  |    MARY    |   SMITH   |     3.71      |
|  2  |  PATRICIA  |  JOHNSON  |     4.77      |
|  3  |   LINDA    | WILLIAMS  |     5.21      |
|  4  |  BARBARA   |   JONES   |     3.72      |
|  5  | ELIZABETH  |   BROWN   |     3.81      |

<details><summary><em>My Solution:</em></summary>

```sql

```

</details>

<details><summary><em>Instructor Solution:</em></summary>

```sql
```

</details>


### `CREATE TABLE` Syntax

When creating a database, this statement will allow a change to be made to the structure of the database or schema. This is a **Data Definition Language (DDL)** statement.

```sql
CREATE [TEMPORARY] TABLE [IF NOT EXISTS] table_name
    (create_definition, ...)
    [table_options]
    [partition_options]

create_definition: {
    col_name column_definition
    | {INDEX | KEY} [index_name] [index_type] (key_part, ...)
        [index_option] ...
    | {FULLTEXT | SPATIAL} [INDEX | KEY] [index_name] (key_part, ...)
        [index_option] ...
    | [CONSTRAINT [symbol]] PRIMARY KEY
        [index_type] (key_part, ...)
        [index_option] ...
    | [CONSTRAINT [symbol]] UNIQUE [INDEX | KEY]
        [index_type] [index_type] (key_part, ...)
        [index_option] ...
    | [CONSTRAINT [symbol]] FOREIGN KEY
        [index_name] (col_name, ...)
        reference_definition
    | check_constraint_definition
    }

    column_definition: {
        data_type [NOT NULL | NULL] [DEFAULT {literal | (expression)} ]
            [AUTO_INCREMENT] [UNIQUE [KEY]] [[PRIMARY] KEY]
            [reference_definition]
        | data_type
            [VIRTUAL | STORED] [NOT NULL | NULL]
            [UNIQUE [KEY]] [[PRIMARY] KEY]
            [reference_definition]
    }
```

### `CREATE TABLE employee` Example:

```sql
CREATE TABLE employee (
    employee_id SMALLINT unsigned NOT NULL,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    address_id SMALLINT unsigned NOT NULL,
    email VARCHAR(50) DEFAULT NULL,
    store_id TINYINT unsigned NOT NULL,
    employee_level TEXT CHECK( employee_level IN ('FAIR', 'GOOD', 'GREAT', 'EXCELLENT') ) ,
    title VARCHAR(25) DEFAULT NULL,
    PRIMARY KEY (employee_id),
    FOREIGN KEY (address_id) REFERENCES address (address_id),
    FOREIGN KEY (store_id) REFERENCES store (store_id)
);
```

#### References:
- [MySQL CREATE TABLE Documentation](https://dev.mysql.com/doc/refman/8.0/en/create-table.html)
- [MySQL Data Types Documentation](https://dev.mysql.com/doc/refman/8.0/en/data-types.html)

<!-- ---

<details><summary><em>My Solution:</em></summary>

```sql
```

</details>

<details><summary><em>Instructor Solution:</em></summary>

```sql
```

</details> -->
