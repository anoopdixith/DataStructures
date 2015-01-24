package com.algorithms.test;

public class CheckPassByReference {
  int a;
  int b;
  public CheckPassByReference(int a, int b) {
    this.a = a;
    this.b = b;
  }
  public CheckPassByReference meth(CheckPassByReference cbpr) {
    cbpr.a *= 2;
    cbpr.b /= 2;
    cbpr = new CheckPassByReference(cbpr.a, cbpr.b);
    return cbpr;
  }
}

