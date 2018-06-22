/********************************************************************************* *
 * Purpose: To insert a record into the database via PreparedStatement
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 21/06/2018
 *********************************************************************************/
package com.bridgelabz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;


/**
 * @author Saurav:
 * Class to insert a record using Prepared Statement Interface
 */
public class InsertionViaPreparedStatement {
	public static void main(String[] args) {
		DataSource ds=null;
		ds=DataSourceFactory.getMySQLDataSource();
		Connection con=null;
		PreparedStatement pst=null;
		String query="insert into capgenimi.employees values(?,?,?)";
		try {
			con=ds.getConnection();
			pst=con.prepareStatement(query);
			pst.setInt(1, 111);
			pst.setString(2, "Anamika");
			pst.setString(3, "Intern");
			pst.executeUpdate();
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
