# Week 7 - MySQL Part 2

Coding and mastery questions from MySQL lesson part 2.

It is now time to use the SQL SELECT statement. This lesson is a little different than the previous lessons. Each question will ask you to use one SQL statement. There are 20 SQL Coding Questions, all using the Sakila database. Refer back to the information shared to assist you in this lesson.

**_REVIEW: IMPORTANT INFORMATION_**

_In these OpenClass SQL assignments, the order of the columns and tables matters. The reason we mention this, is that OpenClass compares results **exactly**. Any of the following could cause your Coding Question to **fail**:_

-   Columns retrieved in the wrong order — The data may be the same, but the result will not match.
-   Joining tables in opposite order, depending on the retrieved columns — The data may be the same, but the result will not match.
-   Using `count(*)` instead of `COUNT(*)` — The same as far as SQL knows, BUT the result will not match because the column name does not match.
-   Using `ROUND(AVG(amount), 2)` instead of `ROUND(AVG(amount),2)` — Notice the space ("` `" ) between the comma and the `2`.

**_The Convention Used in the following Coding Questions_**

-   All SQL keywords in the following examples are CAPITALIZED.
-   All database names and columns are lowercase.
-   No spaces will added unless requested in the question.
-   The order of tables in a query, or with a `JOIN` will be the order of mention in the question.
-   The order of columns retrieved will also be the order of mention in the question.

## Questions

### 11. `SELECT` Statement – city & country using `COUNT(*)`

Retrieve the count of the rows of the `city` table and the `country` table only counting the city names that start with "Ab". Use the `JOIN` keyword, and join on the key column in common between the two tables.

#### Expected STDOUT:

```sql
COUNT(*)
2
```

<details><summary><strong>Solution:</strong></summary>

```sql
-- My solution:
SELECT COUNT(*) FROM city JOIN country USING (country_id) WHERE city LIKE 'Ab%';

-- Instructor solution:
SELECT COUNT(*) FROM city
JOIN country USING (country_id)
WHERE city LIKE 'Ab%';
```

</details>

### 12. `SELECT` Statement – city & country using `COUNT(*)` and a column alias

Retrieve the count of the rows, with a column alias of "Count", of the city table and the country table only counting the city names that start with "Ab". Use the JOIN keyword, and join on the key column in common between the two tables.

#### Expected STDOUT:

```sql
Count
2
```

<details><summary><strong>Solution:</strong></summary>

```sql
-- My solution:
SELECT COUNT(*) AS 'Count' FROM city JOIN country USING (country_id) WHERE city LIKE 'Ab%';

-- Instructor solution:
SELECT COUNT(*) AS "Count" FROM city
JOIN country USING (country_id)
WHERE city LIKE 'Ab%';
```

</details>

## More Aggregate Functions

Remember, aggregate functions are allowed in two places in SQL, in a `SELECT` clause or in a `HAVING` clause. Here is a more in-depth look at additional SQL aggregate functions.

To use many of the functions provided in the SQL language, it is important to utilize another SQL clause, the `GROUP BY` clause. In our above examples of `COUNT()`, we did not use a `GROUP BY`; however, the `GROUP BY` clause is often used with aggregate functions to allow SQL to group the result set by one or more columns.

The SQL `GROUP BY` clause is available for use in a `SELECT` statement. This clause collects data or results across multiple records and groups the results by one or more columns. The `GROUP BY` clause will return one row per group. Another way to describe this is that `GROUP BY` groups a result into subsets that have matching values for one or more columns.

-   `COUNT()` — returns the number of elements in the set provided
-   `MAX()` — returns the maximum value of the set of values provided
-   `MIN()` — returns the minimum value of the set of values provided
-   `AVG()` — returns the average of the set of values provided
-   `SUM()` — returns the sum of all values in the set of values provided

### `AVG()` Example

In the **Sakila** database, there is a payment table. The columns in the payment table are as follows:

| Table Name | Column Names                                                                                   |
| ---------- | ---------------------------------------------------------------------------------------------- |
| payment    | payment_id, customer_id (FK), staff_id (FK), rental_id (FK), amount, payment_date, last_update |

To **_find the average amount spent on a video rental (e.g. using the_** `amount` **_column) for each customer_**, the `SELECT` statement will use an aggregate function, `AVG()` on the `amount` column. What does the following query return?

