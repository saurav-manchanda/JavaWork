/********************************************************************************* *
 * Purpose: Stack implementation using Linked List
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 25/05/2018
 *********************************************************************************/
package com.bridgelabz.datastructures;

/**
 * @author Saurav: Class LinkedStack
 * @param <T>
 */
public class LinkedStack<T> {
	Node<T> top;
	int size;

	/**
	 * For adding a node on top
	 * 
	 * @param data
	 */
	public void push(T data) {
		Node<T> node = new Node<T>(data);
		if (top == null) {
			top = node;
			size++;
			return;
		}
		node.next = top;
		top = node;
		size++;
	}

	/**
	 * For removing a node from the top
	 * 
	 * @return
	 */
	public T pop() {
		if (top == null) {
			System.out.println("stack empty");
			return null;
		}
		Node<T> node1 = top;
		top = node1.next;
		size--;
		return node1.data;
	}

	/**
	 * Function to return the top element
	 * 
	 * @return
	 */
	public T peek() {
		if (top == null) {
			System.out.println("stack empty");
			return null;
		}
		Node<T> node1 = top;
		return node1.data;
	}

	/**
	 * For checking whether the stack is empty.
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		if (top == null) {
			return true;
		} else
			return false;
	}

	/**
	 * For getting the size of stack
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * Method to display the stack
	 */
	public void display() {
		if (size == 0) {
			System.out.println("Linked List is empty");
			return;
		}
		Node<T> temp = top;
		System.out.println("The stack:");
		while (temp != null) {
			System.out.print(temp.data+"-->");
			temp = temp.next;
		}	
	}
	/**
	 * Method for dislaying annagram prime pairs in the reverse order as according to the question
	 */
	public void display1() {
		if (size == 0) {
			System.out.println("Linked List is empty");
			return;
		}
		Node<T> temp = top;
		System.out.println("The stack annagram pairs:");
		while (temp != null) {
			System.out.println("["+temp.data+","+temp.next.data+"]");
			temp = temp.next.next;
		}
	}
}