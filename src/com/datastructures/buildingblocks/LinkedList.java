package com.datastructures.buildingblocks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<AnyType> implements Iterable<AnyType>{

  @Override
  public Iterator<AnyType> iterator() {
    return new LinkedListIterator();
  }
  
  private class LinkedListIterator  implements Iterator<AnyType>
  {
     private LinkedListNode<AnyType> nextNode;

     public LinkedListIterator()
     {
        nextNode = head;
     }

     public boolean hasNext()
     {
        return nextNode != null;
     }

     public AnyType next()
     {
        if (!hasNext()) throw new NoSuchElementException();
        Object res = nextNode.data;
        nextNode = nextNode.next;
        return (AnyType) res;
     }

     public void remove() { throw new UnsupportedOperationException(); }
  }
  private LinkedListNode<AnyType> head;
  
  /*
   * Constructs an empty list
   */
  public LinkedList() {
    head = null;
  }
  
  /*
   * Check for empty list
   */
  public boolean isEmpty() {
    return head == null;
  }
  
  /*
   * Inserts a new node at the beginning of this list.
   */
  public LinkedListNode<AnyType> addFirst(Object data) {
    LinkedListNode<AnyType> node = new LinkedListNode<AnyType>(data);
    node.next = head;
    head = node;
    return head;
  }
  
  /*
   * Returns the first element in the list
   */
  public LinkedListNode<AnyType> getFirst() {
    if(head == null) {
      throw new NoSuchElementException();
    }
    return head;
  }
  
  /*
   * Remove the first element from the list
   */
  public LinkedListNode<AnyType> removeFirst() {
    LinkedListNode<AnyType> temp = getFirst();
    head = head.next;
    return temp;
  }
  
  /*
   * Insert a node to the end of the list
   */
  public LinkedListNode<AnyType> addLast(Object data) {
    if(head == null) {
      return addFirst(data);
    }
    LinkedListNode<AnyType> temp = head;
    while(temp.next != null) {
      temp = temp.next;
    }
    temp.next = new LinkedListNode<AnyType>(data);
    return head;
    }
  
  /*
   * Get the last element
   */
  public LinkedListNode<AnyType> getLast() {
    if(head == null)
      throw new NoSuchElementException();
    LinkedListNode<AnyType> temp = head;
    while(temp.next != null) 
      temp = temp.next;
    return temp;
  }
  
  /*
   * Remove all nodes from the list
   */
  public void removeAll() {
    head = null;
  }
  
  /*
   * Returns true if the list contains the specified element
   */
  public boolean isExist(Object data) {
    if(head == null) {
      return false;
    }
    LinkedListNode<AnyType> temp = head;
    while(temp.next != null) {
      if(temp.data == data)
        return true;
    }
    return false;
  }
  
  /*
   * Same, but another implementation
   */
  public boolean contains(AnyType x) {
    for(AnyType tmp:this)
      if(tmp.equals(x))
        return true;
    return false;
  }
  
  /*
   * Returns the data in the specified position in the list
   */
  public Object atIndex(int index) {
    if(head == null) {
      throw new IndexOutOfBoundsException();
    }
    LinkedListNode<AnyType> temp = head;
    while(index-- > 0) {
      temp = temp.next;
      if(temp == null && index!=0) {
        throw new IndexOutOfBoundsException();
      }
    }
    
    return temp.data;
  }
  
  /*
   * Inserts a new node after a node containing the key
   */
  public LinkedListNode<AnyType> insertAfter(Object data, Object key) {
    if(head == null) {
      throw new NoSuchElementException();
    }
    LinkedListNode<AnyType> temp = head;
    while(temp.next != null) {
      if(temp.data.equals(key)) {
        insertAfterNode(temp, data);
        return head;
      }
    }
    throw new NoSuchElementException();
  }

  public LinkedListNode<AnyType> insertAfterNode(LinkedListNode<AnyType> temp, Object data) {
    LinkedListNode<AnyType> newNode = new LinkedListNode<AnyType>(data);
    LinkedListNode<AnyType> tempNext = temp.next;
    temp.next = newNode;
    newNode.next = tempNext;
    return newNode;
  }
  
  /*
   * Insert a new node before a node containing the key
   */
  public void insertBefore(Object data, Object key) {
    LinkedListNode<AnyType> current = head;
    LinkedListNode<AnyType> previous = null;
    if(head == null) {
      throw new NoSuchElementException();
    }
    if(head.data.equals(key)) {
      addFirst(data);
    }
    
    while(current.next != null && !(current.data.equals(key))) {
      previous = current;
      current = current.next;
    }
    LinkedListNode<AnyType> third = new LinkedListNode<AnyType>(data);
    previous.next = third;
    third.next = current;    
  }
  
  /*
   * Remove the first occurence of the specified element from the list
   */
  public void remove(Object key) {
    if(head == null) {
      throw new RuntimeException("Cannot delete");
    }
    if(head.data.equals(key)) {
      head = head.next;
    }
    LinkedListNode<AnyType> current = head;
    LinkedListNode<AnyType> previous = null;
    while(current.next != null && !(current.data.equals(key))) {
      previous = current;
      current = current.next;
    }
    previous.next = current.next;
    
  }
  
  /*
   * Returns a deep copy of the list in O(n)
   */
  public LinkedList<AnyType> copy(LinkedList<AnyType> original) {
    LinkedListNode<AnyType> temp = original.getFirst();
    LinkedList<AnyType> copied = new LinkedList<AnyType>();
    while(temp.next != null) {
      copied.addFirst(temp.data);
      temp = temp.next;
    }
    return copied.reverse();
  }

  /*
   * Reverse linkedlist O(n)
   */
  public LinkedList<AnyType> reverse() {
    LinkedList<AnyType> list = new LinkedList<AnyType>();
    LinkedListNode<AnyType> temp = head;
    while(temp != null) {
      list.addFirst(temp.data);
      temp = temp.next;
    }
    return list;
  }
  
}
