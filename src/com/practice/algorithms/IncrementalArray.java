package com.practice.algorithms;

public class IncrementalArray {
  public static void main(String args[]) {
    int[] array = { 6,5,4,3,4,5,6,7,8,9,8,7,6,5,4,5,6,7};
    // {6,7,8,9,10,9,8,7,6,7,8,9, 10, 11, 12} number = 12:
    //Gets linear when array is like - no, never gets linear, not even in the worst case
    int number = 9;
    System.out.println("Value " + number + " exits at index " + doesExist(number, array));
  }
  
  public static int doesExist(int number, int[] array) {
    int exist = -1;
    int init = array[0];
    int difference = Math.abs(init - number);
    while(difference >= 0 && difference <= array.length) {
      if(array[difference] == number) {
        return difference;
      }
      if(array[difference] < number) {
        init = array[difference];
        difference += Math.abs(init - number);
      }
    }
    return exist;
  }
} 
