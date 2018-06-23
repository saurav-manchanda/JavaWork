package com.bridgelabz;

import java.util.Scanner;

public class Utility {
	/**
	 * Function for Inputing a String
	 * 
	 * @return a string
	 */
	public static String inputString() {

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
	public static int inputInt() {
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
	public static double inputDouble() {
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
	public static boolean inputBoolean() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		boolean bool = scan.nextBoolean();
		return bool;
	}
}
