package com.crm.autodeskSeleniumFramework.javaUtility;

import java.awt.Robot;
import java.util.Date;
import java.util.Random;

/**
 * this class contains java specific generic libraries
 * @author kailas
 *
 */
public class JavaUtility {
	/**
	 * it is used to generate the random integer number with in the boundry of 0 to 10000
	 * @return int
	 */

public int getRandomNumber(){
	Random random=new Random();
	int randomNum=random.nextInt(10000);
	return randomNum;
}
/**
 * it is used to get the current system date and time in the Gmt time String format.
 * @ return systemDateAndTime
 */
public String getSystemDate_YYYY_MM_DD() {
	Date date=new Date();
	String systemDateAndTime=date.toString();
	String[]arr=systemDateAndTime.split("");
	String dd=arr[2];
	String yyyy=arr[5];
	int mm=date.getMonth()+1;
	String dateGmt=yyyy+"-"+mm+"-"+dd;
	return dateGmt;
	
}

/**
 * its used to get the current System date & time
 * @return
 */
public String getSystmeDate() {
	Date date = new Date();
	String systemDateAndTime = date.toString().replace(":","-");
	return systemDateAndTime;
}

}
	
		
