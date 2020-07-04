package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mvc.bean.LoginBean;
import com.mvc.bean.ProfileBean;
import com.mvc.util.DBConnection;

public class LoginDAO {
	
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	ResultSet rs2=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;
//	int rs1=-1;
//	int rs2=-1;
	
	
	@SuppressWarnings("static-access")
	public String validate(LoginBean loginbean)
	{
		String Eid=loginbean.getEid();
		String Password=loginbean.getPassword();
		//System.out.print(Eid);
		ProfileBean ProfileBean=new ProfileBean();
		ProfileBean.setEid(Eid);
		
		try {
			con=DBConnection.getConnection();
			String msg="select Eid,Password,Role from msitlogin where Eid ='"+Eid+"' and Password='"+Password+"'";
			stmt=con.createStatement();
			rs = stmt.executeQuery(msg);
			
			while(rs.next())
			{

				String role=rs.getString("Role");
				ProfileBean.setRole("role");
				//System.out.print(role);
					if (role.equals("TEACHING"))

					{
						PreparedStatement pstmt1 = con.prepareStatement(
								"select Email,Lname,Fname,DOJ,Designation,Branch,Role,Phone_No from msitemployeedetails where Eid=?");
						pstmt1.setString(1, Eid);
						PreparedStatement pstmt2 = con.prepareStatement(
								"select Type_Of_Leave,Number_of_Quota,Default_Quota from leavequota where Eid=?");
						pstmt2.setString(1, Eid);

						rs1 = pstmt1.executeQuery();
						rs2 = pstmt2.executeQuery();
						while (rs1.next()) {
							ProfileBean.setEmail(rs1.getString("Email"));
							ProfileBean.setLname(rs1.getString("Lname"));
							ProfileBean.setFname(rs1.getString("Fname"));
							ProfileBean.setBranch(rs1.getString("Branch"));
							ProfileBean.setRole(rs1.getString("Role"));
							ProfileBean.setDOJ(rs1.getString("DOJ"));
							ProfileBean.setDesignation(rs1.getString("Designation"));
							ProfileBean.setPhone_No(rs1.getString("Phone_No"));

						}

						while (rs2.next()) {
							if (rs2.getString("Type_Of_Leave").equals("ML")) {
								ProfileBean.setTotalMedicalLeave(rs2.getFloat("Number_of_Quota"));
								ProfileBean.setRemainingMedicalLeave(rs2.getFloat("Number_of_Quota")- rs2.getFloat("Default_Quota"));
								
							} else if (rs2.getString("Type_Of_Leave").equals("CL")) {
								ProfileBean.setTotalCasualLeave(rs2.getFloat("Number_of_Quota"));
								ProfileBean.setRemainingCasualLeave(rs2.getFloat("Number_of_Quota")- rs2.getFloat("Default_Quota"));

							} else if (rs2.getString("Type_Of_Leave").equals("SCL")) {
								ProfileBean.setTotalSpecialCasualLeave(rs2.getFloat("Number_of_Quota"));
								ProfileBean.setRemainingSpecialCasualLeave(rs2.getFloat("Number_of_Quota")- rs2.getFloat("Default_Quota"));

							} else if (rs2.getString("Type_Of_Leave").equals("OD")) {
								ProfileBean.setTotalOnDutyLeave(rs2.getFloat("Number_of_Quota"));
								ProfileBean.setRemainingOnDutyLeave(rs2.getFloat("Number_of_Quota")- rs2.getFloat("Default_Quota"));

							}

						}
						return role;

					}

					else if (role.equals("NON-TEACHING") )

					{PreparedStatement pstmt1 = con.prepareStatement(
							"select Email,Lname,Fname,DOJ,Designation,Role ,Phone_No from msitemployeedetails where Eid=?");
					pstmt1.setString(1, Eid);
					PreparedStatement pstmt2 = con.prepareStatement(
							"select Type_Of_Leave,Number_of_Quota,Default_Quota from leavequota where Eid=?");
					pstmt2.setString(1, Eid);

					rs1 = pstmt1.executeQuery();
					rs2 = pstmt2.executeQuery();
						while (rs1.next()) {
							ProfileBean.setEmail(rs1.getString("Email"));
							ProfileBean.setLname(rs1.getString("Lname"));
							ProfileBean.setFname(rs1.getString("Fname"));

							ProfileBean.setRole(rs1.getString("Role"));

							ProfileBean.setDOJ(rs1.getString("DOJ"));
							ProfileBean.setDesignation(rs1.getString("Designation"));
							ProfileBean.setPhone_No(rs1.getString("Phone_No"));
						}
						while (rs2.next()) {
							if (rs2.getString("Type_Of_Leave").equals("ML")) {
								ProfileBean.setTotalMedicalLeave(rs2.getFloat("Number_of_Quota"));
										ProfileBean.setRemainingMedicalLeave(rs2.getFloat("Number_of_Quota")- rs2.getFloat("Default_Quota"));
								
							} else if (rs2.getString("Type_Of_Leave").equals("CL")) {
								ProfileBean.setTotalCasualLeave(rs2.getFloat("Number_of_Quota"));
								ProfileBean.setRemainingCasualLeave(rs2.getFloat("Number_of_Quota")- rs2.getFloat("Default_Quota"));

							}  else if (rs2.getString("Type_Of_Leave").equals("EL")) {
								ProfileBean.setTotalEL(rs2.getFloat("Number_of_Quota"));
								ProfileBean.setRemainingEL(rs2.getFloat("Number_of_Quota")- rs2.getFloat("Default_Quota"));

							}

						}
						return role;
					}

			
					else if (role.equals("ADMIN") )
		
					{
						return role;
					}
					else if(role.equals("SUPER-ADMIN"))
					{
						return role;
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Invalid User Credentials.";
		
	}

}
