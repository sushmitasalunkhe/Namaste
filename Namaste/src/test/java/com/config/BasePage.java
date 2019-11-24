package com.config;

import static org.testng.AssertJUnit.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
//import io.appium.java_client.pagefactory.TimeOutDuration;
import io.appium.java_client.pagefactory.TimeOutDuration;


public class BasePage extends BaseClass{
	
	
	//public AndroidDriver<AndroidElement> driver; 

    private final int WAIT_TIME = 10;    
   
   
    private TimeOutDuration timeOutDuration;
    public BasePage(AndroidDriver<AndroidElement> driver) {
        BaseClass.driver = driver;
        timeOutDuration = new TimeOutDuration(WAIT_TIME, TimeUnit.SECONDS);
        PageFactory.initElements(new AppiumFieldDecorator(driver,timeOutDuration), this);//,new TimeOutDuration(15,TimeUnit.SECONDS)
        waitAuto(WAIT_TIME);
    }
	 
    
    public int getWaitTime() {
		return WAIT_TIME;
	}

	public void waitAuto(int time) {
	        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	        
	    }
	 public void sendKeys(AndroidElement ae, String str) {
	       ae.sendKeys(str);
	        	

	    }
	 public boolean isElementExsit(AndroidElement ele){ 
			waitAuto(0);
	       
	            
	                if(!ele.isDisplayed()){
	                	this.threadsleep(1000);
	                	return true;
	                }
	                else {
	                	
	                System.out.println("OTP did not get");
	                return false;
	                }
	            } 
	        
	        
			
		
	 public void threadsleep(int timeout){
			try {
				Thread.sleep(timeout);
	    	   } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	    	   }
		}
}
