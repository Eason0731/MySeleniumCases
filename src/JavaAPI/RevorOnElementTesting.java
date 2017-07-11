package JavaAPI;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class RevorOnElementTesting {
	public WebDriver driver;
	//10.25
  @Test
  public void RevorOnElement() {
	  File myHtml = new File ("html/10.25.html");
	  String myHtmlFile = myHtml.getAbsolutePath(); //getAbsolutePath()返回抽象路径名的绝对路径名字符串
	  driver.get("file://" +myHtmlFile);
	  WebElement link1 = driver.findElement(By.id("link1")); //找到id为link1的链接，实例化并赋给变量link1
	  
	  WebElement link2 = driver.findElement(By.id("link2")); //找到id为link2的链接，实例化并赋给变量link2
	  Actions action1 = new Actions(driver); //实例化action动作的操作
	  
	  action1.moveToElement(link1).perform();
	  
	  try
	  {
		  Thread.sleep(5000);
	  }
	  
	  catch( Exception e)
	  {
		  e.printStackTrace();
	  }
	  
	  action1.moveToElement(link2).perform();
	  try
	  {
		  Thread.sleep(5000);
	  }
	  
	  catch(Exception e)
	  {
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
