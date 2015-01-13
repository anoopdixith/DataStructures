package com.algorithms.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.practice.algorithms.PrimeFactors;

public class TestPrimeFactors {
  public static void main(String args[]) {
    long number = 71632201l;
    List<Integer> factors = new ArrayList<Integer>();
    factors = new PrimeFactors().primeFactors(number);
    Iterator iterator = factors.iterator();
    while(iterator.hasNext()) {
      System.out.print(iterator.next() + ",");
    }
  }
}
