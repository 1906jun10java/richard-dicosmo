package yourworkhere;

public class SavingsAccountManager implements IAccountManager {
	//creates instance of savings account
	private SavingsAccount account;
	
	//constructor
	public SavingsAccountManager(SavingsAccount account) {
		this.account = account;
	}
	
	
	//methods
	@Override
	public boolean deposit(double value) {
		//Checks value for negatives
		if (value <= 0) {
			System.out.println("Please Input a positive value.");
			return false;
		}else {
			account.setBalance(account.getBalance() + value);
			return true;
		}
	}
	
	@Override
	public boolean withdraw(double value) {
		//checks value for negatives 
		if (value <= 0 || account.getCurrentMonthlyWithdrawals() >= account.getMaxMonthlyWithdrawals()) {
			System.out.println("Please check that your input is a positive value.");
			System.out.println("Max withdrawals = " + account.getMaxMonthlyWithdrawals() + " Current = " + account.getCurrentMonthlyWithdrawals());
			return false;
		}else if (value > account.getBalance() ||  account.getCurrentMonthlyWithdrawals() >= account.getMaxMonthlyWithdrawals()){
			System.out.println("Withdrawing more than the value of the account is not allowed.");
			System.out.println("Max withdrawals = " + account.getMaxMonthlyWithdrawals() + " Current = " + account.getCurrentMonthlyWithdrawals());
			return false;
		}else {
			account.setCurrentMonthlyWithdrawals(account.getCurrentMonthlyWithdrawals() + 1);
			account.setBalance(account.getBalance() - value);
			return true;
		}
	}
	
	
	
}
