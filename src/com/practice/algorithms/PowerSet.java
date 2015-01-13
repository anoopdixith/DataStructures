package com.practice.algorithms;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PowerSet {
  public <T> Set<Set<T>> powerSet(Set<T> input) {
    Set<Set<T>> result = new HashSet<Set<T>>();
    if(input.isEmpty()) {
      Set<T> emptySet = Collections.emptySet();
      result.add(emptySet);
    }
    else {
      for(T e:input) {
        Set<T> t = copyWithout(input, e);
        System.out.println("t is : " + t);
        Set<Set<T>> ps = powerSet(t);
        System.out.println("ps is : " + ps);
        result.addAll(ps);
        
        for(Set<T> ts: ps) {
          result.add(copyWith(ts, e));
        }
        System.out.println("result is : " + result);
        break;
      }
    }
    return result;
  }
  
  private <T> Set<T> copyWith(Set<T> input, T e) {
    Set<T> result = new HashSet<T>(input);
    result.add(e);
    return result;
  }
  
  private <T> Set<T> copyWithout(Set<T> input, T e) {
    Set<T> result = new HashSet<T>(input);
    result.remove(e);
    return result;
  }
  
  public static void main(String args[]) {
    Set<String> input = new HashSet<String>();
    input.add("a");
    input.add("b");
    input.add("c");
    System.out.println(new PowerSet().powerSet(input));
  }
}
