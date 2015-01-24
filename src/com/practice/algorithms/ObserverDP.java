package com.practice.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;
import java.util.Observer;

public class ObserverDP {
  public class EventSource extends Observable implements Runnable{
    public void eventSource() {
      System.out.println("This is an event source");
      try {
        final InputStreamReader isr = new InputStreamReader(System.in);
        final BufferedReader br = new BufferedReader(isr);
        while (true) {
            String response = br.readLine();
            setChanged();
            notifyObservers(response);
        }
    }
    catch (IOException e) {
        e.printStackTrace();
    }
    }

    @Override
    public void run() {
      try {
        final InputStreamReader isr = new InputStreamReader(System.in);
        final BufferedReader br = new BufferedReader(isr);
        while (true) {
            String response = br.readLine();
            setChanged();
            notifyObservers(response);
        }
    }
    catch (IOException e) {
        e.printStackTrace();
    }
    }
  }
  
  public class ResponseHandler implements Observer {

    @Override
    public void update(Observable o, Object arg) {
      if (arg instanceof String) {
        String resp = (String) arg;
        System.out.println("\nReceived response: " + resp);
      }
    }
    
  }
  
  public static void main(String args[]) {
    System.out.println("Enter Text >");
    ObserverDP observerDp = new ObserverDP();
     EventSource eventSource = observerDp.new EventSource();
     ResponseHandler resourseHandler = observerDp.new ResponseHandler();
     eventSource.addObserver(resourseHandler);
     //Thread event = new Thread(eventSource);
     //event.start();
     eventSource.eventSource();
  }
}
