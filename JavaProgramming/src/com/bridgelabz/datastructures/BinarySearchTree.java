/********************************************************************************* *
 * Purpose: Binary Tree Implementation
 * @author Saurav Manchanda
 * @version 1.0
 * @since 29/05/2018
 *********************************************************************************/
package com.bridgelabz.datastructures;

/**
 * @author Saurav:
 * Class to implement binary Search tree
 */
public class BinarySearchTree {

	public BinaryNode root;
/**
 * Constructor
 */
	public BinarySearchTree() {
		this.root = null;
	}
/**
 * MEthod to search a node
 * @param data
 * @return
 */
	public boolean search(int data) {
		BinaryNode current = root;
		while (current != null) {
			if (current.data == data) {
				return true;
			} else if (current.data > data) {
				current = current.leftNode;
			} else {
				current = current.rightNode;
			}
		}
		return false;
	}
/**
 * Method to insert a data node
 * @param data
 */
	public void insert(int data) {
		BinaryNode newNode = new BinaryNode(data);
		if (root == null) {
			root = newNode;
			return;
		}
		BinaryNode current = root;
		BinaryNode parent = null;
		while (true) {
			parent = current;
			if (data < current.data) {
				current = current.leftNode;
				if (current == null) {
					parent.leftNode = newNode;
					return;
				}
			} else {
				current = current.rightNode;
				if (current == null) {
					parent.rightNode = newNode;
					return;
				}
			}
		}
	}
/**
 * Method to display the tree
 * @param root
 */
	public void display(BinaryNode root) {
		if (root != null) {
			display(root.leftNode);
			System.out.print(" " + root.data);
			display(root.rightNode);
		}
	}
/**
 * Method to count the number of tree possible
 * @param count
 * @return
 */
	public int count(int count) {
		 int intsum = 0;
	        if (count == 0 || count == 1) {
	            return 1;
	        } else if (count == 2) {
	            return 2;
	        } else {
	            for (int i = 0; i < count; i++) {
	                intsum = intsum + count(i) * count(count - i - 1);
	            }
	            return intsum;
	        }
	}

}
