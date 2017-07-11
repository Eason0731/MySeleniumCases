package WebDriver_Advanced_Application_Examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class UIMapTesting {
	public WebDriver driver;
	private ObjectMap objectMap; //引用当前目录下已经创建的ObjectMap类
	String WebURL = "http://mail.sohu.com";
	//11.11
	
	
  @Test
  public void UIMapTest() throws Exception {
	  Thread.sleep(5000);
	 
	  try 
	  {
		  objectMap = new ObjectMap ("D://Selenium//UIMap//objectMap.properties"); 
	  }
	  
	  catch (Exception e)
	  {
		  e.printStackTrace();
		  System.out.println("生成Object对象失败");
	  }
	  
	  WebElement username = driver.findElement(objectMap.getLocator("SohuMai.HomePage.username"));
	  WebElement password = driver.findElement(objectMap.getLocator("SohuMai.HomePage.password"));
	  WebElement submitButton = driver.findElement(objectMap.getLocator("SohuMai.HomePage.submitButton"));
	  
	  username.sendKeys("fosterwu");
	  password.sendKeys("1111");
	  submitButton.click();
	  
	  Thread.sleep(5000);
	  Assert.assertTrue(driver.getPageSource().contains("星标邮件"));
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = GetBrowserDriver.GetChromeDriver();
	  driver.navigate().to(WebURL);
  }
  


  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
