package com.algorithms.test;

import com.practice.algorithms.PanCakeSorting;

/*
 * 7,21,6,11
 * 7,21,
 * 7,21,6 = flip =0 = 6,21,11 = 6,11,21
 */

public class TestPanCakeSorting {
  public static void main(String args[]) {
    int[] arr = {18,11,5,12,7,6,19,14,23,3,8};
    //int[] arr = {3,2,1};
    int[] arr2 = {6,9,12,17,21};
    PanCakeSorting panCake = new PanCakeSorting();
    int[] arr1 = panCake.sort(arr);
    for(int i:arr1) {
      System.out.print(i + ",");
    }
  }
}
