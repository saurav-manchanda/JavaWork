/********************************************************************************* *
 * Purpose: To make a PreSuccess Servlet which forward the request to success.jsp 
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 2/07/2018
 *********************************************************************************/
package com.bridgelabz;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Saurav:
 * Pre Success Servlet
 */
public class PreSuccess extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		RequestDispatcher rd= req.getRequestDispatcher("success.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
