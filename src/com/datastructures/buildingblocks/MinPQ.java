package com.datastructures.buildingblocks;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MinPQ<Key> implements Iterable<Key>{

  @Override
  public Iterator<Key> iterator() {
    return null;
  }
  
  private Key[] pq;
  private int N;
  private Comparator<Key> comparator;
  
  public MinPQ(int initCapacity) {
    N = 0;
    pq = (Key[]) new Object[initCapacity + 1];
  }
  
  public MinPQ() {
    this(1);
  }
  
  public MinPQ(int initCapacity, Comparator<Key> comparator) {
    N = 0;
    pq = (Key[]) new Object[initCapacity + 1];
    this.comparator = comparator;
  }
  
  public MinPQ(Comparator comparator) {
    this(1, comparator);
  }
  
  public MinPQ(Key[] keys) {
    N = keys.length;
    pq = (Key[]) new Object[N + 1];
    for(int i=0; i < keys.length; i++) {
      pq[i+1] = keys[i];
    }
    for(int k = N/2; k >=1; k--) {
      sink(k);
    }
    assert isMinHeap();
  }
  
  public boolean isEmpty() {
    return N ==0;
  }
  
  public int size() {
    return N;
  }
  
  public Key min() {
    if(isEmpty()) {
      throw new NoSuchElementException("Priority Queue underflow");
    }
    return pq[1];
  }
  
  //Helper, so private.
  private void resize(int capacity) {
    assert capacity > N;
    Key[] temp = (Key[]) new Object[capacity];
    for(int i=0; i < N; i++) {
      temp[i] = pq[i];
    }
    pq = temp;
  }
  
  public void insert(Key x) {
    if(N == pq.length - 1) {
      resize(2 * pq.length);
    }
    pq[++N] = x;
    swim(N);
    assert isMinHeap();
  }
  
  public Key delMin() {
    if(isEmpty()) {
      throw new NoSuchElementException("Priority Queue underflow");
    }
    exch(1, N);
    Key min = pq[N--];
    sink(1);
    pq[N+1] = null;
    if(N > 0 && N == (pq.length - 1) / 2) {
      resize(pq.length / 2);
    }
    assert isMinHeap();
    return min;
  }
  
  //Coming up
  // Like, during insert
  private void swim(int k) {
    while(k > 1 && greater(k/2,k)) {
      exch(k, k/2);
      k = k/2;
    }
  }
  
  //Going down
  // Like, when deleteMin or buildHeap
  private void sink(int k) {
    while(2 *k <= N) {
      int j = 2 *k;
      if( j < N && greater(j, j+1)) {
        j++;
      }
      if(!greater(k,j)) {
        break;
      }
      exch(k,j);
      k = j;
    }
  }
  
  // if i < j, return true
  private boolean greater(int i, int j) {
    if( comparator == null) {
      return ((Comparable<Key>)pq[i]).compareTo(pq[j]) > 0;
    }
    else {
      return comparator.compare(pq[i], pq[j]) > 0;
    }
  }
  
  private void exch(int i, int j) {
    Key swap = pq[i];
    pq[i] = pq[j];
    pq[j] = swap;
  }
  
  private boolean isMinHeap() {
    return isMinHeap(1);
  }
  
  private boolean isMinHeap(int k) {
    if(k > N) {
      return true;
    }
    int left = 2 *k;
    int right = left + 1;
    if(left <=N && greater(k,left)) return false;
    if(right <=N && greater(k,right)) return false;
    return isMinHeap(left) && isMinHeap(right);
  }
}
