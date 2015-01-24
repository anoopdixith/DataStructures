package com.algorithms.test;

import com.algorithms.extremelysimple.Traversals;
import com.datastructures.buildingblocks.BinaryTreeNode;
import com.practice.algorithms.IterativeInorder;
import com.practice.algorithms.IterativePostOrder;

public class TestRecursiveTraversals {
  public static void main(String args[]) {
    BinaryTreeNode n1 = new BinaryTreeNode(1);
    BinaryTreeNode n2 = new BinaryTreeNode(2);
    BinaryTreeNode n3 = new BinaryTreeNode(3);
    BinaryTreeNode n4 = new BinaryTreeNode(4);
    BinaryTreeNode n5 = new BinaryTreeNode(5);
    BinaryTreeNode n6 = new BinaryTreeNode(6);
    BinaryTreeNode n7 = new BinaryTreeNode(7);
    BinaryTreeNode n8 = new BinaryTreeNode(8);
    n1.setLeft(n2);
    n1.setRight(n3);
    n2.setLeft(n4);
    n2.setRight(n5);
    n3.setLeft(n6);
    n3.setRight(n7);
    n4.setLeft(n8);
    
    Traversals traversals = new Traversals();
    //System.out.println("InOrder");
    //traversals.inOrder(n1);
    //System.out.println("\n\nPre");
    //traversals.preOrder(n1);
    System.out.println("\n\npost");
    traversals.postOrder(n1);
    //System.out.println("\nin order iteration");
    //new IterativeInorder().iterativeInorder(n1);
    System.out.println("\npost order iteration");
    new IterativePostOrder().iterativePostOrder(n1);
  }
}
