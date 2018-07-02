/********************************************************************************* *
 * Purpose: To make a Register servlet to follow the registration account functionality
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 2/07/2018
 *********************************************************************************/
package com.bridgelabz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * @author Saurav:
 * Class RegisterServlet used for registration
 */
public class RegisterServltet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String phoneNumber = req.getParameter("phoneNumber");
		String email = req.getParameter("email");
		Connection con = null;
		PreparedStatement pst = null;
		String query = "insert into registerDB.customers(Name,PhnNo,email_id,password) values(?,?,?,?)";
		try {
			DataSource ds=null;
			ds=DataSourceFactory.getMySQLDataSource();
			con=ds.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, phoneNumber);
			pst.setString(3, email);
			pst.setString(4, password);
			pst.executeUpdate();
			
			//resp.sendRedirect("afterRegister");
			RequestDispatcher rd=req.getRequestDispatcher("afterRegister.jsp");
			rd.forward(req, resp);
		} catch (SQLException | IOException e) {
			System.out.println("Exception Caught");
		} finally {
			if (pst != null) {
				try {
					pst.close();
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
