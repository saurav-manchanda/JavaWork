/********************************************************************************* *
 * Purpose: Reads   in   strings   from   standard   input   and   prints   them   in   sorted   orderby using
 	insertion   sort. 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 21/05/2018
 *********************************************************************************/
package com.bridgelabz.alogoritm;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to implement insertion sort
 */
public class InsetionSort {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter the size of an array");
		int size=utility.inputInt();
		String[] array= new String[size];
		System.out.println("Enter the string elements");
		for(int i=0;i<size;i++)
		{
			array[i]=utility.inputString();
		}
		String[] sortedArray= utility.insertionSortString(array);
		System.out.println("The sorted array is:");
		for(String x:sortedArray)
			System.out.println(x);
	}
}
