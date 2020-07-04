package com.mvc.controller.superAdmin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.DeleteUserBean;
import com.mvc.dao.DeleteUserLeavesSA_DAO;

public class DeleteUserLeavesSA_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@SuppressWarnings("unused")
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DeleteUserBean DeleteUserBean=new DeleteUserBean();
		
		String Eid=request.getParameter("Eid");
		
		String Role=request.getParameter("Role");
		DeleteUserBean.setEid(Eid);
		
		
		if(Role.equals("ADMIN"))
		{
			String leaveType=request.getParameter("type_of_leave_ADMIN");
			DeleteUserBean.setLeaveType(leaveType);
		}
		else if(Role.equals("TEACHING"))
		{
			String leaveType=request.getParameter("type_of_leave_TEACHING");
			DeleteUserBean.setLeaveType(leaveType);
		}
		else
		{
			String leaveType=request.getParameter("type_of_leave_NON-TEACHING");
			DeleteUserBean.setLeaveType(leaveType);
		}
			
		
		String duration=request.getParameter("duration");
		DeleteUserBean.setDuration(duration);
		
		if(duration.equals("FULL_DAY"))
		{
			String startDate=request.getParameter("start_date_FULLDAY");
			String endDate=request.getParameter("end_date_FULLDAY");
			
			
			
			
			DeleteUserBean.setStartDate(startDate);
			DeleteUserBean.setEndDate(endDate);
			
			

		}
		else
		{
			String startDate=request.getParameter("start_date_HALFDAY");
			
			
			DeleteUserBean.setStartDate(startDate);
			DeleteUserBean.setEndDate(startDate);
		
			
			
		}
		
		String doUpdate=DeleteUserLeavesSA_DAO.func(DeleteUserBean);
		System.out.println(doUpdate);
		
		if(doUpdate.equals("Deleted Successfully"))
		{
			HttpSession session=request.getSession(false);
			request.setAttribute("successMessageDeleteSA", "Leaves Deleted Successfully.");
			
			RequestDispatcher rd=request.getRequestDispatcher("/DeleteUserLeaves_SA.jsp");
			rd.forward(request, response);
		}
		else if(doUpdate.equals("Please check your data again"))
		{
			HttpSession session=request.getSession(false);
			request.setAttribute("errorMessageDeleteSA", "Please check your data again.");
			
			RequestDispatcher rd=request.getRequestDispatcher("/DeleteUserLeaves_SA.jsp");
			rd.forward(request, response);
		}
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
