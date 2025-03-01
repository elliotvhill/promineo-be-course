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
