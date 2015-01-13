package com.practice.algorithms;

public class NumberOfOnes {
  
  public static void main(String args[]) {
    long runningCount = 0;
    for(long i=1; i < Long.MAX_VALUE; i++) {
      runningCount+= getOnes(i);
      if(runningCount == i) {
        System.out.println("f(n) == n when n = " + i);
      }
    }
  }

  private static long getOnes(long number) {
    int numberOfOnes = 0;
    while(number > 0) {
      long rem = number % 10;
      if(rem == 1) {
        numberOfOnes++;
      }
      number/=10;
    }
    return numberOfOnes;
  }
}
