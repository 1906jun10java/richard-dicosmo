package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.revature.beans.User;
import com.revature.connections.ConnFactory;
import com.revature.daointerfaces.AccountDAO;

public class AccountDAOImp implements AccountDAO{

	public static ConnFactory cf = ConnFactory.getInstance();
	
	//Returns true if the user is valid, otherwise returns false
	@Override
	public boolean getValidation(String username, String pass) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "SELECT USERNAME, PASS FROM USERS WHERE USERNAME = ? AND PASS =?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, pass);
		ps.executeUpdate();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			if(rs.getString(2).contentEquals(pass)) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}

	//returns a user object with the inputed user
	@Override
	public User pullInfo(String username) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM USERS WHERE USERNAME=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.executeUpdate();
		ResultSet rs = ps.executeQuery();
		User u = null;
		while (rs.next()) {
		u = new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));
		//System.out.println(u);
		}
		return u;
	}

	//Updates user information, returns true if the update works and false if it does not
	@Override
	public boolean updateInfo(String username, String email){
		Connection conn = cf.getConnection();
		String sql = "UPDATE USERS SET EMAIL = ? WHERE USERNAME = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, username);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	//Creates a new user on the database
	@Override
	public boolean createUser(String username, String pass, String firstName, String lastName, String email, int seesTo, String title){
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO USERS VALUES(USERSEQ.NEXTVAL,?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pass);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			ps.setString(5, email);
			ps.setInt(6, seesTo);
			ps.setString(7, title);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public int getUserID(String username) throws SQLException {
		int id = 0;
		Connection conn = cf.getConnection();
		String sql = "SELECT USER_ID FROM USERS WHERE USERNAME=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			id = rs.getInt(1);
		}
		return id;
	}

	@Override
	public ArrayList<User> getAllUsers() throws SQLException {
		Logger logger = Logger.getGlobal();
		logger.info("This log worked");
		ArrayList<User> userList = new ArrayList<User>();
		Connection conn = cf.getConnection();
		String sql = "SELECT USER_ID, FIRSTNAME, LASTNAME, EMAIL, SEES_TO, TITLE FROM USERS ORDER BY SEES_TO";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		User u = null;
		while (rs.next()) {
			u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
			//System.out.println(u.toString());
			userList.add(u);
		}
		conn.close();
		return userList;
	}
}
