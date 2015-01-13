package com.practice.algorithms;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TakeScreenshot {
  public static void main(String args[]) {
    try {
      Robot robot = new Robot();
      Rectangle screenRect = new Rectangle(1000,1000);
      BufferedImage bi = robot.createScreenCapture(screenRect);
      ImageIO.write(bi, "png", new File("/Users/anoop/Desktop/screenshot1"));
    } catch (AWTException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      String s = new String("Asd");
      s.intern();
    }
  }
}
