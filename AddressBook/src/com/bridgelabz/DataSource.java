/**
 * 
 */
package com.bridgelabz;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author bridgelabz
 *
 */
public class DataSource {
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "root";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/AddressBook?useSSL=false";
	private static final String DB_CLASS = "com.mysql.jdbc.Driver";

	
	private static DataSource dataSource;
	private ComboPooledDataSource comboPooledDataSource;

	private DataSource() throws PropertyVetoException {
		comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setDriverClass(DB_CLASS);
		comboPooledDataSource.setJdbcUrl(DB_URL);
		comboPooledDataSource.setUser(DB_USERNAME);
		comboPooledDataSource.setPassword(DB_PASSWORD);

		comboPooledDataSource.setMinPoolSize(20);
		comboPooledDataSource.setAcquireIncrement(5);
		comboPooledDataSource.setMaxPoolSize(20);
		comboPooledDataSource.setMaxStatements(180);
	}

	public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
		if (dataSource == null) {
			dataSource = new DataSource();
			return dataSource;
		} else {
			return dataSource;
		}
	}

	public Connection getConnection() throws SQLException {
		return this.comboPooledDataSource.getConnection();
	}

}

