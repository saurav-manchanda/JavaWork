/********************************************************************************* *
 * Purpose: To create a POJO class of Company Shares having symbol,number of shares,dateTime and price

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 10/06/2018
 *********************************************************************************/
package com.bridgelabz.objectoriented.StockAccountApplication;

/**
 * @author Saurav:
 * Class POJO Company Shares
 */
public class CompanyShares {
	private String symbol;
	private int numberOfShares;
	private String dateTime;
	private double price;
	/**
	 * Method to get the symbol
	 * @return
	 */
	public String getSymbol() {
		return symbol;
	}
	/**
	 * Method to set the symbol
	 * @param symbol
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	/**
	 * Method to get the number of Shares
	 * @return
	 */
	public int getNumberOfShares() {
		return numberOfShares;
	}
	/**
	 * Method to set the number of shares
	 * @param numberOfShares
	 */
	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}
	/**
	 * Method to get the date and time
	 * @return
	 */
	public String getDateTime() {
		return dateTime;
	}
	/**
	 * Method to set the date and time
	 * @param dateTime
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	/**
	 * Method to get the price of stock
	 * @return
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * Method to set the stock price
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	

}