```sql
SELECT AVG(amount) FROM payment;
```

The above query returns the average of every payment that has ever been recorded in this table. Remember, originally we asked to **_find the average amount spent on a video rental (e.g. using the_** `amount` **_column) for each customer_**. Notice that the above query does not mention the customer at all, just an average. Try the following:

```sql
SELECT AVG(amount), customer_id FROM payment;
```

Note that the above query also does not do what we think it should. The above query will return the average amount spent on all of the rows, and it will return a random `customer_id` (probably the first one), but because we did not include a `GROUP BY` clause, we are not getting the average spent per customer.

When using the aggregate functions, it is required to use a `GROUP BY` clause to get the correct grouping of information. The following query will indeed return the average amount spent per `customer_id`. The `LIMIT` clause was added, or the query would have returned a row for every customer stored in the database.

```sql
SELECT AVG(amount), customer_id FROM payment GROUP BY customer_id LIMIT 5;
```

### 13. `SELECT` Statement – payment using `AVG()` & `GROUP BY`

Retrieve the `customer_id`, and the average of the `amount` paid for a rental in the `payment` table per customer. Use the `AVG()` aggregate function and the `GROUP BY` clause. Limit your results to the first 5 rows.

#### Expected STDOUT:

| customer_id | AVG(amount)        |
| :---------: | ------------------ |
|      1      | 3.7087499999999975 |
|      2      | 4.767777777777775  |
|      3      | 5.212222222222222  |
|      4      | 3.7172727272727273 |
|      5      | 3.80578947368421   |

<details><summary><strong>Solution:</strong></summary>

```sql
-- My solution:
SELECT customer_id, AVG(amount) FROM payment GROUP BY customer_id LIMIT 5;

-- Instructor solution:
SELECT customer_id, AVG(amount) FROM payment
GROUP BY customer_id LIMIT 5;
```

</details>

### `ROUND()` Function

Notice in the above question, that the average is printed out with many decimal places. There is a function that is provided in SQL that will round the result to the number of requested decimal places. That function is `ROUND()`, and it takes two parameters. The first parameter is the number to be rounded, and the second parameter is the number of decimal places requested.

```sql
SELECT ROUND(AVG(amount),2) FROM payment;
```

### 14. SELECT Statement – payment using `AVG()`, `GROUP BY` and `ROUND()`

Retrieve the `customer_id`, and the average of the `amount` paid for a rental in the `payment` table per customer, rounded to two (2) decimal places. Limit your results to the first 5 rows.

_Note: If you are struggling with the `ROUND()` function, refer to the example above._

#### Expected STDOUT:

| customer_id | ROUND(AVG(amount),2) |
| :---------: | -------------------- |
|      1      | 3.71                 |
|      2      | 4.77                 |
|      3      | 5.21                 |
|      4      | 3.72                 |
|      5      | 3.81                 |

<details><summary><strong>Solution:</strong></summary>

```sql
-- My solution:
SELECT customer_id, ROUND(AVG(amount),2) FROM payment GROUP BY customer_id LIMIT 5;
```

</details>

### 15. `SELECT` Statement — payment using `AVG()`, `GROUP BY`, `ROUND()` and Column Aliases

Retrieve the `customer_id`, and the average of the `amount` paid for a rental in the `payment` table per customer, rounded to two (2) decimal places. Limit your results to the first 5 rows. Use the following aliases in your query:

-   `customer_id` –> "Id"
-   rounded average –> "Average Spent"

#### Expected STDOUT:

| Id  | Average Spent |
| :-: | ------------- |
|  1  | 3.71          |
|  2  | 4.77          |
|  3  | 5.21          |
|  4  | 3.72          |
|  5  | 3.81          |

<details><summary><strong>Solution:</strong></summary>

```sql
-- My solution:
SELECT customer_id AS "Id", ROUND(AVG(amount),2) AS "Average Spent" FROM payment GROUP BY customer_id LIMIT 5;

-- Instructor solution:
SELECT customer_id AS "Id", ROUND(AVG(amount),2) AS "Average Spent"
FROM payment
GROUP BY customer_id LIMIT 5;
```

</details>

### 16. `SELECT` Statement -- `JOIN` two tables, `payment` and `customer`

