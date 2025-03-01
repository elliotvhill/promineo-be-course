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

## Pet Park — Update Contributor

#### Overview:

-   We'll add a **method** to modify an existing contributor
-   This is basically the same as the "Create Contributor" operation but `PUT` is used instead of `POST`
-   We only need to modify the controller because the service (save method) and DAO methods are already written

### The REST way...

-   We have to tell Spring which contributor we want to modify
-   This is done using the `@PutMapping` and `@PathVariable` annotations

```java
@PutMapping("/contributor/{id}")
ContributorData updateContributor(
    @PathVariable Long id) {
        // ...
    }
```

## Pet Park — Delete Contributor

#### Overview:

-   Learn how to delete a contributor
-   Use the HTTP `DELETE` method (verb)

### In the controller

-   Very similar to `GET` with ID
-   A `DELETE` with no ID means delete **all** contributors
    -   This is not allowed

```java
@DeleteMapping("/contributor/{id}")
public void deleteContributor(
    @PathVariable Long id) {
    }
```

## Pet Park — Create Location

#### Overview:

-   Create a Data Transfer Object (**DTO**) for pet parks _(similar to the ContributorData object)_
-   Write the controller `POST` method
-   Write the service method
-   Test it
-   Repeat for modify (`PUT`) method

### Pet Park DTO

-   `PetParkData` — similar to `ContributorData` but the focus is on the **park**, not the contributor
-   Contains an **inner class** for the contributor that does not have pet park as a recursive variable

### Controller `POST` method (Create)

-   The **REST** call looks like: `/pet_park/contributor/{ID}/park`
-   The `@PostMapping` is used for a create operation

### Controller `PUT` method (Update)

-   Basically the same as `POST`, but...
    -   Uses `@PutMapping`
    -   Must pass the park ID _(as well as the contributor ID)_ as a path variable
-   `@PutMapping` means "Update the park data"

### The service method

-   **Retrieve** the contributor by contributor ID
-   Retrieve all **amenities**
-   Create/retrieve the pet park object
-   **Set** the contributor in the pet park
-   **Set** the pet park in the contributor
-   **Set** the pet park in all amenities
-   **Set** the amenities in the pet park
-   Save the pet park
-   Hope it works!

### New DAOs

-   Create an **amenity** DAO to retrieve amenities
-   Create a pet park DAO to **save** the pet park

## Pet Park — Retrieve Pet Park

#### Overview:

-   A RESTful **discussion**
-   Add the **controller** method to retrieve a pet park by ID
-   Add the **service** method
-   **Test** it!

### A RESTful discussion

-   Contributor is the **primary** resource
-   A park location is a **sub-resource** of Contributor
-   In REST parlance: `/contributor/{contributorId}/park/{parkId}` — where `{contributorId}` is the **primary key** value of the contributor row, and `{parkId}` is the **primary key** value of the pet park row

### Add the controller method

-   Use the `@GetMapping` annotation
-   Use `@PathVariable` for contributor ID and park ID

### Add the service method

-   Create a `findPetParkById` method that throws a `NoSuchElementException` if the park isn't found
-   **Verify** that the contributor ID in the database is the same as the one requested
