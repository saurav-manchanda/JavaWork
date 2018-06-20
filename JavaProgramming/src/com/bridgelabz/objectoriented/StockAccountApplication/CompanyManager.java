/********************************************************************************* *
 * Purpose:StockAccount.java   implements   a   data   type   that  
might   be   used   by   a   financial   institution   to   keep   track   of   customer   information.The   StockAccount   class   also   maintains   a   list   of   CompanyShares   object   which   has  
Stock   Symbol   and   Number   of   Shares   as   well   as   DateTime   of   the   transaction.   When  
buy   or   sell   is   initiated   StockAccount   checks   if   CompanyShares   are   available   and  
accordingly   update   or   create   an   Object. 

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 8/06/2018
 *********************************************************************************/
package com.bridgelabz.objectoriented.StockAccountApplication;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.bridgelabz.datastructures.LinkedStack;
import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class that manages all the stocks
 */
public class CompanyManager {

	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		CompanyManager companyManager=new CompanyManager();
		companyManager.askUser();
	}

	public void askUser() throws IOException, ParseException,FileNotFoundException
	{
		Utility utility=new Utility();
		StockAccount stockAccount=new StockAccount();
		System.out.println("\n Enter your name:");
		String name=utility.inputString();
		System.out.println("Please enter the path of where you want to create a new account of yours");
		String newAccountPath=utility.inputString();
		stockAccount.createNewFile(newAccountPath);
		
		System.out.println("what do you want to perform?");
		System.out.println("1.Buy stock??");
		System.out.println("2. Sell stock??");
		System.out.println("3. Quit");
		int choice=utility.inputInt();
		System.out.println("Please enter path where stock account is present..");
		String filePath=utility.inputString();
		switch (choice) {
		case 1:
			stockAccount.printReport(filePath);
			System.out.println("Which symbol do you want to buy?");
			String symbol=utility.inputString();
			System.out.println("How much amount you have?");
			double amount=utility.inputDouble();
			stockAccount.buy(amount, symbol,filePath,newAccountPath);
			askUser();
			break;
		case 2:
			stockAccount.sell(filePath,newAccountPath);
			askUser();
			break;
		
		default:
			break;
		}
	}
}
