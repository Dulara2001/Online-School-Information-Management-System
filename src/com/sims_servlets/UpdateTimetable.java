package com.sims_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sims_models.Timetables;
import com.sims_service.TimetableDao;
import com.sims_util.FileUpload;

/**
 * Servlet implementation class UpdateTimetable
 */
@WebServlet("/UpdateTimetable")
public class UpdateTimetable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String className, imagePath;
			int tid, year, grade;

			Timetables tb = FileUpload.getFilePathName(request);

			tid = tb.getTid();
			year = tb.getYear();
			grade = tb.getGrade();
			className = tb.getClassName();
			imagePath = tb.getImage();
			
//			System.out.println(year);
//			System.out.println(grade);
//			System.out.println(className);		
//			System.out.println(imagePath);		
//			System.out.println(tid);

			Timetables timetable = new Timetables(tid, year, grade, className, imagePath);

			boolean isAdded = TimetableDao.updateTimetables(timetable);

			if (isAdded) {

				PrintWriter out = response.getWriter();

				out.println("<script type=\"text/javascript\">");
				out.println("alert('Timetable updated');");
				out.println("location='ViewTimetables';");
				out.println("</script>");

//				RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-timetable.jsp");
//				dispatcher.forward(request, response);
				response.sendRedirect("ViewTimetables");
			} else {
				PrintWriter out = response.getWriter();

				out.println("<script type=\"text/javascript\">");
				out.println("alert('Timetable is not updated');");
				out.println("location='ViewTimetables';");
				out.println("</script>");
				
//				RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-timetable.jsp");
//				dispatcher.forward(request, response);
				response.sendRedirect("ViewTimetables");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
