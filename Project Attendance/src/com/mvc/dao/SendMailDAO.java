package com.mvc.dao;


import com.mvc.bean.SendMailBean;
import com.mvc.util.SendMail;


public class SendMailDAO {
	
	public static void sendMail(SendMailBean sendmailbean)
	{
		SendMail.send(sendmailbean);
		System.out.println("Mail Sent Successfully!!.");
	}

	
	
}
