package com.datastructures.buildingblocks;

public class Heap {
  // no constructor instantiation
  private Heap() {
    
  }
  
  public static void main(String[] args) {
    String[] a = {"bad", "asd", "mpo", "ngth", "a", "o", "q", "z", "gjgt"};
    Heap.sort(a);
    show(a);
  }
  
  private static void sort(Comparable[] pq) {
    int N = pq.length;
    //build heap part
    for(int k = N/2; k >=1; k--) {
      sink(pq, k, N);
    }
    //take min and heapigy
    while(N > 1) {
      exch(pq, 1, N--);
      sink(pq, 1, N);
    }
  }

  private static void sink(Comparable[] pq, int k, int N) {
    while( 2 * k <= N) {
      //left child
      int j = 2*k;
      if( j < N && less(pq, j, j+1)) j++;
      if(! less(pq, k, j)) break;
      exch(pq, k, j);
      k = j;
    }
  }
  
  

  private static void exch(Comparable[] pq, int i, int j) {
    Object swap = pq[i-1];
    pq[i-1] = pq[j-1];
    pq[j-1] = (Comparable) swap;
  }

  private static boolean less(Comparable[] pq, int i, int j) {
    return pq[i-1].compareTo(pq[j-1]) < 0;
  }
  

  private static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
        System.out.println(a[i]);
    }
  }
}
