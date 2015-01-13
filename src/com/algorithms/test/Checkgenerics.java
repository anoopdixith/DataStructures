package com.algorithms.test;

import java.util.ArrayList;
import java.util.List;

public class Checkgenerics {
  public static void main(String args[]) {
    List list = new ArrayList();
    //list.add("A");
    //list.add("B");
    //list.add(3);
    list.add(new int[10]);
    System.out.println(list);
  }
}
