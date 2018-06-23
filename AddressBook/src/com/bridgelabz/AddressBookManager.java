package com.bridgelabz;

public class AddressBookManager {

	public static void askOptionFromUser() {
		System.out.println("Please enter the existing addressbook filePath you want to access:");
		String filePath = Utility.inputString();
		System.out.println("Select an action..");
		System.out.println();
		System.out.println("1. Add a person");
		System.out.println("2. Edit a person record");
		System.out.println("3. Delete a person record");
		System.out.println("4. Search a person");
		System.out.println("5. Print the whole Address Book");
		System.out.println("6. Sort by Last Name");
		System.out.println("7. Sort by Zip Code");
		System.out.println("8. Quit");
		int choice = Utility.inputInt();
		switch (choice) {
		case 1:
			AddressBook.addAPerson(filePath);
			askOptionFromUser();
			break;
		case 2:
			AddressBook.editAPerson(filePath);
			askOptionFromUser();
			break;
		case 3:
			delete(filePath);
			addressBook.askOptionFromUser(addressBook,filePath);
			break;
		case 4:
			search(jsonArray,filePath);
			addressBook.askOptionFromUser(addressBook,filePath);
			break;
		case 5:
			printAddressBook(jsonArray,filePath);
			addressBook.askOptionFromUser(addressBook,filePath);
			break;
		case 6:
			sortByLastName(jsonArray,filePath);
			addressBook.askOptionFromUser(addressBook,filePath);
			break;
		case 7:
			sortByZipCode(jsonArray,filePath);
			addressBook.askOptionFromUser(addressBook,filePath);
			break;
default:
	}

}
