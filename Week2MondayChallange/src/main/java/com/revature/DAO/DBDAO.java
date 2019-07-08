package com.revature.DAO;

import java.sql.SQLException;

public abstract class DBDAO {

	public abstract void createEmployee(String firstName, String lastName, int departmentID, double salary, String email) throws SQLException;
	public abstract void displayAverageSalary() throws SQLException;
}
