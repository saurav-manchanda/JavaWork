/*********************************************************************************
 * 
 * Purpose: Computes the prime factorization of N 

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 17/05/2018
 *********************************************************************************/
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to compute the prime factorization
 */
public class Factors {
	static int NUMBER;
	public static void main(String[] args) {
		Utility utility =new Utility();
		System.out.println("Enter the number:");
		NUMBER=utility.inputInt();//calling method of Utility
		System.out.println("The prime factors of "+NUMBER + " are:");
		int i=2;
		while (NUMBER>1)
		{
			if(NUMBER%i==0)
			{	System.out.println(i + "  ");
				NUMBER=NUMBER/i;
			}
			else
				i++;
		}
	}

}
