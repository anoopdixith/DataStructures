package com.practice.algorithms;

public class NumberOfConsecutiveStrings {
  public int numberOfConsecutiveStrings(int n) {
    if(n == 1) 
      return 2; 
    int[] a = new int[n+1];
    int[] b = new int[n+1];
    a[1] = 1; b[1] = 1;
    for(int i=2; i <= n; i++) {
      a[i] = a[i-1] + b[i-1];
      b[i] = a[i-1];
    }
    return a[n] + b[n];
  }
}
