package com.mvc.bean;

public class Delete_ReviewBean {
	
	private  int count=-1;
	private  String Eid=null;
	private  String leaveType=null;
	private  String startDate=null;
	private  String endDate=null;
	
	public  int getCount() {
		return count;
	}
	public  void setCount(int count) {
		this.count = count;
	}
	public  String getEid() {
		return Eid;
	}
	public  void setEid(String eid) {
		this.Eid = eid;
	}
	public  String getLeaveType() {
		return leaveType;
	}
	public  void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public  String getStartDate() {
		return startDate;
	}
	public  void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public  String getEndDate() {
		return endDate;
	}
	public  void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
