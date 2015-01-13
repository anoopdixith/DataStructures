package com.datastructures.buildingblocks;

/*
 * https://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/code/LinkedList.java
 */
public class LinkedListNode<AnyType> {
	public Object data;
	public LinkedListNode<AnyType> next;
	
	public LinkedListNode(Object data) {
	  this.data = data;
	}
}
