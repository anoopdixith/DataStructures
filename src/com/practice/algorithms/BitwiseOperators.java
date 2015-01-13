package com.practice.algorithms;

public class BitwiseOperators {
  public static void main(String args[]) {
    int input = 23;
    System.out.println("Number in binary is " + printBinary(input));
    System.out.println("Logical Right Shift is " +logicalRightShift(input));
    System.out.println("Right Shift is " + rightShift(input));
    System.out.println("Right Rotate is " + rightRotate(input, 1));
    System.out.println("Number of set bits is " + setBits(input));
    System.out.println("Reversed bits is " + reverseBits(input) + " whose binary is " + printBinary(reverseBits(input)));
    System.out.println("Graycode of " + printBinary(input) + " is " + binaryToGray(input));
  }

  private static int binaryToGray(int input) {
    
    return ((input >>> 1) ^ input);
  }

  private static int reverseBits(int input) {
    //move input to right
    //move output to left and keep ORing.
    int b=0;
    while(input!=0) {
      b <<= 1;
      b |= (input & 1);
      input >>= 1;
    }
    return b;
  }

  private static int setBits(int input) {
    int count;
    for(count = 0; input >0 ;count++) {
      input &= input - 1;
    }
    return count;
  }

  private static int rightRotate(int input, int k ) {
    return (input >>> k | input << (Integer.SIZE - k));
  }

  private static int rightShift(int input) {
    return input>>1;
  }

  private static int logicalRightShift(int input) {
    return input>>1;
  }

  private static String printBinary(int input) {
    assert input >= 0;
    String binary = "";
    while(input >0) {
      binary = Integer.toString(input % 2) + binary;
      input /=2;
    }
    return binary;
  }
  
  
}
