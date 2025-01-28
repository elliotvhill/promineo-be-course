# Week 10 Curriculum — Returning Data

Notes from the week 10 MySQL video lessons.

## Overview

### Reading Data

-   The "R" in C**R**UD
-   `SELECT` statement syntax:

    -   `WHERE` clause
    -   `ORDER BY`
    -   `DISTINCT`
    -   `LIMIT`
    -   `GROUP BY`
    -   `HAVING`

### Reading from multiple tables

-   `jOIN`s:
    -   **Inner** `JOIN`
    -   Outer **left** `JOIN`
    -   Outer **right** `JOIN`
    -   **Cross** `JOIN`
-   Subqueries:
    -   Getting the needed **value** from a known value
    -   Example: get an ID given a name

### Returning data

-   The **roles** of the data layer and the service layer
-   Returning single rows using `Optional`
-   Returning multiple rows using `List`
-   Throwing an **exception** from an empty `Optional`

### Work on the video application

-   Retrieve and display _all_ recipes
-   Retrieve and display a _selected_ recipe:
    -   Recipe details
    -   Ingredients
    -   Steps
    -   Categories

## Reading Data

### Reading from a single table: `SELECT`

`SELECT` statement syntax:

```sql
SELECT <columns>
FROM <table>
WHERE <constraints>;
```

**CRUD Recap:**

| Operation  | SQL Keyword             |
| ---------- | ----------------------- |
| **C**reate | `INSERT INTO <table>`   |
| **S**slect | `SELECT * FROM <table>` |
| **U**pdate |                         |
| **D**elete |                         |

#### Literals in `SELECT` statements:

-   **Numbers** do not have quotes
-   Everything else is **surrounded** by _single_ quotes
-   MySQL usually **recognizes** double quotes, but this is not necessarily true of other databases

#### `SELECT` columns:

-   Column names are separated by **commas**
-   Data is returned _(in a Results Set)_ in the **same** order as the column names

```sql
SELECT recipe_id, recipe_name
FROM recipe
WHERE recipe_id = 1;

+-----------+-------------------+
| recipe_id | recipe_name       |
+-----------+-------------------+
|         1 | Kitty Litter Cake |
+-----------+-------------------+
```

#### `SELECT` all columns:

-   "`*`" means _all_ columns
-   The columns are returned in the **order** they were specified in the `CREATE TABLE` statement

```sql
SELECT *
FROM category
WHERE category_id = 1;

+-------------+----------------+
| category_id | category_name  |
+-------------+----------------+
|         1   | Asian          |
+-------------+----------------+
```

#### Column aliases:

```sql
SELECT prep_time AS 'Time to Prepare'
FROM recipe;

+-----------------+
| Time to Prepare |
+-----------------+
|        00:20:00 |
|        00:20:00 |
|        00:50:00 |
|        23:59:00 |
+-----------------+
```

#### No `WHERE` clause:

-   **Acts** on the _entire_ table

```sql
SELECT *
FROM category;

+-------------+----------------+
| category_id | category_name  |
+-------------+----------------+
|         1   | Asian          |
|         2   | Beef           |
|         3   | Smoker         |
|         4   | Bread          |
|         5   | Breakfast      |
|       ...   | ...            |
+-------------+----------------+
```

## `WHERE` clause

`WHERE` clause syntax:

```sql
WHERE
    sub-clause1
    sub-clause2
    ...
    sub-clauseN
```

### `WHERE` — relationsal operators:

| Operator | Meaning               |
| :------: | --------------------- |
|    <     | Less than             |
|    >     | Greater than          |
|    <=    | Less than or equal    |
|    >=    | Greater than or equal |
|    =     | Equals                |
|    !=    | Not equal             |

### `WHERE` — `AND`:

```sql
SELECT *
FROM category
WHERE category_name >= 'a'
    AND category_name <= 'd';

+-------------+----------------+
| category_id | category_name  |
+-------------+----------------+
|          1  | Asian          |
|          2  | Beef           |
|          4  | Bread          |
|          5  | Breakfast      |
+-------------+----------------+
```

### `WHERE` — `OR`:

```sql
SELECT *
FROM category
WHERE category_name <= 'b'
    OR category_name >= 't';

+-------------+----------------+
| category_id | category_name  |
+-------------+----------------+
|          1  | Asian          |
|         21  | Tex-Mex        |
|         22  | Vegetarian     |
|         23  | Veggies        |
+-------------+----------------+
```

