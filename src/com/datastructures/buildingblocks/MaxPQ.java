package com.datastructures.buildingblocks;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MaxPQ<Key> implements Iterable<Key> {

  @Override
  public Iterator<Key> iterator() {
    // TODO Auto-generated method stub
    return null;
  }
  
  /*
   * Variables
   */
  private Key[] pq;
  private int N; //No. of elements in the PQ
  private Comparator<Key> comparator;
  
  /*
   * Constructors
   */
  public MaxPQ() {
    this(1);
  }
  
  public MaxPQ(int initCapacity) {
    pq = (Key[]) new Object[initCapacity + 1];
    N = 0;
  }
  
  /* Construct the heap */
  public MaxPQ(Key[] keys) {
    N = keys.length;
    pq = (Key[]) new Object[N + 1];
    for(int i = 0; i < N; i++) {
      pq[i+1] = keys[i];
    }
    //Start upwards from non-leaf nodes
    for(int k = N/2; k > 1; k--) {
      sink(k);
    }
    assert isMaxHeap();
  }

  private boolean isMaxHeap() {
    return isHeap(1);
  }

  private boolean isHeap(int k) {
    if(k>N)
      return true;
    int left = 2*k; int right = left + 1;
    if(left <=N && k < left)
      return false;
    if(right <= N && right < k)
      return false;
    return (isHeap(left) && isHeap(right));
  }

  private void sink(int k) {
    while(2*k <= N) {
      int j = 2*k;
      if(j < N && (j < j+1)) {
        j++;
      }
      if(j > k) {
        swap(j,k);
      }
      k = j;
    }
  }

  private void swap(int j, int k) {
    Key swap = pq[j];
    pq[j] = pq[k];
    pq[k] = swap;    
  }
  
  public Key max() {
    if(isEmpty()) {
      throw new NoSuchElementException();
    }
    return pq[1];
  }

  private boolean isEmpty() {
    return N==0;
  }
  
  public void insert(Key k) {
    pq[N++] = k;
    swim(N);
    assert isMaxHeap();
  }

  private void swim(int k) {
    int parent = 2*k;
    if(k > parent) {
      swap(k,parent);
    }
  }
}
