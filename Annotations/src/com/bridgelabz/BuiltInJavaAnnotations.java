/********************************************************************************* *
 * Purpose: To show use of built in annotations in java using basic program
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 22/06/2018
 *********************************************************************************/
package com.bridgelabz;

import java.util.Scanner;

/**
 * @author Saurav:
 * Class Book
 */
class Book{
	public void bookName() {
		System.out.println("Hindi Vyakaran");
	}
}
/**
 * @author Saurav:
 * Class to show the use of Built in Java Annotations
 */
public class BuiltInJavaAnnotations extends Book{
	@Override
	public void bookName()// Overrided method thats why @overriding is used
	{
		System.out.println("English grammar");
	}
	@Deprecated
	public void inputString()//We should not use this method because it is deprecated
	{
		System.out.println("Please enter a String");
		@SuppressWarnings("resource")//scan should be closed..thats why to supress the warning we use this
		Scanner scan=new Scanner(System.in);
		String string=scan.next();
		System.out.println("The Entered Strings is "+ string);
	}
	
	public static void main(String[] args) {
		BuiltInJavaAnnotations bin= new BuiltInJavaAnnotations();
		bin.bookName();
		bin.inputString();
	}
}
