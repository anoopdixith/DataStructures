package com.practice.algorithms;

public class NullCheck {
  public static void main(String args[]) {
    System.out.println(isNullObject());
  }

  private static boolean isNullObject() {
    return null instanceof Object;
  }
}
