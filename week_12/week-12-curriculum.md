# Week 12 — JUnit Testing

Notes from the week 12 JUnit testing curriculum.

## Unit Testing

### Why test?

-   Increase the quality of the code
-   Find bugs before the application hits production!
-   Verify that the code is correct
    -   Not just the _right_ code...
    -   ...but coded the _right way_

### What to test?

-   It depends:
    -   **Unit tests** test **methods**
    -   **Integration tests** _(i.e. functional tests)_ test all or part of **applications**

### When to test?

#### Before coding

-   **Results**-based testing
-   Testing **behaviors** of services
-   Integration tests

_For example: testing a (REST) server — does the server return the expected answer for a given request?_

#### After coding

-   Testing **results** of methods
-   Critical **algorithms**
-   Unit tests

### Rules of testing

-   Test as **high-level** as you can
    -   Better to test an **application** vs. a group of methods
    -   Better to test a **group** of methods vs. a single method
-   Test as **soon** as you can
    -   Better to test **before** you code vs. after you code
    -   Better to test _at all_ vs. not testing

### Tools of testing

-   Unit test framework (**JUnit 5**)
-   Functional test framework (**Spring Boot Test**)
-   Mocking library (**Mockito**)
-   Assertion library (**AssertJ**)

### How are tests laid out?

-   **Specification** — descriptive test name
-   **Short** — put supporting code elsewhere
-   **Architecture**
    -   "Given", "When", "Then" _(Martin Fowler)_

## Test Driven Development (TDD)

### What is Test-Driven Development (TDD)?

-   It's simply **unit testing** but the test is written _first_
-   Typically done with **two people** _("eXtreme Programming" — XP)_
-   Also known as **Red**-**Green**-**Refactor**:
    -   **Red** — write some test code
    -   **Green** — write some app code
    -   **Refactor** the test until complete

### Advantages of TDD

-   Avoids code bloat — you _only_ write enough application code to satisfy the test, i.e. no extra code
-   Generally faster development
-   Saves cost over the entire project

## Behavior Driven Development (BDD)

### Advantages over TDD

-   **Results-based** testing
-   Tests **configuration**
-   Tests **SQL** statements
-   Write **fewer unit tests**
-   **Red-Green-Refactor** for _functionality_

### Combine with TDD

-   TDD/BDD is the best of both worlds!
-   **TDD** for complex methods
-   **BDD** for overall functionality
-   Instills **confidence** that the app will perform as designed

<!-- ## Functional Test for Menu Application -->

<!-- ## What To Do When -->
