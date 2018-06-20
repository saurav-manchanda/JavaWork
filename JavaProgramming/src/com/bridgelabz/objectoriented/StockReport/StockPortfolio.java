/********************************************************************************* *
 * Purpose: To make a class that holds a stock

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 19/05/2018
 *********************************************************************************/
package com.bridgelabz.objectoriented.StockReport;

import java.util.ArrayList;

public class StockPortfolio {
private ArrayList<Stock> stocks=new ArrayList<Stock>();

public ArrayList<Stock> getStocks() {
	return stocks;
}

public void setStocks(ArrayList<Stock> stocks) {
	this.stocks = stocks;
}

}
