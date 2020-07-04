package com.mvc.controller;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CalculateDateDifference {
	public static float CalculateNoOfDays(String s, String s1) {
		LocalDate d1 = LocalDate.parse(s, DateTimeFormatter.ISO_LOCAL_DATE);
		LocalDate d2 = LocalDate.parse(s1, DateTimeFormatter.ISO_LOCAL_DATE);
		Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
		long diffDays = diff.toDays() + 1;
		return diffDays;
	}
	
	public static String getCurrenDate()
	{
		LocalDate today = LocalDate.now( ZoneId.of( "Asia/Kolkata" ) ) ;
		String output = today.toString() ; 
		
		return output;
	}

}
