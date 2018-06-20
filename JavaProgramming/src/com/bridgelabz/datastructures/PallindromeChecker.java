/********************************************************************************* *
 * Purpose:  A   palindrome   is   a   string   that   reads   the   same   forward   and   backward,   for 
example,   radar,   toot,   and   madam.   We   would   like   to   construct   an   algorithm   to 
input   a   string   of   characters   and   check   whether   it   is   a   palindrome

 * @author Saurav Manchanda
 * @version 1.0
 * @since 17/05/2018
 *********************************************************************************/
package com.bridgelabz.datastructures;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to check Pallindrome or not.
 */
public class PallindromeChecker {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter the string you want to check:");
		String string = utility.inputString();
		LinkedDequeue<Character> dequeue=new LinkedDequeue<Character>();
		boolean result=utility.pallindromeChecker(dequeue,string);
		if (result==true)
				{
					System.out.println("pallindrome!!");
				}
		else
			System.out.println("Not pallindrome");
		

	}

}
