package com.algorithms.extremelysimple;

public class VariousSwaps {
  public void swapWithTempVariable(Object x, Object y) {
    Object temp = x;
    x = y;
    y = temp;
    System.out.println("After swapping: x is " + x + " and y is " + y);
  }
  
  public void swapWithOutTempUsingArithmetic(int x, int y) {
    x = x + y;
    y = x - y;
    x = x - y;
    System.out.println("After swapping: x is " + x + " and y is " + y);
  }
  
  public void swapWithOutTempUsingXor(int x, int y) {
    x = x ^ y;
    y = x ^ y;
    x = x ^ y;
  }
  
  public void checkAndSwapWithOutTempUsingXor(int x, int y) {
    if(x != y) {
      x = x ^ y;
      y = x ^ y;
      x = x ^ y;
    }
    System.out.println("After swapping: x is " + x + " and y is " + y);
  }
}
