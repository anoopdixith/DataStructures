package com.practice.algorithms;

public class CheckCounting {
  public static void countUp(int n) {
    for(int i=0; i <=n; i++);
  }
  
  public static void countDown(int n) {
    for(int i=n; i >=0; i--);
  }
  
  public static void main(String args[]) {
    int n = Integer.MAX_VALUE - 10;
    
    long start = System.nanoTime();
    for(int i=0; i < Integer.MAX_VALUE; i++)
      for(int j=0; j < Integer.MAX_VALUE; j++)
        //for(int k=0; k < Integer.MAX_VALUE; k++)
          //for(int l=0; l < Integer.MAX_VALUE; l++)
            countUp(n);
    long diffUp = System.nanoTime() - start;
    System.out.println("Time taken by count-up in nanoseconds is " + diffUp);
    
    start = System.nanoTime();
    for(int i=0; i < Integer.MAX_VALUE; i++)
      for(int j=0; j < Integer.MAX_VALUE; j++)
        //for(int k=0; k < Integer.MAX_VALUE; k++)
          //for(int l=0; l < Integer.MAX_VALUE; l++)
            countDown(n);
    long diffDown = System.nanoTime() - start;
    System.out.println("Time taken by count-down in nanoseconds is " + diffDown);
    System.out.println("Ratio of diffDown to diffUp is " + (double)(diffUp/diffDown));
    
    
  }
}
