package JavaBasicAPI;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class IsElementTextPresentTesting {
	public WebDriver driver;
	
  @Test
  //10.20
  public void isElementTextPresent() throws InterruptedException {
	  File myHtml = new File ("html/10.20.html");
	  String myHtmlFile = myHtml.getAbsolutePath(); //getAbsolutePath()返回抽象路径名的绝对路径名字符串
	  driver.get("file://" +myHtmlFile);
	  WebElement text = driver.findElement(By.xpath("//p[1]")); //利用xpath找到第一个p元素
	  
	  String contentText = text.getText();
	  
	  Assert.assertEquals("Fernando is world champion!", contentText); //判断两句话是否一致
	  Thread.sleep(5000);
	  Assert.assertTrue(contentText.contains("Fernando")); //是否包含Fernando
	  Thread.sleep(5000);
	  Assert.assertTrue(contentText.startsWith("Fernando")); //判断是不是以Fernando开头的
	  Thread.sleep(5000);
	  Assert.assertTrue(contentText.endsWith("champion!")); //判断是不是以champion!结尾的
	  
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
