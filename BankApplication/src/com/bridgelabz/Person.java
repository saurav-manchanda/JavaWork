/********************************************************************************* *
 * Purpose: To make a person class having 
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 5/07/2018
 *********************************************************************************/
package com.bridgelabz;

/**
 * @author Saurav:
 * Class Person having fields bank and personName. Settwers and getter methods are applied.
 */
public class Person {
	private Bank bank;
	private String personName;
	/**
	 * Method to get the bank account
	 * @return
	 */
	public Bank getBank() {
		return bank;
	}
/**
 * Method to set the bank 
 * @param bank
 */
	public void setBank(Bank bank) {
		this.bank = bank;
	}
/**
 * Method to get the personName
 */
	
	public String getPersonName() {
		return personName;
	}
/**
 * Method to set the person name.
 * @param personName
 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}
/**
 * Method to display the person details
 */
	public void display() {
		System.out.println("The person name is: "+personName);
		this.bank.display();
		
	}
}
