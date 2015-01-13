package com.practice.algorithms;

/* Answer made better here:
 * http://stackoverflow.com/questions/26222032/reverse-of-a-number-taking-care-of-boundary-conditions?noredirect=1#comment41127452_26222032
 */
public class NumberReverse {
  public static void main(String args[]) {
    System.out.println("Reverse of " + Integer.MAX_VALUE + " is "
        + reverseNumber(Integer.MAX_VALUE));
  }

  private static int reverseNumber(int number) {
    int remainder = 0, sum = 0; // One could use comma separated declaration for primitives and
                                // immutable objects, but not for Classes or mutable objects because
                                // then, they will allrefer to the same element.
    boolean isNegative = number < 0 ? true : false;
    if (isNegative)
      number = Math.abs(number); // doesn't work for Int.MIN_VALUE
                                 // http://stackoverflow.com/questions/5444611/math-abs-returns-wrong-value-for-integer-min-value
    
    System.out.println(number);
    while (number > 0) {
      remainder = number % 10;
      if (!(sum <= ((Integer.MAX_VALUE -remainder) / 10))) {
        //next *10 + remainder will exceed the boundaries of Integer.
        throw new RuntimeException("Over or under the limit");
      }
      sum = sum * 10 + remainder;
      /* Never works, because int won't throw error for outside int limit, it just wraps around */
      if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
        throw new RuntimeException("Over or under the limit");
      }
      /* end */
      /* This doesn't work always either.
       * For eg. let's take a hypothetical 5 bit machine.
       * If we want to reverse 19, 91 will be the sum and it is (in a 5 bit machine), 27, valid again!
       */
      if (sum < 0) {
        throw new RuntimeException("Over or under the limit");
      }

      number /= 10;
    }
    return isNegative ? -sum : sum;

  }
}
