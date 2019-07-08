package com.revature.driver;

import java.sql.SQLException;

import com.revature.DAOImp.DBDAOImp;

public class Driver {

	public static void main(String[] args) {
		DBDAOImp db = new DBDAOImp();
		
		try {
			db.createEmployee("John", "Doe", 6, 150000, "JDC@gmail.com");
			db.displayAverageSalary();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
