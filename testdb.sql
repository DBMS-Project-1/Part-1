USE testdb;
DROP TABLE IF EXISTS User;
CREATE TABLE IF NOT EXISTS User (
    CustomerID INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Address VARCHAR(100),
    City VARCHAR(50),
    State CHAR(2),  -- Changed to CHAR for state abbreviation
    ZipCode VARCHAR(10),
    CreditCardNumber VARCHAR(16),
    ExpirationDate DATE,
    CVV CHAR(3),     -- Changed to CHAR for CVV
    Email VARCHAR(100)
);

INSERT INTO User (FirstName, LastName, Address, City, State, ZipCode, CreditCardNumber, ExpirationDate, CVV, Email)
VALUES 
	('susie', 'Guzman', 'whatever street', 'detroit', 'MI', '48202', '1000123412341234', '2000-06-27', '1234', 'susie@gmail.com'),
    ('Sophie', 'Pierce', 'yolos street', 'ides', 'CM', '24680', '1000246824682468', '1999-06-15', '2468', 'sophie@gmail.com'),
    ('Angelo', 'Francis', 'egypt street', 'lolas', 'DT', '13579', '1000468014680134680', '2021-06-14', '4680', 'angelo@gmail.com'),
    ('Rudy', 'Smith', 'sign street', 'samo ne tu', 'MH', '09876', '1000123412341234', '1706-06-05', '1234', 'rudy@gmail.com'),
    ('Jeannette', 'Stone', 'snoop street', 'kojik', 'HW', '87654', '1000098109810981', '2001-04-24', '0981', 'jeannette@gmail.com'),
    ('default', 'default', 'Default', 'Default', '0', '00000', '1000000000000000', '2021-01-01', '000', 'root');

SELECT * FROM User;