Retrieve the `customer_id`, the customer's first and last names, and the average of the `amount` paid for a rental in the `payment` table per customer, rounded to two (2) decimal places. Limit your results to the first 5 rows.

**NOTE:** The column headers have to be **exact** for the answers to match. For example `round()` does not match `ROUND()`. If your answer looks correct, but does not match, please check the column headers.

_Use `AVG()`, `GROUP BY`, `ROUND()`, and `INNER JOIN`_

#### Expected STDOUT:

| customer_id | first_name | last_name | ROUND(AVG(amount),2) |
| :---------: | ---------- | --------- | -------------------- |
|      1      | MARY       | SMITH     | 3.71                 |
|      2      | PATRICIA   | JOHNSON   | 4.77                 |
|      3      | LINDA      | WILLIAMS  | 5.21                 |
|      4      | BARBARA    | JONES     | 3.72                 |
|      5      | ELIZABETH  | BROWN     | 3.81                 |

<details><summary><strong>Solution:</strong></summary>

```sql
-- My solution:
SELECT customer_id, first_name, last_name, ROUND(AVG(amount),2) FROM PAYMENT
JOIN customer USING (customer_id)
GROUP BY customer_id
LIMIT 5;

-- Instructor solution:
SELECT customer_id, first_name, last_name, ROUND(AVG(amount),2)
FROM payment
INNER JOIN customer USING (customer_id)
GROUP BY customer_id LIMIT 5;
```

</details>

### 17. `SELECT` Statement — `JOIN` two tables, `payment` and `customer` — Use column aliases

Retrieve the `customer_id`, the customer's first and last names, and the average of the `amount` paid for a rental in the `payment` table per customer, rounded to two (2) decimal places. Limit your results to the first 5 rows. Use the following column aliases in your query:

-   `customer_id` –> "Id"
-   `first_name` –> "First Name"
-   `last_name` –> "Last Name"
-   rounded average –> "Average Spent"

_Use `AVG()`, `GROUP BY`, `ROUND()`, `INNER JOIN` and column aliases_

#### Expected STDOUT:

| Id  | First Name | Last Name | Average Spent |
| :-: | ---------- | --------- | ------------- |
|  1  | MARY       | SMITH     | 3.71          |
|  2  | PATRICIA   | JOHNSON   | 4.77          |
|  3  | LINDA      | WILLIAMS  | 5.21          |
|  4  | BARBARA    | JONES     | 3.72          |
|  5  | ELIZABETH  | BROWN     | 3.81          |

<details><summary><strong>Solution:</strong></summary>

```sql
-- My solution:
SELECT customer_id AS "Id", first_name AS "First Name", last_name AS "Last Name", ROUND(AVG(amount),2) AS "Average Spent" FROM payment
JOIN customer USING (customer_id)
GROUP BY customer_id
LIMIT 5;

-- Instructor solution:
SELECT customer_id AS "Id", first_name AS "First Name", last_name AS "Last Name",
    ROUND(AVG(amount),2) AS "Average Spent"
FROM payment
INNER JOIN customer USING (customer_id)
GROUP BY customer_id LIMIT 5;
```

</details>

### Concatenation Operator

When retrieving columns, it sometimes makes sense to use the concatenation operator `||` to allow one column to be printed with the information from multiple columns. Here is an example:

```sql
SELECT customer_id AS "Id", first_name || " " || last_name AS "Customer Name" FROM customer;
```

### 18. `SELECT` Statement — `JOIN` two tables, `payment` and `customer` -- Use column aliases & `||`

Retrieve the `customer_id`, the customer's first and last names, and the average of the `amount` paid for a rental in the `payment` table per customer, rounded to two (2) decimal places. Limit your results to the first 5 rows. Use the following column aliases in your query:

-   `customer_id` –> "Id"
-   customer's full name –> "Customer Name"
-   rounded average –> "Average Spent"

_Use `AVG()`, `GROUP BY`, `ROUND()`, `INNER JOIN`, column aliases, and `||`_

#### Expected STDOUT:

