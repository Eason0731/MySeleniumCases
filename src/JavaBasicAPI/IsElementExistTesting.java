package JavaBasicAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;

public class IsElementExistTesting {
	public WebDriver driver;
	//10.32
	
	private boolean IsElementExist(By by)
	{
		try
		{
			driver.findElement(by);
			return true;
			
		}
		
		catch (NoSuchElementException e)
		{
			Assert.fail("搜索文本框未找到");
			e.printStackTrace();
		}
		return false;
		
	}
	
  @Test
  public void IsElementExistTest() throws InterruptedException {
	  driver.get("http://www.baidu.com");
	  
	  if (IsElementExist(By.id("kw"))) //利用IsElementExist函数去判断 kw 元素是否存在
	  {
		  WebElement SearchBox = driver.findElement(By.id("kw"));
		  
		  if ( SearchBox.isDisplayed() == true) //判断搜索文本框是否处于激活状态
		  {
			  SearchBox.sendKeys("搜索文本框被找到");
			  Thread.sleep(5000);
		  }
	  }
	  
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
