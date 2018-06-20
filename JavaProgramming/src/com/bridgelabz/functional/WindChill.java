/*********************************************************************************
 * 
 * Purpose: Given   the   temperature   t   (in   Fahrenheit)   and   the   wind   speed   v   (in   miles   per   hour),  
the   National   Weather   Service   defines   the   effective   temperature   (the   wind   chill)

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 18/05/2018
 *********************************************************************************/
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to Calculate the Wind Chill effective Temperature
 */
public class WindChill {
static double TEMPERATURE,WIND_SPEED,WIND_CHILL_EFFECTIVE_TEMPERATURE;
	public static void main(String[] args) {
		Utility utility=new Utility();
		TEMPERATURE=Double.parseDouble(args[0]);
		WIND_SPEED=Double.parseDouble(args[1]);
		WIND_CHILL_EFFECTIVE_TEMPERATURE= utility.windChillCalculation(TEMPERATURE,WIND_SPEED);
		System.out.println("The wind chill is:"+WIND_CHILL_EFFECTIVE_TEMPERATURE);

	}

}
