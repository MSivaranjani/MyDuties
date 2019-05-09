package Demo;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.*;



public class MyDutiesDemo {
	public static AppiumDriver driver;
	@Test
	public void Demo() throws InterruptedException, IOException
	{
	
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "iOS");
		caps.setCapability("platformVersion", "12.1");
		caps.setCapability("deviceName", "iPhone 6s");
		caps.setCapability("app","/Users/sivaranjani/Downloads/MyDutiess.app");
		caps.setCapability("automationName","XCUITest");
		driver= new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		
	
	 //driver.findElementByXPath("//XCUIElementTypeTextField[@name='User Name Field']").clear();
	  driver.findElementByXPath("//XCUIElementTypeTextField[@name='User Name Field']").sendKeys("mounika.nune@finnair.com");
	  driver.findElementByXPath("//XCUIElementTypeButton[@name='Sign In']").click();
	  Thread.sleep(10000);
	  driver.findElementByXPath("//XCUIElementTypeSecureTextField").sendKeys("Linemain13");
	  driver.findElementByXPath("//XCUIElementTypeButton[@name='Sign in']").click();
	  Thread.sleep(9000);
	  try{
	  if(driver.findElementByXPath("(//XCUIElementTypeButton[@name='Dashboard'])[1]").isDisplayed())
	  {
		  System.out.println("Displayed");
	  }
	  }
	catch(Exception e)
	  {
		File src=driver.getScreenshotAs(OutputType.FILE);
		//File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		 String Destination = "/Users/sivaranjani/Downloads/check"+".jpeg";
		 
		 FileUtils.copyFile(src, new File(Destination));
		       
		 MailConfiguration.send("sivaranjanidx@gmail.com","Ranjani@91","sayom4u@gmail.com","Login failed",e.getMessage(),Destination);
		   
	  }
	}
  
}
