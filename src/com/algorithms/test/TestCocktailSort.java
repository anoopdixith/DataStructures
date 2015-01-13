package com.algorithms.test;

import com.algorithms.extremelysimple.CocktailSort;

public class TestCocktailSort {
  public static void main(String args[]) {
    Integer arr[] = {13, 11, 2, 7, 56, 31, 9, 4};
    arr = (Integer[]) new CocktailSort().cocktailSort(arr);
    for(Integer i:arr) {
      //System.out.print(i + ",");
    }
  }
}
