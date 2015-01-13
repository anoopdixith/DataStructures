package com.practice.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class EvernoteInterview {
  private HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
  
  /*
   * This method takes the input text and the numberOfItems and returns the 
   * string array that is sorted according to the word frequency.
   */
  private List<String> wordFrequency(String text, int numberOfItems) {
    /* Convert the given string to a char array to not waste a lot of immutable strings */
    char[] textArray = text.toCharArray();

    // Cleanup the array
    textArray = this.cleanText(textArray);

    // Create string tokens. While on it, fill the hashmap of words and their frequencies.
    fillMap(textArray);

    /*
     * Now to sort the values of hashmap in O(n), I am using a non-comparison based sort because all
     * comparison based sorts have the lower bound of nlogn. So instead, counting sort is being
     * used. Why counting sort? Because, a. I know there won't be any 0 in the values of the
     * hashmap. b. the range of k could be known by single traversal c. the difference between max
     * and min of values is not very very large.
     */
    ArrayList<String> sortedArray = sortMap(wordCount, numberOfItems);
    return sortedArray;
  }

  private ArrayList<String> sortMap(HashMap<String, Integer> originalMap, int numberOfItems) {
    // Create a hashmap of word counts (values in the original hashmaps) and their indices

    // Create an array of integers from the above hashmap values to sort.
    int[] arr = new int[originalMap.size()];

    int index = 0;
    for (Integer frequency : originalMap.values()) {
      arr[index++] = frequency;
    }
    // Declare an ArrayList to hold the output strings
    ArrayList<String> sortedArr = new ArrayList<String>();
    // Call the counting sort method that returns an array of sorted word frequencies
    int arrSorted[] = countingSort(arr);
    Entry<String, Integer> entry = (Entry<String, Integer>) originalMap.entrySet();
    //Only add as many strings as asked in the "numberOfParameter".
    for (int i=0; i< arrSorted.length && i < numberOfItems; i++) {
      if (i == entry.getValue()) {
        sortedArr.add(entry.getKey());
        /*
         * After inserting the word to the output array, remove the entry from the hashmap so that
         * if there are multiple keys with same values, they all will be considered.
         */
        originalMap.remove(entry.getKey());
      }
    }
    return sortedArr;
  }

  /*
   * This is the O(n) sorting algorithm.
   * This is counting sort.
   * 
   * @param an array of integers
   * @return sorted array of integers
   */
  private int[] countingSort(int[] arr) {
    int max = arr[0];
    int min = arr[0];

    for (int i : arr) {
      if (arr[i] > max) {
        max = arr[i];
      }
      if (arr[i] < min) {
        min = arr[i];
      }
    }
    int range = max - min + 1;
    int[] count = new int[range];
    /*
     * For every element, make the count-frequency array
     */
    for (int i = 0; i < arr.length; i++) {
      count[arr[i] - min]++;
    }

    /*
     * Find the positions in the final array
     */
    for (int i = 1; i < range; i++) {
      count[i] += count[i - 1];
    }

    /*
     * Set the original array
     */
    int j = 0;
    for (int i = 0; i < range; i++) {
      while (j < count[i]) {
        arr[j++] = i + min;
      }
    }

    return arr;
  }

  /*
   * Instead of using String split on StringBuilder,I'm doing it manually just to make sure I don't
   * use a lot of inbuilt functions
   */
  private void fillMap(char[] textArray) {
    int i = 0, j = 0; // Primitives so I could use comma operators
    String textString = textArray.toString();
    for (int k = 0; k < textArray.length; k++) {
      if (textArray[k] == ' ') {
        j = k - 1;
        String wordToUpdate = textString.substring(i, j);
        if (wordCount == null) {
          wordCount.put(wordToUpdate, 1);
        } else {
          if (wordCount.containsKey(wordToUpdate)) {
            wordCount.put(wordToUpdate, wordCount.get(wordToUpdate) + 1);
          } else {
            wordCount.put(wordToUpdate, 1);
          }
        }
        i = k + 1;
      }
    }
  }

  /*
   * This method removes all the punctuations so that the fullstops, commas, question marks,
   * exclamations and semicolons are replaced by single space to separate the word. This is because
   * when they use one of these, there might not be spaces between words. E.g.
   * "This is a java code.It is platform independent". Here, there's no space between 'code' and
   * 'it'. But they will not be replaced is there's already space after them.
   */
  private char[] cleanText(char[] textArray) {
    for (int i = 0; i < textArray.length; i++) {
      if (textArray[i] == '.' || textArray[i] == ',' || textArray[i] == '?' || textArray[i] == ';'
          && i + 1 < textArray.length && textArray[i + 1] != ' ') {
        textArray[i] = ' ';
      }
    }
    return textArray;
  }
}