### `WHERE` — `IN`:

```sql
SELECT *
FROM category
WHERE category_id IN (4, 6, 8);

+-------------+-------------------+
| category_id | category_name     |
+-------------+-------------------+
|          4  | Bread             |
|          6  | Fish and Seafood  |
|          8  | Kid Food          |
+-------------+-------------------+
```

### `WHERE` — `BETWEEN` (inclusive):

```sql
SELECT *
FROM category
WHERE category_id BETWEEN 8 AND 10;

+-------------+----------------+
| category_id | category_name  |
+-------------+----------------+
|          8  | Kid Food       |
|          9  | Low Carb       |
|         10  | Main Dish      |
+-------------+----------------+
```

### `WHERE` wildcards

-   An underscore ('`_`') means "match any **single** character"
-   A percent ('`%`') means "match **zero or more** characters"
-   Used with `LIKE` keyword

### `WHERE` — `LIKE`:

```sql
SELECT *
FROM category
WHERE category_name LIKE '_e%';

+-------------+-----------------+
| category_id | category_name   |
+-------------+-----------------+
|          2  | Bread           |
|         11  | Mediterranean   |
|         12  | Mexican         |
|         21  | Tex-Mex         |
|         22  | Vegetarian      |
|         23  | Veggies         |
+-------------+-----------------+
```

### `WHERE` — `IS NULL`:

```sql
SELECT ingredient_name, amount
FROM ingredient
WHERE amount IS NULL;

+----------------------+------------+
| ingredient_name      |   amount   |
+----------------------+------------+
| green food coloring  |   [NULL]   |
| sunflower seeds      |   [NULL]   |
+----------------------+------------+
```

### `WHERE` — `NOT`:

```sql
SELECT *
FROM category
WHERE category_id NOT BETWEEN 3 AND 22;

+-------------+----------------+
| category_id | category_name  |
+-------------+----------------+
|          1  | Asian          |
|          2  | Beef           |
|         23  | Veggies        |
|         24  | Fruit          |
+-------------+----------------+
```

## Other clauses

### Sorting: `ORDER BY`

```sql
SELECT *
FROM category
ORDER BY category_name DESC;

+-------------+----------------+
| category_id | category_name  |
+-------------+----------------+
|         23  | Veggies        |
|         22  | Vegetarian     |
|         21  | Tex-Mex        |
|         20  | Soup           |
|          3  | Smoker         |
|         19  | Slow Cooker    |
|        ...  | ...            |
+-------------+----------------+
```

### `ORDER BY` details

-   Can specify a **direction**:

    -   `ORDER BY category_name ASC`
    -   `ORDER BY category_name DESC`
    -   `ORDER BY category_name` — _same as `ASC`_

-   **More** than one column can be specified
-   Separate columns by **comma**

```sql
SELECT prep_time, recipe_name
FROM recipe
ORDER BY prep_time, recipe_name;

+-----------+-------------------+
| prep_time | recipe_name       |
+-----------+-------------------+
|  00:05:00 | Ice Cubes         |
|  00:20:00 | Apple Monsters    |
|  00:20:00 | Kitty Litter Cake |
|  23:59:00 | Chocolate Moose   |
+-----------+-------------------+
```

### `DISTINCT`

Returns rows that are **unique** across all requested columns

```sql
SELECT prep_time
FROM recipe
ORDER BY prep_time;

+-----------+
| prep_time |
+-----------+
|  00:05:00 |
|  00:20:00 |
|  00:20:00 |
|  23:59:00 |
+-----------+

SELECT DISTINCT prep_time
FROM recipe
ORDER BY prep_time;

+-----------+
| prep_time |
+-----------+
|  00:05:00 |
|  00:20:00 |
|  23:59:00 |
+-----------+
```

### `LIMIT`

Specifies the **maximum** number of rows to return

```sql
SELECT recipe_name, prep_time
FROM recipe
ORDER BY prep_time
LIMIT 2;

+-------------------+-----------+
| recipe_name       | prep_time |
+-------------------+-----------+
| Ice Cubes         |  00:05:00 |
| Kitty Litter Cake |  00:20:00 |
+-------------------+-----------+
```

