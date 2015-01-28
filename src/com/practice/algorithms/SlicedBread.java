package com.practice.algorithms;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SlicedBread {
  public static void main(String args[]) {
    Scanner scanner = new Scanner(new InputStreamReader(System.in));
    Integer T = Integer.parseInt(scanner.nextLine());
    //System.out.println("T is " + T);
    String[] inputs = new String[T];
    for(int i=0; i < T; i++) {
      //System.out.println("take input " + i);
      inputs[i] = scanner.nextLine();
    }
    StringTokenizer token;
    Integer l;
    Integer b;
    int max = 0;
    for(int i=0; i < inputs.length; i++) {
      max = 0;
      token = new StringTokenizer(inputs[i]);
      l = Integer.parseInt((String) token.nextElement());
      b = Integer.parseInt((String) token.nextElement());
      int area = l*b;
      int j=1;
      while(area / (j*j) > 0) {
        if((area%(j*j) == 0) && (l%j == 0) && (b % j ==0)) {
            //System.out.println("j is " + j);
            max = area/(j*j);
        }
        j++;
      }
      System.out.println(max);
    }
    
  }
}
