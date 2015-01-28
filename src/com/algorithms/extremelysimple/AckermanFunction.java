package com.algorithms.extremelysimple;

public class AckermanFunction {
  public static void main(String args[]) {
    System.out.println(new AckermanFunction().findAckerman(4,5));
    //System.out.println(Math.pow(2,65536));
    //new AckermanFunction().powersOfTwo(736);
    // A(4,5) = A(3,A(4,4)) = A(3, A(3,A(3,3))) = A(3, A(3,61)). 
  }

  private long findAckerman(long m, long n) {
    if(m == 0) {
      return (n+1);
    }
    if(m > 0 && n ==0) {
      return findAckerman(m-1, 1);
    }
    return findAckerman(m-1, findAckerman( m, n-1))%1000; 
  }
  
  private void powersOfTwo(int limit) {
    int base = 128;
    int mul = 2;
    for(int i=1; i <= limit; i++) {
      System.out.println(mul);
      mul = mul *2;
      if(mul >= 1000) {
        mul %= 1000;
      }
    }
  }
  
}
