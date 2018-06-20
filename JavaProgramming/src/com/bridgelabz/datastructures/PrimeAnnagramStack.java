/********************************************************************************* *
 * Purpose: the   Prime   Number   Program   and   store   only   the   numbers   in   that   range   that   are  
Anagrams.   For   e.g.   17   and   71   are   both   Prime   and   Anagrams   in   the   0   to   1000   range.  
Further   store   in   a   2D   Array   the   numbers   that   are   Anagram   and   numbers   that   are   not  
Anagram 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 29/05/2018
 *********************************************************************************/
package com.bridgelabz.datastructures;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to make the Prime Number Program and store only the numbers in that range that are anagrams.  
 */
public class PrimeAnnagramStack {
	public static void main(String[] args) {
		LinkedStack<Integer> linkedStack = new LinkedStack<>();
		MyLinkedList array[][] = new MyLinkedList[11][];
		Utility utility = new Utility();
		for (int i = 0; i < 10; i++) {
			array[i] = new MyLinkedList[100];
			for (int j = 0; j < 100; j++) {
				array[i][j] = new MyLinkedList<Integer>();
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 100 * i; j < 100 * (i + 1) - 1; j++) {
				for (int m = j + 1; m < 100 * (i + 1); m++) {
				if (utility.isPrimeNumber(j) == true && utility.isPrimeNumber(m)==true) {
						if (utility.isAnnagram(("" + j), ("" + m)) == true) {
							linkedStack.push(j);
							linkedStack.push(m);
						}
					}
				}
			}
		}
		linkedStack.display1();
	}

}
