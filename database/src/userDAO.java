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
import java.math.BigDecimal;

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
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb?allowPublicKeyRetrieval=true&useSSL=false&user=john&password=pass1234");
            System.out.println(connect);
        }
    }
    
    public boolean database_login(String username, String password) throws SQLException{
    	try {
    		connect_func();
    		String sql = "select * from User where username = ?";
    		preparedStatement = connect.prepareStatement(sql);
    		preparedStatement.setString(1, username);
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
        	String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            int roleId = resultSet.getInt("role_id");
             
            user users = new user(username, password, roleId);
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
        connect_func();
        String sql = "insert into User(username, password, role_id) VALUES (?, ?, ?)";
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, users.getUsername());
        preparedStatement.setString(2, users.getPassword());
        preparedStatement.setInt(3, users.getRoleId());
     

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }




    public void setQuote_id(user users) throws SQLException {
        connect_func();
        
        String sql = "SELECT unique_id FROM User WHERE username = ?";
        preparedStatement = connect.prepareStatement(sql);
        preparedStatement.setString(1, users.getUsername());
        
        ResultSet resultSet = preparedStatement.executeQuery();
        
        if (resultSet.next()) {
            int unique_id = resultSet.getInt("unique_id");
            System.out.println("Unique ID for username '" + users.getUsername() + "': " + unique_id);
            users.setQuote_id(unique_id);
            System.out.println("username: " + users.getUsername() + " has a quote_id of: " + users.getQuote_id());
        } else {
            System.out.println("No user found with username '" + users.getUsername() + "'");
        }
        
        resultSet.close();
        preparedStatement.close();

    }



    
    public boolean delete(String username) throws SQLException {
        String sql = "DELETE FROM User WHERE username = ?";        
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, username);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowDeleted;     
    }
     
    public boolean update(user users) throws SQLException {
    	 String sql = "UPDATE User SET password = ?, role_id = ? WHERE username = ?";
         connect_func();
         
         preparedStatement = connect.prepareStatement(sql);
         preparedStatement.setString(1, users.getPassword());
         preparedStatement.setInt(2, users.getRoleId());
         preparedStatement.setString(3, users.getUsername());	
         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
    
    public user getUser(String username) throws SQLException {
    	user user = null;
        String sql = "SELECT * FROM User WHERE username = ?";
        connect_func();
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String password = resultSet.getString("password");
            int roleID = resultSet.getInt("role_id");
            user = new user(username, password, roleID);
        }
         
        resultSet.close();
        statement.close();
         
        return user;
    }
    
    public int getRoleID(String username) throws SQLException {
        int roleID = 0;
        String sql = "SELECT role_id FROM User WHERE username = ?";
        connect_func();
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        if (resultSet.next()) {
            roleID = resultSet.getInt("role_id");
        }
         
        resultSet.close();
        statement.close();
         
        return roleID;
    }
    
    public boolean checkUsername(String username) throws SQLException {
        boolean checks = false;
        String sql = "SELECT * FROM User WHERE username = ?";
        connect_func();
        preparedStatement = connect.prepareStatement(sql);
        preparedStatement.setString(1, username);
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
    
    
    
    public boolean isValid(String username, String password) throws SQLException
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
    		if(resultSet.getString("username").equals(username) && resultSet.getString("password").equals(password)) {
    			return true;
    		}		
    	}
    	return false;
    }
    
    
    public void init() throws SQLException, FileNotFoundException, IOException{
        
        connect_func();
        statement =  (Statement) connect.createStatement();

        String[] INITIAL = {
            "DROP DATABASE IF EXISTS testdb;",
            "CREATE DATABASE testdb;",
            "USE testdb;",
            "DROP TABLE IF EXISTS User;",
            "DROP TABLE IF EXISTS Role;",
            "CREATE TABLE Role ( " +
            "    role_id INT AUTO_INCREMENT PRIMARY KEY, " +
            "    role_name VARCHAR(255) NOT NULL UNIQUE " +
            ");",
            "CREATE TABLE User ( " +
            "    unique_id INT AUTO_INCREMENT PRIMARY KEY, " +
            "    username VARCHAR(255) NOT NULL UNIQUE, " +
            "    password VARCHAR(255) NOT NULL, " +
            "    role_id INT, " +
            "    FOREIGN KEY (role_id) REFERENCES Role(role_id) " +
            ");"
        };

        String[] TUPLES = {
            "INSERT INTO Role (role_name) VALUES ('user');",
            "INSERT INTO Role (role_name) VALUES ('root');",
            "INSERT INTO Role (role_name) VALUES ('david');",
                "INSERT INTO User (username, password, role_id) VALUES ('root', 'pass1234', 2);",
                "INSERT INTO User (username, password, role_id) VALUES ('David Smith', 'pass1234', 3);",
                "INSERT INTO User (username, password, role_id) VALUES ('Michael@gmail.com', 'michaelpass123', 1);",
                "INSERT INTO User (username, password, role_id) VALUES ('Emily@gmail.com', 'emilypass123', 1);",
                "INSERT INTO User (username, password, role_id) VALUES ('David@gmail.com', 'davidpass123', 1);",
                "INSERT INTO User (username, password, role_id) VALUES ('Sophia@gmail.com', 'sophiapass123', 1);",
                "INSERT INTO User (username, password, role_id) VALUES ('Liam@gmail.com', 'liampass123', 1);",
                "INSERT INTO User (username, password, role_id) VALUES ('Olivia@gmail.com', 'oliviapass123', 1);",
                "INSERT INTO User (username, password, role_id) VALUES ('Noah@gmail.com', 'noahpass123', 1);",
                "INSERT INTO User (username, password, role_id) VALUES ('Ava@gmail.com', 'avapass123', 1);"
            };
        
        //for loop to put these in database
        for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
        for (int i = 0; i < TUPLES.length; i++)	
        	statement.execute(TUPLES[i]);
        disconnect();
    }
}
