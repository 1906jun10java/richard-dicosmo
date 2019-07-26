package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = -5095172352805670544L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// grab current session, if it exists, otherwise get a null value
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			try {
				String username = session.getAttribute("username").toString();
				String firstname = session.getAttribute("firstName").toString();
				String lastname = session.getAttribute("lastName").toString();
				String email = session.getAttribute("email").toString();
				int seesTo = Integer.parseInt(session.getAttribute("seesTo").toString());
				String title = session.getAttribute("title").toString();
				User u = new User(username, firstname, lastname, email, seesTo, title);
				response.getWriter().write((new ObjectMapper()).writeValueAsString(u));
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("{\"session\":null}");
			}
		} else {
			System.out.println("Could not find session");
			response.getWriter().write("{\"session\":null}");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
