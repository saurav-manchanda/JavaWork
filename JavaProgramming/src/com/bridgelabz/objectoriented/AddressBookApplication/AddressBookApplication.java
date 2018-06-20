/********************************************************************************* *
 * Purpose: Create   Object   Oriented   Analysis   and   Design   of   a   simple   Address   Book   Problem . 

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 7/06/2018
 *********************************************************************************/
package com.bridgelabz.objectoriented.AddressBookApplication;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to manage the Address Book
 */
public class AddressBookApplication {

	public static void main(String[] args)
			throws JsonGenerationException, JsonMappingException, IOException, ParseException, InterruptedException {
		AddressBook addressBook = new AddressBook();
		Utility utility = new Utility();
		System.out.println("Please Enter a choice:");
		System.out.println();
		System.out.println("1.ACCESS EXISTING ADDRESSBOOK ACTIONS");
		System.out.println("2.CREATE NEW ADDRESSBOOK");
		System.out.println("3.QUIT");
		int choice = utility.inputInt();
		switch (choice) {
		case 1:
			System.out.println("Please enter the existing addressbook filePath you want to access:");
			String filePath = utility.inputString();
			addressBook.askOptionFromUser(addressBook, filePath);
			break;
		case 2:
			AddressBookApplication aba = new AddressBookApplication();
			aba.doNew();
			break;
		default:
			break;
		}
	}
/**
 * Method to create a new Address Book
 * @throws JsonGenerationException
 * @throws JsonMappingException
 * @throws IOException
 * @throws ParseException
 * @throws InterruptedException
 */
	public void doNew()
			throws JsonGenerationException, JsonMappingException, IOException, ParseException, InterruptedException {

		AddressBook addressBook = new AddressBook();
		String filePath = addressBook.createEmptyNewFile();
		addressBook.askOptionFromUser(addressBook, filePath);
	}

}
