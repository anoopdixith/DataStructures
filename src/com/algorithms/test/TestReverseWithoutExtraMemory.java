package com.algorithms.test;

import com.datastructures.buildingblocks.LinkedListNode;
import com.practice.algorithms.ReverseListWithoutExtraSpace;

public class TestReverseWithoutExtraMemory {
  public static void main(String arfs[]) {
    LinkedListNode<Character> node1 = new LinkedListNode<Character>('a');
    LinkedListNode<Character> node2 = new LinkedListNode<Character>('b');
    LinkedListNode<Character> node3 = new LinkedListNode<Character>('c');
    LinkedListNode<Character> node4 = new LinkedListNode<Character>('d');
    LinkedListNode<Character> node5 = new LinkedListNode<Character>('e');
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    
    ReverseListWithoutExtraSpace rlwex = new ReverseListWithoutExtraSpace();
    rlwex.printInReverseOrder(node1, null);
  }
}
