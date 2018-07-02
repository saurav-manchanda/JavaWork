package com.bridgelabz;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class AddressBook implements AddressBookInterface{
	
	public LinkedList <Persons>l=new LinkedList <Persons>();
	public LinkedList personsNameList=new LinkedList();
	Test t=new Test();
	
/****************************************************************************************************/	
public  void addPerson() {
		
	 	Persons p=new Persons();
	 	System.out.println("Enter your first name");
		p.setFirstName(Utility.getString());
		System.out.println("Enter your last name");
		p.setLastName(Utility.getString());
		System.out.println("Enter your address");
		p.setAddress(Utility.getString());
		System.out.println("Enter your city name");
		p.setCity(Utility.getString());
		System.out.println("Enter your state name");
		p.setState(Utility.getString());
		System.out.println("Enter your zip code");
		p.setZip(Utility.getString());
		System.out.println("Enter your Phone Number");
		p.setPhoneNumber(Utility.getString());
		
		AddressBookManager.addressBookObject.l.add(p);
		
		AddressBookManager.addressBookObject.personsNameList.add(p.getPhoneNumber());
}
/*************************************************************************************************/ 
  public void editPersonInfo(String phoneNumber) {
	 
	 System.out.print("Searching Person Number Status : ");
	 System.out.println(AddressBookManager.addressBookObject.personsNameList.search(phoneNumber));
	 if(AddressBookManager.addressBookObject.personsNameList.search(phoneNumber)==true) {
	 int index=AddressBookManager.addressBookObject.personsNameList.index(phoneNumber);
	 
	 System.out.println("Enter your address");
	 AddressBookManager.addressBookObject.l.get(index-1).setAddress(Utility.getString());
	 
	 System.out.println("Enter your city name");
	 AddressBookManager.addressBookObject.l.get(index-1).setCity(Utility.getString());
	
	 System.out.println("Enter your state name");
	 AddressBookManager.addressBookObject.l.get(index-1).setState(Utility.getString());
	
	 System.out.println("Enter your zip code");
	 AddressBookManager.addressBookObject.l.get(index-1).setZip(Utility.getString());
	
	 System.out.println("Enter your Phone Number");
	 AddressBookManager.addressBookObject.l.get(index-1).setPhoneNumber(Utility.getString());
	 
	 AddressBookManager.addressBookObject.personsNameList.removeAt(index-1);
	 AddressBookManager.addressBookObject.personsNameList.insert(l.get(index-1).getPhoneNumber(),index-1);
	 
	 }else {
		 System.out.println(" Entered user number not found ");
	 }
	
 }
 /*************************************************************************************************/
 public void deletePerson(String phoneNumber){
	 
	 System.out.print("Searching number /n Status : ");
	 System.out.println(AddressBookManager.addressBookObject.personsNameList.search(phoneNumber));
	 if(AddressBookManager.addressBookObject.personsNameList.search(phoneNumber)==true) {
	 int index=AddressBookManager.addressBookObject.personsNameList.index(phoneNumber);
	 System.out.println("Persons found at : "+index+"...deleted.");
	 AddressBookManager.addressBookObject.l.remove(index-1);
	 AddressBookManager.addressBookObject.personsNameList.removeAt(index-1);
	 }else
	 {
		 System.out.println(" Entered user number not found ");
	 }
}
 /*************************************************************************************************/
	public void sortEntriesByLastName(LinkedList<Persons> l) {
		class SortByLastName implements Comparator<Persons>
		{
			// Used for sorting in ascending order by Persons Last Name
			@Override
			public int compare(Persons a, Persons b) {
				return a.getLastName().compareTo(b.getLastName());
			}
		}
		 Collections.sort(l, new SortByLastName());
		 	System.out.println("person list size "+l.size());
	        System.out.println("Sorting Choosen Address Book by Last Name");
	        for (int i=0; i<l.size(); i++) {
	        	System.out.println("Printing Person "+(i+1)+" from the Choosen Address Book");
	            System.out.println("First Name "+l.get(i).getFirstName());
	            System.out.println("Last Name "+l.get(i).getLastName());
	            System.out.println("Address "+l.get(i).getAddress());
	            System.out.println("City "+l.get(i).getCity());
	            System.out.println("State "+l.get(i).getState());
	            System.out.println("Zip "+l.get(i).getZip());
	            System.out.println("Phone Number "+l.get(i).getPhoneNumber());
	            System.out.println();
	            }
	}
	/*************************************************************************************************/
	public void sortEntriesByPhoneNumber(LinkedList<Persons> l) {
		class SortByPhoneNumber implements Comparator<Persons>
		{
			// Used for sorting in ascending order by Persons Phone Number
			@Override
			public int compare(Persons a, Persons b) {
				return a.getPhoneNumber().compareTo(b.getPhoneNumber());
			}
		}
		
		 Collections.sort(l, new SortByPhoneNumber());
		 
	        System.out.println("Sorting Choosen Address Book by Phone Number");
	        for (int i=0; i<l.size(); i++) {
	        	System.out.println("Printing Person "+(i+1)+" from the Choosen Address Book");
	            System.out.println("First Name "+l.get(i).getFirstName());
	            System.out.println("Last Name "+l.get(i).getLastName());
	            System.out.println("Address "+l.get(i).getAddress());
	            System.out.println("City "+l.get(i).getCity());
	            System.out.println("State "+l.get(i).getState());
	            System.out.println("Zip "+l.get(i).getZip());
	            System.out.println("Phone Number "+l.get(i).getPhoneNumber());
	            System.out.println();
	            }
	}
 /*****************************************************************************************************/
 public static void printEntries (LinkedList L) {
	 for(int i=0;i<AddressBookManager.addressBookObject.l.size();i++) {
	 System.out.println(AddressBookManager.addressBookObject.l.get(i).getFirstName());
	 System.out.println(AddressBookManager.addressBookObject.l.get(i).getLastName());
	 System.out.println(AddressBookManager.addressBookObject.l.get(i).getAddress());
	 System.out.println(AddressBookManager.addressBookObject.l.get(i).getCity());
	 System.out.println(AddressBookManager.addressBookObject.l.get(i).getState());
	 System.out.println(AddressBookManager.addressBookObject.l.get(i).getZip());
	 System.out.println(AddressBookManager.addressBookObject.l.get(i).getPhoneNumber());
	 
	 System.out.println();
	}
}
/******************************************************************************************************/ 
 public static void manager() {
	 boolean addressBookStatus=true;	
	 while(addressBookStatus==true) {
		System.out.println(" _________________________");
		System.out.println(" Address Book Menu"); 
		System.out.println(" _________________________\n");
		System.out.println(" Select the option : ");
		System.out.println(" Enter 1 to add new Person in the address book : ");
		System.out.println(" Enter 2 to edit existing Person Information in the Address Book : ");
		System.out.println(" Enter 3 to delete existing Person in the Address Book : ");
		System.out.println(" Enter 4 to Sort Entries By Last Name : ");
		System.out.println(" Enter 5 to Sort Enries By Phone Number  : ");
		System.out.println(" Enter 0 to Exit the Currently Opened Address Book:");
		int option=Utility.getInt();
		switch(option) {
		case 1 : AddressBookManager.addressBookObject.addPerson();
				 AddressBook.printEntries(AddressBookManager.addressBookObject.l);	
				 break;	
		case 2 : System.out.println("Displaying Available Person Number List");
		 		 AddressBookManager.addressBookObject.personsNameList.display();
		 		 System.out.println();
				 System.out.println("Enter the number of the person to edit the information "); 
				 String phoneNumber=Utility.getString();
				 AddressBookManager.addressBookObject.editPersonInfo(phoneNumber);
				 AddressBook.printEntries(AddressBookManager.addressBookObject.l);
				 break;	
		case 3 : System.out.println("Displaying Available Person Number List");
				 AddressBookManager.addressBookObject.personsNameList.display();
				 System.out.println();
				  System.out.println("Enter the number of the person to delete the person from the"
				+ "Address Book ");
				  phoneNumber=Utility.getString();
				  AddressBookManager.addressBookObject.deletePerson(phoneNumber);
				  break;	
		case 4 : 
		        AddressBookManager.addressBookObject.sortEntriesByLastName(AddressBookManager.addressBookObject.l);
		        break;
		case 5 : 
	        	AddressBookManager.addressBookObject.sortEntriesByPhoneNumber(AddressBookManager.addressBookObject.l);
	        	break;
		case 0 : addressBookStatus=false;
				System.out.println("Closing Address Book \n");
        		 break;	    	
		default : System.out.println(" Entered option is wrong ");
		}
 }
 }
}
