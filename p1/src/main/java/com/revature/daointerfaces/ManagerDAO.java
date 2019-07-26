package com.revature.daointerfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Reimbursement;

public interface ManagerDAO {

	//Allows a manager to view all requests from a single user
	public ArrayList<Reimbursement> viewAUserRequests(String firstName, String lastName) throws SQLException;
	//Allows a manager to view all requests
	public ArrayList<Reimbursement> getAllRequests() throws SQLException;
	//Allows a manager to accept or deny a request
	public boolean manageRequest(int ReimbursementID, int answerCode, int managerID) throws SQLException;
	//Allows a manager to get requests only they manage
	public ArrayList<Reimbursement> getAllManagedRequests(String username) throws SQLException;
}
