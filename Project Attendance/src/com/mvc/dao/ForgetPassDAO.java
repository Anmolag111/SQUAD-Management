package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.ForgetPassBean;
import com.mvc.util.DBConnection;
import com.mvc.util.SendMailReset;

public class ForgetPassDAO {

	static Connection con=null;
	static PreparedStatement pstmt=null;
	static ResultSet rs;
	
	
	@SuppressWarnings("unused")
	public static String reset(ForgetPassBean forgetpassbean) {
		
		String email=forgetpassbean.getEmail();
		
		String msg="select Email from MsitLogin where Email=?";
		String msg1="update MsitLogin set Password=? where Email=?";
		
		
		
		try {
			con=DBConnection.getConnection();
			pstmt=con.prepareStatement(msg);
			pstmt.setString(1, email);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				String pass=GeneratePassword.generate(forgetpassbean);
				forgetpassbean.setNewpass(pass);
				pstmt=con.prepareStatement(msg1);
				pstmt.setString(1,forgetpassbean.getNewpass());
				pstmt.setString(2,email);
				int res=pstmt.executeUpdate();
				SendMailReset.send(forgetpassbean);
				
				return "Success";
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			return "Failure";
		
	}
	
	

}
