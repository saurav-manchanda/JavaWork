/*********************************************************************************
 * Purpose:  Read   in   the   following   message:   Hello   <<name>>,   We   have   your   full 
name   as   <<full   name>>   in   our   system.   your   contact   number   is   91­xxxxxxxxxx. 
Please,let   us   know   in   case   of   any   clarification   Thank   you   BridgeLabz   01/01/2016. 
Use   Regex   to   replace   name,   full   name,   Mobile#,   and   Date   with   proper   value. 

 * @author Saurav Manchanda
 * @version 1.0
 * @since /05/2018
 *********************************************************************************/
package com.bridgelabz.objectoriented;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav: Class to show Regex demonstration
 */
public class RegexDemonstration {
	static String template = "Hello   <<name>>,   We   have   your   full \n"
			+ "name   as   <<fullname>>   in   our   system.   your   contact   number   is   91­-xxxxxxxxxx. \n"
			+ "Please,let   us   know   in   case   of   any   clarification   Thank   you   BridgeLabz   01/01/2016.";
/**
 * Method for replacing particular string word as according to regex in a template
 * @param template
 * @param regex
 * @param replaceWith
 * @return
 */
	public static String regexReplacement(String template, String regex, String replaceWith) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(template);
		template = matcher.replaceAll(replaceWith);
		return template;
	}
	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter the name:");
		String name = utility.inputString();
		System.out.println("Enter your Fullname:");
		String fullName = utility.inputString();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date = dateFormat.format(new Date());
		System.out.println("Enter your phone number:");
		String phnNo = utility.inputString();

		String regex1 = "(\\<<)(name)(\\>>)";
		String regex2 = "(\\<<)(fullname)(\\>>)";
		String regex3 = "(01/01/2016)";
		String regex4 = "(xxxxxxxxxx)";
		template = RegexDemonstration.regexReplacement(template, regex1, name);
		template = RegexDemonstration.regexReplacement(template, regex2, fullName);
		template = RegexDemonstration.regexReplacement(template, regex3, date);
		template = RegexDemonstration.regexReplacement(template, regex4, phnNo);

		System.out.println(template);
	}

}
