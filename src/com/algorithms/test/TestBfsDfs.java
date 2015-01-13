package com.algorithms.test;

import com.practice.algorithms.BTNode;
import com.practice.algorithms.BfsDfsTreeConstruction;

public class TestBfsDfs {
  public static void main(String args[]) {
  BfsDfsTreeConstruction bfsDfs = new BfsDfsTreeConstruction();
  char[] bfs = {'a','b','c','d','g','e','f','h','i','j'};
  char[] dfs = {'a','b','d','e','f','c','g','h','j','i'};
  BTNode root = bfsDfs.constructTree(bfs, dfs);
  System.out.println("Preorder Traversal");
  System.out.println("===================");
  inOrder(root);
  }
  
  public static void inOrder(BTNode node) {
    if(node == null)
      return;
    inOrder(node.getLeft());
    System.out.print(node.getValue());
    inOrder(node.getRight());
  }
}
