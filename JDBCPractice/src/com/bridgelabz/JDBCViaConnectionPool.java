/********************************************************************************* *
 * Purpose: Example of Connection Pooling
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 21/06/2018
 *********************************************************************************/
package com.bridgelabz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

/**
 * @author Saurav:
 * Class to perform an example of how to use Connection Pooling
 */
public class JDBCViaConnectionPool {
	public static void main(String[] args) {
		DataSource ds=null;
		ds=DataSourceFactory.getMySQLDataSource();
		Connection con=null;
		Statement st= null;
		String query="insert into capgenimi.employees values(122,'Rahul M','Manager director')";
		try {
			con=ds.getConnection();
			st=con.createStatement();
			st.executeUpdate(query);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(st!=null)
			{
				try {
					st.close();
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
