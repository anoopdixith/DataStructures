package com.practice.algorithms;

public class CoinChangeProblem {
  public int numberOfWaysRecursion(int[] S, int m, int n) {
    if(n ==0) {
      return 1;
    }
    if(m < 1 && n > 0) {
      return 0;
    }
    if(n < 0 ) {
      return 0;
    }
    return numberOfWaysRecursion(S, m, n - S[m-1]) + numberOfWaysRecursion(S, m-1, n);
  }
  
  public int numberOfWaysDP1(int S[], int m, int n) {
    int[][] table = new int[n+1][m];
    /*
     * table[i][j] is number of ways of making n using upto m[i] coins
     */
    for(int i=0; i < m; i++) {
      table[0][i] = 1;
    }
    for(int i=1; i < n+1; i++) {
      for(int j=0; j < m; j++) {
        int x = i - S[j] >= 0? table[i - S[j]][j] : 0;
        int y = j >=1?table[i][j-1] :0;
        table[i][j] = x + y;
      }
    }
    return table[n][m-1];
  }
  
  public int numberOfWaysDP2(int S[], int m, int n) {
    int[] table = new int[n+1];
    /*
     * table[i] stores the number of solutions for value i.
     */
    table[0] = 1;
    for(int i=0; i < m; i++) {
      for(int j = S[i]; j <= n; j++) {
        table[j] += table[j - S[i]]; 
      }
    }
    return table[n];
  }
  
  public static void main(String args[]) {
    int[] input = {1,2,3};
    int sum = 4;
    int m = 3;
    CoinChangeProblem ccp = new CoinChangeProblem();
    System.out.println("Recur " + ccp.numberOfWaysRecursion(input, m, sum));
    System.out.println("DP1 " +ccp.numberOfWaysDP1(input, m, sum));
    System.out.println("DP2 " +ccp.numberOfWaysDP2(input, m, sum));
  }
}
