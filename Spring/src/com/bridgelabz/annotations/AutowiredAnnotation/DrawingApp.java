package com.bridgelabz.annotations.AutowiredAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DrawingApp {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("autowireannotation.xml");
		Circle circle=(Circle) context.getBean("circle");
		circle.draw();
	}
}
