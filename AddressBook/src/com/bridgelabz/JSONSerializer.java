/**
 * 
 */
package com.bridgelabz;

import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.parser.ParseException;

import com.bridgelabz.models.Person;
import com.bridgelabz.services.AddressBookImplementation;
import com.bridgelabz.utility.AddressUtility;

/**
 * @author bridgelabz
 *
 */
public class JSONSerializer implements Serialiser {
	static ObjectMapper mapper=new ObjectMapper();
	AddressBookImplementation addressBook = new AddressBookImplementation();
	AddressUtility addressUtility= new AddressUtility();
	public ArrayList<Person> personList = new ArrayList<Person>();
	public ArrayList<String> addressBookList = new ArrayList<String>();
	static String template = "/home/bridgelabz/Javaprograms/AddressBook/src/com/bridgelabz/";
	static String bookList="/home/bridgelabz/Javaprograms/AddressBook/src/com/bridgelabz/addressbooklist.json";
	static Serialiser serialiser;


	
	public void createBook(String addressBookName) throws  IOException {

		 addressBookList = mapper.readValue(new File(bookList), new TypeReference<ArrayList<String>>() {});
			//Creating empty addressBook
			 File file = new File(template + addressBookName + ".json");
			 addressBookList.add(file.toString());
			 mapper.writeValue(file,personList);
			//Adding new address book to the addressBookList
			 mapper.writeValue((new File(bookList)),addressBookList);
		}


	public void addPerson(Person person,String addressbookName) throws IOException, ParseException {
		File fileAdd = findAddressBook(addressbookName);
		if(fileAdd!=null) {
		personList = AddressUtility.parseJSONArray(fileAdd, Person.class);
		personList.add(person);
		System.out.println("Do you want to save??(Y/N)");
		if (AddressUtility.userInputString().equals("Y")) {
			 mapper.writeValue(fileAdd,personList);
			System.out.println("Added Successfully...!!!");
		}else {
			System.out.println("Changes not saved !!! ThankYou ");
			}
		}
	}




	@Override
	public void deletePerson(String addressBookName) throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		 viewAddressbook(addressBookName);
		File file = findAddressBook(addressBookName);
		if(file!=null) {

		System.out.println("Enter the index position of the person you want to delete ");
		int index = AddressUtility.userInputInteger();
		
		 personList = AddressUtility.parseJSONArray(file,Person.class);
			personList.remove(personList.get(index));
			

			System.out.println("Do you want to save??(Y/N)");
			String result = AddressUtility.userInputString();
			if (result.equals("Y")) {
				mapper.writeValue((file),personList);
				System.out.println("Successfully deleted!!! ");
				viewAddressbook(addressBookName);
			}
			else {
			System.out.println("Changes not saved !!! ThankYou ");
			}
		}
	}



	@Override
	public void deleteAddressBook() throws SQLException, IOException, PropertyVetoException {
		System.out.println("Enter addressbook you want to delete");
		String addressBook=AddressUtility.userInputString();
		addressBookList= mapper.readValue(new File(bookList), new TypeReference<ArrayList<String>>() {});
		int index = addressBookList.indexOf(template + addressBook + ".json");
		addressBookList.remove(index);
		System.out.println("Are you sure you want to delete??(Y/N)");
		String result = AddressUtility.userInputString();
		if (result.equals("Y")) {
			mapper.writeValue(new File(bookList),addressBookList);
			System.out.println("Deleted Successfully...!!!");
		}else {
			System.out.println("Changes not saved !!! ThankYou ");
			}
		}

	/**
	 * Method to FIND ADDRESS BOOK from the address book list
	 * 
	 * @param addressBookName
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public File findAddressBook(String addressBookName) throws FileNotFoundException, IOException, ParseException {

		// parse to select multiple address books
		addressBookList = mapper.readValue(new File(bookList), new TypeReference<ArrayList<String>>() {});
		if(addressBookList.contains(template + addressBookName + ".json")) {
			int index = addressBookList.indexOf(template + addressBookName + ".json");
			return new File(addressBookList.get(index));
		}
		System.out.println("Sorry!!! The address book you are looking for doesn't exist..");
		return null;
		}


	public void viewAddressbook(String addressBookName) throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		File fileOpen = findAddressBook(addressBookName);
		if(fileOpen!=null) {
		System.out.println("The address book details are shown below: ");
		personList=AddressUtility.parseJSONArray(fileOpen,Person.class);
		for(int i=0 ;i<personList.size();i++) {
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString((personList.get(i))));
		}
			
	}

	}

	@Override
	public void updatePerson(String addressBookName,String[] inputs) throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		File file = findAddressBook(addressBookName);
		personList = AddressUtility.parseJSONArray(file, Person.class);
		for(int i=0 ;i < personList.size();i++) {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString((personList.get(i))));
		}
		
		System.out.println("Enter the index position of the person you want to edit ");
		int index = AddressUtility.userInputInteger();
		String firstName = personList.get(index).getFirstName();
		String lastName =  personList.get(index).getLastName();
		personList.remove(personList.get(index));
		Person person=new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setAddress(inputs[0]);
		person.setCity(inputs[1]);
		person.setState(inputs[2]);
		person.setZip(inputs[3]);
		person.setPhone(inputs[4]);
		
		personList.add(index,person);

		System.out.println("Do you want to save??(Y/N)");
		String result = AddressUtility.userInputString();
		if (result.equals("Y")) {
			mapper.writeValue(file,personList);
			System.out.println("Updated Successfully...!!!");
		}else {
			System.out.println("Changes not saved !!! ThankYou ");
			}
		
	}


	/* (non-Javadoc)
	 * @see com.bridgelabz.repositories.Serialiser#getConnection()
	 */
	@Override
	public Connection getConnection() throws SQLException, IOException, PropertyVetoException {
		// TODO Auto-generated method stub
		return null;
	}



	}



