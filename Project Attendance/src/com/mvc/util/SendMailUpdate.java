package com.mvc.util;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import com.mvc.bean.SendMailUpdateBean;


public class SendMailUpdate 
{ 
	
	
    public static void send(SendMailUpdateBean updBean)
    { 
    	String to=updBean.getEmail();
    	String user="msitlm.19@gmail.com";
    	String pass="Password123$";
    	String sub="Leaves Updated Successfully.";
    	String msg="";
    	if(updBean.getLeaveProvided()=="Yes")
    	{
    		msg+="Hi! There \n Your "+updBean.getLeaveType()+" Leaves have been sanctioned from "+updBean.getStartDate()+" to "+updBean.getEndDate()+" for the following Reason:"
    	    +updBean.getReason()+"\n"
    	    +"Your Remaining Leaves for "+updBean.getLeaveType()+" Type of Leave is :"+updBean.getLeavesLeft()+
    	    "\n Please Visit the site for Detailed Summary of Leave.";
    	}
    	else
    	{
    		msg+="Hi! There \n Your "+updBean.getLeaveType()+" Leaves have been sanctioned from "+updBean.getStartDate()+" to "+updBean.getEndDate()+" for the following Reason:"
    	    	    +updBean.getReason()+"\n But Your Leave Application has not been provided Kindly Submit the Application at the earliest possible date. \n"
    	    	    +"Your Remaining Leaves for "+updBean.getLeaveType()+" Type of Leave is :"+updBean.getLeavesLeft()+
    	    	    "\n Please Visit the site for Detailed Summary of Leave.";
    	}
    	
    	
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