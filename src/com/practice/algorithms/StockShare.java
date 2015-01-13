package com.practice.algorithms;

public class StockShare {
  public int[] buySell(int arr[]) {
    int[] values = new int[2];
    int bottom = arr[0];
    int max = Integer.MIN_VALUE;
    int diff = 0;
    int maxDiff = Integer.MIN_VALUE;
    for(int i=1; i < arr.length; i++) {
      diff += arr[i] - arr[i-1];
      if(diff > maxDiff) {
        maxDiff = diff;
        max = arr[i];
      }
      if(bottom > arr[i]) {
        bottom = arr[i];
        diff = 0;
      }
    }
    values[0] = max - maxDiff;
    values[1] = max;
    return values;
  }
}
