package com.algorithms.test;

import java.util.Scanner;

public class TakeInput {
  public static void main(String args[]) {
    int place = 'd' - 'a';
    System.out.println(place);
    Scanner scanner = new Scanner(System.in);
    int testCaseSize = scanner.nextInt();
    while(--testCaseSize >= 0) {
      int input = scanner.nextInt();
      System.out.println(input);
    }
    scanner.close();
  }
  
}
