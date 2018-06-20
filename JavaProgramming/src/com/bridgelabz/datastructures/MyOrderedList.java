/********************************************************************************* *
 * Purpose: Read   .a   List   of   Numbers   from   a   file   and   arrange   it   ascending   Order   in   a 
Linked   List.   Take   user   input   for   a   number,   if   found   then   pop   the   number   out   of   the 
list   else   insert   the   number   in   appropriate   position
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 25/05/2018
 *********************************************************************************/
package com.bridgelabz.datastructures;

import java.io.IOException;
import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class Ordered List
 */
public class MyOrderedList {
	static String string= "/home/bridgelabz/Documents/file1";
	public static void main(String[] args) throws IOException {
		Utility utility=new Utility();
		MyLinkedList<Integer> myLinkedList= new MyLinkedList<Integer>();
		Integer[] arr=Utility.fileWriterIntegers(string);
		for(int i=0;i<arr.length;i++)
		{
			myLinkedList.add(arr[i]);
		}
		myLinkedList.sortList(myLinkedList);
		myLinkedList.display();
		System.out.println("Enter the number you want to search:");
		Integer number= utility.inputInt();
		int index=myLinkedList.search(number);
		if(index>=0)
		{
			myLinkedList.pop(index);
		}
		else
		{
			myLinkedList.add(number);
			
		}
		myLinkedList.sortList(myLinkedList);
		myLinkedList.display();
	}
	
}
