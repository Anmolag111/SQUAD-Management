package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mvc.bean.View_UserBean;
import com.mvc.util.DBConnection;

public class View_UserDAO {
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;

	public String validate(View_UserBean View_UserBean) {
		String Eid = View_UserBean.getEid();
		System.out.println(Eid);
		try {
			con = DBConnection.getConnection();
			String msg = "select Role from Msitemployeedetails where Eid='" + Eid + "'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(msg);
			if (rs.next()) {
				View_UserBean.setRole(rs.getString("Role"));

				System.out.print(View_UserBean.getRole());

				if (View_UserBean.getRole().equals("TEACHING"))

				{
					PreparedStatement pstmt1 = con.prepareStatement(
							"select Email,Lname,Fname,DOJ,Designation,Branch,Role from Msitemployeedetails where Eid=?");
					pstmt1.setString(1, Eid);
					PreparedStatement pstmt2 = con.prepareStatement(
							"select Type_Of_Leave,Number_of_Quota,Default_Quota from leavequota where Eid=?");
					pstmt2.setString(1, Eid);

					rs1 = pstmt1.executeQuery();
					rs2 = pstmt2.executeQuery();
					while (rs1.next()) {
						View_UserBean.setEmail(rs1.getString("Email"));
						View_UserBean.setLname(rs1.getString("Lname"));
						View_UserBean.setFname(rs1.getString("Fname"));
						View_UserBean.setBranch(rs1.getString("Branch"));
						View_UserBean.setRole(rs1.getString("Role"));

						View_UserBean.setDOJ(rs1.getString("DOJ"));
						View_UserBean.setDesignation(rs1.getString("Designation"));

					}

					while (rs2.next()) {
						if (rs2.getString("Type_Of_Leave").equals("ML")) {
							View_UserBean.setMedicalLeave(rs2.getFloat("Number_of_Quota")- rs2.getFloat("Default_Quota"));

						} else if (rs2.getString("Type_Of_Leave").equals("CL")) {
							View_UserBean.setCasualLeave(rs2.getFloat("Number_of_Quota")- rs2.getFloat("Default_Quota"));

						} else if (rs2.getString("Type_Of_Leave").equals("SCL")) {
							View_UserBean.setSpecialCasualLeave(rs2.getFloat("Number_of_Quota")- rs2.getFloat("Default_Quota"));

						} else if (rs2.getString("Type_Of_Leave").equals("OD")) {
							View_UserBean.setOnDutyLeave(rs2.getFloat("Number_of_Quota")- rs2.getFloat("Default_Quota"));

						}

					}
					return View_UserBean.getRole();

				}

				else if (View_UserBean.getRole().equals("NON-TEACHING") || View_UserBean.getRole().equals("ADMIN"))

				{PreparedStatement pstmt1 = con.prepareStatement(
						"select Email,Lname,Fname,DOJ,Designation,Role from Msitemployeedetails where Eid=?");
				pstmt1.setString(1, Eid);
				PreparedStatement pstmt2 = con.prepareStatement(
						"select Type_Of_Leave,Number_of_Quota,Default_Quota from leavequota where Eid=?");
				pstmt2.setString(1, Eid);

				rs1 = pstmt1.executeQuery();
				rs2 = pstmt2.executeQuery();
					while (rs1.next()) {
						View_UserBean.setEmail(rs1.getString("Email"));
						View_UserBean.setLname(rs1.getString("Lname"));
						View_UserBean.setFname(rs1.getString("Fname"));

						View_UserBean.setRole(rs1.getString("Role"));

						View_UserBean.setDOJ(rs1.getString("DOJ"));
						View_UserBean.setDesignation(rs1.getString("Designation"));
					}
					while (rs2.next()) {
						if (rs2.getString("Type_Of_Leave").equals("ML")) {
							View_UserBean.setMedicalLeave(rs2.getFloat("Number_of_Quota")- rs2.getFloat("Default_Quota"));

						} else if (rs2.getString("Type_Of_Leave").equals("CL")) {
							View_UserBean.setCasualLeave(rs2.getFloat("Number_of_Quota")- rs2.getFloat("Default_Quota"));

						} else if (rs2.getString("Type_Of_Leave").equals("EL")) {
							View_UserBean.setEL(rs2.getFloat("Number_of_Quota")- rs2.getFloat("Default_Quota"));

						}

					}
					return View_UserBean.getRole();
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "Invalid User Credentials.";

	}

}
