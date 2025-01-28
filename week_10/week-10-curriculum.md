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

### Reading from a Single Table: `SELECT`

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

## `WHERE` Clause

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

## Other Clauses

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

## `JOIN`s and Subqueries — Reading from Multiple Tables

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
    -   Returns only the rows that have matching values in **both** tables
-   **Outer** join (left and right)
    -   Returns all the rows from one table (left or right) and all rows from the second table regardless of whether they hold null values
-   **Cross** join _(rarely used)_

### Subqueries

-   A **subquery** is a query **within** another query, insert, delete, or update statement.
-   It is used to get an ID or other value that is used by the **surrounding** query.
-   Subqueries are used to **transform** a value you _have_ ("name") into a value you _need_ ("ID").

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

## Returning Data — Moving and Modifying Data

#### Java Application — 3 tiers:

-   I/O layer
-   Service layer
-   Data Access Object (DAO) layer

## DAO Layer

-   Reads and writes data to **tables**
-   Does not _create_ **exceptions** (but rather, passes on exceptions from the driver)
-   Data is generally **not** transformed
-   Data is put into DAO classes that **model** the tables
-   The DAO **returns** multiple rows (`fetchAll`) or single rows (`fetchById`)

### Multiple Rows

-   Returns a **list** of objects in which each element in the list represents a single row of data
-   If no rows are found, an **empty** list is returned
-   `NULL` is **never** returned

**Code Example:**

```java
public List<Recipe> fetchRecipe(Integer recipeId) {
    try (Connection conn = getConnection()) { // Get connection with try-with-resource block
        try (PreparedStatement stmt = conn.prepareStatement(sql)) { // Get PreparedStatement with another try-with-resource block
            stmt.setInt(recipeId); // Set parameters on the statement

            try (ResultSet rs = stmt.executeQuery() { // Perform the query
                List<Recipe> recipes = new LinkedList<>(); // Return result set

                while (rs.next()) { // Work through result set one at a time
                    recipes.add(extract(rs, Recipe.class));
                }

                return recipes;
            })
        }
    }
}
```

### Single Row: return `NULL` _(not optimal)_

-   The "old" way of returning a single row is to return data if the row exists and return `NULL` if the row does _not_ exist
-   The problem is that a **programmer** may not know (or may _ignore_ the fact) that a `NULL` may be returned

**Return `NULL` Code:**

```java
public Recipe fetchRecipe(Integer recipeId) {
    try (Connection conn = getConnection()) {
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery() {
                if (rs.next()) { // Use 'if' because only expecting one row (vs 'while' above)
                    return extract(rs, Recipe.class);
                }

                return null;
            })
        }
    }
}
```

### Single Row: return `Optional` _(better)_

-   An `Optional` is a Java class that replaces `NULL` as a return value.
-   The `Optional` either contains an Object _or_ it is empty — it is **never** `NULL` _(could_ contain `NULL`_, though)_
-   A programmer can ignore a `NULL` return value — leading to a `NullPointerException`...
-   ...whereas `Optional`s **cannot** be ignored.
-   i.e. an "in your **face**" approach

**Return `Optional` Code:**

```java
public Optional<Recipe> fetchRecipe(Integer recipeId) {
    try (Connection conn = getConnection()) {
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery() {
                Recipe recipe = null;

                if (rs.next()) {
                    recipe = extract(rs, Recipe.class);
                }

                return Optional.ofNullable(recipe); // '.ofNullable()' allows null whereas using '.of' could return a NullPointerException
            })
        }
    }
}
```

## Service Layer

-   **Transforms** data
-   **Applies** business rules — _e.g. changing a sort order, pulling output from different tables together to combine into a single Object, etc._
-   **Validates** data
-   **Throws** appropriate Exceptions
-   Works well with `Optional` to throw application-specific exceptions

### Service Layer: Multiple Rows

-   No need for `NULL` check — the **list** returned from the Data layer will never be `NULL`
-   If there are no rows, the list will be **empty**

### Service Layer: Single Row with `NULL`

```java
Recipe recipe = dao.fetchRecipe(recipeId);

if ("Ice".equals(recipe.getRecipeName())) {
    // something
}
```

-   This throws a `NullPointerException` if the recipe is `NULL`
-   The **programmer** did _not_ consider that `recipe` may be null
-   It probably wasn't **documented**...

### Service Layer: Single Row with `Optional`

-   Expresses the programmer's **intent**
-   Specifically says: the returned value _may be_ `NULL` _(i.e. is self-documenting)_ — deal with it!

```java
Optional<Recipe> opRecipe = dao.fetchRecipe(...);

if (opRecipe.isPresent()) {
    Recipe recipe = opRecipe.get();

    // Do something here
}
```

### `Optional` with default Exception

```java
public Recipe getRecipe(Integer recipeId) {
    Optional<Recipe> opRecipe = dao.fetchRecipe(recipeId);

    return opRecipe.orElseThrow(); // Throws a 'NoSuchElementException'
}
```

### `Optional` with custom Exception

```java
public Recipe getRecipe(Integer recipeId) {
    Optional<Recipe> opRecipe = dao.fetchRecipe(recipeId);

    return opRecipe.orElseThrow(
        () -> new NotFoundException("Not found"); // Lambda expression with no parameters
    );
}
```

#### Or, without assigning a variable:

```java
public Recipe getRecipe(Integer recipeId) {
    return dao.getRecipe(recipeId)
        .orElseThrow();
}

// or with a custom exception...

public Recipe getRecipe(Integer recipeId) {
    return dao.getRecipe(recipeId)
        .orElseThrow(() ->
            new NotFoundException(
                "Not found");
    );
}
```

## Input/Output Layer

-   **Gathers** data from the user
-   **Handles** exceptions
-   **Processes** menu operations
-   **Interacts** with the Service layer

```java
private void displayMenu() {
    boolean done = false;

    while (!done) {
        try {
            int operation = getOperation();

            switch (operation) {
                // ...
            }
        }
        catch (Exception e) {
            System.out.println("\nError: " +
                e.getMessage() + " Try again.");
        }
    }
}
```

### Recap

-   **Data** layer:
    -   Returns data (`List` or `Optional`)
    -   Passes on exceptions; does not _create_ them
-   **Service** layer:
    -   Formats/transforms data
    -   Applies business rules
    -   Throws exceptions
-   **I/O** layer:
    -   Accepts and displays data
    -   Handles exceptions

## Listing Recipes

**Goal:** request a list recipes without steps or ingredients

1. Add the **selection** to the menu operation list
2. Add a **case** inside the `switch` statement
3. Write methods in the `main` class, the service, and the DAO to **fetch** all recipes

## Select Current Recipe

**Goal:** list a recipe with steps or ingredients

1. In the **DAO** class, write the method to fetch recipe details, ingredients, steps, and categories
2. In the **Service** class, write the method to call the DAO method
3. In the **main** class, write the method that gets data from the user and calls the service method
