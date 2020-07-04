package com.mvc.bean;

public class ProfileBean {
	
	private static String email;
	private static String DOJ;
	private static String Designation;
	private static String Fname;
	private static String Lname;
	private static String Role;
	private static String Branch;
	private static String Eid;
	private static String Phone_No;
	private static float RemainingCasualLeave;
	private static float RemainingSpecialCasualLeave;
	private static float RemainingMedicalLeave;
	private static float RemainingOnDutyLeave;
	private static float RemainingEL;
	private static float TotalCasualLeave;
	private static float TotalSpecialCasualLeave;
	private static float TotalMedicalLeave;
	private static float TotalOnDutyLeave;
	private static float TotalEL;
	
	public static String getPhone_No() {
		return Phone_No;
	}
	public static void setPhone_No(String phone_No) {
		Phone_No = phone_No;
	}
	public static float getTotalOnDutyLeave() {
		return TotalOnDutyLeave;
	}
	public static void setTotalOnDutyLeave(float TotalonDutyLeave) {
		TotalOnDutyLeave = TotalonDutyLeave;
	}
	public static float getTotalEL() {
		return TotalEL;
	}
	public static void setTotalEL(float TotaleLLeave) {
		TotalEL = TotaleLLeave;
	}
	public static float getRemainingOnDutyLeave() {
		return RemainingOnDutyLeave;
	}
	public static void setRemainingOnDutyLeave(float RemainingonDutyLeave) {
		RemainingOnDutyLeave = RemainingonDutyLeave;
	}
	public static float getRemainingEL() {
		return RemainingEL;
	}
	public static void setRemainingEL(float RemainingeLLeave) {
		RemainingEL = RemainingeLLeave;
	}
	public static String getEmail() {
		return email;
	}
	@SuppressWarnings("static-access")
	public void setEmail(String email) {
		this.email = email;
	}
	public static String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public static String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public static String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public static String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public  static String getEid() {
		return Eid;
	}
	public void setEid(String eid) {
		Eid = eid;
	}
	public static float getRemainingCasualLeave() {
		return RemainingCasualLeave;
	}
	public void setRemainingCasualLeave(float RemainingcasualLeave) {
		RemainingCasualLeave = RemainingcasualLeave;
	}
	public static float getRemainingSpecialCasualLeave() {
		return RemainingSpecialCasualLeave;
	}
	public void setRemainingSpecialCasualLeave(float RemainingspecialCasualLeave) {
		RemainingSpecialCasualLeave = RemainingspecialCasualLeave;
	}
	public static  float getRemainingMedicalLeave() {
		return RemainingMedicalLeave;
	}
	public void setRemainingMedicalLeave(float RemainingmedicalLeave) {
		RemainingMedicalLeave = RemainingmedicalLeave;
	}
	@SuppressWarnings("static-access")
	public  void setDOJ(String DOJ)
	{
		this.DOJ=DOJ;
	}
	@SuppressWarnings("static-access")
	public void setDesignation(String Designation)
	{
	 this.Designation=Designation;
	}public static String getDOJ()
	{
		return DOJ;
	}
	public static String getDesignation()
	{
		return Designation;
	}
	public static float getTotalCasualLeave() {
		return TotalCasualLeave;
	}
	public void setTotalCasualLeave(float TotalcasualLeave) {
		TotalCasualLeave = TotalcasualLeave;
	}
	public static float getTotalSpecialCasualLeave() {
		return TotalSpecialCasualLeave;
	}
	public void setTotalSpecialCasualLeave(float TotalspecialCasualLeave) {
		TotalSpecialCasualLeave = TotalspecialCasualLeave;
	}
	public static  float getTotalMedicalLeave() {
		return TotalMedicalLeave;
	}
	public void setTotalMedicalLeave(float TotalmedicalLeave) {
		TotalMedicalLeave = TotalmedicalLeave;
	}

}
