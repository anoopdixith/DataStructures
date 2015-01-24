package com.practice.algorithms;

public class LongestIncreasingSubsequence {
  public int longestIncreasingSequenceLength(int[] input) {
    int table[] = new int[input.length];
    for(int i=0; i < input.length; i++) {
      table[i] = 1;
    }
    for(int i=1; i < table.length; i++) {
      
      for(int j = 0; j < i; j++) {
        if(input[i] > input[j] && table[i] < table[j] + 1) {
          table[i] = 1 + table[j];
        }
      }
    }
    int maxValue = Integer.MIN_VALUE;
    for(int i=0; i < table.length; i++) {
      if(table[i] > maxValue) {
        maxValue = table[i];
      }
    }
    //System.out.println(maxValue);
    return maxValue;
  }
  
  public static void main(String args[]) {
    int[] input = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 40};
    LongestIncreasingSubsequence LIS = new LongestIncreasingSubsequence();
    System.out.println(LIS.longestIncreasingSequenceLength(input));
  }
}
