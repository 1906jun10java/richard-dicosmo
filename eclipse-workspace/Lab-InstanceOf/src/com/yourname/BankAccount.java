package com.yourname;

public abstract class BankAccount {
	private static long accountCount = 0;
	private long accountNo;
    private double funds;
    
    public BankAccount() {}
    public BankAccount(double funds) {
    	this.accountNo = BankAccount.accountCount++;
    	this.funds = funds;
    }
    
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public double getFunds() {
		return funds;
	}
	public void setFunds(double funds) {
		this.funds = funds;
	}    
	
	public void deposit(double amount) {
		System.out.println("making a deposit...");
		this.setFunds(amount + this.getFunds());
	}

	public double withdrawal(double amount) {
		System.out.println("making a withdrawal...");
		this.setFunds(this.getFunds() - amount);
		
		return amount;
	}
}
