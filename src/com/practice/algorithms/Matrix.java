package com.practice.algorithms;

public class Matrix {
  int[][] matrix;
  public Matrix(int[][] matrix) {
    this.matrix = matrix;
  }
  public int[][] transposeMatrix() {
    int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
    for(int row=0; row < matrix.length;row++) {
      for(int col=0; col < matrix[0].length; col++) {
        transposedMatrix[col][row] = matrix[row][col];
      }
    }
    return transposedMatrix;
  }
  public int[][] rotateRight() throws Exception {
    if(matrix.length != matrix[0].length) {
      throw new Exception();
    }
    int n = matrix.length;
    for(int layer =0 ; layer < n/2; layer++) {
      int first = 0;
      int last = n - 1 - layer;
      for(int i = first; i < last; i++) {
        int offset = i - first;
        int top = matrix[first][i];
        matrix[first][i] = matrix[last - offset][first];
        matrix[last - offset][first] = matrix[last][last - offset];
        matrix[last][last - offset] = matrix[i][last];
        matrix[i][last] = top; 
      }
    }
    return matrix;
  }
  public void printMatrix() {
    int rowLength = matrix.length;
    int colLength = matrix[0].length;
    for(int i = 0; i < rowLength; i++) {
      for(int j = 0; j < colLength; j++) {
        System.out.print(matrix[i][j] + ",");
      }
      System.out.println();
    }
  }
}
