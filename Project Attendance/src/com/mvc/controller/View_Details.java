package com.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.ProfileBean;
import com.mvc.bean.View_DetailsBean;
import com.mvc.dao.View_DetailsDAO;


public class View_Details extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("static-access")
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String Eid =ProfileBean.getEid();
			String StartDate=request.getParameter("StartDate");
			String EndDate=request.getParameter("EndDate");
			
			View_DetailsBean  View_DetailsBean =new View_DetailsBean ();
			View_DetailsBean.setEid(Eid);
			View_DetailsBean.setStartDate(StartDate);
			View_DetailsBean.setEndDate(EndDate);
			
		    View_DetailsDAO View_DetailsDAO=new View_DetailsDAO();
		
			String msg=View_DetailsDAO.fun(View_DetailsBean);
			//System.out.println(msg);
			
			if(msg.equals("Successful"))
			{
				
				HttpSession session = request.getSession(false);
				session.setAttribute("ResultSet",View_DetailsBean.getResultSet());
				
				RequestDispatcher rd=request.getRequestDispatcher("/View_Details.jsp");
				rd.forward(request, response);
				
			}
			
			else 
			{
				HttpSession session = request.getSession(false);
				session.setAttribute("ResultSet", View_DetailsBean.getResultSet());
				
				RequestDispatcher rd=request.getRequestDispatcher("/View_Details.jsp");
				rd.forward(request, response);
				
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
	}

}
