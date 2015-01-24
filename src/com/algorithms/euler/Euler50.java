package com.algorithms.euler;

import java.util.List;

import com.practice.algorithms.SieveOfEras;

public class Euler50 {
  public static void main(String args[]) {
    List<Integer> allPrimes = new SieveOfEras().generatePrimes(1000000);
    //for(int i:allPrimes) {
      //System.out.print(i + ",");
    //}
    //System.out.println(allPrimes.size());
    int maxLength = 0;
    for(int i= 50000; i < allPrimes.size(); i++) {
      int currentPrime = allPrimes.get(i);
      int sum = 0;
      for(int j=i-1; j > 0; j--) {
        int k =0; int l =0;
        for(k=j; k >=0; k--) {
          sum = 0;
          for(l = j; l >=k; l--) {
            sum += allPrimes.get(l);
            if(sum > currentPrime) {
              break;
            }
            //System.out.println(sum);
          }
          if(sum > currentPrime) {
            break;
          }
          if((sum == currentPrime) && (j - k) > maxLength) {
            maxLength = j - k;
            
            System.out.println("==" + currentPrime);
            /*
            System.out.println(" jth prime is " + allPrimes.get(j));
            System.out.println(" kth prime is " + allPrimes.get(k));
            //System.out.println(" lth prime is " + allPrimes.get(l));
            System.out.println(" j - k is " + (j-k));
            System.out.println("========");
            */
          }
        }
      }
      
      //System.out.println("number is " + allPrimes.get(i));
      //System.out.println(" jth prime is " + allPrimes.get(j));
      //System.out.println(" kth prime is " + allPrimes.get(k));
      //System.out.println(" lth prime is " + allPrimes.get(l));
      //System.out.println(" j - k is " + (j-k));
      //System.out.println("========");
    }
  }
}
