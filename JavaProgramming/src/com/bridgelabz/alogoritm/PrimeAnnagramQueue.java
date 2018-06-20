/********************************************************************************* *
 * Purpose: Add   the   Prime   Numbers   that   are   Anagram   in   the   Range   of   0   ­   1000   in   a   Queue   using  
the   Linked   List   and   Print   the   Anagrams   from   the   Queue.
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 29/05/2018
 *********************************************************************************/
package com.bridgelabz.alogoritm;

import com.bridgelabz.datastructures.LinkedQueue;
import com.bridgelabz.datastructures.MyLinkedList;
import com.bridgelabz.utility.Utility;
/**
 * @author Saurav:
 * Class to display Prime Anagram pairs in a queue in reverse order
 */
public class PrimeAnnagramQueue {

	public static void main(String[] args) {
		LinkedQueue<Integer> queue=new LinkedQueue<>();
		Utility utility = new Utility();
		MyLinkedList array[][] = new MyLinkedList[11][];
		for (int i = 0; i < 10; i++) {
			array[i] = new MyLinkedList[100];
			for (int j = 0; j < 100; j++) {
				array[i][j] = new MyLinkedList<Integer>();
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 100 * i; j < 100 * (i + 1) - 1; j++) {
				
				if (utility.isPrimeNumber(i) == true) {
					for (int m = j + 1; m < 100 * (i + 1); m++) {
						if (utility.isAnnagram(("" + j), ("" + m)) == true) {
							queue.enqueue(j);
							queue.enqueue(m);
						}
					}
				}
			}
		}
		queue.display1();

	}

}
