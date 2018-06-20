package com.bridgelabz.structuraldesignpattern.ProxyPattern;

import java.util.Scanner;

public class ProxyPatternTest {

	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.println("Please enter the username:");
		String userName=scan.next();
		System.out.println("Please enter the password:");
		String password=scan.next();
		CommandExecutor executor = new CommandExecutorProxy(userName, password);
		try {
			executor.runCommand("ls -ltr");
			executor.runCommand("rm -rf abc.pdf");
		} catch (Exception e) {
			System.out.println("Exception Message::"+e.getMessage());
		}
	}
}
