/********************************************************************************* *
 * Purpose: Program   to   find   the   prime   numbers   that   are   Anagram  

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 19/05/2018
 *********************************************************************************/
package com.bridgelabz.alogoritm;
import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to define prime numbers that are anagram
 */
public class PrimeAnnagram {

	public static void main(String[] args) {
		Utility utility= new Utility();
		System.out.println("The range is between 0 to 1000");
		
		int count=0;
		
		for(int i=0;i<=1000;i++)
		{
			if(utility.isPrimeNumber(i)==true)
				count++;
		}
		String arr[]=new String[count];
		int index = 0;
		for(int i=0;i<=1000;i++) {
			if(utility.isPrimeNumber(i))
				arr[index++] = i+"";
		} 
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(utility.isAnnagram(arr[i],arr[j]))
					System.out.println("[" + arr[i] + "," + arr[j] + "]");
			}
		}
	}
}
