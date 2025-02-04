# Week 11: MySQL — Many to Many, Update, Delete

Notes from the week 11 MySQL lecture videos.

## Overview

-   MySQL functions:

    -   **Math** functions
    -   **Text** functions
    -   **Date/timme** functions

-   Coding the many-to-many relationship:

    -   Write code to properly insert categories using the join table
    -   Using a subquery

-   More CRUD:

    -   `UPDATE <table> SET`
    -   `DELETE FROM <table>`
    -   A **real-life** look at `ON DELETE CASCADE`

-   A brief look at Streams:

    -   Fetch, sort, and return all in **one** statement
    -   Streams are ultimately **elegant**
    -   Streams are initially **confusing**

## MySQL Functions

### Math Functions

#### `COUNT`

Counts the **number of rows returned** using the current constraints (i.e. `WHERE` clause)

```sql
SELECT COUNT(i.amount) AS Count
FROM ingredient i;

+-------+
| Count |
+-------+
|    17 |
+-------+
```

#### `AVG`

Computes the **average** of a column across all selected rows

```sql
SELECT AVG(i.amount) AS Average
FROM ingredient i;

+----------+
| Average  |
+----------+
| 9.152941 |
+----------+
```

#### `SUM`

Computes the **sum** of a column across all selected rows

```sql
SELECT SUM(i.amount) AS Sum
FROM ingredient i;

+-------+
| Sum   |
+-------+
| 155.6 |
+-------+
```

#### `MIN`

Finds the **minimum** value of a column across all selected rows

```sql
SELECT MIN(i.amount) AS Min
FROM ingredient i;

+------+
| Min  |
+------+
|    1 |
+------+
```

#### `MAX`

Finds the **maximum** value of a column across all selected rows

```sql
SELECT MAX(i.amount) AS Max
FROM ingredient i;

+------+
| Max  |
+------+
|   40 |
+------+
```

### String Functions

#### `CONCAT`

Concatenates **two Strings** _or_ **column values** together

```sql
SELECT DISTINCT CONCAT(i.amount, ' ',
    u.unit_name_plural) AS Amount
FROM ingredient i
INNER JOIN unit u USING (unit_id)
WHERE u.unit_name_plural LIKE 'ou%';

+--------------+
| Amount       |
+--------------+
| 16.25 ounces |
| 5.10 ounces  |
| 25.00 ounces |
+--------------+
```

#### `UPPER`

Returns a String **converted to uppercase**

```sql
SELECT UPPER(r.recipe_name) AS 'Name Upper'
FROM recipe r;

+-------------------+
| Name Upper        |
+-------------------+
| KITTY LITTER CAKE |
| APPLE MONSTERS    |
| ICE CUBES         |
| CHOCOLATE MOOSE   |
+-------------------+
```

#### `LOWER`

Returns a String **converted to lowercase**

```sql
SELECT LOWER(r.recipe_name) AS 'Name Lower'
FROM recipe r;

+-------------------+
| Name Lower        |
+-------------------+
| kitty litter cake |
| apple monsters    |
| ice cubes         |
| chocolate moose   |
+-------------------+
```

### Date/time Functions

#### `CURRENT_TIMESTAMP`

-   Returns the **current time** as a `TIMESTAMP`
-   Same as using `NOW()`

```sql
SELECT CURRENT_TIMESTAMP() AS Now;

+---------------------+
| Now                 |
+---------------------+
| 2024-04-13 14:08:15 |
+---------------------+
```

#### `CURDATE`

Returns the **current time** as a `DATE`

```sql
SELECT CURDATE() AS Now;

+------------+
| Now        |
+------------+
| 2024-04-13 |
+------------+
```

#### `CURTIME`

Returns the **current time** as a `TIME`

```sql
SELECT CURTIME() AS Now;

+----------+
| Now      |
+----------+
| 14:08:15 |
+----------+
```

### 'Recipes' project work

#### Recipes project approach:

1. Add the menu items with methods:
    - Add ingredient to current recipe
    - Add step to current recipe
