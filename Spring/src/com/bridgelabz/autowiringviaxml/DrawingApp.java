package com.bridgelabz.autowiringviaxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class DrawingApp {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("autowiringbyname.xml");
		Triangle triangle=(Triangle) context.getBean("triangle");
		triangle.draw();
	}

}
