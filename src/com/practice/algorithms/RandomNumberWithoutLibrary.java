package com.practice.algorithms;

public class RandomNumberWithoutLibrary {
  public int randomNumber(int min, int max) {
    return min + limitedRandomNumber(max - min);
  }

  private int limitedRandomNumber(int limit) {
    Object obj = new RandomNumberWithoutLibrary();
    int hashCode = obj.hashCode();
    //System.out.println("Hashcode is " + obj.toString());
    return hashCode;
  }
  
  public static void main(String args[]) {
    RandomNumberWithoutLibrary rnwl = new RandomNumberWithoutLibrary();
    System.out.println(rnwl.randomNumber(0, 30));
  }
}
