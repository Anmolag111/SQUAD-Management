package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.Add_new_EmployeeBean;
import com.mvc.util.DBConnection;

public class Add_new_Employee_DAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	int rs = -1;
	ResultSet r;
	int rs1 = -1;
	int rs2=-1;

	@SuppressWarnings("unused")
	public String validate(Add_new_EmployeeBean Add_new_EmployeeBean) {
		String Fname = Add_new_EmployeeBean.getFname();
		String Lname = Add_new_EmployeeBean.getLname();
		String Email = Add_new_EmployeeBean.getEmail();
		String Password = Add_new_EmployeeBean.getPassword();
		String Eid = Add_new_EmployeeBean.getEid();
		String Phone_no = Add_new_EmployeeBean.getPhone_no();
		String Branch = Add_new_EmployeeBean.getBranch();
		int CasualLeave = Add_new_EmployeeBean.getCasualLeave();
		int MedicalLeave = Add_new_EmployeeBean.getMedicalLeave();
		int SpecialCasualLeave = Add_new_EmployeeBean.getSpecialCasualLeave();
		int OnDutyLeaves=Add_new_EmployeeBean.getOnDutyLeave();
		int ElLeaves=Add_new_EmployeeBean.getElLeave();
		String Role = Add_new_EmployeeBean.getRole();
		String Designation = Add_new_EmployeeBean.getDesignation();
		String DOJ = Add_new_EmployeeBean.getDOJ();
		

		
		try {
			con = DBConnection.getConnection();
			
			String msg = "insert into msitemployeedetails values(?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(msg);
			
			pstmt.setString(1,Fname);
			pstmt.setString(2,Lname);
			pstmt.setString(3,Eid);
			pstmt.setString(4,Email);
			pstmt.setString(5,Branch);
			pstmt.setString(6,Designation);
			pstmt.setString(7,Role);
			pstmt.setString(8,Phone_no);
			pstmt.setString(9,DOJ);
			
			rs = pstmt.executeUpdate();
			
	
			String msg1 = "insert into msitlogin values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(msg1);
			
			pstmt.setString(1,Fname);
			pstmt.setString(2,Lname);
			pstmt.setString(3,Eid);
			pstmt.setString(4,Email);
			pstmt.setString(5,Password);
			pstmt.setString(6,Role);
			
			rs1 = pstmt.executeUpdate();
			System.out.println(Role);
			if(Role.equals("TEACHING"))
			{
				String msg2="insert into leavequota values (?,?,?,?,?,?),(?,?,?,?,?,?),(?,?,?,?,?,?),(?,?,?,?,?,?)";
				pstmt=con.prepareStatement(msg2);
				pstmt.setString(1,Add_new_EmployeeBean.getEid());
				pstmt.setString(2,"CL");
				pstmt.setString(3,Add_new_EmployeeBean.getDOJ());
				pstmt.setString(4,"2019-12-31");
				pstmt.setInt(5,Add_new_EmployeeBean.getCasualLeave());
				pstmt.setInt(6,0);
				
				pstmt.setString(7,Add_new_EmployeeBean.getEid());
				pstmt.setString(8,"ML");
				pstmt.setString(9,Add_new_EmployeeBean.getDOJ());
				pstmt.setString(10, "9999-12-31");
				pstmt.setInt(11,Add_new_EmployeeBean.getMedicalLeave());
				pstmt.setInt(12, 0);
				
				pstmt.setString(13,Add_new_EmployeeBean.getEid());
				pstmt.setString(14,"SCL");
				pstmt.setString(15,Add_new_EmployeeBean.getDOJ());
				pstmt.setString(16, "2019-12-31");
				pstmt.setInt(17,Add_new_EmployeeBean.getSpecialCasualLeave());
				pstmt.setInt(18,0 );
				
				pstmt.setString(19,Add_new_EmployeeBean.getEid());
				pstmt.setString(20,"OD");
				pstmt.setString(21,Add_new_EmployeeBean.getDOJ());
				pstmt.setString(22,"2019-12-31");
				pstmt.setInt(23,Add_new_EmployeeBean.getOnDutyLeave() );
				pstmt.setInt(24,0);
				
				rs2=pstmt.executeUpdate();
			}
			else if(Role.equals("NON-TEACHING")||Role.equals("ADMIN"))
			{
				String msg2="insert into leavequota values (?,?,?,?,?,?),(?,?,?,?,?,?),(?,?,?,?,?,?)";
				pstmt=con.prepareStatement(msg2);
				pstmt.setString(1,Add_new_EmployeeBean.getEid());
				pstmt.setString(2,"CL");
				pstmt.setString(3,Add_new_EmployeeBean.getDOJ());
				pstmt.setString(4,"2019-12-31");
				pstmt.setInt(5,Add_new_EmployeeBean.getCasualLeave());
				pstmt.setInt(6,0);
				
				pstmt.setString(7,Add_new_EmployeeBean.getEid());
				pstmt.setString(8,"ML");
				pstmt.setString(9,Add_new_EmployeeBean.getDOJ());
				pstmt.setString(10, "9999-12-31");
				pstmt.setInt(11,Add_new_EmployeeBean.getMedicalLeave());
				pstmt.setInt(12, 0);
				
				pstmt.setString(13,Add_new_EmployeeBean.getEid());
				pstmt.setString(14,"EL");
				pstmt.setString(15,Add_new_EmployeeBean.getDOJ());
				pstmt.setString(16, "2019-12-31");
				pstmt.setInt(17,Add_new_EmployeeBean.getElLeave());
				pstmt.setInt(18,0);
				
				rs2=pstmt.executeUpdate();
			}
			
			if (rs > 0 && rs1 > 0 && rs2>0) {
				return "Successfully added New user";

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "Invalid User Credentials.";

	}
}
