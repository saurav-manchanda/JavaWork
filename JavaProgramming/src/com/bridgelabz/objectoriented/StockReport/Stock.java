/********************************************************************************* *
 * Purpose:  Write   a   program   to   read   in   Stock   Names,   Number   of   Share,   Share   Price. 
Print   a   Stock   Report   with   total   value   of   each   Stock   and   the   total   value   of   Stock. 

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 5/06/2018
 *********************************************************************************/
package com.bridgelabz.objectoriented.StockReport;

public class Stock {
	private String StockName;
	private int NumberOfShares;
	private double SharePrice;
	public String getStockName() {
		return StockName;
	}
	public void setStockName(String stockName) {
		StockName = stockName;
	}
	public int getNumberOfShares() {
		return NumberOfShares;
	}
	public void setNumberOfShares(int numberOfShares) {
		NumberOfShares = numberOfShares;
	}
	public double getSharePrice() {
		return SharePrice;
	}
	public void setSharePrice(double sharePrice) {
		SharePrice = sharePrice;
	}
}
