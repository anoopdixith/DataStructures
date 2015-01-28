package com.practice.algorithms;

import java.io.InputStreamReader;
import java.util.*;

public class Billboard {
 public static void main(String args[]) {
   Scanner scanner = new Scanner(new InputStreamReader(System.in));
   String firstLine = scanner.nextLine();
   int N = Integer.parseInt(firstLine.split(" ")[0]);
   int K = Integer.parseInt(firstLine.split(" ")[1]);
   //System.out.println(N + " " + K);
   long[] input = new long[N]; 
   for(int i=0; i < N; i++) {
     input[i] = scanner.nextInt();
     //System.out.println(input[i]);
   }
   
   long sum[][] = new long[K+1][N];
   int j = 0;
   for(int i=1; i <= K; i++) {
     sum[i][0] = input[0];
   }
   for(int i=1; i <= K; i++) {
     int l = 1;
     while(l <= j) {
       sum[i][l] += input[l] + sum[i][l-1];
       l++;
     }
     j++;
   }
   
   /*
   for(int i=0; i <= K; i++) {
     for(int m=0; m < N; m++) {
       System.out.print(sum[i][m] + ",");
     }
     System.out.println();
   }
   */
   for(int m=1; m <= K; m++) {
     int saturation = m;
     for(int n = m; n < N; n++) {
       if(saturation < m) {
         sum[m][n] = Math.max(sum[m-1][n-1] + input[n], sum[m][n-1] + input[n]);
         if(!(sum[m][n] > sum[m][n-1])) {
           saturation = 0;
         }
         else {
           saturation++;
         }
       }
       else if(saturation == m){
         if(n > 1) {
           sum[m][n] = Math.max(sum[m-1][n-1] + input[n], sum[m][n-2] + input[n]);
         }
         else {
           sum[m][n] = Math.max(sum[m][n-1], input[n]);
         }
         if(!(sum[m][n] > sum[m][n-1])) {
           sum[m][n] = sum[m][n-1];
           saturation = 0;
         }
         else if(sum[m-1][n-1] == sum[m][n-2]) {
           saturation = 1;
         }
       }
     }
   }
   
   System.out.println();
   for(int i=0; i <= K; i++) {
     for(int m=0; m < N; m++) {
       System.out.print(sum[i][m] + ",");
     }
     System.out.println();
   }
   
   //System.out.println(sum[K][N-1]);
 }
}
