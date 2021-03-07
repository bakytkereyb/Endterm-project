# Endterm-project
This project focuses on developing an online banking system. The main aim is to create an online banking application that has a lot of functions, so customers can see information about themselves and their banks cards. Also, they are able to transfer money to another customer(user) and see their transaction history.
Futhermore, there is an another user, that is admin. He/she is responsible to control application. So admins can create account for customer, search customer by username and create account for admin.
Every user(customer or admin) can see their account information.
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
