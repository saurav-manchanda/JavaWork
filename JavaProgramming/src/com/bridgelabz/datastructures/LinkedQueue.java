/********************************************************************************* *
 * Purpose: Queue implementation using Linked List
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 25/05/2018
 *********************************************************************************/
package com.bridgelabz.datastructures;

/**
 * @author Saurav: Class to make Queue using Linked List concept
 * @param <T>
 */
public class LinkedQueue<T> {
	Node<T> front, rear;
	int size;
/**
 * Constructor to create an empty queue
 */
	public LinkedQueue() {
		front = null;
		rear = null;
		size = 0;
	}
/**
 * method to enter a node in the queue
 * @param data
 */
	public void enqueue(T data) {
		Node<T> n1 = new Node<>(data);
		if (front == null && rear == null) {
			front = n1;
			rear = n1;
			size++;
			return;
		}
		Node<T> t = rear;
		while (t.next != null) {
			t = t.next;
		}
		t.next = n1;
		rear = t;
		size++;
	}
/**
 * Method to display the queue
 */
	public void display() {
		if (size == 0) {
			System.out.println("Linked List is empty");
			return;
		}
		Node<T> temp = front;
		System.out.println("The queue:");
		while (temp != null) {
			System.out.print(temp.data + "--->");
			temp = temp.next;
		}
	}
/**
 * Method to remove a node from the queue
 * @return
 */
	public T dequeue() {
		if (front == null) {
			return (T) "queue empty";
		}
		T data = front.data;
		front = front.next;
		if (front == null) {
			rear = null;
		}
		size--;
		return data;
	}
/**
 * Method to find the size of the queue
 * @return size of the queue
 */
	public int size() {
		return size;
	}
/**
 * Method to find whether the file is empty or not
 * @return boolean 
 */
	public boolean isEmpty() {
		if (front == null) {
			return true;
		}
		return false;
	}
/**
 * Method for displaying the contents of the queue in reverse order and that too in pairs as a pair is a prime annagram pair 
 */
	public void display1() {
		if (size == 0) {
			System.out.println("Linked List is empty");
			return;
		}
		Integer[] array = new Integer[size];
		Node<T> temp = front;
		System.out.println("The queue annagram prime pairs:");
		for (int i = 0; i < size && temp != null; i++) {
			array[i] = (Integer) temp.data;
			temp = temp.next;
		}
		for(int i=size-1;i>=0;i=i-2) {
			System.out.println("["+array[i]+","+array[i-1]+"]");
			
		}
	}
	

}
