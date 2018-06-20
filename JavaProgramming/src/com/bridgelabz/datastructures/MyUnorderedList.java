/********************************************************************************* *
 * Purpose: Read   the   Text   from   a   file,   split   it   into   words   and   arrange   it   as   Linked   List. 
Take   a   user   input   to   search   a   Word   in   the   List.   If   the   Word   is   not   found   then   add   it 
to   the   list,   and   if   it   found   then   remove   the   word   from   the   List.   In   the   end   save   the 
list   into   a   file 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 23/05/2018
 *********************************************************************************/
package com.bridgelabz.datastructures;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class Unorderd List
 */
public class MyUnorderedList {

	public static void main(String[] args) throws IOException {
		Utility utility= new Utility();
		MyLinkedList<String> myLinkedList= new MyLinkedList<String>();
		String string= "/home/bridgelabz/Documents/file1";
		Utility.fileWriter(string);
		String[] arr= Utility.fileReaderAndSplitter();
		for(int i=0;i<arr.length;i++)
		{
			myLinkedList.add(arr[i]);
		}
		System.out.println("The linked list elements are:");
		myLinkedList.display();
		System.out.println("Enter the word you want to search in file:");
		String word= utility.inputString();
		int index=myLinkedList.search(word);
		if (index>=0){
			
			System.out.println("Now we have to delete the word from Linked List");
			myLinkedList.pop(index);
		}
		else 
		{
			System.out.println("Word Not found but dont worry i am adding this word to the file and list");
			myLinkedList.add(word);
			FileWriter fileWriter=new FileWriter(string);
			BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
			String str="";
			for(int i=0;i<arr.length;i++)
			{
				str=str+" "+arr[i];
			} 
			str+=" " +word;
			bufferedWriter.write(str);
			bufferedWriter.close();
			System.out.println("The word is added to the file and list successfully");
			
		}
		System.out.println("The final Linked List after all operations is:");
		 myLinkedList.display();
	}

}
