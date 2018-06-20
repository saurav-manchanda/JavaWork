/********************************************************************************* *
 * Purpose: Take a range of 0 to 1000 Numbers and   find   the   Prime   numbers   in   that   range.   Store  
the prime numbers   in   a   2D   Array,   the   first   dimension   represents   the   range   0­100,  
100­200,   and   so   on.   While   the   second   dimension   represents   the   prime   numbers   in  
that   range.
 * @author Saurav Manchanda
 * @version 1.0
 * @since 29/05/2018
 *********************************************************************************/
package com.bridgelabz.datastructures;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class Prime2Darray
 */
public class Prime2DArrays {

	public static void main(String[] args) {
		Utility utility = new Utility();
		MyLinkedList array[][] = new MyLinkedList[11][];
		for (int i = 0; i < 10; i++) {
			array[i] = new MyLinkedList[100];
			for (int j = 0; j < 100; j++) {
				array[i][j] = new MyLinkedList();
			}
		}

		for (int i = 0; i < 10; i++) {
			int k = 0;
			for (int j = 100 * i; j < 100 * (i + 1); j++) {

				if (utility.isPrimeNumber(j) == true) {
					array[i][k].add(j);
					k++;
				}
			}
		}
		for (int i = 0; i < 10; i++) {
			System.out.println("");
			System.out.print(i + " " + " | ");
			for (int j = 0; j < 100; j++) {

				array[i][j].display();
			}
			System.out.println();
		}

	}

}
