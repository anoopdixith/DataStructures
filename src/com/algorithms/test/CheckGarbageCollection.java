package com.algorithms.test;

public class CheckGarbageCollection {
  public static void main(String args[]) {
    //System.gc();
    Runtime runtime = Runtime.getRuntime();
    System.out.println("Available processes " + runtime.availableProcessors());
    System.out.println("Available Memory " + runtime.totalMemory());
    System.gc();
    System.out.println("Free Memory " + runtime.freeMemory());
  }
}
