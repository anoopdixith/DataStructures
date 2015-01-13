package com.practice.algorithms;

public class ReverseNumber {
  public static void main(String args[]) {
    int input = 2532;
    System.out.println("Reverse of " + input + " is " + reverseInt(input));
    System.out.println(input + " is palindrome is " + isPalindrome(input));
  }

  private static boolean isPalindrome(int input) {
    int length = 1;
    int temp = input;
    while(temp > 0) {
      length *= 10;
      temp /= 10;
    }
    length /= 10;
    while(input > 0) {
      int l = input % 10;
      int r = input / length;
      System.out.println("input is " + input + " length is " + length);
      System.out.println("left is " + l + " right is " + r);
      if(l != r)
        return false;
      input = (input % length) / 10;
      length /= 100;
    }
    return true;
  }

  private static int reverseInt(int input) {
    int sum = 0;
    while(input > 0) {
      sum = sum*10 + (input%10);
      input /= 10;
    }
    return sum;
  }
  
  
}
