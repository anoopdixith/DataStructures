package com.algorithms.extremelysimple;

public class DhattiginaDP {
  public static void main (String args[]) {
    int limit = 8;
    int[] ways = new int[limit+1];
    ways[1] = 1;ways[2] = 2; 
    for(int i=3; i < ways.length; i++) {
      ways[i] = ways[i-1] + ways[i-2];
    }
    System.out.println(ways[ways.length-1]);
    /*
     * x^3 = z*720
     * 1440, 2160
     * 2,3,4,5,6 = 2,2,2,2, 3,3, 5, (3 * 5 * 5 *  2 * 2) = 300 = 720*300 = 216 * 000 = 60
     * 
     *   2,3,4,5,6,300 = 
     *   a*b*c*d = 60
     *   
     *   10,30, 
     *   
     *   c+21 = m
     *   m+6 = 5(c+6) => m + 6 = 5c + 30 => m - 5c = 24 and m -c = 21 => 4c = -3 => c = -9 months
     *   
     *   0..     taninv(cos 0)
     *   3!=> 
     *   
     *   
     *   
     */
  }
}
