package com.revature.daointerfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import com.revature.beans.User;

public interface AccountDAO {
	//Outlines all the methods included in the DAO
	//Method for checking credentials against database
	public boolean getValidation(String username, String pass) throws SQLException;
	//Method for getting user information
	public User pullInfo(String username) throws SQLException;
	//Method to update information
	public boolean updateInfo(String username, String email);
	//Method to create user
	public boolean createUser(String username, String pass, String firstName, String lastName, String email, int seesTo, String title);
	//gets user_ID for user
	public int getUserID(String username) throws SQLException;
	//Get all users
	public ArrayList<User> getAllUsers() throws SQLException;
}
