# Week 7 Curriculum

Notes from the week 7 MySQL video lessons.

## Project Tools

### What is a database?

A **Database** is an application that stores and serves up data -- the _back end_.

A **Database Client** is the _front end_:
- Sends **requests** to a database
- Parses **responses** from a database
- _Examples: MySQL Command Line Interface (CLI), DBeaver, Java application_

The relationship between a **Database** and a **Client** is like a relationship between a banking application and a browser:

- You don't confuse the **browser** with the bank **application** -- the browser _connects_ to the bank application
- Don't confuse the **database** and the **client** -- the client _connects_ to the database

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


