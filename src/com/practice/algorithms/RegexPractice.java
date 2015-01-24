package com.practice.algorithms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class RegexPractice {
  public static void main(String args[]) {
    String allWords = new RegexPractice().getEnglishWords();
    //System.out.println(allWords);
    StringTokenizer tokenizer = new StringTokenizer(allWords);
    String wordToReturn = "";
    int maxWordLength = Integer.MIN_VALUE;
    String regex1 = "..tion";
    
    //All words that end in gry
    String regex2 = ".+gry";
    
    //All words in vowel alphabetical order
    String regex3 = ".+a.+e.+i.+o.+u.+";
    
    //Words without vowels
    String regex4 = "[^aeiou]+";
    
    String regex5 = ".+uu.+";
    
    String regex6 = "[fkine]{5}";
    
    while(tokenizer.hasMoreTokens()) {
      String currentWord = tokenizer.nextToken();
      if(currentWord.matches(regex6)) {
        System.out.println("Regex is " + regex6 + " word is " + currentWord);
        if(currentWord.length() > maxWordLength) {
          maxWordLength = currentWord.length();
          wordToReturn = currentWord;
        }
      }
    }
    System.out.println("Longest such is " + wordToReturn);
  }

  private String getEnglishWords() {
    StringBuilder allWords = new StringBuilder();
    try(BufferedReader br = new BufferedReader(new FileReader("/Users/anoop/Documents/words.txt"))) {
      String line = "dummybeginningelementqazrtfgt";
      while (line != null) {
        line = br.readLine();
        allWords.append(line);
        allWords.append(" ");
        //System.out.println("inserting " + line);
      }
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return allWords.toString();
  }
}
