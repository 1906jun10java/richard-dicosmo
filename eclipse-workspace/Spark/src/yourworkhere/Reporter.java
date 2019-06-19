package yourworkhere;

import java.util.ArrayList;
import java.util.List;

public class Reporter {
	//creates instance of ledger
	Ledger ledger;
	
	//constructor
	public Reporter(Ledger ledger) {
		this.ledger = ledger;
	}
	//Methods
	public int getNumAccounts() {
		//counts the amount of objects in the getAllAccounts list
		//creates a ArrayList object
		List<Account> list = new ArrayList<>();
		
		list = ledger.getAllAccounts();
		int accounts = list.size();
		return accounts;
		
	}
	
	public List<Account> getAccountsWithMinimum(double minimumBalance) {
		List<Account> list = ledger.getAllAccounts();
        List<Account> newList = new ArrayList<Account>();
        for(int i = 0; i < list.size(); i++) {
            //System.out.println("Hi I'm on index " + i + " and the balance of this index is: " + list.size());
            if(list.get(i).getBalance() >= minimumBalance) {
                //System.out.println("The balance meets the minimum!");
                newList.add(list.get(i));
            }
        }

        return newList;
    }
	
	
	public void printAllAccounts() {
		//prints all accounts to the console
		List<Account> list = ledger.getAllAccounts();
		 for(int i = 0; i < list.size(); i++) {
	            System.out.println(list.get(i).toString());
	        }
		
		
	}
	
	public int getNumAccountsByType(String type) {
		//returns the number of account types specified
		  int numAccounts = 0;
	        List<Account> list = ledger.getAllAccounts();

	        //System.out.println("Accounts by type started! There are " + list.size() + " accounts!");
	        if(list.get(0) == null)
	            System.out.println("It's null!");

	        for(int i = 0; i < list.size(); i++) {
	            //System.out.println("Hi I'm on index " + i + " and the account type is " + list.get(i).getAccountType());
	            if(list.get(i).getAccountType().equals(type)) {
	                //System.out.println("The account type is correct!");
	                numAccounts++;
	            }
	        }

	        //System.out.println("There were " + numAccounts + " " + type + " accounts!");
	        return numAccounts;
	}
}
