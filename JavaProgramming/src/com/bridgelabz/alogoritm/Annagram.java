/********************************************************************************* *
 * Purpose: To check whether the give two Strings are Annagram or not!!

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 19/05/2018
 *********************************************************************************/
package com.bridgelabz.alogoritm;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to determine whether the given strings are annagram or not.
 */
public class Annagram {

	public static void main(String[] args) {
		Utility utility= new Utility();
		System.out.println("enter the first string:");
		String string1= utility.inputString();
		System.out.println("enter the second string:");
		String string2=utility.inputString();
		boolean result=utility.isAnnagram(string1, string2);
		if(result==true)
			System.out.println("The strings are Annagram!!");
		else
			System.out.println("The strings are not Annagram!");

	}

}
