/*********************************************************************************
 * 
 * Purpose: taking two integer command­line arguments x
and y and prints the Euclidean distance from the point (x, y) to the origin (0, 0).

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 17/05/2018
 *********************************************************************************/
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to find the Euclidean distance
 */
public class Distance {
	static double DISTANCE;
	public static void main(String[] args) {
		Utility utility= new Utility();//creating the reference
		int x= Integer.parseInt(args[0]);//parsing the command line arguments
		int y= Integer.parseInt(args[1]);//parsing the command line arguments
		DISTANCE=utility.distance(x,y);//calling the method of Utility
		System.out.println("The Euclidean distance from the point("+x+","+ y+ ") to the origin (0, 0)"+ DISTANCE);
		

	}

}
