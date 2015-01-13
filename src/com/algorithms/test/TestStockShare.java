package com.algorithms.test;

import com.practice.algorithms.StockShare;

public class TestStockShare {
  public static void main(String args[]) {
    int arr[] = {6,4,2,9,11,3,18,17,4};
    int values[] = new StockShare().buySell(arr);
    System.out.println("Buy at " + values[0]);
    System.out.println("Sell at " + values[1]);
  }
}
