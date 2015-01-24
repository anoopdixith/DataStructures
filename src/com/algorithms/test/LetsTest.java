package com.algorithms.test;


  public class LetsTest {
    public static void main(String args[]) {
      CheckPassByReference cpbr = new CheckPassByReference(10, 20);
      cpbr = cpbr.meth(cpbr);
      System.out.println("x is " + cpbr.a);
      System.out.println("y is " + cpbr.b);
    }
  }

