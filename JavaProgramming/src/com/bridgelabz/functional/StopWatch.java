/************************************************************************************
 * Purpose: Write   a   Stopwatch   Program   for   measuring   the   time   that   elapses   between 
the   start   and   end   clicks
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
 * class to Write   a   Stopwatch   Program   for   measuring   the   time   that   elapses   between 
the   start   and   end   clicks
 */
public class StopWatch {
	static double START,END,ELAPSE_TIME;
	public static void main(String[] args) {
		Utility utility= new Utility();
		System.out.println("Do you want to start the Stop watch:(Y/N)");
		String choice= utility.inputString();
		
		String Y="Y";
		if(choice.equalsIgnoreCase(Y))
				{
					START=System.currentTimeMillis();
					System.out.println("your current time is:"+START);
					System.out.println("Press S to stop:");
					String ask= utility.inputString();
					if(ask.equalsIgnoreCase("S"))
					{
						END= System.currentTimeMillis();
						System.out.println("your end time is:"+END);
						
					}
					
				}
		else
			System.out.println("ok bye!");
		ELAPSE_TIME = (END-START)/1000;
		System.out.println("elapsed time is:"+ELAPSE_TIME);

	}

}