2. Add the pass-through methods in the `Service` class
3. Write the methods to add an ingredient and a step in the `DAO` class

## Coding the Many-to-Many Relationship

### Many-to-many Recap

-   A many-to-many relationship requires a **join table**. Each main table has a **primary key**. The join table has **two foreign keys**.

#### `recipe_category` join table:

The `recipe_category` table has foreign keys for the **recipe ID** and the **category ID**.

#### Reminder: `CREATE TABLE` for many-to-many relationships:

```sql
CREATE TABLE recipe_category (
    recipe_id INT NOT NULL,
    category_id INT NOT NULL,
    FOREIGN KEY (recipe_id)
        REFERENCES recipe (recipe_id)
        ON DELETE CASCADE,
    FOREIGN KEY (category_id)
        REFERENCES category (category_id)
        ON DELETE CASCADE,
    UNIQUE KEY (recipe_id, category_id)
);
```

### The strategy

-   MySQL won't fill in the **foreign key** values when we add a row to `recipe_category`
-   The **user** will enter:
    -   The recipe ID
    -   The category name
-   The **application** will look up the category ID based on the name
-   We will use a **subquery** for this

### The SQL

```sql
INSERT INTO recipe_category
    (recipe_id, category_id)
VALUES (
    ?,
    -- Subquery:
    (
        SELECT category_id
        FROM categories,
        WHERE category_name = ?
    )
)
```

In the (Java) `statement`, set these parameters _(based on the position of the "_`?`_"s)_:

```java
stmt.setInt(1, categoryId); // 1 = first '?'
stmt.setString(2, categoryName); // 2 = second '?'
```

### Recipes project approach

-   Add the "add category" selection to the application menu, along with the associated methods
-   Add the service method
-   Write the add category method in the DAO
-   Test it!

## The Update Statement

#### Update syntax:

```sql
UPDATE <table_name> SET
<column_name_1> = <value_1>,
<column_name_2> = <value_2>,
-- ...
<column_name_n> = <value_n>
WHERE <constraint>;
```

#### CRUD Recap:

| Operation  | SQL Keyword             |
| ---------- | ----------------------- |
| **C**reate | `INSERT INTO <table>`   |
| **R**ead   | `SELECT * FROM <table>` |
| **U**pdate | `UPDATE <table> SET...` |
| **D**elete |                         |

#### `UPDATE` example:

```sql
INSERT INTO step
    (recipe_id, step_order, step_text)
VALUES
    (5, 1, 'Mix water and dirt with fingers');

UPDATE step
SET step_text =
    'Squish water and dirt together with fingers'
WHERE step_id = 25;
```

### Recipes project approach

1. Add "modify step" to menu and get input from user
2. Add `modifyStep` method to service class
3. Write the `modifyRecipeStep` method in the DAO

## The Delete Statement

### Delete syntax

```sql
DELETE FROM <table_name>
WHERE <constraint>;
```

**Note: Do not forget the `WHERE` clause — otherwise _all_ rows in the table will be deleted!!**

### Deleting child rows

-   When a recipe is deleted, all the **child rows** are deleted as well:
    -   ingredient
    -   step
    -   recipe_category
-   This is because the foreign key constraints used `ON DELETE CASCADE` _(i.e. in the schema)_

#### CRUD Recap:

| Operation  | SQL Keyword             |
| ---------- | ----------------------- |
| **C**reate | `INSERT INTO <table>`   |
| **R**ead   | `SELECT * FROM <table>` |
| **U**pdate | `UPDATE <table> SET...` |
| **D**elete | `DELETE FROM <table>`   |

#### Delete example:

```sql
DELETE FROM recipe
WHERE recipe_id = 5;
```

### Recipes project approach

1. Add "delete recipe" operation and gather user input
2. Add `deleteRecipe` method in the service class
    - Throw an exception if the recipe doesn't exist
3. Write `deleteRecipe` method in the DAO

<!-- ## Changing Sort Order with Streams -->
