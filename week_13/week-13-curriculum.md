# Week 13: Intro to Sprint Boot — Pet Park API

Notes from the week 13 curriculum— using Sprint Boot to build a Pet Park API.

### Content

-   Introduction to **Maven**
-   How to create a **Spring Boot** project

## Introduction to Maven

-   Maven is a project **build** tool
-   We are using it for **dependency** _(Java code packaged in a library)_ management
-   Built-in to Eclipse

## Create a Spring Boot project

-   Navigate to `https://start.spring.io`
-   Build the **POM (Project Object Model)** file, using the latest version of Spring Boot 3.x
-   **Paste** it into the Maven project
-   Create the main application class file

#### Main application file:

```java
@SpringBootApplication
public class PetParkApplication {
    public static void main(String[] args) {
        SpringApplication.run(
            PetParkApplication.class, args);
    }
}
```

#### `@SpringBootApplication`:

-   Enables **Component Scan** — Spring will load classes and libraries, starting at the package in which the annotation is found
-   Enables **Auto-configuration**

### Component Scan

-   Boot looks at every class in the **main package** and all sub-packages
-   Determines if Spring should manage the class:
    -   Called a "managed Bean" or **Bean**
    -   Spring creates a **single** instance
    -   Stashes it in an object **repository**
    -   We can request an instance using `@Autowired`
-   We will then write a **controller** class
-   Spring's component scan will **map** HTTP requests to Java methods that we write
-   We use annotations to tell Spring which HTTP **verb** (internet requests) to map the method

### Auto-configuration

-   Spring Boot examines the **classpath** and the application configuration
-   It sets up **functionality** _(i.e. Web application)_ based on what it finds
-   Spring creates a Web application if it finds the **Tomcat** dependency
-   Tomcat is loaded by `spring-boot-starter-web`

## Create Database Schema

Use MySQL **Workbench** to create:

-   Schema
-   User with permissions

In **Eclipse**:

-   Create `application.yaml`
-   (Possibly install YAML — *"YAML Ain't Markup Language"* — editor)
-   Add database configuration

## Create Table Entities

### Video Content

-   A look at the Pet Park Locations Entity Relationship Diagram (ERD)
-   Create the **entities** that Spring Java Persistence API (Spring JPA) will use to create the schema tables
-   JPA will **create** the tables for us

### Pet Park ERD

<img src="./pet-park-erd.png" alt="A screenshot of the pet park entity relationship diagram." />

### Create the JPA table entities

```java
@Entity // can specify the table name here
@Data
public class Contributor {
    @Id // primary key
    @GeneratedValue(strategy = ...)
    private Long contributorId;

    @Column(unique = true) // unique index
    private String contributorEmail;

    @OneToMany(mappedBy = ...)
    private Set<PetPark> petParks;
}
```

### Embed an object in an entity

-   Need to use the `@Embedded` annotation and then `@Embeddable` in the class that gets embedded

```java
@Entity
public class PetPark {
    @Embedded
    private GeoLocation geolocation;
}

@Embeddable
public class GeoLocation {
    // ...
}
```

## Create Table Data

-   In Eclipse, we will create **data** for the `amenity` table
-   Spring Boot will automatically **execute** a file with SQL `INSERT` statements: `src/main/resources/data.sql`

## Create JPA Configuration

-   Add the JPA and Spring Boot **configuration** into `application.yaml`
-   Start the application and show that the tables are **created** by JPA and **populated** by Spring Boot

### Configuration — `application.yaml`

#### Three configuration sections:

1. `spring.datasource`: database **connection** instructions
2. `spring.jpa`: **JPA** setup instructions
3. `spring.sql`: Spring data **instructions**

#### Adding JPA config to `application.yaml`:

-   `hibernate:` — an **Object Relational Mapper (ORM)** library which takes the entities and converts them into SQL statements (to create tables and relationships)
    -   `ddl-auto: create` — have Hibernate create the tables _(initially; after will use "update")_
-   `show-sql: true` — shows the SQL statements
-   `defer-datasource-initialization: true` — tells Spring Boot to wait until Hibernate has finished creating tables before inserting data

### Verify table creation

-   We will use **DBeaver** to verify that the tables have been created and populated.
-   Here are the rules:
    -   Use **MySQL Workbench** to create the schema, user, and password — and to give privileges to the user
    -   Use **DBeaver** for everything else — queries, inserts, etc.

## Create Contributor Operation

-   Explain the **parts** of a Spring Boot application
-   Code the classes needed to **perform** the "Create Contributor" operation
-   Develop **JSON** that will be used to create a `contributor`
-   Explain the HTTP **POST** method
-   Add **transaction** management

### The anatomy of a Spring Boot application

1. **Controller** (class) — handles HTTP requests — `ParkController.java`
2. **Service** (class) — manages business logic — `ParkService.java`
3. **DAO** (interface) — interacts with database — `ContributorDao.java`

### Once the Java is created...

-   Use a **REST** client to send JSON to the running application
-   We will use Advaced REST Client (**ARC**) from MuleSoft

### JSON vs. Java

-   Must look **exactly** like the receiving class

#### JSON:

```json
{
    "contributorName": "Sandy Blotts",
    "contributorEmail": "sandy@blotts.r.us"
}
```

#### Java:

```java
class ContributorData {
    Long contributorId;
    String contributorName;
    String contributorEmail;
}
```

### A look at HTTP

-   HTTP is an **abbreviation** for **H**yper**t**ext **T**ransfer **P**rotocol
-   HTTP is just **text** sent over the internet
-   HTTP consists of a **request** and a **response**

### HTTP Request

-   Request Line:

    -   HTTP verb + URI + HTTP version

        ```
        GET /pet_park HTTP/2.0
        POST /pet_park HTTP/2.0
        ```

    -   Common HTTP verbs (CRUD):
        -   `POST` (Create)
        -   `GET` (Read)
        -   `PUT` (Update)
        -   `DELETE` (Delete)

-   Request Headers:

    -   Describe the request and allowed response format(s)

        ```
        Accept: application/json
        Content-Type: application/json
        ```

-   Request Body (JSON):
    -   Used for `POST` (Create) and `PUT` (Update)
    -   Written as valid **JSON**
    -   Also called the request **payload**

### HTTP Response

-   Status Line:

    -   HTTP version + status code + reason

        ```
        HTTP/2.0 200 OK
        HTTP/2.0 404 Not Found
        HTTP/2.0 409 Conflict
        ```

-   Response Headers:
    -   Very **similar** to request headers and body
    -   Response headers may be different than the request headers, but they are still **key: value** pairs
-   Response Body (JSON)
    -   Body (payload) is **JSON**

### Setting up

-   We will create **Data Transfer Objects** (**DTO**s) for the request and response instead of entities
-   This is because Jackson (JSON generator) freaks out with the recursive nature of entities:

    ```java
    class Contributor {
        List<PetStore> petStores;
    }

    class PetStore {
        Contributor contributor;
    }
    ```

### The `POST` request

-   Use Advanced Rest Client (ARC) to send a `POST` request with JSON payload to the service running in Eclipse: `http://localhost:8080/pet_park`
-   A `POST` request returns status `201` (Created) if successfull

### Transaction management

-   In a transaction, a **group** of SQL statements will either _all_ succeed or _all_ fail — there is no partial success
-   In Spring Boot, transactions are started by adding _`@Transactional`_ to a public method in the service class
-   If an exception is thrown, the transaction "**rolls back**"
-   If an exception is not thrown, the transaction is "**committed**"
