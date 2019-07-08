package com.revature.DAOImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.DAO.DBDAO;
import com.revature.connections.ConnFactory;

public class DBDAOImp extends DBDAO {

	public static ConnFactory cf = ConnFactory.getInstance();
	@Override
	public void createEmployee(String firstName, String lastName, int departmentID, double salary, String email)
			throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO EMPLOYEE VALUES(EMPLOYEESEQ.NEXTVAL,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, firstName); 
		ps.setString(2, lastName); 
		ps.setInt(3, departmentID);
		ps.setDouble(4, salary); 
		ps.setString(5, email);
		ps.executeUpdate();
		System.out.println("Added " + firstName + " " + lastName + " to employee list.");
	}

	@Override
	public void displayAverageSalary() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT DEPARTMENT.DEPARTMENT_NAME, AVG(EMPLOYEE.SALARY) FROM DEPARTMENT INNER JOIN EMPLOYEE ON EMPLOYEE.DEPARTMENT_ID = DEPARTMENT.DEPARTMENT_ID GROUP BY DEPARTMENT.DEPARTMENT_NAME";
		PreparedStatement stmt = conn.prepareStatement(sql);
		//stmt.setInt(1, user_id);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println("Average salary for Department " + rs.getString(1) + " = " + rs.getDouble(2));
		}
	}

	
}