### `LIMIT` with `OFFSET`

-   Specifies the **starting row** as well as the **maximum** number of rows returned
-   `OFFSET` is **zero-based**

```sql
SELECT recipe_name, prep_time
FROM recipe
ORDER BY prep_time
LIMIT 2 OFFSET 1;

+-------------------+-----------+
| recipe_name       | prep_time |
+-------------------+-----------+
| Kitty Litter Cake |  00:20:00 |
| Apple Monsters    |  00:20:00 |
+-------------------+-----------+
```

### `GROUP BY`

Groups like results together

```sql
SELECT count(*) AS 'Num Recipes', prep_time
FROM recipe
GROUP BY prep_time;

+-------------+-----------+
| Num Recipes | prep_time |
+-------------+-----------+
|           2 |  00:20:00 |
|           1 |  00:05:00 |
|           1 |  23:59:00 |
+-------------+-----------+
```

### `HAVING`

Like a `WHERE` clause but with an **aggregate function** — like `count(*)`

```sql
SELECT count(*) AS 'Num Recipes', prep_time
FROM recipe
GROUP BY prep_time
HAVING count(*) = 1;

+-------------+-----------+
| Num Recipes | prep_time |
+-------------+-----------+
|           1 |  00:05:00 |
|           1 |  23:59:00 |
+-------------+-----------+
```

-   **Difference** between `WHERE` and `HAVING`:
    -   `WHERE` puts constraint(s) on table **columns**
    -   `HAVING` puts constraint(s) on **aggregate functions**
-   Aggregate functions **combine** results — e.g. `SUM`, `COUNT`, `AVG`

### `GROUP BY` vs. `HAVING`

-   `GROUP BY` does **not** need a `HAVING` clause
-   `HAVING` does not need a `GROUP BY` clause, but the results won't be anything that makes **sense**

```sql
SELECT count(*) AS 'Num Recipes', prep_time
FROM recipe
HAVING count(*) > 0;

+-------------+-----------+
| Num Recipes | prep_time |
+-------------+-----------+
|           4 |  00:20:00 |
+-------------+-----------+
```

### Recap of `SELECT` statement components:

```sql
SELECT [DISTINCT] <columns>
FROM <table>
WHERE <constraints>
GROUP BY <column>
HAVING <aggregate function>
ORDER BY <columns>
LIMIT <num_rows> [OFFSET row];
```

## `JOIN`s and Subqueries — reading from multiple tables

### Table aliases

```sql
SELECT i.ingredient_name
FROM ingredient i -- Alias 'i'
WHERE i.recipe_id = 4;

+---------------------+
| ingredient_name     |
+---------------------+
| moose               |
| Hersheys chocolate  |
| Cool Whip           |
| cherry              |
+---------------------+
```

### Working with multiple tables

-   Tables can be "joined" together to form a **single** result set with data from more than one table.
-   Tables are **joined** on primary key/foreign key columns.
-   If the value in the primary key **matches** a value in the foreign key column, the rows are **joined**.

### Join Types

MySQL recognizes these join types:

-   **Inner** join
    - Returns only the rows that have matching values in **both** tables
-   **Outer** join (left and right)
    - Returns all the rows from one table (left or right) and all rows from the second table regardless of whether they hold null values
-   **Cross** join _(rarely used)_

### Subqueries

- A **subquery** is a query **within** another query, insert, delete, or update statement.
- It is used to get an ID or other value that is used by the **surrounding** query.
- Subqueries are used to **transform** a value you _have_ ("name") into a value you _need_ ("ID").

**Example:**

```sql
SELECT b.breed_name, c.category_name
FROM breed b
JOIN breed_category bc USING (breed_id)
JOIN category c USING (category_id)
WHERE b.breed_id = 1;

DELETE FROM breed_category WHERE breed_id = 1;

-- Add row back to table, using subqueries to retrieve the breed and category IDs:
INSERT INTO breed_category
(breed_id, category_id)
VALUES
(
    (SELECT breed_id FROM breed WHERE breed_name = 'American Rabbit'),
    (SELECT category_id FROM category WHERE category_name = 'smooth')
)
```

<!-- ## Returning Data -->

<!-- ## List Recipes -->

<!-- ## Select Current Recipe -->
