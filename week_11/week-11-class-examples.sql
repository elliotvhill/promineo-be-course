-- CREATE DATABASE World;
-- use World;

CREATE TABLE country (
	country_id INT AUTO_INCREMENT PRIMARY KEY,
    country_name VARCHAR(255),
    population INT
);

CREATE TABLE city (
	city_id INT AUTO_INCREMENT PRIMARY KEY,
    city_name VARCHAR(255),
    city_population INT,
    zip_code INT,
    country_id INT,
    FOREIGN KEY(country_id) REFERENCES country(country_id)
);

CREATE TABLE event (
	event_id INT AUTO_INCREMENT PRIMARY KEY,
    event_name VARCHAR(255),
    event_location VARCHAR(255)
);

CREATE TABLE participant (
	participant_id INT AUTO_INCREMENT PRIMARY KEY,
    participant_name VARCHAR(255),
    participant_email VARCHAR(255),
);

CREATE TABLE event_participant (
	PRIMARY KEY (event_id, participant_id),
    FOREIGN KEY (event_id) REFERENCES event(event_id),

);

select * from customers;

UPDATE customers
SET CustomerName = "Alfred Pennyworth",
City = "Gotham"
WHERE CustomerID = 1;

update customers
SET Country = "MX"
WHERE Country = "Mexico";

select * from customers;