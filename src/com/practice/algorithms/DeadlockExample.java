package com.practice.algorithms;

public class DeadlockExample {
  double balance;
  int id;
  
  DeadlockExample(int id, double balance) {
    this.id = id;
    this.balance = balance;
  }
  
  void withdraw(double amount) {
    try {
      Thread.sleep(10l);
    }
    catch(InterruptedException e) {
      
    }
    balance -= amount;
  }
  
  void deposit(double amount) {
    try {
      Thread.sleep(10l);
    }
    catch(InterruptedException e) {
      
    }
    balance += amount;
  }
  
  static void transfer(DeadlockExample from, DeadlockExample to, double amount) {
    synchronized(from) {
      from.withdraw(amount);
      synchronized(to) {
        to.deposit(amount);
      }
    }
    System.out.println("After transfer");

  }
  
  public static void main(String args[]) {
    final DeadlockExample fooAccount = new DeadlockExample(1, 100d);
    final DeadlockExample barAccount = new DeadlockExample(2, 100d);
    
    
    new Thread() {
      public void run() {
        DeadlockExample.transfer(fooAccount, barAccount, 10d);
      }
  }.start();
   
  new Thread() {
      public void run() {
        DeadlockExample.transfer(barAccount, fooAccount, 10d);
      }
  }.start();
  }
}
