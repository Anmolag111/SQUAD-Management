package com.mvc.bean;

public class SendMailUpdateBean {

	private String Email;
	private String LeaveType;
	private String leaveProvided;
	private String Reason;
	private String startDate;
	private String endDate;
	private float leavesLeft;
	
	
	public String getLeaveProvided() {
		return leaveProvided;
	}
	public void setLeaveProvided(String leaveProvided) {
		this.leaveProvided = leaveProvided;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
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
	public float getLeavesLeft() {
		return leavesLeft;
	}
	public void setLeavesLeft(float leavesLeft) {
		this.leavesLeft = leavesLeft;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getLeaveType() {
		return LeaveType;
	}
	public void setLeaveType(String leaveType) {
		LeaveType = leaveType;
	}
	
}
