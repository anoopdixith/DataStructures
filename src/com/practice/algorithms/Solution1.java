package com.practice.algorithms;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution1 {

    public static void main(String[] args) {
      Scanner scanner = new Scanner(new InputStreamReader(System.in));
      int numberOfTestcases = scanner.nextInt();
      int[] inputs = new int[numberOfTestcases];
      int i=0;
      while(numberOfTestcases-- > 0) {
        inputs[i++] = scanner.nextInt();
      }
      
      for(i =0; i < inputs.length;i++) {
        if(inputs[i] < 4) {
          System.out.println("0");
        }
        else 
          System.out.println(numberOfPrimes(inputs[i] - 2 ));
      }
    }

    private static int numberOfPrimes(int number) {
      if(number == 2)
        return 1;
      if(number == 3)
        return 2;
      int numberOfPrimes = 2; //initialized to two for 2 and 3.
      for(int i=4; i <= number; i++) {
        for(int j = 2; j <= Math.sqrt(i); j++) {
          if(i % j == 0) {
            continue;
          }
          numberOfPrimes++;
        }
      }
      return numberOfPrimes;
    }
}