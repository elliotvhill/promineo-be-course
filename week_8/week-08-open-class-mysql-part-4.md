# Week 8 - MySQL Part 4

Coding and mastery questions from MySQL lesson part 4.

## 31. `SELECT` from actor

Find all of the actors Ids & Full Names, film Id, and film Title for `film_id = 100`  
Additionally, use column aliases for each of these as follows:

-   id --> "Actor Id"
-   full name --> "Name"
-   film id --> "Film Id"
-   film title --> "Title"

_This query requires information from three (3) tables:_ `actor`_,_ `film_actor`_, and_ `film`_._  
Remember that `||` is the concatenate operator here.

#### Sample Test Case #1:

`SELECT`

#### Expected output:

| Actor Id | Name             | Film Id | Title           |
| :------: | ---------------- | :-----: | --------------- |
|    41    | JODIE DEGENERES  |   100   | BROOKLYN DESERT |
|    62    | JAYNE NEESON     |   100   | BROOKLYN DESERT |
|    90    | SEAN GUINESS     |   100   | BROOKLYN DESERT |
|   125    | ALBERT NOLTE     |   100   | BROOKLYN DESERT |
|   172    | GROUCHO WILLIAMS |   100   | BROOKLYN DESERT |

<details><summary><em>My Solution:</em></summary>

```sql
-- Solution that works on my machine / for the version of MySQL I'm using...
SELECT actor_id "Actor Id", CONCAT(first_name, " ", last_name) "Name", film_id "Film Id", title "Title" FROM actor
JOIN film_actor USING (actor_id)
JOIN film USING (film_id)
WHERE film_id = 100;

-- Solution accepted by Open Class
SELECT actor_id "Actor Id", first_name || " " || last_name "Name", film_id "Film Id", title "Title" FROM actor
JOIN film_actor USING (actor_id)
JOIN film USING (film_id)
WHERE film_id = 100;
```

</details>

<details><summary><em>Instructor Solution:</em></summary>

```sql
SELECT a.actor_id AS "Actor Id", a.first_name || " " || a.last_name AS "Name", fa.film_id AS "Film Id", f.title AS "Title" FROM actor a
INNER JOIN film_actor fa USING (actor_id)
INNER JOIN film f USING (film_id) WHERE f.film_id = 100;

-- SELECT actor_id AS "Actor Id", first_name || " " || last_name AS "Name",
-- film_id AS "Film Id", title AS "Title" FROM actor
-- INNER JOIN  film_actor USING (actor_id)
-- INNER JOIN film USING (film_id) WHERE film_id = 100;
```

</details>

## Indexes

An **index** in a DBMS is a construct that will **increase retrieval speed**. Indexes are used to retrieve data more quickly than a retrieval without an index, because the index is a **pointer** to the data in the tables. With index use, retrieval is faster, but **updating** a table with indexes will take **longer**, **because the index must also be updated**.

The key with index use is to **only** create indexes on columns that will be **frequently searched**.

### `CREATE INDEX` Syntax

```sql
CREATE INDEX index_name ON table_name (column1, column2, ...);
```

## 32. `CREATE INDEX` _actor_index_

Create an index on the actor table using the above syntax.  
Then retrieve all of the actors that have an `actor_id` less than 10.

#### Sample Test Case #1:

`CREATE`
`SELECT`

#### Expected output:

| actor_id | first_name | last_name    | last_update         |
| :------: | ---------- | ------------ | ------------------- |
|    1     | PENELOPE   | GUINESS      | 2006-02-15 09:34:33 |
|    2     | NICK       | WAHLBERG     | 2006-02-15 09:34:33 |
|    3     | ED         | CHASE        | 2006-02-15 09:34:33 |
|    4     | JENNIFER   | DAVIS        | 2006-02-15 09:34:33 |
|    5     | JOHNNY     | LOLLOBRIGIDA | 2006-02-15 09:34:33 |
|    6     | BETTE      | NICHOLSON    | 2006-02-15 09:34:33 |
|    7     | GRACE      | MOSTEL       | 2006-02-15 09:34:33 |
|    8     | MATTHEW    | JOHANSSON    | 2006-02-15 09:34:33 |
|    9     | JOE        | SWANK        | 2006-02-15 09:34:33 |

