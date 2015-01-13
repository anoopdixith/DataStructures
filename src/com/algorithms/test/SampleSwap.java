package com.algorithms.test;

public class SampleSwap {
  public static void main(String args[]) {
    int arr[] = {2,3,4,5,6};
    /*
    for(int beg=0; beg < arr.length/2; beg++) {
      int temp = arr[beg];
      arr[beg] = arr[arr.length -1 - beg];
      arr[arr.length - 1 - beg] = temp; 
    }
    for(int i:arr) {
      //System.out.print(i + ",");
    }
    */
    arr = swapSubArray(arr, 0, 1); //2,5,4,3,6
    for(int i:arr) {
      System.out.print(i + ",");
    }
  }
  
  public static int[] swapSubArray(int[] input, int beg, int end) {
    while(beg < end) {
      int temp = input[beg];
      input[beg++] = input[end];
      input[end--] = temp;
    }
    return input;
  }
}
