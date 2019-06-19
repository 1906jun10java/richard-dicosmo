package com.yourname;

public class TestBank {

	public static void main(String[] args) {
		//create main instances
		Bank myBank = new Bank();
		Client scrooge = new Client("Scrooge");
		Client mary = new Client("Mary");
		
		//Scrooge opens an account
		BankAccount scroogeAccount = myBank.openAccount(scrooge, 400.00, "checking");
		BankAccount maryAccount = myBank.openAccount(mary, 100.00, "savings");
		
		//Set the accounts on the clients
		scrooge.setAccount(scroogeAccount);
		mary.setAccount(maryAccount);
		
		//print the account details
		System.out.println(scrooge.getAccount());
		System.out.println(mary.getAccount());
		
		//simulate a deposit
		myBank.deposit(mary.getAccount().getAccountNo(), 1);
		System.out.println(mary.getAccount());
		
		//simulate a withdrawal
		myBank.withdrawal(scrooge.getAccount().getAccountNo(), 400);
		System.out.println(scrooge.getAccount());
		myBank.withdrawal(mary.getAccount().getAccountNo(), 3);
		System.out.println(mary.getAccount());
	}
}
