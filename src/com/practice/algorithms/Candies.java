package com.practice.algorithms;

import java.util.Scanner;

public class Candies {
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    long[] input = new long[T];
    for(int i=0; i < T; i++) {
      input[i] = scanner.nextLong();
    }
    for(int i=0; i < T; i++) {
      countChildren(input[i]);
    }
  }

  private static void countChildren(long limit) {
      //long countLimit = ((long)(Math.sqrt(limit)))+1;
      long countLimit = limit/2;
      if(countLimit == 0) {
        countLimit = 1;
      }
      for(long i=1; i <= limit; i++) {
        if(sumOfSquares(i) > limit) {
          System.out.println(i-1);
          break;
        }
        else if(sumOfSquares(i) == limit) {
          System.out.println(i);
          break;
        }
      }
  }

  private static long sumOfSquares(long i) {
    return i * (i+1) * (2 * i + 1) / 6;
  }
}
