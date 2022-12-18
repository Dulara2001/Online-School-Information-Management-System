package com.sims_servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sims_models.Inquiry;
import com.sims_models.Student;
import com.sims_service.InquiryDao;
import com.sims_service.StudentService;

/**
 * Servlet implementation class addInquiry
 */
@WebServlet("/addInquiry")
public class addInquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(); 
		
		try {
			int auid = (int) session.getAttribute("AUID");

			Student student = StudentService.selectStudentById(auid);
			int iid =0;
			//TODO get sid value from session
			int sid = student.getSid();
			String email = request.getParameter("email");
			String title = request.getParameter("title");
			String inquiry = request.getParameter("inquiry");
			int responded =0;
			
			Inquiry inq = new Inquiry(iid,sid,email,title,inquiry,responded);
			
			InquiryDao.addInquiry(inq);
			
			response.sendRedirect("inquiry_success.jsp");
			
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
		
		
		
		
		
	}

}
