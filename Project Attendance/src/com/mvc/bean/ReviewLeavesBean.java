package com.mvc.bean;

import java.sql.ResultSet;

public class ReviewLeavesBean {

	private static ResultSet rs=null;
	private static String currentDate=null;

	public static String getCurrentDate() {
		return currentDate;
	}

	public static void setCurrentDate(String currentDate) {
		ReviewLeavesBean.currentDate = currentDate;
	}

	public static ResultSet getRs() {
		return rs;
	}

	public static void setRs(ResultSet rs) {
		ReviewLeavesBean.rs = rs;
	}
}
