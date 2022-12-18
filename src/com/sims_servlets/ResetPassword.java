package com.sims_servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sims_service.UpdateProfileService;


@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int auid = (int) session.getAttribute("AUID");
			String password, newPassword;
			
			password = request.getParameter("pwd");
			newPassword = request.getParameter("new-pwd");
			
			boolean isAdded = UpdateProfileService.checkPassword(auid, password, newPassword);
			
			if (isAdded) {
				//TODO Add alert
				response.sendRedirect("Profile");
				
			}
			else {
				response.sendRedirect("ShowEditFormPassword");
			}

	}
}
