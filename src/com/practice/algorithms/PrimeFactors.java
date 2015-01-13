package com.practice.algorithms;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
  List<Integer> allPrimes = new ArrayList<Integer>();
  List<Integer> allFactors = new ArrayList<Integer>();
  public List<Integer> primeFactors(long number) {
    //System.out.println("number is " + number);
    long limit = number / 2;
    if(allPrimes.size() == 0) {
      allPrimes = new SieveOfEras().generatePrimes(limit);
    }
    /* Print 
    Iterator iterator = allPrimes.iterator();
    while(iterator.hasNext()) {
      System.out.print(iterator.next() + ",");
    }
    System.out.println();
    /* Print complete */
    
    if(allPrimes.contains((int)number)) {
      //System.out.println("Base case");
      allFactors.add((int) number);
      return allFactors;
    }
    for(int i=0; i < allPrimes.size();i++) {
      if(number % allPrimes.get(i) == 0) {
        allFactors.add(allPrimes.get(i));
        return primeFactors(number/allPrimes.get(i));
      }
      //System.out.println("left out number is " + number);
    }
    return allFactors;
  }
}
