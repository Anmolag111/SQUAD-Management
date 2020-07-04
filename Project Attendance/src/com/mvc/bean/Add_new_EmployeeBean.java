package com.mvc.bean;

public class Add_new_EmployeeBean {
	
	
	private String Fname;
	private String Lname;
	private String email;
	private String password;
	private String Eid;
	private String Phone_no;
	private String Branch;
	private int  CasualLeave;
	private int  MedicalLeave;
	private int SpecialCasualLeave;
	private String Role;
	private String Designation;
	private String DOJ;
	private int OnDutyLeave;
	private int ElLeave;

	public void setFname(String Fname)
	{
		this.Fname=Fname;
	}

	public void setLname(String Lname)
	{
		this.Lname=Lname;
	}
	

	public void setEmail(String email)
	{
		this.email=email;
	}
	
	public void setPassword(String password)
	{
		this.password=password;
	}
	public void setEid(String Eid)
	{
		this.Eid=Eid;
	}
	public void setPhone_no(String Phone_no)
	{
		this.Phone_no=Phone_no;
	}
	public void setBranch(String Branch)
	{
		this.Branch=Branch;
	}
	
	public void setDOJ(String DOJ)
	{
		this.DOJ=DOJ;
	}
	public void setDesignation(String Designation)
	{
		this.Designation=Designation;
	}
	
	
	
	public void setRole(String Role)
	{
		this.Role=Role;
	}
	public String getFname()
	{
		return Fname;
	}
	
	public String getLname()
	{
		return Lname;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getPassword()
	{
		return password;
	}
	public String getEid()
	{
		return Eid;
	}
	public String getDOJ()
	{
		return DOJ;
	}
	public String getDesignation()
	{
		return Designation;
	}
	public String getPhone_no()
	{
		return Phone_no;
	}
	public String getBranch()
	{
		return Branch;
	}
	public int getCasualLeave() {
		return CasualLeave;
	}

	public void setCasualLeave(int casualLeave) {
		CasualLeave = casualLeave;
	}

	public int getMedicalLeave() {
		return MedicalLeave;
	}

	public void setMedicalLeave(int medicalLeave) {
		MedicalLeave = medicalLeave;
	}

	public int getSpecialCasualLeave() {
		return SpecialCasualLeave;
	}

	public void setSpecialCasualLeave(int specialCasualLeave) {
		SpecialCasualLeave = specialCasualLeave;
	}

	public int getOnDutyLeave() {
		return OnDutyLeave;
	}

	public void setOnDutyLeave(int onDutyLeave) {
		OnDutyLeave = onDutyLeave;
	}

	public int getElLeave() {
		return ElLeave;
	}

	public void setElLeave(int elLeave) {
		ElLeave = elLeave;
	}

	public String getRole()
	{
		return Role;
	}
}