| Id  | Customer Name    | Average Spent |
| :-: | ---------------- | ------------- |
|  1  | MARY SMITH       | 3.71          |
|  2  | PATRICIA JOHNSON | 4.77          |
|  3  | LINDA WILLIAMS   | 5.21          |
|  4  | BARBARA JONES    | 3.72          |
|  5  | ELIZABETH BROWN  | 3.81          |

<details><summary><strong>Solution:</strong></summary>

```sql
-- My solution:
SELECT customer_id AS "Id", first_name || " " || last_name AS "Customer Name",
    ROUND(AVG(amount),2) AS "Average Spent" FROM payment
JOIN customer USING (customer_id)
GROUP BY customer_id LIMIT 5;

-- Instructor solution:
```

</details>

These are the **Sakila** tables that might help you with the following two questions:

| Table Name | Column Names                                                                                                             |
| ---------- | ------------------------------------------------------------------------------------------------------------------------ |
| address    | address_id, address, address2, district, city_id (FK), postal_code, phone, location, last_update                         |
| city       | city_id, city, country_id (FK), last_update                                                                              |
| country    | country_id, country, last_update                                                                                         |
| customer   | customer_id, store_id (FK), first_name, last_name, email, address_id (FK), active, create_date, last_update              |
| rental     | rental_id, rental_date, inventory_id (FK), customer_id (FK), return_date, staff_id (FK), last_update                     |
| staff      | staff_id, first_name, last_name, address_id (FK), picture, email, store_id (FK), active, username, password, last_update |
| store      | store_id, manager_staff_id (FK), address_id (FK), last_update                                                            |

### 19. Mastery #1: Complex `SELECT` Statement

Retrieve data from the **Sakila** database that solves the following request:

-   List the `customer_id` & the count of films rented by the customer with a `first_name` of "AUSTIN".
-   Create the following title for the count of films — "Number of Rentals"
-   Use "Id" as the header for the `customer_id` column

#### Expected STDOUT:

| Id  | Number of Rentals |
| :-: | ----------------- |
| 599 | 19                |

<details><summary><strong>Solution:</strong></summary>

```sql
-- My solution:
SELECT customer_id AS "Id", COUNT(rental_id) AS "Number of Rentals" FROM customer JOIN rental 
    USING (customer_id) WHERE first_name = "AUSTIN" GROUP BY customer_id;

-- Instructor solution:
SELECT customer_id AS "Id", COUNT(rental_id) AS "Number of Rentals"
FROM rental
JOIN customer USING (customer_id)
WHERE first_name = "AUSTIN";
```

</details>

### 20. Mastery #2: Complex `SELECT` Statement

Retrieve data from the **Sakila** database that solves the following request:

-   List all the `staff` members and their respective stores,
-   For each `staff` member, print out the `staff_id`, `first_name`, and `last_name`
-   For each `store`, print out the `store_id` as well as the location of the **store**, including the `address`, the `city` and the `country`
-   Remember that each table has an `tableName_id` field, which can be used in the `JOIN` for each table.
-   This question requires retrieving information from five (5) tables.
-   Additionally, use the form `tableName.columnName` to retrieve the information from the correct location. For example, `city` could be `city.city` in the `SELECT` statement.

_The_ `JOIN` _statement is used to connect tables together._

_Notice that both the staff and the store have an address, so use_ `JOIN address ON store.address_id = address.address_id` _to get the correct address._

#### Expected STDOUT:

| staff_id | first_name | last_name | store_id | address            | city      | country   |
| :------: | ---------- | --------- | :------: | ------------------ | --------- | --------- |
|    1     | Mike       | Hillyer   |    2     | 28 MySQL Boulevard | Woodridge | Australia |
|    2     | Jon        | Stephens  |    2     | 28 MySQL Boulevard | Woodridge | Australia |

<details><summary><strong>Solution:</strong></summary>

```sql
-- My solution:
SELECT staff_id, first_name, last_name, store_id, address, city, country
FROM staff
JOIN store USING (store_id)
JOIN address ON store.address_id = address.address_id
JOIN city USING (city_id)
JOIN country USING (country_id)
GROUP BY staff_id;

-- Instructor solution:
SELECT staff_id, first_name, last_name, store_id, address.address, 
    city.city, country.country
FROM staff
JOIN store USING (store_id)
JOIN address ON store.address_id = address.address_id
JOIN city USING (city_id)
JOIN country USING (country_id);
```

</details>
