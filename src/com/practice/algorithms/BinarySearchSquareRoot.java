package com.practice.algorithms;

public class BinarySearchSquareRoot {
  public static void main(String args[]) {
    BinarySearchSquareRoot bin = new BinarySearchSquareRoot();
    int input = 61;
    System.out.println(bin.getSquareRoot(input, 1, input/2));
  }

  private int getSquareRoot(int input, int low, int high) {
    if(high < low) 
      return -1;
    int mid = low + (high - low) /2;
    if(mid * mid == input) 
      return mid;
    if(mid*mid < input) 
       return getSquareRoot(input, mid, high); 
    return getSquareRoot(input, low, mid);
  }
}
