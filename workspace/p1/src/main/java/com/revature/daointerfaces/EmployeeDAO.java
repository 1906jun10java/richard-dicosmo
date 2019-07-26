package com.revature.daointerfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Reimbursement;

public interface EmployeeDAO {
	//Outlines all the methods included in the DAO
	//Method to create requests for Reimbursement
	public boolean createRequest(String username, String title, String description);
	//Method to view personal pending requests
	public ArrayList<Reimbursement> getAllRequests(String username) throws SQLException;
	
	
	
}
