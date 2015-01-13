package com.algorithms.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.practice.algorithms.SieveOfEras;

public class TestSieveOfEras {
  public static void main(String args[]) {
    List<Integer> primes = new ArrayList<Integer>();
    long limit = 100;
    primes = new SieveOfEras().generatePrimes(limit );
    Iterator<Integer> iterator = primes.iterator();
    while(iterator.hasNext()) {
      System.out.print(iterator.next() + ",");
    }
  }
}
