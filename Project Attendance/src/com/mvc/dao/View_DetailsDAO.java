package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.View_DetailsBean;
import com.mvc.util.DBConnection;

public class View_DetailsDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public String fun(View_DetailsBean vdb) throws SQLException {
		
		String Eid = vdb.getEid();
		String StartDate = vdb.getStartDate();
		String EndDate = vdb.getEndDate();
		
		//System.out.println(StartDate);
		//System.out.println(EndDate);
		System.out.println("DB"+Eid);
		
		con = DBConnection.getConnection();

		String msg = "select * from leavededuction where Eid=? and Start_Date between ? and ?";

		pstmt = con.prepareStatement(msg);
		pstmt.setString(1, Eid);
		pstmt.setString(2, StartDate);
		pstmt.setString(3, EndDate);
		rs = pstmt.executeQuery();
		
		
		
		if (rs!=null) 
		{
			View_DetailsBean.setResultSet(rs);
			return "Successful";
		} 
		else 
		{
			return "Not Successful";
		}

	}

}
