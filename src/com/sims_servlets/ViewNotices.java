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

/**
 * Servlet implementation class notices
 */
@WebServlet("/Notices")
public class ViewNotices extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Notices[] notices;
	String username;
	String userstate;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher;
		HttpSession session = request.getSession();

		username = (String) session.getAttribute("username");
		userstate = (String) session.getAttribute("userState");
		

		if (username.length() >= 1) {
			try {
				notices = NoticesServices.getNotices(userstate);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			dispatcher = request.getRequestDispatcher("Notices.jsp");
			request.setAttribute("notices", notices);
			dispatcher.forward(request, response);
		}
	}

}
