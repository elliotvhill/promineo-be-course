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

## Additional content

Notes from the "break out" videos.

## Spring vs. Spring Boot

-   What is **Spring**?
-   What is **Spring Boot**?
-   How do they work together?

### What is Spring?

-   Spring is a development and runtime **framework** for Java
-   Spring provides the following **features**:
    -   Component **Scan**
    -   Object lifecycle **management**
    -   Inversion of Control (**IoC**)
    -   Dependency Injection (**DI**)
    -   Common **logging** framework
    -   **Tools** for common solutions

### Component Scan

-   When Spring starts up, it loads and **scans** all classes looking for objects to manage
    -   _`@Service`_
    -   _`@Controller`_
    -   _`@Component`_
    -   etc.
-   Spring stores managed objects in a **registry** and makes them available for the application

### Object lifecycle management

-   A Spring-managed object is called a "**Managed Bean**" or "**Bean**"
-   Spring creates Beans and allows the application to **hoook** into lifecycle events
-   Applications can hook into post-create methods for **initialization** purposes
-   Applications can hook into pre-destroy methods for **cleanup**

#### For example:

```java
@Component
public class MyClass {
    @PostConstruct // Spring automatically calls the method after all the Beans have been created
    public void setup() {
        // Initialize class here
    }
}
```

### Inversion of Control (IoC)

#### "Normal" application:

-   In a "normal" Java application **you** write code in the main method
-   **You** make method calls and create objects
-   When finished, the application **exits** from the main method

```java
public static void main(String[] args) {
    // Call stuff
    // Do stuff
    // Exit now
}
```

#### Inversion of Control (IoC):

-   Spring **manages** object lifecycles
    -   Creation
    -   Initialization
    -   Destruction
-   You write code that "**hooks**" into object lifecycle events
-   Spring **calls** that code when a lifecycle event is triggered
-   To an observer, code execution appears **non-linear**

#### IoC Example:

```java
@Component // makes the class eligible for Spring management
@ComponentScan // begins the component scan
public class MyClass {
    public static void main(Stringp[] args) {
        try (AbstractApplicationContext ctx =
            new AnnotationConfigApplicationContext(MyClass.class)) {
                // code
            }
    }

    @PostConstruct
    public void run() {
        System.out.println("I am running!");
    }
}
```

### Dependency Injection (DI)

-   Beans can **request** other Beans
-   This is called Dependency Injection (DI) or just **Injection** — Spring is able to populate instance variables based on Beans it has created
-   Use the `@Autowired` annotaion for this

#### Example:

```java
@Service
public class MyService {
    public void doTheThing() {
        // Do something
    }
}

@Component
public class MyClass {
    @Autowired
    private MyService myService;

    @PostConstruct
    public void init() {
        myService.doTheThing();
    }
}
```

### Common logging framework

-   Spring provides a **custom implementation** of Apache Commons Logging
-   When the app is deployed, almost any logging **framework** can be used:
    -   Logback
    -   Log4j
    -   Java Util Logging
    -   etc.
-   Common logging across the enterprise allows for **automation**
-   But — you must set up all the logging **dependencies** and the initialization yourself

#### Example:

```java
@Component
public class MyClass {
    private static final Logger log = LogFactory(MyClass.class);

    @PostConstruct
    public void init() {
        log.info("In the init method!");
    }
}
```

### Tools for common solutions

-   Spring provides tools for **common** solutions:
    -   `DispatcherServlet` for Web (REST) applications — set up to call methods in a Controller class and maps HTTP requests to methods
    -   Java **configuration** support for Web applications
    -   Framework for **SOAP (Simple Object Access Protocol)** Web applications
    -   **APIs** for JDBC, JPA, messaging (queue, SMS)

### If Spring does all this, why Spring Boot?

-   Whereas you _can_ create complex and wonderful applications with Spring, it is often **HARD**
-   Once you figure out a solution, you **reuse** it over and over again
-   This leads to brittle, **archaic** code
    -   Spring adds **features** but you don't know about or utilize them if you don't make the **effort** to stay current

### What is Spring Boot?

### Spring Boot offers opinionated oversight

-   Through **auto-configuration**, Boot determines what you are trying to do
-   Spring Boot examines the **classpath** to see what's there
-   Spring Boot then **configures** the application for the most common usage

#### Web example:

-   If Boot finds `spring-boot-starter-web` on the classpath, it:
    -   Automatically creates a **dispatcher servlet** (i.e. routes Web requests to controller methods)
    -   Configures an embedded **Tomcat** Web application server to work with the application
    -   **Maps** HTTP requests to specific controller methods

#### JPA example:

-   If Boot finds `spring-boot-starter-jpa` on the classpath, Boot:
    -   Creates a **transaction** manager
    -   Creates a **data source** to manage connections
    -   Creates a **connection pool** to reuse connections
    -   Scans for JPA **entities**
    -   Automatically **connects** to the database

### Spring Boot configuration

-   Spring Boot has automatic configuration for **dozens** and dozens (perhaps hundreds) of application types
-   Check out the dependency list at https://start.spring.io

### Spring Boot logging

-   Spring Boot **automatically** configures the **Simple Logging Façade for Java (SLF4J)** and adds required dependencies
-   Spring Boot automatically provides support for the **Logback** logging framework
-   With no developer support, logging is **enabled** out of the box

