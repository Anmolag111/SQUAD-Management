package com.mvc.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.ReviewLeavesBean;
import com.mvc.controller.CalculateDateDifference;
import com.mvc.dao.View_Review_Leaves_DAO;


public class ReviewUpdatedLeavesFetcher_Admin_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		ReviewLeavesBean.setCurrentDate(CalculateDateDifference.getCurrenDate());
		String fetchResult=View_Review_Leaves_DAO.fetch_data();
		
		if(fetchResult.equals("Success"))
		{
			HttpSession session=request.getSession(false);
			session.setAttribute("ReviewResultSet", ReviewLeavesBean.getRs());
			
			RequestDispatcher rd=request.getRequestDispatcher("ReviewUpdatedLeaves_Admin.jsp");
			rd.forward(request, response);
		}
		else
		{
			HttpSession session=request.getSession(false);
			session.setAttribute("ReviewResultSet", ReviewLeavesBean.getRs());
			
			RequestDispatcher rd=request.getRequestDispatcher("ReviewUpdatedLeaves_Admin.jsp");
			rd.forward(request, response);
		}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		service(request,response);
	}
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		service(request,response);
	}
	

}
