## Instructions

For this assignment, you will begin brainstorming and creating a proposal for your Spring Boot Final Project. Begin brainstorming ideas and come up with one you (and your group if you choose) feel fulfills all the requirements listed below. Your proposal can be approved during class in **Week 15 by your instructor, or by your mentor**, and finalized by the end of Week 15.

A simple template for your proposal is included below.  Think about your database design first.  It is often helpful to create an ERD of your tables and columns, including all relationships (PK/FK connections and join tables).

**NOTE: You will _not_ be turning anything in for this assignment this week.**

## Requirements

### Project Requirements

#### 1-person Project:

-   Database design which contains at least 3 entities and 3 tables
-   Contains all CRUD operations (Create, Read, Update & Delete)
-   **Each entity** should have at least one **CRUD operation**
    -   **AND:**  one or more entities needs to have **all 4 CRUD operations** (Create, Read, Update & Delete).
-   Contains *at least* one (1) **one-to-many** relationship
-   Contains *at least* one (1) **many-to-many** relationship with one or more CRUD operations on this relationship
    - **Required**: **REST Web API Server** tested through Swagger, Postman or **AdvancedRestClient (ARC)** or a front-end client.

#### Group Project (max 3 people):

-   Database should have at least two tables per group member + one.
-   Contains 2 entities per person, plus 1 entity done together at the beginning to solidify the structure expected for the project.
-   Each member of the group is required **to code their entities top to bottom —** entity, controller, service, & dao/repository.
-   Each member of the group is required to:
    1. Implement CRUD operations on each of their entities
    2. Implement **all 4 CRUD operations** (Create, Read, Update, & Delete) on at least one of their 2 entities
-   Contains *at least* one (1) **one-to-many** relationship
-   Contains *at least* one (1) **many-to-many** relationship with one or more CRUD operations on this relationship
-   **Required:** **REST Web API Server** tested through Swagger, Postman or **AdvancedRestClient (ARC)** or a front-end client.

<!-- ## Proposal Template

#### *(Copy and paste the* Proposal Template *section into a document to complete.)*

**Project Participants**:

List all group members here. Just write your name if you are working solo.

**Title**:

Come up with a simple title.

**Executive Summary**:

This is where you will describe what your project is intended to do.

Remember, this project should be completed in **3 weeks time**. If you can’t explain it in 1-2 paragraphs, you may need to scale it back so you can complete your initial features on time.

**Initial Features**:

**Create a bulleted list of Initial Features**.  This will be a list of features that meet the requirements of the final project.

-   Database Design -- maybe an ERD which demonstrates the design.
-   A bulleted list of planned features you will complete in your project by the deadline.
-   A list of API endpoints for each feature.  *If you are working in a group, please note which team member will be assigned to each feature.*

    _Example of list of Features/Endpoints for a Library API:_

    -   _Entity Ideas: Users, Administration, Books, Genre, Checkout, BookReviews, etc._
    -   _Operation (Endpoint) Ideas:   (Think:  what can a User (or Client Application) do when they use this REST API)_
    -   _Login, and use system_
    -   _Browse all Books (GET on Books)_
    -   _Browse Books by genre (GET on Books with genre specified)_
    -   _View all details about a specific Book (GET on Books by primary key)_
    -   _Leave review on a Book (POST in BookReviews)_
    -   _Read reviews on a Book (GET on BookReviews)_
    -   _Checkout X amount of books at a time (POST in Checkout), set dueDate for 2 weeks from today (e.g. Checkout Date) and (PUT Change Status of Book to Unavailable)_
    -   _Return a Book (PUT Change Status of Book to Available, PUT Checkout to RETURNED status, POST Fee on Users, by primary key, if the book is past due, etc.)_

**Stretch Goals (to be completed if time allows, or after graduation)**:

**Create a bulleted list of Stretch Goals**.  These are Enhancements that you will add to your REST API after you get your initial features implemented.   These should be features that may require more research in how to implement or features that would take longer than the allotted time frame. -->

### Final Reminders

-   This project should be written following the pattern implemented in one of the following projects:  **pet-parks**, **dog-rescue** or **pet-store**.
-   Use **JPA** to create a **REST API Server.**
-   Test your REST API Server using **Postman, Swagger,** or **AdvancedRestClient (ARC).**
-   **Have fun**.  Choose a project that interests you, and make it your own.  **_The best final projects are the ones that are interesting and useful to the one writing the software!_**

# Proposal

**Project participant(s):** Elliot Hill

**Title:** Concert Tracking API

### Executive Summary

The Concert Tracking API is a RESTful web service designed to help users catalog and manage concert events, venues, and artists. Built using Spring Boot and JPA, the API allows users to store, retrieve, update, and delete information about concerts, ensuring seamless tracking of past and upcoming events.

The API features a structured database with three core entities: Concert, Venue, and Artist. It supports essential CRUD operations, enabling users to query concerts by ID, associate them with specific venues and artists, and modify event details. A many-to-many relationship is established between concerts and artists, reflecting real-world scenarios where multiple artists perform at a single concert.

Future enhancements may include a SetList entity to track songs played at each concert, along with search functionality for concerts by song.

### Initial Features

-   **Database Design:** Create an Entity Relationship Diagram (ERD) to illustrate relationships between Concerts, Venues, and Artists.
-   **Concert Management:** Users can create, retrieve, update, and delete concert records.
-   **Venue Management:** Users can create, retrieve, update, and delete venue records.
-   **Artist Management:** Users can create, retrieve, update, and delete artist records.
-   **Relationships:**
    -   Implement a **many-to-one** relationship between Concerts and Venues (each concert occurs at one venue, but a venue can host many concerts).
    -   Implement a **many-to-many** relationship between Concerts and Artists (a concert can feature multiple artists, and an artist can perform at multiple concerts).
-   **REST API Endpoints:**
    -   **Concert Endpoints**:
        -   `GET /concerts` – Retrieve all concerts.
        -   `GET /concerts/{id}` – Retrieve a concert by ID.
        -   `POST /concerts` – Create a new concert.
        -   `PUT /concerts/{id}` – Update an existing concert.
        -   `DELETE /concerts/{id}` – Delete a concert.
    -   **Venue Endpoints:**
        -   `GET /venues` – Retrieve all venues.
        -   `GET /venues/{id}` – Retrieve a venue by ID.
        -   `POST /venues` – Create a new venue.
        -   `PUT /venues/{id}` – Update an existing venue.
        -   `DELETE /venues/{id}` – Delete a venue.
    -   **Artist Endpoints:**
        -   `GET /artists` – Retrieve all artists.
        -   `GET /artists/{id}` – Retrieve an artist by ID.
        -   `POST /artists` – Create a new artist.
        -   `PUT /artists/{id}` – Update an existing artist.
        -   `DELETE /artists/{id}` – Delete an artist.

### Stretch Goals

-   Include a SetList entity and allow users to look up sets by ID
-   Allow users to look up concerts by song(s)
