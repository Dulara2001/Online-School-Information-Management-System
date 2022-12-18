package com.sims_servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims_models.Timetables;
import com.sims_service.TimetableDao;

/**
 * Servlet implementation class ShowEditFormTimetables
 */
@WebServlet("/ShowEditFormTimetables")
public class ShowEditFormTimetables extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Timetables tb = TimetableDao.selectTeacherTimetable(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AddTimeTables.jsp");
		request.setAttribute("timetable", tb);
		dispatcher.forward(request, response);
	}

}
