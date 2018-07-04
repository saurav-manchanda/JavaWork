package com.bridgelabz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class MailServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String to = req.getParameter("to");
		String subject = "To change your password";
		String user = "nohairsobby@gmail.com";
		String password = "alwaysbald";
		String query="select * from registerDB.customers where email_id = ?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pst = con.prepareStatement(query);
			pst.setString(1, to);
			System.out.println(to);
			rs = pst.executeQuery();
			System.out.println(rs);
			if (rs.next()) {
				String message = rs.getString("password");
				System.out.println("enht");
				SendEmail.send(to, subject, message, user, password);
				System.out.println("Email sent successfully");
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (SQLException | IOException | ServletException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
