package com.algorithms.test;

public class SumOfElementsInArray {
  int[] arr;
  int[] sum;
  int k;
  public SumOfElementsInArray(int[] arr) {
    this.arr = arr;
    k = (int) Math.sqrt(arr.length);
    this.sum = new int[k+1];
    int pointer = -1;
    for(int i=0; i < arr.length; i++) {
      if(i%k == 0) {
        pointer++;
      }
      sum[pointer] += arr[i];
    }
    //System.out.println("k is " + k);
    int checkSum = 0;
    for(int every:sum) {
      System.out.print(every + ",");
      checkSum += every;
    }
    System.out.println();

    //System.out.println("Sum is " + checkSum);
  }
  public void update(int i, int value) {
    sum[i/k] = sum[i/k] - arr[i] + value;
  }
  
  public int query(int low, int high) {
    int run = 0;
    int lowQuo = low / k;
    for(int i = low; i < lowQuo + k; i++) {
      run+=arr[i];
    }
    System.out.println(run);
    for(int i = lowQuo + k; i < (high - high%k); i=i+k) {
      System.out.println("thru sum");
      run+= sum[i/k];
    }
    System.out.println(run);
    for(int i= high - (high%k) ; i <= high; i++ ) {
      run+= arr[i];
    }
    return run;
  }
  
  public static void main(String argsp[]) {
    int[] arr = {3,8,1,7,6,5,4,11,13,9,18};
    System.out.println(new SumOfElementsInArray(arr).query(0, arr.length-1));
  }
}
