package com.practice.algorithms;

public class Queens {
  public static void main(String args[]) {
    int N = 4;
    enumerate(N);
  }
  
  public static void enumerate(int n) {
    int a[] = new int[n];
    enumerate(a, 0);
  }
  
  public static void enumerate(int[] q, int n) {
    int N = q.length;
    if(n == N) {
      printQueue(q);
    }
    else {
      for(int i=0; i < N; i++) {
        q[n] = i;
        if(isConsistent(q,n)) 
            enumerate(q, n+1);
      }
    }
  }

  private static void printQueue(int[] q) {
    // TODO Auto-generated method stub
    
  }

  public static boolean isConsistent(int[] q, int n) {
        for(int i=0; i < n; i++) {
          if(q[i] == q[n]) return false;
        }
        return false;
  }
}
