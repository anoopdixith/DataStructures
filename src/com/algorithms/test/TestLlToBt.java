package com.algorithms.test;

import com.datastructures.buildingblocks.SpecialNode;
import com.practice.algorithms.LlToBt;

public class TestLlToBt {
  public static void main(String args[]) {
    SpecialNode node1 = new SpecialNode(1);
    SpecialNode node2 = new SpecialNode(2);
    SpecialNode node3 = new SpecialNode(3);
    SpecialNode node4 = new SpecialNode(4);
    SpecialNode node5 = new SpecialNode(5);
    SpecialNode node6 = new SpecialNode(6);
    SpecialNode node7 = new SpecialNode(7);
    SpecialNode node8 = new SpecialNode(8);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node7;
    node7.next = node8;
    
    SpecialNode binaryTree = new LlToBt().llToBt(node1);
    levelOrder(binaryTree);
    //nextNodes(binaryTree);
    //anotherNodes(binaryTree);
  }

  private static void nextNodes(SpecialNode binaryTree) {
    System.out.println("Next nodes");
    while(binaryTree != null) {
      System.out.print(binaryTree.value + ",");
      binaryTree = binaryTree.next;
    }
    System.out.println();
  }
  
  private static void anotherNodes(SpecialNode binaryTree) {
    System.out.println("Another Nodes");
    while(binaryTree != null) {
      System.out.print(binaryTree.value + ",");
      binaryTree = binaryTree.another;
    }
    System.out.println();

  }

  private static void levelOrder(SpecialNode node1) {
    if(node1 == null) {
      return;
    }
    int height = height(node1);
    //System.out.println("Height is " + height);
    for(int i=1; i <= height; i++) {
      printValues(node1, i);
    }
    
  }
  
  private static void printValues(SpecialNode node1, int i) {
    if(node1 == null) {
      return;
    }
    if(i == 1) {
      System.out.print(node1.value + ",");
    }
    printValues(node1.next, i-1);
    printValues(node1.another, i-1);
  }

  private static int height(SpecialNode node1) {
    if(node1 == null) {
      return 0;
    }
    int leftHeight = height(node1.next);
    int rightHeight = height(node1.another);
    return leftHeight>rightHeight?leftHeight+1:rightHeight+1;
  }
}
