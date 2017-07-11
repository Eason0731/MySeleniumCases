package WebDriver_Advanced_Application_Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class Use_JavaScriptExecutor_Click_Testing {
	public WebDriver driver;
  @Test
  //11.1
  public void Use_JavaScriptExecutor_Click_Test() throws Exception {
	  
	  Thread.sleep(5000);
	  WebElement SearchButton = driver.findElement(By.id("stb"));
	  
	  WebElement SearchTextBox = driver.findElement(By.id("query"));
	  	  
	  SearchTextBox.click();
	  SearchTextBox.sendKeys("Click it!");
	  Thread.sleep(5000);
	 
	  JavaScriptClick(SearchButton);
  }
  
  public void JavaScriptClick (WebElement yuansu)
  {
	  try
	  {
		  if (yuansu.isDisplayed() && yuansu.isEnabled())
		  {
			  System.out.println("使用JavaScript进行页面元素的单击");
			  ((JavascriptExecutor) driver).executeScript("arguments[0].click()", yuansu);
			  
			  //执行JavascriptExecutor语句arguments[0].click()
			  Thread.sleep(5000);
			
			  Assert.assertEquals(driver.getTitle(), "Click it! - 搜狗搜索");
		  }
		  
		  else 
		  {
			  System.out.println("无法对JavaScript进行页面元素的单击");
		  }
		  
	  }
	  
	  catch (StaleElementReferenceException e)
	  {
		  System.out.println("页面元素没有附加在网页中" + e.getStackTrace());
	  }
	  
	  catch (NoSuchElementException e)
	  {
		  System.out.println("在页面中没有找到要操作的元素" + e.getStackTrace());
	  }
	  
	  catch (Exception e)
	  {
		  System.out.println("无法完成动作" + e.getStackTrace());
	  }
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	 
	  driver = GetBrowserDriver.GetChromeDriver();
	 
	  String url ="http://www.sogou.com";
	  
	  //driver.get(url);
	  driver.navigate().to(url);
	 //This is chromedriver
	  
	  /*System.setProperty("webdriver.ie.driver", "D://Selenium//IEDriverServer.exe");
	 driver = new InternetExplorerDriver();
	 */
	//This is IEdriver
	
	 /*System.setProperty("webdriver.firefox.bin","C://Program Files (x86)//Mozilla Firefox//firefox.exe");
	 driver = new FirefoxDriver(); */
	//This is FireFoxdriver
  }

  @AfterMethod
  public void afterMethod() {
	 driver.quit();
	 
  }

}
