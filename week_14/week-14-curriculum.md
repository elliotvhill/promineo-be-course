# Week 14 Video Curriculum Notes

Notes from the week 14 video curriculum.

## Overview

-   Retrieve contributors using HTTP `GET`
-   Implement a global **error handler**
-   Update contributors using HTTP `PUT`
-   Delete contributors using HTTP `DELETE`
-   How to **customize** the Spring Boot DAO interface
-   Write **create** and **modify** operations for pet park locations
-   Write a "**Retrieve**" operation for pet park locations

## Pet Park — Retrieve Contributor

### Overview:

-   A look at the HTTP `GET` method
-   Write the "Retreive All Contributors" operation
-   Write the "Retrieve contributor by ID" operation
-   Explain HTTP status **200**

### HTTP `GET` method (verb)

-   Used to retrieve information
-   Does not change the **state** of the data
-   Does not contain a JSON body
-   Send `GET` to `/pet_park/contributor` at `http://localhost:8080`

### Two methods...

```java
@GetMapping("/contributor")
public List<ContributorData> retrieveAllContributor()

@GetMapping("/contributor/{id}")
public ContributorData getContributorById(
    @PathVariable Long id)
```

Returns `200` status by default

## Pet Park — Global Error Handler

#### Overview:

-   How to gracefully handle errors (**theory**)
-   How to gracefully handle errors (**code**)

### The problem

-   What happens when we add **another** contributor with the same email as an existing one?
    -   We get an unhelpful `java.sql.SQLIntegrityConstraint-ViolationException`
-   We need to **parse** the exception message to see that it is a duplicate key exception (that's bad — exception messages change all the time, not good practice to rely on the message itself)

### Why is this a problem?

-   Spring returns a `500` status (Internal Server Error) for any **unhandled** exception
-   The real status should be `409` (**Conflict**)
-   We can **fix** this by throwing a more specific exception and handling it in a **global error handler**

### The solution

```java
// Pseudo code
class ParkService {
    public saveContributor(...) {
        if (contributor email exists) {
            throw new DuplicateKeyException()
        }
    }
}

@RestControllerAdvice // tells spring that this is a global error handler
class GlobalErrorHandler {
    @ExceptionHandler(
        DuplicateKeyException
    )
    public ... handleErr() {
    }
}
```

### In the code...

-   Throw `DuplicateKeyException` if contributor already exists
-   Throw `NoSuchElementException` if contributo is not found
-   Create global error handler to **manage** the exceptions

<!-- ## Pet Park — Update Contributor -->

<!-- ## Pet Park — Delete Contributor -->

<!-- ## Pet Park — Create Location -->

<!-- ## Pet Park — Retrieve Pet Park -->
