package com.practice.algorithms;

public class MinJumpsToReachEnd {
 public static void main(String args[]) {
   int[] arr = {2,1,1,1,8};
   System.out.println("Min jumps is " + minJumps(arr));
   }

//Dynamic programming
//jumps[i] indicates minimum number of jumps needed to jump from arr[0] to arr[i] 
private static int minJumps(int array[]) {
  int[] jumps = new int[array.length];
  for(int i=0; i < jumps.length;i++) {
    jumps[i] = Integer.MAX_VALUE;
  }
  jumps[0] = 0;
  for(int i=1; i < jumps.length ;i++) {
    for(int j=0; j < i; j++) {
      //j in j + array[j] indicates max j steps to come to j
      if(i <= j + array[j] && jumps[j] < Integer.MAX_VALUE) {
        jumps[i] = Math.min(jumps[j] + 1, jumps[i]);
        break;
      }
    }
  }
  return jumps[jumps.length-1];
  }
}
