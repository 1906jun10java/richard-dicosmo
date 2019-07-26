package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDAOImp;

@WebServlet("/createRequest")
public class CreateRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String title = request.getParameter("createTitle");
		String description = request.getParameter("createDescription");
		if (session != null && session.getAttribute("username") != null) {
			String username = session.getAttribute("username").toString();
			EmployeeDAOImp edao = new EmployeeDAOImp();
			boolean status = edao.createRequest(username, title, description);
			ObjectMapper mapper = new ObjectMapper();
			response.getWriter().write(mapper.writeValueAsString(status));
		}else {
			System.out.println("Could not find session");
			response.getWriter().write("{\"session\":null}");
		}
	}

}
