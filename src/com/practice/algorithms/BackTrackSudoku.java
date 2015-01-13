package com.practice.algorithms;

public class BackTrackSudoku {
  private int[][] matrix;
  private final int NROW;
  private final int NCOL;
  public BackTrackSudoku(int[][] input) {
    //input will have the input sudoku matrix 0 is unfilled 
    //and rest are numbers between 1 to 9 included
    this.matrix = input;
    this.NROW = matrix.length;
    this.NCOL = matrix[0].length;
  }
  
  private boolean isValid() {
    boolean[][] rows = new boolean[NROW][NCOL];
    boolean[][] cols = new boolean[NROW][NCOL];
    boolean[][] boxes = new boolean[NROW][NCOL];
    int boxRow = 0;
    int boxCol = 0;
    int boxIndex = 0;
    int boxSize = (int)Math.sqrt(NROW);
    
    for(int i = 0; i < NROW; i++) {
      if(boxRow == 3) {
        boxRow = 0;
        boxIndex++;
      }
    }
    return false;
  }
  
  
  
  public static void main(String args[]) {
    int[][] input = {{1,2},{1,2}};
    BackTrackSudoku backTrackSudoku = new BackTrackSudoku(input );
  }
}
