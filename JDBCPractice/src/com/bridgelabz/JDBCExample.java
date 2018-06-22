/********************************************************************************* *
 * Purpose: To perform basic JDBC operations.
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

public class JDBCExample {

	public static void main(String[] args){
		Connection con= null;
		Statement st=null;
		String query="insert into capgenimi.employees values(104, 'Aruna N', 'Product Manager')";
		String query1="update capgenimi.employees set empname ='Vishal Dubbey' where empid=102";
		String query2="update capgenimi.employees set empname='yuga' where empid=103";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			st=con.createStatement();
			st.addBatch(query);
			st.addBatch(query1);
			st.addBatch(query2);
			st.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
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
