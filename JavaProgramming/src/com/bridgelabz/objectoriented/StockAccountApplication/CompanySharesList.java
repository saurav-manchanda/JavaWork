/********************************************************************************* *
 * Purpose: Maintain   the   List   of   CompanyShares   in   a   Linked   List   So   new   CompanyShares   can  
be   added   or   removed   easily.   Do   not   use   any   Collection   Library   to   implement   Linked  
List. 

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 12/06/2018
 *********************************************************************************/
package com.bridgelabz.objectoriented.StockAccountApplication;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.datastructures.MyLinkedList;
import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to Maintain   the   List   of   CompanyShares   in   a   Linked   List
 */
public class CompanySharesList {
	static MyLinkedList<JSONObject> LIST= new MyLinkedList<JSONObject>();
/**
 * Method that read from file and create and return the json array
 * @param filePath
 * @return JsSONArray
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
	 * Method that writes json Array into the file
	 * @param jsonArray
	 * @param filePath
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void writeIntoFile(JSONArray jsonArray,String filePath) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(new File(filePath),jsonArray);
	}
	/**
	 * Mehtod that writes List into the file
	 * @param filePath
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void writeIntoFile(String filePath) throws JsonGenerationException, JsonMappingException, IOException
	{
		JSONArray array=new JSONArray();
		for(int i=0;i<LIST.size();i++)
		{
			array.add(LIST.get(i));
		}
		writeIntoFile(array, filePath);
	}
	/**
	 * Method that makes a Company Shares Object
	 * @return object of CompanyShares
	 */
	public static CompanyShares makeCompanySharesObject() {
		Utility utility=new Utility();
		CompanyShares companyShares = new CompanyShares();
		System.out.println("Enter the symbol of shares:");
		String symbol = utility.inputString();
		companyShares.setSymbol(symbol);
		System.out.println("Enter the number of shares:");
		int numberOfShares = utility.inputInt();
		companyShares.setNumberOfShares(numberOfShares);
		String dateTime = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		companyShares.setDateTime(dateTime);
		System.out.println("Enter the price of share:");
		double price = utility.inputDouble();
		companyShares.setPrice(price);
		return companyShares;
	}
	/**
	 * Method that converts an object to json object
	 * @param companyShares
	 * @return
	 */
	public JSONObject createJSONObject(CompanyShares companyShares) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Symbol", companyShares.getSymbol());
		jsonObject.put("Number Of Shares", companyShares.getNumberOfShares());
		jsonObject.put("Date", companyShares.getDateTime());
		jsonObject.put("Stock Price", companyShares.getPrice());
		return jsonObject;
	}
	/**
	 * Main Mehtod
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		Utility utility= new Utility();
		CompanySharesList companySharesList=new CompanySharesList();
		System.out.println("Enter the path where StockAccounts are present");
		String filePath=utility.inputString();
		System.out.println("Enter the choice!!");
		System.out.println("1. Add into Stock Account?");
		System.out.println("2. Delete from a Stock Account?");
		int choice=utility.inputInt();
		switch (choice) {
		case 1:
			companySharesList.add(filePath);
			break;
		case 2:
			companySharesList.remove(filePath);
			break;
		default:
			break;
		}
	}
	/**
	 * Method that removes a particular stock from the list
	 * @param filePath
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void remove(String filePath) throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		Utility utility=new Utility();
		JSONArray jsonArray=readFromFile(filePath);
		for(int i=0;i<jsonArray.size();i++)
		{
			LIST.add((JSONObject)jsonArray.get(i));
		}
		System.out.println("Enter the symbol you want to remove?");
		String symbol=utility.inputString();
		for(int i=0;i<LIST.size();i++)
		{
			JSONObject temporary=LIST.get(i);
			if(temporary.get("Symbol").equals(symbol))
			{
				LIST.remove(temporary);
			}
		}
		writeIntoFile(filePath);
	}
	/**
	 * Method to add a particular stock
	 * @param filePath
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void add(String filePath) throws FileNotFoundException, IOException, ParseException {
		JSONArray jsonArray=readFromFile(filePath);
		for(int i=0;i<jsonArray.size();i++)
		{
			LIST.add((JSONObject)jsonArray.get(i));
		}
		CompanyShares companyShares=makeCompanySharesObject();
		JSONObject jsonObject= createJSONObject(companyShares);
		LIST.add(jsonObject);
		writeIntoFile(filePath);
	}

}
