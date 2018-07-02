/********************************************************************************* *
 * Purpose: To make a servlet for login purpose.
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 2/07/2018
 *********************************************************************************/
package com.bridgelabz;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
/**
 * @author Saurav
 * Class LoginServlet extending HttpServlet 
 */
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse resp ) {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			DataSource ds=null;
			ds=DataSourceFactory.getMySQLDataSource();
			con=ds.getConnection();
			String sql="select * from registerDB.customers where email_id=? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,email);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			PrintWriter out=resp.getWriter();
			if(rs.next())
			{
				HttpSession session=req.getSession();
				session.setMaxInactiveInterval(24*60*60);
				session.setAttribute("EMAIL", email);
				RequestDispatcher rd = req.getRequestDispatcher("PreSuccess");
				rd.forward(req, resp);
			}
			else
			{
				RequestDispatcher rd = req.getRequestDispatcher("PreFailure");
				rd.forward(req, resp);
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