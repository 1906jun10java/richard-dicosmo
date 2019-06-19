package yourworkhere;

public class CheckingAccount extends Account{
	public double overdraftFee = 35;
	
	//constructor
	public CheckingAccount(String accountID, String firstName, String lastName) {
		this.accountID = accountID;
		this.firstName = firstName;
		this.lastname = lastName;
	}
	public CheckingAccount(String accountID, double balance, String accountType, String firstName, String lastname) {
		super(accountID, balance, accountType, firstName, lastname);
		
	}

	//getter
	public double getOverdraftFee() {
		return overdraftFee;
	}
	//setter
	public void setOverdraftFee(double overdraftFee) {
		this.overdraftFee = overdraftFee;
	}

	@Override
	public String toString() {
		return "CheckingAccount [overdraftFee=" + overdraftFee + ", accountID=" + accountID + ", balance=" + balance
				+ ", accountType=" + accountType + ", firstName=" + firstName + ", lastname=" + lastname + "]";
	}

	//Account Manager system
	@Override
	public IAccountManager getAccountManager() {
		CheckingAccountManager c = new CheckingAccountManager(this);
		return c;
	}
	
	
	
	
	
}
