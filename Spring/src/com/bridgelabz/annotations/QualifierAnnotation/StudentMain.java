package com.bridgelabz.annotations.QualifierAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMain {

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("student.xml");
        Profile profile=(Profile) context.getBean("profile");
        profile.printName();
        profile.printAge();
    }
}


