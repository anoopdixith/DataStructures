package com.practice.algorithms;

public class NextPalindromeYear {
  // Date in mmddyyyy format
  //12032014
  public int nextPalindromeYear(String date) {
    char[] dateArr = date.toCharArray();
    int[] dateIntArr = new int[dateArr.length];
    int[] numberOfDays = {31,28,31,30,31,30,31,31,30,31,30,31};
    for(int i=0; i < dateArr.length;i++) {
      dateIntArr[i] = dateArr[i] - '0';
    }
    int month = dateIntArr[0] * 10 + dateIntArr[1];
    int day = dateIntArr[2] * 10 + dateIntArr[3];
    int year = 0;int pow = 1;
    for(int i= 7; i > 3; i--) {
      year += dateIntArr[i] * pow ;
      pow *= 10;
    }
    int givenYear = year;
    //System.out.println("Month is " + month);
    //System.out.println("Date is " + day);
    int nearestYear = Integer.MAX_VALUE;
    int splitType = -1;
    while(true) {
      System.out.println("Year is " + year);

      //first way of splitting 2014 = 20,14
      int split1 = year / 100;
      int split2 = year % 100;
      split1 = ((split1 % 10) * 10 ) + (split1/10);
      split2 = ((split2 % 10) * 10 ) + (split2/10);
      //System.out.println("Split 1 is " + split1);
      //System.out.println("Split 2 is " + split2);
      boolean validDate = isValid(split2, split1, year);
      if(validDate) {
        if(nearestYear > year) {
          splitType = 1;
          nearestYear = year;
        }
      }
      
      //second way of splitting 2014 = 1,4
      split1 = (year % 100) / 10;
      split2 = year % 10;
      split1 = ((split1 % 10) * 10 ) + (split1/10);
      split2 = ((split2 % 10) * 10 ) + (split2/10);
      //System.out.println("Split 1 is " + split1);
      //System.out.println("Split 2 is " + split2);
      validDate = isValid(split2, split1, year);
      if(validDate) {
        if(nearestYear > year) {
          splitType = 2;
          nearestYear = year;
        }
      }
      
      //third way of splitting 2014 = 01,4
      split1 = (year % 1000) / 10;
      split2 = year % 10;
      split1 = ((split1 % 10) * 10 ) + (split1/10);
      split2 = ((split2 % 10) * 10 ) + (split2/10);
      //System.out.println("Split 1 is " + split1);
      //System.out.println("Split 2 is " + split2);
      validDate = isValid(split2, split1, year);
      if(validDate) {
        if(nearestYear > year) {
          splitType = 3;
          nearestYear = year;
        }
      }
      
      //fourth way of splitting 2014 = 0,14
      split1 = (year % 1000) / 100;
      split2 = year % 100;
      split1 = ((split1 % 10) * 10 ) + (split1/10);
      split2 = ((split2 % 10) * 10 ) + (split2/10);
      //System.out.println("Split 1 is " + split1);
      //System.out.println("Split 2 is " + split2);
      validDate = isValid(split2, split1, year);
      if(validDate) {
        if(nearestYear > year) {
          splitType = 4;
          nearestYear = year;
        }
      }
      
      if(nearestYear < Integer.MAX_VALUE) {
        System.out.println("Split is " + splitType);
        return nearestYear;
      }
      year++;
    }
  }
  
  public boolean isValid(int month, int day, int year) {
    int[] numberOfDays = {31,28,31,30,31,30,31,31,30,31,30,31};
    if(year%4 == 0) {
      numberOfDays[1] = 29;
    }
    if(day >31 || month > 11 || numberOfDays[month] < day) {
      return false;
    }
    return true;
    }
    
}
