package com.bridgelabz.scopeofjavabeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("scope.xml");
		Triangle triangle=(Triangle) context.getBean("triangle");
		System.out.println(triangle);
		Triangle triangle1=(Triangle) context.getBean("triangle");
		System.out.println(triangle1);
	}

}
