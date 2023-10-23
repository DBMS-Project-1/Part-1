public class user 
{
		protected int unique_id;
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

	    public user(String username, String password, int RoleID) {
	        this.username = username;
	        this.password = password;
	        this.role_id = RoleID;
	    }
	    
	    public user(int uniqueId,String username, String password, int RoleID) {
	    	this.unique_id = uniqueId;
	        this.username = username;
	        this.password = password;
	        this.role_id = RoleID;
	    }
	 
	    
	   //getter and setter methods
	    
	    public int getUniqueId() {
	        return unique_id;
	    }
	    public void setUniqueId(int unique_id) {
	        this.unique_id = unique_id;
	    }
	    
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