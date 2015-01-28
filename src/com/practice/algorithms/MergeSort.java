package com.practice.algorithms;

/*
 * 2,3,4,5,6,(12/5)
 * 
 * 
 * 
 */

public class MergeSort {
  int[] arr;
  int[] tempArr;
  private void split(int low, int high) {
    while(low < high) {
      int mid = low + (high - low) / 2;
      split(low, mid);
      split(mid+1, high);
      merge(low, mid,high);
    }
  }

  private void merge(int low, int mid, int high) {
    tempArr = arr;
    int i = low;
    int j = mid+1;
    int k = low;
    while(i < mid && j < high) {
      if(tempArr[i] <= tempArr[j]) {
        arr[k] = tempArr[i];
        i++;
      }
      else {
        arr[k] = tempArr[j];
        j++;
      }
      k++;
    }
    while(i<=mid) {
      arr[k++] = tempArr[i++];
    }
    
  }
}
