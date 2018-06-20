/*********************************************************************************
 * 
 * Purpose: to make a generic Linked List
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 16/05/2018
 *********************************************************************************/
package com.bridgelabz.datastructures;


public class  MyLinkedList<T> {
	private Node<T> head = null;
	private int size = 0;
/**
 * Constructor
 * @return
 */
	public MyLinkedList<T> list() {
		return new MyLinkedList<T>();
	}
	/**
	 * Function to add a particular Object
	 * @param data
	 */
	public void add(T data) {
		Node<T> node1 = new Node<T>(data);
		if (head == null) {
			head = node1;
			size++;
			return;
		}
		Node<T> temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node1;
		size++;
	}
/**
 * Function to add at first postion
 * @param data
 */
	public void addFirst(T data) {
		Node<T> node1 = new Node<T>(data);
		node1.next = head;
		head = node1;
		size++;
	}
/**
 * Function to display the Linked List
 */
	public void display() {

		Node<T> temp = head;
		
		while (temp != null) {
			System.out.print("the queue:");
			System.out.println(temp.data+"--->");
			temp = temp.next;
		}
	}
/**
 * Method to insert into linked list at particular position
 * @param data
 * @param index
 */
	public void insert(T data, int index) {
		if (index == 0) {
			addFirst(data);
			return;
		}
		Node<T> node1 = new Node<T>(data);
		int count = 0;
		Node<T> temp = head;
		while (count < index - 1) {
			temp = temp.next;
			count++;
		}
		node1.next = temp.next;
		temp.next = node1;
		size++;
	}
/**
 * Mehtod to return the size of list
 * @return
 */
	public int size() {
		return size;
	}
/**
 * Method to find whether the list is empty or not
 * @return
 */
	public boolean isEmpty() {
		if(size==0)
			return true;
		else 
			return false;

	}
	/**
	 * Method to remove the element at a particular index
	 * @param index
	 * @return
	 */
	public T pop(int index) {
		if(index==0)
		{
			T temp=head.data;
			head=head.next;
			size--;
			return temp;
		}
		Node<T> t=head;
		int count=0;
		while(count<index-1)
		{
			t=t.next;
			count++;
		}
		T temp=t.next.data;
		t.next=t.next.next;
		size--;
		return temp;
	}
	/**
	 * Method to search a data in the list
	 * @param data
	 * @return the index position
	 */
	public int search(T data) {
        if(head.data.equals(data)) {
            return 0;
        }
        Node<T> temp=head;
        int count=0;
        while(temp.next!=null) {
            temp=temp.next;
            count++;
            if(temp.data.equals(data)) {
                System.out.println("word is present at : "+count);
                return count;
            }
        }
       return -1;
    }
	/**
	 * Method to convert from list to array
	 * @param myLinkedList reference
	 * @return an integer array
	 */
	 public Integer[] listToArray(MyLinkedList<T> myLinkedList)
	 {
		 Integer[] arr=new Integer[50];
		 Node<T> temp=head;
		 while(temp!=null)
		 {
			 for(int i=0;i<myLinkedList.size();i++)
			 {
				 arr[i]=(Integer)temp.data;
			 temp=temp.next;
			 }
		 }
		 return arr;
	 }
	 /**
	  * To get data at a particular index
	  * @param location
	  * @return data at poarticular position
	  */
	 public T get(int index) {
			Node<T> tempCurrent = head;
			int tempPosition = 0;
			
			while(tempPosition != index){
				tempCurrent = tempCurrent.next;
				tempPosition++;
			}
			
			return tempCurrent.data;
			
		}
	 /**
	  * Method to remove the element from the list
	  * @param data
	  */
	public void remove(T data) {
		int index=0;
		Node<T> temp=head;
		if(!temp.data.equals(data))
		{
			index++;
			temp=temp.next;
		}
		pop(index);	
	}
	/**
	 * Method to sort the linked list according to ascending order
	 * @param list
	 */
	public void sortList( MyLinkedList<T> list) {
		Node<T> node = head;
		for(int i=0;i<size-1;i++) {
			for(int j=i+1;j<size;j++) {
				if((Integer)node.data>(Integer)(node.next.data))
				{
					T swap= (T) node.data;
					node.data=node.next.data;
					node.next.data=swap;
				}
				node=node.next;
			}
			node=head;
		}
}
}
