package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.ContactUsBean;
import com.mvc.dao.ContactUsDAO;

public class ContactUsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		String name=request.getParameter("name").trim();
		String email=request.getParameter("email").trim();
		String subject=request.getParameter("subject");
		String message=request.getParameter("message");
		
		ContactUsBean cub=new ContactUsBean();
		cub.setName(name);
		cub.setEmail(email);
		cub.setSubject(subject);
		cub.setMessage(message);
		
		String result=ContactUsDAO.sendMail(cub);
		if(result.equals("Send"))
		{
			HttpSession session=request.getSession(false);
			request.setAttribute("successmessageContact", "Message Successfully sent to Admin.");
			response.sendRedirect("Contact_Us.jsp");
		}
		
	}

	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		service(request,response);
		
	}
	

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		service(request,response);
		
	}
}
