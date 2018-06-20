package com.bridgelabz;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class JDBCTransactionRollback {
	public static void main(String[] args) {
		DataSource ds = null;
		ds = DataSourceFactory.getMySQLDataSource();
		Connection con = null;
		Statement st = null;
		String query1 = "insert into capgenimi.facebook values('Saurav Manchanda','saurav123')";
		String query2 = "insert into capgenimi.student values(1100, 'Saurav Manchanda', 'fifth', 33)";
		String query3 = "insert into capgenimi.employee values(129,'SatyaJeet','CEO')";
		try {

			con = ds.getConnection();
			st = con.createStatement();
			con.setAutoCommit(false);// Making Autocommit false so that now where we want to commit we can commit..
			st.executeUpdate(query1);
			System.out.println("First Operation!!");
			st.executeUpdate(query2);
			System.out.println("Second Operation!!");
			st.executeUpdate(query3);
			System.out.println("Third operation!!");
			con.commit();

		} catch (SQLException e) {
			System.out.println("rolled back");
			try {
				con.rollback();
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
