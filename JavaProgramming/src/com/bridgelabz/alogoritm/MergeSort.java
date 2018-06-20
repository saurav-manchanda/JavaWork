/********************************************************************************* *
 * Purpose: Program   with   Static   Functions   to   do   Merge   Sort   of   list   of 
Strings.   

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 21/05/2018
 *********************************************************************************/
package com.bridgelabz.alogoritm;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to perform merge sort on string array
 */
public class MergeSort {

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
		System.out.println("Array after the merge sort is:");
		MergeSort.mergeSort(array,0,array.length-1);
		for(String x: array)
			System.out.println(x);

	}
	/**
	 * Function for partitioning the array into halves and after that merging
	 * @param array
	 * @param low
	 * @param high
	 */
	public static void mergeSort(String[] array,int low,int high)  
	{  
	    int mid;  
	   
	    if(low < high)  
	    {  
	        mid = (low + high) / 2;  
	        mergeSort(array, low, mid);  
	        mergeSort(array, mid + 1, high);  
	        merge(array, low, mid, high);  
	    }  
	}  
	   /**
	    * Function to merge the arrays 
	    * @param array
	    * @param low
	    * @param mid
	    * @param high
	    */
	public static void merge(String array[],int low,int mid,int high)  
	{  
	    int i, mid1, k=0, low1;  
	    String[] temp= new String[50];
	    low1 = low;  
	    i = low;  
	    mid1 = mid + 1;  
	    while ((low1 <= mid) && (mid1 <= high))  
	    {  
	        if (array[low1].compareToIgnoreCase(array[mid1])<=0 )  
	        {  
	            temp[i] = array[low1];  
	            low1++;  
	        }  
	        else  
	        {  
	            temp[i] = array[mid1];  
	            mid1++;  
	        }  
	        i++;  
	    }  
	    if (low1 > mid)  
	    {  
	        for (k = mid1; k <= high; k++)  
	        {  
	            temp[i] = array[k];  
	            i++;  
	        }  
	    }  
	    else  
	    {  
	        for (k = low1; k <= mid; k++)  
	        {  
	             temp[i] = array[k];  
	             i++;  
	        }  
	    }  
	   
	    for (k = low; k <= high; k++)  
	    {  
	        array[k] = temp[k];  
	    } 
	}
}
