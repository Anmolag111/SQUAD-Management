package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.Update_UsersBean;
import com.mvc.util.DBConnection;
//import com.mvc.util.SendMailLeaveExhausted;
//import com.mvc.util.SendMailUpdate;

public class Update_Users_DAO {

	private static Connection con=null;
	private static PreparedStatement pstmt=null;
	private static PreparedStatement pstmt1=null;
	private static PreparedStatement pstmt2=null;
	private static ResultSet rs=null;
	private static int rs1=-1;
	private static int rs2=-1;
	
	
	
	
	public static String runUpdate(Update_UsersBean updBean) {
		
		
		String Eid=updBean.getEid();
		float no_Of_Days=updBean.getNo_Of_Days();
		String leaveType=updBean.getLeaveType();
		String startDate=updBean.getStartDate();
		String endDate=updBean.getEndDate();
		String startTime=updBean.getStartTime();
		String endTime=updBean.getEndTime();
		String Reason=updBean.getReason();
		String currentYear=updBean.getCurrentYear();
		float subtract_result=-1;
		String startDateToBeUpdated=null;
		String endDateToBeUpdated=null;
		float no_Of_DaysFinal=0;
		float defaultQuota=0;
	
		

		
		try {
			con=DBConnection.getConnection();
			
			String msg="select * from leavequota where Eid=? and Type_Of_Leave=? ";
			pstmt=con.prepareStatement(msg);
			pstmt.setString(1,Eid);
			pstmt.setString(2,leaveType);
			
			rs=pstmt.executeQuery();
			
			if(rs==null)
				return "Invalid Eid";
			
			while(rs.next())
			{
				
				String currentYearDB=rs.getString("Start_Date");
				currentYearDB=currentYearDB.substring(0, 4);
				
				
				
				if(currentYearDB.equals(currentYear))
				{
					subtract_result=(rs.getFloat("Number_of_Quota")-rs.getFloat("Default_Quota"));
					no_Of_DaysFinal=rs.getFloat("Default_Quota")+no_Of_Days;
					startDateToBeUpdated=rs.getString("Start_Date");
					endDateToBeUpdated=rs.getString("End_Date");
					defaultQuota=rs.getFloat("Number_of_Quota");
					
					break;
					
				}
				
			}
			
			
			if(rs!=null && no_Of_Days<= subtract_result)
			{
				String msg4="select * from leavededuction where Eid=? and Type_Of_Leave=?";
				PreparedStatement pstmt4 = con.prepareStatement(msg4);
				pstmt4.setString(1, Eid);
				pstmt4.setString(2, leaveType);
				
				ResultSet rs4 = pstmt4.executeQuery();
				while(rs4.next())
				{
					String startDateDB=rs4.getString("Start_Date");
					String endDateDB=rs4.getString("End_Date");
					
					if((startDateDB.equals(startDate))&&(endDateDB.equals(endDate)))
					{
						return "Duplicate Record Found";
					}
				}
				
				
				
				
				String msg1="insert into leavededuction values(?,?,?,?,?,?,?,?)";
				pstmt1=con.prepareStatement(msg1);
				pstmt1.setString(1, Eid);
				pstmt1.setString(2, leaveType);
				pstmt1.setString(3, startDate);
				pstmt1.setString(4, endDate);
				pstmt1.setString(5, startTime);
				pstmt1.setString(6, endTime);
				pstmt1.setFloat(7, no_Of_Days);
				pstmt1.setString(8, Reason);
				
				rs1=pstmt1.executeUpdate();
				
				String msg2="update leavequota set Default_Quota=? where Eid=? and Type_Of_Leave=? and Start_Date=? and End_Date=?";
				pstmt2=con.prepareStatement(msg2);
				pstmt2.setFloat(1, no_Of_DaysFinal);
				pstmt2.setString(2, Eid);
				pstmt2.setString(3, leaveType);
				pstmt2.setString(4, startDateToBeUpdated);
				pstmt2.setString(5, endDateToBeUpdated);
				
				updBean.setRemaining_Leaves(defaultQuota-no_Of_DaysFinal);
				
				if(defaultQuota==no_Of_DaysFinal)
				{
				
					//SendMailLeaveExhausted.send(updBean);
				}
	
				rs2=pstmt2.executeUpdate();
				
				if(rs1>=0 && rs2>=0)
				{
					if(updBean.getEmail()!=null)
						//SendMailUpdate.send(updBean);
					
					return "Success";
				}
					
				
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
