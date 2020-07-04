package com.mvc.bean;


public class Update_UsersBean {


	private String Eid;
	private String Email;
	private String leaveType;
	private String currentYear;
	private boolean isLeaveProvided;
	private String startDate;
	private String endDate;
	private String startTime;
	private String endTime;
	private float no_Of_Days;
	private String Reason;
	private float remaining_Leaves;
	private String currentDate;
	
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	public float getRemaining_Leaves() {
		return remaining_Leaves;
	}
	public void setRemaining_Leaves(float remaining_Leaves) {
		this.remaining_Leaves = remaining_Leaves;
	}
	public String getCurrentYear() {
		return currentYear;
	}
	public void setCurrentYear(String currentYear) {
		this.currentYear = currentYear;
	}
	public String getEid() {
		return Eid;
	}
	public void setEid(String eid) {
		Eid = eid;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public boolean isLeaveProvided() {
		return isLeaveProvided;
	}
	public void setLeaveProvided(boolean isLeaveProvided) {
		this.isLeaveProvided = isLeaveProvided;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public float getNo_Of_Days() {
		return no_Of_Days;
	}
	public void setNo_Of_Days(float no_Of_Days) {
		this.no_Of_Days = no_Of_Days;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	


}
