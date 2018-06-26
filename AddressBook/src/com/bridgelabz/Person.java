
package com.bridgelabz;
import java.io.Serializable;

/**
 * @author bridgelabz
 *
 */
public class Person implements Serializable {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;

	public Person() {

	}

	/**
	 * Constructor to initialize the person's details while adding person to address
	 * book
	 * 
	 * @param firstName
	 *            FirstName of the person
	 * @param lastName
	 *            LastName of the person
	 * @param address
	 *            Address of the person
	 * @param city
	 *            City of the person
	 * @param state
	 *            State of the person
	 * @param zip
	 *            ZipCode of the person
	 * @param phone
	 *            PhoneNumber of the person
	 */
	public Person(String firstName, String lastName, String address, String city, String state, String zip,
			String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;

	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getAddress() {
		return address;
	}


	public String getCity() {
		return city;
	}


	public String getState() {
		return state;
	}


	public String getZip() {
		return zip;
	}


	public String getPhone() {
		return phone;
	}

}


