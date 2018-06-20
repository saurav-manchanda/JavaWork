/********************************************************************************* *
 * Purpose: Take   an   Arithmetic   Expression   such   as 
(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3)   where   parentheses   are   used   to   order   the 
performance   of   operations.   Ensure   parentheses   must   appear   in   a   balanced 
fashion. 
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 25/05/2018
 *********************************************************************************/
package com.bridgelabz.datastructures;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to ensure the arithmetic expression is balanced
 */
public class BalancedParanthesis {
	static String str;
	public static void main(String[] args) 
		{
			Utility utility = new Utility(); 
			boolean result=false;
			System.out.println("Enter arithmatic expression");
			str = utility.inputString(); 
			if(str.length()==0) 
			{
				System.out.println("Plz.. Enter the expression.");
			}
			else
			{	
				result = Utility.checkValidExpression(str);
				if(result == true) 
				{
					System.out.println("True!! It is valid expression.");
				}
				else
				{
					System.out.println("False!! it is not valid expression");
				
				}
			}
		}
}
