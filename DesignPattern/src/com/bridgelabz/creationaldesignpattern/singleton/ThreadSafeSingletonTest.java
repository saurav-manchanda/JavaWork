package com.bridgelabz.creationaldesignpattern.singleton;

public class ThreadSafeSingletonTest {
	 private static ThreadSafeSingletonTest instance;
	    
	    private ThreadSafeSingletonTest(){}
	    
	    public static synchronized ThreadSafeSingletonTest getInstance(){
	        if(instance == null){
	            instance = new ThreadSafeSingletonTest();
	        }
	        return instance;
	    }
	public static void main(String[] args) {
		ThreadSafeSingletonTest instance1=new ThreadSafeSingletonTest();
		System.out.println(instance1.getInstance());
		System.out.println(instance1.getInstance().hashCode());
		ThreadSafeSingletonTest instance2=new ThreadSafeSingletonTest();
		System.out.println(instance2.getInstance());
		System.out.println(instance2.getInstance().hashCode());
		//The hashcodes of both the instance are same.. Therefore implying singleton class

	}

}
