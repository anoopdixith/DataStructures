package com.practice.algorithms;

import java.util.Stack;

import com.datastructures.buildingblocks.BinaryTreeNode;

public class IterativePostOrder {
  public void iterativePostOrder(BinaryTreeNode node) {
    Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
    do {
    while(node != null) {
      if(node.getRight()!=null) {
        stack.push(node.getRight());
      }
      stack.push(node);
      node = node.getLeft();
    }
    
    node = stack.pop();
    if(node.getRight() != null && !stack.isEmpty() && stack.peek()==node.getRight()) {
      stack.pop();
      stack.push(node);
      node = node.getRight();
    }
    else {
      System.out.print(node.getData() + ","); 
      node = null;
    }
      
    }
    while(!stack.isEmpty());
  }
}
