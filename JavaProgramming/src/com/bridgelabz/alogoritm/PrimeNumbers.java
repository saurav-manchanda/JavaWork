/********************************************************************************* *
 * Purpose: To print Prime Numbers between 0-1000

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 19/05/2018
 *********************************************************************************/
package com.bridgelabz.alogoritm;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to print Prime numbers
 */
public class PrimeNumbers {

	public static void main(String[] args) {
		Utility utility= new Utility();
		boolean flag=false;
		System.out.println("The prime numbers between 0-1000 are:");
		for(int i=0;i<=1000;i++)
		{
			flag=utility.isPrimeNumber(i);
			if(flag==true)
				System.out.println(i);
		}
	}

}
