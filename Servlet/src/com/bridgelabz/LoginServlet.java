package com.bridgelabz;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse resp ) {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl="jdbc:mysql://localhost:3306?user=root&password=root";
			con = DriverManager.getConnection(dbUrl);
			String sql="select * from registerDB.customers where email_id=? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,email);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			PrintWriter out=resp.getWriter();
			if(rs.next())
			{
				resp.sendRedirect("success.jsp");
			}
			else
			{
				out.print("<h1>Invalid Credentials.. Authentication Failed</h1><br>");
			}
		}
			 catch(Exception e)
		     {
		   	  e.printStackTrace();
		     }
		     finally
		     {
		   	  try
		   	  {
		   		  if(con!=null)
		   		  {
		   			  con.close();
		   		  }
		   		  if(pstmt!=null)
		   		  {
		   			  pstmt.close();
		   		  }
		   		  if(rs!=null)
		   		  {
		   			  rs.close();
		   		  }
		   	  
		   	  }
		   	 catch(SQLException e)
		   	  {
		   		  e.printStackTrace();
		   		  
		   		  }
		     }
		
		}
		}