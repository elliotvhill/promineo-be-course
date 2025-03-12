# Week 16 Video Curriculum Notes

Notes from the week 16 video curriculum.

## Introduction

### Recap — weeks 13 & 14:

-   Created a Pet Park Location **REST API**
-   Learned to work with Spring **JPA**
    -   Configuration
    -   Entities
    -   Relationships

### Recap — week 15:

-   Started **Dog Rescue** REST API
-   Created the Maven/Spring Boot project
-   Created the database schema
-   Created JPA **entities**
-   Created `schema.sql` (to create tables) and `data.sql` (to populate tables)
-   Set up the JPA configuration
-   **Coded** the "Create Location" operation

### What's happening in week 16:

-   Fill out **CRUD** operations for dog rescue locations
-   Create rows in the **dog** table
-   Delete location and show that it deletes dog child rows as well
-   Write **integration tests** for all operations
    -   _Next video:_ we will create an integration test for the "Create Location" operation. We will use the H2 **in-memory** database for the tests and set the data to a known state before each test.

## Dog Rescue — Insert Location Test

### Overview

-   Set up the Spring Boot **Test** Framework to write an integration test that tests the service method for the "Insert Location" operation
    -   Difference between **integration** and **unit** test:
        -   A **Unit test** tests a single method, generally doesn't allow any code to go out beyond that method without being mocked or stubbed
        -   An **Integration test** tests the actual functionality of the entire application (or a large portion)
-   Use the **H2** (in-memory database) to store data for the tests
-   Investigate the `@SpringBootTest` annotation
-   Create a test **profile**
-   Run the test

### Spring Boot Test Framework

-   Tests are **managed** by JUnit 5 (AKA Jupiter)
-   Individual tests are **run** by the Spring Boot Test Framework
-   A test **profile** is set up for the tests, which allows us to write test configuration that overrides the main application configuration
-   Specific test **configuration** is loaded
-   An **in-memory** database is used for the tests (H2)
    -   Advantage of using H@ is that **all** tables are dropped, created, and populated before each test
-   An advantage of the Spring Boot Test Framework is that Spring creates an **application context** for the tests
    -   This means that we can inject dependencies using `@Autowired`

### Test format

-   Use Martin Fowler's (ThoughtWorks) test method **organization**:
    -   **Given:** (a precondition)
    -   **When:** (the test is executed)
    -   **Then:** (the results are evaluated)
-   Tests are **clean** and organized

### H2 database

-   H2 is an **in-memory** database
-   It is extremely **fast**
-   The tables can be dropped, created, and populated before **each** test
-   This is important for **automating** tests because:
    -   If the data is not in a **known** state, the tests will be _non-deterministic_
    -   If the tests are non-deterministic you **don't** know the reason for failure

### `@SpringBootTest` is a combo annocation

-   It sets `SpringExtension.class` as the **class** controlling the tests
-   It sets a **configuration** class for the tests
-   It creates an application **context** for the tests:
    -   Application contexts contain a Bean **Registry** (Spring will manage Beans with lifecycle management)
    -   This means we can use **Dependency Injection** for the tests (using `@Autowired`)
    -   The test runs in a Spring Boot **environment**

### Create a test profile

-   Create `application-test.yaml` in `src/test/resources`
-   This configuration file is merged with and overwrites `application.yaml`
-   Configuration is created that applies to **tests** but _not_ the running application
-   This means we can connect to MySQL in application mode and **H2** in test mode

### Use AssertJ to manage test assertions

-   An **assertion** in a test determines if something is true or false or is equal to some value
-   For example, assert that a result is **equal** to some expected value
-   AssertJ is a **natural language** assertion library — it allows assertions to be easily read and **understood**

## Dog Rescue — Retrieve Location by ID

### Overview

-   Write the "Retrieve by Location ID" **operation** methods in:
    -   Controller class
    -   Service class
-   Write the **test**

### Write the controller method

-   A retrieve operation uses the HTTP `GET` verb (method)
-   It returns a `100` (OK) status if successful
-   The location ID is passed in the REST resource request — `dog_rescue/location/{ID}` — where `{ID}` is the location ID
-   We tell Spring about the REST resource ID using `@PathVariable` in the parameter list
-   The method simply logs the request and calls the rescue **service**

### Write the service method

-   Service methods run within a **transaction**
-   As such, they are _public_ and have the `@Transactional` annotation
-   The service method calls the helper method `findLocationById`
-   It returns a `LocationData` object
-   There is **no need** to add a method declaration to the DAO interface

### Write the test

-   The test is simple: **insert** a location and retrieve it
-   **Compare** the retrieved value to the expected value

## Dog Rescue — Retrieve All Locations

-   Write the "Retrieve All Locations" methods in:
    -   `Controller`
    -   `Service`
-   Write and run the test

### Write the controller method

-   Add method `retrieveAllLocations()`
-   Add the `@GetMapping` annotation
-   The REST request will be sent to `dog_rescue/location`
-   We don't need to pass an ID as a parameter as we are returning **all** resources
-   Log the request
-   Call the service

### Write the service method

-   Add public method `retrieveAllLocations()`
-   Add the `@Transactional` annotation
-   Call the `findAll()` method in the DAO
-   Convert the `List` of `Location` to a `List` of `LocationData`

### Write the test

-   Create the test method `testRetrieveAllLocations()`
-   Add the `@Test` annotation
-   Create two locations
-   Call the controller **receive** method
-   **Assert** that the actual Objects returned are what we expect
-   Run the test and demonstrate the **green** bar

### Easier than JDBC?

-   If this seems simpler than JDBC, it's because Spring and Spring Boot are doing most of the work for us
-   **Someone** wrote all the supporting code, but it wasn't us

<!-- ## Dog Rescue — Update Location -->

<!-- ## Dog Rescue — Delete Location -->
