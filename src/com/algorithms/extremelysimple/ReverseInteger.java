package com.algorithms.extremelysimple;

import com.practice.algorithms.ReverseNumber;

public class ReverseInteger {
  public static void main(String args[]) {
    int num = 367;
    System.out.println(reverseNumber(353967));
  }
  
  public static int reverseNumber(int num) {
    int rev = 0;
    while(num > 0) {
      int rem = num % 10;
      rev = 10 * rev + rem;
      num/=10;
    }
    return rev;
  }
}