<details><summary><em>My Solution:</em></summary>

```sql
CREATE INDEX actor_index ON actor (actor_id);
SELECT * FROM actor WHERE actor_id < 10;
```

</details>

<details><summary><em>Instructor Solution:</em></summary>

```sql
CREATE INDEX IF NOT EXISTS actor_index ON actor (actor_id);

SELECT * FROM actor WHERE actor_id < 10;
```

</details>

## 33. `SELECT` Review #1

Retrieve the number of actors stored in the database. Display the result as "Count of Actors"

#### Sample Test Case #1:

`SELECT`

#### Expected output:

| Count of Actors |
| :-------------: |
|       200       |

<details><summary><em>My Solution:</em></summary>

```sql
SELECT COUNT(actor_id) "Cound of Actors" FROM actor;
```

</details>

<details><summary><em>Instructor Solution:</em></summary>

```sql
SELECT COUNT(*) AS "Count of Actors" FROM actor;
```

</details>

## 34. `SELECT` Review #2

Retrieve the actor first name, actor last name, and the number of film titles AS "count_of_films" for each actor with the last name of "GUINESS".

_Don't forget a_ `GROUP BY` _clause._  
_The tables that you will need for this query are_ `actor`_,_ `film_actor`_, and_ `film`_._

#### Sample Test Case #1:

`SELECT`

#### Expected output:

| first_name | last_name | count_of_films |
| ---------- | --------- | :------------: |
| ED         | GUINESS   |       29       |
| PENELOPE   | GUINESS   |       19       |
| SEAN       | GUINESS   |       33       |

<details><summary><em>My Solution:</em></summary>

```sql
SELECT first_name, last_name, COUNT(film_id) "count_of_films" FROM actor
JOIN film_actor USING (actor_id)
JOIN film USING (film_id)
WHERE last_name = "GUINESS"
GROUP BY first_name; -- GROUP BY actor_id returns results in the wrong order for Open Class
```

</details>

<details><summary><em>Instructor Solution:</em></summary>

```sql
SELECT a.first_name, a.last_name, COUNT(f.title) AS "count_of_films"
FROM actor a
JOIN film_actor fa ON a.actor_id = fa.actor_id
JOIN film f ON fa.film_id = f.film_id
WHERE a.last_name = "GUINESS"
GROUP BY a.first_name;
```

</details>

## 35. `SELECT` Review #3

Retrieve the actor first name, actor last name, and each film title for "PENELOPE GUINESS".

_Remember that three tables are needed to find this result._

#### Sample Test Case #1:

`SELECT`

#### Expected output:

| first_name | last_name |         title         |
| ---------- | --------- | :-------------------: |
| PENELOPE   | GUINESS   |   ACADEMY DINOSAUR    |
| PENELOPE   | GUINESS   | ANACONDA CONFESSIONS  |
| PENELOPE   | GUINESS   |      ANGELS LIFE      |
| PENELOPE   | GUINESS   | BULWORTH COMMANDMENTS |
| PENELOPE   | GUINESS   |     CHEAPER CLYDE     |
| _etc..._   | _etc..._  |       _etc..._        |

<details><summary><em>My Solution:</em></summary>

```sql
SELECT first_name, last_name, title FROM actor
JOIN film_actor USING (actor_id)
JOIN film USING (film_id)
WHERE first_name = "PENELOPE" AND last_name = "GUINESS"
GROUP BY title;
```

</details>

<details><summary><em>Instructor Solution:</em></summary>

