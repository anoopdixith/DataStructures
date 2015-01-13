package com.practice.algorithms;

public class Egain2 {
  private final static int CAPACITY = 5;
  private static int[] queue = new int[CAPACITY];
  int top = -1;
  int rear = -1;
  private final Object lock = new Object();
  
  //Queue is made static so multiple threads can access them
  //Enqueue and Dequeue synchrozied to make them thread safe
  public void enqueue(int item) {
    synchronized (lock) {
    if(top == CAPACITY - 1) {
      System.out.println("Overflow");
    }
    else {
      top++;  
      queue[top] = item;  
    }
    display();  
   }
   lock.notify(); 
  }
  
  public void dequeue() {
    synchronized (lock) {
    if (top >= rear) {  
      rear++;   
      display();  
     } else {  
      System.out.println("No element to dequeue");  
     }  
    }
    lock.notify();
  }

  private void display() {
    if (top >= rear) {  
      System.out.println("Elements in Queue : ");  
      for (int i = rear; i <= top; i++) {  
       System.out.println(queue[i]);  
      }  
     }  
  }
  
}
