package MyLabForTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;

public class MultipleBrowserTesting {
	public WebDriver driver;
	
	public static void TestItem(WebDriver driver,String content) throws Exception {
		String WebSite = "https://www.sogou.com/";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.navigate().to(WebSite);	
		Assert.assertEquals(driver.getTitle(), "搜狗搜索引擎 - 上网从搜狗开始");
		
		WebElement SearchBox = driver.findElement(By.id("query"));
		WebElement SearchButton = driver.findElement(By.id("stb"));
		SearchBox.sendKeys(content);
		Thread.sleep(5000);
		js.executeScript("arguments[0].click()", SearchButton); 
		//Safari对Webdriver的click并不起作用，但在IE，chrome和Firefox有作用，所以用Javascript语句来执行
		//此语句等同于SearchButton.click();
		Thread.sleep(5000);
		
		Assert.assertEquals(driver.getTitle(), content+" - 搜狗搜索");
		//js.executeScript("return document.title") 等同于 driver.getTitle()
		Thread.sleep(2000);
	}


  @Test (priority = 0)
  public void IEBrowser() throws Exception {
	  driver = GetBrowserDriver.GetInternetExplorerDriver();
	  TestItem(driver,"Internet Explorer");
  }

	
  @Test (priority = 1)
  public void ChromeBrowser() throws Exception {
	  driver = GetBrowserDriver.GetChromeDriver();
	  TestItem(driver,"Chrome");
  }
  
  @Test (priority = 2)
  public void FireFoxBrowser() throws Exception {
	  driver = GetBrowserDriver.GetFireFoxDriver();
	  TestItem(driver,"FireFox");
  }
  
  @Test (priority = 3)
  public void SafariBrowser() throws Exception {
	  driver = GetBrowserDriver.GetSafariDriver();
	  TestItem(driver,"Safari");
  }

  @Test (priority = 4)
  public void EdgeBrowser() throws Exception {
	  driver = GetBrowserDriver.GetEdgeDriver();
	  TestItem(driver,"Edge");
  }
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
