package com.bridgelabz.creationaldesignpattern.singleton;

public enum EnumSingleton {
     INSTANCE,INSTANCE1;
	public static void display() {
		System.out.println(INSTANCE.hashCode());
		System.out.println(INSTANCE1.hashCode());
	}
	public static void main(String[] args) {
		display();
		display();
		//INSTANCE is only one and INSTANCE! is only one.. Clearly enum returns only one Hashcode of single instance.
	}
}
