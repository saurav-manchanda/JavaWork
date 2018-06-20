/********************************************************************************* *
 * Purpose:   to   Create   InventoryManager   to   manage   the 
Inventory.   The   Inventory   Manager   will   use   InventoryFactory   to   create   Inventory 
Object   from   JSON.   The   InventoryManager   will   call   each   Inventory   Object   in   its   list 
to   calculate   the   Inventory   Price   and   then   call   the   Inventory   Object   to   return   the 
JSON   String.  

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 04/06/2018
 *********************************************************************************/
package com.bridgelabz.objectoriented.InventoryDataManagement;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
 * Class to create the Inventory Manager that manages the inventory
 */
public class InventoryManager {
	static double TOTAL_PRICE_RICE;
	static double TOTAL_PRICE_PULSES;
	static double TOTAL_PRICE_WHEAT;
	static double ALL_STOCK_PRICE;
	static Utility utility = new Utility();

	/**
	 * Method to make a valid product in the inventory
	 * @return proct object
	 */
	public static Product makeProductObject() {
		Product product = new Product();
		System.out.println("Enter the name of product");
		String name = utility.inputString();
		product.setName(name);
		System.out.println("Enter the weight:");
		int weight = utility.inputInt();
		product.setWeight(weight);
		System.out.println("Enter the price per kg:");
		double price = utility.inputDouble();
		product.setPrice(price);
		return product;
	}

//	public static Pulses makePulsesObject() {
//		Pulses pulses = new Pulses();
//		System.out.println("Enter the name of pulses");
//		String name = utility.inputString();
//		pulses.setName(name);
//		System.out.println("Enter the weight:");
//		int weight = utility.inputInt();
//		pulses.setWeight(weight);
//		System.out.println("Enter the price per kg:");
//		double price = utility.inputDouble();
//		pulses.setPrice(price);
//		return pulses;
//	}
//
//	public static Wheat makeWheatObject() {
//		Wheat wheat = new Wheat();
//		System.out.println("Enter the name of wheat");
//		String name = utility.inputString();
//		wheat.setName(name);
//		System.out.println("Enter the weight:");
//		int weight = utility.inputInt();
//		wheat.setWeight(weight);
//		System.out.println("Enter the price per kg:");
//		double price = utility.inputDouble();
//		wheat.setPrice(price);
//		return wheat;
//	}

	public static void main(String[] args)
			throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		Inventory inventory = new Inventory();
		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println("Enter how many types of rice you are having");
		int riceTypes = utility.inputInt();
		Product product= new Product();
		for (int i = 0; i < riceTypes; i++) {
			product=makeProductObject();
			inventory.getRicesArrayList().add(product);
		}

		System.out.println("Enter how many types of pulses you are having");
		int pulsesTypes = utility.inputInt();
		for (int i = 0; i < pulsesTypes; i++) {
			product=makeProductObject();
			inventory.getPulsesArrayList().add(product);
		}
		System.out.println("Enter how many types of wheat you are having");
		int wheatTypes = utility.inputInt();
		for (int i = 0; i < wheatTypes; i++) {
			product=makeProductObject();
			inventory.getWheatArrayList().add(product);
		}
		objectMapper.writeValue(
				new File("/home/bridgelabz/saurav/JavaProgramming/src/com/bridgelabz/objectoriented/InventoryFile.json"),
				inventory);
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(
				"/home/bridgelabz/saurav/JavaProgramming/src/com/bridgelabz/objectoriented/InventoryFile.json"));
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray arrayRice = (JSONArray) jsonObject.get("ricesArrayList");
		for (int i = 0; i < arrayRice.size(); i++) {
			JSONObject temporary = (JSONObject) arrayRice.get(i);
			TOTAL_PRICE_RICE += (long) temporary.get("weight") * (double) temporary.get("price");
			ALL_STOCK_PRICE+=(long) temporary.get("weight") * (double) temporary.get("price");
		}
		JSONArray arrayPulses = (JSONArray) jsonObject.get("pulsesArrayList");
		for (int i = 0; i < arrayPulses.size(); i++) {
			JSONObject temporary = (JSONObject) arrayPulses.get(i);
			TOTAL_PRICE_PULSES += (long) temporary.get("weight") * (double) temporary.get("price");
			ALL_STOCK_PRICE+=(long) temporary.get("weight") * (double) temporary.get("price");
		}
		JSONArray arrayWheat = (JSONArray) jsonObject.get("wheatArrayList");
		for (int i = 0; i < arrayWheat.size(); i++) {
			JSONObject temporary = (JSONObject) arrayWheat.get(i);
			TOTAL_PRICE_WHEAT += (long)temporary.get("weight") * (double) temporary.get("price");
			ALL_STOCK_PRICE+=(long) temporary.get("weight") * (double) temporary.get("price");

			System.out.println("The overall price of rice in stock is " + TOTAL_PRICE_RICE + " rupees");
			System.out.println("The overall price of pulses in stock is " + TOTAL_PRICE_PULSES + " rupees");
			System.out.println("The overall price of wheat in stock is " + TOTAL_PRICE_WHEAT + " rupees");
			System.out.println("The total stock price: "+ALL_STOCK_PRICE+"rupees");

		}
	}
}