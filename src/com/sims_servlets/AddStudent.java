package com.sims_servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims_models.Auth;
import com.sims_models.Student;
import com.sims_service.AdminService;
import com.sims_util.GenerateAuthData;
import com.sims_util.StudentFileUpload;

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Student std = StudentFileUpload.getStudentData(request);
		Auth auth = GenerateAuthData.generateStudentAuthData(std, "student");

		AdminService.addStudent(std, auth);

		// Redirect to Enroll.jsp
		response.sendRedirect("enroll.jsp");

	}

}
