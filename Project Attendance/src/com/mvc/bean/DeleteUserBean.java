package com.mvc.bean;

public class DeleteUserBean {
	
	
	private String Eid;
	private String Role;
	private String LeaveType;
	
	private String StartDate;
	private String EndDate;
	private String StartTime;
	private String EndTime;
	private String Duration;
	private Float NoOfDays;
	private float DefaultQuota;
	
	public float getDefaultQuota() {
		return DefaultQuota;
	}
	public void setDefaultQuota(float defaultQuota) {
		DefaultQuota = defaultQuota;
	}
	public void setNoOfDays(Float noOfDays) {
		NoOfDays = noOfDays;
	}
	public float getNoOfDays() {
		return NoOfDays;
	}
	public void setNoOfDays(float noOfDays) {
		NoOfDays = noOfDays;
	}
	public String getDuration() {
		return Duration;
	}
	public void setDuration(String duration) {
		Duration = duration;
	}
	public String getLeaveType() {
		return LeaveType;
	}
	public void setLeaveType(String leaveType) {
		LeaveType = leaveType;
	}
	
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
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
//	public String getDuration() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	

}
