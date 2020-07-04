package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.ForgetPassBean;
import com.mvc.dao.ForgetPassDAO;

public class ForgetPassServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		ForgetPassBean forgetpassbean = new ForgetPassBean();
		forgetpassbean.setEmail(email);

		String result = ForgetPassDAO.reset(forgetpassbean);
		System.out.println("Pass Reset Successfully.");
		if (result.equals("Success")) {
			request.getSession(false);
			request.setAttribute("successMessageReset", "Email has been sent with a new pass.");
			RequestDispatcher rd = request.getRequestDispatcher("/forgetpass.jsp");
			rd.forward(request, response);
		} else {
			request.getSession(false);
			request.setAttribute("errorMessageReset", "No Email found within our database.");
			RequestDispatcher rd = request.getRequestDispatcher("/forgetpass.jsp");
			rd.forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request,response);
	}
}