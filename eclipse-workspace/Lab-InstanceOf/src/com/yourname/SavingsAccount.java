package com.yourname;

public class SavingsAccount extends BankAccount{

	public SavingsAccount(double amount) {
		super(amount);
	}
	
	@Override
	public String toString() {
		return "Savings Account [Account Number: " + this.getAccountNo() + ", funds: " + this.getFunds() + "]";
	}
}
