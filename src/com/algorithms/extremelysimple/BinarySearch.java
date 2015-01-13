package com.algorithms.extremelysimple;

public class BinarySearch {
  public <T> int binarySearch(Comparable<T>[] input, Comparable element, int low, int high) {
    if(high - low == 0) {
      if(element.compareTo(input[0]) == 0) {
        return high;
      }
      return -1;
    }
    int mid = low + (high-low)/2;
    if(element.compareTo(input[mid]) == 0) {
      return mid;
    }
    if(element.compareTo(input[mid]) == -1) {
      return binarySearch(input, element, low, mid);
    }
    else {
      return binarySearch(input, element, mid + 1, high);
    }
  }
  
  public <T> int binarySearchIter(Comparable<T>[] input, Comparable<T> element) {
    int index = -1;
    int low = 0;
    int high = input.length -1;
    while(low <= high) {
      int mid = low + (high - low) /2 ;
      //System.out.println("mid is " + mid);
      if(input[mid].compareTo((T) element) == 0) {
        return mid;
      }
      if(input[mid].compareTo((T) element) == 1) {
        high = mid - 1;
      }
      else {
        low = mid + 1;
      }
    }
    return index;
  }
  
  public static void main(String args[]) {
    Integer[] input = {3,5,7,11,23,44,88};
    System.out.println("Index is " + new BinarySearch().binarySearch(input, 5, 0, input.length));
    System.out.println("Index iter is " + new BinarySearch().binarySearchIter(input, 3));
  }
}
