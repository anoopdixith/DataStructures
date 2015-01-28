package com.algorithms.extremelysimple;

import java.util.*;

public class MaximumSubArray {
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    for(int i=0; i < T; i++) {
      int N = scanner.nextInt();
      int[] arr =  new int[N];
      for(int j=0; j < N; j++) {
        arr[j] = scanner.nextInt();
      }
      findMaxSum(arr);
    }
  }

  private static void findMaxSum(int[] arr) {
    int maxNow = 0;
    int maxSoFar = 0;
    int sum = 0;
    int min = Integer.MIN_VALUE;
    for(int i=0; i < arr.length; i++) {
      maxNow = (maxNow + arr[i]) > 0? maxNow+arr[i]:0;
      maxSoFar = maxNow > maxSoFar?maxNow:maxSoFar;
      if(arr[i] > 0) {
        sum += arr[i];
      }
      if(arr[i] > min && arr[i]<0) {
        min = arr[i];
      }
    }
    System.out.println((maxSoFar==0?min:maxSoFar) + " " + (sum==0?min:sum));
  }
}
