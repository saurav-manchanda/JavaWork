/********************************************************************************* *
 * Purpose: Create   Object   Oriented   Analysis   and   Design   of   a   simple   Address   Book   Problem . 
     Address Book implementation
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 7/06/2018
 *********************************************************************************/
package com.bridgelabz.objectoriented.AddressBookApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class Address Book has Person Objects in a JSONArray and we are manipulation the array
 */
public class AddressBook {
	JSONArray jsonArray = new JSONArray();
/**
 * Method to create a person object
 * @return
 */
	public Person makePersonObject() {
		Utility utility = new Utility();
		System.out.println("Enter the First Name:");
		String firstName = utility.inputString();
		System.out.println("Enter the Last Name:");
		String lastName = utility.inputString();
		System.out.println("Enter the Address:");
		String address = utility.inputString();
		System.out.println("Enter the city:");
		String city = utility.inputString();
		System.out.println("Enter the state:");
		String state = utility.inputString();
		System.out.println("Enter the zip code:");
		String zipCode = utility.inputString();
		System.out.println("Enter the phone number:");
		String phoneNumber = utility.inputString();
		Person person = new Person(firstName, lastName, address, city, state, zipCode, phoneNumber);
		return person;
	}
/**
 * Method to covert a person object to json object
 * @param person
 * @return
 */
	public JSONObject createJSONObject(Person person) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("First Name", person.getFirstName());
		jsonObject.put("Last Name", person.getLastName());
		jsonObject.put("Address", person.getAddress());
		jsonObject.put("City", person.getCity());
		jsonObject.put("State", person.getState());
		jsonObject.put("Zip Code", person.getZipcode());
		jsonObject.put("Phone Number", person.getPhoneNumber());
		return jsonObject;
	}
/**
 * Method to write in a json file
 * @param jsonArray
 * @throws JsonGenerationException
 * @throws JsonMappingException
 * @throws IOException
 */
	public void writeJson(JSONArray jsonArray) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(new File(
				"/home/bridgelabz/JavaWorkspace/JavaProgramming/src/com/bridgelabz/objectoriented/AddressBookApplication/AddressBook.json"),
				jsonArray);
		

	}
/**
 * Method to ask options from the user according to implementation
 * @param addressBook
 * @param filePath
 * @throws JsonGenerationException
 * @throws JsonMappingException
 * @throws IOException
 * @throws ParseException
 * @throws InterruptedException
 */
	public void askOptionFromUser(AddressBook addressBook,String filePath)
			throws JsonGenerationException, JsonMappingException, IOException, ParseException, InterruptedException {

		Utility utility = new Utility();
		System.out.println("Select an action..");
		System.out.println();
		System.out.println("1. Add a person");
		System.out.println("2. Edit");
		System.out.println("3. Delete a person record");
		System.out.println("4. Search a person");
		System.out.println("5. Print the whole Address Book");
		System.out.println("6. Sort by Last Name");
		System.out.println("7. Sort by Zip Code");
		System.out.println("8. Quit");

		int choice = utility.inputInt();
		switch (choice) {
		case 1:
			addAPerson(jsonArray, addressBook,filePath);
			addressBook.askOptionFromUser(addressBook,filePath);
			break;
		case 2:
			edit(jsonArray,filePath);
			addressBook.askOptionFromUser(addressBook,filePath);
			break;
		case 3:
			delete(jsonArray,filePath);
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
			System.out.println("please select:");
			System.out.println("1. Do you want to save?");
			System.out.println("2. Do you want to save As in a new file?");
			System.out.println("Do you want to save the changes into a file??");
			int select=utility.inputInt();
			switch (select) {
			case 1:
				break;
			case 2:
				writeNewFile(jsonArray,filePath);
				break;

			default:
				break;
			}
			
			break;
			
		}
	}
/**
 * Method to write into file
 * @param jsonArray
 * @param filePath where we want to write the json array
 * @throws JsonGenerationException
 * @throws JsonMappingException
 * @throws IOException
 */
	public void write(JSONArray jsonArray,String filePath) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(new File(filePath),jsonArray);
		
	}
