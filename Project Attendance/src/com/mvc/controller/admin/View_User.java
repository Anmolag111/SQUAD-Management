package com.mvc.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.View_UserBean;
import com.mvc.dao.View_UserDAO;

public class View_User extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	@SuppressWarnings("unused")
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Eid = request.getParameter("Eid");
		
		
		
		View_UserBean View_UserBean=new View_UserBean();
		
		View_UserBean.setEid(Eid);
		
		View_UserDAO View_UserDAO = new View_UserDAO();
		String userValidate = View_UserDAO.validate(View_UserBean);
		System.out.println(userValidate);
		
		if (userValidate.equals("TEACHING"))
		{
			HttpSession session=request.getSession();
			session.setAttribute("email",View_UserBean.getEmail());
			session.setAttribute("fname", View_UserBean.getFname());
			session.setAttribute("lname", View_UserBean.getLname());
			session.setAttribute("role", View_UserBean.getRole());
			session.setAttribute("branch", View_UserBean.getBranch());
			session.setAttribute("eid", View_UserBean.getEid());
			session.setAttribute("Designation", View_UserBean.getDesignation());
			session.setAttribute("DOJ", View_UserBean.getDOJ());
			session.setAttribute("casualLeave", View_UserBean.getCasualLeave());
			session.setAttribute("specialCasualLeave", View_UserBean.getSpecialCasualLeave());
			session.setAttribute("medicalLeave", View_UserBean.getMedicalLeave());
			session.setAttribute("onDutyLeave", View_UserBean.getOnDutyLeave());
			RequestDispatcher rd = request.getRequestDispatcher("/View_User_Result.jsp");
			rd.forward(request, response);
		}

		else if (userValidate.equals("NON-TEACHING")||userValidate.equals("ADMIN"))
		{
			HttpSession session=request.getSession();
			session.setAttribute("email",View_UserBean.getEmail());
			session.setAttribute("fname", View_UserBean.getFname());
			session.setAttribute("lname", View_UserBean.getLname());
			session.setAttribute("role", View_UserBean.getRole());
			session.setAttribute("eid", View_UserBean.getEid());
			session.setAttribute("Designation", View_UserBean.getDesignation());
			session.setAttribute("DOJ", View_UserBean.getDOJ());
			session.setAttribute("casualLeave", View_UserBean.getCasualLeave());
			session.setAttribute("medicalLeave", View_UserBean.getMedicalLeave());
			session.setAttribute("EL", View_UserBean.getEL());
			RequestDispatcher rd = request.getRequestDispatcher("/View_User_Result.jsp");
			rd.forward(request, response);
		}
		else
		{
			HttpSession session=request.getSession();
			request.setAttribute("errormessage", "Couldn't View the record .Please check  Eid again.");
			RequestDispatcher rd = request.getRequestDispatcher("/View_User.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
	}
}
