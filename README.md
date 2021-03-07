# Endterm-project
This project focuses on developing an online banking system. The main aim is to create an online banking application that has a lot of functions, so customers can see information about themselves and their banks cards. Also, they are able to transfer money to another customer(user) and see their transaction history.
Futhermore, there is an another user, that is admin. He/she is responsible to control application. So admins can create account for customer, search customer by username and create account for admin.
Every user(customer or admin) can see their account information.
## Classes
### Entities
	class User - this class is responsible for creating an object User and storing information about user. It contains variables 'username', 'password', 'user_type' (customer or admin), 'full_name', 'address'. 
	class Card - this class is responsible for creating an object Card and storing information about bank card. It contains variables 'id', 'username', 'money', 'number'. 
	class Transaction - this class is responsible for creating an object Transaction and storing information about transaction. It contains variables 'id', 'date', 'from_username', 'to_username', 'money'.
### Repositories
	class UserRepository - this class is responsible for creating an object UserRepository. It contains methods 'getUserByUsername' - to get user by username from database; and 'createUser' - to add a new user into database.
	class CardRepository - this class is responsible for creating an object CardRepository. It contains methods 'createCardForUsername' - to add a new card for username into database; 'getCardByUsername' - to get card by username from database; 'depositMoney' - to update(increase) money of user in database. It is needed in transfering money from someone to someone; 'withdrawMoney' - to update(decrease) money of user in database. It is needed in transfering money from someone to someone.
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
