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
import com.sims_models.Student;
import com.sims_models.Subject;
import com.sims_models.Teacher;
import com.sims_models.Notices;
import com.sims_service.AdminService;
import com.sims_service.NoticesServices;
import com.sims_service.StudentService;
import com.sims_service.TeacherService;

/**
 * Servlet implementation class notices
 */
@WebServlet("/Profile")
public class ViewProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Notices[] notices;
	String username;
	String userstate;
	int AUID;

	Student student;
	Teacher teacher;
	Subject subject;
	Admin admin;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher;
		HttpSession session = request.getSession();

		username = (String) session.getAttribute("username");
		userstate = (String) session.getAttribute("userState");
		try {
			AUID = (int) session.getAttribute("AUID");
		} catch (NullPointerException e) {
			response.sendRedirect("./Login");
			return;
		}
		
		System.out.println(request.getContextPath());

		try {
			notices = NoticesServices.getNotices(userstate);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		switch (userstate) {
		case "student": {

			try {
				student = StudentService.selectStudentById(AUID);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			dispatcher = request.getRequestDispatcher("student-profile.jsp");
			request.setAttribute("student", student);
			request.setAttribute("recentNotices", notices);
			dispatcher.forward(request, response);
			break;
		}
		case "teacher": {
			teacher = TeacherService.selectTeacherById(AUID);
			subject = TeacherService.getSubjectName(teacher.getSbid());

			dispatcher = request.getRequestDispatcher("teacher-profile.jsp");
			request.setAttribute("teacher", teacher);
			request.setAttribute("subject", subject);
			request.setAttribute("recentNotices", notices);
			dispatcher.forward(request, response);
			break;
		}
		case "admin": {
			admin = AdminService.selectAdminById(AUID);

			dispatcher = request.getRequestDispatcher("admin-profile.jsp");
			request.setAttribute("admin", admin);
			request.setAttribute("recentNotices", notices);
			dispatcher.forward(request, response);
			break;
		}
		default:
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			break;
		}

	}
}
