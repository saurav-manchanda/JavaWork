/************************************************************************************
 * Purpose: A program with cubic running time. Read in N integers and counts the
number of triples that sum to exactly 0.
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
 * Class to find the Triplets
 */
public class Triplets {

	public static void main(String[] args) {
		Utility utility= new Utility();
		
		System.out.println("Enter the number of elements");
		int number= utility.inputInt();
		int[] arr= new int[number];
		for(int i=0;i<number;i++)
		{
			arr[i]=utility.inputInt();
		}
		utility.threeSumCount(number, arr);//calling method of Utility class
		
		

	}

}
