package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.AccountDAOImp;
import com.revature.dao.ManagerDAOImp;

@WebServlet("/manageReimbursements")
public class ManageReimbursementsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reimbursementID = request.getParameter("reimbursementID");
		String answerCode = request.getParameter("answerCode");
		ManagerDAOImp mdao = new ManagerDAOImp();
		AccountDAOImp adao = new AccountDAOImp();
		HttpSession session = request.getSession(false);
		boolean status;
		try {
			
			String username = session.getAttribute("username").toString();
			if(username == null) {
				status = false;
			}else {
				int u = adao.getUserID(username);
				status = mdao.manageRequest(Integer.parseInt(reimbursementID), Integer.parseInt(answerCode), u);
			}
		} catch (NumberFormatException e) {
			status = false;
			e.printStackTrace();
		} catch (SQLException e) {
			status = false;
			e.printStackTrace();
		}
		//Pulls user information and validates the update
		
		ObjectMapper mapper = new ObjectMapper();
		response.getWriter().write(mapper.writeValueAsString(status));
	}

}
