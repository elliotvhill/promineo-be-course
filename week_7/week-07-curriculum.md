# Week 7 Curriculum

Notes from the week 7 MySQL video lessons.

## Project Tools

### What is a database?

A **Database** is an application that stores and serves up data — the _back end_.

A **Database Client** is the _front end_:
- Sends **requests** to a database
- Parses **responses** from a database
- _Examples: MySQL Command Line Interface (CLI), DBeaver, Java application_

The relationship between a **Database** and a **Client** is like a relationship between a banking application and a browser:

- You don't confuse the **browser** with the bank **application** — the browser _connects_ to the bank application
- Don't confuse the **database** and the **client** — the client _connects_ to the database

#### Connections need...

| Browser to Website | Client to Database |
|--------------------|--------------------|
| The _scheme_ (http/https) | The database _type_ (mysql) |
| The _host_ name | The _host_ name |
| The _port_ number | The _port_ number |
| The _locator_ name <br />_(e.g. `https://exxon.com:8080/global_warming`)_ | The _schema_ name <br />_(e.g. `jdbc:mysql://localhost:3306/recipes`)_ |


### What is a schema?

A **Schema** is a **named collection** of data within a database. A **schema** has a collection of **tables**.

**Tables** are like spreadsheets:

- Tables define **columns** of data.
- Tables contain **rows** of data organized by column.

A **row** and a **column** is like a spreadsheet cell:

- Spreadsheet cells can have _any_ type of data, however...
- Table rows contain data _specified_ by the _column type_.

_**Note:** Unforunately, MySQL has historically called schemas **"databases"**._

- A **database** can have many **schemas**.
- A **schema** can have many **tables**.
- A **table** can have many **columns** (types).
    - **Columns** have a _name_, a _type_, and other attributes.
- **Tables** can have many **rows** (data).


### Database Clients

| Client | Features |
|--------|----------|
| MySQL CLI | <ul><li>Very _basic_ interface</li><li>_Not_ user-friendly</li><li>Does _not_ autofill</li><li>It's _ugly_!</li></ul> |
| DBeaver | <ul><li>Queries tables _automatically_</li><li>Generates `INSERT` statements _automatically_</li><li>Generates ERDs _automatically_</li><li>Limits data returned _automatically_</li><li>Has _intuitive_ graphical interface</li></ul> |


## Create Maven Project

### All About Apache Maven

**Maven** is an **application build tool**:
- Builds (compiles)
- Tests
- Packages

### How are we using Maven?

We use **Maven** to add **project dependencies**.

A **dependency** is a **Java library** that contains code used by our application. Java libraries are packaged as **Java Archives** — **JAR** files.

**JAR files** are ZIP files with a specific directory structure. The Java Runtime knows how to read **JAR files** and find code and resources in them.

#### Which dependencies do we need?

- **MySQL Connector/J** — this is a database **driver** _(written in Java)_

A **database driver** supports the **Java Database Connectivity (JDBC) standard.**

A **driver** is used to:
- _Manage_ connections
- Send SQL to a database
- Manage results from the database in a consistent manner

A **driver** is _specific_ to a particular **database**. Drivers are _(normally)_ maintained by the teams that write the database.

The **driver** **connects** the _database_ and the _client_.


### How Maven Works

**Maven** works by reading a **Project Object Model (POM)**.

The **POM** controls the build and is described in an XML file (`pom.xml`) typically at the root of your project. **Eclipse** has an _internal_ version of **Maven** and a **Maven connector** — `m2e`.

- Any changes made to the POM file are reflected in Eclipse.
- Any dependencies added in the POM are added to the application runtime.

We can add the **MySQL driver** as a **dependency** in the **POM**. The **Maven-Eclipse connector** (`m2e`) tells Eclipse to add the driver to the **application runtime**. We then write Java code with **JDBC-compliant classes**. The Java classes load and talk to the **driver** in a consistent manner. The **driver** communicates with the **database** itself.

_**Bottom line:** We can write Java code to talk to the database — our **application** becomes a **database client**._

#### How to add a project dependency

**Maven** classifies **dependencies** according to what it calls the **GAV** — the **G**roup ID, **A**rtifact ID, and **V**ersion number:

```xml
<dependencies>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.27</version>
    </dependency>
</dependencies>
```

This **uniquely identifies** the dependency. All of these attributes **must** be present in a dependency element in order to load the dependency.

#### How to find a dependency

1. Navigate to https://mvnrepository.com/
2. Type `mysql` in the search box
3. Click on the link for `MySQL Connector/J`
4. Click on the link for the latest version
5. Make sure the `Maven` tab is selected
6. Click in the dependency box
7. Paste into `pom.xml`


