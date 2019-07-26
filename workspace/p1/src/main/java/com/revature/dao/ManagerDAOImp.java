package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Reimbursement;
import com.revature.connections.ConnFactory;
import com.revature.daointerfaces.ManagerDAO;

public class ManagerDAOImp implements ManagerDAO{

	public static ConnFactory cf = ConnFactory.getInstance();
	//View all reimbursements from one user
	public ArrayList<Reimbursement> viewAUserRequests(String firstName, String lastName) throws SQLException{
		ArrayList<Reimbursement> list = new ArrayList<Reimbursement>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE USER_ID IN (SELECT USER_ID FROM USERS WHERE FIRSTNAME=? AND LASTNAME=?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ResultSet rs = ps.executeQuery();
		Reimbursement r = null;
		while (rs.next()) {
			r = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(6), rs.getInt(7));
			list.add(r);
		}
		return list;
	}
	@Override
	public ArrayList<Reimbursement> getAllRequests() throws SQLException {
		ArrayList<Reimbursement> list = new ArrayList<Reimbursement>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM REIMBURSEMENTS";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		Reimbursement r = null;
		while (rs.next()) {
			r = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(6), rs.getInt(7));
			list.add(r);

		}
		return list;
	}
	@Override
	public ArrayList<Reimbursement> getAllManagedRequests(String username) throws SQLException {
		ArrayList<Reimbursement> list = new ArrayList<Reimbursement>();
		AccountDAOImp adao = new AccountDAOImp();
		int userID = adao.getUserID(username);
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE USER_ID IN (SELECT USER_ID FROM USERS WHERE SEES_TO=?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userID);
		ResultSet rs = ps.executeQuery();
		Reimbursement r = null;
		while (rs.next()) {
			r = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(6), rs.getInt(7));
			list.add(r);

		}
		return list;
	}
	@Override
	public boolean manageRequest(int reimbursementID, int answerCode, int managerID) throws SQLException {
		boolean status = false;
		Connection conn = cf.getConnection();
		String sql = "UPDATE REIMBURSEMENTS SET STATUS =?, RESOLVED_BY=? WHERE REIMBURSEMENT_ID=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, answerCode);
			ps.setInt(2, managerID);
			ps.setInt(3, reimbursementID);
			ps.executeUpdate();
			status = true;
		} catch (SQLException e) {
			status = false;
			e.printStackTrace();
		}
		return status;
	}
	
}
