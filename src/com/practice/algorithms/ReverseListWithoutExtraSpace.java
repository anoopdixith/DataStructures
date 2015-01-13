package com.practice.algorithms;

import com.datastructures.buildingblocks.LinkedListNode;

public class ReverseListWithoutExtraSpace {
  public <T> void printInReverseOrder(LinkedListNode<T> current, LinkedListNode<T> tail) {
    LinkedListNode<T> next = null;
    while(current != null) {
      next = current.next;
      current.next = tail;
      tail = current;
      current = next;
    }
    
    while(tail != null) {
      System.out.println(tail.data);
      tail = tail.next;
    }
  }
}
