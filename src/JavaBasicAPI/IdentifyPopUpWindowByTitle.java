package JavaBasicAPI;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;



public class IdentifyPopUpWindowByTitle {
	public WebDriver driver;
	//10.33
  @Test
  public void IdentifyPopUpWindowByTitleTest() throws InterruptedException {
	  File myHtml = new File ("html/10.33.html");
	  String myHtmlFile = myHtml.getAbsolutePath(); //getAbsolutePath()返回抽象路径名的绝对路径名字符串
	  driver.get("file://" +myHtmlFile);
	  String parentWindowHandle = driver.getWindowHandle();
	  //现将当前浏览器窗口的句柄存储到parentWindowHandle的变量中
	  WebElement link1 = driver.findElement(By.xpath("//a"));
	  
	  link1.click();
	  
	  Set<String> allWindowsHandles = driver.getWindowHandles(); 
	  //获取当前所有打开窗口的句柄，并把它们存储到一个set容器中
	  
	  if(!allWindowsHandles.isEmpty()) //判断set容器是否为空
	  {
		  for(String windowHandle:allWindowsHandles) //如果容器对象不为空，再遍历容器 allWindowsHandle 中所有浏览器的句柄
		  {
			  try{
			  
		     if( driver.switchTo().window(windowHandle).getTitle().equals("百度一下，你就知道"))
				  //调用driver.switchTo().window(windowHandle).getTitle()方法 获取getTitle属性
				  //并判断是否是"百度一下，你就知道" 
			  {
				driver.findElement(By.id("kw")).sendKeys("获取到了百度首页");
				Thread.sleep(5000);
			  }
				  
		  }
			  catch (NoSuchWindowException e)
			  {
				  e.printStackTrace();
			  }
		  }
	  }
	  
	  driver.switchTo().window(parentWindowHandle);	  //返回之前页面
	  Thread.sleep(5000);
	  Assert.assertEquals(driver.getTitle(), "10.33");
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
