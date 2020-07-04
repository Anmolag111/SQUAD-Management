package com.mvc.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.Update_UsersBean;
import com.mvc.controller.CalculateDateDifference;
import com.mvc.dao.Update_Users_Review_DAO;

public class Update_Users_Servlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		Update_UsersBean updBean=new Update_UsersBean();
		
		String Eid=request.getParameter("Eid");
		updBean.setEmail(request.getParameter("Email"));
		String Role=request.getParameter("Role");
		updBean.setEid(Eid);
		
		
		if(Role.equals("ADMIN"))
		{
			String leaveType=request.getParameter("type_of_leave_ADMIN");
			updBean.setLeaveType(leaveType);
		}
		else if(Role.equals("TEACHING"))
		{
			String leaveType=request.getParameter("type_of_leave_TEACHING");
			updBean.setLeaveType(leaveType);
		}
		else
		{
			String leaveType=request.getParameter("type_of_leave_NON-TEACHING");
			updBean.setLeaveType(leaveType);
		}
			
		String isLeaveProvided=request.getParameter("leaveProvided");
		if(isLeaveProvided.equals("LP_YES"))
			updBean.setLeaveProvided(true);
		else
			updBean.setLeaveProvided(false);
		
		String duration=request.getParameter("duration");
		
		if(duration.equals("FULL_DAY"))
		{
			String startDate=request.getParameter("start_date_FULLDAY");
			String endDate=request.getParameter("end_date_FULLDAY");
			
			Float noOfDays=CalculateDateDifference.CalculateNoOfDays(startDate, endDate);
			
			System.out.println(noOfDays);
			
			updBean.setStartDate(startDate);
			updBean.setEndDate(endDate);
			updBean.setNo_Of_Days(noOfDays);
			updBean.setStartTime("00:00");
			updBean.setEndTime("00:00");
			updBean.setCurrentYear(startDate.substring(0, 4));
			

		}
		else
		{
			String startDate=request.getParameter("start_date_HALFDAY");
			String startTime=request.getParameter("start_time_HALFDAY");
			String endTime=request.getParameter("end_time_HALFDAY");
			updBean.setStartDate(startDate);
			updBean.setEndDate(startDate);
			updBean.setNo_Of_Days((float)0.5);
			updBean.setStartTime(startTime);
			updBean.setEndTime(endTime);
			updBean.setCurrentYear(startDate.substring(0, 4));
			
			
		}
		
		
		
		String Reason=request.getParameter("reason");
		updBean.setReason(Reason);
		updBean.setCurrentDate(CalculateDateDifference.getCurrenDate());
		
		
		String doUpdate=null;
		
		if(updBean.getLeaveType().equals("ML") && updBean.getNo_Of_Days()==1)
		{
			doUpdate="Not Possible";
		}
		else
		{
			 doUpdate=Update_Users_Review_DAO.runUpdate(updBean);
		}
		
		
		
		if(doUpdate.equals("Success"))
		{
			HttpSession session=request.getSession(false);
			request.setAttribute("successMessageUpdate", "Leaves Updated Successfully.");
			
			RequestDispatcher rd=request.getRequestDispatcher("/Update_Users.jsp");
			rd.forward(request, response);
		}
		else if(doUpdate.equals("Not Possible"))
		{
			HttpSession session=request.getSession(false);
			request.setAttribute("errorMessageMedical", "Medical Leave is applicable for a duration of more than 1 day.");
			
			RequestDispatcher rd=request.getRequestDispatcher("/Update_Users.jsp");
			rd.forward(request, response);
		}
		else if(doUpdate.equals("No Success"))
		{
			HttpSession session=request.getSession(false);
			request.setAttribute("errorMessageUpdate", "No Sufficient Leaves Available.");
			
			RequestDispatcher rd=request.getRequestDispatcher("/Update_Users.jsp");
			rd.forward(request, response);
		}
		else if(doUpdate.equals("Already Pending"))
		{
			HttpSession session=request.getSession(false);
			request.setAttribute("errorMessagePending", "Error: You  cannot update Leaves of "+updBean.getLeaveType()+" for this user. Reason: Approval Pending for Leaves.");
			
			RequestDispatcher rd=request.getRequestDispatcher("/Update_Users.jsp");
			rd.forward(request, response);
		}
		
		else if(doUpdate.equals("Duplicate Record Found"))
		{
			HttpSession session=request.getSession(false);
			request.setAttribute("errorMessageDuplicate", "Already Availed Leaves on this date.\n Please Enter correct Date.");
			
			RequestDispatcher rd=request.getRequestDispatcher("/Update_Users.jsp");
			rd.forward(request, response);
		}
		
		else
		{
			HttpSession session=request.getSession(false);
			request.setAttribute("errorMessageUpdateEid", "Invalid Eid.");
			
			RequestDispatcher rd=request.getRequestDispatcher("/Update_Users.jsp");
			rd.forward(request, response);
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
