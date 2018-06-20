/*********************************************************************************
 * 
 * Purpose: Prints the Nth harmonic number: 1/1 + 1/2 + ... + 1/N

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 17/05/2018
 *********************************************************************************/
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to print the Harmonic value of a number
 */
public class HarmonicNumber {
	static int NUMBER;
	public static void main(String[] args) {	
	Utility utility = new Utility();
	System.out.println("Enter the number:");
	NUMBER = utility.inputInt(); //calling a method
	double har_num = 0.0;
	if (NUMBER<0)
		System.out.println("N should be positive");
	else if(NUMBER==0) {
		har_num=0;
		System.out.println("The harmonic value is "+har_num+ " as N!=0");
	}
	else
	{
	// to find harmonic value of range n
	for (int i=1;i<=NUMBER;i++)
	{
		har_num += 1.0/i;
	}
				
	System.out.println("The Harmonic value is: " +har_num);
	}
	}
}

