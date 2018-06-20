package com.bridgelabz.creationaldesignpattern.singleton;

public class SerializedSingletonClass {
	private SerializedSingletonClass()
	{	
	}
	private static class SingletonHelper{
		private static SerializedSingletonClass instance=new SerializedSingletonClass();
	}
	public static SerializedSingletonClass getInstance(){
		return SingletonHelper.instance;
	}
}