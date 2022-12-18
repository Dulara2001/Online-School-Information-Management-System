package com.sims_servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sims_models.Admin;
import com.sims_models.Auth;
import com.sims_models.Notices;
import com.sims_models.Student;
import com.sims_models.Subject;
import com.sims_models.Teacher;
import com.sims_service.AdminService;
import com.sims_service.LoginDao;
import com.sims_service.NoticesServices;
import com.sims_service.StudentService;
import com.sims_service.TeacherService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Auth user;
	Student student;
	Teacher teacher;
	Subject subject;
	Admin admin;
	String username;
	String userstate;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		user = (Auth) LoginDao.validate(username, password);
		
		RequestDispatcher dispatcher;
		
		if (user != null) {
			
			HttpSession session=request.getSession();  
	        session.setAttribute("username",username); 
	        session.setAttribute("userState", user.getUserState());
	        session.setAttribute("AUID", user.getAuid());
	        
	        response.sendRedirect("./Profile");
		}

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher;
		HttpSession session = request.getSession();

		username = (String) session.getAttribute("username");
		userstate = (String) session.getAttribute("userState");
		

		if (username != null) {
			response.sendRedirect("./Profile");
		}else {
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}
	

}
