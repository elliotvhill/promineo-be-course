# Week 15 Video Curriculum Notes

Notes from the week 15 video curriculum.

## Introduction

### Recap of Weeks 13 & 14

-   Created a **REST** API that maintained pet park locations
-   Learned how to create a **Spring Boot** application
    -   Configuration
    -   Spring Java Persistence API (**Spring JPA**)
    -   The anatomy of a Spring Boot application
    -   Table entities
-   Performed **CRUD** operations

### Week 15 Overview

-   An introduction to the Dog **Rescue** API
-   Many of the things you learned in the Pet Park Location API
-   **Plus**, how to use the Spring Boot Test Framework to validate the coding
-   In this API, Spring Boot will **both** create _and_ populate tables
-   **JPA** will perform CRUD operations

### Dog Rescue API

-   A simple API with three tables: `location`, `dog`, and `breed`
-   Tracks dogs at different locations
-   Each location can have many dogs (**one-to-many**)
-   A dog can be more than one breed, and a breed consists of more than one dog (**many-to-many**)

## Dog Rescue — Create Maven Project

### Overview

-   Create the Spring Boot **application**:
    -   Maven
    -   Spring Initializr
    -   Main application class

### Recap: Maven

-   Maven is an application build tool
-   We are using it to manage application **dependencies** (like Spring Boot)
-   Maven keeps track of the project in a Project Object Model (**POM**)
-   The POM is physically expressed in `pom.xml`

### Recap: Spring Boot project

-   We use the Sprint **Initializr** to create the POM — `https://start.spring.io`
-   Add Web, Lombok, MySQL, JPA, H2
-   Use latest Spring Boot **3.0x**

### Recap: Main application class

-   Create class with `main()` method in top-level package
-   Add `@SpringBootApplication`, which triggers:
    -   Auto-configuration
    -   Component Scan
-   Start Spring **Boot** by calling `SpringApplication.run()` from the `main()` method

## Dog Rescue — Create Table Entities

### Review the table entities

-   **Entities**: Dog, Location, Breed
-   **Review**: Spring uses **Hibernate** as the Object-Relational Mapping (ORM) tool that powers JPA
-   **Project**:
    -   JPA will manage the CRUD operations
    -   Spring will create and populate the tables
    -   This will help us write tests

### Recap: Entity

-   Maps from data tables to objects
-   JPA looks for `@Entity` to identify the class as an entity
-   The identity field (primary key) is annotated with `@Id` and `@GeneratedValue`
    -   `@Id` identifies the field as the identity field
    -   `@GeneratedValue` tells JPA how MySQL manages the primary key value

### Recap: One-to-many

-   "Owning" class has the `@OneToMany` annotation
    -   Specifies the cascade strategy
    -   Defines orphan removal behavior
-   "Owned" class has the `@ManyToOne` annotation
    -   Can specify a join column (used if JPA doesn't create the tables but just manages them)

### Recap: Many-to-many

-   "Owning" class has the `@ManyToMany` and `@JoinTable` annotations
    -   Defines a cascade strategy
    -   Specifies a join table definition
-   "Owned" class has `@ManyToMany`
    -   Declares the `mappedBy` attribute (name of the Java field in the owning class)

### Recap: Relationship essentials

-   The "many" side of a relationship uses a Java **Set**
-   You can also use a **List**, but using a Set makes managing the relationships easier
    -   You can just add to a Set, and it will **add** or **replace** the appropriate child row
    -   With a List, you would need to do a lookup on the list to find the correct child element

### Recap: Child row update

-   Use the **cascade** attribute of `@ManyToMany` and `@OneToMany` to tell JPA to automatically update or insert child rows when a parent row is saved

    ```java
    @OneToMany(
        cascade = CascadeType.ALL
    )
    ```

## Dog Rescue — Create DDL and DML Files

### `schema.sql`

-   Create in `src/main/resources` folder
-   Contains `CREATE TABLE` statements

### `data.sql`

-   Create in `src/main/resources`
-   Contains `INSERT` statements to add data to tables

### Using `.sql` files

-   Spring JPA uses `schema.sql` to automatically **create** tables
-   Spring JPA uses `data.sql` to automatically **populate** tables
-   We won't let JPA (**Hibernate**) create the tables because we will use `schema.sql` and `data.sql` to manage data in tests

## Dog Rescue — JPA Configuration

-   Create JPA and Spring **configuration** in `src/main/resources/application.yaml`
-   Test to see that the tables are created and populated **successfully**

### Recap: `application.yaml`

-   Three sections:
    -   `spring.datasource` contains **schema** name and credentials
    -   `spring.jpa` contains configuration for Spring **JPA**
    -   `spring.sql` contains **instructions** on how to load `schema.sql` and `data.sql`

<!-- ## Dog Rescue — Create Location -->
