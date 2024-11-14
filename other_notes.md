# Other Notes

A place to store miscellaneous notes

## Topics

### Week 8

SQL: aliases, `USING` vs. `ON` [[#](#sql-aliases-using-vs-on)]  




### <a id="aliases-using-on"></a> SQL: aliases, `USING` vs. `ON` 

**Student Question:**  

> _Week 8 openclass question. My solution works fine and is more readable. Why do the instructor solutions seem more convoluted? ... I don't see the use of renaming tables, or specifying which table a given column belongs to when there's only one possibility._
> 
> _Is the instructor demonstrating best practices when working with more complicated data structures?_

**Student solution:**  

```sql
SELECT first_name, last_name, COUNT(film.film_id) as "count_of_films"
FROM actor
JOIN film_actor USING (actor_id)
JOIN film USING (film_id)
WHERE last_name = "GUINESS"
GROUP BY first_name;
```

**Instructor solution:**  

```sql
SELECT a.first_name, a.last_name, COUNT(f.title) AS "count_of_films"
FROM actor a
JOIN film_actor fa ON a.actor_id = fa.actor_id
JOIN film f ON fa.film_id = f.film_id
WHERE a.last_name = "GUINESS"
GROUP BY a.first_name;
```

**Instructor Explanation:**  

> _The two queries you presented are functionally equivalent. It’s not that the instructor’s version is more convoluted. It’s more just demonstrating two aspects of sql that are essential to understand._
> 
> 1. ALIASES:  
    > - The `from actor a` line creates an alias named `a`. An alias is simply a short name for the table. In a simple query like the one above, they are not needed, but in more complicated queries with many joins on many different tables or even where table names are long, they increase readability and reduce typing.  
    > 
    > - For example, usually table names should be descriptive of what they contain.   So if you have a table called `ACCOUNTS_RECEIVABLE` you can alias the table `ar`, `FROM ACCOUNTS_RECEIVASBLE AR`.  
    > 
    > - So instead of typing `ACCOUNTS_RECEIVABLE.amount`, its just `ar.amount`. Also, if you have several tables in your query that have a column name that is the same, you will need to use an alias to which column you are referencing or the query will not compile.
    > 
    > - In summary, alias' do two things: 1) allow you to shorten your query text, and 2) remove ambiguity when using a column name that exists in more that one of the tables in your query. 
    > 
> 2. `USING` vs `ON`:  
    > - Your query is using `USING` to implement the join. That only works if the column names you are joining are the same and is provided to make the query text shorter-- i.e. `employee.employee_id` to `department.employee_id`.
    > 
    > - In many instances you will join on column names that are not the same, i.e. `employee.id` to `department.employee_id`. In the latter case, you will need to use the `ON` like in the instructor’s example because the column names are different.