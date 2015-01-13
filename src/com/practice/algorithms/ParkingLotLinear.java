package com.practice.algorithms;

import java.util.HashMap;

public class ParkingLotLinear {
  public static void main(String args[]) {
    char[] current = {'b', 'd' , 'a', '_', 'c', 'e'};
    char[] target =  {'a', '_' , 'd', 'b', 'e', 'c'};
    repark(current, target);
  }
  
  public static void repark(char[] current, char[] target) {
    //A hashmap to keep track of in what position a car is in 'current'
    HashMap<Character, Integer> locations = new HashMap<Character, Integer>();
    
    //Build the hashmap - O(n)
    for(int i=0; i < current.length; i++) {
      locations.put(current[i], i);
    }
    
    //Traverse through the target - O(n)
    for(int i=0; i < target.length; i++) {
      
      //if the car is already at the right place, don't do anything 
      if(target[i] == current[i]) {
        continue;
      }
      //see what should come at 'i'th position in current - O(1)
      char toPark = target[i];
      System.out.println("toPark is " + toPark);
      //find where this is in the 'current' setup - O(1)
      int currentPosition = Integer.valueOf(locations.get(toPark));
      System.out.println("Current Position is " + currentPosition);
      //find the empty spot - O(1)
      int emptySpot = Integer.valueOf(locations.get('_'));
      System.out.println("Empty Pos is " + emptySpot);
      
      //if the target spot itself is empty - O(1)
      if(toPark == '_') {
        char temp = current[i];
        current[i] = current[emptySpot];
        current[emptySpot] = temp;
        current[i] = '_';
        //needed to update the hashmap
        emptySpot = i;
      }
      else {
        //movie the car "toPark" from its "currentPosition" to 'i'th position
        //by using "emptySpot" as a "temporary variable - O(1)
        current[emptySpot] = current[i];
        current[i] = current[currentPosition];
        current[currentPosition] = current[emptySpot];
        current[emptySpot] = '_';
      }
      
      //update the hashmap
      locations.put(current[i], i);
      locations.put(current[currentPosition], currentPosition);
      locations.put('_', emptySpot);
      print(current);
      System.out.println();
    }
    
    //print(current);
    
  }
  
  public static void print(char[] arr) {
    for(char c:arr) {
      System.out.print(c + ",");
    }
  }
}
