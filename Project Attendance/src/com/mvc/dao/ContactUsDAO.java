package com.mvc.dao;

import com.mvc.bean.ContactUsBean;
import com.mvc.util.SendMailContact;

public class ContactUsDAO {

	public static String sendMail(ContactUsBean cub) {
		
		SendMailContact.send(cub);
		System.out.println("Message Sent Successfully.");
		return "Send";
	}
	
	

}
