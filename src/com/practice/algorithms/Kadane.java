package com.practice.algorithms;

public class Kadane {
  public static void main(String args[]) {
    int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println("Maximum subarray sum is " + maxSubArraySum(array));
  }

  private static int maxSubArraySum(int[] array) {
    int maxTillHere = 0;
    int maxAtThisPoint = 0;
    for(int i=0; i < array.length; i++) {
      maxAtThisPoint = (maxAtThisPoint + array[i]) > 0 ? (maxAtThisPoint+ array[i]) : 0;
      maxTillHere = (maxAtThisPoint > maxTillHere) ? maxAtThisPoint : maxTillHere;
    }
    return maxTillHere;
  }
}