/**
 * Method to write into new file
 * @param jsonArray
 * @throws IOException
 * @throws ParseException 
 */
	public void writeNewFile(JSONArray jsonArray, String filePath) throws IOException, ParseException {
		Utility utility=new Utility();
		JSONArray array=readFromFile(filePath);
		System.out.println("Enter the path of the file to create the new file and storing all the changes");
		String filePath1=utility.inputString();
		File file = new File(filePath1);
		//Create the file
		if (file.createNewFile()){
		System.out.println("File is created!");
		}else{
		System.out.println("File already exists.");
		}
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(new File(filePath1),array);
	}
/**
 * Method that sort the json array according to zip code
 * @param jsonArray
 * @param filePath
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
	public void sortByZipCode(JSONArray jsonArray,String filePath) throws FileNotFoundException, IOException, ParseException {
		AddressBook addressBook = new AddressBook();
		JSONArray bookArray = addressBook.readFromFile(filePath);
		ArrayList<JSONObject> list=new ArrayList<JSONObject>();
		for(int i=0;i<bookArray.size();i++)
		{
			JSONObject temp=(JSONObject) bookArray.get(i);
			list.add(temp);
		}
		
		 for(int i=0 ; i<list.size()-1;i++) {
	            for(int j=i+1; j<list.size();j++) {
	                JSONObject jsonObject1 = (JSONObject) list.get(i);
	                String key1 = (String) jsonObject1.get("Zip Code");
	               
	                JSONObject jsonObject2 = (JSONObject) list.get(j);
	                String key2 = (String) jsonObject2.get("Zip Code");
	               
	                if (key1.compareTo(key2)>0) {
	                    JSONObject temp =jsonObject1;
	                    list.set(i,jsonObject2);
	                    list.set(j,temp);
	                    }
	                }
	            }  
		 ObjectMapper mapper= new ObjectMapper();
		 mapper.writeValue(new File("/home/bridgelabz/JavaWorkspace/JavaProgramming/src/com/bridgelabz/objectoriented/AddressBookApplication/AddressBook.json"), list);
		 ObjectMapper objectMapper = new ObjectMapper();
		 objectMapper.writeValue(new File(filePath),list);
		 printAddressBook(bookArray,filePath);
	}
/**
 * Method to sort the json array by last name
 * @param jsonArray
 * @param filePath
 * @throws JsonGenerationException
 * @throws JsonMappingException
 * @throws IOException
 * @throws ParseException
 */
	public void sortByLastName(JSONArray jsonArray,String filePath) throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		AddressBook addressBook = new AddressBook();
		JSONArray bookArray = addressBook.readFromFile(filePath);
		ArrayList<JSONObject> list=new ArrayList<JSONObject>();
		for(int i=0;i<bookArray.size();i++)
		{
			JSONObject temp=(JSONObject) bookArray.get(i);
			list.add(temp);
		}
		 for(int i=0 ; i<list.size()-1;i++) {
	            for(int j=i+1; j<list.size();j++) {
	                JSONObject jsonObject1 = (JSONObject) list.get(i);
	                String key1 = (String) jsonObject1.get("Last Name");
	               
	                JSONObject jsonObject2 = (JSONObject) list.get(j);
	                String key2 = (String) jsonObject2.get("Last Name");
	               
	                if (key1.compareTo(key2)>0) {
	                    JSONObject temp =jsonObject1;
	                    list.set(i,jsonObject2);
	                    list.set(j,temp);
	                    }
	                }
	            }  
		 ObjectMapper mapper= new ObjectMapper();
		 mapper.writeValue(new File("/home/bridgelabz/JavaWorkspace/JavaProgramming/src/com/bridgelabz/objectoriented/AddressBookApplication/AddressBook.json"), list);
		 ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.writeValue(new File(filePath),list);
		 printAddressBook(bookArray, filePath);
	}
