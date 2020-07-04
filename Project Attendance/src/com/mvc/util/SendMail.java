package com.mvc.util;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import com.mvc.bean.SendMailBean;

public class SendMail 
{ 
	
	
    public static void send(SendMailBean sendmailbean)
    { 
    	String to=sendmailbean.getEmail();
    	String user="msitlm.19@gmail.com";
    	String pass="Password123$";
    	String sub="Welcome To Project Attendance.";
    	String msg="Hi! "+sendmailbean.getFname()+" you have been Successfully Registered on our site. \n You may start using the site.";
    	
     Properties props = new Properties();
     
     props.put("mail.smtp.host", "smtp.gmail.com");
     props.put("mail.smtp.port", "587");		
     props.put("mail.smtp.auth", "true");
     props.put("mail.smtp.starttls.enable", "true");
     
     /* Pass Properties object(props) and Authenticator object   
           for authentication to Session instance 
        */

    Session session = Session.getInstance(props,new javax.mail.Authenticator()
    {
  	  protected PasswordAuthentication getPasswordAuthentication() 
  	  {
  	 	 return new PasswordAuthentication(user,pass);
  	  }
   });
    
   try
   {
 
    MimeMessage message = new MimeMessage(session);
       message.setFrom(new InternetAddress(user));
       message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
       message.setSubject(sub);
       message.setText(msg);

       
       Transport.send(message);
 
 
    }
    catch(Exception e)
    {
    	 e.printStackTrace();
    }
  }

	
}