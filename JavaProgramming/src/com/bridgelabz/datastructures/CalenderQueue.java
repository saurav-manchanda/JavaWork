/********************************************************************************* *
 * Purpose: To make the Calender Queue
 * @author Saurav Manchanda
 * @version 1.0
 * @since 29/05/2018
 *********************************************************************************/
package com.bridgelabz.datastructures;

import com.bridgelabz.utility.Utility;
/**
 * @author Saurav:
 * Class to have day and date arrays
 */
class WeekDay{
	String[] day= {"S","M","Tu","W","Th","F","S"};
	int[] date= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
}
/**
 * @author Saurav:
 * Class to make Calender via Queue
 */
public class CalenderQueue {
	static String[] MONTHS = { " ", "january", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };// the first space is for " "
	static int[] DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		LinkedQueue<String> queue1= new LinkedQueue<>();
		LinkedQueue<Integer> queue2= new LinkedQueue<>();
		WeekDay weekDay=new WeekDay();
		for(int i=0; i<weekDay.day.length;i++)
        {
        	queue1.enqueue(weekDay.day[i]);
        }
		for(int i=0; i<weekDay.date.length;i++)
        {
        	queue2.enqueue(weekDay.date[i]);
        }
		Utility utility = new Utility();
		int month = Integer.parseInt(args[0]);
		int year = Integer.parseInt(args[1]);
		if (Utility.leap(year))
			DAYS[2] = 29;
		System.out.println("   " + MONTHS[month] + " " + year);
		queue1.display();
        System.out.println();
		// starting day
		int startingDay = utility.dayOfWeek(month, queue2.front.data, year);

		// print the calendar
		for (int i = 0; i < startingDay; i++)
			System.out.print("  ");
		for (int i = 1; i <= DAYS[month]; i++) {
			if (i <= 7)
				System.out.print(i+"      ");
			else
				System.out.print(i+"    ");
			if (((i + startingDay) % 7 == 0) || (i == DAYS[month]))
				System.out.println();

		}
	}
}
