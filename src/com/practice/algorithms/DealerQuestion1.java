package com.practice.algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.ini4j.InvalidFileFormatException;

/*
 * This class has a method printSum that prints the sum of key counts
 *  of all key-value pairs in a given file.
 */
public class DealerQuestion1 {
  /*
   * Main method to call the actual function
   */
  public static void main(String args[]) {
    DealerQuestion1 dealer = new DealerQuestion1();
    String filePath = "/Users/anoop/Documents/dealer/question1.txt";
    dealer.printSumCount(filePath);
  }

  /*
   * @param : File path of the input file that contains the key-value pair.
   * @return: Nothing
   */
  private void printSumCount(String filePath) {

    /*
     * Using Hashmap to keep the count of each keys If the key already exists, count is added to its
     * value, otherwise, it's created afresh.
     */
    HashMap<String, Integer> keyCount = new HashMap<String, Integer>();
    
    // Using the buffered reader for file reading 
    try {
      BufferedReader br = new BufferedReader(new FileReader(filePath));
      //Using StringBuilder to avoid creation of so many immutable String objects
      String line = "";
      while (true) {
        line = br.readLine();
        if(line == null) {
          br.close();
          break;
        }
        StringTokenizer tokenizer = new StringTokenizer(line,",");
        //Check fi the file format is correct. If not, throw an exception
        if(tokenizer.countTokens() != 2) {
          br.close();
          throw new InvalidFileFormatException("File format error. Should be in key:value format");
        }
        
        String name = tokenizer.nextToken();
        Integer count = Integer.parseInt(tokenizer.nextToken());
          
        //If the 'key' doesn't exist,insert it.
        if(keyCount.get(name) == null) {
          keyCount.put(name, count);
        }
        //If the key already exists, update the count
        else {
          keyCount.put(name, keyCount.get(name) + count);
        }
      }
      //Close the resource to avoid leakage
      br.close();
      print(keyCount);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }

  private void print(HashMap<String, Integer> keyCount) {
    /*
     * Using Iterator to scan through the values.
     */
    Iterator<String> iterator = keyCount.keySet().iterator();
    while(iterator.hasNext()) {
      String key = iterator.next();
      System.out.println("The total for " + key + " is " + keyCount.get(key) + ".");
    }
  }
}
