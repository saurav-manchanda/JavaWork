package com.bridgelabz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		
		Test obj= new Test();
		Class cls=obj.getClass();
		
		//Getting the name of the class
		System.out.println("The name of the class is--->"+cls.getName());
		
		Constructor contructor = cls.getConstructor();
		System.out.println("The name of the constructor is --->"+contructor.getName());
		
		System.out.println("The public methods of the class are:");
		Method []methods=cls.getMethods();
		for(Method method:methods)
			System.out.println(method.getName());
		
		//create objects of desire methods
		Method methodCall1=cls.getDeclaredMethod("method2", int.class);
		methodCall1.invoke(obj, 19);
		
		Field field=cls.getDeclaredField("str");
		//allow the filed to access the filed
		field.setAccessible(true);
		
		//takes object and new value to be assigned as argument
		field.set(obj, "java");
		
		
		Method methodCall2=cls.getDeclaredMethod("method1");
		//invoke the method at run time
		methodCall2.invoke(obj);
		
		
		Method methodCall3=cls.getDeclaredMethod("method3");
		//invoke the method at run time
		methodCall3.setAccessible(true);
		methodCall3.invoke(obj);
		
		
		
	}
	
	
	
}
