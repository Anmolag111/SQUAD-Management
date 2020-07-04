package com.mvc.bean;

public class Change_SettingsBeam {
	
	private String email;
	private String password;
	private String Newpassword;
	
	public void setEmail(String email)
	{
		this.email=email;
	}
	
	public void setPassword(String password)
	{
		this.password=password;
	}
	public void setNewpassword(String Newpassword)
	{
		this.Newpassword=Newpassword;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getPassword()
	{
		return password;
	}
	public String getNewpassword()
	{
		return Newpassword;
	}
}
