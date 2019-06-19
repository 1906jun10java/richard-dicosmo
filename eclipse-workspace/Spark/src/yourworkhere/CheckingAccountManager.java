package yourworkhere;

public class CheckingAccountManager implements IAccountManager{
	//Creates instance of checking account
	private CheckingAccount account;
	
	
	//constructor
	public CheckingAccountManager(CheckingAccount account) {
		this.account = account;
	}
	
	//Methods
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
		//checks value for negatives and subtracts over draft fee if below threshold. 
		if (value <= 0) { 
			System.out.println("Please Input a positive value.");
			return false;
		}else if (value > account.getBalance()){
			account.setBalance((account.getBalance() - value) - account.getOverdraftFee());
			System.out.println("An overdraft fee of " + account.overdraftFee + " was deducted from the account.");
			throw new OverdraftException();
		}else {
			account.setBalance(account.getBalance() - value);
			return true;
		}
	}
	
	
	
}
