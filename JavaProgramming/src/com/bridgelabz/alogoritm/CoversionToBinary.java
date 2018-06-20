/********************************************************************************* *
 * Purpose: Program that outputs   the   binary   (base   2)   representation   of  
the   decimal   number   typed   as   the   input.   It   is   based   on   decomposing   the   number   into  
a   sum   of   powers   of   2.   

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 22/05/2018
 *********************************************************************************/
package com.bridgelabz.alogoritm;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to convert decimal to binary
 */
public class CoversionToBinary {
	public static void main(String args[])
	{
		Utility utility = new Utility();
		System.out.println("Enter the number:");
		int number = utility.inputInt();
		String string=Utility.convertToBinary(number);
		System.out.println("Binary form is: "+string);
	}
}
