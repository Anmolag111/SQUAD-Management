package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.bean.ReviewLeavesBean;
import com.mvc.util.DBConnection;

public class View_Review_Leaves_DAO {

	private static Connection con=null;
	private static PreparedStatement pstmt=null;
	
	public static String fetch_data()
	{
		String date=ReviewLeavesBean.getCurrentDate();
		//System.out.println(date);
		
		try {
			con=DBConnection.getConnection();
			
			String msg="select * from leaveReview where Date=? and Leave_Status=? ";
			pstmt=con.prepareStatement(msg);
			pstmt.setString(1, date);
			pstmt.setInt(2, 0);
			
			
			ReviewLeavesBean.setRs(pstmt.executeQuery());
			
			if(ReviewLeavesBean.getRs()!=null)
			{
				return "Success";
			}
			else 
			{
				return "No Success";
			}
			
			
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "No Success";
	}
	
}
