/********************************************************************************* *
 * Purpose:   program that takes   a   command­line   argument   N,   asks   you   to   think   of   a   number 
between   0   and   N­1,   where   N   =   2^n,   and   always   guesses   the   answer   with   n 
questions. 

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 19/05/2018
 *********************************************************************************/
package com.bridgelabz.alogoritm;

import com.bridgelabz.utility.Utility;
/**
 * @author Saurav:
 * Class that the   Number   N   and   then   recursively   ask   true/false   if   the   number   is   between 
a   high   and   low   value
 */
public class FindNumber {

	public static void main(String[] args) {
        System.out.println("Enter the value of N");
    	int number = Integer.parseInt(args[0]);
        System.out.println("Think of an integer between "+0+" "+((int)Math.pow(2, number)));
    	try {
			Thread.sleep(3000);
		} catch ( Exception e) {
			System.out.println("Exception occured");
		}
        Utility.search(0, (int)Math.pow(2, number));

	}

}
