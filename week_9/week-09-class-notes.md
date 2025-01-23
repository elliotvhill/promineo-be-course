# Week 9 Class Notes

### JDBC

-   We use several Java class/objects to help connect to MySQL
-   Java provides the objects, the driver makes the connections
    -   `java.sql.Connection` -> MySQL driver
    -   `java.sql.Statement` -> MySQL driver
    -   `java.sql.PreparedStatement` -> MySQL driver
    -   `java.sql.ResultSet` -> MySQL driver

### JDBC and Transactions

-   This is a key component of database technologies.
-   We don't want partial transactions to be written to the database — we will have corrupt data and/or we might create problems with other things going on.
-   JDBC supports transactions — _no partial transactions, i.e. all succeed or all fail_

### Java Design

-   CRUD pattern:
    -   Create (`INSERT`)
    -   Read (`SELECT`)
    -   Update (`UPDATE`)
    -   Delete (`DELETE`)
-   This will be used moving forward and we will use this pattern for all our projects.

### Packages

-   Remember when we started learning Java, we talked about the keyword "package" — which is nothing more than a way to separate code into folders or sections.

-   For projects moving forward, we have some new folders that will help us identify what code goes where.

-   For example, in the projects we'll be working on, you'll see folders called:
    -   **Entity** — an Entity is an Object that represents a Table in the database
    -   **DAO** — DAO stands for Data Access Object; this Object holds the SQL or Access stuff to read data from the database into the Entity. So for the recipe project example, we will have a `Recipe.java` (Entity) and `RecipeDao.java` (DAO) and they work together.
    -   **Service** — Services are Objects that do more things and we will look at some examples
