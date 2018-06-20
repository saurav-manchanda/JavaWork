package com.bridgelabz.creationaldesignpattern.singleton;

public class EagerInitialization {
private static final EagerInitialization instance = new EagerInitialization();
    
    
    private EagerInitialization(){}

    public static EagerInitialization getInstance(){
        return instance;
    }
    public static void main(String[] args) {
		EagerInitialization instance1=new EagerInitialization();
		System.out.println(instance1.getInstance());
		System.out.println(instance1.getInstance().hashCode());
		EagerInitialization instance2=new EagerInitialization();
		System.out.println(instance2.getInstance());
		System.out.println(instance2.getInstance().hashCode());
		//The hashcodes of both the instance are same.. Therefore implying singleton class
	}
}
