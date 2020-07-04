package com.mvc.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.Delete_ReviewBean;
import com.mvc.bean.ReviewLeavesBean;
import com.mvc.dao.Delete_Review_Leaves_DAO;


public class ReviewUpdatedLeavesDeleter_Admin_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int target=Integer.parseInt(request.getParameter("counterValue"));
		String Eid=request.getParameter("Eid"+target);
		String Type_Of_Leave=request.getParameter("Type_Of_Leave"+target);
		String Start_Date=request.getParameter("Start_Date"+target);
		String End_Date=request.getParameter("End_Date"+target);
		
		Delete_ReviewBean deleteBean=new Delete_ReviewBean();
		deleteBean.setCount(target);
		deleteBean.setEid(Eid);
		deleteBean.setLeaveType(Type_Of_Leave);
		deleteBean.setStartDate(Start_Date);
		deleteBean.setEndDate(End_Date);
		
		//System.out.println(deleteBean.getCount()+" "+deleteBean.getEid()+" "+deleteBean.getLeaveType()+" "+deleteBean.getStartDate()+" "+deleteBean.getEndDate() );
		
		
		String deleteResult=Delete_Review_Leaves_DAO.doDelete(deleteBean);
		
		if(deleteResult.equals("Success"))
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


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
