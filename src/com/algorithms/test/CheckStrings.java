package com.algorithms.test;

public class CheckStrings {
  public static void main(String args[]) {
    String obj1 = "hello";
    String obj2 = obj1;
    System.out.println(obj1 == obj2);
    System.out.println(obj1.equals(obj2));
    obj2 = "world";
    System.out.println(obj1 == obj2);
    System.out.println(obj1.equals(obj2));
    System.out.println("obj1 is " + obj1 + " obj2 is " + obj2);
    try {
      
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
}
