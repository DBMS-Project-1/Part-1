public class user 
{
		protected String FirstName;
	 	protected String LastName;
	    protected String Address;
	    protected String City;
	    protected String State;
	    protected String ZipCode;
	    protected String CreditCardNumber;
	    protected String Expiration_Date;
	    protected String CVV;
	    protected String PhoneNumber;
	    protected String Email;
	    protected String Password;

	 
	    //constructors
	    public user() {
	    }
	 
	    public user(String email) 
	    {
	        this.Email = email;
	    }

	    public user(String FirstName,String LastName, String Address, String City, String State, String ZipCode, String CreditCardNumber, String expiration_date, String CVV, String phoneNumber, String Email, String Password) 
	    {
	    	this(FirstName, LastName, Address, City, State, ZipCode, CreditCardNumber, expiration_date, CVV, phoneNumber, Password);
	    	this.Email = Email;
	    }
	 
	
	    public user(String FirstName,String LastName, String Address, String City, String State, String ZipCode, String CreditCardNumber, String expiration_date, String CVV, String phoneNumber, String Password) 
	    {
	    	this.FirstName = FirstName;
	    	this.LastName = LastName;
	    	this.Address = Address;
	        this.City = City;
	        this.State = State;
	        this.ZipCode = ZipCode;
	        this.CreditCardNumber= CreditCardNumber;
	        this.Expiration_Date= expiration_date;
	        this.CVV = CVV;
	        this.PhoneNumber = phoneNumber;
	        this.Password = Password;
	    }
	    
	   //getter and setter methods
	    
	    public String getFirstName() {
	        return FirstName;
	    }
	    public void setFirstName(String firstName) {
	        this.FirstName = firstName;
	    }
	    
	    public String getLastName() {
	        return LastName;
	    }
	    public void setLastName(String lastName) {
	        this.LastName = lastName;
	    }
	    
	    public String getAddress() {
	        return Address;
	    }
	    public void setAdress(String adress) {
	        this.Address = adress;
	    }
	    public String getCity() {
	        return City;
	    }
	    public void setCity(String city) {
	        this.City = city;
	    }
	    public String getState() {
	        return State;
	    }
	    public void setAdress_city(String state) {
	        this.State = state;
	    }
	    public String getZipCode() {
	        return ZipCode;
	    }
	    public void setZipCode(String zipCode) {
	        this.ZipCode = zipCode;
	    }
	    public String getCreditCardNumber() {
	        return CreditCardNumber;
	    }
	    public void setCreditCardNumber(String creditCardNumber) {
	        this.CreditCardNumber = creditCardNumber;
	    }
	    
	    public String getExpirationDate() {
	        return Expiration_Date;
	    }
	    
	    public String getCVV() {
	    	return CVV;
	    }
	    public void setCVV(String cvv) {
	    	this.CVV = cvv;
	    }
	    
	    public String getEmail() {
	    	return Email;
	    }
	    public void setEmail(String email) {
	    	this.Email = email;
	    }
	    
	    public String getPassword() {
	    	return Password;
	    }
	    public void setPassword(String password) {
	    	this.Password = password;
	    }
	    
	    public String getPhoneNumber() {
	    	return PhoneNumber;
	    }
	    public void setPhoneNumber(String phoneNumber) {
	    	this.PhoneNumber = phoneNumber;
	    }
	}