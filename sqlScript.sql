USE testdb;
DROP TABLE IF EXISTS User;
CREATE TABLE IF NOT EXISTS User (
    CustomerID INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Address VARCHAR(100),
    City VARCHAR(50),
    State CHAR(2),
    ZipCode VARCHAR(5),
    CreditCardNumber VARCHAR(16),
    ExpirationDate CHAR(6),
    CVV CHAR(3),
    PhoneNumber CHAR(10),
    Email VARCHAR(100),
    Password VARCHAR(255) NOT NULL
);

INSERT INTO User (FirstName, LastName, Address, City, State, ZipCode, CreditCardNumber, ExpirationDate, CVV, Email, Password)
VALUES 
    ('Susie', 'Guzman', 'Whatever Street', 'Detroit', 'MI', '48202', '1000123412341234', '205066', '124', 'susie@gmail.com', 'password123'),
    ('Sophie', 'Pierce', 'Yolos Street', 'Ides', 'CM', '24680', '1000246824682468', '196565', '268', 'sophie@gmail.com', 'securepass'),
    ('Angelo', 'Francis', 'Egypt Street', 'Lolas', 'DT', '13579', '1000468014680180', '201566', '460', 'angelo@gmail.com', 'secret123'),
    ('Rudy', 'Smith', 'Sign Street', 'Samo Ne Tu', 'MH', '09876', '1000123412341234', '170566', '134', 'rudy@gmail.com', 'userpass'),
    ('Jeannette', 'Stone', 'Snoop Street', 'Kojik', 'HW', '87654', '1000098109810981', '205166', '081', 'jeannette@gmail.com', 'mypassword'),
    ('Default', 'Default', 'Default', 'Default', '0', '00000', '1000000000000000', '205261', '000', 'root', 'pass1234');

SELECT * FROM User;
delete from User