package com.practice.algorithms;

public class RomanNumerals {
  
  public static void main(String args[]) {
    int number = 762;
    try {
      String roman = new RomanNumerals().numberToRoman(number);
      System.out.println("Number is " + number + " roman is " + roman);
    } catch (InputExceededRangeException e) {
      e.printStackTrace();
    }
    
  }
  
  
  public String numberToRoman(int number) throws InputExceededRangeException {
    StringBuilder roman = new StringBuilder("");
    if(number <1 || number > 3688) {
      throw new InputExceededRangeException("Input exceeded the range");
    }
    int[] points = {1,5,10,50,100,500,1000};
    char[] pointsValues = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    int pointsIndex = points.length - 1;
    while(number > 1) {
      int quotient = number / points[pointsIndex];
      int remainder = number % points[pointsIndex];
      if(number - remainder == 40) {
        roman.append("XL");
        number = remainder;
        continue;
      }
      if(number - remainder == 400) {
        roman.append("CD");
        number = remainder;
        continue;
      }
      if(number - remainder == 90) {
        roman.append("XC");
        number = remainder;
        continue;
      }
      if(number - remainder == 900) {
        roman.append("CM");
        number = remainder;
        continue;
      }
      if(number - remainder == 4) {
        roman.append("IV");
        number = remainder;
        continue;
      }
      if(number - remainder == 9) {
        roman.append("IX");
        number = remainder;
        continue;
      }
      if(remainder < number) {
        for(int k=1; k <= quotient; k++) {
          roman.append(pointsValues[pointsIndex]);
        }
        number = remainder;
      }
      else {
        pointsIndex--;
      }
    }
    
    return roman.toString();
  }
}
