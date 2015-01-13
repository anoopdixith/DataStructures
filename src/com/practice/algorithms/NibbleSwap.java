package com.practice.algorithms;

public class NibbleSwap {
  public static void main(String args[]) {
    int number = 53;
    int bits = 2;
    System.out.println("final number is " + new NibbleSwap().nibbleSwap(number, bits));
  }
  
  /*
   * Right to left nibble swap
   * 10101-11010
   * 110 ->101
   */
  public int nibbleSwap(int number, int bits) {
    int finalNum = 0;
    int orringNumber = generateNumber(bits);
    System.out.println("orringNumber is " + orringNumber);
    int left = (orringNumber & number) ;
    int right = ((orringNumber >> bits) & number);
    System.out.println("left is " + left);
    System.out.println("right is " + right);
    finalNum = left << bits | right >> bits;
    return finalNum;
  }
  
  public int generateNumber(int bits) {
    int number = 0;
    int k = 0;
    while(k++ < 31) {
      for(int i=0; i < bits; i++, k++) {
        number = (number << 1) | 0;
      }
      for(int i=0; i < bits; i++, k++) {
        number = (number << 1) | 1 ;
      }
    }
    return number;
  }
}