### Spring Boot Actuator

-   Spring Boot supports application metrics collection with **Micrometer**
-   Metrics are automatically collected at **boundary** points such as:
    -   HTTP requests (count and timing)
    -   Database requests (count and timing)
    -   Scheduler requests (e.g. Quartz)
-   Out-of-the-box support for metrics aggregators like **Prometheus**

### So what's the difference between Spring and Spring Boot?

-   Spring provides the **framework**
-   Spring Boot provides the **access**

## Spring JPA vs. Spring JDBC

A look at Spring JPA and Spring JDBC:

-   What's the difference?
-   Pros and cons of **each**
-   Where is the **industry** going?
-   What is Promineo teaching and **why**?
-   How does **Java** JDBC fit in?
-   **Coding** Spring JPA vs. Spring JDBC

### Spring JPA vs. Spring JDBC — what's the difference?

-   **JPA**: Java Persistence API
-   **JDBC**: Java Database Connectivity
-   Spring **JPA**:
    -   Built on the Hibernate Object/Relational Mapping (ORM) tool
    -   Not "true" JPA (like Hibernate) but built _on top_ of Hibernate
-   Spring **JDBC**:
    -   Templated approach built on Java JDBC
    -   Not Java JDBC, but built _on top_ of Java JDBC

### Spring JPA

-   Relational databases (**RDBMS**) define relationships as:
    -   One-to-one
    -   One-to-many
    -   Many-to-many
-   Java _(and other OOP models)_ relationships are:
    -   **Is A**... (inheritance)
    -   **Has A**... (instance variable)
    -   **Uses A**... (local variable)

Java knows about objects, **inheritance**, and embedded objects. Relational databases **don't** know about any of those things.

An **ORM** (in this case, Hibernate) attempts to **bridge** the gap between Java and relational databases.

#### Hibernate:

-   automatically **populates** (i.e. `INSERT` statements, etc. — but not initializations) tables and Java classes
-   automatically **maintains** the database relationships
-   will **create** tables, but not _initialize_ them

#### Spring JPA:

-   _will_ populate/initialize tables with **data**
-   provides many **common** methods in the Data (DAO) layer
-   creates DAO-layer methods based on programmer-supplied method **names** (via an interface)

#### Spring JDBC:

-   provides **templates** that sit _on top of_ Java JDBC
-   saves the programmer from (mostly) having to **interact** with Java JDBC directly
-   takes the **drudgery** out of Java JDBC by writing boilerplate code
-   handles transactions correctly by **managing** exceptions
-   makes all exceptions **unchecked**

### Spring JPA pros and cons

#### Pros:

-   Loads Java **objects** from table data
-   Loads **tables** from Java object data
-   Can **create** tables
-   Maintains table **relationships**
-   Programmer can write custome **queries** using special naming of methods in an interface _(Spring JPA provides the implementation)_
-   Isolates/**protects** programmers from themselves

#### Cons:

-   Can **create** tables
-   Oftentimes _very_ **inefficient**
-   Relationships are modeled with **recursive** variables, which means:
    -   Can't print entities
    -   Can't compare entities
    -   Can't easily transform a Java entity to JSON using the Jackson library
-   Hard to **debug** issues
-   Isolates/**protects** programmers from themselves

### Spring JDBC pros and cons

#### Pros:

-   JDBC **templates** mean:
    -   No more exception handling
    -   No more closing resources
    -   Transactions are handled with a single annotation
-   All **boilerplate** code is already written
-   The programmer just **writes**:
    -   The queries
    -   The code to populate Java objects from a `ResultSet`
-   With good SQL, JDBC is very **efficient**

#### Cons:

-   Java objects are **not** populated automatically
-   The programmer writes **more** code than with JPA
-   The programmer must know **SQL** in order to write the queries

### Where is the industry going?

-   A quick perusal of Internet **documentation** shows most newer tutorials/how to documents favor JPA.
-   There is a kind of **_mythos_** that programmers must be protected from themselves _(this is not entirely without merit...)_
-   JPA is a high-level abstraction that **bridges** object-oriented languages with relational databases

It appears, then, that the industry is moving towards adopting **JPA** vs. JDBC. Spring Boot shops appear to favor Spring **JPA** over Spring JDBC.

#### What is Promineo teaching and why?

Based on the perceived industry direction (always **risky** when analyzed from the _before_ perspective), Promineo is teaching Spring JPA as part of the Spring Boot course.

### How does Java JDBC fit in?

-   In the MySQL part of the course, you learned **Java** JDBC
-   Java JDBC is a **low-level** API that is:
    -   Hard to use
    -   Easy to miss closing resources
    -   Extremely verbose, requiring _lots_ of supporting code
-   But both Spring JPA and Spring JDBC are built on **top** of Java JDBC
-   Both are **high-level** abstractions _(i.e. simplifications)_ of the low-level API

<!-- ### Coding the One-to-Many Relationship in JPA -->

<!-- ### Coding the Many-to-Many Relationship in JPA -->

<!-- ## Dependency Injection -->

<!-- ## Lombok Explained -->

<!-- ## Spring Boot Test Framework -->

<!-- ## Porting the Recipe App (from MySQL videos Weeks 7-11) -->

<!-- ## Building the Final Project -->
