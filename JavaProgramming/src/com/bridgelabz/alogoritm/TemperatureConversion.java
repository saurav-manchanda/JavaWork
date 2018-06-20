/********************************************************************************* *
 * Purpose: given   the   temperature  
in   fahrenheit   as   input   outputs   the   temperature   in   Celsius   or   viceversa   using   the  
formula 
Celsius   to   Fahrenheit:       (°C   ×   9/5)   +   32   =   °F 
Fahrenheit   to   Celsius:       (°F   −   32)   x   5/9   =   °C  

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 22/05/2018
 *********************************************************************************/
package com.bridgelabz.alogoritm;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to do Temperature Conversion
 */
public class TemperatureConversion {
	public static void main (String[] args) 
	{
		Utility utility= new Utility();
		double celcius=0.0;
		double fahrenheit=0.0;
		while(true)
		{
			System.out.println("Enter the choice:");
			System.out.println("1: Celsius to Fahrenheit.");
			System.out.println("2: Fahrenheit to Celsius.");
			System.out.println("press any key for exit.");
			int choice = utility.inputInt();
			switch (choice) 
			{			
			    case 1: // convert Celsius to Fahrenheit
			    		System.out.println("Enter the Temperature in celsius.");
						celcius=utility.inputDouble();
			    		fahrenheit = (celcius*9/5) + 32;
			    		System.out.println("Temperature in Fahrenheit : "+fahrenheit);
			    	 break;
			    	 	
			    case 2: // convert Fahrenheit to Celsius
			    		System.out.println("Enter the Temperature in Fahrenheit.");
						fahrenheit = utility.inputDouble();
			    		celcius = (fahrenheit-32)*5/9;
			    		System.out.println("Temperature in Celsius : "+celcius); 
			    	break;
			    default :System.out.println("Wrong choice");
			    	return;
			}
		}
	} 

}
