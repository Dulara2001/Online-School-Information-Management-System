package com.sims_servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sims_models.Auth;
import com.sims_service.UpdateProfileService;

/**
 * Servlet implementation class ShowEditFormPassword
 */
@WebServlet("/ShowEditFormPassword")
public class ShowEditFormPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int auid =(int) session.getAttribute("AUID");
		Auth user = UpdateProfileService.selectAuthInfo(auid);
		
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("resetPassword.jsp");
		dispatcher.forward(request, response);
	}

}
