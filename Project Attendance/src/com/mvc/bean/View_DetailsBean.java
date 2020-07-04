package com.mvc.bean;

import java.sql.ResultSet;

public class View_DetailsBean {

	private String Eid;
	private static ResultSet rs;
	private String StartDate;
	private String EndDate;

	public String getEid() {
		return Eid;

	}

	public void setEid(String eid) {
		Eid = eid;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	public static ResultSet getResultSet() {
		return rs;
	}

	public static void setResultSet(ResultSet resultSet) {

		rs = resultSet;
	}

}
