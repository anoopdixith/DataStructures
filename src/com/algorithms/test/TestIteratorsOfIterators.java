package com.algorithms.test;

import java.util.ArrayList;
import java.util.Iterator;

import com.practice.algorithms.IteratorOfIterators;

public class TestIteratorsOfIterators {
  public static void main(String args[]) {
    ArrayList<Integer> arr1 = new ArrayList<Integer>();
    ArrayList<Integer> arr2 = new ArrayList<Integer>();
    ArrayList<Integer> arr3 = new ArrayList<Integer>();
    ArrayList<Integer> arr4 = new ArrayList<Integer>();
    arr1.add(5);
    arr1.add(1);
    arr1.add(4);
    
    arr2.add(3);
    arr2.add(6);
    
    arr4.add(1);
    arr4.add(7);
    arr4.add(3);
    arr4.add(5);
    
    Iterator<Integer> it1 = arr1.iterator();
    Iterator<Integer> it2 = arr2.iterator();
    Iterator<Integer> it3 = arr3.iterator();
    Iterator<Integer> it4 = arr4.iterator();
    
    Iterator[] iterators = {it1,it2,it3,it4};
    IteratorOfIterators iterIter = new IteratorOfIterators(iterators);
    while(iterIter.hasNext()) {
      System.out.print(iterIter.next() + " , ");
    }
    
  }
}
