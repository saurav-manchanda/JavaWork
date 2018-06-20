/********************************************************************************* 
 * Purpose: Write   a   program     Calendar.java   that   takes   the   month   and   year   as   command­line  
arguments   and   prints   the   Calendar   of   the   month.   Store   the   Calendar   in   an   2D   Array,  
the   first   dimension   the   week   of   the   month   and   the   second   dimension   stores   the   day  
of   the   week.  
 * @author Saurav Manchanda
 * @version 1.0
 * @since 18/05/2018
 *********************************************************************************/
package com.bridgelabz.datastructures;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to display the calender of the month
 */
public class Calender {

	static String[] MONTHS = { " ", "january", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };// the first space is for " "
	static int[] DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		Utility utility = new Utility();
		int month = Integer.parseInt(args[0]);
		int year = Integer.parseInt(args[1]);
		if (Utility.leap(year))
			DAYS[2] = 29;
		System.out.println("   " + MONTHS[month] + " " + year);
		System.out.println(" S  M  Tu  W  Th  F  S");

		// starting day
		int startingDay = utility.dayOfWeek(month, 1, year);

		// print the calendar
		for (int i = 0; i < startingDay; i++)
			System.out.print("   ");
		for (int i = 1; i <= DAYS[month]; i++) {
			if(i<=9)
			System.out.print("  "+i);
			else System.out.print(" "+i);
			if (((i + startingDay) % 7 == 0) || (i == DAYS[month]))
				System.out.println();
		}
	}
}
