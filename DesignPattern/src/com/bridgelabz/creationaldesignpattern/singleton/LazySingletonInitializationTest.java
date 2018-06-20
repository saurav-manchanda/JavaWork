package com.bridgelabz.creationaldesignpattern.singleton;

public class LazySingletonInitializationTest {

private static LazySingletonInitializationTest instance;
    
    private LazySingletonInitializationTest() {
		// TODO Auto-generated constructor stub
	}
    
    public static LazySingletonInitializationTest getInstance(){
        if(instance == null){
            instance = new LazySingletonInitializationTest();
        }
        return instance;
    }
	public static void main(String[] args) {
		LazySingletonInitializationTest instance1=new LazySingletonInitializationTest();
		System.out.println(instance1.getInstance());
		System.out.println(instance1.getInstance().hashCode());
		LazySingletonInitializationTest instance2=new LazySingletonInitializationTest();
		System.out.println(instance2.getInstance());
		System.out.println(instance2.getInstance().hashCode());
		//The hashcodes of both the instance are same.. Therefore implying singleton class

	}

}