### Maven Project Setup

1. **Create** the Maven project
2. Add the **driver dependency**
3. Set the **compiler version** in the project

There are **three** important directories that Maven expects to find:
- **Source code:** `src/main/java`
- **Project resources:** `src/main/resources`
- **Built class files:** `target/classes`


## Working with data

### N-tier application design

We want to **separate** areas of concern _(i.e. "tiers")_:

- User input and output
- Business rules
- Data acquisition and persistence

If areas of concern are **not** separated, it can lead to:

- Complex classes
- Code that is **hard to maintain**
- **Buggy** code
- Code that violates the **single-responsibility principle (SRP)**

The **single-responsibility principle** is part of the five **SOLID** principles of **OOP**. **SRP** states that each **module**, **package**, **class**, and **method** is responsible for a **_single aspect_** of application functionality or area of concern.

**For example:**

- **Method:** _creates_ a connection to a database
- **Class:** _obtains_ and _pools_ connections
- **Package:** contains classes that _manage_ database input/output

In Java, there are **two** ways to separate concerns:

1. Ultra-large applications may separate the different concerns into **libraries** or **JAR files**
2. Smaller applications may use **packages** to separate the concerns

<details><summary><em>What are the concerns?</em></summary>

- User input and output
- Business rules
- Data acquisition and persistence

</details>

A **package** is a way of organizing your Java source code into different **directories**. If all your **source code** is in one file, packages may **not** make sense to use. However, if you were to have **30 files**, packages make sense to use — the **compiler** can handle the complexity; people **cannot**.


### Creating a small application

#### Designing with three _tiers_ or _layers_:

- **Input/Output Layer** — interacts with a user
    - _*Note:* the "user" could also be another microservice or Java application_
- **Service Layer** — applies business rules
    - _Examples of business rules — use cases to sort results by name, by color, etc._
- **Data "DAO" Layer** — reads and writes tables
    - _**Data Access Object** — a class that has attributes or methods to shuttle data back and forth between layers_

#### Packaging the layers:

- **Input/Output layer** — "main" package (e.g. `recipes`)
- **Service Layer:** — "service" package (e.g. `recipes.service`)
    - "entities" package (e.g. `recipes.entity`) — _entities are DAOs_
- **Data (DAO) Layer:** — "dao" package (e.g. `recipes.dao`)


## Connect to the Database

#### Video Contents
- How connections connect
- How drivers translate from JDBC to MySQL
- Video project:
    1. Create recipe schema and a user
    2. Implement a "main" class
    3. Implement a class to obtain a connection


### More about connections

A **connection** to MySQL is done with **Transmission Control Protocol (TCP)**. 

**Transmission Control Protocol (TCP)**:

- **Connects** two computers together _(like a circuit or a phone call)_
- Is **reliable** — the data is guaranteed to be received in the _right order_
- Is **bidirectional** — data is **sent** and **received** by either side
- Can have **multiple connections** open simultaneously

The connection **remains open** until it is _explicitly_ closed. When the connection is established, data is exchanged so that **both sides agree** on the **data format**, **compression**, **encryption**, etc.

**Establishing** a connection is _slow_; **using** a connection is _fast_. **Connections** can be **reused** and **pooled** (but not if they're closed). **TCP** is managed by **computer hardware**.

#### Database language

Each database has its own different **language** (i.e. _protocol_) that it uses to communicate with clients. The **Java Database Connectivity (JDBC)** classes _do not know_ the language that MySQL (or any other database) uses — this is where the **database driver** comes in.

#### Database drivers

The **database driver** works with the computer hardware to **establish** a reliable connection with the **database server**. The **MySQL driver** "**translates**" between JDBC calls and the MySQL language.

<details><summary><strong>Example</strong></summary>

Programmer writes in JDBC format:

```sql
String sql = "SELECT * FROM table";
String url = "jdbc:mysql://host:port/schema";
Connection conn = DriverManager.getConnection(url); -- finds and loads driver
PreparedStatement ps = conn.prepareStatement(sql);
ResultSet rs = ps.executeQuery(); -- sends request to MySQL
```

_Driver translates and sends to MySQL server_

MySQL server receives:

```sql
[03] COM_QUERY
SELECT * FROM table
```

</details>


#### Driver selection

When the application starts up, **JDBC** finds all database drivers on the **classpath**. It then selects the correct driver based on the **connection string** (url) passed to the `DriverManager` class.

&emsp; MySQL connection string format: `jdbc:mysql://host:port/schema`