/**
 * Method to print the whole address book
 * @param jsonArray
 * @param filePath
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
	public void printAddressBook(JSONArray jsonArray,String filePath) throws FileNotFoundException, IOException, ParseException {
		AddressBook addressBook = new AddressBook();
		JSONArray bookArray = addressBook.readFromFile(filePath);
		for(int i=0;i<bookArray.size();i++)
		{
			System.out.println(bookArray.get(i));
		}
	}
/**
 * Method to delete a person record in the address book
 * @param jsonArray
 * @param filePath
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
	public void delete(JSONArray jsonArray,String filePath) throws FileNotFoundException, IOException, ParseException {
		Utility utility=new Utility();
		AddressBook addressBook = new AddressBook();
		JSONArray bookArray = addressBook.readFromFile(filePath);
		System.out.println("Whose data you want to remove? please enter the first name and the last name:");
		String firstName = utility.inputString();
		String lastName = utility.inputString();
		int flag=0;
		for(int i=0;i<bookArray.size();i++)
		{
			JSONObject bookObject=(JSONObject) bookArray.get(i);
			if (bookObject.get("First Name").equals(firstName) && bookObject.get("Last Name").equals(lastName)) {
				bookArray.remove(i);
				writeJson(bookArray);
				ObjectMapper objectMapper = new ObjectMapper();
				objectMapper.writeValue(new File(filePath),bookArray);
				flag=1;
				System.out.println("Removed successfully!!");
		}
		}
		if(flag==0)
			System.out.println("No such person found");
	}
/**
 * Method to add a person record in the addressbook
 * @param jsonArray
 * @param addressBook
 * @param filePath
 * @throws JsonGenerationException
 * @throws JsonMappingException
 * @throws IOException
 * @throws ParseException
 */
	public void addAPerson(JSONArray jsonArray, AddressBook addressBook,String filePath)
			throws JsonGenerationException, JsonMappingException, IOException, ParseException {
	
		Utility utility = new Utility();
		JSONParser parser = new JSONParser();
		FileReader reader=new FileReader(filePath);
		JSONArray jsonArray1 = (JSONArray) parser.parse(reader);
		Person person = addressBook.makePersonObject();
		JSONObject jsonObject = addressBook.createJSONObject(person);
		jsonArray1.add(jsonObject);
		addressBook.writeJson(jsonArray1);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(new File(filePath),jsonArray1);
		
	}
