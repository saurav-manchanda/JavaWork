/********************************************************************************* *
 * Purpose: Dequeue implementation using Linked List
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 26/05/2018
 *********************************************************************************/
package com.bridgelabz.datastructures;

/**
 * @author Saurav:
 * Class to make a Double Ended Queue using Linked List
 */
public class LinkedDequeue<T> {
	Node <T> front,rear;
	int size;
	public LinkedDequeue(){
		front=null;
		rear=null;
		size=0;
	}
	/**
	 * Method to add at first
	 * @param data
	 */
	public void addFirst(T data) {
		Node<T> node1 = new Node<>(data);
		node1.next=front;
		front=node1;
		node1.data=data;
		size++;
	}
	/**
	 * Method to add at Last
	 * @param data
	 */
	public void addLast(T data) {
		Node<T> node1 = new Node<>(data);
		if (front == null && rear == null) {
			front = node1;
			rear = node1;
			size++;
			return;
		}
		Node<T> temp=rear;
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=node1;
		rear=node1;
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
			System.out.print(temp.data+"--->");
			temp = temp.next;
		}
	}
	public T removeFront(){
		if (front == null) {
			return (T) "queue empty";
		}
		Node<T> temp=front;
		front=front.next;
		size--;
		return (T) temp.data;
		
	}
	public T removeRear() {
		Node<T> current= front;
		Node<T> node1=current.next;
		while(node1.next!=null) {
			current=current.next;
			node1=node1.next;
			size--;
		}
		T data=(T) node1.data;
		current.next=null;
		rear=current;
		node1=null;
		size--;
		return data;
	}
	/**
	 * Method to return the size 
	 * @return
	 */
	public int size() {
		return size;
	}
	/**
	 * Method to find whether the queue is empty or not
	 * @return
	 */
	public boolean isEmpty() {
		if(size==0)
			return true;
		else 
			return false;

	}
	
}
