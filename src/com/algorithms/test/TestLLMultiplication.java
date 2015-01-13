package com.algorithms.test;

import com.practice.algorithms.LLMultiplication;
import com.practice.algorithms.MultiplicationNode;

public class TestLLMultiplication {
  public static void main(String args[]) {
    MultiplicationNode node1 = new MultiplicationNode(3);
    node1.next = new MultiplicationNode(4);
    node1.next.next = new MultiplicationNode(7);
    
    MultiplicationNode node2 = new MultiplicationNode(1);
    node2.next = new MultiplicationNode(2);
    node2.next.next = new MultiplicationNode(8);
    
    LLMultiplication llMul = new LLMultiplication();
    MultiplicationNode result = llMul.multiplyLL(node1, node2);
    
    while(result != null) {
      System.out.print(result.value);
      result = result.next;
    }
  }
}
