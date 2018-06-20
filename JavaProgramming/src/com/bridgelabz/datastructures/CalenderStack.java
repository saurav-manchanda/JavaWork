/********************************************************************************* *
 * Purpose: To make the Calender Stack
 * @author Saurav Manchanda
 * @version 1.0
 * @since 29/05/2018
 *********************************************************************************/
package com.bridgelabz.datastructures;

import com.bridgelabz.utility.Utility;
/**
 * @author Saurav:
 * Class to make a Calnder via Stack
 */
public class CalenderStack {
	static String[] MONTHS = { " ", "january", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };
	static int[] DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		WeekDay weekDay=new WeekDay();
		LinkedStack<String> stack1= new LinkedStack<>();
		LinkedStack<Integer> stack2= new LinkedStack<>();
		for(int i=weekDay.day.length-1;i>=0;i--) {
			stack1.push(weekDay.day[i]);
		}
		for(int i=weekDay.date.length-1;i>=0;i--) {
			stack2.push(weekDay.date[i]);
		}
		Utility utility = new Utility();
		int month = Integer.parseInt(args[0]);
		int year = Integer.parseInt(args[1]);
		if (Utility.leap(year))
			DAYS[2] = 29;
		System.out.println("   " + MONTHS[month] + " " + year);
		stack1.display();
		System.out.println();

		// starting day
		int startingDay = utility.dayOfWeek(month, stack2.top.data, year);

		// print the calendar
		for (int i = 0; i < startingDay; i++)
			System.out.print("   ");
		for (int i = 1; i <= DAYS[month]; i++) {
			if (i <= 7)
				System.out.print("   " + i);
			else
				System.out.print("  " + i);
			if (((i + startingDay) % 7 == 0) || (i == DAYS[month]))
				System.out.println();
		}
	
	}
	
}
