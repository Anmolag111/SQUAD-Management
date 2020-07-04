package com.mvc.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.Add_new_EmployeeBean;
import com.mvc.bean.SendMailBean;
import com.mvc.dao.Add_new_Employee_DAO;
import com.mvc.dao.SendMailDAO;

public class Add_new_Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		String Fname=request.getParameter("Fname").trim();
		String Lname=request.getParameter("Lname").trim();
		String Eid=request.getParameter("Eid").trim();
		String Email=request.getParameter("Email").trim();
		String Password=request.getParameter("Password");
		String Phone_no=request.getParameter("Phone_no").trim();
		String DOJ=request.getParameter("DOJ");
		String Role=request.getParameter("Role");
		
		Add_new_EmployeeBean Add_new_EmployeeBean = new Add_new_EmployeeBean();
		Add_new_EmployeeBean.setFname(Fname);
		Add_new_EmployeeBean.setLname(Lname);
		Add_new_EmployeeBean.setEmail(Email);
		Add_new_EmployeeBean.setPassword(Password);
		Add_new_EmployeeBean.setEid(Eid);
		Add_new_EmployeeBean.setPhone_no(Phone_no);
		Add_new_EmployeeBean.setDOJ(DOJ);
		Add_new_EmployeeBean.setRole(Role);
		
		System.out.println(DOJ);
		
		
		if(Role.equals("TEACHING"))
		{
			String Designation=request.getParameter("DesignationTeaching");
			String Branch=request.getParameter("BranchTeaching");
			int CasualLeaves=Integer.parseInt(request.getParameter("CasualLeaveTeaching"));
			int MedicalLeaves=Integer.parseInt(request.getParameter("MedicalLeavesTeaching"));
			int SpecialCasualLeaves=Integer.parseInt(request.getParameter("SpecialCasualLeaveTeaching"));
			int OnDutyLeaves=Integer.parseInt(request.getParameter("OnDutyLeaveTeaching"));
			
			Add_new_EmployeeBean.setBranch(Branch);
			Add_new_EmployeeBean.setDesignation(Designation);
			Add_new_EmployeeBean.setCasualLeave(CasualLeaves);
			Add_new_EmployeeBean.setMedicalLeave(MedicalLeaves);
			Add_new_EmployeeBean.setSpecialCasualLeave(SpecialCasualLeaves);
			Add_new_EmployeeBean.setOnDutyLeave(OnDutyLeaves);
			
		}
		else if(Role.equals("NON-TEACHING")||Role.equals("ADMIN"))
		{
			String Designation=request.getParameter("DesignationNonTeaching");
			int CasualLeaves=Integer.parseInt(request.getParameter("CasualLeaveNonTeaching"));
			int MedicalLeaves=Integer.parseInt(request.getParameter("MedicalLeavesNonTeaching"));
			int ElLeaves=Integer.parseInt(request.getParameter("ElLeavesNonTeaching"));
			
			Add_new_EmployeeBean.setDesignation(Designation);
			Add_new_EmployeeBean.setCasualLeave(CasualLeaves);
			Add_new_EmployeeBean.setMedicalLeave(MedicalLeaves);
			Add_new_EmployeeBean.setElLeave(ElLeaves);
			
		}
		
		Add_new_Employee_DAO Add_new_EmployeeDAO = new Add_new_Employee_DAO();
		String userValidate = Add_new_EmployeeDAO.validate(Add_new_EmployeeBean);
		
		System.out.print(userValidate);
		
		if (userValidate.equals("Successfully added New user"))
		{
			request.setAttribute("successmessage", "User Added successfully");
			SendMailBean sendmailbean=new SendMailBean();
			sendmailbean.setEmail(Email);
			sendmailbean.setFname(Fname);
			SendMailDAO.sendMail(sendmailbean);
			RequestDispatcher rd = request.getRequestDispatcher("/Add_new_Employee.jsp");
			rd.forward(request, response);
		}

		else 
		{

			request.setAttribute("errormessage", "Couldn't Add your record .Please check your data.");
			RequestDispatcher rd = request.getRequestDispatcher("/Add_new_Employee.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		service(request,response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		service(request,response);
	}


}
