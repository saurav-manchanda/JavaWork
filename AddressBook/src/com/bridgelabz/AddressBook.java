package com.bridgelabz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class AddressBook {
	/**
	 * Method to create a person object
	 * 
	 * @return
	 */
	public static Person makePersonObject() {
		System.out.println("Enter the First Name:");
		String firstName = Utility.inputString();
		System.out.println("Enter the Last Name:");
		String lastName = Utility.inputString();
		System.out.println("Enter the Address:");
		String address = Utility.inputString();
		System.out.println("Enter the city:");
		String city = Utility.inputString();
		System.out.println("Enter the state:");
		String state = Utility.inputString();
		System.out.println("Enter the zip code:");
		String zipCode = Utility.inputString();
		System.out.println("Enter the phone number:");
		String phoneNumber = Utility.inputString();
		Person person = new Person(firstName, lastName, address, city, state, zipCode, phoneNumber);
		return person;
	}

	/**
	 * Method to covert a person object to json object
	 * 
	 * @param person
	 * @return
	 */
	public static JSONObject createJSONObject(Person person) {
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
	 * Method to add a person record in the addressbook
	 * 
	 * @param jsonArray
	 * @param addressBook
	 * @param filePath
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void addAPerson(String filePath) {
		Person person = makePersonObject();
		JSONObject jsonObject = createJSONObject(person);
		JSONArray jsonArray = readFromFile(filePath);
		jsonArray.add(jsonObject);
		writeJson(jsonArray, filePath);
	}

	public static void writeJson(JSONArray jsonArray, String filePath) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.writeValue(new File(filePath), jsonArray);
		} catch (JsonGenerationException e) {
			System.out.println("JsonGenerationException is found");
		} catch (JsonMappingException e) {
			System.out.println("JSON Mapping is failed..");
		} catch (IOException e) {
			System.out.println("File is not found to write..Please enter the correct file path");
		}

	}

	public static JSONArray readFromFile(String filepath) {
		JSONParser parser = new JSONParser();
		FileReader reader;
		JSONArray jsonArray = null;
		try {
			reader = new FileReader(filepath);
			jsonArray = (JSONArray) parser.parse(reader);
		} catch (Exception e) {
			System.out.println("File cannot be Read from the given path.");
		}
		return jsonArray;
	}

	public static void editAPerson(String filePath) {
		JSONArray jsonArray = readFromFile(filePath);
		System.out.println("Whose data you want to edit? please enter the first name and the last name:");
		String firstName = Utility.inputString();
		String lastName = Utility.inputString();
		System.out.println("What do you want to edit??");
		System.out.println("1.Address");
		System.out.println("2.Phone Number");
		int choice = Utility.inputInt();
		int flag = 0;
		switch (choice) {
		case 1:
			editAddress(jsonArray, firstName, lastName, filePath);
			flag=1;
			break;
		case 2:
			editPhoneNumber(jsonArray, firstName,lastName,filePath);
			flag=1;
			break;
		}
		if (flag == 0)
			System.out.println("No such person found");
	}

	public static void editPhoneNumber(JSONArray jsonArray, String firstName, String lastName, String filePath) {
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObject = (JSONObject) jsonArray.get(i);
			if (jsonObject.get("First Name").equals(firstName) && jsonObject.get("Last Name").equals(lastName)) {
				System.out.println("Enter the new Phone number:");
				String phoneNumber = Utility.inputString();
				jsonObject.put("Phone Number", phoneNumber);
				jsonArray.remove(i);
				jsonArray.add(i, jsonObject);
				writeJson(jsonArray, filePath);
			}
		}
	}

	public static void editAddress(JSONArray jsonArray, String firstName, String lastName, String filePath) {
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObject = (JSONObject) jsonArray.get(i);
			if (jsonObject.get("First Name").equals(firstName) && jsonObject.get("Last Name").equals(lastName)) {
				System.out.println("Please enter new Address:");
				String address = Utility.inputString();
				System.out.println("please enter new City:");
				String city = Utility.inputString();
				System.out.println("please enter new State:");
				String state = Utility.inputString();
				System.out.println("Please enter the new Zip code");
				String zipCode = Utility.inputString();
				jsonObject.put("Address", address);
				jsonObject.put("City", city);
				jsonObject.put("State", state);
				jsonObject.put("Zip Code", zipCode);
				jsonArray.remove(i);
				jsonArray.add(i, jsonObject);
				writeJson(jsonArray, filePath);
			}
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
		public void delete(String filePath)  {
			JSONArray jsonArray = readFromFile(filePath);
			System.out.println("Whose data you want to remove? please enter the first name and the last name:");
			String firstName = Utility.inputString();
			String lastName = Utility.inputString();
			int flag=0;
			for(int i=0;i<jsonArray.size();i++)
			{
				JSONObject bookObject=(JSONObject) jsonArray.get(i);
				if (bookObject.get("First Name").equals(firstName) && bookObject.get("Last Name").equals(lastName)) {
					jsonArray.remove(i);
					writeJson(jsonArray,filePath);
					flag=1;
					System.out.println("Removed successfully!!");
			}
			}
			if(flag==0)
				System.out.println("No such person found");
	}
}
