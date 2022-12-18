package com.sims_servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims_models.Auth;
import com.sims_models.Teacher;
import com.sims_service.AdminService;
import com.sims_util.GenerateAuthData;
import com.sims_util.TeacherFileUpload;

/**
 * Servlet implementation class AddTeacher
 */
@WebServlet("/AddTeacher")
public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Teacher teach = TeacherFileUpload.getTeacherData(request);
		Auth auth = GenerateAuthData.generateTeacherAuthData(teach, "teacher");

		AdminService.addTeacher(teach, auth);

		response.sendRedirect("enroll.jsp");

	}

}
