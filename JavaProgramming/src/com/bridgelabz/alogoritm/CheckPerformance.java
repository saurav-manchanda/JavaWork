/********************************************************************************* *
 * Purpose:To Check   using   Stopwatch   the   Elapsed   Time   for   every   method   call

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 17/05/2018
 *********************************************************************************/
package com.bridgelabz.alogoritm;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to Check   using   Stopwatch   the   Elapsed   Time   for   every   method   call
 */
public class CheckPerformance {
	static double start=0;
	static double end=0;
	static double elapsetime=0;
	static Utility utility= new Utility();
	public static void testPerformanceBinarySearch(int[] arrayInteger) {
		System.out.println("Enter the element to be searched in integer array:");
		int element=utility.inputInt();
		start=System.currentTimeMillis();
		System.out.println("The start time is"+start);
		Utility.binarySearchIntegers(arrayInteger, element);
		end=System.currentTimeMillis();
		System.out.println("The end time is:"+end);
		elapsetime=(end-start);
		System.out.println("the elapse time of binary search of integers is :"+elapsetime);
	}
	public static void testPerformanceBinarySearchString(String[] arrayString) {
		System.out.println("Enter the element to be searched in string array:");
		String elementString=utility.inputString();
		start=System.currentTimeMillis();
		System.out.println("The start time is"+start);
		Utility.binarySearch1(arrayString, elementString);
		end=System.currentTimeMillis();
		System.out.println("The end time is:"+end);
		elapsetime=(end-start);
		System.out.println("the elapse time of binary search of strings is :"+elapsetime);
	}
	public static void checkPerformanceBubbleSortIntegers(int[] arrayInteger) {
		start=System.currentTimeMillis();
		System.out.println("The start time is"+start);
		utility.bubbleSortIntegers(arrayInteger);
		end=System.currentTimeMillis();
		System.out.println("The end time is:"+end);
		elapsetime=(end-start);
		System.out.println("the elapse time of bubble sort of integers is :"+elapsetime);
	}
	public static void checkPerformanceBubbleSortString(String[] arrayString) {
		start=System.currentTimeMillis();
		System.out.println("The start time is"+start);
		utility.bubbleSortString(arrayString);
		end=System.currentTimeMillis();
		System.out.println("The end time is:"+end);
		elapsetime=(end-start);
		System.out.println("the elapse time of bubble sort of strings is :"+elapsetime);
	}
	public static void checkPerformanceInsertionSortIntegers(int[] arrayInteger)
	{
		start=System.currentTimeMillis();
		System.out.println("The start time is"+start);
		utility.insertionSortInteger(arrayInteger);
		end=System.currentTimeMillis();
		System.out.println("The end time is:"+end);
		elapsetime=(end-start);
		System.out.println("the elapse time of insertion sort of integers is :"+elapsetime);
	}
	public static void checkPerformanceInsertionSortString(String[] arrayString)
	{
		start=System.currentTimeMillis();
		System.out.println("The start time is"+start);
		utility.insertionSortString(arrayString);
		end=System.currentTimeMillis();
		System.out.println("The end time is:"+end);
		elapsetime=(end-start);
		System.out.println("the elapse time of insertion sort of strings is :"+elapsetime);
	}
	public static void main(String[] args) {
		Utility utility= new Utility();
		System.out.println("Enter the size of string array:");
		int sizeOfStringArray=utility.inputInt();
		String[] arrayString=new String[sizeOfStringArray];
		System.out.println("Enter the String elements:");
		for(int i=0;i<arrayString.length;i++)
		{
			arrayString[i]=utility.inputString();
		}
		System.out.println("Enter the size of Integer array:");
		int sizeOfIntegerArray=utility.inputInt();
		int[] arrayInteger=new int[sizeOfIntegerArray];
		System.out.println("Enter the Integer elements:");
		for(int i=0;i<arrayString.length;i++)
		{
			arrayInteger[i]=utility.inputInt();
		}
		CheckPerformance.testPerformanceBinarySearch(arrayInteger);
		CheckPerformance.testPerformanceBinarySearchString(arrayString);
		CheckPerformance.checkPerformanceBubbleSortIntegers(arrayInteger);
		CheckPerformance.checkPerformanceBubbleSortString(arrayString);
		CheckPerformance.checkPerformanceInsertionSortIntegers(arrayInteger);
		CheckPerformance.checkPerformanceInsertionSortString(arrayString);	
	}

}
