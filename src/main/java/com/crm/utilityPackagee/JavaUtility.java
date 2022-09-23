package com.crm.utilityPackagee;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * to get the random number
	 * @return
	 */

	public int getRandomNumber()
	{
		Random random = new Random();
		int rnum = random.nextInt(1000);
		return rnum;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSystemDate()
	{
		Date date = new Date();
		String dateTime = date.toString();
		return dateTime;
	}
	
	/**
	 * to get the systemdateInFormat
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date date= new Date();
		String dateTime=date.toString();
		String[] dateArr=dateTime.split("");
		
		int month =date.getMonth()+1;
		String date1=dateArr[2];
		String year = dateArr[5];
		int day = date.getDay();
		String time=dateArr[3];
		
		String finalFormat=month+" "+date+" "+year+" "+day+" "+time;
		return finalFormat;
 	}
}
