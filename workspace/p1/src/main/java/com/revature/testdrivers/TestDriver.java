package com.revature.testdrivers;

import java.sql.SQLException;

import com.revature.dao.AccountDAOImp;

public class TestDriver {

	public static void main(String[] args) {
		AccountDAOImp acc = new AccountDAOImp();
		try {
			System.out.println(acc.getValidation("Goombazio", "pass"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
