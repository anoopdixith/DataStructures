package com.algorithms.euler;

public class Euler38 {
  public static void main(String args[]) {
    int numberOfDigits = 8;
    int limit = findLimit(numberOfDigits);
    System.out.println("limit is " + limit);
    for(int i=limit; i >= 2; i--) {
      for(int j=2; j <=numberOfDigits; j++) {
        int[] values = multiply(i, j);
        String concatenated = concatnateAsString(values);
        if(concatenated.length() > numberOfDigits) {
          break;
        }
        if((concatenated.length() == numberOfDigits) && isContainAll(Integer.parseInt(concatenated),numberOfDigits)) {
          System.out.println("Final result is " + concatenated);
          System.exit(0);
        }
      }
    }
  }
  
  private static boolean isContainAll(int concatenated, int numberOfDigits) {
    boolean[] allNumbers = new boolean[numberOfDigits+1];
    allNumbers[0] = true;
    while(concatenated > 0) {
      int rem = concatenated%10;
      if(rem > numberOfDigits) {
        return false;
      }
      allNumbers[rem] = true;
      concatenated/=10;
    }
    for(boolean b:allNumbers) {
      if( b == false) {
        return false;
      }
    }
    return true;
  }

  private static int[] multiply(int i, int j) {
    int[] result = new int[j];
    for(int k=1; k <=j; k++) {
      result[k-1] = i * k;
    }
    /*
    for(int m:result) {
      System.out.print(m + ",");
    }
    */
    return result;
  }

  private static int findLimit(int numberOfDigits) {
    int startingPointNumberOfDigit = numberOfDigits/2;
    int startingPoint = getStartingPoint(startingPointNumberOfDigit);
    int i =0;
    for(i= startingPoint; getlength(concatnate(i,2*i)) <= numberOfDigits ; i++) {
    }
    return (i-1);
  }

  private static int concatnate(int ... elements) {
    //System.out.println("Inside concatenate elements length is " + elements.length);
    int numberOfElements = elements.length;
    int result = elements[0];
    for(int i=1; i < numberOfElements; i++) {
      result = (result * (int)Math.pow(10, getlength(elements[i]))) + elements[i];
    }
    //System.out.println("result is " + result);
    return result;
  }
  
  private static String concatnateAsString(int ... elements) {
    //System.out.println("Inside concatenate elements length is " + elements.length);
    StringBuilder str = new StringBuilder();
    for(int i=0; i < elements.length;i++) {
      str =str.append(elements[i]);
    }
    //System.out.println("result is " + str.toString());
    return str.toString();
  }

  private static int getlength(int i) {
    int length = 0;
    while(i > 0) {
      length++;
      i/=10;
    }
    return length;
  }

  private static int getStartingPoint(int startingPointNumberOfDigit) {
    return (int) Math.pow(10, startingPointNumberOfDigit);
  }
}
