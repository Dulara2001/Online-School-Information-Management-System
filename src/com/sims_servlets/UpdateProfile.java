package com.sims_servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sims_service.UpdateProfileService;

/**
 * Servlet implementation class UpdateProfile
 */
@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int auid = (int) session.getAttribute("AUID");
		String uname,name,address,contact;
		
		uname = request.getParameter("uname");
		name = request.getParameter("name");
		address = request.getParameter("address");
		contact = request.getParameter("contact");
		
		UpdateProfileService.updateProfile(auid, uname, name, address, contact);
		
		response.sendRedirect("Profile");
		
	}

}
