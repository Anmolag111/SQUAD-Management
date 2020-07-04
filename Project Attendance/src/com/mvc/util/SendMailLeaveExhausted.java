package com.mvc.util;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import com.mvc.bean.SendMailUpdateBean;

public class SendMailLeaveExhausted 
{ 
	
	
    public static void send(SendMailUpdateBean updBean)
    { 
    	String to=updBean.getEmail();
    	String user="msitlm.19@gmail.com";
    	String pass="Password123$";
    	String sub="Leaves Exhausted.";
    	String msg="Hi! There \n Your "+updBean.getLeaveType()+" Leaves has been exhausted. \n"+
    	    "Please Visit the site for Detailed Summary of Leave.";
    	
    	
    	
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