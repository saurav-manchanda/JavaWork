/********************************************************************************* *
 * Purpose: To create inventory 

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 4/06/2018
 *********************************************************************************/
package com.bridgelabz.objectoriented.InventoryDataManagement;

import java.util.ArrayList;

/**
 * @author Saurav:
 * Class to create the inventory 
 */
public class Inventory {
	private ArrayList<Product> ricesArrayList= new ArrayList<Product>();
	private ArrayList<Product> pulsesArrayList= new ArrayList<Product>();
	private ArrayList<Product> wheatArrayList= new ArrayList<Product>();
	public ArrayList<Product> getRicesArrayList() {
		return ricesArrayList;
	}
	public void setRicesArrayList(ArrayList<Product> ricesArrayList) {
		this.ricesArrayList = ricesArrayList;
	}
	public ArrayList<Product> getPulsesArrayList() {
		return pulsesArrayList;
	}
	public void setPulsesArrayList(ArrayList<Product> pulsesArrayList) {
		this.pulsesArrayList = pulsesArrayList;
	}
	public ArrayList<Product> getWheatArrayList() {
		return wheatArrayList;
	}
	public void setWheatArrayList(ArrayList<Product> wheatArrayList) {
		this.wheatArrayList = wheatArrayList;
	}
}
