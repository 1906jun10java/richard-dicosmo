package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Reimbursement;
import com.revature.connections.ConnFactory;
import com.revature.daointerfaces.EmployeeDAO;

public class EmployeeDAOImp implements EmployeeDAO{

	public static ConnFactory cf = ConnFactory.getInstance();
	@Override
	public boolean createRequest(String username, String title, String description) {
		boolean created = false;
		AccountDAOImp adao = new AccountDAOImp();
		try {
			int userID = adao.getUserID(username);
			Connection conn = cf.getConnection();
			String sql = "INSERT INTO REIMBURSEMENTS VALUES(REIMBURSEMENTSEQ.NEXTVAL,?,?,?,?,?,?)";
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, userID);
				ps.setString(2, title);
				ps.setString(3, description);
				ps.setString(4, null);
				ps.setString(5, null);
				ps.setString(6, null);
				ps.executeUpdate();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				created = false;
			}
		} catch (SQLException e) {
			return false;
		}
		return created;
	}

	@Override
	public ArrayList<Reimbursement> getAllRequests(String username) throws SQLException {
		ArrayList<Reimbursement> list = new ArrayList<Reimbursement>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE USER_ID IN (SELECT USER_ID FROM USERS WHERE USERNAME=?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		Reimbursement r = null;
		while (rs.next()) {
			r = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(6), rs.getInt(7));
			list.add(r);
			//System.out.println(r);
		}
		return list;
	}
	
	

}