```sql
SELECT a.first_name, a.last_name, f.title
FROM actor a
JOIN film_actor fa USING (actor_id)
INNER JOIN film f USING (film_id)
WHERE a.last_name = "GUINESS" AND a.first_name = "PENELOPE";
```

</details>

## 36. `SELECT` Review #4

Retrieve the film title, rental date, and return date for all rentals, along with the customer first name and last name who made the rental. Limit the result to 5.

_Remember that four (4) tables are needed to find this result:_ `rental`_,_ `inventory`_,_ `film`_, and_ `customer`_._

#### Sample Test Case #1:

`SELECT`

#### Expected output:

| title           | rental_date         | return_date         | first_name | last_name |
| --------------- | ------------------- | ------------------- | :--------: | :-------: |
| BLANKET BEVERLY | 2005-05-24 22:53:30 | 2005-05-26 22:04:30 | CHARLOTTE  |  HUNTER   |
| FREAKY POCUS    | 2005-05-24 22:54:33 | 2005-05-28 19:40:33 |   TOMMY    |  COLLAZO  |
| GRADUATE LORD   | 2005-05-24 23:03:39 | 2005-06-01 22:12:39 |   MANUEL   |  MURRELL  |
| LOVE SUICIDES   | 2005-05-24 23:04:41 | 2005-06-03 01:43:41 |   ANDREW   |   PURDY   |
| IDOLS SNATCHERS | 2005-05-24 23:05:21 | 2005-06-02 04:33:21 |  DELORES   |  HANSEN   |

<details><summary><em>My Solution:</em></summary>

```sql
SELECT f.title, r.rental_date, r.return_date, c.first_name, c.last_name FROM film f
JOIN inventory i USING (film_id)
JOIN rental r USING (inventory_id)
JOIN customer c USING (customer_id)
GROUP BY rental_id
LIMIT 5;
```

</details>

<details><summary><em>Instructor Solution:</em></summary>

```sql
SELECT f.title, r.rental_date, r.return_date, c.first_name, c.last_name
FROM rental r
JOIN inventory i ON r.inventory_id = i.inventory_id
JOIN film f ON i.film_id = f.film_id
JOIN customer c ON r.customer_id = c.customer_id
LIMIT 5;
```

</details>

## 37. `SELECT` Review #5

Retrieve the name of the category AS "category_name", and the number of films in each category AS "film_count".

_Remember that three (3) tables are needed to find this result. Research in the above information what tables connect films to their category._

#### Sample Test Case #1:

`SELECT`

#### Expected output:

| category_name | film_count |
| ------------: | :--------: |
|        Action |     64     |
|     Animation |     66     |
|      Children |     60     |
|      Classics |     57     |
|        Comedy |     58     |
|   Documentary |     68     |
|         Drama |     62     |
|        Family |     69     |
|       Foreign |     73     |
|         Games |     61     |
|        Horror |     56     |
|         Music |     51     |
|           New |     63     |
|        Sci-Fi |     61     |
|        Sports |     74     |
|        Travel |     57     |

<details><summary><em>My Solution:</em></summary>

```sql
SELECT c.name "category_name", COUNT(f.title) "film_count" FROM category c
JOIN film_category fc USING (category_id)
JOIN film f USING (film_id)
GROUP BY c.category_id;
```

</details>

<details><summary><em>Instructor Solution:</em></summary>

```sql
SELECT category.name AS category_name, COUNT(*) AS film_count
FROM film
JOIN film_category ON film.film_id = film_category.film_id
JOIN category ON film_category.category_id = category.category_id
GROUP BY category.category_id;
```

</details>

## 38. SELECT Review #6

Retrieve the id, the title, the rating, the release year, and the length of the shortest film, displayed as "shortest_length".

#### Sample Test Case #1:

`SELECT`

#### Expected output:

| film_id | title        | rating | release_year | shortest_length |
| :-----: | ------------ | ------ | :----------: | :-------------: |
|   15    | ALIEN CENTER | NC-17  |     2006     |       46        |

