package tests;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	static AppiumDriver<MobileElement> driver;
@BeforeTest

	public void setup(){
		try {
	DesiredCapabilities caps=new DesiredCapabilities();
	caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
	caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0.0");
	caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 7");
	caps.setCapability(MobileCapabilityType.UDID, "be16ca76");
	caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
	caps.setCapability("appPackage","com.nc.neobanking");
	caps.setCapability("appActivity", "com.nc.neobanking.module.user.activity.OtpActivity");
	//caps.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome"); 
	
	caps.setCapability("chromedriverExecutable", "/home/ankur-loktra/Downloads/node_modules/appium/node_modules/appium-chromedriver/chromedriver/linux/chromedriver_64");
	caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	
	
	URL url =new URL(" http://127.0.1.1:4723/wd/hub");
	driver=new AppiumDriver<MobileElement>(url,caps);
	//driver=new AndroidDriver<MobileElement>(url,caps);
	//driver=new IOSDriver<MobileElement>(url,caps);
		}catch(Exception e) {
			System.out.println("cause is: "+e.getCause());
			System.out.println("msg is : "+e.getMessage());
			e.printStackTrace();
		}
}
@Test
public void test() {
	System.out.println("inside");
}
@AfterTest
public void teardown() {
		
}
}
