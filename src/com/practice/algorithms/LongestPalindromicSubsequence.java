package com.practice.algorithms;

import com.google.common.collect.Table;

public class LongestPalindromicSubsequence {
  public static void main(String args[]) {
    char[] arr = {'g','e','e','k','s','k','e'};
    System.out.println("Length of longest palindromic subsequence is " + longestPalinSubseq(arr));
    }

  private static int longestPalinSubseq(char[] arr) {
    boolean[][] longest = new boolean[arr.length][arr.length];
    int start = 0;
    int maxLength = 1;
    for(int i=0;i < arr.length;i++) {
      longest[i][i] = true;
      start = i;
    }
    
    for(int i=1; i < arr.length;i++) {
      if(arr[i] == arr[i-1]) {
        longest[i-1][i] = true;
        maxLength = 2;
        start = i;
      }
    }
    
    //k is the length of the substring
    for(int k = 3; k <= arr.length ; k++) {
      for(int i=0; i < arr.length - 1 - k; ++i) {
        int j = i + k -1;
        if(longest[i+1][j-1] == true && arr[i] == arr[j]) {
          longest[i][j] = true;
          if(k > maxLength) {
            maxLength = k;
            start = i;
          }
        }
      }
    }
    
    return maxLength;
  }
}