/**
 * Method to read from file
 * @param filePath
 * @return
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
	public JSONArray readFromFile(String filePath) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(filePath));
		return jsonArray;
	}
/**
 * Method to edit any person record in the addressbook
 * @param jsonArray
 * @param filePath
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
	public void edit(JSONArray jsonArray,String filePath) throws FileNotFoundException, IOException, ParseException {
		Utility utility = new Utility();
		AddressBook addressBook = new AddressBook();
		JSONArray bookArray = addressBook.readFromFile(filePath);
		System.out.println("Whose data you want to edit? please enter the first name and the last name:");
		String firstName = utility.inputString();
		String lastName = utility.inputString();

		System.out.println("What do you want to edit??");
		System.out.println("1.Address");
		System.out.println("2.Phone Number");
		int choice = utility.inputInt();
		int flag=0;
		switch (choice) {
		case 1:
			int i = 0;
			Iterator<Object> iterator = bookArray.iterator();
			while (iterator.hasNext()) {
				JSONObject bookObject = (JSONObject) iterator.next();
				if (bookObject.get("First Name").equals(firstName) && bookObject.get("Last Name").equals(lastName)) {
					System.out.println("Please enter new Address:");
					String address = utility.inputString();
					System.out.println("please enter new City:");
					String city = utility.inputString();
					System.out.println("please enter new State:");
					String state = utility.inputString();
					System.out.println("Please enter the new Zip code");
					String zipCode = utility.inputString();
					bookObject.put("Address", address);
					bookObject.put("City", city);
					bookObject.put("State", state);
					bookObject.put("Zip Code", zipCode);
					bookArray.remove(i);
					bookArray.add(i, bookObject);
					writeJson(bookArray);
					ObjectMapper objectMapper = new ObjectMapper();
					objectMapper.writeValue(new File(filePath),bookArray);
					flag=1;
				} 
				i++;
			}
			break;
		case 2:
			int j = 0;
			Iterator<Object> iterator1 = bookArray.iterator();
			while (iterator1.hasNext()) {
				JSONObject bookObject = (JSONObject) iterator1.next();
				if (bookObject.get("First Name").equals(firstName) && bookObject.get("Last Name").equals(lastName)) {
					System.out.println("Enter the new Phone number:");
					String phoneNumber=utility.inputString();
					bookObject.put("Phone Number", phoneNumber);
					bookArray.remove(j);
					bookArray.add(j, bookObject);
					writeJson(bookArray);
					ObjectMapper objectMapper = new ObjectMapper();
					objectMapper.writeValue(new File(filePath),bookArray);
					flag=1;
				}
				j++;
			}
			break;
		}
		if(flag==0)
			System.out.println("No such person found");
		
	}
	/**
	 * Method to search a person details by its phone number or last name
	 * @param jsonArray
	 * @param filePath
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 * @throws InterruptedException
	 */
	public void search(JSONArray jsonArray,String filePath) throws FileNotFoundException, IOException, ParseException, InterruptedException {
		Utility utility=new Utility();
		AddressBook addressBook = new AddressBook();
		JSONArray bookArray = addressBook.readFromFile(filePath);
		System.out.println("Through which way do you want to search the person details: ");
		System.out.println("1.By phone number?");
		System.out.println("2.by Name?");
		System.out.println("Please Enter your choice");
		int choice=utility.inputInt();
		
		switch (choice) {
		case 1:
			int i=0;
			System.out.println("Please enter the phone number:");
			String phoneNumber=utility.inputString();
			Iterator<Object> iterator = bookArray.iterator();
			while (iterator.hasNext()) {
				JSONObject bookObject = (JSONObject) iterator.next();
				if (bookObject.get("Phone Number").equals(phoneNumber)) {
					printPersonDetails(i,filePath);
				} 
				i++;
			}
			break;
		case 2:
			int j=0;
			System.out.println("Please enter the first name:");
			String firstName=utility.inputString();
			System.out.println("Please enter the Last name:");
			String lastName=utility.inputString();
			Iterator<Object> iterator1 = bookArray.iterator();
			while (iterator1.hasNext()) {
				JSONObject bookObject = (JSONObject) iterator1.next();
				if (bookObject.get("First Name").equals(firstName) && bookObject.get("Last Name").equals(lastName)) {
					printPersonDetails(j,filePath);
				} 
				j++;
			}
			break;
		default:
			break;
		}
	}
/**
 * Method to print a particular person details
 * @param index
 * @param filePath
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 * @throws InterruptedException
 */
	public void printPersonDetails(int index,String filePath) throws FileNotFoundException, IOException, ParseException, InterruptedException {
		AddressBook addressBook = new AddressBook();
		JSONArray bookArray = addressBook.readFromFile(filePath);
		System.out.println("Searching the person.");
		Thread.sleep(1000);
		System.out.println("Searching the person..");
		Thread.sleep(1000);
		System.out.println("Searching the person...");
		Thread.sleep(1000);
		System.out.println();
		System.out.println("The person details are:");
		System.out.println();
		for(int i=0;i<bookArray.size();i++) {
			if(index==i)
			{
				System.out.println(bookArray.get(i));
			}
		}
		
	}
/**
 * Method to create an empty new file
 * @return
 * @throws IOException
 */
	public String createEmptyNewFile() throws IOException {
		Utility utility=new Utility();
		JSONArray jsonArray=new JSONArray();
		System.out.println("Please enter the path where you want to store new addressbook details");
		String filePath=utility.inputString();
		File file = new File(filePath);
		//Create the file
		if (file.createNewFile()){
		System.out.println("File is created!");
		}else{
		System.out.println("File already exists.");
		}
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(new File(filePath),jsonArray);
		return filePath;
	}
	/**
	 * Method to create a new file
	 * @return
	 * @throws IOException
	 */
	public String createNewFile() throws IOException {
		Utility utility=new Utility();
		System.out.println("Please enter the path where you want to store new addressbook details");
		String filePath=utility.inputString();
		File file = new File(filePath);
		//Create the file
		if (file.createNewFile()){
		System.out.println("File is created!");
		}else{
		System.out.println("File already exists.");
		}
		return filePath;
	}
}
