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


@WebServlet("/QuoteDAO")

public class QuoteDAO {
    private Connection connect = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private Statement statement = null;

    public QuoteDAO() {
        // Initialize the database connection in the constructor
        connectToDatabase();
    }

    private void connectToDatabase() {
        try {
            // Establish the database connection
            // Modify the connection URL, username, and password as needed
            String dbUrl = "jdbc:mysql://127.0.0.1:3306/testdb";
            String dbUser = "john";
            String dbPassword = "pass1234";

            connect = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(Quote quote) throws SQLException {
        try {
            // Create a SQL statement to insert a new quote
            String sql = "INSERT INTO Quote (num_of_trees, budget) VALUES (?, ?)";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setInt(1, quote.getNum_of_trees());
            preparedStatement.setDouble(2, quote.getBudget());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }
    
    
    /*
     * should list all quotes
     * listAllUsers from userDAO.java does not work so this might also not work
     * maybe not retrieving the correct attributes from resultSet
     */
    public List<Quote> listAllQuotes() throws SQLException {
    	
    	List<Quote> listQuote = new ArrayList<Quote>();
    	String sql = "SELECT * FROM Quote";
    	
    	connectToDatabase();
    	
    	statement = (Statement) connect.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	
    	while (resultSet.next()) {
    		//int quoteID = resultSet.getInt("quote_id");
    		int numTrees = resultSet.getInt("num_of_trees");
    		float budget = resultSet.getFloat("budget");
    		
    		Quote quotes = new Quote(numTrees, budget);
    		listQuote.add(quotes);
    	}
    	
    	closeResources();
    	
    	return listQuote;
    }
    
    
    // You can add more methods like listAllQuotes, delete, update, etc., if needed

    private void closeResources() {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
