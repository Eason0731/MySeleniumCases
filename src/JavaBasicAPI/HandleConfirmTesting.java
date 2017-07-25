package JavaAPI;

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

public class HandleConfirmTesting {
	public WebDriver driver;
  @Test
  //10.36
  public void HandleConfirmTest() throws InterruptedException {
	  File myHtml = new File ("html/10.36.html");
	  String myHtmlFile = myHtml.getAbsolutePath(); //getAbsolutePath()返回抽象路径名的绝对路径名字符串
	  driver.get("file://" +myHtmlFile);
	  
	  WebElement button1 = driver.findElement(By.id("button"));
	  button1.click();
	  
	  try
	  {
		  Alert confirm = driver.switchTo().alert();
		  Assert.assertEquals(confirm.getText(), "这是一个confirm的弹出框"); //判断Confirm弹窗的名字是不是 “这是一个confirm的弹出框”
		  Thread.sleep(4000);
		  confirm.accept(); //点confirm弹窗的“OK”
		  
		  //confirm.dismiss(); //点confirm弹窗的“取消”
		  
	  }
	  
	  catch( NoAlertPresentException e)
	  {
		  Assert.fail("找不到Confirm弹窗");
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
