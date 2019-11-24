package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.config.BaseClass;
import com.pages.otpPageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Login extends BaseClass{
	
	
	
		otpPageObject otpPage=new otpPageObject(driver);
	@Test(description= "positive_case", priority=0)
	public void Login_in1() throws InterruptedException {
		
		otpPage.Login("9867530069");
	
		}
		

	
	  @Test(description= "negative", priority=1) 
	  public void Login_in2() throws
	  InterruptedException {
	
	  otpPage.Login("7786777888");
	  
	  }
	  
	/*
	 * @Test(description= "negative", priority=1) public void Login_in3() throws
	 * InterruptedException {
	 * 
	 * otpPage.Login("0000000000");
	 * 
	 * }
	 */
	 
	  
}
		
		


	
	


