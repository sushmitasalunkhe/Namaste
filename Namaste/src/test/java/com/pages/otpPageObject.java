package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.config.BaseClass;
import com.config.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class otpPageObject extends BaseClass  {
	
	@AndroidFindBy(id="com.google.android.gms:id/cancel")
	private AndroidElement numberPopUp;
	@AndroidFindBy(id="com.android.packageinstaller:id/permission_deny_button")
	private AndroidElement PopUp1;
	@AndroidFindBy(id="com.android.packageinstaller:id/permission_deny_button")
	private AndroidElement PopUp2;
	@AndroidFindBy(id="com.nc.neobanking:id/phone_number")
	private AndroidElement NumberBox;
	
	public otpPageObject(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
	}
	
	

	public void Login(String Phone_number) throws InterruptedException {
		
		/*
		 * numberPopUp.click(); PopUp1.click(); PopUp2.click(); NumberBox.clear();
		 * NumberBox.sendKeys(Phone_number);
		 */
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.findElement(By.id("com.google.android.gms:id/cancel")).click();
		  driver.findElement(By.id(
		  "com.android.packageinstaller:id/permission_deny_button")).click();
		  driver.findElement(By.id(
		  "com.android.packageinstaller:id/permission_deny_button")).click();
		  
		  
		  driver.findElement(By.id("com.nc.neobanking:id/phone_number")).sendKeys(
		  Phone_number);
		 
		driver.findElement(By.id("com.nc.neobanking:id/get_otp")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		boolean otpAllowBtn=driver.findElement(By.id("com.google.android.gms:id/positive_button")).isDisplayed();
		if(otpAllowBtn==true) {
		driver.findElement(By.id("com.google.android.gms:id/positive_button")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		String ActWelcomeText=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.TextView" )).getText();
		String ExpWelcomeText="Welcome to Namaste Biz";
		Assert.assertEquals(ActWelcomeText, ExpWelcomeText);
		driver.findElement(By.id("com.nc.neobanking:id/btnNext")).click();
		driver.findElement(By.id("com.nc.neobanking:id/btnNext")).click();
		driver.findElement(By.id("com.nc.neobanking:id/btnNext")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		}
		else
		{
			System.out.println("otp not recieved");
		}
		
	}
	
}
