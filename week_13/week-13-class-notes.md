# Week 13 Class Notes — SpringBoot

Class notes from week 13, intro to SpringBoot.

### Content:

SpringBoot, How the Internet Works, Terminology, JPA

## Basic overview of how the internet works

During this course we have discussed several standards and technologies

-   **Java** — created by Sun Microsystems; has standards and dev team
-   **SQL** — created by multiple groups and managed by a standards committee
-   **Internet communication** — was created by multiple groups and is managed by standards committee

### Why do we need standards and/or committees?

For the internet there are so many diff types of ways to transmit data

-   Formats — how the data should look
-   Errors — how to handle errors
-   Hardware — what is the role of hardware in all of this?
-   Infrastructure — this is related to hardware but this is the backbone of everything
-   Security — we need security

### Standards and committees

These groups are designed to define the standards that all companies, infrastructure, software, and hardware should follow to make the internet functional and reusable.

#### Terms:

-   HTTP communication
-   Data
-   REST
-   Web Server
-   Ports

### HTTP communication

-   **HTTP Communication** is the standard for sending info back and forth over the internet
-   Fhe idea is when you send a request, you include the action you want
    -   For example, if you go to `google.com` you send an HTTP GET request
    -   `google.com` responds with an **HTTP Response**

### Data

-   Data that is sent over the internet is organized into a set of standards and formats
-   The many committees have decided various ways to send and receive data using something called **Content-Type**
    -   e.g. if i'm uploading an image i am sending something with `content-type = 'image/jpeg'`
-   We will look at data that is being sent and received to see what those examples look like.

### REST

-   **REST** stands for **Re**presentational **S**tate **T**ransfer
-   REST is a standard that works with HTTP
-   REST supports several types of ways to GET or POST/PUT data
-   We will look at several examples of this

### Web servers

-   Web servers are the tools that we use to serve up web content or responses with an http response
-   web servers are the main application for being able to use http stuff — the "broker" of the conversation
-   springboot is a java framework that has all sorts of cool options we can include and on of those is a Web Server. Springboot will allow us to create REST code that uses HTTP communication

### Ports

-   Ports are the doorways into various services
    -   For example, when we ran MySQL on our machines the connection would be `jdbc://localhost:3306` — 3306 is the port that MySQL is running on
-   HTTP nad HTTPS (secure HTTP) run on port 80 or port 443 mostly, but can run on any port. Usually for our local development we will run on port 8080.

#### How the internet works:

Computer -> HTTP GET -> DNS -> IP address | domain name -> DNS -> HTTP GET -> internet -> HTTP GET -> Google (0.0.0.0) -> HTTP response -> web servers -> http response -> google -> http response -> internet -> dns -> computer

TCPMon - MITM listener

## JPA — Java Persistence API

-   JPA provides existing methods to run SQL queries
