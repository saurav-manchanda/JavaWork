/********************************************************************************* *
 * Purpose: To make an Account Class 
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 5/07/2018
 *********************************************************************************/
package com.bridgelabz;

/**
 * @author Saurav:
 * class to make the Account 
 */
public class Account {
	int accountNumber;
	String addressOfPerson;
	/**
	 * Method to get the account number
	 * @return
	 */
	public int getAccountNumber() {
		return accountNumber;
	}
	/**
	 * Method to set the account number
	 * @param accountNumber
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * Method to get the Address of the person 
	 * @return
	 */
	public String getAddressOfPerson() {
		return addressOfPerson;
	}
	/**
	 * 
	 * @param addressOfPerson
	 */
	
	public void setAddressOfPerson(String addressOfPerson) {
		this.addressOfPerson = addressOfPerson;
	}
	/**
	 * Method to display the Account details
	 */
	public void display() {
		System.out.println("The account number is: "+accountNumber);
		System.out.println("The address is: "+addressOfPerson);
	}
}
