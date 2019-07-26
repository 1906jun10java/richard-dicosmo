package com.revature.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.dao.AccountDAOImp;

@WebServlet("/createEmployee")
public class CreateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("createUsername");
		String pass = request.getParameter("createPassword");
		String firstName = request.getParameter("createFirstname");
		String lastName = request.getParameter("createLastname");
		String email = request.getParameter("createEmail");
		String seesTo = request.getParameter("createSeesto");
		String title = request.getParameter("titleselector");
		AccountDAOImp adao = new AccountDAOImp();
		boolean status = adao.createUser(username, pass, firstName, lastName, email, Integer.parseInt(seesTo), title);
		//Pulls user information and validates the update
		
		ObjectMapper mapper = new ObjectMapper();
		response.getWriter().write(mapper.writeValueAsString(status));
	}

}
