package com.practice.algorithms;

public class SpiralOfAMatrix {
  public static void main(String args[]) {
    int row = 5;
    int col = 5;
    int[][] matrix = new int[row][col];
    int k=1;
    for(int i=0; i < row; i++) {
      for(int j=0; j < col; j++) {
        matrix[i][j] = k++;
      }
    }
    printSpiral(matrix);
  }
  
  public static void printSpiral(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    
    int k = 0; //row index
    int l = 0; //column index
    int m = row -1; //ending row index
    int n = col - 1; //ending column index
    int i;

    while(k <= m && l <= n) {
      for(i=l; i <= n; i++) {
        System.out.print(matrix[k][i] + " ");
      }
      k++;
      
      for(i=k; i <= m; i++) {
        System.out.print(matrix[i][n] + " ");
      }
      n--;
      
      if(k <= m) {
      for(i = n; i >=l; i--) {
        System.out.print(matrix[m][i] + " ");
      }
      m--;
      }
      
      if(l <= n) {
        for(i = m; i >= k; i--) {
          System.out.print(matrix[i][l] + " ");
        }
      }
      l++;
    }
  }
}
