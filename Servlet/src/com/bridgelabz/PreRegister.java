/********************************************************************************* *
 * Purpose: To make a PreRegister which forward the request to register Servlet. 
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
 * Class used to forward the request to register Servlet
 */
public class PreRegister extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		RequestDispatcher rd= req.getRequestDispatcher("register.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
