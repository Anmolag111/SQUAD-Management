package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.Change_SettingsBean;
import com.mvc.dao.Change_SettingsDAO;

public class Change_Settings extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Password = request.getParameter("Password");
		String Newpassword = request.getParameter("Newpassword");

		Change_SettingsBean change_SettingsBean = new Change_SettingsBean();

		 HttpSession session = request.getSession(false);
		 String Eid = (String) session.getAttribute("eid");
		//System.out.println(Eid);
		change_SettingsBean.setEid(Eid);
		change_SettingsBean.setPassword(Password);
		change_SettingsBean.setNewpassword(Newpassword);

		Change_SettingsDAO cg = new Change_SettingsDAO();
		String userValidate = cg.validate(change_SettingsBean);

		if (userValidate.equals("TEACHING") ||userValidate.equals("NON-TEACHING")|| userValidate.equals("ADMIN")|| userValidate.equals("SUPER-ADMIN")) {

			request.setAttribute("successMessageChange", "Password Changed Succesfully");
			RequestDispatcher rd = request.getRequestDispatcher("/Change_Settings.jsp");
			rd.forward(request, response);
		}

		else {

			request.setAttribute("errorMessageChange", "Couldn't update your record .Please check your data.");
			RequestDispatcher rd = request.getRequestDispatcher("/Change_Settings.jsp");
			rd.forward(request, response);

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		service(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		service(request, response);

	}
}
