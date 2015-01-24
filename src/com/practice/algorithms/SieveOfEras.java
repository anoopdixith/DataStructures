package com.practice.algorithms;

import java.util.ArrayList;
import java.util.List;

public class SieveOfEras {
  List<Integer> allNumbers = new ArrayList<Integer>();
  public List<Integer> generatePrimes(long limit) {
    List<Integer> returnNumbers = new ArrayList<Integer>();
    System.gc();
    for(int i=2; i < limit;i++) {
      allNumbers.add(i);
    }
    //System.out.println("Added numbers");
    for(int i = 0; i < Math.sqrt(limit-2); i++) {
      if(allNumbers.get(i) == 0) {
        continue;
      }
        int l = 2;
        int j = allNumbers.get(i);
        int k = j * l;
        int arrLength = allNumbers.size();
        while(k <= arrLength + 1) {
          //System.out.println("k is " + k);\
          if(allNumbers.get(k-2) != 0)
            allNumbers.set(k-2, 0);
          k = j * l++;
        }
    }
    //System.out.println("Finished");
    for(int i=0; i < allNumbers.size(); i++) {
      if(!allNumbers.get(i).equals(0)) {
        //allNumbers.remove(i--);
        returnNumbers.add(allNumbers.get(i));
      }
    }
    //System.out.println("Returned");
    return returnNumbers;
  }
}
