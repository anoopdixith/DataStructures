package com.practice.algorithms;

public class TestSortStructure {
  public static void main(String args[]) {
    int[] array = {2,1,6,5,8};
    
    /* Start StructuredData sorting */
    SortStructure sortStructure = new SortStructure(array);
    int[] sortedArr = new int[array.length];
    /*Start time */
    long start = System.nanoTime();
    //for(int i=0; i <Integer.MAX_VALUE; i++) 
      //for(int j =0 ; j <Integer.MAX_VALUE; j++)
        sortedArr = sortStructure.sortInternal(array);
    long diffUp = System.nanoTime() - start;
    /* End time */
    System.out.println("Time taken by count-up in nanoseconds is " + diffUp);
    
    for(int i = 0; i < sortedArr.length; i++) {
      System.out.print(sortedArr[i] + ",");
    }
    /* End StructuredData sorting */
  }
}
