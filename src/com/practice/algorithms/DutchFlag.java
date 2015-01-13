package com.practice.algorithms;

import java.lang.reflect.Array;

public class DutchFlag {
  public  Comparable[] sortDutchFlag(Comparable[] arr) {
    Comparable[] order = getOrder(arr);
    System.out.println("Order is");
    for(Comparable or: order) {
      System.out.print(or + ",");
    }
    System.out.println();
    int low = 0;
    int high = arr.length -1;
    int mid = 0;
    while(mid <= high) {
      if(arr[mid].compareTo(order[0]) == 0) {
        exchg(arr, low++, mid++);
      }
      else if(arr[mid].compareTo(order[1]) == 0) {
        mid++;
      }
      else if(arr[mid].compareTo(order[2]) == 0) {
        exchg(arr, mid, high--);
      }
    }
    return arr;
  }
  
  private Comparable[] exchg(Comparable[] arr, int i, int j) {
    Comparable temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    return arr;
  }

  private Comparable[] getOrder(Comparable[] input) {
    Comparable[] order = new Comparable[3];
    Comparable min = input[0];
    Comparable max = input[0];
    Comparable mid = input[0];
    for(int i=1; i < input.length; i++) {
      int comp = input[i].compareTo(min);
      if(comp == -1) {
        max = mid;
        mid = min;
        min = input[i];
      }
      else if(comp == 1) {
        if(input[i].compareTo(mid) == 1) {
          mid = max;
          max = input[i];
        }
        else {
          mid = input[i];
        }
      }
    }
    order[0] = min;
    order[1] = mid;
    order[2] = max;
    return order;
  }
  
  public static void main(String args[]) {
    Integer[] input = {3,2,1};
    input = (Integer[]) new DutchFlag().sortDutchFlag(input);
    for(Integer i:input) {
      System.out.print(i + ",");
    }
  }
}
