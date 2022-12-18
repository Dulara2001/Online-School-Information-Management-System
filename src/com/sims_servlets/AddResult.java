package com.sims_servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims_models.Marks;
import com.sims_service.ResultsDao;

/**
 * Servlet implementation class AddResult
 */
@WebServlet("/AddResult")
public class AddResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sbid = Integer.parseInt(request.getParameter("subject"));
		String exam = request.getParameter("exam");
		int grade = Integer.parseInt(request.getParameter("grade"));
		
		for (int i=1; i<5; i++) {

			String sid = request.getParameter("studentid" + String.valueOf(i));
			String result = request.getParameter("result" + String.valueOf(i));
			
			int sidfinal = Integer.parseInt(sid);
			int resultfinal = Integer.parseInt(result);
			
			Marks marks = new Marks(sidfinal, sbid, grade, exam, resultfinal);
			
			ResultsDao.addResults(marks);
			
			
		}
		
		response.sendRedirect("Profile");
		//RequestDispatcher dispatcher = request.getRequestDispatcher("Profile");
		//dispatcher.forward(request, response);
		
	}

}
