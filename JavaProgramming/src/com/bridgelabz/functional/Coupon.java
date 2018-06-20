/*********************************************************************************
 * Purpose: Given N distinct Coupon Numbers, how many random numbers do you
need to generate distinct coupon number?
 * @author Saurav Manchanda
 * @version 1.0
 * @since 17/05/2018
 *********************************************************************************/
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

/**
 * @author saurav:
 * 
 * Class to generate distinct coupon numbers
 *
 */
public class Coupon {
	static int NUMBER_OF_COUPONS;
	public static void main(String[] args) {
		Utility utility= new Utility();// Making refernce 
		System.out.println("Enter the number of Coupons:");
		NUMBER_OF_COUPONS = utility.inputInt();
		int[] array =new int[NUMBER_OF_COUPONS];
		utility.randomDistinct(NUMBER_OF_COUPONS, array);

	}
 }
