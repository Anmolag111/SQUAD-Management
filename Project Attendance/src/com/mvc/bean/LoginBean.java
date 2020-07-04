package com.mvc.bean;

public class LoginBean {
	
	private static String eid;
	private String password;
	private static String email;
	
	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		LoginBean.email = email;
	}

	public void setEid(String eid)
	{
		LoginBean.eid=eid;
	}
	
	public void setPassword(String password)
	{
		this.password=password;
	}
	
	public static String getEid()
	{
		return eid;
	}
	
	public String getPassword()
	{
		return password;
	}

}
