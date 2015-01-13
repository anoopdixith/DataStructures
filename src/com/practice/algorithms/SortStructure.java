package com.practice.algorithms;

public class SortStructure {
  private int[] arrayToSort;
  private int sizeOfArray;
  private int sum = 0;
  private int differenceMean = 0;
  private int max = Integer.MIN_VALUE;
  private int min = Integer.MAX_VALUE;
  
  //Sorting data structure
  class Element{
    private int value;
    private int count = 1;
    private boolean hasMore = false;
    //Maximum number of different values in the same element
    private int maximumExtraElements = 10;
    //An internal array that needs to be sorted using the same algo or a different sorting algo.
    private int[] internalArray = new int[maximumExtraElements];
    private int internalArrayIndex = 1;
    
    public Element(int value) {
    //first time number
      this.value = value;
      this.hasMore = false;
      this.internalArray[0] = value;
    }
    
    public void updateElement(int value) {
      //this is the same number
      if(this.value == value ) {
        this.count++;
      }
      //this is a new number
      else {
        this.hasMore = true;
        internalArray[internalArrayIndex++] = value;
      } 
    }
  }
  
  public Element[] fillElements(int[] arrayToSort) {
    //Multiplier is used to blow up the element array size.
    int multiplier = 2;
    int finalSum = sum * multiplier;
    Element[] elementArray = new Element[sum*multiplier + 1];
    for(int i = arrayToSort.length - 1; i >= 0; i--) {
      int quotient = 0;
      if(arrayToSort[i] != 0) {
        quotient = finalSum / arrayToSort[i];
      }
      if(elementArray[quotient] == null) {
        elementArray[quotient] =  new Element(arrayToSort[i]);
      }
      else {
        elementArray[quotient].updateElement(arrayToSort[i]);
      }
    }
    return elementArray;
  }
  
  public int[] cleanReturn(Element[] elementArray) {
    int[] resultArray = new int[sizeOfArray];
    int index = 0;
    for(int i = elementArray.length - 1; i >=0; i-- ) {
      if(elementArray[i] == null) {
        continue;
      }
      Element currentElement = elementArray[i];
      if(!currentElement.hasMore) {
        while(currentElement.count > 0) {
          resultArray[index++] = currentElement.value;
          currentElement.count--;
        }
      }
      else {
        SortStructure sortStructureInternal = new SortStructure(currentElement.internalArray);
        int[] internalSortedArray = sortStructureInternal.sortInternal(currentElement.internalArray);
        for(int j=internalSortedArray.length - 1; j >=0; j--) {
          resultArray[index++] = internalSortedArray[j];
        }
      }
    }
    return resultArray;
  }
  
  public int[] sortInternal(int[] array) {
    return cleanReturn(fillElements(array));
  }

  public SortStructure(int[] arrayToSort) {
    int difference = 0;
    this.arrayToSort = arrayToSort;
    this.sizeOfArray = arrayToSort.length;
    //Not including 0 to avaoid checks while calculating difference.
    //Countdown for loop for speed
    for(int i= sizeOfArray - 1; i >0; i--) {
      if(arrayToSort[i] < 0) {
        throw new NumberFormatException();
      }
      sum += arrayToSort[i];
      if(arrayToSort[i] > max) {
        max = arrayToSort[i];
      }
      if(arrayToSort[i] < min) {
        min = arrayToSort[i];
      }
      int diff = (arrayToSort[i] - arrayToSort[i-1]);
      difference += diff > 0? diff: -diff; 
    }
    //Taking care of arrayToSort[0]
    sum += arrayToSort[0];
    max = max > arrayToSort[0]?max:arrayToSort[0];
    min = min < arrayToSort[0]?min:arrayToSort[0];
    differenceMean = difference / sizeOfArray;
  }
  
  public void printStats() {
    System.out.print("Input array = ");
    
    for(int i = 0; i < sizeOfArray-1; i++ ) {
      System.out.print(arrayToSort[i] + ",");
    }
    System.out.println(arrayToSort[sizeOfArray-1]);
    
    System.out.println("Size of the array = " + sizeOfArray);
    System.out.println("Sum of the elements = " + sum);
    System.out.println("Max element = " + max);
    System.out.println("Min element = " + min);
    System.out.println("Average difference = " + differenceMean);
  }
  
  
}
