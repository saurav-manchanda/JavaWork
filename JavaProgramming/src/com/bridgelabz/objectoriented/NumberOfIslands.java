/********************************************************************************* *
 * Purpose: To find the Number of islands. 

 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 8/06/2018
 *********************************************************************************/
package com.bridgelabz.objectoriented;

import com.bridgelabz.utility.Utility;

 /**
 * @author Saurav:
 * Class to find the number of islands 
 */
public class NumberOfIslands {
	static int NUMBER_OF_ISLANDS;
	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter the number of rows:");
		int rows = utility.inputInt();
		System.out.println("Enter the number of columns:");
		int columns = utility.inputInt();
		System.out.println("Enter the elements in an array:(W or L or w or l)");
		String[][] array = new String[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				array[i][j] = utility.inputString();
			}
		}
		System.out.println("the elements are:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (i == 0 || j == 0 || i == rows-1 || j == columns - 1) {

				} 
				else if (array[i][j].equalsIgnoreCase("L") && array[i][j - 1].equalsIgnoreCase("W") && array[i][j + 1].equalsIgnoreCase("W")
						&& array[i - 1][j].equalsIgnoreCase("W") && array[i + 1][j].equalsIgnoreCase("W") && array[i - 1][j - 1].equalsIgnoreCase("W")
						&& array[i - 1][j + 1].equalsIgnoreCase("W") && array[i + 1][j - 1].equalsIgnoreCase("W")
						&& array[i + 1][j + 1].equalsIgnoreCase("W")) {
					NUMBER_OF_ISLANDS++;
				}
			}
		}
		System.out.println("The number of islands are:"+NUMBER_OF_ISLANDS);

	}

}
