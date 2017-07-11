package WebDriver_Advanced_Application_Examples;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class UseLog4jTesting {
	public WebDriver driver;
	String WebURL = "http://www.baidu.com";
	//public Log Rizhi;
  @Test
  //11.16
  public void UseLog4jTest() throws Exception {
	  Log.startTestcase("开始进行搜索的测试"); //调用Log类的startTestcase方法，这里可以自定义内容
	  driver.navigate().to(WebURL);
	  Log.Info("打开百度首页"); //调用Log类的Info方法，这里可以自定义内容
	  Thread.sleep(5000);
	  WebElement SearchBox = driver.findElement(By.id("kw"));
	  WebElement SearchButton = driver.findElement(By.id("su"));
	  SearchBox.sendKeys("Selenium Webdriver");
	  Log.Info("输入关键字：Selenium Webdriver");
	  SearchButton.click();
	  Thread.sleep(5000);
	  Log.Info("点击搜索按钮");
	  Assert.assertEquals(driver.getTitle(), "Selenium Webdriver_百度搜索");
	  Log.Info("验证是否符合预期的结果");
	  Thread.sleep(5000);
	  Log.endTestcase("结束搜索测试"); //调用Log类的endTestcase方法，这里可以自定义内容
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = GetBrowserDriver.GetChromeDriver();
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
  @BeforeClass
  public void beforeClass(){
	  DOMConfigurator.configure("log4j.xml");
  }

}
