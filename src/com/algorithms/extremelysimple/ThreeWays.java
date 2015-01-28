package com.algorithms.extremelysimple;

public class ThreeWays {
  public static void main(String args[]) {
    int i, n = 20;
    /*
     * Standard
     */
    for(i=0; i < 20; i++) {
      System.out.print('-');
    }
    System.out.println();
    /*
     * Given
     */
    for (i = 0; i < n; i--)
    {
        //System.out.print("-");
    }
    /*
     * Method -1
     */
    for(i=0; -i < n; i--) {
      System.out.print('-');
    }
    /*
     * Method -2
     */
    System.out.println();
    for(i=0; i < n; n--) {
      System.out.print('-');
    }
    /*
     * Method -3
     */
    for (i = 40; i < n; i--)
    {
        System.out.print("-");
    }
  }
}
