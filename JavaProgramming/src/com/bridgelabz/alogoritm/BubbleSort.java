/********************************************************************************* *
 * Purpose: Reads   in   integers   prints   them   in   sorted   order   using   Bubble   Sort 

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 19/05/2018
 *********************************************************************************/
package com.bridgelabz.alogoritm;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to perform bubble sort in an integer array
 */
public class BubbleSort {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter the size of an array");
		int size=utility.inputInt();
		int[] array= new int[size];
		System.out.println("Enter the elements:");
		for(int i=0;i<size;i++)
		{
			array[i]=utility.inputInt();
		}
		int[] sortedArray= utility.bubbleSortIntegers(array);
		System.out.println("The sorted array is:");
		for(int x:sortedArray)
			System.out.println(x);
	}

}
