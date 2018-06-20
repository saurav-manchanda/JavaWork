/********************************************************************************* *
 * Purpose: To create a Pojo class of product so we can simply add produts to invetory by making object od this class

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 04/06/2018
 *********************************************************************************/
package com.bridgelabz.objectoriented.InventoryDataManagement;

/**
 * @author Saurav:
 * Class to create a Pojo class of product
 */
public class Product {
	private String name;
	private int weight;
	private double price;
/**
 * Method to get the name of product
 * @return name
 */
	public String getName() {
		return name;
	}
/**
 * Mehtod to set the name of the product
 * @param name
 */
	public void setName(String name) {
		this.name = name;
	}
/**
 * Method to get the weight of product in the inventory
 * @return weight
 */
	public int getWeight() {
		return weight;
	}
/**
 * Method to set the weight of product available in the invenoty
 * @param weight
 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
/**
 * Method to get the price of the product per kg
 * @return price
 */
	public double getPrice() {
		return price;
	}
/**
 * Method to set the Price of the product per kg
 * @param price
 */
	public void setPrice(double price) {
		this.price = price;
	}
}
