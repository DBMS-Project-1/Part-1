import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/userDAO")
public class userDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public userDAO(){}
	
	/** 
	 * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
    	//uses default connection to the database
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb?allowPublicKeyRetrieval=true&useSSL=false&user=root&password=pass1234");
            System.out.println(connect);
        }
    }
    
    public boolean database_login(String email, String password) throws SQLException{
    	try {
    		connect_func("root","pass1234");
    		String sql = "select * from user where email = ?";
    		preparedStatement = connect.prepareStatement(sql);
    		preparedStatement.setString(1, email);
    		ResultSet rs = preparedStatement.executeQuery();
    		return rs.next();
    	}
    	catch(SQLException e) {
    		System.out.println("failed login");
    		return false;
    	}
    }
	//connect to the database 
    public void connect_func(String username, String password) throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://127.0.0.1:3306/userdb?"
  			          + "useSSL=false&user=" + username + "&password=" + password);
            System.out.println(connect);
        }
    }
    
    public List<user> listAllUsers() throws SQLException {
        List<user> listUser = new ArrayList<user>();        
        String sql = "SELECT * FROM User";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	String firstName = resultSet.getString("FirstName");
        	String lastName = resultSet.getString("LastName");
        	String address = resultSet.getString("Address"); 
        	String city = resultSet.getString("City"); 
        	String state = resultSet.getString("State"); 
        	String zip_code = resultSet.getString("ZipCode"); 
        	String credit_card_number = resultSet.getString("CreditCardNumber"); 
        	String expiration_date = resultSet.getString("ExpirationDate"); 
        	String cvv = resultSet.getString("CVV"); 
        	String email = resultSet.getString("Email"); 
        	String phoneNumber = resultSet.getString("PhoneNumber"); 
        	String password = resultSet.getString("Password"); 
   

             
            user users = new user(firstName, lastName, address, city, state, zip_code, credit_card_number, expiration_date, cvv, phoneNumber, email, password);
            listUser.add(users);
        }        
        resultSet.close();
        disconnect();        
        return listUser;
    }
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    public void insert(user users) throws SQLException {
    	connect_func("root","pass1234");         
    	String sql = "INSERT INTO User (FirstName, LastName, Address, City, State, ZipCode, CreditCardNumber, ExpirationDate, CVV, PhoneNumber, Email, Password) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setString(1, users.getFirstName());
			preparedStatement.setString(2, users.getLastName());
			preparedStatement.setString(3, users.getAddress());
			preparedStatement.setString(4, users.getCity());
			preparedStatement.setString(5, users.getState());		
			preparedStatement.setString(6, users.getZipCode());		
			preparedStatement.setString(7, users.getCreditCardNumber());		
			preparedStatement.setString(8, users.getExpirationDate());		
			preparedStatement.setString(9, users.getCVV());	
			preparedStatement.setString(10, users.getPhoneNumber());	
			preparedStatement.setString(11, users.getEmail());		
			preparedStatement.setString(12, users.getPassword());		

		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public boolean delete(String email) throws SQLException {
        String sql = "DELETE FROM User WHERE email = ?";        
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowDeleted;     
    }
     
    public boolean update(user users) throws SQLException {
        String sql = "update User set firstName = ?, lastName = ?, address = ?, city, state = ?, zip_code = ?, credit_card_number = ?, expiration_date = ?, cvv = ?, phoneNumber = ?, password = ? where email = ?";
        connect_func();
        
		preparedStatement.setString(1, users.getEmail());
		preparedStatement.setString(2, users.getFirstName());
		preparedStatement.setString(3, users.getLastName());
		preparedStatement.setString(4, users.getAddress());
		preparedStatement.setString(5, users.getCity());
		preparedStatement.setString(6, users.getState());		
		preparedStatement.setString(7, users.getZipCode());		
		preparedStatement.setString(8, users.getCreditCardNumber());		
		preparedStatement.setString(9, users.getExpirationDate());		
		preparedStatement.setString(10, users.getCVV());	
		preparedStatement.setString(11, users.getPhoneNumber());	
		preparedStatement.setString(12, users.getEmail());		
		preparedStatement.setString(13, users.getPassword());	
         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
    
    public user getUser(String email) throws SQLException {
    	user user = null;
        String sql = "SELECT * FROM User WHERE email = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
        	String firstName = resultSet.getString("FirstName");
        	String lastName = resultSet.getString("LastName");
        	String address = resultSet.getString("Address"); 
        	String city = resultSet.getString("City"); 
        	String state = resultSet.getString("State"); 
        	String zip_code = resultSet.getString("ZipCode"); 
        	String credit_card_number = resultSet.getString("CreditCardNumber"); 
        	String expiration_date = resultSet.getString("ExpirationDate"); 
        	String cvv = resultSet.getString("CVV");
        	String phoneNumber = resultSet.getString("PhoneNumber"); 
        	String password = resultSet.getString("Password"); 
        	
            user = new user(firstName, lastName, address, city, state, zip_code, credit_card_number, expiration_date, cvv, phoneNumber, password);
        }
         
        resultSet.close();
        statement.close();
         
        return user;
    }
    
    public boolean checkEmail(String email) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM User WHERE email = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
    	return checks;
    }
    
    public boolean checkPassword(String password) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM User WHERE password = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
       	return checks;
    }
    
    
    
    public boolean isValid(String email, String password) throws SQLException
    {
    	String sql = "SELECT * FROM User";
    	connect_func();
    	statement = (Statement) connect.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	
    	resultSet.last();
    	
    	int setSize = resultSet.getRow();
    	resultSet.beforeFirst();
    	
    	for(int i = 0; i < setSize; i++)
    	{
    		resultSet.next();
    		if(resultSet.getString("email").equals(email) && resultSet.getString("password").equals(password)) {
    			return true;
    		}		
    	}
    	return false;
    }
    
    
    public void init() throws SQLException, FileNotFoundException, IOException{
    	connect_func();
        statement =  (Statement) connect.createStatement();
        
        String[] INITIAL = {"USE testdb; ",
					        "DROP TABLE IF EXISTS User; ",
					        ("CREATE TABLE IF NOT EXISTS User ( " +
					            "CustomerID INT AUTO_INCREMENT PRIMARY KEY, " + 
					            "FirstName VARCHAR(50) NOT NULL,, " +
					            "LastName VARCHAR(50) NOT NULL, " +
					            "Address VARCHAR(100), " +
					            "City VARCHAR(50), " +
					            "State CHAR(2),  "+ 
					            "ZipCode VARCHAR(5), "+ 
					            "CreditCardNumber VARCHAR(16), " + 
					            "ExpirationDate VARCHAR(6), "+ 
					            "CVV CHAR(3), "+ 
					            "PhoneNumber CHAR(10)," +
					            "Email VARCHAR(100) "+ 
					            "Password VARCHAR(255) NOT NULL ")
        					};
        String[] TUPLES = {("INSERT INTO User (FirstName, LastName, Address, City, State, ZipCode, CreditCardNumber, ExpirationDate, CVV, Email, Password)"+
        			"values ('John', 'Doe', '123 Main St', 'New York', 'NY', '10001', '1234123412341234', '2000-01-15', '789', 'john@example.com', 'johnpass123'),\n" +
        			"    ('Alice', 'Johnson', '456 Elm St', 'Los Angeles', 'CA', '90001', '5678567856785678', '1998-03-20', '456', 'alice@example.com', 'alicepass123'),\n" +
        			"    ('Michael', 'Smith', '789 Oak St', 'Chicago', 'IL', '60601', '9876987698769876', '2002-05-10', '234', 'michael@example.com', 'michaelpass123'),\n" +
        			"    ('Emily', 'Brown', '321 Pine St', 'Houston', 'TX', '77001', '7654765476547654', '1995-11-30', '654', 'emily@example.com', 'emilypass123'),\n" +
        			"    ('David', 'Lee', '654 Birch St', 'Miami', 'FL', '33101', '8765876587658765', '1990-08-12', '321', 'david@example.com', 'davidpass123'),\n" +
        			"    ('Sophia', 'Martinez', '987 Cedar St', 'San Francisco', 'CA', '94101', '3456345634563456', '2005-02-25', '987', 'sophia@example.com', 'sophiapass123'),\n" +
        			"    ('Liam', 'Garcia', '741 Willow St', 'Dallas', 'TX', '75201', '2345234523452345', '1997-07-05', '567', 'liam@example.com', 'liampass123'),\n" +
        			"    ('Olivia', 'Perez', '369 Redwood St', 'Atlanta', 'GA', '30301', '4321432143214321', '2001-04-15', '123', 'olivia@example.com', 'oliviapass123'),\n" +
        			"    ('Noah', 'Rodriguez', '852 Sycamore St', 'Seattle', 'WA', '98101', '8765876587658765', '1992-09-08', '876', 'noah@example.com', 'noahpass123'),\n" +
        			"    ('Ava', 'Sanchez', '123 Pineapple St', 'Denver', 'CO', '80201', '7654765476547654', '1994-12-10', '345', 'ava@example.com', 'avapass123');")
			    	};
        
        //for loop to put these in database
        for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
        for (int i = 0; i < TUPLES.length; i++)	
        	statement.execute(TUPLES[i]);
        disconnect();
    }
    
    
   
    
    
    
    
    
	
	

}
