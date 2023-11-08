import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class ControlServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    private userDAO userDAO = new userDAO();
	    private QuoteDAO QuoteDAO = new QuoteDAO();
	    private String currentUser;
	    private HttpSession session=null;
	    
	    public ControlServlet()
	    {
	    	
	    }
	    
	    public void init()
	    {
	    	userDAO = new userDAO();
	    	QuoteDAO = new QuoteDAO();
	    	currentUser= "";
	    }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }
	    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getServletPath();
	        System.out.println(action);
	    
	    try {
        	switch(action) {  
        	case "/login":
        		login(request,response);
        		break;
        	case "/register":
        		register(request, response);
        		break;
        	case "/initialize":
        		userDAO.init();
        		System.out.println("Database successfully initialized!");
        		rootPage(request,response,"");
        		break;
        	case "/root":
        		rootPage(request,response, "");
        		break;
        	case "/logout":
        		logout(request,response);
        		break;
        	 case "/list": 
                 System.out.println("The action is: listUser");
                 listUser(request, response);           	
                 break;
        	 case "/listQuotes":
        		 System.out.println("The action is: listQuotes");
        		 listQuote(request, response);
        	 case "/submitQuote":
        		 System.out.println("The action is: submitQuote");
        		 submitQuote(request,response);
        		 break;
	    	}
	    }
	    catch(Exception ex) {
        	System.out.println(ex.getMessage());
	    	}
	    }
        	
	    private void listUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        System.out.println("listUser started: 00000000000000000000000000000000000");

	     
	        List<user> listUser = userDAO.listAllUsers();
	        request.setAttribute("listUser", listUser);       
	        RequestDispatcher dispatcher = request.getRequestDispatcher("UserList.jsp");       
	        dispatcher.forward(request, response);
	     
	        System.out.println("listUser finished: 111111111111111111111111111111111111");
	    }
	    
	    private void listQuote(HttpServletRequest request, HttpServletResponse response) 
	    		throws SQLException, IOException, ServletException {
	        System.out.println("listQuote started: 00000000000000000000000000000000000");
	        
	        List<Quote> listQuote = QuoteDAO.listAllQuotes();
	        request.setAttribute("listQuote", listQuote);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("QuoteList.jsp");
	        dispatcher.forward(request, response);
	        
	        System.out.println("listQuote finished: 111111111111111111111111111111111111");

	    }
	    	        
	    private void rootPage(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("root view");
			request.setAttribute("listUser", userDAO.listAllUsers());
			request.setAttribute("listQuotes", QuoteDAO.listAllQuotes());
	    	request.getRequestDispatcher("rootView.jsp").forward(request, response);
	    }
	    
	    private void davidSmith(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("David Smith");
			request.setAttribute("listUser", userDAO.listAllUsers());
			request.setAttribute("listQuotes", QuoteDAO.listAllQuotes());
	    	request.getRequestDispatcher("davidSmith.jsp").forward(request, response);
	    }
	    
	    protected void submitQuote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	        String num_of_treesStr = request.getParameter("num_of_trees");
	        String budgetStr = request.getParameter("budget");

	        int num_of_trees = 0; // Initialize to a default value (or handle exceptions if parsing fails)
	        double budget = 0; // Initialize to a default value (or handle exceptions if parsing fails)

	        // Check if the data is valid (you may need more validation)
	        if (num_of_treesStr != null && budgetStr != null) {
	            try {
	                // Attempt to parse the budget string into an integer
	            	num_of_trees = Integer.parseInt(num_of_treesStr);
	            	budget = Double.parseDouble(budgetStr);

	                // Create a new Quote object with num_of_trees as a string and budget as an integer
	                Quote quote = new Quote(num_of_trees, budget);

	                // Insert the quote into the database using a QuoteDAO
	                QuoteDAO quoteDAO = new QuoteDAO(); // Initialize your DAO class
	                quoteDAO.insert(quote); // Implement this method in your DAO to insert the quote into the database

	                // Redirect to a confirmation page or perform other actions
	                //response.sendRedirect("quoteConfirmation.jsp");
	            } catch (NumberFormatException e) {
	                // Handle the case where budget is not a valid integer
	                request.setAttribute("error", "Invalid budget. Please enter a valid number.");
	                request.getRequestDispatcher("activity.jsp").forward(request, response);
	            }
	        } else {
	            // Handle invalid data
	            request.setAttribute("error", "Invalid data. Please fill out all fields.");
	            request.getRequestDispatcher("quoteForm.jsp").forward(request, response);
	        }
	    }


	    
	    
	    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	 String username = request.getParameter("username");
	    	 String password = request.getParameter("password");
	    	 
	    	 if (username.equals("root") && password.equals("pass1234")) {
				 System.out.println("Login Successful! Redirecting to root");
				 session = request.getSession();
				 session.setAttribute("username", username);
				 rootPage(request, response, "");
	    	 }
	    	 if (username.equals("David Smith") && password.equals("pass1234")) {
				 System.out.println("Login Successful! Redirecting to David Smith");
				 session = request.getSession();
				 session.setAttribute("username", username);
				 davidSmith(request, response, "");
	    	 }
	    	 else if(userDAO.isValid(username, password)) 
	    	 {
	    		 int role_ID = userDAO.getRoleID(username);
	    		 if (role_ID == 1) {
	    			 currentUser = username;
					 System.out.println("Login Successful! Redirecting");
					 request.getRequestDispatcher("activitypage.jsp").forward(request, response);
	    		 }
	    		 if (role_ID == 2) {
	    			 System.out.println("Login Successful! Redirecting to root");
					 session = request.getSession();
					 session.setAttribute("username", username);
					 rootPage(request, response, "");
	    		 }
	    		 if (role_ID == 3) {
	    			 System.out.println("Login Successful! Redirecting to David Smith");
					 session = request.getSession();
					 session.setAttribute("username", username);
					 davidSmith(request, response, "");
	    		 }
			 			 			 			 
	    	 }
	    	 else {
	    		 request.setAttribute("loginStr","Login Failed: Please check your credentials.");
	    		 request.getRequestDispatcher("login.jsp").forward(request, response);
	    	 }
	    }
	           
	    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	String username = request.getParameter("Username");
	        String password = request.getParameter("Password");
	        String confirm = request.getParameter("Confirmation");
	        String roleID_String = request.getParameter("role");
	        int roleID = 1;
	        
	        if (roleID_String.equals("user")) {
	        	roleID = 1;
	        }
	        else if (roleID_String.equals("root")) {
	        	roleID = 2;
	        }
	        else if (roleID_String.equals("davidsmith")) {
	        	roleID = 3;
	        }
	        
	        
	        System.out.println("Role ID: " + roleID_String);
	        
	        if (password.equals(confirm)) {
	   	 		if (!userDAO.checkUsername(username)) {
		   	 		System.out.println("Registration Successful! Added to database");
		            user users = new user(username, password, roleID);
		   	 		userDAO.insert(users);
		   	 		userDAO.setQuote_id(users);
		   	 		response.sendRedirect("login.jsp");
	   	 		}
		   	 	else {
		   	 		System.out.println("Username taken, please enter new username");
		    		 request.setAttribute("errorOne","Registration failed: Username taken, please enter a new username.");
		    		 request.getRequestDispatcher("register.jsp").forward(request, response);
		   	 	}
	   	 	}
	   	 	else {
	   	 		System.out.println("Password and Password Confirmation do not match");
	   		 request.setAttribute("errorTwo","Registration failed: Password and Password Confirmation do not match.");
	   		 request.getRequestDispatcher("register.jsp").forward(request, response);
	   	 	}
	    }    
	    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    	currentUser = "";
        		response.sendRedirect("login.jsp");
        	}   
}
	        