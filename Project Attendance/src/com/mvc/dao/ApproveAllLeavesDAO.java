package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.ReviewLeavesBean;
import com.mvc.bean.SendMailUpdateBean;
import com.mvc.util.DBConnection;
import com.mvc.util.SendMailLeaveExhausted;
import com.mvc.util.SendMailUpdate;

public class ApproveAllLeavesDAO {

	private static Connection con=null;
	private static PreparedStatement pstmt=null;
	private static PreparedStatement pstmt1=null;
	private static PreparedStatement pstmt2=null;
	private static PreparedStatement pstmt3=null;
	private static ResultSet rs=null;
	private static int res1=-1;
	private static int res2=-1;
	private static int res3=-1;
	
	
	
	
	public static String doApproveAll()
	{
		
		try {
			con=DBConnection.getConnection();
			String msg="select * from leaveReview where Date=?";
			pstmt=con.prepareStatement(msg);
			pstmt.setString(1, ReviewLeavesBean.getCurrentDate());
			rs=pstmt.executeQuery();
				
			if(rs!=null)
			{
				while(rs.next())
				{
					String msg1="insert into leavededuction values(?,?,?,?,?,?,?,?)";
					pstmt1=con.prepareStatement(msg1);
					
					pstmt1.setString(1,rs.getString("Eid"));
					pstmt1.setString(2,rs.getString("Type_Of_Leave"));
					pstmt1.setString(3,rs.getString("Start_Date"));
					pstmt1.setString(4,rs.getString("End_Date"));
					pstmt1.setString(5,rs.getString("Begin_Time"));
					pstmt1.setString(6,rs.getString("End_Time"));
					pstmt1.setFloat(7,rs.getFloat("No_of_Days"));
					pstmt1.setString(8,rs.getString("Remarks"));
					
					res1=pstmt1.executeUpdate();
					
					
					String msg2="UPDATE leavequota SET Default_Quota=? where Eid=? and Type_Of_Leave=? and Start_Date=? and End_Date=?";
					pstmt2=con.prepareStatement(msg2);
					
					pstmt2.setFloat( 1,  rs.getFloat("Default_Quota"));
					pstmt2.setString(2, rs.getString("Eid"));
					pstmt2.setString(3, rs.getString("Type_Of_Leave"));
					pstmt2.setString(4, rs.getString("Start_Date_Quota"));
					pstmt2.setString(5, rs.getString("End_Date_Quota"));
					
					res2=pstmt2.executeUpdate();
					
					//******************************************//
					//write mail functionality here
					SendMailUpdateBean updBean=new SendMailUpdateBean();
					String mailQuery1="select * from leavequota where Eid=? and Type_Of_Leave=? and Start_Date=? and End_Date=? ";
					PreparedStatement pstmt5 = con.prepareStatement(mailQuery1);
					
					pstmt5.setString(1, rs.getString("Eid"));
					pstmt5.setString(2, rs.getString("Type_Of_Leave"));
					pstmt5.setString(3, rs.getString("Start_Date_Quota"));
					pstmt5.setString(4, rs.getString("End_Date_Quota"));
					
					ResultSet rs1 = pstmt5.executeQuery();
					
					while(rs1.next())
					{
						 float leavesLeft=rs1.getFloat("Number_of_Quota")-rs1.getFloat("Default_Quota");
						 updBean.setLeavesLeft(leavesLeft);
						if(leavesLeft==0)
						{
							mailQuery1="Select Email from msitlogin where Eid=?";
							PreparedStatement pstmt6 = con.prepareStatement(mailQuery1);
							pstmt6.setString(1, rs.getString("Eid"));
							
							ResultSet rs2 = pstmt6.executeQuery();
							
							if(rs2!=null)
							{
								updBean.setEmail(rs2.getString("Email"));
								updBean.setLeaveType(rs.getString("Type_Of_Leave"));
								if(updBean.getEmail()!=null)
									SendMailLeaveExhausted.send(updBean);
									
							}
							
						}
					}
					
					mailQuery1="Select Email from msitlogin where Eid=?";
					PreparedStatement pstmt7 = con.prepareStatement(mailQuery1);
					pstmt7.setString(1, rs.getString("Eid"));
					
					ResultSet rs3 = pstmt7.executeQuery();
					
					while(rs3.next())
					{
						updBean.setEmail(rs3.getString("Email"));
					}
						
						updBean.setReason(rs.getString("Remarks"));
						updBean.setLeaveProvided(rs.getString("LeaveProvided"));
						updBean.setLeaveType(rs.getString("Type_Of_Leave"));
						updBean.setStartDate(rs.getString("Start_Date"));
						updBean.setEndDate(rs.getString("End_Date"));
						
						if(updBean.getEmail()!=null)
						{
							SendMailUpdate.send(updBean);	
							System.out.println("Mail Sent Successfully.");
						}
							
					
					//*****************************************//
					String query="delete from leaveReview where Date=?";
					pstmt3=con.prepareStatement(query);
					
					pstmt3.setString(1, ReviewLeavesBean.getCurrentDate());
					
					res3=pstmt3.executeUpdate();
					
					
					
				}
					
				
			}
			
			String query1="select * from leaveReview where Date=?";
			PreparedStatement pstmt4 = con.prepareStatement(query1);
			pstmt4.setString(1, ReviewLeavesBean.getCurrentDate());
			
			ReviewLeavesBean.setRs(pstmt4.executeQuery());
			
			if(ReviewLeavesBean.getRs()==null && res1>=0 && res2>=0 && res3>=0)
				return "Success";
			else
				return "NoSuccess";
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}
}
