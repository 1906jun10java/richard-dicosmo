package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.User;
import com.revature.dao.AccountDAOImp;

/**
 * Servlet implementation class UpdateInfoServlet
 */

@WebServlet("/updateinfo")
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		HttpSession session = request.getSession(); 
		AccountDAOImp adao = new AccountDAOImp();
		try {
				System.out.println("Updating email for: " + session.getAttribute("username").toString());
				adao.updateInfo(session.getAttribute("username").toString(), email);
				//Pulls user information and validates the update
				User u = adao.pullInfo(session.getAttribute("username").toString()); 
				adao.updateInfo(u.getUsername(), email);
				session.setAttribute("email", u.getEmail());

				response.sendRedirect("account.html");
			
		} catch (SQLException e) {
			response.setStatus(400);
			e.printStackTrace();
		}
	}

}
