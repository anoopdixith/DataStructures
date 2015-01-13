package com.practice.algorithms;

import java.util.Random;

public class KnuthShuffle {
  public static int[] shuffle(int[] array) {
    for(int i = array.length - 1; i > 1; i--) {
      int random1 = randInt(0,array.length - 1);
      int random = randInt(0,i);
      int temp = array[i];
      array[i] = array[random];
      array[random] = temp;
    }
    
    return array;
  }
  
  public static int randInt(int min, int max) {

    // NOTE: Usually this should be a field rather than a method
    // variable so that it is not re-seeded every call.
    Random rand = new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    
    //clever.. Just find a number in its difference and add minimum
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
}
  
  public static void main(String args[]) {
    int array[] = {1,2,3,4,5,6,7};
    array = shuffle(array);
    for(int i = 0; i < array.length; i++) {
      System.out.print(array[i] + ",");
    }
    
  }
}
