package com.practice.algorithms;

public class Egain1 {
  public static void main(String args[]) {
    double[] input = { 2.4, -1.2, 0, 5, 33.21};
    double[] output = new double[3];
    output = findMaxMin(input);
    System.out.println("Two highest and one smallest in order is: " + output[0] + "," + output[1] + "," + output[2]);
  }

  private static double[] findMaxMin(double[] input) {
    double[] output = new double[3];
    double maxFirst = Double.NEGATIVE_INFINITY;
    double maxSecond = Double.NEGATIVE_INFINITY;
    double min = Double.POSITIVE_INFINITY;
    
    for(double d:input) {
      //number is greater than max
      if(Double.compare(d, maxFirst) > 0) {
        maxSecond = maxFirst;
        maxFirst = d;
      }
      //number is between max and second max
      else if(Double.compare(d, maxSecond) > 0) {
        maxSecond = d;
      }
      //number is less than min
      if(Double.compare(d, min) < 0) {
        min = d;
      }
    }
    output[0] = maxFirst;
    output[1] = maxSecond;
    output[2] = min;
    return output;
  }
}
