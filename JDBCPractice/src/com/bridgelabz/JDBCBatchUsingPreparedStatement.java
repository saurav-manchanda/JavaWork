package com.bridgelabz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.bridgelabz.DataSourceFactory;

public class JDBCBatchUsingPreparedStatement {

	public static void main(String[] args) {
		DataSource ds=null;
		ds=DataSourceFactory.getMySQLDataSource();
		Connection con=null;
		PreparedStatement pst=null;
		PreparedStatement pst1=null;
		PreparedStatement pst2=null;
		String query="insert into capgenimi.employees values(121, 'Shweta', 'Software Engineer')";
		String query1="update capgenimi.employees set empname ='Saurav Manchanda' where empid=110";
		String query2="delete from capgenimi.employees where empid=120";
		try {
			con=ds.getConnection();
			pst=con.prepareStatement(query);
			pst1=con.prepareStatement(query1);
			pst2=con.prepareStatement(query2);
			pst.addBatch(query);
			pst.addBatch(query1);
			pst.addBatch(query2);//but pst only loading query initially!! Therefore we have to make different batches for one type of query.
			int array[]=pst.executeBatch();//n number of queries --> n number of batches... NOT A GOOD PRACTICE
			for(int x: array)
			{
				System.out.println(x);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
