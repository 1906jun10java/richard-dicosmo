package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Credentials;
import com.revature.beans.User;
import com.revature.service.AuthenticationService;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{	
	
	private AuthenticationService authService = new AuthenticationService();
	
	//No logic belongs in the servlets. Should have only code related to handling requests and formatting responses
	//all application logic should be occurring in service classes
	/*
	 * doGet: this method will handle all GET requests made to this servlet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//Write a message to the response body with the PrintWriter
		//resp.getWriter().write("hello from Login Servlet");
		//serve the Login.html page as the response
		//The request dispatcher is used to perform a 'forward' - passing a request to another resource with the client's awareness
		req.getRequestDispatcher("Login.html").forward(req, resp);
	}
	/*
	 * doPost this method will handle all POST requests made to this servlet
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//Grab the credentials from the request
		Credentials creds = new Credentials(req.getParameter("username"), req.getParameter("password"));
		User u = authService.authenticateUser(creds);
		if (u != null) {
			//resp.getWriter().write("Welcome, " + u.getFirstname() + " " + u.getLastname());
			//redirect the user to their profile page if authenticated.
			resp.sendRedirect("profile");
		}else {
			//What if the credentials are wrong?
			//Option 1: print message
			//Option 2: redirect back to login
			
			//resp.getWriter().write("invalid credentials");
			//Option 3: send 403 response
			resp.sendError(403, "Invalid Credentials");
		}
	}
	

}
