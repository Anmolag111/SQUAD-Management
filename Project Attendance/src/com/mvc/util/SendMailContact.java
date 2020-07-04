package com.mvc.util;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import com.mvc.bean.ContactUsBean;

public class SendMailContact 
{ 
	
	
    public static void send(ContactUsBean contactusbean)
    { 
    	String to="msitlm.19@gmail.com";
    	String user="msitlm.19@gmail.com";
    	String pass="Password123$";
    	String sub=contactusbean.getSubject();
    	String msg="Hi Admin \n"+contactusbean.getName()+" has contacted with the following message:\n"
    			+contactusbean.getMessage();
    	
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