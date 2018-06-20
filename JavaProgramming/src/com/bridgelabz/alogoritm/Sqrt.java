/********************************************************************************* *
 * Purpose:   To   compute   the   square   root   of   a   nonnegative   number   c  
given   in   the   input   using   Newton's   method.

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 17/05/2018
 *********************************************************************************/
package com.bridgelabz.alogoritm;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to compute the square root of a number
 */
public class Sqrt {
	public static void main (String[] args) 
	{
		double c = Double.parseDouble(args[0]); 
		if(c>=0) {
		double t = c;
		double epsilon = 1e-15;
		double res = Utility.sqrt(c,t,epsilon);
		System.out.println(res);
		}
		else
			System.out.println("the ouput will be imaginary");
	}  

}
