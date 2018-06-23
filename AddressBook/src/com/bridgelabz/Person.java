/********************************************************************************* *
 * Purpose: Create   Object   Oriented   Analysis   and   Design   of   a   simple   Address   Book   Problem . 
Person class
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 23/06/2018
 *********************************************************************************/
package com.bridgelabz;

/**
 * @author Saurav: POJO class Person
 */
public class Person {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String phoneNumber;

	/**
	 * Constructor
	 * 
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param city
	 * @param state
	 * @param zipcode
	 * @param phoneNumber
	 */
	public Person(String firstName, String lastName, String address, String city, String state, String zipcode,
			String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * to get the first name
	 * 
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * to set the first name
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * toget the last name
	 * 
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * to set the last name
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * to get the address
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * to set the address
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * to get the city name
	 * 
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * to set the city name
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * to get the state
	 * 
	 * @return
	 */
	public String getState() {
		return state;
	}

	/**
	 * to set the state
	 * 
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * to get the zip code
	 * 
	 * @return
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * to set the zipcode
	 * 
	 * @param zipcode
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * to get the phone number
	 * 
	 * @return
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * to set the phone number
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
