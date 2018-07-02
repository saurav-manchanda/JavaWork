/********************************************************************************* *
 * Purpose: To make a Servlet used for logout purpose
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
import javax.servlet.http.HttpSession;
/**
 * @author Saurav:
 * Class that is a Servlet and performs operations for logging out from the account
 */
public class LogoutServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			session.invalidate();
		}
		RequestDispatcher rd= req.getRequestDispatcher("Welcome.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
