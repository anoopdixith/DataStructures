package com.practice.algorithms;

import java.util.Stack;

import com.datastructures.buildingblocks.BinaryTreeNode;

public class IterativeInorder {
  public void iterativeInorder(BinaryTreeNode node) {
    Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
    do {
    while(node != null) {
      stack.push(node);
      node = node.getLeft();
    }
    node = stack.pop();
    System.out.print(node.getData()+",");
    node = node.getRight();
    }
    while(!stack.isEmpty() || node!=null);
  }
}
