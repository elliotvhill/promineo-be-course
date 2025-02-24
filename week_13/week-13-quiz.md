# Week 13 Spring Boot quiz

### 1. What is the Spring Initializr used for?

-   A. To initialize auto-configuration, which properly configures your application.
-   **B. To add dependencies to the application and set up pom.xml.**
-   C. To start Spring Boot.
-   D. To ensure that Spring Boot runs with no errors.

### 2. To start Spring Boot:

-   A. Run the Component Scan.
-   B. From the Command Prompt (Windows) or Terminal (MacOS) window, type `run spring-boot`.
-   **C. Call `SpringApplication.run()` from a `main()` method**
-   D. Do nothing. Spring Boot starts itself when the dependency is found in the class path.

### 3. The Component Scan:

-   A. Runs when you annotate a class with `@ScanApplication`.
-   B. Enables Auto-Configuration in which Spring Boot automatically configures the application.
-   C. Always runs in the parent package of the `main()` application class.
-   **D. Is used by Spring to create Managed Beans.**

### 4. In the week 13 Videos, MySQL Workbench was used to:

-   **A. Create a schema, a user and assign permissions.**
-   B. Configure the MySQL database.
-   C. Insert rows into a table.
-   D. Write all MySQL statements for the application.

### 5. As shown in the week 13 videos, in a Spring Boot application, configuration is supplied by:

-   A. `application.xml` in the `src/main/configuration` directory.
-   **B. `application.yaml` in the `src/main/resources` directory.**
-   C. `application.properties` in the project root directory.
-   D. `config.yaml` in the `src/main` directory.

### 6. In the week 13 videos, a Data Transfer Object (DTO) is used to:

-   A. Provide application configuration when the main configuration file is missing.
-   B. Transfer data to the data (DTO) layer.
-   C. Provide visibility into the Project Object Model (POM).
-   **D. Populate a Java object from JSON data and vice versa.**

### 7. `@Entity` tells Spring Boot to embed an object inside a many-to-many relationship.

-   **A. false**
-   B. true

### 8. The `@GeneratedValue` annotation:

-   A. Tells Spring JPA to create a join table with the given name.
-   B. Creates primary key values before inserting a row into a data table.
-   **C. Instructs Spring JPA as to how the primary key is managed.**
-   D. Identifies the identity (primary key) column.

### 9. If `@OneToMany` is used in a JPA entity, which annotation would you expect to find in the related entity?

-   A. `@OneToAll`
-   B. `@OneToMany`
-   **C. `@ManyToOne`**
-   D. `@ManyToAll`

### 10. Which of the following is true?

-   A. Spring JPA can be used to automatically populate tables using data stored in a JPA entity.
-   B. Hibernate is used to pause a database connection.
-   **C. Spring Boot can automatically populate tables when it finds data.sql in the src/main/resources directory.**
-   D. Spring JPA is used to populate tables but not create them.

### 11. In the week 13 videos, a table was populated by writing:

-   A. SQL statements in schema.sql
-   B. SQL statements in data.sql.config
-   C. JPQL statements in schema.jpql
-   **D. None of the other statements are true.**

### 12. The videos showed that Spring Boot populated a table when the configuration item `spring.jpa.auto-populate` is set to `true`.

-   **A. false**
-   B. true

### 13. Which are the three configuration sections discussed in the week 13 videos:

-   **A. spring.jpa, spring.sql, spring.datasource**
-   B. spring.database, spring.jdbc, spring.sql
-   C. spring.database, spring.jpa, spring.sql
-   D. spring.datasource, spring.jpa, spring.logging

### 14. Which tool was used to verify that the schema tables were created and populated?

-   A. SQuirreL
-   B. MySQL CLI
-   C. MySQLWorkbench
-   **D. DBeaver**

### 15. Which statement is incorrect?

-   A. The type of object created for the DAO (data) layer was an interface.
-   B. The controller handles HTTP requests.
-   **C. An HTTP POST request is used to modify existing data.**
-   D. The service class was annotated with @Service so that the Component Scan would identify it as a Managed Bean.

### 16. The JSON object names must match the Java object field (instance variable) names exactly or the fields won't get populated correctly.

-   A. false
-   **B. true**

### 17. The HTTP verb used tells the application which CRUD operation to perform.

-   **A. true**
-   B. false

### 18. Which best describes the HTTP verb and the CRUD operation requested?

-   A. POST=Create, GET=Read, PUT=Update, DEL=Delete
-   **B. POST=Create, GET=Read, PUT=Update, DELETE=Delete**
-   C. PUT=Create, GET=Read, POST=Update, DEL=Delete
-   D. CREATE=Create, READ=Read, UPDATE=Update, DELETE=Delete

### 19. The two HTTP headers used to describe the payload as shown in the week 13 videos were:

-   **A. Accept: application/json and Content-Type: application/json**
-   B. Expect: JSON and Content-Type: JSON
-   C. Response: json, and Request-Length: 58
-   D. Accept: application/json and Request-Type: application/json

### 20. The request body is also referred to as the content body.

-   **A. false**
-   B. true
