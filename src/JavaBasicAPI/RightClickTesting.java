package JavaBasicAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class RightClickTesting {
	public WebDriver driver;
	
	//10.24
  @Test
  public void RightClickTest() throws InterruptedException {
	  driver.get("http://www.baidu.com");
	  Actions action = new Actions(driver);
	  
	  action.contextClick(driver.findElement(By.id("kw"))).perform();
	  Thread.sleep(5000);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = GetBrowserDriver.GetChromeDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }


}
