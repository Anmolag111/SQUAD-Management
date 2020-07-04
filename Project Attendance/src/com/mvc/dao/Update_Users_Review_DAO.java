package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.Update_UsersBean;
import com.mvc.util.DBConnection;

public class Update_Users_Review_DAO {
	
	private static Connection con=null;
	private static PreparedStatement pstmt=null;
	private static PreparedStatement pstmt1=null;
	private static PreparedStatement pstmt2=null;
	private static ResultSet rs=null;
	private static ResultSet rs1=null;
	private static int rs2=-1;

	
	@SuppressWarnings("unused")
	public static String runUpdate(Update_UsersBean updBean)
	{
		String Eid=updBean.getEid();
		String leaveType=updBean.getLeaveType();
		float no_Of_Days=updBean.getNo_Of_Days();
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
		String currentDate=updBean.getCurrentDate();
		String leaveProvided=null;
		if(updBean.isLeaveProvided()==true)
			leaveProvided="Yes";
		else 
			leaveProvided="No";
		
		
		
		
		try {
			
			
			con=DBConnection.getConnection();
			
			String msg="select * from leavequota where Eid=? and Type_Of_Leave=? ";
			pstmt=con.prepareStatement(msg);
			pstmt.setString(1, Eid);
			pstmt.setString(2, leaveType);
			
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
				String msg1="select * from leavededuction where Eid=? and Type_Of_Leave=?";
				
				pstmt1=con.prepareStatement(msg1);
				pstmt1.setString(1, Eid);
				pstmt1.setString(2, leaveType);
				
				rs1=pstmt1.executeQuery();
				
				while(rs1.next())
				{
					String startDateDB=rs1.getString("Start_Date");
					String endDateDB=rs1.getString("End_Date");
					
					if((startDateDB.equals(startDate))&&(endDateDB.equals(endDate)))
					{
						return "Duplicate Record Found";
					}
				}
			}
			
			String query="select * from leaveReview where Eid=? and Type_Of_Leave=?";
			PreparedStatement pstmt3 = con.prepareStatement(query);
			pstmt3.setString(1,updBean.getEid());
			pstmt3.setString(2, updBean.getLeaveType());
			
			ResultSet rs3 = pstmt3.executeQuery();
			
			if(rs3!=null)
			{
				while(rs3.next())
				{
					String EidDB=rs3.getString("Eid");
					String leaveTypeDB=rs3.getString("Type_Of_Leave");
					
					if(EidDB.equals(Eid) && leaveType.equals(leaveTypeDB))
						return "Already Pending";
				}
				
			}
			
			String msg2="insert into leaveReview values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt2=con.prepareStatement(msg2);
			
			pstmt2.setString(1,Eid);
			pstmt2.setString(2,leaveType);
			pstmt2.setString(3,startDate);
			pstmt2.setString(4,endDate);
			pstmt2.setString(5,startTime);
			pstmt2.setString(6,endTime);
			pstmt2.setFloat(7,no_Of_Days);
			pstmt2.setString(8,Reason);
			pstmt2.setFloat(9,no_Of_DaysFinal);
			pstmt2.setString(10,"0");
			pstmt2.setString(11,startDateToBeUpdated);
			pstmt2.setString(12,endDateToBeUpdated);
			pstmt2.setString(13, currentDate);
			pstmt2.setString(14, leaveProvided);
			
			rs2=pstmt2.executeUpdate();
			
			if(rs2>=0)
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
