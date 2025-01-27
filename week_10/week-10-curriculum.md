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

<!-- ## Other clauses -->

<!-- ### Sorting: `ORDER BY` -->

<!-- ## `JOIN`s and Subqueries -->

<!-- ## Returning Data -->

<!-- ## List Recipes -->

<!-- ## Select Current Recipe -->
