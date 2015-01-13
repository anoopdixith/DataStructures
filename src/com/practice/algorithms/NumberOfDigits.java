package com.practice.algorithms;

public class NumberOfDigits {
  public static void main(String args[]) {
    for(int i= 1; i <= 10; i++) {
      new NumberOfDigits().getAllNumbers(i);
    }
  }
  public void getAllNumbers(int limit) {
    int[] output = new int[limit];
    //Set everything to -1
    for(int i= 0; i < limit; i++, output[i-1] = -1);
    // i is for each index
    // j is for each digit for an index
    int i=0;
    getNumbers(output, i);
    return;
  }
  
  private void getNumbers(int[] output, int i) {
    int limit = output.length;
    for(int j =0; j < limit; j++) {
      int currentValue = output[i];
      //put the value
      output[i] = j;
      if(isValid(output, i, j)) {
        if(i == limit - 1) {
          print(output);
        }
        else {
          getNumbers(output, i+1);
        }
      }
      else {
        output[i] = currentValue;
      }
    }
  }
  private void print(int[] array) {
    for(int i: array) {
      System.out.print(i+",");
    }
    System.out.println();
  }
  
  private boolean isValid(int[] array, int position , int digit) {
    boolean valid = true;
    int limit = array.length;
    int count = 0;
    for(int i=0; i <= position; i++) {
      if(array[i] == position) {
        count++;
      }
      if(count > digit) {
        return false;
      }
    }
    //if the position is the last position, check if the entire array is valid or not
    if(position == limit -1) {
      if(!isArrayValid(array)) {
        return false;
      }
    }
    return valid;
  }
  
  private boolean isArrayValid(int[] array) {
    for(int i=0; i < array.length; i++) {
      int digit = array[i];
      if(findCount(array,i) != digit) {
        return false;
      }
    }
    return true;
  }
  
  private int findCount(int[] array, int digit) {
    int count = 0;
    for(int i:array) {
      if(i == digit) {
        count++;
      }
    }
    return count;
  }
}
