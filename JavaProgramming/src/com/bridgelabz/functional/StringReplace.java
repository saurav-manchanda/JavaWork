/*********************************************************************************
 * 
 * Purpose: User Input and Replace String Template “Hello <<UserName>>, How are you?

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 16/05/2018
 *********************************************************************************/
package com.bridgelabz.functional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.bridgelabz.utility.Utility;

/**
 * @author Saurav: Class to replace the string with username
 */
public class StringReplace {
	private static String REGEX="\\<[^\\<]*\\>";
	   private static String userName ;
	   private static String temp;

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter your name:");
		userName = utility.inputString();// getting input from the user
		System.out.println("Enter the input string including angular brackets");
		temp=utility.inputString();
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(temp); 
	    temp= m.replaceAll(userName);
		
        System.out.println(temp);
		
	}

}
