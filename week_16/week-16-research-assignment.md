# Week 16 Research Assignment

### Instructions

-   Choose at least **two (2)** of the below prompts.
-   Research those prompts.
-   Write at least one paragraph for **two (2)** of the below prompts
-   Include URLs from where you found the information to cite your sources.
-   Submit your **Research Results** to the LMS.

## Prompts

#### Security:

1. When discussing handling of sensitive data, how do hashing and salting work? Why would we need to hash and salt certain data?

    > **Hashing** converts data into a fixed-size, irreversible string of characters — a **hash**. It is mainly used for storing passwords and ensuring data integrity (i.e. that data has not been altered or tampered with). <sup>[[1]](#source-1)[[2]](#source-2)</sup>
    >
    > **Salting** refers to the practice of adding random data — **salt** — to a hash. "Salt" is added to a hash to make data even more secure: it ensures hashes will be unique, even if they have the same input, and makes hashes much stronger against brute force attacks. <sup>[[3]](#source-3)</sup>
    >
    > Both salting and hashing are used to protect sensitive data — anything from passwords, to files, to digital signatures, etc. It is a standard security practice to protect user data.

2. What are the three parts of a JSON Web Token (JWT)?

    > A **JSON Web Token** (JWT) is used to authenticate users and securely exchange information via a JSON object.
    >
    > The three parts of a JWT are the **header**, **payload**, and **signature**. The header contains metadata about the token, including the algorithm used for signing and the token type. The payload is information about the user — e.g. a user ID, when a token was issued and when it expires, etc. The signature is generated using a secret and is used to ensure that the token hasn't been tampered with.
    >
    > The final token is created using the header, payload, and signature values separated by dots (`.`). <sup>[[4]](#source-4)</sup>

3. If a JWT can be decoded by anyone, how are they useful? What problem do they solve and how do they solve it securely?

    > JWTs are used for authenticating and authorizing users, not necessarily transmitting sensitive data. Because they are readable by anyone, tokens should not contain any secrets information unless it is encrypted. <sup>[[6]](#source-6)</sup> This is also why tokens are set to expire after a given amount of time. Additionally, because tokens can be decoded and then re-encoded, it is easy to determine that a token has been altered if the token signatures do not match.

4. Research Spring Security. Though not covered in this course, how to provide security is a question that many of our students have. Take a look into some of the available resources to provide security to your application.

    > Spring Security is a project developed by the Spring team to provide code for developers to handle authentication and authorization. This code can be used as-is or customized. <sup>[[5]](#source-5)</sup>

## Resources consulted

<a id="source-1"></a>1. [Encryption vs. Hashing vs. Salting - What's the Difference? | Ping Identity](https://www.pingidentity.com/en/resources/blog/post/encryption-vs-hashing-vs-salting.html)  
<a id="source-2"></a>2. [What Is Hashing, and How Does It Work? | Codecademy](https://www.codecademy.com/resources/blog/what-is-hashing/)  
<a id="source-3"></a>3. [Adding Salt to Hashing: A Better Way to Store Passwords | Auth0](https://auth0.com/blog/adding-salt-to-hashing-a-better-way-to-store-passwords/)  
<a id="source-4"></a>4. [JSON Web Token (JWT) | Geeks for Geeks](https://www.geeksforgeeks.org/json-web-token-jwt/)  
<a id="source-5"></a>5. [Introduction to Spring Security and its Features | Geeks for Geeks](https://www.geeksforgeeks.org/introduction-to-spring-security-and-its-features/)  
<a id="source-6"></a>6. [Introduction to JSON Web Tokens | JWT.io](https://jwt.io/introduction)  

<!-- <a id="source-7"></a>7.  <sup>[[7]](#source-7)</sup> -->
