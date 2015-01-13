package com.practice.algorithms;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BrainFuckCompiler {
  private char[] inputCode;
  private ArrayList<Integer> dataSegment = new ArrayList<Integer>();
  private int dataPointer = 0;
  private int instructionPointer = 0;
  public BrainFuckCompiler(String inputCode) {
    this.inputCode = inputCode.toCharArray();
  }
  
  public void compile() {
    if(!compilationCheck(inputCode)) {
      System.out.println("Parenthesis Mismatch");
      return;
    }
    
    for(int i=0; i < inputCode.length; i++) {
      Character c = inputCode[i];
      switch(c)
      {
        case '>':
        {
          dataPointer++;
          if(dataSegment.size()  < dataPointer) {
            while(dataSegment.size() < dataPointer) {
              dataSegment.add(0);
            }
          }
          break;
        }
        case '<':
        {
          dataPointer--;
          break;
        }
        case '+':
        {
          if(dataSegment.size()  <= dataPointer) {
            while(dataSegment.size() <= dataPointer) {
              dataSegment.add(0);
            }
          }
          dataSegment.set(dataPointer, dataSegment.get(dataPointer) + 1);
          break;
        }
        case '-':
        {
          if(dataSegment.size()  <= dataPointer) {
            while(dataSegment.size() <= dataPointer) {
              dataSegment.add(0);
            }
          }
          dataSegment.set(dataPointer, dataSegment.get(dataPointer) - 1);
          break;
        }
        case '.':
        {
          if(dataSegment.size()  <= dataPointer) {
            while(dataSegment.size() <= dataPointer) {
              dataSegment.add(0);
            }
          }
          System.out.print(Character.toChars(dataSegment.get(dataPointer)));
          break;
        }
        case ',':
        {
          Scanner scanner = new Scanner(System.in);
          dataSegment.set(dataPointer, scanner.nextInt());
          scanner.close();
          break;
        }
        case '[':
        {
          if(dataSegment.get(dataPointer) == 0) {
            for(int j = i+1; j < inputCode.length; j++) {
              if(inputCode[j] == ']') {
                i = j+1;
                break;
              }
            }
           break; 
          }
        }
        case ']':
        {
          if(dataSegment.get(dataPointer) == 0) {
            for(int j = i-1; j > 0; j--) {
              if(inputCode[j] == '[') {
                i = j-1;
                break;
              }
            }
           break; 
          }
        }
        
      }
    }
  }
  
  public boolean compilationCheck(char[] input) {
    Stack<Character> parenholder = new Stack<Character>(); 
    for(char i:input) {
      if(i == '[') {
        parenholder.push(i);
      }
      if(i == ']') {
        if(parenholder.pop() != '[') {
          return false;
        }
      }
    }
    return parenholder.isEmpty();
  }
  
}
