/********************************************************************************* *
 * Purpose: Create   a   Slot   of   10   to   store   Chain   of   Numbers   that   belong   to   each   Slot   to 
efficiently   search   a   number   from   a   given   set   of   number 
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 29/05/2018
 *********************************************************************************/
package com.bridgelabz.datastructures;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav: Class to create slots and putting numbers in it according to
 *         given situation
 */
public class HashingFunction {
	static int slots = 10;
	static String filePath = "/home/bridgelabz/Documents/file1";

	public static void main(String[] args) throws IOException {
		Utility utility = new Utility();
		Integer[] myList = Utility.fileWriterIntegers(filePath);

		HashMap<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();
		LinkedList<Integer>[] List = new LinkedList[slots];

		// COMPUTATION
		int Value, SlotNumber;
		for (int i = 0; i < myList.length; i++) {
			Value = myList[i];
			SlotNumber = Value % 11;

			if (List[SlotNumber] == null) {
				List[SlotNumber] = new LinkedList<Integer>();
				map.put(SlotNumber, List[SlotNumber]);
			}
			List[SlotNumber].add(Value);
		}
		System.out.println("Map is:" + map);
		System.out.println("Enter the word to search in the map");
		int number1;
		number1 = utility.inputInt();
			int key = number1 % 11;
			map.remove(key);
			System.out.println("Word removed Successfully");
			// WRITING INTO A FILE
			FileWriter writer = new FileWriter(filePath);
			for (int i = 0; i < map.size(); i++) {
				writer.write(map.get(i) + " ");
				writer.flush();
			}
			writer.close();
			System.out.println("Final Map: " + map);
		
	}

}
