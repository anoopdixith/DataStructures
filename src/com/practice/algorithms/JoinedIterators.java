package com.practice.algorithms;

import java.util.Iterator;
import java.util.List;

public class JoinedIterators implements Iterator{

  private static final Iterator[] ITERATORS = {};

  private Iterator[] iterators;
  
  private Iterator currentIterator;
  private Iterator lastUsedIterator;
  private int currentIteratorIndex;
  
  public JoinedIterators(Iterator[] iterators) {
    this.iterators = iterators;
  }
  
  public JoinedIterators(List iterators1) {
    this( (Iterator[]) iterators1.toArray(ITERATORS));
  }
  
  public JoinedIterators(Iterator first, Iterator second) {
    this( new Iterator[] { first, second } );
  }
  
  @Override
  public boolean hasNext() {
    updateCurrentIterator();
    return currentIterator.hasNext();
  }

//call this before any Iterator method to make sure that the current Iterator
 // is not exhausted
 protected void updateCurrentIterator() {

   if (currentIterator == null) {
     if( iterators.length==0  ) {
       currentIterator = EmptyIterator.emptyIterator;
     }
     else {
       currentIterator = iterators[0];
     }
     // set last used iterator here, in case the user calls remove
     // before calling hasNext() or next() (although they shouldn't)
     lastUsedIterator = currentIterator;
   }

   while (! currentIterator.hasNext() && currentIteratorIndex < iterators.length - 1) {
     currentIteratorIndex++;
     currentIterator = iterators[currentIteratorIndex];
   }
 }

 static class EmptyIterator implements java.util.Iterator {
   public static final EmptyIterator emptyIterator = new EmptyIterator();
   public boolean hasNext() { return false; }
   public Object next() { return null; }
   public void remove() {
     throw new UnsupportedOperationException();
   }
  
 }
  @Override
  public Object next() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void remove() {
    // TODO Auto-generated method stub
    
  }

}
