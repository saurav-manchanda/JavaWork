package com.bridgelabz;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MySessionListener
 *
 */
@WebListener
public class MySessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public MySessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
    	Date date=new Date();
    	SimpleDateFormat todayDate=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
         System.out.println("Session is created at"+ todayDate.format(date));
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stubDate date=new Date();
    	Date date=new Date();
    	SimpleDateFormat todayDate=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("Session ended at"+ todayDate.format(date));
    }
	
}
