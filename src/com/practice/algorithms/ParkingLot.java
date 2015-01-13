package com.practice.algorithms;

public class ParkingLot {
  public static void main(String args[]) {
    char[] current = {'b', 'd' , 'a', '_', 'c', 'e'};
    char[] target =  {'a', '_' , 'd', 'b', 'e', 'c'};
    repark(current, target);
  }
  
  public static void repark(char[] current, char[] target) {
    int emptyPos = -1;
    //keep track of empty position
    for(int i=0; i < current.length; i++) {
      if(current[i] == '_') {
        emptyPos = i;
      }
    }
    int i=0;
    while(i < current.length) {
      boolean moved = false;
      for(int j=0; j < current.length; j++) {
        if((current[i] == target[j]) && (current[j] == '_') && (current[i]!='_')) {
          current[j] = current[i];
          current[i] = '_';
          emptyPos = i;
          //if a car is moved, the check starts from beginning as the 
          //whole process is being done in-place
          moved = true;
        }
      }
      if(moved) {
        i=0;
      }
      else {
        i++;
      }
    }
    //if still not re-parked, use the empty spot as a 'temp' variable
    //to move the other cars to their right spot
    if(!compare(current, target)) {
      for(i=0; i < current.length; i++) {
        if((current[i] != target[i]) && current[i] != '_') {
          char temp = target[i];
          if(temp == '_') {
            current[emptyPos] = current[i]; 
            current[i] = '_';
            emptyPos = i;
          }
          else {
            int index = -1;
            for(int m=0; m < current.length;m++) {
                if(current[m] != '_') {
                  if(current[m] == target[i]) {
                  index = m;
                }
              }
            }
            //This below assignment made to indicate the car is first moved to
            //an empty spot
            current[emptyPos] = current[i];
            //This below step is 'programmetically' unnecessary but done to
            //show that an empty spot gets created when a car is moved
            current[i] = '_';
            //moving car from empty spot to its right target place
            current[i] = temp; 
            current[index] = current[emptyPos];
            current[emptyPos] = '_';
            }
        }
      }
    }
    
    print(current);
    
  }
  
  public static void print(char[] arr) {
    for(char c:arr) {
      System.out.print(c + ",");
    }
  }
  
  public static boolean compare(char[] first, char[] second) {
    if(first.length != second.length) {
      return false;
    }
    for(int i=0; i < first.length; i++) {
      if(first[i] != second[i]) {
        return false;
      }
    }
    
    return true;
  }
}
