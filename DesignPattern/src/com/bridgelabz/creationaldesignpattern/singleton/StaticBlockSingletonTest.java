package com.bridgelabz.creationaldesignpattern.singleton;

public class StaticBlockSingletonTest {
private static StaticBlockSingletonTest instance;
    
    private StaticBlockSingletonTest(){}
    
    //static block initialization for exception handling
    static{
        try{
            instance = new StaticBlockSingletonTest();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    
    public static StaticBlockSingletonTest getInstance(){
        return instance;
    }


	public static void main(String[] args) {
		StaticBlockSingletonTest instance1=new StaticBlockSingletonTest();
		System.out.println(instance1.getInstance());
		System.out.println(instance1.getInstance().hashCode());
		StaticBlockSingletonTest instance2=new StaticBlockSingletonTest();
		System.out.println(instance2.getInstance());
		System.out.println(instance2.getInstance().hashCode());
		//The hashcodes of both the instance are same.. Therefore implying singleton class
	}

}
