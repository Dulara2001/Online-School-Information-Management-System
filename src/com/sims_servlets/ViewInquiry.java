package com.sims_servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims_models.Inquiry;
import com.sims_service.InquiryDao;

/**
 * Servlet implementation class ViewInquiry
 */
@WebServlet("/ViewInquiry")
public class ViewInquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    ArrayList<Inquiry> inquiries = new ArrayList<Inquiry>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		inquiries = (ArrayList<Inquiry>) InquiryDao.getInquiry();
		
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("viewInquiry.jsp");
		request.setAttribute("inquiries", inquiries);
		dispatcher.forward(request, response);
		}

}
