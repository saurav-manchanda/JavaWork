package com.bridgelabz.innerbeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DrawingApp {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("innerbeans.xml");
		Triangle triangle=(Triangle) context.getBean("triangle");
		triangle.draw();
	}

}
