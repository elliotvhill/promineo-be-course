# Week 12 Research Assignment

### Instructions

-   Choose at least **two (2)** of the below prompts.
-   Research those prompts.
-   Write at least one paragraph for **two (2)** of the below prompts
-   Include URLs from where you found the information to cite your sources.
-   Submit your **Research Results** to the LMS.

## Prompts

1. What is the difference between **TDD** and **BDD**?

    > Test Driven Development is an approach to development where tests are written _first_, and then code is written to satisfy those tests. <sup>[[1](#source-1)]</sup>
    >
    > Behavior Driven Development instead focuses on building tests around an application's desired or intended _behavior_, specifically from the perspective of a user. <sup>[[2](#source-2)][[3](#source-3)]</sup>

2. What does **mocking** a class allow you to do?

    > Mocking a class allows you to run unit tests using simulated objects, saving you from having to create entire objects for the sake of testing. For example, when writing a test for functionality that would ordinarily take user input, you can use a mock object to simulate the user input in testing. <sup>[[4](#source-4)]</sup>

3. What is the value in separating your code into controller, service, and data access layers rather than keeping it all in the same files?

4. Why would you want to avoid putting credentials in plaintext in your code?

    > Putting credentials in plaintext creates a huge security risk because it can expose sensitive user information. It can also make future updates to the code more difficult if credentials have to be tracked down and changed. <sup>[[5](#source-5)]</sup>

5. What is one method that can be used to avoid putting plaintext database usernames and passwords into your code?

    > One way is to use hashing to convert sensitive information into a random, unique string. <sup>[[6](#source-6)]</sup> These "hashes" cannot reasonably be reverse engineered, so they have an extra layer of security in place even if they are exposed. <sup>[[7](#source-7)]</sup>

## Resources Consulted

<a id="source-1"></a>1. [What is Test Driven Development (TDD)? | Geeks for Geeks](https://www.geeksforgeeks.org/test-driven-development-tdd/)  
<a id="source-2"></a>2. [What is Behavior Driven Development (BDD)? | Geeks for Geeks](https://www.geeksforgeeks.org/behavioral-driven-development-bdd-in-software-engineering/)  
<a id="source-3"></a>3. [Difference between BDD vs TDD in Software Engineering | Geeks for Geeks](https://www.geeksforgeeks.org/difference-between-bdd-vs-tdd-in-software-engineering/)  
<a id="source-4"></a>4. [Java mocks: A guide to mocking in Java | Unlogged](https://www.unlogged.io/post/java-mocks-a-guide-to-mocking-in-java)  
<a id="source-5"></a>5. [Keep passwords out of source code — why and how | Falk Tandetzky for NEW IT Engineering](https://medium.com/twodigits/keep-passwords-out-of-source-code-why-and-how-e84f9004815a)  
<a id="source-6"></a>6. [Hashing a Password in Java | Baeldung](https://www.baeldung.com/java-password-hashing)  
<a id="source-7"></a>7. [Hashing | TechTarget](https://www.techtarget.com/searchdatamanagement/definition/hashing#:~:text=Hashing%20is%20the%20process%20of,or%20employ%20the%20original%20string.)  
