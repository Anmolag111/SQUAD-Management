package com.mvc.controller.superAdmin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.ReviewLeavesBean;
import com.mvc.dao.ApproveAllLeavesDAO;

public class ApproveAllLeaves extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String result=ApproveAllLeavesDAO.doApproveAll();
		System.out.println(result);
		
		if(result.equals("Success"))
		{
			HttpSession session=request.getSession(false);
			session.setAttribute("ReviewResultSet", ReviewLeavesBean.getRs());
			
			RequestDispatcher rd=request.getRequestDispatcher("Review_Leaves_Result.jsp");
			rd.forward(request, response);
		}
		else
		{
			HttpSession session=request.getSession(false);
			session.setAttribute("ReviewResultSet", ReviewLeavesBean.getRs());
			
			RequestDispatcher rd=request.getRequestDispatcher("Review_Leaves_Result.jsp");
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
