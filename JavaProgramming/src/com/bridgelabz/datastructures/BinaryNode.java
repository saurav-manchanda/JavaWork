/********************************************************************************* *
 * Purpose: To create a node so that we can use it in binary tree
 * @author Saurav Manchanda
 * @version 1.0
 * @since 29/05/2018
 *********************************************************************************/
package com.bridgelabz.datastructures;

/**
 * @author Saurav:
 * Class to create a Binary Node
 */
public class BinaryNode {
		int data;
		BinaryNode leftNode;
		BinaryNode rightNode;

		public BinaryNode(int data) {
			this.data = data;
			leftNode = null;
			rightNode = null;
		}
}
