package com.mvc.dao;

import com.mvc.bean.ForgetPassBean;

public class GeneratePassword {

	private static String randomString()
	{
		String pass="";
		
		char alphabet[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 
                'h', 'i', 'j', 'k', 'l', 'm', 'n',  
                'o', 'p', 'q', 'r', 's', 't', 'u', 
                'v', 'w', 'x', 'y', 'z' ,'1','2','3','4','5','6','7','8','9','@',
                '*','(','&','^','%','$','#','!',}; 
		for(int i=0;i<10;i++)
		{
			pass+=alphabet[(int)(Math.random()*alphabet.length)];
		}
		
		return pass;
	}
	
	public static String generate(ForgetPassBean forgetpassbean) {
		String newPass=null;
		
		newPass=randomString();
		
		
		return newPass;
	}

	
}
