package JavaAPI;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class JavaAPITesting {
	public WebDriver driver;
	//10.1 10.2 10.3 10.6
	
  @Test
  public void OpenWebPage() throws InterruptedException {
	  String url1="http://www.baidu.com";
	  String url2="http://www.sogou.com";
	  
	  driver.navigate().to(url1); //navigate=go to website
	  Thread.sleep(3000);
	  System.out.println(driver.getTitle()); //getCurrentTitle
	  
	  driver.navigate().to(url2);
	  Thread.sleep(3000);
	  System.out.println(driver.getTitle());
	  
	  driver.navigate().back(); //go back to Baidu 
	  System.out.println(driver.getTitle());
	  
	  driver.navigate().forward(); //go forword to Sogou
	  System.out.println(driver.getTitle());
	  
	  driver.navigate().refresh(); //refresh current page
	  System.out.println(driver.getTitle());
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
