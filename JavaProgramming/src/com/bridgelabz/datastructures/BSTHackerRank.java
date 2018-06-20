/********************************************************************************* *
 * Purpose: to take number of test cases from the user and tell how many binary trees are possible
 * @author Saurav Manchanda
 * @version 1.0
 * @since 29/05/2018
 *********************************************************************************/
package com.bridgelabz.datastructures;

import com.bridgelabz.utility.Utility;

/**
 * @author Saurav:
 * Class to take number of test cases from the user and tell how many binary trees are possible
 */
public class BSTHackerRank {
	static int NUMBER_OF_TEST_CASES;
	static int BINARY_TREE_POSSIBLE;

	public static void main(String[] args) {
		Utility utility = new Utility();
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println("Enter the number of test cases");
		NUMBER_OF_TEST_CASES = utility.inputInt();
		BINARY_TREE_POSSIBLE = bst.count(NUMBER_OF_TEST_CASES);
		System.out.println("The number of binary trees possible is: " + BINARY_TREE_POSSIBLE);
	}
}
