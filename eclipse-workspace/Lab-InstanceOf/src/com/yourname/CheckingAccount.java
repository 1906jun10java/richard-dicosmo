package com.yourname;

public class CheckingAccount extends BankAccount{
	
	public CheckingAccount(double amount) {
		super(amount);
	}

	@Override
	public String toString() {
		return "Checking Account [Account Number: " + this.getAccountNo() + ", funds: " + this.getFunds() + "]";
	}

}
