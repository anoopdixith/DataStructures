package com.algorithms.extremelysimple;

import com.datastructures.buildingblocks.LinkedListNode;

public class ReverseLinkedList {
  public <T> LinkedListNode<T> reverseLinkedList(LinkedListNode<T> node) {
    if(node == null) {
      return null;
    }
    if(node.next == null) {
      return node;
    }
    LinkedListNode<T> second = node.next;
    node.next = null;
    LinkedListNode<T> reversedList = reverseLinkedList(second);
    second.next = node;
    return reversedList;
  }
}
