package com.algorithms.extremelysimple;

import java.util.*;

/*
 * Sam: 13,19,25,29,31,37,43,49,53,55,
 * 
 * Polly: 
 * 
 * (3 and 28 or 4 and 21)
 * 
 * ans: polly has: 78 (3*26, 6*13 = both sum to 29 and 19 and both are in the list).
 * 
 * 
 * Sam has one of the above numbers.
 * He splits it into all its sum-combinations
 * Multiplies each of those combinations
 * All such products have more than 2 ways of product-combination 
 * 
 * 
 * find one such product whose all combinations of two-factors sum to one of the numbers in the list 
 * 
 * 
 * x=3, y=9
 * sam: 12
 * polly: 27
 * 
 * 
 * 13:
 * 3+10,4+9, 5+8, 6+7
 * 30, 36, 40, 42
 * 
 * 2,>1,>1,
 * 
 * 
 * 
 * sam: 3,9 = 27  => 3,9
 *      4,8 = 32  => 16,2 or 4,8 
 *      5,7 = 35  => 5,7
 *      6,6 = 36  => 6,6 or 3,12 or 9,4 or 2,18
 *      
 *      all prods of a sum must have at least two ways to come to that product
 */


public class SumProduct {
  public static void main(String args[]) {
    Map<Integer,Integer[]> pair = new HashMap<Integer, Integer[]>();
    for(int x=3; x <= 97; x++) {
      for(int y=x;y <=97; y++)  {
        int sum = x+y;
        List<Integer> allProdsOfThisSum = getAllProdsOfThisSum(sum);
        Iterator<Integer> iter = allProdsOfThisSum.iterator();
        boolean allAtLeastTwo = true;
        while(iter.hasNext()) {
          int product = iter.next();
          int splitsLength = numberOfWaysOfSplitting(product);
          if(splitsLength == 1) {
            allAtLeastTwo = false;
          }
        }
        if(allAtLeastTwo == true) {
          if(pair.get(x*y) == null) {
            pair.put(x*y, new Integer[]{1,x,y});
          }
          else {
            int count = pair.get(x*y)[0] + 1;
            pair.put(x*y, new Integer[]{count, x, y});
          }
          //System.out.println("x is " + x + " y is " + y + " sum is " + (x+y) + " prod is " + (x*y));
        }
      }
    }
    Iterator<Integer[]> iter = pair.values().iterator();
    while(iter.hasNext()) {
      Integer[] tempArr = iter.next();
      if(tempArr[0] == 1) {
        System.out.println("x is " + tempArr[1] + " y is " + tempArr[2] + " sum is " + (tempArr[1]+tempArr[2]) + " prod is " + (tempArr[1]*tempArr[2]));
      }
    }
    
  }

  private static int numberOfWaysOfSplitting(int product) {
    int result = 0;
    for(int x=3; x <= 97; x++) {
      for(int y=x; y <=97; y++)  {
        if(x*y == product) {
          result++;
        }
      }
    }
    return result;
  }

  private static List<Integer> getAllProdsOfThisSum(int sum) {
    List<Integer> allProdsOfSum = new ArrayList<Integer>();
    for(int i=3; i <= 97; i++) {
      for(int j=i; j <= 97; j++) {
        if(sum == (i+j)) {
          allProdsOfSum.add(i*j);
        }
      }
    }
    return allProdsOfSum;
  }
}
