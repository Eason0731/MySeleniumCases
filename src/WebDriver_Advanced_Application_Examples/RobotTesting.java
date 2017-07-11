package WebDriver_Advanced_Application_Examples;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class RobotTesting {
	public WebDriver driver;
	JavascriptExecutor jse;
  @Test
  //11.10
  public void RobotTest() {
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	 driver = GetBrowserDriver.GetChromeDriver();
	 String URL = "http://www.sogou.com";
	 driver.navigate().to(URL);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
