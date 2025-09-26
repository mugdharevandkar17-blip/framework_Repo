package com.comcast.crm.webdriverUtility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int randomNumber() {
		Random rm=new Random();
		int a=rm.nextInt(5000);
		return a;
	}
	
	public String getSystemdate() {
		Date dobj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dobj);
		return date;
		
		
	}
	
	public String getRequireDate(int days) {
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String requiredate = sim.format(cal.getTime());
		return requiredate;
	}
}
