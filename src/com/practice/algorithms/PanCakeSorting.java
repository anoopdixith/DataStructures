package com.practice.algorithms;

/*
 * 7,3,11,18,6
 * 
 * 3,7,11,5,6 = 3,7,11,5 =
 * 
 * 
 *  2,3,4,5
 */
public class PanCakeSorting {
  public int[] sort(int[] input) {
    //System.out.println("input length is " + input.length);
    for(int i=1; i < input.length; i++) {
      int flip = findMaxIndex(input, i, input[i]);
      //System.out.println("\nflip is " + flip);
      //Flip till flip
      input = reverseSubArray(input, flip, i);
      input = reverseSubArray(input, flip+1, i);
    }
    return input;
  }
  
  public int findMaxIndex(int[] array, int limit, int number) {
    //System.out.println("Array before limit " + limit + " is ");
    //for(int k:array) {
      //System.out.print(k+",");
    //}
    //linear
    /*
    for(int i=0; i <= limit; i++) {
      if(array[i] > number) {
        return i;
      }
    }
    return limit+1;
    */
    
    //log n
    int low = 0;
    int high = limit-1;
    int mid = low + (high - low)/2;
    if(mid == 0) {
      return 0;
    }
    //System.out.println();
    //System.out.println("low is " + low + " mid is " + mid + " high is " + high);
    while(low <= high) {
        
        if(number > array[mid] && number < array[mid+1]) {
          //System.out.println("Case 1 ");
          return mid+1;
        }
        else if(number > array[mid] && number > array[mid+1]) {
          //System.out.println("case 2 " + low + "," + mid + "," + high);
          low = mid+1;
          mid = low + (high - low)/2;
        }
        else {
          //System.out.println("case 3 " + low + "," + mid + "," + high);
          high = mid-1;
          mid = low + (high - low)/2;
        }
        //System.out.println();
        //System.out.println("low is " + low + " mid is " + mid + " high is " + high);
    }
    return (low > 0)?limit+1:0;
    
  }
  
  public int[] reverseSubArray(int[] input, int beg, int end) {
    while(beg < end) {
      int temp = input[beg];
      input[beg++] = input[end];
      input[end--] = temp;
    }
    return input;
  }
}
