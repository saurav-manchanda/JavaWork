/********************************************************************************* *
 * Purpose: Utility class which contains all logics 
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 17/05/2018
 *********************************************************************************/
package com.bridgelabz;

import java.util.Scanner;



/**
 * @author Saurav: Class to define all logics via methods
 */
public class Utility {
	

	/**
	 * Function for String Replace
	 * 
	 * @param string
	 *            string which needs to be replaced
	 * @return a replaced string
	 */
	public static String stringReplace(String string) {
		String tempString = "Hello username, How are you?";
		tempString = tempString.replaceAll("username", string);
		return tempString;
	}

	/**
	 * Function for Inputing a String
	 * 
	 * @return a string
	 */
	public String inputString() {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String string = scan.nextLine();
		return string;

	}

	/**
	 * Function for Inputing an Integer
	 * 
	 * @return an integer
	 */
	public int inputInt() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int integer = scan.nextInt();
		return integer;

	}

	/**
	 * Function for Inputing an double
	 * 
	 * @return a double
	 */
	public double inputDouble() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		double doub = scan.nextDouble();
		return doub;

	}

	/**
	 * Function for Inputing a boolean
	 * 
	 * @return a boolean
	 */
	public boolean inputBoolean() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		boolean bool = scan.nextBoolean();
		return bool;
	}
}