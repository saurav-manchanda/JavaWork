package com.bridgelabz.simpleaddressbook;

import java.io.IOException;

import com.bridgeLabz.Utility.Utility;
import com.bridgelabz.simpleaddressbook.AddressBookFactory;;
public class FileMenu {

	static Utility obj = new Utility();
	
	static AddressBookSerializer addressBookSerializerObject=null;
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
		
		System.out.println("        _______________________________________           ");
		System.out.println("        Welcome to the Address Book Application           ");
		System.out.println("        _______________________________________           ");
		System.out.println();
		FileMenu.read();
		boolean status = true;
		while (status == true) {
			System.out.println(" _________________________");
			System.out.println(" Address Book Manager Menu");
			System.out.println(" _________________________\n");
			System.out.println(" Select the option : ");
			System.out.println(" Enter 1 to create new Address Book : ");
			System.out.println(" Enter 2 to open Existing Address book : ");
			System.out.println(" Enter 3 to save Address Book : ");
			System.out.println(" Enter 0 to quit Address Book : ");
			int option=Utility.getInt();
			switch (option) {
			case 1:
				FileMenu.newAddressBook();
				break;
			case 2:
				FileMenu.open();
				break;
				
			case 3:
				FileMenu.save();
				break;
			case 0:
				FileMenu.quit();
				break;
			default:
				System.out.println(" Entered option is Wrong ");
			}
	}
	}
/****************************************************************************************************/
	static void newAddressBook() {
		AddressBookManager.createNewAddressBook();
	}
/****************************************************************************************************/
	static void open() {
		AddressBookManager.openExistingAddressBook();
	}
/*****************************************************************************************************/
	static void save() {
		System.out.println("Saving Address Book");
		addressBookSerializerObject.save();
	}
/*****************************************************************************************************/
	static void quit() {
		AddressBookManager.quitAddressBook();
	}
/**
 * @throws IOException 
 * @throws IllegalAccessException 
 * @throws InstantiationException 
 * @throws ClassNotFoundException ***************************************************************************************************/
	static void read() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
		System.out.println("Enter 1 to read Address Book from Json");
		System.out.println("Enter 2 to read Address Book from Jdbc");
		int choice=Utility.getInt();
		if(choice==1)
			addressBookSerializerObject=AddressBookFactory.objectManager("json");
		else
			addressBookSerializerObject=AddressBookFactory.objectManager("jdbc");
		
		addressBookSerializerObject.read();
	}
}
