package com.practice.algorithms;

import java.util.Iterator;

public class IteratorOfIterators<E> implements Iterator<E>{

  private Iterator<E>[] iterators;
  private int currentIndex;
  private Iterator<E> currentIterator;
  
  public IteratorOfIterators(Iterator<E>[] iterators) {
    this.iterators = iterators; 
    this.currentIterator = iterators[0];
    this.currentIndex = 0;
  }
  
  @Override
  public boolean hasNext() {
    if(currentIterator.hasNext() || currentIndex!= iterators.length - 1) {
      return true;
    }
    return false;
  }

  @Override
  public E next() {
    if(!hasNext()) {
      return null;
    }
    if(currentIterator.hasNext()) {
      return currentIterator.next();
    }
    else {
      while(!currentIterator.hasNext() && currentIndex < iterators.length - 1) {
        currentIndex++;
        currentIterator = iterators[currentIndex];
      }
      return currentIterator.next();
    }
  }

  @Override
  public void remove() {
    if(currentIterator != null && currentIterator.hasNext()) {
      currentIterator.remove();
    }
    while(iterators[currentIndex++].hasNext()) {
      currentIterator = iterators[currentIndex];
      if(currentIterator.hasNext()) {
        currentIterator.remove();
        return;
      }
    }
  }

}
