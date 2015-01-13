package com.practice.algorithms;

public class ChocolateWrapper {
  public static void main(String args[]) {
    int initialChocolates = 49;
    int chocolatesPerNumberOfWrappers = 0;
    System.out.println("Total chocolates is " + totalChocolates(initialChocolates, chocolatesPerNumberOfWrappers));
  }

  private static int totalChocolates(int initialChocolates, int chocolatesPerNumberOfWrappers) {
    int total = initialChocolates;
    int wrappersAtHand = 0;
    int remainingWrappers = initialChocolates;
    if(chocolatesPerNumberOfWrappers == 0) {
      return initialChocolates;
    }
    while(remainingWrappers + wrappersAtHand >= chocolatesPerNumberOfWrappers ) {
      total += (remainingWrappers + wrappersAtHand) / chocolatesPerNumberOfWrappers;
      wrappersAtHand = remainingWrappers % chocolatesPerNumberOfWrappers;
      remainingWrappers = remainingWrappers / chocolatesPerNumberOfWrappers;
    }
    return total;
  }
}
