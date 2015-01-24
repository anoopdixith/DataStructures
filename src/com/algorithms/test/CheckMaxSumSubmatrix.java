package com.algorithms.test;

import com.practice.algorithms.MaximumSubmatrixSum;

public class CheckMaxSumSubmatrix {
  public static void main(String args[]) {
    int input[][] = {{1,2,3},{4,5,6},{7,8,9}};
    System.out.println("Max submatrix sum is " + new MaximumSubmatrixSum().maxSubmatrixSum(input, 2, 3));
  }
}
