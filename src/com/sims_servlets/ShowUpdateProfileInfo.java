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
import com.sims_models.Student;
import com.sims_service.UpdateProfileService;

/**
 * Servlet implementation class ShowUpdateProfileInfo
 */
@WebServlet("/ShowUpdateProfileInfo")
public class ShowUpdateProfileInfo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		int auid = (int) session.getAttribute("AUID");
		
		Student std = UpdateProfileService.selectStudentInfo(auid);
		Auth auth = UpdateProfileService.selectAuthInfo(auid);
		
		request.setAttribute("student", std);
		request.setAttribute("auth", auth);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("updateProfile.jsp");
		dispatcher.forward(request, response);
	}

}
