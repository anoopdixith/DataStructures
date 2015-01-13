package com.algorithms.extremelysimple;

public class LearnRecursion {
  public int fact1(int n) {
    if(n <=1) return 1;
    return n * fact1(n-1);
  }
  
  public int fact2(int n) {
    return n<2?1:n*fact2(n-1);
  }
  
  public static void main(String args[]) {
    LearnRecursion lr = new LearnRecursion();
    System.out.println("fact1 is " + lr.fact1(5));
    System.out.println("fact2 is " + lr.fact2(5));
  }
}
