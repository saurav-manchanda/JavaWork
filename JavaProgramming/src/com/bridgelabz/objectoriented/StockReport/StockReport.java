/********************************************************************************* *
 * Purpose: Write   a   program   to   read   in   Stock   Names,   Number   of   Share,   Share   Price. 
Print   a   Stock   Report   with   total   value   of   each   Stock   and   the   total   value   of   Stock.
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 12/06/2018
 *********************************************************************************/
package com.bridgelabz.objectoriented.StockReport;

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

public class StockReport {
	static double VALUE_OF_EACH_STOCK;
	static double TOTAL_VALUE_OF_STOCKS;
	static Utility utility= new Utility();
	public static Stock makeStockObject() {
		Stock stock= new Stock();
		System.out.println("Enter the name of stock");
		String stockName = utility.inputString();
		stock.setStockName(stockName);
		System.out.println("Enter the Number of shares:");
		int NumberOfShares=utility.inputInt();
		stock.setNumberOfShares(NumberOfShares);
		System.out.println("Share Price:");
		double sharePrice = utility.inputDouble();
		stock.setSharePrice(sharePrice);
		return stock;
	}

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException, ParseException {
		StockPortfolio stockPortfolio= new StockPortfolio();
		System.out.println("Enter the number of Stocks:");
		int numberOfStocks=utility.inputInt();
		Stock stock= new Stock();
		for(int i=0;i<numberOfStocks;i++) {
			stock=makeStockObject();
			stockPortfolio.getStocks().add(stock);
		}
		ObjectMapper objectMapper=new ObjectMapper();
		objectMapper.writeValue(new File("/home/bridgelabz/saurav/JavaProgramming/src/com/bridgelabz/objectoriented/StockReport.json"), stockPortfolio);
		JSONParser parser= new JSONParser();
		Object object=parser.parse(new FileReader("/home/bridgelabz/saurav/JavaProgramming/src/com/bridgelabz/objectoriented/StockReport.json"));
		JSONObject jsonObject=(JSONObject) object;
		JSONArray stockArray= (JSONArray) jsonObject.get("stocks");
		for(int i=0;i<stockArray.size();i++) {
			JSONObject temporary= (JSONObject) stockArray.get(i);
			VALUE_OF_EACH_STOCK+=(long)temporary.get("numberOfShares")*(double)temporary.get("sharePrice");
			System.out.println("The Value of stock "+(i+1) +" is "+VALUE_OF_EACH_STOCK);
			VALUE_OF_EACH_STOCK=0;
			TOTAL_VALUE_OF_STOCKS+=(long)temporary.get("numberOfShares")*(double)temporary.get("sharePrice");
		}
		System.out.println("The total value of stocks is: "+ TOTAL_VALUE_OF_STOCKS);
	}

}
