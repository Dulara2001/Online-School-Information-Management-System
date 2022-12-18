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

import com.sims_models.Marks;
import com.sims_models.Student;
import com.sims_service.ResultsDao;
import com.sims_service.StudentService;

/**
 * Servlet implementation class viewResult
 */
@WebServlet("/viewResult")
public class viewResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Marks[] marks;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		RequestDispatcher dispatcher;
		
		try {
			int auid = (int) session.getAttribute("AUID");
			Student student = StudentService.selectStudentById(auid);
			
			int sid = student.getSid();
			String exam = request.getParameter("exam");
			String year = request.getParameter("year");
			
			String year_exam =year + exam;
			
			marks = ResultsDao.getResults(sid, year_exam);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		dispatcher = request.getRequestDispatcher("viewResult.jsp");
		request.setAttribute("marks", marks);
		dispatcher.forward(request, response);
		
		
	}

}
