/********************************************************************************* *
 * Purpose: Program   to   find   the   prime   numbers   that   are  
Palindrome  

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 19/05/2018
 *********************************************************************************/
package com.bridgelabz.alogoritm;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 *	Class to Define Prime numbers those are pallindroms
 */
public class PrimePallindrome {

	public static void main(String[] args) {
		Utility utility= new Utility();
		boolean flag=false;
		boolean flag1=false;
		System.out.println("The range is between 0 to 1000");
		String temp="";
		for(int i=0;i<=1000;i++)
		{
			flag=utility.isPrimeNumber(i);
			if(flag==true)
			{
				temp=temp+i;
				flag1=utility.isPallindrome(temp);
				if(flag1==true)
				{   
					System.out.println(temp+ " is a pallindrome prime number between the range");
				}
				temp="";
			}
		}
	}
}

