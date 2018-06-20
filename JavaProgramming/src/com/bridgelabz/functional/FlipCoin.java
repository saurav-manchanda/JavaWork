/***********************************************************************
 * Purpose:Flip Coin and print percentage of Heads and Tails.
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 16/05/2018
 * 
 *********************************************************************** 
 */
package com.bridgelabz.functional;

/**
 * @author Saurav: Class to filp coin and print percentages of heads and tails
 */
public class FlipCoin {
	static int TAIL = 0;
	static int HEAD = 0;

	public static void main(String[] args) {
		int number = Integer.parseInt(args[0]);
		if (number < 0)
			System.out.println("Please enter a positive integer");
		else {
			for (int i = 1; i <= number; i++) {
				double flip = Math.random();
				if (flip < 0.5)
					TAIL++;
				else
					HEAD++;
			}
			/**
			 * Calculating head percentage
			 */
			double headPercentage = (HEAD * 100) / number;
			System.out.println("How many times tail comes:" + TAIL);
			System.out.println("How many times heads comes:" + HEAD);
			System.out.println("The Head percentage is:" + headPercentage + "%");
			System.out.println("The Tail percentage is:" + (100 - headPercentage) + "%");
		}

	}

}
