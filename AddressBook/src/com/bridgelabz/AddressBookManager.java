package com.bridgelabz.simpleaddressbook;

import java.util.LinkedList;
import com.bridgeLabz.Utility.Utility;
import com.bridgelabz.datastructure.MyLinkedList;

public class AddressBookManager {
	static Utility obj=new Utility(); 
	public static AddressBook addressBookObject;
	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	public static LinkedList<AddressBook> addressBookList = new <AddressBook>LinkedList();
	public static MyLinkedList addressBookNameList=new MyLinkedList();
/********************************************************************************************/	
	@SuppressWarnings("static-access")
	static void createNewAddressBook() {
		System.out.println("Printing address Book Name List");
		AddressBookManager.addressBookNameList.display();
		System.out.println();
		System.out.println(" Enter the name for new Address Book ");
		String addressBookName=Utility.getString();
		addressBookNameList.add(addressBookName);
		addressBookObject = new AddressBook();
		addressBookList.add(addressBookObject);
		addressBookObject.manager();
	}
	
/***********************************************************************************************/
	@SuppressWarnings("static-access")
	static void openExistingAddressBook() {
		System.out.println("Printing address Book Name List");
		AddressBookManager.addressBookNameList.display();
		System.out.println();
		System.out.println(" Enter the Existing Addrress Book Name ");
		String searcheAddressBook=Utility.getString();
		
		if(addressBookNameList.search(searcheAddressBook)==true) {
			addressBookObject=addressBookList.get(addressBookNameList.index(searcheAddressBook)-1);
			addressBookObject.manager();
		}
	}
/*********************************************************************************************/
	static void quitAddressBook() {
		System.out.println("************ Thank You for Visiting.. Come Again..!  *************");
		System.exit(0);
	}

}
