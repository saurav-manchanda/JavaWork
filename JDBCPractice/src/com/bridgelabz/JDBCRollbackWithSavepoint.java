package com.bridgelabz;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import javax.sql.DataSource;

/**
 * @author Saurav:
 * Class to define an example of JDBC transaction rollback with using Savepoint	
 */
public class JDBCRollbackWithSavepoint {
	public static void main(String[] args) {
		DataSource ds = null;
		ds = DataSourceFactory.getMySQLDataSource();
		Connection con = null;
		Statement st = null;
		Savepoint sp=null;
		String query1 = "insert into capgenimi.facebook values('Saurav Manchanda','saurav123')";
		String query2 = "insert into capgenimi.student values(1100, 'Saurav Manchanda', 'fifth', 33)";
		String query3 = "insert into capgenimi.employee values(129,'SatyaJeet','CEO')";
		try {

			con = ds.getConnection();
			st = con.createStatement();
			con.setAutoCommit(false);// Making Autocommit false so that now where we want to commit we can commit..
			st.executeUpdate(query1);
			System.out.println("First Operation!!");
			sp=con.setSavepoint();
			st.executeUpdate(query2);
			System.out.println("Second Operation!!");
			st.executeUpdate(query3);
			System.out.println("Third operation!!");

		} catch (SQLException e) {
			System.out.println("rolled back");
			try {
				con.rollback(sp);
				con.commit();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
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
