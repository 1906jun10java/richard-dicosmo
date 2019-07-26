package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursement;
import com.revature.dao.EmployeeDAOImp;



@WebServlet("/getAllPersonalRequests")
public class GetAllPersonalRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDAOImp dao = new EmployeeDAOImp();
		ArrayList<Reimbursement> r = null;
		HttpSession session = request.getSession();
		//System.out.println(session.getAttribute("username").toString());
		if (session != null && session.getAttribute("username") != null) {
			try {
				String username = session.getAttribute("username").toString();
				r = dao.getAllRequests(username);
				response.getWriter().write((new ObjectMapper()).writeValueAsString(r));
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("{\"session\":null}");
			}
		} else {
			System.out.println("Could not find session");
			response.getWriter().write("{\"session\":null}");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
