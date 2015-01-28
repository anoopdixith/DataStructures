package com.practice.algorithms;
//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
//CLASS BEGINS, THIS CLASS IS REQUIRED
public class GrayCheck
{
//METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
public static int grayCheck(byte term1, byte term2){
// INSERT YOUR CODE HERE
  int diff = 0;
  for(int i=1; i <= 8; i++) {
    if(((term1&1) ^ (term2&1)) == 1) {
      diff++;
    }
    if(diff > 1) {
      return 0;
    }
    term1 = (byte) (term1 >> 1);
    term2 = (byte) (term2 >> 1);
    System.out.println("diff is " + diff);
  }
  if(diff == 0) {
    return 0;
  }
  return 1;
}
//METHOD SIGNATURE ENDS

//DO NOT IMPLEMENT THE main( ) METHOD
public static void main(String[] args) 
{
   // PLEASE DO NOT MODIFY THIS FUNCTION
   // YOUR FUNCTION SHALL BE AUTOMATICALLY CALLED AND THE INPUTS FROM HERE SHALL BE PASSED TO IT
   byte term1=(byte)0xff,term2=(byte)0x00;
   int out;
   // ASSUME INPUTS HAVE ALREADY BEEN TAKEN
   out = grayCheck(term1,term2);
   System.out.println(out);
   //Print the output
}
}