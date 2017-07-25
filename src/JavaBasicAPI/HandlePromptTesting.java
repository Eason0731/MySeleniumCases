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


public class HandlePromptTesting {
	public WebDriver driver;
	//10.37
  @Test
  public void HandlePromptTest(){
	  File myHtml = new File ("html/10.37.html");
	  String myHtmlFile = myHtml.getAbsolutePath(); //getAbsolutePath()返回抽象路径名的绝对路径名字符串
	  driver.get("file://" +myHtmlFile);
	  
	  WebElement button1 = driver.findElement(By.name("button"));
	  
	  button1.click();
	  
	  try
	  {
		  Alert prompt = driver.switchTo().alert();
		  Assert.assertEquals(prompt.getText(), "这是一个prompt的弹出框"); //判断prompt弹窗的名字是不是 “这是一个prompt的弹出框”
		  
		 
		  prompt.sendKeys("Fernando Alonso is the World Champion"); //在prompt弹窗中输入文字
		  
		  //prompt.accept(); //点prompt弹窗的“OK”
		  
		  prompt.dismiss(); //点prompt弹窗的“取消”
		  
	  }
	  
	  catch( NoAlertPresentException e)
	  {
		  Assert.fail("找不到Prompt弹窗框");
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
