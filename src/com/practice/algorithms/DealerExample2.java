package com.practice.algorithms;

/*
 * This class has a method isPalindrome that checks if a String is a Palindrome or not.
 */
public class DealerExample2 {
  public static void main(String a[]) {
    String string = "abcchba";
    System.out.println("Is given string \'" + string + "\' a palindrome? " + isPalindrome(string));
  }

  /*
   * Method that check if a String is a palindrome of not
   * @param: String object to check if it's a palindrome or not
   * @return: boolean value which is <code>true</code> if the input String 
   * is a plaindrome.<code>false</code> otherwise.
   */
  private static boolean isPalindrome(String string) {
    //Convert the string to char array so that 
    // unnecessary String objects are not created  because of immuatble nature of String
    char[] input = string.toCharArray();
    
    //check for charater i and length-i in each iteration.
    //If they are different, return false.
    //Do this till we reach the mid point
    int mid = input.length /2;
    int length = input.length;
    for(int i =0; i <= mid; i++) {
      if(input[i] != input[length - 1 - i])
        return false;
    }
    return true;
  }
}
