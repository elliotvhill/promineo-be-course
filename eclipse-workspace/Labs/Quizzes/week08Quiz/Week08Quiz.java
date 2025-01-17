package week08Quiz;

public class Week08Quiz {

	public static void main(String[] args) {

		/*
		 * Question 1:
		 * 
		 * What SQL command is used to read data from a table?
		 * 
		 * a. LOOKUP b. SELECT c. READ d. INSERT INTO
		 * 
		 * ANSWER: B
		 */

		/*
		 * Question 2:
		 * 
		 * What is wrong with the following query? (Note: Choose one or more of the
		 * following answers)
		 * 
		 * INSERT INTO products (name, price) VALUES (carrot, 2, 5);
		 * 
		 * a. The query doesn't need `INTO` after `INSERT`. b. `carrot` should be in
		 * quotes. c. Nothing. d. There are more values specified than columns declared.
		 * 
		 * ANSWER: B & D
		 */

		/*
		 * Question 3:
		 * 
		 * Select the correct words to complete the queries below.
		 * 
		 * INSERT __INTO__ people (first_name, last_name, age) __VALUES__ ('Tom',
		 * 'Sawyer', 17);
		 * 
		 * __UPDATE__ people SET age = 18 __WHERE__ last_name = 'Sawyer';
		 * 
		 * SELECT * __FROM__ people WHERE first_name = 'Tom';
		 */

		/*
		 * Question 4:
		 * 
		 * What would the following query return?
		 * 
		 * SELECT * FROM customer WHERE last_name LIKE '_s%';
		 * 
		 * a. Nothing; the query's syntax is incorrect. b. All customers with a last
		 * name where the second letter is `s`. c. All customers with a last name
		 * starting with the letter `s`; d. All customers with a second to last letter
		 * of `s`;
		 * 
		 * ANSWER: B
		 */

		/*
		 * Question 5:
		 * 
		 * TRUE/FALSE: SQL stands for Structured Query Language. ANSWER: TRUE
		 */

		/*
		 * Question 6:
		 * 
		 * Match the SQL commands to the correct definitions.
		 * 
		 * Used to change existing data that already exists in a row. -- UPDATE 
		 * Used to read data from a database table. -- SELECT 
		 * Used to create new rows in a database table. -- INSERT INTO 
		 * Used to remove rows from a database table. -- DELETE
		 */

		/*
		 * Question 7:
		 * 
		 * Before running an UPDATE or DELETE command, what is the safest way to
		 * determine how many rows will be impacted?
		 * 
		 * a. Run the command to see how many rows were affected. 
		 * b. Run a SELECT query with the exact same WHERE clause. 
		 * c. Run a SELECT statement without a WHERE clause and manually count 
		 * the rows that meet your criteria. 
		 * d. There is no way. You need to be very confident your query is written 
		 * correctly to do exactly what you want it to do.
		 * 
		 * ANSWER: B
		 */

		/*
		 * Question 8:
		 * 
		 * Given a table named customers that contains columns `first_name`,
		 * `last_name`, `customer_id`, `street`, `city`, and `zip`, write a query that
		 * returns all customers with a last name that starts with `A` and that live in
		 * `Phoenix`.
		 * 
		 * __SELECT__ * __FROM__ customers __WHERE__ last_name __LIKE__ 'A%` __AND__
		 * city = 'Phoenix';
		 */
		
		/* Question 9:
		 * 
		 * If you want to sort a queries result set by a specific column in the table, 
		 * what command can you use?
		 * 
		 * a. ORGANIZE BY
		 * b. SORT BY
		 * c. ORDER BY
		 * d. FILTER BY
		 * 
		 * ANSWER: C
		 */
		
		/* Question 10:
		 * 
		 * Which of the following commands changes data in a row that already exists?
		 * 
		 * a. CHANGE
		 * b. ALTER
		 * c. UPDATE
		 * d. MODIFY
		 * 
		 * ANSWER: C
		 */

	}

}
