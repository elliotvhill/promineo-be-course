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

<!-- ## Create Contributor Operation -->
