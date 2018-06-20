/************************************************************************************
 * Purpose: To check whetherthe given year is leap year or not and ensure it is a 4 digit number..
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 16/05/2018
 * 
 */


package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to find whether the given year is leap year or not
 *
 */
public class LeapYear {
	static int YEAR;
public static void main(String[] args)
{
	Utility utility=new Utility();
	System.out.println("Enter the Year:");
	boolean result=false;
	YEAR=utility.inputInt();
	if (YEAR<999 || YEAR>9999)//restriction year to a 4 digit no
	{
		System.out.println("please enter 4 digit number!!");
	}
	else
		result=Utility.leap(YEAR);
	
	if (result==true)
	{
		System.out.println(" IT IS A LEAP YEAR!");
	}
	else
		System.out.println("IT IS NOT A LEAP YEAR");
	}
  
}

