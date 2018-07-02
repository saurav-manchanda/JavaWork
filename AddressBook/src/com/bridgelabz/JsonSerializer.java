package com.bridgelabz.simpleaddressbook.serializer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgeLabz.Utility.Utility;
import com.bridgelabz.simpleaddressbook.AddressBook;
import com.bridgelabz.simpleaddressbook.AddressBookManager;
import com.bridgelabz.simpleaddressbook.AddressBookSerializer;
import com.bridgelabz.simpleaddressbook.Persons;
import com.bridgelabz.simpleaddressbook.service;
@service(value="json")
public class JsonSerializer implements AddressBookSerializer {

	static String[] list;

	@SuppressWarnings("unchecked")
	public void save() {

		System.out.println(" Enter the  Addrress Book Name to save  ");
		String addressBookName = Utility.getString();
		if (AddressBookManager.addressBookNameList.search(addressBookName) == true) {
			int index = AddressBookManager.addressBookNameList.index(addressBookName);
			//System.out.println("Index " + index);
			JSONArray ar = new JSONArray();
			for (int i = 0; i < AddressBookManager.addressBookList.get(index - 1).l.size(); i++) {
				JSONObject ob = new JSONObject();
				ob.put("firstName", AddressBookManager.addressBookList.get(index - 1).l.get(i).getFirstName());
				ob.put("lastName", AddressBookManager.addressBookList.get(index - 1).l.get(i).getLastName());
				ob.put("address", AddressBookManager.addressBookList.get(index - 1).l.get(i).getAddress());
				ob.put("city", AddressBookManager.addressBookList.get(index - 1).l.get(i).getCity());
				ob.put("state", AddressBookManager.addressBookList.get(index - 1).l.get(i).getState());
				ob.put("zip", AddressBookManager.addressBookList.get(index - 1).l.get(i).getZip());
				ob.put("phoneNumber", AddressBookManager.addressBookList.get(index - 1).l.get(i).getPhoneNumber());

				ar.add(ob);
			}
			System.out.println("Saving " + addressBookName + "...");
			File f = new File(
					"/home/administrator/eclipse-workspace/Funtional_Programs/src/com/bridgelabz/simpleaddressbook/"
							+ addressBookName + ".json");
			try {
				f.createNewFile();
				BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(f));
				bufferedwriter.write(ar.toString());
				bufferedwriter.close();
				System.out.println(addressBookName + "File updated succesfully");
			} catch (IOException e) {
				e.printStackTrace();
			}

			String addressBookName1 = "";
			for (int i = 0; i < AddressBookManager.addressBookNameList.size(); i++) {
				addressBookName1 += AddressBookManager.addressBookNameList.get(i).toString() + " ";
			}
			File f1 = new File(
					"/home/administrator/eclipse-workspace/Funtional_Programs/src/com/bridgelabz/simpleaddressbook/fileList");
			try {
				f1.createNewFile();
				BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(f));
				bufferedwriter.write(addressBookName1);
				bufferedwriter.close();
				System.out.println("Address book  File updated succesfully");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void read() {
		list = JsonSerializer.retrieveFileList();
		if (list != null)
			JsonSerializer.recoveringData();
	}

	static void recoveringData() {
		JSONParser parser = new JSONParser();
		for (int i = 0; i < list.length; i++) {
			AddressBookManager.addressBookNameList.add(list[i]);
			AddressBookManager.addressBookObject = new AddressBook();
			AddressBookManager.addressBookList.add(AddressBookManager.addressBookObject);

			try {
				JSONArray a = (JSONArray) parser.parse(new FileReader(
						"/home/administrator/eclipse-workspace/Funtional_Programs/src/com/bridgelabz/simpleaddressbook/"
								+ list[i] + ".json"));
				for (int j = 0; j < a.size(); j++) {
					Persons p = new Persons();
					JSONObject ob = (JSONObject) a.get(j);
					p.setFirstName(ob.get("firstName").toString());
					p.setLastName(ob.get("lastName").toString());
					p.setAddress(ob.get("address").toString());
					p.setCity(ob.get("city").toString());
					p.setState(ob.get("state").toString());
					p.setZip(ob.get("zip").toString());
					p.setPhoneNumber(ob.get("phoneNumber").toString());

					AddressBookManager.addressBookList.get(i).l.add(p);
					AddressBookManager.addressBookList.get(i).personsNameList.add(p.getPhoneNumber());

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static String[] retrieveFileList() {
		File f = new File(
				"/home/administrator/eclipse-workspace/Funtional_Programs/src/com/bridgelabz/simpleaddressbook/fileList");
		FileReader fr = null;
		BufferedReader br = null;
		String[] str = null;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String word = br.readLine();
			while (word != null) {
				str = word.split(" ");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Retrieving All Address Book files....\n");
		System.out.println("Displaying all the address book name from the Data Base ");
		if (str != null) {
			for (int i = 0; i < str.length; i++) {
				System.out.println(str[i]);
			}
		}
		System.out.println();
		return str;
	}
}
