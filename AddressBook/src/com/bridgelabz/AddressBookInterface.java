package com.bridgelabz.simpleaddressbook;

import java.util.LinkedList;

public interface AddressBookInterface {
	void addPerson();
	void editPersonInfo(String phoneNumber);
	void deletePerson(String phoneNumber);
	void sortEntriesByLastName(LinkedList<Persons> l);
	void sortEntriesByPhoneNumber(LinkedList<Persons> l);
}
