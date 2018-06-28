package com.bridgelabz.beanfactoryexample;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class DrawingApp {

	public static void main(String[] args) {
		BeanFactory factory=new XmlBeanFactory(new ClassPathResource("spring.xml"));
		Triangle triangle=(Triangle) factory.getBean("triangle");
		triangle.draw();
	}

}
