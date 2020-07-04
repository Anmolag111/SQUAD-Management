package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.bean.Delete_ReviewBean;
import com.mvc.bean.ReviewLeavesBean;
import com.mvc.util.DBConnection;

public class Delete_Review_Leaves_DAO {
	
	private static Connection con=null;
	private static PreparedStatement pstmt=null;
	private static PreparedStatement pstmt1=null;
	private static int res=-1;
	
	public static String doDelete(Delete_ReviewBean deleteBean)
	{
		
		String Eid=deleteBean.getEid();
		String leaveType=deleteBean.getLeaveType();
		String startDate=deleteBean.getStartDate();
		String endDate=deleteBean.getEndDate();
		
		
		try {
			con=DBConnection.getConnection();
			
			String msg="delete from leaveReview where Eid=? and Type_Of_Leave=? and Start_Date=? and End_Date=?";
			pstmt=con.prepareStatement(msg);
			pstmt.setString(1, Eid);
			pstmt.setString(2, leaveType);
			pstmt.setString(3, startDate);
			pstmt.setString(4, endDate);
			
			res=pstmt.executeUpdate();
			
			if(res>=0)
			{
				String msg1="select * from leaveReview where Date=? and Leave_Status=? ";
				pstmt1=con.prepareStatement(msg1);
				pstmt1.setString(1, ReviewLeavesBean.getCurrentDate());
				pstmt1.setInt(2, 0);
				
				ReviewLeavesBean.setRs(pstmt1.executeQuery());
				
				if(ReviewLeavesBean.getRs()!=null)
					return "Success";
				else
					return "NoSuccess";
				
				
			}
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return "NoSuccess";
	}

}
