package com.practice.algorithms;

public class ReflectionChecks {
  public static void main(String args[]) {
    Class<? extends String> c = "test".getClass();
    System.out.println("Class is " + c.getSimpleName());
  }
}
