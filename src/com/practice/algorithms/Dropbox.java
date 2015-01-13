package com.practice.algorithms;

public class Dropbox {
    static int wordpattern(String pattern, String input) {
    
    if(pattern.length() > input.length()) {
      return 0;
    }
    
    if(pattern.length() == input.length()) {
       if(pattern.equalsIgnoreCase(input)) {
         return 1;
       }
       return 0;
    }
    
    for(int i =0; i < pattern.length(); i++) {
      char chunk = pattern.charAt(i);
      String potentialMatch = "";
      for(int j =0; j < input.length();j++) {
        potentialMatch += input.charAt(j);
        for(int k=j+1; k < input.length();k++) {
          if(input.substring(k, k+potentialMatch.length()).equalsIgnoreCase(potentialMatch)) {
            String nextMatch = input.substring(k, k+potentialMatch.length());
            String inBetween = input.substring(j+1, k-1);
          }
        }
      }
    }
    return 0;
    }

public static void main(String args[]) {
  
}
}
