package com.algorithms.test;

import com.practice.algorithms.NextPalindromeYear;

public class TestPalindromeYear {
  public static void main(String args[]) {
    NextPalindromeYear nextPalin = new NextPalindromeYear();
    int year = nextPalin.nextPalindromeYear("01032321");
    System.out.println("next palindromic year is " + year);
  }
}
