package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.LoginBean;
import com.mvc.bean.ProfileBean;
import com.mvc.dao.LoginDAO;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String eid = request.getParameter("eid");
		String password = request.getParameter("password");

		LoginBean loginbean = new LoginBean();

		loginbean.setEid(eid);
		loginbean.setPassword(password);

		LoginDAO logindao = new LoginDAO();
		String userValidate = logindao.validate(loginbean);
		System.out.print(userValidate);
		if (userValidate.equals("ADMIN")) {

			HttpSession session = request.getSession();
			session.setAttribute("eid", eid);
			session.setAttribute("admin", "Valid");


			RequestDispatcher rd = request.getRequestDispatcher("/Admin_Main.jsp");
			rd.forward(request, response);
		}
		else if(userValidate.equals("SUPER-ADMIN"))
		{
			HttpSession session = request.getSession();
			session.setAttribute("eid", eid);
			session.setAttribute("superAdmin", "Valid");


			RequestDispatcher rd = request.getRequestDispatcher("/Super_Admin_Main.jsp");
			rd.forward(request, response);
		}
		
		else if (userValidate.equals("TEACHING")) {
			HttpSession session = request.getSession();
			session.setAttribute("email",ProfileBean.getEmail());
			session.setAttribute("fname", ProfileBean.getFname());
			session.setAttribute("lname", ProfileBean.getLname());
			session.setAttribute("role", ProfileBean.getRole());
			session.setAttribute("branch", ProfileBean.getBranch());
			session.setAttribute("eid", ProfileBean.getEid());
			session.setAttribute("Phone_No", ProfileBean.getPhone_No());
			session.setAttribute("DOJ", ProfileBean.getDOJ());
			session.setAttribute("Designation", ProfileBean.getDesignation());
			session.setAttribute("casualLeave", ProfileBean.getRemainingCasualLeave());
			session.setAttribute("specialCasualLeave", ProfileBean.getRemainingSpecialCasualLeave());
			session.setAttribute("medicalLeave", ProfileBean.getRemainingMedicalLeave());
			session.setAttribute("OnDutyLeave", ProfileBean.getRemainingOnDutyLeave());
			
			session.setAttribute("Total_CL", ProfileBean.getTotalCasualLeave());
			session.setAttribute("Total_ML", ProfileBean.getTotalMedicalLeave());
			session.setAttribute("Total_SCL", ProfileBean.getTotalSpecialCasualLeave());
			session.setAttribute("Total_ODL", ProfileBean.getTotalOnDutyLeave());
			
			session.setAttribute("teaching", "Valid");
			

			RequestDispatcher rd = request.getRequestDispatcher("/Employee_Main.jsp");
			rd.forward(request, response);
		} 
		else if(userValidate.equals("NON-TEACHING"))
		{
			HttpSession session = request.getSession();
			session.setAttribute("email",ProfileBean.getEmail());
			session.setAttribute("fname", ProfileBean.getFname());
			session.setAttribute("lname", ProfileBean.getLname());
			session.setAttribute("role", ProfileBean.getRole());
			session.setAttribute("eid", ProfileBean.getEid());
			session.setAttribute("Phone_No", ProfileBean.getPhone_No());
			session.setAttribute("DOJ", ProfileBean.getDOJ());
			session.setAttribute("Designation", ProfileBean.getDesignation());
			session.setAttribute("casualLeave", ProfileBean.getRemainingCasualLeave());
			session.setAttribute("medicalLeave", ProfileBean.getRemainingMedicalLeave());
			session.setAttribute("EL", ProfileBean.getRemainingEL());
			
			session.setAttribute("Total_CL", ProfileBean.getTotalCasualLeave());
			session.setAttribute("Total_ML", ProfileBean.getTotalMedicalLeave());
			session.setAttribute("Total_EL", ProfileBean.getTotalEL());
			session.setAttribute("non-teaching", "Valid");
			
			RequestDispatcher rd = request.getRequestDispatcher("/Employee_Main.jsp");
			rd.forward(request, response);
		}
		
		
		else {
			HttpSession session = request.getSession();
			request.setAttribute("errormessage", userValidate);
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
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
