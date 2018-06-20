/*********************************************************************************
 * 
 * Purpose: Given   the   temperature   t   (in   Fahrenheit)   and   the   wind   speed   v   (in   miles   per   hour),  
the   National   Weather   Service   defines   the   effective   temperature   (the   wind   chill)

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 18/05/2018
 *********************************************************************************/
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to pemutate the string
 */
public class PermutationString {

	public static void main(String[] args) {
		Utility utility= new Utility();
		System.out.println("Enter the String:");
		String string= utility.inputString();
		int initialIndex=0;
		int lastIndex= string.length()-1;
		utility.permute(string, initialIndex, lastIndex);
	}

}
