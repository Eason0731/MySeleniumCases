package JavaAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;

//10.9 and 10.12
public class ClearInputBoxandDoubleClickTesting {
	public WebDriver driver;
  @Test
  public void clearInputBoxandDoubleClick() throws InterruptedException {
	  driver.get("http://www.baidu.com");
	  WebElement SearchBox = driver.findElement(By.xpath("//*[@id='kw']"));
	  WebElement SearchButton = driver.findElement(By.xpath("//*[@id='su']"));
	  SearchBox.sendKeys("Hello Selenium"); //文本框内输入值
	  Thread.sleep(3000);
	  SearchBox.clear(); //清除文字
	  Thread.sleep(3000);
	  //声明Actions对象
	  Actions db = new Actions(driver);  
	  db.doubleClick(SearchButton).build().perform();
	  Thread.sleep(3000);
	  //双击
	  
	  
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
