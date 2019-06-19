package yourworkhere;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Ledger {
	//the single instance of Ledger
	private static final Ledger instance = new Ledger();
	//The HashMap for functions
	private static HashMap<String, Account> accounts = new HashMap<>();
	
	//private constructor    
	private Ledger() {}
	
	//method to return the single instance
	public static Ledger getInstance(){
	    return instance;
	}
	
	//Other Methods
	public boolean store(Account value) {
		//Stores an account in the hashMap
		accounts.put(value.getAccountID(), value);
		return true;
	}
	
	public Account retrieve(String key) {
		//Retrieves value based on key
		return accounts.get(key);
	}
	
	public Account createAccount(String type, String firstName, String lastName) {
		//creates account
		Account account;
		if( type.equals("checking") ) {
			account = new CheckingAccount(getNextAccountID(), firstName, lastName);
			account.accountType = "checking";
			return account;
		}else if(type.equals("savings") ) {
			account = new SavingsAccount(getNextAccountID(), firstName, lastName);
			account.accountType = "savings";
			return account;
		}else {
			System.out.println("Failed to create account.");
			return null;
		}
		
	}
	
	public String getNextAccountID() {
		//creates an ID for the next created account
		String id = Integer.toString(accounts.size());
		return id;
	}
	
	public List<Account> getAllAccounts() {
		//gets all accounts and returns them as a list

        //creates a ArrayList object
        List<Account> list = new ArrayList<>();

        for(int i = 0; i < accounts.size(); i++) {
            //System.out.println("I'm adding an account at id " + i);
            list.add(retrieve(""+i));
        }

        //returns the list
         return list;
		
	}
	
	
	
}
