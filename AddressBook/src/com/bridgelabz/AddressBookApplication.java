package com.bridgelabz;

public class AddressBookApplication {
	public static void main(String[] args) {
		askUser();
	}

	public static void askUser() {
		Utility utility=new Utility();
		
		System.out.println("Please Enter a choice:\n");
		System.out.println("1.ACCESS EXISTING ADDRESSBOOK ACTIONS");
		System.out.println("2.CREATE NEW ADDRESSBOOK");
		System.out.println("3.QUIT");
		int choice = utility.inputInt();
		switch (choice) {
		case 1:
			System.out.println("Please enter the existing addressbook filePath you want to access:");
			String filePath = utility.inputString();
			AddressBookManager.askOptionFromUser();
			break;
		case 2:
			AddressBookApplication aba = new AddressBookApplication();
			aba.doNew();
			break;
		default:
			break;
		}
}
		
	}
}
