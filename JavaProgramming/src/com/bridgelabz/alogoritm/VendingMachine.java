/********************************************************************************* *
 * Purpose: There   is   1,   2,   5,   10,   50,   100,   500   and   1000   Rs   Notes   which   can   be 
returned   by   Vending   Machine.   Write   a   Program   to   calculate   the   minimum   number 
of   Notes   as   well   as   the   Notes   to   be   returned   by   the   Vending   Machine   as   a 
Change  
 * @author Saurav Manchanda
 * @version 1.0
 * @since 22/05/2018
 *********************************************************************************/
package com.bridgelabz.alogoritm;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to implement the Vending Machine
 */
public class VendingMachine {
	public static void main(String[] args) 
	{	
		Utility utility = new Utility();
		int notes[] = {1,2,5,10,50,100,500,1000};
		System.out.println("Enter the amount:");
		int change = utility.inputInt();
		int len = notes.length;
		int count = utility.findCount(notes,change,len);
		System.out.println("Number of notes to be returns : " +count );
	}
}
