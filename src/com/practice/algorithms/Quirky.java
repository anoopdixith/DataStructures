package com.practice.algorithms;

import java.io.File;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Quirky {
  private static SecureRandom random = new SecureRandom();

  public static void main(String args[]) {
    FirefoxProfile profile = new FirefoxProfile();
    WebDriver driver = new FirefoxDriver(new FirefoxBinary(new File("/Applications/firefox.exe")), profile);

    // And now use this to visit Google
    driver.get("https://www.quirky.com/signup");
    String lastname = nextSessionId();
    String firstname = nextSessionId();
    String emailid = nextSessionId() + "yahoo.co.in";
    String password = nextSessionId();
    
    WebElement fn = driver.findElement(By.name("user[profile_attributes][first]"));
    fn.sendKeys(firstname);
    WebElement ln = driver.findElement(By.name("user[profile_attributes][last]"));
    ln.sendKeys(lastname);
    WebElement em = driver.findElement(By.name("user[email]"));
    em.sendKeys(emailid);
    WebElement pw = driver.findElement(By.name("user[password]"));
    pw.sendKeys(password);
    
    WebElement click1 = driver.findElement(By.linkText("Sign up"));
    //click1.submit();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    
    
    
  }
  

  public static String nextSessionId() {
    return new BigInteger(130, random).toString(32);
  }
}
