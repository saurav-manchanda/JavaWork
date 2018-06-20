package com.bridgelabz.creationaldesignpattern.singleton;

import java.lang.reflect.Constructor;

public class Reflection {

	public static void main(String[] args) {
		EagerInitialization instance1=EagerInitialization.getInstance();
		EagerInitialization instance2=EagerInitialization.getInstance();
		
        try {
            Constructor[] constructors = EagerInitialization.class.getDeclaredConstructors();
            for (Constructor a : constructors) {
                a.setAccessible(true);
                instance2 = (EagerInitialization) a.newInstance();
                break;
            }
        } catch (Exception e) {
            
        }
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
        //HashCodes of instance1 and inctance2 are different..Therefore Reflection breaks the singleton Pattern
    }
}
