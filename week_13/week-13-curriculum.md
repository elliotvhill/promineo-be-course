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

<!-- ## Create Maven Project -->

<!-- ## Create Database Schema -->

<!-- ## Create Table Entities -->

<!-- ## Create Table Data -->

<!-- ## Create JPA Configuration -->

<!-- ## Create Contributor Operation -->
