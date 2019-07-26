package com.revature.dao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;


import com.revature.connections.ConnFactory;


public class AccountDAOImpTest {
	public static ConnFactory cf = ConnFactory.getInstance();
	AccountDAOImp dao = new AccountDAOImp();
	@Test
	public void getUserIDTest() throws SQLException {
		String username = "Goombazio";
		int test = 1;
		int actual = dao.getUserID(username);
		assertEquals(test, actual);
	}
	
}
