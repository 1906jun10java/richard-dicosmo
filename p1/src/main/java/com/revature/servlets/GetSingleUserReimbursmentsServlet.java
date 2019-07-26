package com.revature.servlets;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursement;

import com.revature.dao.ManagerDAOImp;


@WebServlet("/searchSingleR")
public class GetSingleUserReimbursmentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerDAOImp dao = new ManagerDAOImp();
		ArrayList<Reimbursement> r = null;
		ObjectMapper mapper = new ObjectMapper();		
		try {
			r = dao.viewAUserRequests(request.getParameter("firstname"), request.getParameter("lastname"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().write(mapper.writeValueAsString(r));
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
