package com.practice.algorithms;

import java.util.HashMap;

public class ParkingLotSortingOnEmptySpot {
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
    
    //Sort based on empty spot, i.e., find empty spot, fill it - creates now empty spot.
    //This is O(n) and reduces the number of moves.
    while(true) {
      //find the empty spot to fill
      int emptySpot = locations.get('_');
      //see what needs to be filled
      char toFill = target[emptySpot];
      //if the empty spot is already in the right spot, 
      //we can't proceed unless we start swapping. So, break.
      if(toFill == '_') {
        break;
      }
      //Otherwise, move the toFill car to the current empty spot
      int positionOfToFillInCurrent = locations.get(toFill);
      current[emptySpot] = current[positionOfToFillInCurrent];
      current[positionOfToFillInCurrent] = '_';
      
      //Update hashmap
      locations.put(toFill, emptySpot);
      locations.put('_', positionOfToFillInCurrent);
    }
    
    //Traverse through the target - O(n)
    for(int i=0; i < target.length; i++) {
      
      //if the car is already at the right place, don't do anything 
      if(target[i] == current[i]) {
        continue;
      }
      //see what should come at 'i'th position in current - O(1)
      char toPark = target[i];
      //find where this is in the 'current' setup - O(1)
      int currentPosition = Integer.valueOf(locations.get(toPark));
      //find the empty spot - O(1)
      int emptySpot = Integer.valueOf(locations.get('_'));
      
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
      
    }
    print(current);
    
  }
  
  public static void print(char[] arr) {
    for(char c:arr) {
      System.out.print(c + ",");
    }
  }
}
