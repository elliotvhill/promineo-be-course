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

#### The approach:

1. Add the menu items with methods:
    - Add ingredient to current recipe
    - Add step to current recipe
2. Add the pass-through methods in the `Service` class
3. Write the methods to add an ingredient and a step in the `DAO` class

<!-- ## Coding the Many to Many Relationship -->

<!-- ## The Update Statement -->

<!-- ## The Delete Statement -->

<!-- ## Changing Sort Order with Streams -->
