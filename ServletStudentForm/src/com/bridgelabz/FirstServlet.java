/********************************************************************************* *
 * Purpose: To make a Servlet performing Student form functionality 
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 2/07/2018
 *********************************************************************************/
package com.bridgelabz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Saurav:
 * Example Servlet making a Student form
 */
public class FirstServlet extends GenericServlet{
	public void service(ServletRequest req,ServletResponse resp) {
		String name=req.getParameter("nm");
		String place=req.getParameter("pl");
		String age= req.getParameter("ag");
		try {
			PrintWriter out=resp.getWriter();
			out.println("<html><body bgcolor='cyan'><h1>Welcome</h1>"+ " " + name+ " to "+ place+ "</body></html>");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}