/********************************************************************************* *
 * Purpose: To show the use of autowiring  
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 5/07/2018
 *********************************************************************************/
package com.bridgelabz.annotations.AutowiredAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author Sauirav:
 * Class DrawingApp
 */
public class DrawingApp {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("autowireannotation.xml");
		Circle circle=(Circle) context.getBean("circle");
		circle.draw();
	}
}
