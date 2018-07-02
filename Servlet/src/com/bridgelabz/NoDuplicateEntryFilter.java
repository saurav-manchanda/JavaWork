/********************************************************************************* *
 * Purpose: A Servlet Filter used to put restrictions for duplicate entries into the database
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 2/07/2018
 *********************************************************************************/
package com.bridgelabz;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.sql.DataSource;

/**
 * Servlet Filter implementation class NoDuplicateEntryFilter
 */
public class NoDuplicateEntryFilter implements Filter {

    /**
     * Default constructor. 
     */
    public NoDuplicateEntryFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String email=request.getParameter("email");
		Connection con=null;
		DataSource ds=null;
		String qry = "select * from registerDB.customers where  email_id=?";
		PreparedStatement pst=null;
		ResultSet rs=null;
		ds=DataSourceFactory.getMySQLDataSource();
		try {
			con=ds.getConnection();
			pst=con.prepareStatement(qry);
			pst.setString(1, email);
			rs=pst.executeQuery();
			if(rs.next()) {
				RequestDispatcher rd= request.getRequestDispatcher("noduplicate.jsp");
				rd.forward(request, response);
			}
			else {
				chain.doFilter(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
