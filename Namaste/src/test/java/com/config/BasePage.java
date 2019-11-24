package com.config;

import static org.testng.AssertJUnit.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
//import io.appium.java_client.pagefactory.TimeOutDuration;


public class BasePage{
	
	
	public AndroidDriver<AndroidElement> driver; 

    private final int WAIT_TIME = 30;    
   
   
  
    public BasePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        Timeouts timeOutDuration = driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);//,new TimeOutDuration(15,TimeUnit.SECONDS)
        waitAuto(WAIT_TIME);
    }
	 
	
	public void waitAuto(int time) {
	        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	        
	    }
	 public void sendKeys(AndroidElement ae, String str) {
	       ae.sendKeys(str);
	        	

	    }
}
