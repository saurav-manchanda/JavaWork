/**
 * 
 */
package com.bridgelabz;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.CollectionType;


public class AddressUtility {
	public static ObjectMapper mapper = new ObjectMapper();
	static Scanner scanner=new Scanner(System.in);
		
		
		
		
		/*
		 * Method to take user input as string
		 */
		public static String userInputString() {
			return scanner.next();

		}

		/*
		 * Method to take user input as long
		 */
		public static Long userInputLong() {
			return scanner.nextLong();

		}

		public static String userInputStringLine() {
			return scanner.nextLine();
		}

		/*
		 * Method to take user input as integer
		 */
		public static int userInputInteger() {
			return scanner.nextInt();
		}

		/*
		 * Method to take user input as double
		 */
		public static Double userInputDouble() {
			return scanner.nextDouble();
		}

		/*
		 * Method to take user input as boolean
		 */
		public static boolean userInputBoolean() {
			return scanner.nextBoolean();
		}

		/**
		 * Method to take inputs from user regarding person's details for adding
		 * 
		 * @return String containing person's details
		 */
		public static String[] askForInputs() {
			System.out.println("Enter the first name of the person");
			String firstName = userInputString();

			System.out.println("Enter the last name of the person");
			String lastName = userInputString();

			System.out.println("Enter the address of the person");
			String address = userInputString();

			System.out.println("Enter the city of the person");
			String city =userInputString();

			System.out.println("Enter the state of the person");
			String state = userInputString();

			System.out.println("Enter the zipCode of the area");
			String zip = userInputString();

			System.out.println("Enter the phone number of the person");
			String phone = userInputString();

			String[] string = { firstName, lastName, address, city, state, zip, phone };
			return string;

		}

		/**
		 * Method to take inputs from user regarding person's details for updation
		 * 
		 * @return String containing person's details
		 */
		public static String[] askForInputsUpdate() {

			System.out.println("Enter the address of the person");
			String address = userInputString();

			System.out.println("Enter the city of the person");
			String city =userInputString();

			System.out.println("Enter the state of the person");
			String state = userInputString();

			System.out.println("Enter the zipCode of the area");
			String zip = userInputString();

			System.out.println("Enter the phone number of the person");
			String phone = userInputString();

			String[] string = { address, city, state, zip, phone };
			return string;

		}

		/**
		 * Method to parse the JSON file and store into the array list
		 * 
		 * @param file
		 * @return
		 * @throws JsonMappingException
		 * @throws JsonParseException
		 * @throws FileNotFoundException
		 * @throws IOException
		 * @throws ParseException
		 */
		public static <T> ArrayList<T> parseJSONArray(File file, Class<T> clazz)
				throws JsonParseException, JsonMappingException, IOException {
			ArrayList<T> arrayList = new ArrayList<T>();
			CollectionType javaType = mapper.getTypeFactory()
				      .constructCollectionType(List.class, clazz);
			arrayList = mapper.readValue(file, javaType);

			return arrayList;

		}
		

	}

