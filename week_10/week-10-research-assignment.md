# Week 10 Research Assignment

### Instructions

-   Choose at least **two (2)** of the below prompts.
-   Research those prompts.
-   Write at least one paragraph for **two (2)** of the below prompts
-   Include URLs from where you found the information to cite your sources.
-   Submit your **Research Results** to the LMS.

## Prompts

1. What is JDBC? What does it stand for? How does it differ from or relate to MySQL?

2. Give an example of the primary JDBC Classes? What Classes do we use to do the following, and give an example of syntax to accomplish the following:

    - (a) Attach or Connect to a database

        > The `Connection` class is used to attach or connect to a database. Constants are defined and used to construct a URI that is then passed to the `DriverManager` to get a connection.
        >
        > For example, the following code obtains a new connection to a database:

        ```java
        public class DbConnection {

            private static final String SCHEMA = "schema";
            private static final String USER = "user";
            private static final String PASSWORD = "password";
            private static final String HOST = "host";
            private static final int PORT = 3306;

            public static Connection getConnection() {
                String uri = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false", HOST, PORT, SCHEMA, USER,
        		PASSWORD);

                try {
                    Connection conn = DriverManager.getConnection(uri);
                    return conn;
                } catch (SQLException e) {
                    System.out.println("Error getting connection.");
                    throw new DbException(e);
                }
            }
        }
        ```

    - (b) Create a statement (to perform one of the CRUD operations on a database)

        > `PreparedStatement` is used to send a SQL statement back to the database from the application's data layer. <sup>[[3](#source-3)]</sup>
        >
        > For example, you might have the following `try/catch` block inside a Class method:

        ```java
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            // set parameters
        }
        ```

    - (c) Execute a query

        > `PreparedStatement` also provides an `executeQuery()` method that is used to make SQL queries of a database.
        >
        > Following from the example code above:

        ```java
        stmt.executeQuery();
        ```

    - (d) Process the data retrieved,

        > The `ResultSet` class is used to store the data retrieved from a given query. <sup>[[3](#source-3)]</sup>
        >
        > For example:

        ```java
        try (ResultSet rs = stmt.executeQuery()) {
            // Do something with the data, like extract to a variable, etc.
        }
        ```

    - (e) Close the connection to the database

        > The `Connection` class provides a `close()` method to close a connection to a database. <sup>[[3](#source-3)][[4](#source-4)]</sup> Alternatively, connections are automatically closed when using a `try-with-resource` statement.
        >
        > For example:

        ```java
        // Using try-with-resource
        try (ResultSet rs = stmt.executeQuery()) {
            // Do something with the data, like extract to a variable, etc.
        } catch (SQLException e) {
            throw new DbException(e);
        }

        // Using close() with 'finally'
        try {
            stmt.executeQuery();
            // ...
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                // handle exception
            }
            try {
                stmt.close();
            } catch (Exception e) {
                // handle exception
            }
            try {
                conn.close();
            } catch (Exception e) {
                // handle exception
            }
        }
        ```

3. What are the two method calls to execute a query in JDBC, and when do you use each?

    > The two method calls are `executeQuery` and `executeUpdate`. <sup>[[5](#source-5)]</sup>
    >
    > You would use `executeQuery` to **read** data from a database (i.e. a `SELECT` statement). `executeUpdate` is used to **update** data in some way — like for `INSERT`, `UPDATE`, or `DELETE` statements.

## Resources Consulted

<a id="source-1"></a>1. [JDBC classes | IBM](https://www.ibm.com/docs/en/i/7.5?topic=classes-jdbc)  
<a id="source-2"></a>2. [JDBC (Java Database Connectivity) | Geeks for Geeks](https://www.geeksforgeeks.org/introduction-to-jdbc/)  
<a id="source-3"></a>3. [What are the main classes and interfaces of JDBC? | Tutorials Point](https://www.tutorialspoint.com/what-are-the-main-classes-and-interfaces-of-jdbc)  
<a id="source-4"></a>4. [Closing database connections in Java | StackOverflow](https://stackoverflow.com/questions/2225221/closing-database-connections-in-java)  
<a id="source-5"></a>5. [Processing SQL Statements with JDBC | Java Docs](https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html)  
