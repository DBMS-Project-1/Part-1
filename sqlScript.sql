USE testdb;
drop table if exists Role; 
drop table if exists User; 

CREATE TABLE Role (
    role_id INT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE User (
    unique_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role_id INT,
    FOREIGN KEY (role_id) REFERENCES Role(role_id)
);

INSERT INTO Role (role_name)
VALUES 
	('user'),
	('root'),
	('david');

INSERT INTO User (username, password, role_id)
VALUES 
	('root', 'pass1234', 2),
	('David Smith', 'pass1234', 3),
	('user1', 'pass1', 1),
	('user2', 'pass2', 1),
	('user3', 'pass3', 1),
	('user4', 'pass4', 1),
	('user5', 'pass5', 1),
	('user6', 'pass6', 1),
	('user7', 'pass7', 1),
	('user8', 'pass8', 1);

SELECT * FROM Role;
SELECT * FROM User;

delete from User
