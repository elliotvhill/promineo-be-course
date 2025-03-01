# Week 14

Notes from week 14 class.

## Package setup, JPA, HTTP statuses

### Package setup

-   Package setup helps us organize the behavior of our code
-   For example:
    -   Controller package — this is all our REST code for http communication
    -   DAO package — this is our database code location
    -   Service package — this is where we put code to handle all logic for processing results
    -   Error package — this is where we want to put our code to handle errors

### JPA and annotations

-   JPA is designed to scan specific annotations and process those annotations
-   `@Entity`, `@Data`, `@Id` are examples of how JPA can read your Object and create the SQL for processing the data.
-   In our application.yaml file we will use these settings:

    ```yaml
    # application.yaml > jpa configuration
    # Note: YAML requires _spaces_ not _tabs_
    jpa:
        hibernate:
            ddl-auto: update
        show-sql: true
        defer-datasource-initialization: true
    ```

-   For enabling the JPA processing, we create a DAO Object that represents our Entity, for example in the pet-store:

    ```java
    public interface PetStoreDao extends JpaRepository<PetStore, Long> { // where the Long is the Primary Key of the PetStore object
        // do something
    }
    ```

### HTTP Statuses

-   HTTP verbs such as get put and delete represent actions. these actions will produce a **STATUS**
-   Example **STATUS**es are 200 (success), 300 (redirection), 400 (client error), 500 (server error)
-   CRUD is the Create, Read, Update, Delete
    -   C — HTTP `POST`
    -   R — HTTP `GET`
    -   U — HTTP `PUT`
    -   D — HTTP `DELETE`
