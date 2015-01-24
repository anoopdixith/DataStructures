package com.practice.algorithms;
public class MaximumSubmatrixSum {
  //Sub-matrix of size pxq with maximum sum  
  public int maxSubmatrixSum(int[][] input, int p, int q) {
    int m = input.length; int n = input[0].length;
    
    //sum[i][j] represents sum of elements in i'th row from j to j+q-1
    int[][] sum = new int[m][n - q +1];
    for(int i=0; i < m; i++) 
      for(int l=0; l < q; l++) 
        sum[i][0] += input[i][l];
    for(int i=0; i < m; i++) 
      for(int j = 1; j < n - q +1; j++) 
        sum[i][j] = sum[i][j-1] - input[i][j-1] + input[i][j+q-1];
    
    //maxSum[i][j] represents sum of sub-matrix of pxq that starts at (i,j)
    int maxSum[][] = new int[m-p+1][n-q+1];
    for(int j =0; j < n-q+1; j++)
      for(int l=0; l < p; l++)
        maxSum[0][j] += sum[l][j]; 
    for(int i=1; i < m-p+1; i++)
      for(int j=0; j < n -q+1; j++)
        maxSum[i][j] = maxSum[i-1][j] + sum[i+p -1][j] - sum[i-1][j];
    return findMax(maxSum);
  }
  
  private int findMax(int[][] input) {
    int m = input.length; int n = input[0].length;
    int max = Integer.MIN_VALUE; 
    for(int i=0; i < m; i++)
      for(int j = 0; j < n; j++)
        if(input[i][j] > max)
          max = input[i][j];
    return max;
  }
}
