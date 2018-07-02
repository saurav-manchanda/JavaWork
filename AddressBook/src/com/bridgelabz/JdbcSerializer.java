package com.bridgelabz.simpleaddressbook.serializer;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bridgeLabz.Utility.Utility;
import com.bridgelabz.simpleaddressbook.AddressBook;
import com.bridgelabz.simpleaddressbook.AddressBookManager;
import com.bridgelabz.simpleaddressbook.AddressBookSerializer;
import com.bridgelabz.simpleaddressbook.AddressBookUtility;
import com.bridgelabz.simpleaddressbook.Persons;
import com.bridgelabz.simpleaddressbook.service;
@service(value="jdbc")
public class JdbcSerializer implements AddressBookSerializer {

	@SuppressWarnings("resource")
	public void save() {
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;

		try {
			con = AddressBookUtility.loadAndConnect();
			int count = 0;
			System.out.println(" Enter the  Addrress Book Name to save  ");
			String addressBookName = Utility.getString();
			if (AddressBookManager.addressBookNameList.search(addressBookName) == true) {
				ResultSet rs = null;
				DatabaseMetaData meta = con.getMetaData();
				rs = meta.getTables(null, null, null, new String[] { "TABLE" });
				//String[] tableName = new String[10];
				ArrayList<String> tableName1=new <String>ArrayList();
				int tableIndex = 0;
				boolean tableStatus = false;
				if (rs != null) {
					while (rs.next()) {
						String name = rs.getString("TABLE_NAME");
						System.out.println(name);
//						tableName[tableIndex] = name;
//						tableIndex++;
						tableName1.add(name);
					}
					for (int i = 0; i < tableName1.size(); i++) {
//						if (addressBookName.equals(tableName[i]) == true) {
//							tableStatus = true;
//							break;
//						}
						if (addressBookName.equals(tableName1.get(i)) == true) {
							tableStatus = true;
							break;
						}
					}
					if (tableStatus == false) {
						String query = "create table " + addressBookName
								+ "(firstName varchar(20),lastName varchar(20),address varchar(20),city varchar(20),state varchar(20),zip varchar(20),phoneNumber varchar(10))";
						stmt = con.createStatement();
						count = stmt.executeUpdate(query);
					}
				} else {
					String query = "create table " + addressBookName
							+ "(firstName varchar(20),lastName varchar(20),address varchar(20),city varchar(20),state varchar(20),zip varchar(20),phoneNumber varchar(10))";
					stmt = con.createStatement();
					count = stmt.executeUpdate(query);
				}
				String query = "truncate table " + addressBookName;
				stmt = con.createStatement();
				count = stmt.executeUpdate(query);
			}
			int index = AddressBookManager.addressBookNameList.index(addressBookName);
			for (int i = 0; i < AddressBookManager.addressBookList.get(index - 1).l.size(); i++) {
				String query = "insert into " + addressBookName + " values(?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(query);

				pstmt.setString(1, AddressBookManager.addressBookList.get(index - 1).l.get(i).getFirstName());
				pstmt.setString(2, AddressBookManager.addressBookList.get(index - 1).l.get(i).getLastName());
				pstmt.setString(3, AddressBookManager.addressBookList.get(index - 1).l.get(i).getAddress());
				pstmt.setString(4, AddressBookManager.addressBookList.get(index - 1).l.get(i).getCity());
				pstmt.setString(5, AddressBookManager.addressBookList.get(index - 1).l.get(i).getState());
				pstmt.setString(6, AddressBookManager.addressBookList.get(index - 1).l.get(i).getZip());
				pstmt.setString(7, AddressBookManager.addressBookList.get(index - 1).l.get(i).getPhoneNumber());

				count = pstmt.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("Table not updated");
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {

			}
		}
	}

	public void read() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			int tableCount = 0;
			System.out.println("reding from jdbc ....");
			con = AddressBookUtility.loadAndConnect();

			DatabaseMetaData meta = con.getMetaData();

			rs = meta.getTables(null, null, null, new String[] { "TABLE" });

			while (rs.next()) {

				String tableName = rs.getString("TABLE_NAME");
				System.out.println((tableCount + 1) + ". tableName=" + tableName);
				AddressBookManager.addressBookNameList.add(tableName);
				tableCount++;
			}

			for (int i = 0; i < AddressBookManager.addressBookNameList.size(); i++) {
				AddressBookManager.addressBookObject = new AddressBook();
				AddressBookManager.addressBookList.add(AddressBookManager.addressBookObject);

				String query = "select * from " + AddressBookManager.addressBookNameList.get(i);
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					Persons p = new Persons();
					p.setFirstName(rs.getString("firstName").toString());
					p.setLastName(rs.getString("lastName").toString());
					p.setAddress(rs.getString("address").toString());
					p.setCity(rs.getString("city").toString());
					p.setState(rs.getString("state").toString());
					p.setZip(rs.getString("zip").toString());
					p.setPhoneNumber(rs.getString("phoneNumber").toString());

					AddressBookManager.addressBookList.get(i).l.add(p);
					AddressBookManager.addressBookList.get(i).personsNameList.add(p.getPhoneNumber());
				}
			}

		} catch (Exception e) {

		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {

			}
		}
	}

}
