/********************************************************************************* *
 * Purpose: To display multiple records from the database
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 20/06/2018
 *********************************************************************************/
package com.bridgelabz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * @author Saurav:
 * Class to display multiple records fetched from the database
 */
public class DisplayMultipleRecords {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		String query = "select * from capgenimi.employees";
		ResultSet set = null;
		try {
			DataSource ds=null;
			ds=DataSourceFactory.getMySQLDataSource();
			con=ds.getConnection();
			pst = con.prepareStatement(query);
			set = pst.executeQuery();
			while (set.next()) {
				int id = set.getInt(1);
				String name = set.getString("empname");
				String branch = set.getString(3);
				System.out.println(id + "  " + name + "  " + branch);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(pst!=null)
			{
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

