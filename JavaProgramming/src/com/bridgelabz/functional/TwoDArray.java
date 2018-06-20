/************************************************************************************
 * Purpose: A library for reading in 2D arrays of integers, doubles, or booleans from
standard input and printing them out to standard output.
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
 * Class to make 2D array
 */
public class TwoDArray {
	static int ROW,COL;
	public static void main(String[] args) {
		Utility utility=new Utility();
		System.out.println("1. Interger ");
		System.out.println("2. Double ");
		System.out.println("3. Boolean ");
		System.out.println("Enter the choice of 2D Array you want to create:");
		int number= utility.inputInt();
		System.out.println("Enter the number of rows:");
		ROW= utility.inputInt();
		System.out.println("enter the number of columns:");
		COL= utility.inputInt();
		utility.makeArray(number, ROW, COL);
	}

	

}
