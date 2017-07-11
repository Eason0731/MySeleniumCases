package WebDriver_Advanced_Application_Examples;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class SetAttributeTesting {
	public WebDriver driver;
	//11.3
  @Test
  public void SetAttributeTest() throws Exception {
	  WebElement TextBox = driver.findElement(By.id("text"));
	  Thread.sleep(5000);
	  SetAttribute(driver,TextBox,"size","30"); //调用SetAttribute方法将文本框的大小改为30
	  Thread.sleep(5000);
	  SetAttribute(driver,TextBox,"value","Alonso");//调用SetAttribute方法将文本框的值改为Alonso
	  Thread.sleep(5000);
	  SetAttribute(driver,TextBox,"value","");//调用SetAttribute方法将文本框的值改为null
	  Thread.sleep(5000);
	  RemoveAttribute(driver,TextBox,"size"); //调用RemoveAttribute方法移除size属性
	  Thread.sleep(5000);
  }
  
  private void SetAttribute(WebDriver qudong,WebElement Element,String attributeName,String value)
  {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	
	  js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])",Element,attributeName,value);
	  //调用Javascript代码修改页面元素的值,arguments[0]-[2]对应Element,attributeName,value
  }

  private void RemoveAttribute(WebDriver driver,WebElement Element,String attributeName)
  {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].removeAttribute(arguments[1],arguments[2])", Element,attributeName);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = GetBrowserDriver.GetChromeDriver();
	  File myHtml = new File ("html/11.3.html");
	  String myHtmlFile = myHtml.getAbsolutePath(); //getAbsolutePath()返回抽象路径名的绝对路径名字符串
	  driver.navigate().to("file://" +myHtmlFile);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
