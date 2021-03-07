# Endterm-project
description of project

## Classes
### Entities
	class User - 
	class Card - 
	class Transaction -
### Repositories
	class UserRepository - 
	class CardRepository - 
	class TransactionRepository - 
### Controllers
	class UserController - 
### Data
	class DB - 

## PostgreSQL
```SQL
CREATE TABLE users(
	username VARCHAR(255),
	password VARCHAR(255),
	user_type BOOL,
	full_name VARCHAR(255),
	address VARCHAR(255),
	PRIMARY KEY(username)
);

CREATE TABLE cards(
	id SERIAL,
	username VARCHAR(255),
	money INT,
	number VARCHAR(255),
	PRIMARY KEY(id),
	FOREIGN KEY(username) REFERENCES users(username)
);

CREATE TABLE transactions(
	id SERIAL,
	date DATE,
	from_username VARCHAR(255),
	to_username VARCHAR(255),
	money INT,
	PRIMARY KEY(id),
	FOREIGN KEY(from_username) REFERENCES users(username),
	FOREIGN KEY(to_username) REFERENCES users(username)
);
```

## Author
* Full name: Bakytkereiuly Batyrbek
* Group: SE-2015
