package com.practice.algorithms;

public class EggDrop {
  public int eggDropRecursion(int eggs, int floors) {
    if(eggs == 1) {
      return floors;
    }
    if(floors == 1 || floors == 0) {
      return floors;
    }
    int res = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for(int floor = 1; floor <= floors; floor++) {
      res = Math.max(eggDropRecursion(eggs, floors - floor), eggDropRecursion(eggs -1, floor -1));
      if(res < min) {
        min = res;
      }
    }
    return min+1;
  }
  
  public int eggDrop(int noOfEggs, int noOfFloors) {
    int[][] table = new int[noOfEggs+1][noOfFloors+1];
    /*
     * table[i][j] indiactes the min trials in worst case for i eggs and j floors
     */
    for(int i=1; i <= noOfEggs; i++) {
      table[i][0] = 0;
      table[i][1] = 1;
    }
    for(int j = 1; j <= noOfFloors; j++) {
      table[1][j] = j;
    }
    for(int i=2; i <= noOfEggs; i++) {
      for(int j=2; j <= noOfFloors; j++) {
        table[i][j] = Integer.MAX_VALUE;
        for(int x = 1; x <= j; x++) {
          int res = 1 + Math.max(table[i][j-x], table[i-1][x-1]);
          if(table[i][j] > res) {
            table[i][j] = res;
          }
        }
      }
    }
    for(int i=0; i <= noOfEggs; i++) {
      for(int j=0; j <= noOfFloors; j++) {
        System.out.print(table[i][j] + ",");
      }
      System.out.println();
    }
    return table[noOfEggs][noOfFloors];
  }
  
  public static void main(String args[]) {
    EggDrop ed = new EggDrop();
    int floors = 1000;
    int eggs = 7;
    System.out.println("Recur: " + ed.eggDropRecursion(eggs, floors));
    System.out.println("DP: " + ed.eggDrop(eggs, floors));
  }
}
