/********************************************************************************* *
 * Purpose: To make a bank application havinmg information about the bank account of person.
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 5/07/2018
 *********************************************************************************/
package com.bridgelabz;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * @author Saurav:
 * class Bank Application
 */
public class BankApplication {
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("bankapplication.xml");
		Person person=(Person) context.getBean("person");
		person.display();
		
	}
}
