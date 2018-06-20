/*********************************************************************************
 * 
 * Purpose: to make a Node
 * 
 * @author Saurav Manchanda
 * @version 1.0
 * @since 16/05/2018
 *********************************************************************************/
package com.bridgelabz.datastructures;

/**
 * @author Saurav:
 * Class Node
 * @param <T>
 */
public class Node<T> {
public T data;
public Node<T> next;
/**
 * Parameterized Constructor
 * @param data
 */
public Node(T data)
{
	this.data=data;
}
/**
 * Constructor
 */
public Node()
{
	data=null;
}
}
