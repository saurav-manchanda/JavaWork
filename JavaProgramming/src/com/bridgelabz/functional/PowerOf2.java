/*********************************************************************************
 * 
 * Purpose: This program takes a command­line argument N and prints a table of the
powers of 2 that are less than or equal to 2^N.

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 17/05/2018
 *********************************************************************************/
package com.bridgelabz.functional;

/**
 * @author Saurav:
 * Class to print the table of power of N
 */
public class PowerOf2 {
	public static void main(String[] args) {
	int result=1;
	int number= Integer.parseInt(args[0]);
	if(number>=0 && number<31)
	{
	for(int i=1;i<=number;i++)
	{
		result=result*2;
		System.out.println("2^"+i+" = " +result);
	}
	}
	else
		System.out.println("Enter the number in between 0 to 30");
	
	}
}
