package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.User;
import com.revature.dao.AccountDAOImp;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.html").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		HttpSession session = request.getSession(); 
		AccountDAOImp adao = new AccountDAOImp();
		try {
			if(adao.getValidation(username, pass) != false) {
				//System.out.println("Welcome " + username);
				//Pulls user information and creates a session for the user
				User u = adao.pullInfo(username); 
				session.setAttribute("username", u.getUsername());
				session.setAttribute("firstName", u.getFirstName());
				session.setAttribute("lastName", u.getLastName());
				session.setAttribute("email", u.getEmail());
				session.setAttribute("seesTo", u.getSeesTo());
				session.setAttribute("title", u.getTitle());
				//Sends the user to the main menu
//				String nextPage = "/main.html";
//				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
//				dispatcher.forward(request,response);
				response.sendRedirect("main.html");
			}else {
				String nextPage = "/index.html";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
				dispatcher.forward(request,response);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
