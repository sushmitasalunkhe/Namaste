package com.config;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	public static AndroidDriver<AndroidElement> driver;
	
	@BeforeTest(alwaysRun = true)

		public void setup(){

			try {
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "be16ca76");
		caps.setCapability(MobileCapabilityType.UDID, "be16ca76");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		caps.setCapability("appPackage","com.nc.neobanking");
		caps.setCapability("appActivity", "com.nc.neobanking.module.user.activity.HomeScreenActivity");
		//caps.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome"); 
		
		caps.setCapability("chromedriverExecutable", "/home/ankur-loktra/Downloads/node_modules/appium/node_modules/appium-chromedriver/chromedriver/linux/chromedriver_64");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		Thread.sleep(5000);
		
		URL url =new URL(" http://127.0.1.1:4723/wd/hub");
		driver= new AndroidDriver(url,caps);
				  
		Thread.sleep(5000);
		

//driver=new AndroidDriver<MobileElement>(url,caps);
		//driver=new IOSDriver<MobileElement>(url,caps);
			}catch(Exception e) {
				System.out.println("cause is: "+e.getCause());
				System.out.println("msg is : "+e.getMessage());
				e.printStackTrace();
			}
	}
	
	@AfterTest(alwaysRun=true)
	public void teardown() throws InterruptedException {
		Thread.sleep(5000);
		
		((AppiumDriver)driver).closeApp();
		((AppiumDriver)driver).resetApp();// Close the app which was provided in the capabilities at session creation   
		
			
	}

}
