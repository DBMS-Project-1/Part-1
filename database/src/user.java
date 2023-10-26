public class user 
{
		protected String username;
		protected String password;
		protected int role_id;

	 
	    //constructors
	    public user() {
	    }
	 
	    public user(String username) 
	    {
	        this.username = username;
	    }

	    public user(String username, String password, int roleID) {
	    	this(password,roleID);
	        this.username = username;
	    }
	    
	    public user(String password, int roleID) {
	    	this.password = password;
	    	this.role_id = roleID;
	    }
	    
	    
	   //getter and setter methods
	    
	    public String getUsername() {
	        return username;
	    }
	    public void setUsername(String username) {
	        this.username = username;
	    }
	    
	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    
	    public int getRoleId() {
	        return role_id;
	    }
	    public void setRoleId(int role_id) {
	        this.role_id = role_id;
	    }
	}