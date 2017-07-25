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

public class HandleiFrameTesting {
	public WebDriver driver;
  @Test
  //10.40
  public void HandleiFrameTest() {
	  File myHtml = new File ("html/10.40/frameset.html");
	  String myHtmlFile = myHtml.getAbsolutePath(); //getAbsolutePath()返回抽象路径名的绝对路径名字符串
	  driver.get("file://" +myHtmlFile);
	  
	  driver.switchTo().frame("leftframe"); //先Switch到左边frame
	  
	  //注意：By.tagname 也是寻找元素的方式，多用于寻找第一个标签，如html,body,frame,iframe可能需要用到
	  //By.tagname来寻找到
	  
	  WebElement iframePage = driver.findElement(By.tagName("iframe")); //将leftframe里的iframe找到
	  
	  driver.switchTo().frame(iframePage); //Switch到左边frame里的iframe
	  
	  WebElement p =driver.findElement(By.xpath("//p"));	  
	  Assert.assertEquals(p.getText(),"This is iframe page");
	  
	  driver.switchTo().defaultContent(); //switch回主frame页面
	  
	  driver.switchTo().frame("rightframe"); //Swich到右边frame
	  
	  
	  
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
