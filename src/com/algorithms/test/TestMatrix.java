package com.algorithms.test;

import com.practice.algorithms.Matrix;

public class TestMatrix {
  static int[][] inputMatrix = {{11,2,5}, {3,4,7}};
  public static void main(String args[]) {
    Matrix matrix = new Matrix(inputMatrix);
    int[][] transposedMatrix = matrix.transposeMatrix();
    Matrix transposedMat = new Matrix(transposedMatrix);
    transposedMat.printMatrix();
  }
}
