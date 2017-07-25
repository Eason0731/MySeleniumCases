package JavaBasicAPI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;



public class ImpllictTesting {
	//10.29 隐式等待
	public WebDriver driver;
  @Test
  public void ImpllictTest() throws InterruptedException {
	  driver.get("http://www.baidu.com");
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //用implicitlyWait 方法设定查找页面元素等待时间，调用findElement方法时没有立刻
	  //找到定位元素会等待设定的等待时长，如果还没有找到则抛出NoSuchElementException
	  
	  try
	  {
		WebElement SearchBox = driver.findElement(By.id("su"));
		
		WebElement SearchButton = driver.findElement(By.id("kw"));
		
		SearchBox.sendKeys("找到搜索框了");
		
		SearchBox.click();
		
		Thread.sleep(3000);
		
	  }
	  catch (NoSuchElementException e)
	  {
		  Assert.fail("没有找到搜索框");
		  
		  e.printStackTrace();
		  
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
