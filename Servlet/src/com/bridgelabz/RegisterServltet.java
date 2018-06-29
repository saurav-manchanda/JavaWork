package com.bridgelabz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pst = con.prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, password);
			pst.setString(3, phoneNumber);
			pst.setString(4, email);
			pst.executeUpdate();
			
			//resp.sendRedirect("afterRegister");
			RequestDispatcher rd=req.getRequestDispatcher("afterRegister.jsp");
			rd.forward(req, resp);
		} catch (ClassNotFoundException | SQLException | IOException e) {
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
