package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.DeleteUserBean;
import com.mvc.util.DBConnection;

public class DeleteUserLeavesSA_DAO {
	private static Connection con = null;
	private static PreparedStatement pstmt = null;
	private static PreparedStatement pstmt1 = null;
	private static PreparedStatement pstmt2 = null;
	private static PreparedStatement pstmt3 = null;
	private static ResultSet rs = null;
	private static int rs1 = -1;
	private static int rs2 = -1;
	private static ResultSet rs3 = null;

	public static String func(DeleteUserBean DeleteUserBean) {

		String Eid = DeleteUserBean.getEid();

		String leaveType = DeleteUserBean.getLeaveType();
		String startDate = DeleteUserBean.getStartDate();
		String endDate = DeleteUserBean.getEndDate();

		try {
			con = DBConnection.getConnection();

			String msg = "select * from leavededuction where Eid=? and Type_Of_Leave=? and Start_Date= ? and End_Date=?";
			pstmt = con.prepareStatement(msg);
			pstmt.setString(1, Eid);
			pstmt.setString(2, leaveType);
			pstmt.setString(3, startDate);
			pstmt.setString(4, endDate);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				DeleteUserBean.setNoOfDays(rs.getFloat("No_Of_Days"));
				System.out.print(DeleteUserBean.getNoOfDays());
				String msg1 = "Delete from leavededuction where Eid=? and Type_Of_Leave=? and Start_Date= ? and End_Date=?";
				pstmt1 = con.prepareStatement(msg1);
				pstmt1.setString(1, Eid);
				pstmt1.setString(2, leaveType);
				pstmt1.setString(3, startDate);
				pstmt1.setString(4, endDate);

				rs1 = pstmt1.executeUpdate();
				if (rs1 > 0) {

					String msg2 = "select * from leavequota where Eid=? and Type_Of_Leave=?";
					pstmt2 = con.prepareStatement(msg2);
					pstmt2.setString(1, Eid);
					pstmt2.setString(2, leaveType);

					rs3 = pstmt2.executeQuery();
					if (rs3.next()) {
						DeleteUserBean.setDefaultQuota(rs3.getFloat("Default_Quota"));
						float NewDefaultQuota = DeleteUserBean.getDefaultQuota() - DeleteUserBean.getNoOfDays();

						String msg4 = "update leavequota set Default_Quota=? where Eid=? and Type_Of_Leave=?";
						pstmt3 = con.prepareStatement(msg4);
						pstmt3.setFloat(1, NewDefaultQuota);
						pstmt3.setString(2, Eid);
						pstmt3.setString(3, leaveType);

						rs2 = pstmt3.executeUpdate();
						System.out.print(NewDefaultQuota);
						if (rs2 > 0) {
							return "Deleted Successfully";
						}

						else {
							return "Please check your data again";
						}
					}
				}
			}

			else {
				return "Please check your data again";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "Please check your data again";

	}

}
