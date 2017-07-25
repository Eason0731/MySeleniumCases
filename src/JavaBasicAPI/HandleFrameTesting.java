package JavaAPI;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;

public class HandleFrameTesting {
	public WebDriver driver;
	//10.38
  @Test
  public void HandleFrameTest() throws InterruptedException {
	  File myHtml = new File ("html/10.38/frameset.html");
	  String myHtmlFile = myHtml.getAbsolutePath(); //getAbsolutePath()返回抽象路径名的绝对路径名字符串
	  driver.get("file://" +myHtmlFile);
	  
	  driver.switchTo().frame("leftframe"); //Switch到左边的Frame
	  WebElement leftText = driver.findElement(By.xpath("//p")); //用xpath找到p
	  Assert.assertEquals(leftText.getText(), "This is Left side Frame"); //判断左边Frame中获取P标签的文字是否与实际的匹配
	  driver.switchTo().defaultContent(); //Switch回到默认的页面，否则无法进入其他的Frame页面
	  Thread.sleep(5000);
	  
	  driver.switchTo().frame("middleframe"); //Switch到中间的Frame
	  WebElement MiddleText = driver.findElement(By.xpath("//p")); //用xpath找到p
	  Assert.assertEquals(MiddleText.getText(), "This is Middle side Frame"); //判断中间Frame中获取P标签的文字是否与实际的匹配
	  driver.switchTo().defaultContent(); //Switch回到默认的页面，否则无法进入其他的Frame页面
	  Thread.sleep(5000);
	  
	  driver.switchTo().frame("rightframe"); //Switch到右边的Frame
	  WebElement RightText = driver.findElement(By.xpath("//p")); //用xpath找到p
	  Assert.assertEquals(RightText.getText(), "This is Right side Frame"); //判断右边Frame中获取P标签的文字是否与实际的匹配
	  driver.switchTo().defaultContent(); //Switch回到默认的页面，否则无法进入其他的Frame页面
	  Thread.sleep(5000);
	  
	  //用索引的方式进入Frame，默认为0
	  driver.switchTo().frame(2);
	  WebElement Text = driver.findElement(By.xpath("//p"));
	  Assert.assertEquals( Text.getText(), "This is Right side Frame");
	  driver.switchTo().defaultContent();
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
