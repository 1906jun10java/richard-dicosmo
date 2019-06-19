package yourworkhere;

public abstract class Account {
	
	//Variables for class
	protected String accountID;
	protected double balance;
	protected String accountType;
	protected String firstName;
	protected String lastname;
	
	
	//Constructor
	public Account() {}
	public Account(String accountType, String firstName, String lastName) {
		this.accountType = accountType;
		this.firstName = firstName;
		this.lastname = lastName;
	}
	public Account(String accountID, double balance, String accountType, String firstName, String lastname) {
		super();
		this.accountID = accountID;
		this.balance = balance;
		this.accountType = accountType;
		this.firstName = firstName;
		this.lastname = lastname;
	}
	
	
	//Access to object data
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	} 
	
	//Account manager method control
	public abstract IAccountManager getAccountManager();
	
}
