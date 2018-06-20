/*********************************************************************************
 * Purpose: to   find   the   roots   of   the   equation   a*x*x   +   b*x   +   c.  
Since   the   equation   is   x*x,   hence   there   are   2   roots.   The   2   roots   of   the   equation  
can   be   found   using   a   formula  
delta   =   b*b   ­   4*a*c 
Root   1   of   x   =   (­b   +   sqrt(delta))/(2*a) 
Root   2   of   x   =   (­b   ­   sqrt(delta))/(2*a) 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 17/05/2018
 *********************************************************************************/
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to find the roots of quadtratic equation
 */
public class Quadratic {
static int A,B,C;
static double X1,X2;
	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.print("a ="); // reading value of a
		A = utility.inputInt();
		System.out.print("b ="); // reading value of b
		B = utility.inputInt();  
		System.out.print("c ="); // reading value of c
		C = utility.inputInt();
		
		int delta = (B*B)-(4*A*C); 
		
		if(delta>0)
		{
			X1 = (-B + (Math.sqrt(delta)))/(2*A); // calculating root 1
			X2 = (-B - (Math.sqrt(delta)))/(2*A); // calculating root 2
			System.out.println("Roots of X ("+X1+","+X2+")");
		}
		else 
		{
			System.out.println("roots are imaginary");
		} 

	}

}
