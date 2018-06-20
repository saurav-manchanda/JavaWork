/********************************************************************************* *
 * Purpose: to   calculate     monthlyPayment   that   reads   in   three  
command­line   arguments   P,   Y,   and   R   and   calculates   the   monthly   payments   you  
would   have   to   make   over   Y   years   to   pay   off   a   P   principal   loan   amount   at   R   per   cent  
interest   compounded   monthly. 

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 17/05/2018
 *********************************************************************************/
package com.bridgelabz.alogoritm;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 *Class to calculate monthly payment
 */
public class MonthlyPayment {
	public static void main (String[] args) 
	{
		double  principal = Double.parseDouble(args[0]);
		double  year = Double.parseDouble(args[1]);
		double  rate = Double.parseDouble(args[2]);
		Utility.monthlyPayment(principal,year,rate);
	}    

}
