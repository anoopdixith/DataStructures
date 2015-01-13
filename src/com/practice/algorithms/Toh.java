package com.practice.algorithms;

public class Toh {
  public void solve(int discs, String start, String aux, String end) {
    if(discs == 1) {
      System.out.println("Move from " + start + " to " + end);
    }
    else {
      solve(discs - 1, start, end, aux);
      System.out.println("Move from " + start + " to " + end );
      solve(discs - 1, aux, start, end);
    }
  }
  
  public static void main(String args[]) {
    Toh toh = new Toh();
    toh.solve(2, "A","B", "C" );
  }
}
