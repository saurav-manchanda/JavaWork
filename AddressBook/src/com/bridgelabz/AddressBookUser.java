
package com.bridgelabz;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.parser.ParseException;

import com.bridgelabz.services.AddressBookManagerImplementation;
import com.bridgelabz.utility.AddressUtility;

/**
 * @author bridgelabz
 *
 */
public class AddressBookUser {

	/**
	 * @param args
	 * @throws PropertyVetoException 
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * @throws InterruptedException 
	 * @throws ParseException 
	 * @throws SecurityException 
	 */
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException, SQLException, PropertyVetoException, SecurityException, ParseException, InterruptedException {
		// TODO Auto-generated method stub
		String serialiseType = args[0];
		AddressBookManagerImplementation addressBookManagerImpl = new AddressBookManagerImplementation();
		System.out.println("WELCOME TO ADDRESS BOOK APPLICATION...!!! ");
		boolean keepOn=true;
		while(keepOn) {
		System.out.println("Enter your choice");

		System.out.println("(1)- CREATE A NEW ADDRESSBOOK");
		System.out.println("(2)- VIEW A PARTICULAR ADDRESSBOOK");
		System.out.println("(3)- OPEN EXISTING ADDRESSBOOK");
		System.out.println("(4)- VIEW ADDRESSBOOK LIST");
		System.out.println("(5)- DELETE ADDRESSBOOK");
		System.out.println("(6)- QUIT ADDRESSBOOK");

		int choice = AddressUtility.userInputInteger();
		switch (choice) {

		case 1:
            System.out.println("Enter addressbook name you want to create");
            String addressBookName=AddressUtility.userInputString();
			addressBookManagerImpl.createAddressBook(serialiseType,addressBookName);
			System.out.println("Now you may add persons on your new address book..!!!");
			System.out.println("(1)- ADD A PERSON TO ADDRESSBOOK");
			System.out.println("(2)- QUIT ADDRESSBOOK");
			int choice1 = AddressUtility.userInputInteger();
			switch (choice1) {
			case 1:
			
				addressBookManagerImpl.addPerson(serialiseType,addressBookName);
				break;

			default:
				System.out.println("Exiting address book..!! ThankYou");
			}

			break;

		case 2:
			addressBookManagerImpl.openExistingAdBook(serialiseType);
			break;

		case 3:
			System.out.println("Enter the name of address book you want to open ");
			String addressBookName1 = AddressUtility.userInputString();

			System.out.println("You may perform following operations on existing address book ");
			System.out.println("(1)- ADD A PERSON TO ADDRESSBOOK");
			System.out.println("(2)- DELETE A PERSON FROM ADDRESSBOOK");
			System.out.println("(3)- EDIT A PERSON IN ADDRESSBOOK");
			System.out.println("(4)- QUIT ADDRESSBOOK");

			int choice2 = AddressUtility.userInputInteger();
			switch (choice2) {

			case 1:
				addressBookManagerImpl.addPerson(serialiseType,addressBookName1);
				break;

			case 2:
				addressBookManagerImpl.removePerson(serialiseType,addressBookName1);
				break;

			case 3:
				addressBookManagerImpl.updatePerson(serialiseType,addressBookName1);
				break;

			default:
				System.out.println("Exiting address book..!! ThankYou");

			}
			break;

		case 4:

			break;

		case 5:
			addressBookManagerImpl.deleteAddressBook(serialiseType);
			break;
		default:keepOn=false;
		System.out.println("Exiting addressbook!! ThankYou!!");
		}
		
		}
	}

}
