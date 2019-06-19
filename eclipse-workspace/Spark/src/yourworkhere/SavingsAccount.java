package yourworkhere;

public class SavingsAccount extends Account{
	private double minBalance;
	private int currentMonthlyWithdrawals;
	private int maxMonthlyWithdrawals = 3;
	
	//constructors
	public SavingsAccount(String accountID, String firstName, String lastName) {
		this.accountID = accountID;
		this.firstName = firstName;
		this.lastname = lastName;
	}
	
	public SavingsAccount(String accountID, double balance, String accountType, String firstName, String lastname) {
		super(accountID, balance, accountType, firstName, lastname);
	}

	//getters and setters
	public double getMinBalance() {
		return minBalance;
	}
	
	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	public int getCurrentMonthlyWithdrawals() {
		return currentMonthlyWithdrawals;
	}
	public void setCurrentMonthlyWithdrawals(int currentMonthlyWithdrawals) {
		this.currentMonthlyWithdrawals = currentMonthlyWithdrawals;
	}
	public int getMaxMonthlyWithdrawals() {
		return maxMonthlyWithdrawals;
	}
	public void setMaxMonthlyWithdrawals(int maxMonthlyWithdrawals) {
		this.maxMonthlyWithdrawals = maxMonthlyWithdrawals;
	}
	
	//override toString()
	@Override
	public String toString() {
		return "SavingsAccount [minBalance=" + minBalance + ", currentMonthlyWithdrawals=" + currentMonthlyWithdrawals
				+ ", maxMonthlyWithdrawals=" + maxMonthlyWithdrawals + "]";
	}
	
	//Account Manager system
	@Override
	public IAccountManager getAccountManager() {
		SavingsAccountManager c = new SavingsAccountManager(this);
		return c;
	}
	
	
}
