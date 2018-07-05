/********************************************************************************* *
 * Purpose: To make Cklass Point having coordinates x and y  
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 5/07/2018
 *********************************************************************************/
package com.bridgelabz.annotations.AutowiredAnnotation;

/**
 * @author Saurav:
 * Class Point having fields as x and y coordinate
 */
public class Point {
	private int x;
	private int y;
	/**
	 * Method to get the value of x coordinate
	 * @return
	 */
	public int getX() {
		return x;
	}
	/**
	 * Method to set the values of x coordinate
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * Method to get the values of y coordinate
	 * @return
	 */
	public int getY() {
		return y;
	}
	/**
	 * Method to set the coordinates of y coordinate
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
}
