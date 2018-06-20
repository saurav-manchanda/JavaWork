/********************************************************************************* *
 * Purpose: To create a Stock Account

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 10/06/2018
 *********************************************************************************/
package com.bridgelabz.objectoriented.StockAccountApplication;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.datastructures.LinkedQueue;
import com.bridgelabz.datastructures.LinkedStack;
import com.bridgelabz.datastructures.MyLinkedList;
import com.bridgelabz.objectoriented.AddressBookApplication.Person;
import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class StockAccount that holds Methods to implement stock
 */
public class StockAccount {
	static LinkedStack<String> transactionStack=new LinkedStack<String>();
	static LinkedQueue<String> transactionQueue=new LinkedQueue<String>();
	public StockAccount(){
		
	}
	public StockAccount(String filePath) throws IOException
	{
		createNewFile(filePath);
	}
/**
 * Method to buy the stock
 * @param amount
 * @param symbol
 * @param filePath
 * @param newAccountFilePath
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
	public void buy(double amount,String symbol,String filePath,String newAccountFilePath) throws FileNotFoundException, IOException, ParseException
	{
		Utility utility=new Utility();
		JSONArray jsonarray=readFromFile(filePath);
		System.out.println("Please enter how many shares you want to buy?");
		int buyShares=utility.inputInt();
		for(int i=0;i<jsonarray.size();i++)
		{
			JSONObject temporary=(JSONObject) jsonarray.get(i);
			if(symbol.equals(temporary.get("Symbol")))
			{
				if((amount*buyShares)<=((long)temporary.get("Number Of Shares")*(double)temporary.get("Stock Price")) && (buyShares<=(long)temporary.get("Number Of Shares")))
				{
					long temp=(long)temporary.get("Number Of Shares")-buyShares;
					temporary.put("Number Of Shares",temp);
					jsonarray.remove(i);
					jsonarray.add(i, temporary);
					amount=amount-(buyShares*(double)temporary.get("Stock Price"));
					writeIntoFile(jsonarray, filePath);
					updateNewAccount(newAccountFilePath, symbol, buyShares, amount);
					transactionStack.push((String)temporary.get("Symbol"));
					System.out.println("\n Transaction done!! Symbol pushed to the Stack");
					transactionStack.display();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					String date = dateFormat.format(new Date());
					transactionQueue.enqueue(date);
					System.out.println("\n DateTime added to queue!!");
					transactionQueue.display();
				}
			}
		}
		
		
	}
	/**
	 * Method to update the new Account
	 * @param filePath
	 * @param symbol
	 * @param buyShares
	 * @param amount
	 * @throws IOException
	 */
	private void updateNewAccount(String filePath,String symbol,int buyShares,double amount) throws IOException {
		FileWriter filewriter=new FileWriter(filePath);
		BufferedWriter bw=new BufferedWriter(filewriter);
		String fileitem = "Share bought from: " + symbol + "\n" + "No of share bought: " + buyShares + "\n"
				+ "Current balance: " + amount + "\n" + "Buying date and time: " + LocalDateTime.now() + "\n" + "\n";
		bw.write(fileitem);
		bw.flush();
		bw.close();
	}
/**
 * Mehtod to print the report
 * @param filePath
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
	public void printReport(String filePath) throws FileNotFoundException, IOException, ParseException {
		JSONArray jsonArray= readFromFile(filePath);
		for(int i=0;i<jsonArray.size();i++)
		{
			System.out.println(jsonArray.get(i));
		}
	}
	/**
	 * Method to create a CompanySHaresObject
	 * @return
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
	 * Method to convert an object to json object
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
 * Method to read from file and return json array
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
	 * Method to write a jsonArray into file
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
 * Method to sell our stock
 * @param filePath
 * @param newAccountPath
 * @throws FileNotFoundException
 * @throws IOException
 * @throws ParseException
 */
	public void sell(String filePath,String newAccountPath) throws FileNotFoundException, IOException, ParseException {
		CompanyShares companyShares=makeCompanySharesObject();
		JSONObject jsonObject=createJSONObject(companyShares);
		transactionStack.push((String)jsonObject.get("Symbol"));
		JSONArray jsonArray=readFromFile(filePath);
		jsonArray.add(jsonObject);
		writeIntoFile(jsonArray, filePath);
		writeIntoFile(jsonArray, newAccountPath);
		System.out.println("\n Your shares added to the shares account successfully..");
		System.out.println("\n Symbol is added to the stack..");
		transactionStack.display();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date = dateFormat.format(new Date());
		transactionQueue.enqueue(date);
		System.out.println("\n DateTime added to queue!!");
		transactionQueue.display();
		
	}
	/**
	 * Method that creates a new file
	 * @param filePath
	 * @throws IOException
	 */
	public void createNewFile(String filePath) throws IOException {
		File file = new File(filePath);
		//Create the file
		if (file.createNewFile()){
		System.out.println("File is created!");
		}else{
		System.out.println("File already exists.");
		}
		return;
	}
	
	
}
