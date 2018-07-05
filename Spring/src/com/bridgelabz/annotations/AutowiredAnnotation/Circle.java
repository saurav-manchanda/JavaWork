/********************************************************************************* *
 * Purpose: To show the use of autowiring  
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 5/07/2018
 *********************************************************************************/
package com.bridgelabz.annotations.AutowiredAnnotation;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Saurav:
 * Class Circle having points. 
 */
public class Circle {
	private Point center1;
	private Point center2;

	
	/*public Circle(Point center1, Point center2) {
		super();
		this.center1 = center1;
		this.center2 = center2;
	}*/
	public Point getCenter1() {
		return center1;
	}
	/**
	 * to set the values of center1
	 * @param center
	 */
	@Autowired
	public void setCenter1(Point center) {
		this.center1 = center;
	}
	/**
	 * to get the values of center2
	 * @return
	 */
	public Point getCenter2() {
		return center2;
	}
	/**
	 * To set the value of center 2
	 * @param center2
	 */
	@Autowired
	public void setCenter2(Point center2) {
		this.center2 = center2;
	}
	/**
	 * To print the corresponding points
	 */
	public void draw() {
		System.out.println("Center1 is: ("+ getCenter1().getX()+ ","+getCenter1().getY()+")");
		System.out.println("Center2 is: ("+ getCenter2().getX()+ ","+getCenter2().getY()+")");
	}
}
	