<details><summary><em>My Solution:</em></summary>

```sql
SELECT film_id, title, rating, release_year, MIN(length) "shortest_length" FROM film;
```

</details>

<details><summary><em>Instructor Solution:</em></summary>

```sql
SELECT film_id, title, rating, release_year, MIN(length) AS shortest_length FROM film;
```

</details>

## 39. SELECT Review #7

Retrieve the customer id, first name, last name, and total number of rentals AS "rental_count" from `rental`, matched with the records from `customer`, sorted by the number of rentals in descending order.

#### Sample Test Case #1:

`SELECT`

#### Expected output:

| customer_id | first_name | last_name | rental_count |
| :---------: | :--------: | :-------: | :----------: |
|     148     |  ELEANOR   |   HUNT    |      46      |
|     526     |    KARL    |   SEAL    |      45      |
|     236     |   MARCIA   |   DEAN    |      42      |
|     144     |   CLARA    |   SHAW    |      42      |
|  _etc..._   |  _etc..._  | _etc..._  |   _etc..._   |

<details><summary><em>My Solution:</em></summary>

```sql
SELECT customer_id, first_name, last_name, COUNT(rental_id) "rental_count" FROM customer
JOIN rental USING (customer_id)
GROUP BY customer_id
ORDER BY rental_count DESC;
```

</details>

<details><summary><em>Instructor Solution:</em></summary>

```sql
SELECT c.customer_id, c.first_name, c.last_name, COUNT(*) AS rental_count
FROM rental r
JOIN customer c ON c.customer_id = r.customer_id
GROUP BY c.customer_id
ORDER BY rental_count DESC;
```

</details>

## 40. `SELECT` Review #8

-   Retrieve the film title, category name AS "category", and the average rental duration (in days) for all films AS "average_rental_duration"
-   Round the average to 2 decimal places.
-   `GROUP BY` both title and category
-   `ORDER BY average_rental_duration` highest to lowest
-   `LIMIT` the result to 5

**_More information on the how to find the rental duration_**
To calculate the difference between dates, use the following method:

-   Use `JULIANDAY()` on each date.
-   Subtract the `JULIANDAY()` of the `rental_date` from the `JULIANDAY()` of the `return_date`.
-   This result will be averaged using `AVG()` and that result will be rounded using `ROUND()`

_This query requires 5 tables to get all of the required information._

#### Sample Test Case #1:

`SELECT`

#### Expected output:

| title          | category    | average_rental_duration |
| -------------- | ----------- | :---------------------: |
| FLIGHT LIES    | Sports      |          7.27           |
| IMPACT ALADDIN | Music       |           7.2           |
| AFRICAN EGG    | Family      |          7.11           |
| HARDLY ROBBERS | Documentary |          6.95           |
| HUNTER ALTER   | Documentary |          6.81           |

<details><summary><em>My Solution:</em></summary>

```sql
SELECT f.title, c.name "category", ROUND(AVG(JULIANDAY(r.return_date) - JULIANDAY(r.rental_date)),2) "average_rental_duration" FROM film f
JOIN inventory i USING (film_id)
JOIN film_category fc USING (film_id)
JOIN category c USING (category_id)
JOIN rental r USING (inventory_id)
GROUP BY f.title, category
ORDER BY average_rental_duration DESC
LIMIT 5;
```

</details>

<details><summary><em>Instructor Solution:</em></summary>

```sql
SELECT f.title, cat.name AS category, 
       ROUND(AVG(JULIANDAY(r.return_date) - JULIANDAY(r.rental_date)),2) AS average_rental_duration
FROM film f
JOIN inventory i USING(film_id)
JOIN rental r USING (inventory_id)
JOIN film_category fc USING (film_id)
JOIN category cat USING (category_id)
GROUP BY f.title, cat.name
ORDER BY average_rental_duration DESC
LIMIT 5;
```

</details>
