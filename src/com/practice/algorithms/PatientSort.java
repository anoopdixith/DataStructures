package com.practice.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class PatientSort {
  
  public static void main(String args[]) {
    Integer[] input = { 2,4,4,3,1,5,9 };
    sort(input);
  }
  public static <E extends Comparable<? super E>> void sort(E[] n) {
    List<Pile<E>> piles = new ArrayList<Pile<E>>();
    for(E x:n) {
      Pile<E> newPile = new Pile<E>();
      newPile.push(x);
      int i= Collections.binarySearch(piles, newPile);
      if(i < 0) {
        //System.out.println("No match for " + x + " for i = " + i);
        i = ~i;
      }
      
      if(i != piles.size()) {
        //System.out.println("Value in if is " + x);
        piles.get(i).push(x);
      }
      else {
        //System.out.println("Value in else is " + x);
        piles.add(newPile);
      }
    }
    
    System.out.println("longest increasing subsequence has length = " + piles.size());
    
    //Lets get the numbers back in sorted order
    PriorityQueue<Pile<E>> heap = new PriorityQueue<Pile<E>>(piles);
    for(int c=0; c < n.length; c++) {
      Pile<E> smallPile = heap.poll();
      n[c] = smallPile.pop();
      if(!smallPile.empty()) {
        heap.offer(smallPile);
      }
    }
    assert heap.isEmpty();
    System.out.println();
    for(E x:n) {
      System.out.print(x + ",");
    }
  }
  
  public static class Pile<E extends Comparable<? super E>> extends Stack<E> implements Comparable<Pile<E>> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public int compareTo(Pile<E> y) {
      return peek().compareTo(y.peek());
    }
  }
}
