package com.bridgelabz.simpleaddressbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class AddressBookUtility {
	public static Connection loadAndConnect() {

		Connection con = null;
		Driver driverRef;
		try {

			driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			String dbUrl = "jdbc:mysql://localhost:3306/addressBook?useSSL=false";
			con = DriverManager.getConnection(dbUrl, "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
