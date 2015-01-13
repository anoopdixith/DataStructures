package com.algorithms.extremelysimple;

public class CocktailSort {
  @SuppressWarnings("unchecked")
  /*
   * Notice that in the inner loop that does the actual comparison, the gap is 1 
   * (i.e. j is compared with j+1). This could be made j and j+gap where gap >=1.
   * This is called Comb sort and aims at eliminating turtles. (small values at the end)
   * gap is determined by arr.length / shrinkFactor.
   * Empirically, it's been found that the shrink factor is best at 1.3 initial value.
   */
  public <T> Comparable<T>[] cocktailSort(Comparable<T> arr[]) {
    for(Comparable<T> k:arr) {
      System.out.print(k + ",");       
    }
    System.out.println();
    for(int i=0; i < arr.length; i++) {
      if(sortingComplete(arr)) {
        return arr;
      }
      for(int j = 1; j < arr.length - i; j++) {
        if((arr[j].compareTo((T) arr[j-1])) < 0) {
          //System.out.println("Inside if");
          Comparable<T> temp = arr[j];
          arr[j] = arr[j-1];
          arr[j-1] = temp;
        }
      }
      for(int j = arr.length - i - 1; j >= 1 + i; j--) {
        if((arr[j].compareTo((T) arr[j-1])) < 0) {
          Comparable<T> temp = arr[j];
          arr[j] = arr[j-1];
          arr[j-1] = temp;
        }
      }
      for(Comparable<T> k:arr) {
        System.out.print(k + ",");       
      }
      System.out.println();
    }
    return arr;
  }

  @SuppressWarnings("unchecked")
  private <T>boolean sortingComplete(Comparable<T>[] arr) {
    for(int i=0; i < arr.length - 1; i++) {
      if(arr[i].compareTo((T) arr[i+1]) > 0 ) {
        return false;
      }
    }
    return true;
  }
}
