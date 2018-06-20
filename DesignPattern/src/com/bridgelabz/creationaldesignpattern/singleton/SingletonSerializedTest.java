package com.bridgelabz.creationaldesignpattern.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SingletonSerializedTest implements Serializable {

	private SingletonSerializedTest() {
	}

	private static class SingletonHelper {
		private static final SingletonSerializedTest instance = new SingletonSerializedTest();
	}

	public static SingletonSerializedTest getInstance() {
		return SingletonHelper.instance;
	}
	protected Object readResolve() {
	    return getInstance();
	}
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		SingletonSerializedTest instanceOne = SingletonSerializedTest.getInstance();
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("/home/bridgelabz/saurav/DesignPattern/src/com/bridgelabz/creationaldesignpattern/singleton/SerializedSingleton"));
		out.writeObject(instanceOne);
		out.close();

		ObjectInput in = new ObjectInputStream(new FileInputStream("/home/bridgelabz/saurav/DesignPattern/src/com/bridgelabz/creationaldesignpattern/singleton/SerializedSingleton"));
		SingletonSerializedTest instanceTwo = (SingletonSerializedTest) in.readObject();
		in.close();

		System.out.println("instanceOne hashCode=" + instanceOne.hashCode());
		System.out.println("instanceTwo hashCode=" + instanceTwo.hashCode());
		//Different hashcodes of instance1 and instance 2 therefore destroys the singleton pattern. But after adding 
		//readResolve() this problem is resolved
		
	}
}
