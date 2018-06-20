/********************************************************************************* *
 * Purpose: add     dayOfWeek   static   function   that   takes   a   date   as   input   and  
prints   the   day   of   the   week   that   date   falls   on.

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 22/05/2018
 *********************************************************************************/
package com.bridgelabz.alogoritm;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to find the DayOfWeek
 */
public class DayOfWeek {
	public static void main (String[] args) 
	{
		Utility utility = new Utility();
		String arr[] = {"Sun","Mon","Tue","Wed","Thus","Fri","Sat"};
		int month = Integer.parseInt(args[0]);
		int day = Integer.parseInt(args[1]);
		int year = Integer.parseInt(args[2]);
		System.out.println("Entered date is : " + month + "/" + day + "/" + year);
		int result = utility.dayOfWeek(month,day,year);
		System.out.println("The day is:");
		System.out.println(arr[result]);
	}
}
