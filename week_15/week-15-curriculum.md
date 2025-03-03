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

<!-- ## Dog Rescue — Create Database Schema -->

<!-- ## Dog Rescue — Create Table Entities -->

<!-- ## Dog Rescue — Create DDL and DML Files -->

<!-- ## Dog Rescue — JPA Configuration -->

<!-- ## Dog Rescue — Create Location -->
