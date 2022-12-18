package com.sims_servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sims_models.Timetables;
import com.sims_service.TimetableDao;

/**
 * Servlet implementation class ViewTimetables
 */
@WebServlet("/ViewTimetables")
public class ViewTimetables extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Timetables timetable;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");

			int teacherId = TimetableDao.getLoggedInTeacherID(username);

			timetable = TimetableDao.selectTeacherTimetable(teacherId);

			RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-timetable.jsp");
			request.setAttribute("timetable", timetable);
			dispatcher.forward(request, response);

		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
