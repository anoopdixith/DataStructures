package com.practice.algorithms;

public class BTNode {
  protected Object value;
  protected BTNode left;
  protected BTNode right;
  protected BTNode parent;
  
  public BTNode(Object value) {
    this.setValue(value);
    this.setRight(null);
    this.setRight(null);
    this.parent = null;
  }
  public Object getValue() {
    return value;
  }
  public void setValue(Object value) {
    this.value = value;
  }
  public BTNode getLeft() {
    return left;
  }
  public void setLeft(BTNode left) {
    this.left = left;
  }
  public BTNode getRight() {
    return right;
  }
  public void setRight(BTNode right) {
    this.right = right;
  }
  
}
