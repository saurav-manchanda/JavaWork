/********************************************************************************* *
 * Purpose: Queue implementation using Arrays
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 25/05/2018
 *********************************************************************************/
package com.bridgelabz.datastructures;

/**
 * @author Saurav:
 * Class to make a stack using array concept
 * @param <T>
 */
public class Queue<T> {
	public Object[] obj;
	public Integer size;
	public Integer front = -1, rear = -1;

	/**
	 * Function to create new empty list.
	 * 
	 * @return empty queue.
	 */
	public Queue() {
		@SuppressWarnings("unused")
		Queue<T> queue = new Queue<T>();
	}

	/**
	 * Function to create new empty list of specified size.
	 * 
	 * @param size
	 */
	public Queue(Integer size) {
		this.size = size;
		obj = new Object[size];
	}

	/**
	 * Function is to add object in the queue.
	 * 
	 * @param data
	 */
	public void enqueue(Object data) {
		if (rear == size - 1) {
			System.out.println("Queue is full");
			return;
		}
		if (rear == -1 && front == -1) {
			front++;
		}
		obj[++rear] = data;
	}

	/**
	 * Function is to remove element from Queue.
	 * 
	 * @return temp.
	 */
	public Object dequeue() {
		if (front == -1) {
			System.out.println("Queue is Empty");
			return null;
		}
		if (front > rear) {
			front = rear - 1;
			System.out.println("Queue is Empty");
		}
		Object temp = obj[front];
		front++;
		return temp;
	}

	/**
	 * Function is to display all the elements in Queue.
	 */
	public void display() {
		for (int i = front; i <= rear; i++) {
			System.out.println(obj[i]);
		}
	}

	/**
	 * Function to check peek element.
	 * 
	 * @return peek element
	 */
	public Object peek() {
		if (front == -1) {
			System.out.println("Queue is Empty");
			return null;
		}
		return obj[front];

	}

	/**
	 * @return size of queue
	 */
	public Integer size() {
		return size;
	}
}
