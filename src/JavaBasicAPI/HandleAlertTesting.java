package JavaBasicAPI;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;

public class HandleAlertTesting {
	public WebDriver driver;
	//10.35
  @Test
  public void HandleAlertTest() throws InterruptedException {
	  File myHtml = new File ("html/10.35.html");
	  String myHtmlFile = myHtml.getAbsolutePath(); //getAbsolutePath()返回抽象路径名的绝对路径名字符串
	  driver.get("file://" +myHtmlFile);
	  
	  WebElement Button1 = driver.findElement(By.xpath("//input"));
	  
	  Button1.click();
	  Thread.sleep(4000);
	  
	  try 
	  {
		  Alert alert = driver.switchTo().alert(); //使用driver.switchTo().alert()获取Alert（弹窗）对象
		  Assert.assertEquals(alert.getText() , "这是一个alert的弹出框"); //判断弹窗的文字是否与预期的一致
		  Thread.sleep(4000);
		  alert.accept(); //将弹窗的窗口点击OK
	  }
	  
	  catch( NoAlertPresentException e)
	  {
		  Assert.fail("未找到Alert的弹窗啊");
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
