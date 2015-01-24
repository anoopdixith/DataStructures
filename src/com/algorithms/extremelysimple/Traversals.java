package com.algorithms.extremelysimple;

import com.datastructures.buildingblocks.BinaryTreeNode;

public class Traversals {
  public void inOrder(BinaryTreeNode node) {
    if(node == null)
      return;
    inOrder(node.getLeft());
    System.out.print(node.getData() + ",");
    inOrder(node.getRight());
  }
  
  public void preOrder(BinaryTreeNode node) {
    if(node == null)
      return;
    System.out.print(node.getData()+ ",");
    preOrder(node.getLeft());
    preOrder(node.getRight());
  }
  
  public void postOrder(BinaryTreeNode node) {
    if(node == null)
      return;
    postOrder(node.getLeft());
    postOrder(node.getRight());
    System.out.print(node.getData() + ",");
  }
}
