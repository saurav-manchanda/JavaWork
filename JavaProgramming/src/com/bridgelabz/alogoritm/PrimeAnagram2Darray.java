package com.bridgelabz.alogoritm;

import com.bridgelabz.datastructures.MyLinkedList;
import com.bridgelabz.utility.Utility;

public class PrimeAnagram2Darray {

	public static void main(String[] args) {
MyLinkedList<Integer> array[][] = new MyLinkedList[11][];
		Utility utility= new Utility();
		for (int i = 0; i < 10; i++) {
			array[i] = new MyLinkedList[100];
			for (int j = 0; j < 100; j++) {
				array[i][j] = new MyLinkedList();
			}
		}
		System.out.println("The annagram prime number pars in the corresponding group:");
		for (int i = 0; i < 10; i++) {
			System.out.println(i+ "group");
			for (int j = 100 * i; j < 100 * (i + 1) - 1; j++) {
				int k = 0;
				if ( utility.isPrimeNumber(i)== true) {
					for (int m = j + 1; m < 100 * (i + 1); m++) {
						if (utility.isAnnagram(("" +j), ("" + m)) == true) {
							array[i][k].add(j);
							k++;
							System.out.println("["+j+","+m+"]");
						}
					}
				}
			}
		}
	}
}
