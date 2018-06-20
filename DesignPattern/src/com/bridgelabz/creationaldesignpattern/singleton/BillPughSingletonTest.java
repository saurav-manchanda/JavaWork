package com.bridgelabz.creationaldesignpattern.singleton;

public class BillPughSingletonTest {

private BillPughSingletonTest(){}
    
    private static class SingletonHelper{
        private static final BillPughSingletonTest INSTANCE = new BillPughSingletonTest();
    }
    
    public static BillPughSingletonTest getInstance(){
        return SingletonHelper.INSTANCE;
    }
	public static void main(String[] args) {
		BillPughSingletonTest instance1=new BillPughSingletonTest();
		System.out.println(instance1.getInstance());
		System.out.println(instance1.getInstance().hashCode());
		BillPughSingletonTest instance2=new BillPughSingletonTest();
		System.out.println(instance2.getInstance());
		System.out.println(instance2.getInstance().hashCode());
		//The hashcodes of both the instance are same.. Therefore implying singleton class

	}

}
